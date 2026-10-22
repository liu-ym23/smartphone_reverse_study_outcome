package kl;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f18663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f18664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f18665c = 0;

    static {
        Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L8
    L12:
        f18663a = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
    L18:
        f18664b = WindowManager.LayoutParams.class.getField("statusBarColor");     // Catch: NoSuchFieldException -> L10
    L16:
        f18665c = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);     // Catch: Throwable -> L11
        return;
    }

    public static void a(FragmentActivity r5, boolean r10, boolean r11) {
        Method r12 = f18663a;
        if (r12 != null) goto L30;
        if (r11 == false) goto L34;
        Window r13 = r5.getWindow();
        View r14 = r13.getDecorView();
        int r15 = r14.getSystemUiVisibility();
        int r16 = f18665c;
        if (r10 == false) goto L16;
        int r17 = r15 | r16;
    L17:
        if (r17 == r15) goto L19;
        r14.setSystemUiVisibility(r17);
    L19:
        WindowManager.LayoutParams r18 = r13.getAttributes();
        Field r19 = f18664b;
        if (r19 == null) goto L35;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        if (r19.getInt(r18) == 0) goto L36;
        r19.set(r18, 0);     // Catch: IllegalAccessException -> L25
        r13.setAttributes(r18);     // Catch: IllegalAccessException -> L25
        return;
    L36:
        return;
    L35:
        return;
    L16:
        r17 = (~r16) & r15;
        goto L17
    L34:
        return;
    L30:
        r12.invoke(r5, new Object[]{Boolean.valueOf(r10)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8
    L37:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
