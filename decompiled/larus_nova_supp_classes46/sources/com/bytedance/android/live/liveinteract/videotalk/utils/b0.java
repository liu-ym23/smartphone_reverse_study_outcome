package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 {
    public static final tf0.m b() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L8;
        rj0.k r0 = rj0.k.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSwitchLayoutStatisticsUtils();
    L8:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L14;
        rj0.l r1 = rj0.l.a.a();
        if (r1 != null) goto L13;
        return null;
    L13:
        return r1.getSwitchLayoutStatisticsUtils();
    L14:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L20;
        com.bytedance.android.live.liveinteract.voicechat.d r2 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r2 != null) goto L19;
        return null;
    L19:
        return r2.getSwitchLayoutStatisticsUtils();
    L20:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L29;
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 != null) goto L25;
        return null;
    L25:
        return r3.getSwitchLayoutStatisticsUtils();
    L29:
        return null;
    }

    public static final tf0.o c() {
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L6;
        tf0.o r1 = r0.windowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.windowManager();
    }

    public static final tf0.o d() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L6;
        tf0.o r1 = r0.commonWindowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.commonWindowManager();
    }

    public static final tf0.o e() {
        tf0.o r0 = d();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return c();
    }

    public static final void a(ILinkPlayerInfoBridge r1, LinkmicPositionItem r2) {
        Intrinsics.checkNotNullParameter(r1, "playerInfo");
        Intrinsics.checkNotNullParameter(r2, "lockItem");
        r1.setStats(r2.getStatus());
        r1.setActiveName(r2.getActiveName());
        r1.setVerifyStatus(r2.getVerifyStatus());
        r1.setPositionType(r2.getPositionType());
    }
}
