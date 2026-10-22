package ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsetsController;
import he.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @SuppressLint({"BlockedPrivateApi", "PrivateApi"})
    public static int a(View r8) {
        i.f(r8, "rootView");
        WindowInsetsController r10 = r8.getWindowInsetsController();     // Catch: Exception -> L32
        if (r10 == null) goto L37;
        Method r11 = r10.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L32
        i.e(r11, "getStateMethod");     // Catch: Exception -> L32
        r11.setAccessible(true);     // Catch: Exception -> L32
        Object r12 = r11.invoke(r10, new Object[0]);     // Catch: Exception -> L32
        int r13 = Build.VERSION.SDK_INT;     // Catch: Exception -> L32
        if (r13 < 35) goto L8;
        String r14 = "android.view.InsetsSource";
    L9:
        Class<?> r15 = Class.forName(r14);     // Catch: Exception -> L32
        if (r13 < 35) goto L12;
        String r16 = "ID_IME";
    L13:
        Field r17 = r15.getDeclaredField(r16);     // Catch: Exception -> L32
        i.e(r17, "insetField");     // Catch: Exception -> L32
        r17.setAccessible(true);     // Catch: Exception -> L32
        Object r18 = null;
        int r19 = r17.getInt(null);     // Catch: Exception -> L32
        Method r20 = r12.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L32
        i.e(r20, "peekSourceMethod");     // Catch: Exception -> L32
        r20.setAccessible(true);     // Catch: Exception -> L32
        Object r21 = r20.invoke(r12, new Object[]{Integer.valueOf(r19)});     // Catch: Exception -> L32
        if ((r21 instanceof Object) == true) goto L16;
        r21 = null;
    L16:
        if (r21 == null) goto L38;
        Method r22 = r21.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L32
        i.e(r22, "isVisibleMethod");     // Catch: Exception -> L32
        r22.setAccessible(true);     // Catch: Exception -> L32
        Object r23 = r22.invoke(r21, new Object[0]);     // Catch: Exception -> L32
        if ((r23 instanceof Boolean) == true) goto L20;
        r23 = null;
    L20:
        Boolean r24 = (Boolean) r23;     // Catch: Exception -> L32
        if (r24 != null) goto L23;
        return 0;
    L23:
        if (r24.booleanValue() == false) goto L34;
        Method r25 = r21.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L32
        i.e(r25, "getFrameMethod");     // Catch: Exception -> L32
        r25.setAccessible(true);     // Catch: Exception -> L32
        Object r26 = r25.invoke(r21, new Object[0]);     // Catch: Exception -> L32
        if ((r26 instanceof Rect) == false) goto L28;
        r18 = r26;
    L28:
        Rect r27 = (Rect) r18;     // Catch: Exception -> L32
        if (r27 == null) goto L40;
        return r27.height();
    L40:
        return 0;
    L34:
        return 0;
    L38:
        return 0;
    L12:
        r16 = "ITYPE_IME";
        goto L13
    L8:
        r14 = "android.view.InsetsState";
        goto L9
    L37:
        return 0;
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    public static int b(Context r8) {
        if (r8 != null) goto L5;
        return 0;
    L5:
        int r10 = r8.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r10 > 0) goto L8;
        Class<?> r11 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r12 = r11.newInstance();     // Catch: Exception -> L11
        int r13 = Integer.parseInt(r11.getField("navigation_bar_height").get(r12).toString());     // Catch: Exception -> L11
        return r8.getResources().getDimensionPixelSize(r13);
    L14:
        return 0;
    L8:
        return r8.getResources().getDimensionPixelSize(r10);
    }
}
