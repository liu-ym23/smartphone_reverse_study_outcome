package np;

import android.view.View;
import com.obric.common.oea.foundation.blur.BlurUtils$BlurType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f20291a = null;

    static {
        f20291a = new HashMap();
    }

    public static void a(View r10, BlurUtils$BlurType r11, float r12, int... r13) {
        int r14 = r11.ordinal() - 1;
        HashMap r5 = f20291a;
        Method r15 = (Method) r5.get("getExt");
        Object r16 = null;
        if (r15 == null) goto L28;
    L9:
        r16 = r15.invoke(r10, null);     // Catch: InvocationTargetException -> L5 Throwable -> L7
    L13:
        Method r17 = (Method) r5.get("setBackdropBlurEffect");
        if (r17 == null) goto L30;
    L22:
        r17.invoke(r16, new Object[]{Integer.valueOf(r14), Float.valueOf(r12), r13});     // Catch: ClassNotFoundException -> L16 InvocationTargetException -> L18 Throwable -> L20
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L34:
        return;
    L30:
        r17 = Class.forName("android.view.IExtView").getDeclaredMethod("setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: ClassNotFoundException -> L16 InvocationTargetException -> L18 Throwable -> L20
        r17.setAccessible(true);     // Catch: ClassNotFoundException -> L16 InvocationTargetException -> L18 Throwable -> L20
        r5.put("setBackdropBlurEffect", r17);     // Catch: ClassNotFoundException -> L16 InvocationTargetException -> L18 Throwable -> L20
        goto L22
    L7:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L28:
        r15 = View.class.getDeclaredMethod("getExt", null);     // Catch: InvocationTargetException -> L5 Throwable -> L7
        r15.setAccessible(true);     // Catch: InvocationTargetException -> L5 Throwable -> L7
        r5.put("getExt", r15);     // Catch: InvocationTargetException -> L5 Throwable -> L7
        goto L9
    }
}
