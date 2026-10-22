package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED = 0;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized;
    private static Field sServedViewField;
    private Activity mActivity;

    public ImmLeaksCleaner(Activity r5) {
        this.mActivity = r5;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @MainThread
    private static void initializeReflectiveFields() {
        sReflectedFieldsInitialized = 2;     // Catch: NoSuchFieldException -> L5
        Field r5 = InputMethodManager.class.getDeclaredField("mServedView");     // Catch: NoSuchFieldException -> L5
        sServedViewField = r5;     // Catch: NoSuchFieldException -> L5
        r5.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r10 = InputMethodManager.class.getDeclaredField("mNextServedView");     // Catch: NoSuchFieldException -> L5
        sNextServedViewField = r10;     // Catch: NoSuchFieldException -> L5
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r11 = InputMethodManager.class.getDeclaredField("mH");     // Catch: NoSuchFieldException -> L5
        sHField = r11;     // Catch: NoSuchFieldException -> L5
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        sReflectedFieldsInitialized = 1;     // Catch: NoSuchFieldException -> L5
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r5, @NonNull Lifecycle.Event r10) {
        if (r10 == Lifecycle.Event.ON_DESTROY) goto L6;
        return;
    L6:
        if (sReflectedFieldsInitialized != 0) goto L9;
        initializeReflectiveFields();
    L9:
        if (sReflectedFieldsInitialized != 1) goto L36;
        InputMethodManager r11 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        Object r12 = sHField.get(r11);     // Catch: IllegalAccessException -> L37
        if (r12 != null) goto L14;
        return;
    L14:
        monitor-enter(r12);
        View r13 = (View) sServedViewField.get(r11);     // Catch: Throwable -> L19 ClassCastException -> L30 IllegalAccessException -> L32
        if (r13 != null) goto L22;
        monitor-exit(r12);     // Catch: Throwable -> L19
        return;
    L22:
        if (r13.isAttachedToWindow() == false) goto L39;
        monitor-exit(r12);     // Catch: Throwable -> L19
        return;
    L39:
        sNextServedViewField.set(r11, null);     // Catch: Throwable -> L19 IllegalAccessException -> L28
        monitor-exit(r12);     // Catch: Throwable -> L19
        r11.isActive();
        return;
    L29:
        return;
    L19:
        th = move-exception;
        throw th;
    L31:
        return;
    L33:
        return;
    L45:
        return;
    }
}
