package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y {
    public static final String a(RealtimeCallParam r5) {
        if (r5 != null) goto L5;
        return "normal";
    L5:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r2 = false;
        if (r1 == null) goto L12;
        DeviceService r3 = r1.device();
        if (r3 == null) goto L12;
        if (r3.C() != true) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
        IDoraAVLinkService r6 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r6 != null) goto L30;
    L32:
        if (r2 == false) goto L34;
    L35:
        return "companion_mode";
    L34:
        if (r5.p.T == true) goto L35;
        return "normal";
    L30:
        if (r6.l() != true) goto L32;
        r2 = true;
        goto L32
    L15:
        if (v88.a.c(Integer.valueOf(r5.k.s)) == true) goto L35;
        if (BaseDoraLiteLiveAiPlugin.l == true) goto L35;
        if (r5.p.T == true) goto L35;
        if (v88.a.b(Integer.valueOf(r5.k.s)) == false) goto L25;
        return "observation_mode";
    L25:
        if (r5.k.s != 21) goto L38;
        return "dora_gesture_note";
    L38:
        return "normal";
    L12:
        r4 = false;
        goto L13
    }
}
