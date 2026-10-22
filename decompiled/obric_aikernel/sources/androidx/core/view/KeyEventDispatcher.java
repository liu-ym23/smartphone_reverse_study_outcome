package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
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
        boolean superDispatchKeyEvent(@NonNull KeyEvent r10);
    }

    static {
    }

    private KeyEventDispatcher() {
    }

    private static boolean actionBarOnMenuKeyEventPre28(ActionBar r10, KeyEvent r11) {
        if (sActionBarFieldsFetched == false) goto L16;
    L6:
        Method r12 = sActionBarOnMenuKeyMethod;
        if (r12 != null) goto L18;
    L13:
        return false;
    L18:
        Object r13 = r12.invoke(r10, new Object[]{r11});     // Catch: Throwable -> L14
        if (r13 != null) goto L11;
        return false;
    L11:
        return ((Boolean) r13).booleanValue();
    L16:
        sActionBarOnMenuKeyMethod = r10.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});     // Catch: NoSuchMethodException -> L15
    L5:
        sActionBarFieldsFetched = true;
        goto L6
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity r10, KeyEvent r11) {
        r10.onUserInteraction();
        Window r12 = r10.getWindow();
        if (r12.hasFeature(8) == false) goto L11;
        ActionBar r13 = r10.getActionBar();
        if (r11.getKeyCode() != 82) goto L11;
        if (r13 == null) goto L11;
        if (actionBarOnMenuKeyEventPre28(r13, r11) == false) goto L11;
        return true;
    L11:
        if (r12.superDispatchKeyEvent(r11) == false) goto L13;
        return true;
    L13:
        View r14 = r12.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r14, r11) == false) goto L16;
        return true;
    L16:
        if (r14 == null) goto L18;
        KeyEvent.DispatcherState r15 = r14.getKeyDispatcherState();
    L20:
        return r11.dispatch(r10, r15, r10);
    L18:
        r15 = null;
        goto L20
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog r10, KeyEvent r11) {
        DialogInterface.OnKeyListener r12 = getDialogKeyListenerPre28(r10);
        if (r12 != null) goto L5;
    L7:
        Window r13 = r10.getWindow();
        if (r13.superDispatchKeyEvent(r11) == false) goto L10;
        return true;
    L10:
        View r14 = r13.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r14, r11) == false) goto L13;
        return true;
    L13:
        if (r14 == null) goto L15;
        KeyEvent.DispatcherState r15 = r14.getKeyDispatcherState();
    L17:
        return r11.dispatch(r10, r15, r10);
    L15:
        r15 = null;
        goto L17
    L5:
        if (r12.onKey(r10, r11.getKeyCode(), r11) == false) goto L7;
        return true;
    }

    public static boolean dispatchBeforeHierarchy(@NonNull View r10, @NonNull KeyEvent r11) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(r10, r11);
    }

    @SuppressLint({"LambdaLast"})
    public static boolean dispatchKeyEvent(@NonNull Component r10, @Nullable View r11, @Nullable Window.Callback r12, @NonNull KeyEvent r13) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        return r10.superDispatchKeyEvent(r13);
    L10:
        if ((r12 instanceof Activity) == false) goto L14;
        return activitySuperDispatchKeyEventPre28((Activity) r12, r13);
    L14:
        if ((r12 instanceof Dialog) == true) goto L16;
        if (r11 == null) goto L21;
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r11, r13) == false) goto L21;
    L22:
        return true;
    L21:
        if (r10.superDispatchKeyEvent(r13) == true) goto L22;
        return false;
    L16:
        return dialogSuperDispatchKeyEventPre28((Dialog) r12, r13);
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog r10) {
        if (sDialogFieldsFetched == false) goto L17;
    L7:
        Field r11 = sDialogKeyListenerField;
        if (r11 != null) goto L15;
        return null;
    L15:
        return (DialogInterface.OnKeyListener) r11.get(r10);
    L19:
        return null;
    L17:
        Field r12 = Dialog.class.getDeclaredField("mOnKeyListener");     // Catch: NoSuchFieldException -> L13
        sDialogKeyListenerField = r12;     // Catch: NoSuchFieldException -> L13
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L13
    L6:
        sDialogFieldsFetched = true;
        goto L7
    }
}
