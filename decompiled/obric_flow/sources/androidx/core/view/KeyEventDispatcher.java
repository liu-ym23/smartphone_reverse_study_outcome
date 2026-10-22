package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched = false;
    private static Method sActionBarOnMenuKeyMethod = null;
    private static boolean sDialogFieldsFetched = false;
    private static Field sDialogKeyListenerField;

    public interface Component {
        boolean superDispatchKeyEvent(@NonNull KeyEvent r5);
    }

    private KeyEventDispatcher() {
    }

    private static boolean actionBarOnMenuKeyEventPre28(ActionBar r5, KeyEvent r10) {
        if (sActionBarFieldsFetched == false) goto L18;
    L6:
        Method r11 = sActionBarOnMenuKeyMethod;
        if (r11 != null) goto L16;
    L13:
        return false;
    L16:
        Object r12 = r11.invoke(r5, new Object[]{r10});     // Catch: Throwable -> L14
        if (r12 != null) goto L11;
        return false;
    L11:
        return ((Boolean) r12).booleanValue();
    L18:
        sActionBarOnMenuKeyMethod = r5.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});     // Catch: NoSuchMethodException -> L15
    L5:
        sActionBarFieldsFetched = true;
        goto L6
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity r5, KeyEvent r10) {
        r5.onUserInteraction();
        Window r11 = r5.getWindow();
        if (r11.hasFeature(8) == false) goto L11;
        ActionBar r12 = r5.getActionBar();
        if (r10.getKeyCode() != 82) goto L11;
        if (r12 == null) goto L11;
        if (actionBarOnMenuKeyEventPre28(r12, r10) == false) goto L11;
        return true;
    L11:
        if (r11.superDispatchKeyEvent(r10) == false) goto L13;
        return true;
    L13:
        View r13 = r11.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r13, r10) == false) goto L16;
        return true;
    L16:
        if (r13 == null) goto L18;
        KeyEvent.DispatcherState r14 = r13.getKeyDispatcherState();
    L20:
        return r10.dispatch(r5, r14, r5);
    L18:
        r14 = null;
        goto L20
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog r5, KeyEvent r10) {
        DialogInterface.OnKeyListener r11 = getDialogKeyListenerPre28(r5);
        if (r11 != null) goto L5;
    L7:
        Window r12 = r5.getWindow();
        if (r12.superDispatchKeyEvent(r10) == false) goto L10;
        return true;
    L10:
        View r13 = r12.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r13, r10) == false) goto L13;
        return true;
    L13:
        if (r13 == null) goto L15;
        KeyEvent.DispatcherState r14 = r13.getKeyDispatcherState();
    L17:
        return r10.dispatch(r5, r14, r5);
    L15:
        r14 = null;
        goto L17
    L5:
        if (r11.onKey(r5, r10.getKeyCode(), r10) == false) goto L7;
        return true;
    }

    public static boolean dispatchBeforeHierarchy(@NonNull View r5, @NonNull KeyEvent r10) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(r5, r10);
    }

    @SuppressLint({"LambdaLast"})
    public static boolean dispatchKeyEvent(@NonNull Component r5, @Nullable View r10, @Nullable Window.Callback r11, @NonNull KeyEvent r12) {
        if (r5 != null) goto L6;
        return false;
    L6:
        return r5.superDispatchKeyEvent(r12);
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog r5) {
        if (sDialogFieldsFetched == false) goto L17;
    L7:
        Field r10 = sDialogKeyListenerField;
        if (r10 != null) goto L15;
        return null;
    L15:
        return (DialogInterface.OnKeyListener) r10.get(r5);
    L19:
        return null;
    L17:
        Field r11 = Dialog.class.getDeclaredField("mOnKeyListener");     // Catch: NoSuchFieldException -> L13
        sDialogKeyListenerField = r11;     // Catch: NoSuchFieldException -> L13
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L13
    L6:
        sDialogFieldsFetched = true;
        goto L7
    }
}
