package com.larus.avlink;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.IFlowTtsClientService$b;
import com.larus.dora.api.IDoraService;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        b(r3, "DoraNotice" + System.currentTimeMillis(), null);
    }

    public static void b(String r13, String r14, l68.b r15) {
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r14, "taskId");
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService r1 = IFlowTtsClientService.a.a();
        if (r1 != null) goto L6;
        FLogger.a.i("DoraTtsPlayer", "playNoticeTTS failed, flowTtsClientService is null");
        return;
    L6:
        r1.f("onPlayNoticeTTS");
        r1.j(z2.a.J());
        FLogger.a.i("DoraTtsPlayer", "taskId = " + r14 + ", text = " + r13);
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        String r2 = r0.v0();
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L20;
        e10 r4 = e10.a;
        r2 = e10.f().a();
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        String r5 = r2;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L23;
        String r9 = r6.z();
    L24:
        IFlowTtsClientService$b.a(r1, r14, null, r13, r5, null, null, r15, r9, ia8.e.c().b(), ia8.e.c().c(), 14450);
        return;
    L23:
        r9 = null;
        goto L24
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
        goto L16
    L9:
        r2 = null;
        goto L10
    }
}
