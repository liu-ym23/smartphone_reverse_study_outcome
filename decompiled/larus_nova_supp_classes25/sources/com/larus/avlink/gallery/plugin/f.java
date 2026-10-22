package com.larus.avlink.gallery.plugin;

import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final Object a(Continuation r6) {
        IPluginService r0 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L11;
        IDoraPluginService r7 = (IDoraPluginService) ServiceManager.get().getService(IDoraPluginService.class);
        b(r7);
        return r7;
    L11:
        j r4 = new j(IntrinsicsKt.intercepted(r6), 1);
        r4.C();
        AtomicBoolean r1 = new AtomicBoolean(false);
        PluginLoadBuilder r2 = new PluginLoadBuilder();
        Intrinsics.checkNotNullParameter("com.larus.mira.dora", "packageName");
        r2.a = "com.larus.mira.dora";
        Intrinsics.checkNotNull(IDoraPluginService.class, "null cannot be cast to non-null type java.lang.Class<*>");
        r2.b = IDoraPluginService.class;
        PluginLoadBuilder.PluginLoadType r5 = PluginLoadBuilder.PluginLoadType.ASYNC;
        Intrinsics.checkNotNullParameter(r5, "type");
        r2.e = r5;
        PluginLoadBuilder.PluginLoadTime r8 = PluginLoadBuilder.PluginLoadTime.IMMEDIATE;
        Intrinsics.checkNotNullParameter(r8, "method");
        r2.d = r8;
        r2.g = 3000;
        c r9 = new c(r1, r4);
        Intrinsics.checkNotNullParameter(r9, "result");
        r2.f = r9;
        PluginLoadBuilder.c r10 = r2.a();
        if (r0 == null) goto L14;
        r0.a(r10);
    L14:
        r4.i(new b(r1));
        Object r11 = r4.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L17:
        return r11;
    L5:
        if (r0.c(IDoraPluginService.class) != true) goto L7;
        r3 = true;
        goto L8
    }

    public static final void b(IDoraPluginService r1) {
        if (r1 == null) goto L5;
        r1.ensureMorphoFiles(AppHost.a.getApplication());
        return;
    }
}
