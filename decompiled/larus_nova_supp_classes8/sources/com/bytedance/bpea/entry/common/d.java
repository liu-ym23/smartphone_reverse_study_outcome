package com.bytedance.bpea.entry.common;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.TypeCastException;
import me.ele.lancet.base.annotations.Skip;
import qc4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    static {
        Field r0 = a().getDeclaredField("INSTANCE");     // Catch: Throwable -> L8
        r0.setAccessible(true);     // Catch: Throwable -> L8
        Object r1 = r0.get(null);     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        ((f) r1).a();     // Catch: Throwable -> L8
        int r2 = qc4.a.a;     // Catch: Throwable -> L8
    L10:
        int r3 = qc4.a.a;
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.bpea.basics.ICorePowerProvider");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bpea.core.checker.CorePowerProvider");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bpea.core.checker.CorePowerProvider");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bpea.core.checker.CorePowerProvider");
    }

    public static void b(qc4.c r6) throws BPEAException {
        Iterator<b> r7 = c.a.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().c();
        goto L4
    L6:
        CopyOnWriteArraySet<b> r8 = c.a;
        CertCheckerHolder$check$1 r9 = CertCheckerHolder$check$1.INSTANCE;
        b.a r0 = new b.a("invokeStartSuccess");
        Iterator<b> r1 = c.a.iterator();
        String r2 = "";
    L7:
        int r3 = 0;
        boolean r4 = false;
    L9:
        if (r1.hasNext() == false) goto L17;
        r0 = r1.next().a();
        if (r0.a() == false) goto L13;
        r2 = r2 + '_' + r0.b;
    L13:
        if (r4 == true) goto L16;
        if (r0.a() == false) goto L7;
    L16:
        r4 = true;
        goto L9
    L17:
        if (r4 == true) goto L19;
        return;
    L19:
        if (r0.a() == true) goto L22;
        r3 = -1;
    L22:
        r9.invoke(Integer.valueOf(r3), r2);
    }
}
