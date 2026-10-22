package ms.bd.c;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import el9.a;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class n {
    public static volatile int a = -1;
    public static volatile String b = "";
    public static volatile String c;
    public static final HashMap d = null;
    public static boolean e;
    public static final PthreadHandlerThreadV2 f = null;
    public static final AtomicBoolean g = null;
    public static Handler h;

    static {
        d = new HashMap(3);
        e = false;
        f = new PthreadHandlerThreadV2((String) p2.a(16777217, 0, 0, "62adef", new byte[]{42, 35, 1, 20, 81}));
        g = new AtomicBoolean(true);
        h = null;
    }

    public static int b() {
        if (d() == null) goto L6;
        return 1;
    L6:
        return 0;
    L8:
        return -1;
    }

    public static Activity d() {
        Class r0 = a((String) p2.a(16777217, 0, 0, "6e355a", new byte[]{38, 105, 68, 83, 5, ByteCompanionObject.MAX_VALUE, 49, 10, 99, 117, 55, 41, 97, 66, 30, ByteCompanionObject.MAX_VALUE, 35, 77, 118, 124, 19, 111, 82, 68, 11, 114}));     // Catch: Exception -> L14
        Object r1 = r0.getMethod((String) p2.a(16777217, 0, 0, "8b2db9", new byte[]{42, 117, 83, 2, 88, 32, 47, 98, 96, 32, 32, 118, 72, 4, 68, 26, 51, 81, 102, 53, 45}), null).invoke(null, null);     // Catch: Exception -> L14
        Field r2 = r0.getDeclaredField((String) p2.a(16777217, 0, 0, "4ea5eb", new byte[]{40, 70, 17, 85, 83, 99, 62, 80, 57, 96, 54}));     // Catch: Exception -> L14
        r2.setAccessible(true);     // Catch: Exception -> L14
        ArrayMap r3 = (ArrayMap) r2.get(r1);     // Catch: Exception -> L14
        if (r3.size() >= 1) goto L7;
        return null;
    L7:
        Iterator r4 = r3.values().iterator();     // Catch: Exception -> L14
    L9:
        if (r4.hasNext() == false) goto L22;
        Object r5 = r4.next();     // Catch: Exception -> L14
        Class<?> r6 = r5.getClass();     // Catch: Exception -> L14
        Field r7 = r6.getDeclaredField((String) p2.a(16777217, 0, 0, "3d81c5", new byte[]{49, 114, 68, 85, 76, 39, 52}));     // Catch: Exception -> L14
        r7.setAccessible(true);     // Catch: Exception -> L14
        if (r7.getBoolean(r5) == true) goto L9;
        Field r8 = r6.getDeclaredField((String) p2.a(16777217, 0, 0, "e9fd31", new byte[]{117, 56, 1, 25, 26, 47, 114, 1}));     // Catch: Exception -> L14
        r8.setAccessible(true);     // Catch: Exception -> L14
        return (Activity) r8.get(r5);
    L22:
        return null;
    L14:
        String r9 = (String) p2.a(16777217, 0, 0, "0eb2b2", new byte[]{32, 110, 46, 65});
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void c(int r12) {
        HashMap r0 = d;
        if (r0 != null) goto L5;
    L15:
        String r2 = null;
    L16:
        String r7 = r2;
        if (TextUtils.isEmpty(r7) == true) goto L25;
        p2.a(16777223, r12, System.currentTimeMillis(), r7, null);
        return;
    L25:
        return;
    L5:
        if (r0.size() <= 0) goto L15;
        Iterator r1 = r0.entrySet().iterator();
        r2 = "";
        int r3 = 0;
    L8:
        if (r1.hasNext() == false) goto L16;
        int r4 = ((MSManagerUtils.ScenePageNameCallback) ((Map.Entry) r1.next()).getValue()).getScenePageName();
        if (r4 == 0) goto L8;
        if (r3 <= 0) goto L14;
        r2 = r2 + ((String) p2.a(16777217, 0, 0, "17b7f4", new byte[]{31}));
    L14:
        r2 = r2 + r4;
        r3 = r3 + 1;
        goto L8
    }
}
