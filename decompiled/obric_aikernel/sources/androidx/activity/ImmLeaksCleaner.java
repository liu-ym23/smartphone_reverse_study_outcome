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

    static {
    }

    ImmLeaksCleaner(Activity r10) {
        this.mActivity = r10;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @MainThread
    private static void initializeReflectiveFields() {
        sReflectedFieldsInitialized = 2;     // Catch: NoSuchFieldException -> L5
        Field r10 = InputMethodManager.class.getDeclaredField("mServedView");     // Catch: NoSuchFieldException -> L5
        sServedViewField = r10;     // Catch: NoSuchFieldException -> L5
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r11 = InputMethodManager.class.getDeclaredField("mNextServedView");     // Catch: NoSuchFieldException -> L5
        sNextServedViewField = r11;     // Catch: NoSuchFieldException -> L5
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r12 = InputMethodManager.class.getDeclaredField("mH");     // Catch: NoSuchFieldException -> L5
        sHField = r12;     // Catch: NoSuchFieldException -> L5
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        sReflectedFieldsInitialized = 1;     // Catch: NoSuchFieldException -> L5
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r10, @NonNull Lifecycle.Event r11) {
        if (r11 == Lifecycle.Event.ON_DESTROY) goto L6;
        return;
    L6:
        if (sReflectedFieldsInitialized != 0) goto L9;
        initializeReflectiveFields();
    L9:
        if (sReflectedFieldsInitialized != 1) goto L36;
        InputMethodManager r12 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        Object r13 = sHField.get(r12);     // Catch: IllegalAccessException -> L37
        if (r13 != null) goto L14;
        return;
    L14:
        monitor-enter(r13);
        View r14 = (View) sServedViewField.get(r12);     // Catch: Throwable -> L28 ClassCastException -> L30 IllegalAccessException -> L32
        if (r14 != null) goto L20;
        monitor-exit(r13);     // Catch: Throwable -> L28
        return;
    L20:
        if (r14.isAttachedToWindow() == false) goto L38;
        monitor-exit(r13);     // Catch: Throwable -> L28
        return;
    L38:
        sNextServedViewField.set(r12, null);     // Catch: IllegalAccessException -> L26 Throwable -> L28
        monitor-exit(r13);     // Catch: Throwable -> L28
        r12.isActive();
        return;
    L27:
        return;
    L28:
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
