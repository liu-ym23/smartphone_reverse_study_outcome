package h18;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final Rect a = null;
    public static final Class<?> b = null;

    static {
        a = new Rect();
        b = a();     // Catch: ClassNotFoundException -> L5
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.graphics.Insets");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.graphics.Insets");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.graphics.Insets");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.graphics.Insets");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.graphics.Insets");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.graphics.Insets");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.graphics.Insets");
    }

    public static Rect b(Drawable r11) {
        Class<?> r0 = b;
        if (r0 == null) goto L36;
        Drawable r12 = DrawableCompat.unwrap(r11);     // Catch: Exception -> L37
        Object r13 = r12.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(r12, new Object[0]);     // Catch: Exception -> L37
        if (r13 == null) goto L36;
        Rect r1 = new Rect();     // Catch: Exception -> L37
        Field[] r2 = r0.getFields();     // Catch: Exception -> L37
        int r3 = r2.length;     // Catch: Exception -> L37
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L34;
        Field r5 = r2[r4];     // Catch: Exception -> L37
        String r6 = r5.getName();     // Catch: Exception -> L37
        switch(r6.hashCode()) {
            case -1383228885: goto L21;
            case 115029: goto L18;
            case 3317767: goto L15;
            case 108511772: goto L12;
            default: goto L23;
        };     // Catch: Exception -> L37
    L23:
        byte r7 = -1;
    L24:
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L30;
        if (r7 != 3) goto L33;
        r1.bottom = r5.getInt(r13);     // Catch: Exception -> L37
    L33:
        r4 = r4 + 1;
        goto L7
    L30:
        r1.right = r5.getInt(r13);     // Catch: Exception -> L37
        goto L33
    L31:
        r1.top = r5.getInt(r13);     // Catch: Exception -> L37
        goto L33
    L32:
        r1.left = r5.getInt(r13);     // Catch: Exception -> L37
        goto L33
    L12:
        if (r6.equals("right") == false) goto L23;
        r7 = 2;
        goto L24
    L15:
        if (r6.equals("left") == false) goto L23;
        r7 = 0;
        goto L24
    L18:
        if (r6.equals("top") == false) goto L23;
        r7 = 1;
        goto L24
    L21:
        if (r6.equals("bottom") == false) goto L23;
        r7 = 3;
        goto L24
    L34:
        return r1;
    L36:
        return a;
    }
}
