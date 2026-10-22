package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void enableZ(@NonNull Canvas r10, boolean r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 21) goto L6;
        return;
    L6:
        if (r12 < 29) goto L11;
        if (r11 == false) goto L9;
        r10.enableZ();
        return;
    L9:
        r10.disableZ();
        return;
    L11:
        if (r12 == 28) goto L32;
        if (sOrderMethodsFetched == false) goto L35;
    L17:
        if (r11 == true) goto L37;
    L23:
        if (r11 == true) goto L40;
        Method r13 = sInorderBarrierMethod;     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
        if (r13 == null) goto L41;
        r13.invoke(r10, new Object[0]);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
    L21:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    L44:
        return;
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L37:
        Method r14 = sReorderBarrierMethod;     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
        if (r14 == null) goto L23;
        r14.invoke(r10, new Object[0]);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L34
        goto L23
    L35:
        Method r15 = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);     // Catch: NoSuchMethodException -> L33
        sReorderBarrierMethod = r15;     // Catch: NoSuchMethodException -> L33
        r15.setAccessible(true);     // Catch: NoSuchMethodException -> L33
        Method r16 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);     // Catch: NoSuchMethodException -> L33
        sInorderBarrierMethod = r16;     // Catch: NoSuchMethodException -> L33
        r16.setAccessible(true);     // Catch: NoSuchMethodException -> L33
    L16:
        sOrderMethodsFetched = true;
        goto L17
    L32:
        throw new IllegalStateException("This method doesn't work on Pie!");
    }
}
