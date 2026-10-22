package com.bytedance.android.btm.bridge;

import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class HybridContainerContextManager {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(HybridContainerContextManager$hybridContainerContextList$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public static String b(g66.c r10) {
        if (r10 == null) goto L9;
        Iterator r0 = ((List) a.getValue()).iterator();
    L5:
        if (r0.hasNext() == false) goto L14;
        String r1 = ((b) r0.next()).getPageUrl(r10);
        if (r1 == null) goto L5;
        return r1;
    L14:
        return null;
    L9:
        return null;
    }

    public static View c(g66.c r10) {
        int r0 = ((List) a.getValue()).size();
        View r1 = null;
        int r11 = 0;
    L3:
        if (r11 >= r0) goto L8;
        r1 = ((b) ListProtector.get((List) a.getValue(), r11)).obtainView(r10);
        if (r1 != null) goto L8;
        r11 = r11 + 1;
    L8:
        return r1;
    }
}
