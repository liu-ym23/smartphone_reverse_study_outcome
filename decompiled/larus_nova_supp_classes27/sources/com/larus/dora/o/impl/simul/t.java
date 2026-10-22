package com.larus.dora.o.impl.simul;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.oui.tab.OTabLayoutBase;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements OTabLayoutBase.e {
    public final /* synthetic */ ODoraSimulInterpretFragment a;

    public final void a(OTabLayoutBase.i r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    public final void b(OTabLayoutBase.i r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    public t(ODoraSimulInterpretFragment r1) {
        this.a = r1;
    }

    public final void c(OTabLayoutBase.i r5) {
        Intrinsics.checkNotNullParameter(r5, "t");
        ODoraSimulInterpretFragment r0 = this.a;
        if (r0.j == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (r5.d == 1) goto L9;
        r1 = false;
    L9:
        FLogger.a.i("ODoraSimulInterpretFragment", "onModeSwitch isConference=" + r1);
        DoraConfig.a.storeBoolean("key_si_dora_g_conference_enable", r1);
        r0.V90(r1);
        IDoraAVLinkService r6 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r6 == null) goto L15;
        if (r1 == false) goto L13;
        String r2 = "ConferenceRoom";
    L14:
        r6.h(r2);
        goto L15
    L13:
        r2 = "FaceToFace";
    L15:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L21;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L22;
        r8.B0(r1);
        return;
    L22:
        return;
    }
}
