package f4;

import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w {
    public static final w a = null;
    public static final Object b = null;
    public static final r c = null;
    public static WindowManager d;
    public static Object e;
    public static Class<?> f;
    public static Boolean g;

    public w() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [f4.r] */
    static {
        a = new w();
        b = new Object();
        c = new r();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("java.util.function.Consumer");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("java.util.function.Consumer");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.util.function.Consumer");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("java.util.function.Consumer");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("java.util.function.Consumer");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.util.function.Consumer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("java.util.function.Consumer");
    }

    public static void c() {
        WindowManager r0 = d;
        Object r1 = e;
        Class<?> r10 = f;
        if (r0 == null) goto L13;
        if (r1 == null) goto L13;
        if (r10 == null) goto L13;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(WindowManager.class.getMethod("removeScreenRecordingCallback", new Class[]{r10}).invoke(r0, new Object[]{r1}));     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L13;
        com.bytedance.ai.utils.g.a.w("UserScreenRecordEventHelper", "unregister screen recording callback failed", r13);
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        d = null;
        e = null;
        f = null;
        g = null;
    }

    public static void b(int r10, boolean r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Integer.valueOf(WindowManager.class.getField("SCREEN_RECORDING_STATE_VISIBLE").getInt(null)));     // Catch: Throwable -> L4
    L6:
        boolean r12 = true;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = 1;
    L10:
        if (r10 != ((Number) r1).intValue()) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        String r14 = "start";
    L16:
        Object r15 = b;
        monitor-enter(r15);
        Boolean r16 = g;     // Catch: Throwable -> L32
        if (Intrinsics.areEqual(r16, Boolean.valueOf(r13)) == true) goto L26;
        g = Boolean.valueOf(r13);     // Catch: Throwable -> L32
        if (r13 == true) goto L27;
        if (r16 != null) goto L27;
        if (r11 == false) goto L26;
    L27:
        monitor-exit(r15);
        if (r12 == true) goto L30;
        return;
    L30:
        Lazy r17 = l3.d.a;
        JsonObject r18 = new JsonObject();
        r18.addProperty("state", r14);
        Unit r19 = Unit.INSTANCE;
        l3.d.c(new l3.a("doubao.onUserScreenRecord", r18, 4));
        return;
    L26:
        r12 = false;
    L32:
        th = move-exception;
        throw th;
    L15:
        r14 = "stop";
        goto L16
    L12:
        r13 = false;
    L4:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
