package sda;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public static final m a = null;
    public static final Class<?> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static volatile Object m;

    public m() {
    }

    static {
        a = new m();
        b = new Class[0].getClass();
        c = LazyKt.lazy(new c());
        d = LazyKt.lazy(new d());
        e = LazyKt.lazy(new e());
        f = LazyKt.lazy(new f());
        g = LazyKt.lazy(new g());
        h = LazyKt.lazy(new h());
        i = LazyKt.lazy(new i());
        j = LazyKt.lazy(new j());
        k = LazyKt.lazy(new k());
        l = LazyKt.lazy(new l());
    }

    public static Class b() {
        return (Class) c.getValue();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static Class c(String r7) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Method r2 = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L9
        r2.setAccessible(true);     // Catch: Throwable -> L9
        Object r3 = r2.invoke(null, new Object[]{r7});     // Catch: Throwable -> L9
        if ((r3 instanceof Class) == false) goto L6;
        Class r4 = (Class) r3;     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r5) == null) goto L24;
        Object r8 = Result.constructor-impl(a(r7));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r8) == true) goto L22;
        r0 = r8;
    L22:
        r5 = (Class) r0;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        return (Class) r5;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static Constructor d(Class r7, Class... r8) {
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Method r3 = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{b});     // Catch: Throwable -> L12
        r3.setAccessible(true);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L12
        Object r4 = r3.invoke(r7, new Object[]{r8});     // Catch: Throwable -> L12
        if ((r4 instanceof Constructor) == false) goto L6;
        Constructor r5 = (Constructor) r4;     // Catch: Throwable -> L12
    L7:
        if (r5 == null) goto L9;
        r5.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r6) == null) goto L27;
        Constructor r9 = r7.getDeclaredConstructor((Class[]) Arrays.copyOf(r8, r8.length));     // Catch: Throwable -> L19
        r9.setAccessible(true);     // Catch: Throwable -> L19
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r10) == true) goto L25;
        r0 = r10;
    L25:
        r6 = (Constructor) r0;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        return (Constructor) r6;
    L9:
        r5 = null;
        goto L10
    L6:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static Field e(Class r7, String r8) {
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Method r3 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L12
        r3.setAccessible(true);     // Catch: Throwable -> L12
        Object r4 = r3.invoke(r7, new Object[]{r8});     // Catch: Throwable -> L12
        if ((r4 instanceof Field) == false) goto L6;
        Field r5 = (Field) r4;     // Catch: Throwable -> L12
    L7:
        if (r5 == null) goto L9;
        r5.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r6) == null) goto L27;
        Field r9 = r7.getDeclaredField(r8);     // Catch: Throwable -> L19
        r9.setAccessible(true);     // Catch: Throwable -> L19
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r10) == true) goto L25;
        r0 = r10;
    L25:
        r6 = (Field) r0;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        return (Field) r6;
    L9:
        r5 = null;
        goto L10
    L6:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static Method f(Class r8, String r9, Class... r10) {
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Method r3 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, b});     // Catch: Throwable -> L12
        r3.setAccessible(true);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L12
        Object r4 = r3.invoke(r8, new Object[]{r9, r10});     // Catch: Throwable -> L12
        if ((r4 instanceof Method) == false) goto L6;
        Method r5 = (Method) r4;     // Catch: Throwable -> L12
    L7:
        if (r5 == null) goto L9;
        r5.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r6) == null) goto L27;
        Method r11 = r8.getDeclaredMethod(r9, (Class[]) Arrays.copyOf(r10, r10.length));     // Catch: Throwable -> L19
        r11.setAccessible(true);     // Catch: Throwable -> L19
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r12) == true) goto L25;
        r0 = r12;
    L25:
        r6 = (Method) r0;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        return (Method) r6;
    L9:
        r5 = null;
        goto L10
    L6:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static void g(Object r23, Context r24, String r25, String r26, Integer r27, Integer r28) {
        if (r27 == null) goto L50;
        int r7 = r27.intValue();
        if (r28 == null) goto L7;
        int r9 = r28.intValue();
    L8:
        Method r10 = (Method) e.getValue();
        if (r10 != null) goto L54;
        FLogger.a.w("VendorLaunchBoostHelper", "requestLaunchHint fallback, scene=" + r26 + ", source=" + r25 + ", perfHintAcqRelMethod is null");
        boolean r0 = false;
    L29:
        if (r0 == true) goto L56;
        Method r11 = (Method) f.getValue();
        if (r11 != null) goto L52;
        FLogger.a.w("VendorLaunchBoostHelper", "requestPerfHint skipped, scene=" + r26 + ", source=" + r25 + ", perfHintMethod is null");
        return;
    L52:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L44
        Object r1 = r11.invoke(r23, new Object[]{Integer.valueOf(r7), r24.getPackageName(), 500, Integer.valueOf(r9)});     // Catch: Throwable -> L44
        if ((r1 instanceof Integer) == false) goto L36;
        Integer r2 = (Integer) r1;     // Catch: Throwable -> L44
    L37:
        if (r2 != null) goto L39;
    L41:
        FLogger.a.w("VendorLaunchBoostHelper", "requestPerfHint rejected, scene=" + r26 + ", source=" + r25 + ", handle=" + r2 + ", hint=0x" + Integer.toString(r7, CharsKt.checkRadix(16)) + ", launchType=" + r9 + ", durationMs=500");     // Catch: Throwable -> L44
    L42:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L58;
        FLogger.a.w("VendorLaunchBoostHelper", "requestPerfHint failed, scene=" + r26 + ", source=" + r25, r4);
        return;
    L58:
        return;
    L39:
        if (r2.intValue() <= 0) goto L41;
        FLogger.a.i("VendorLaunchBoostHelper", "requestPerfHint success, scene=" + r26 + ", source=" + r25 + ", handle=" + r2 + ", hint=0x" + Integer.toString(r7, CharsKt.checkRadix(16)) + ", launchType=" + r9 + ", durationMs=500");     // Catch: Throwable -> L44
        goto L42
    L36:
        r2 = null;
    L44:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L56:
        return;
    L54:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L22
        Object r6 = r10.invoke(r23, new Object[]{-1, Integer.valueOf(r7), r24.getPackageName(), 500, Integer.valueOf(r9), 0, new int[0]});     // Catch: Throwable -> L22
        if ((r6 instanceof Integer) == false) goto L14;
        Integer r8 = (Integer) r6;     // Catch: Throwable -> L22
    L15:
        if (r8 != null) goto L17;
    L19:
        FLogger.a.w("VendorLaunchBoostHelper", "requestLaunchHint rejected, scene=" + r26 + ", source=" + r25 + ", handle=" + r8 + ", hint=0x" + Integer.toString(r7, CharsKt.checkRadix(16)) + ", launchType=" + r9 + ", durationMs=500");     // Catch: Throwable -> L22
        boolean r12 = false;
    L20:
        Object r13 = Result.constructor-impl(Boolean.valueOf(r12));     // Catch: Throwable -> L22
    L24:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L28;
        FLogger.a.w("VendorLaunchBoostHelper", "requestLaunchHint failed, scene=" + r26 + ", source=" + r25, r14);
        r13 = Boolean.FALSE;
    L28:
        r0 = ((Boolean) r13).booleanValue();
        goto L29
    L17:
        if (r8.intValue() <= 0) goto L19;
        FLogger.a.i("VendorLaunchBoostHelper", "requestLaunchHint success, scene=" + r26 + ", source=" + r25 + ", handle=" + r8 + ", hint=0x" + Integer.toString(r7, CharsKt.checkRadix(16)) + ", launchType=" + r9 + ", durationMs=500");     // Catch: Throwable -> L22
        r12 = true;
        goto L20
    L14:
        r8 = null;
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L7:
        r9 = 0;
        goto L8
    L50:
        FLogger.a.w("VendorLaunchBoostHelper", "requestLaunchHint skipped, scene=" + r26 + ", source=" + r25 + ", vendor hint is null");
    }
}
