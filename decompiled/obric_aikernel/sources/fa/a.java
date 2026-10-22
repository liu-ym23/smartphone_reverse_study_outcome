package fa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8880a = null;

    static {
        f8880a = new a();
    }

    private a() {
    }

    @RequiresApi(30)
    @SuppressLint({"BlockedPrivateApi", "PrivateApi"})
    public final int a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "rootView");
        WindowInsetsController r11 = r10.getWindowInsetsController();     // Catch: Exception -> L33
        if (r11 == null) goto L38;
        Intrinsics.checkNotNullExpressionValue(r11, "rootView.windowInsetsController ?: return 0");     // Catch: Exception -> L33
        Method r12 = r11.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L33
        Intrinsics.checkNotNullExpressionValue(r12, "getStateMethod");     // Catch: Exception -> L33
        r12.setAccessible(true);     // Catch: Exception -> L33
        Object r13 = r12.invoke(r11, new Object[0]);     // Catch: Exception -> L33
        int r14 = Build.VERSION.SDK_INT;     // Catch: Exception -> L33
        if (r14 < 35) goto L9;
        String r15 = "android.view.InsetsSource";
    L8:
        Class<?> r16 = Class.forName(r15);     // Catch: Exception -> L33
        if (r14 < 35) goto L13;
        String r17 = "ID_IME";
    L12:
        Field r18 = r16.getDeclaredField(r17);     // Catch: Exception -> L33
        Intrinsics.checkNotNullExpressionValue(r18, "insetField");     // Catch: Exception -> L33
        r18.setAccessible(true);     // Catch: Exception -> L33
        Object r19 = null;
        int r20 = r18.getInt(null);     // Catch: Exception -> L33
        Method r21 = r13.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L33
        Intrinsics.checkNotNullExpressionValue(r21, "peekSourceMethod");     // Catch: Exception -> L33
        r21.setAccessible(true);     // Catch: Exception -> L33
        Object r22 = r21.invoke(r13, new Object[]{Integer.valueOf(r20)});     // Catch: Exception -> L33
        if ((r22 instanceof Object) == true) goto L17;
        r22 = null;
    L17:
        if (r22 == null) goto L39;
        Method r23 = r22.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L33
        Intrinsics.checkNotNullExpressionValue(r23, "isVisibleMethod");     // Catch: Exception -> L33
        r23.setAccessible(true);     // Catch: Exception -> L33
        Object r24 = r23.invoke(r22, new Object[0]);     // Catch: Exception -> L33
        if ((r24 instanceof Boolean) == true) goto L21;
        r24 = null;
    L21:
        Boolean r25 = (Boolean) r24;     // Catch: Exception -> L33
        if (r25 != null) goto L24;
        return 0;
    L24:
        if (r25.booleanValue() == false) goto L35;
        Method r26 = r22.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L33
        Intrinsics.checkNotNullExpressionValue(r26, "getFrameMethod");     // Catch: Exception -> L33
        r26.setAccessible(true);     // Catch: Exception -> L33
        Object r27 = r26.invoke(r22, new Object[0]);     // Catch: Exception -> L33
        if ((r27 instanceof Rect) == false) goto L29;
        r19 = r27;
    L29:
        Rect r28 = (Rect) r19;     // Catch: Exception -> L33
        if (r28 == null) goto L41;
        return r28.height();
    L41:
        return 0;
    L35:
        return 0;
    L39:
        return 0;
    L13:
        r17 = "ITYPE_IME";
        goto L12
    L9:
        r15 = "android.view.InsetsState";
        goto L8
    L38:
        return 0;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    public final int b(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r11 > 0) goto L8;
        Class<?> r12 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r13 = r12.newInstance();     // Catch: Exception -> L11
        int r14 = Integer.parseInt(r12.getField("navigation_bar_height").get(r13).toString());     // Catch: Exception -> L11
        return r10.getResources().getDimensionPixelSize(r14);
    L14:
        return 0;
    L8:
        return r10.getResources().getDimensionPixelSize(r11);
    }

    public final int c(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r11 > 0) goto L8;
        Class<?> r12 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r13 = r12.newInstance();     // Catch: Exception -> L11
        int r14 = Integer.parseInt(r12.getField("status_bar_height").get(r13).toString());     // Catch: Exception -> L11
        return r10.getResources().getDimensionPixelSize(r14);
    L14:
        return 0;
    L8:
        return r10.getResources().getDimensionPixelSize(r11);
    }

    public final void d(boolean r10) {
    }
}
