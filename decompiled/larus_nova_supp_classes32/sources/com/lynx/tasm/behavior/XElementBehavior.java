package com.lynx.tasm.behavior;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class XElementBehavior implements b {
    public static final HashSet<String> GENERATOR_FILE_NAME_SETS = null;
    private static final String TAG = "XElementBehavior";
    private static volatile List<a> sCacheBehaviors;

    public XElementBehavior() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        GENERATOR_FILE_NAME_SETS = new AnonymousClass1();
    }

    @Override // com.lynx.tasm.behavior.b
    public List<a> create() {
        monitor-enter(XElementBehavior.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sCacheBehaviors != null) goto L7;
    L11:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<String> r2 = GENERATOR_FILE_NAME_SETS.iterator();     // Catch: Throwable -> L18
    L13:
        if (r2.hasNext() == false) goto L15;
        r1.addAll(getModuleBehaviors(r2.next()));     // Catch: Throwable -> L18
        goto L13
    L15:
        sCacheBehaviors = r1;     // Catch: Throwable -> L18
        ArrayList r3 = new ArrayList(r1);     // Catch: Throwable -> L18
        monitor-exit(XElementBehavior.class);     // Catch: Throwable -> L18
        return r3;
    L7:
        if (sCacheBehaviors.isEmpty() == true) goto L11;
        ArrayList r4 = new ArrayList(sCacheBehaviors);     // Catch: Throwable -> L18
        monitor-exit(XElementBehavior.class);     // Catch: Throwable -> L18
        return r4;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_behavior_XElementBehavior_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    private List<a> getModuleBehaviors(String r5) {
        return (List) INVOKESTATIC_com_lynx_tasm_behavior_XElementBehavior_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r5 + ".BehaviorGenerator").getMethod("getBehaviors", new Class[0]).invoke(null, new Object[0]);
    L9:
        return new ArrayList();
    }
}
