package com.bytedance.android.livesdk.interactivity.common.utils;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import ec2.u1;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
        return true;
    L5:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L28;
        o r2 = IRoomContextService.a.a(r1, r6, 0, 2);
        if (r2 == null) goto L28;
        IVSPlayerService r3 = jc1.k.f(IVSPlayerService.class);
        if (r3 == null) goto L28;
        IPlayerProgressService r4 = r3.provideVSProgressService(r6);
        if (r4 == null) goto L28;
        PlayerProgressServiceContext r7 = r4.provideContext(r6);
        if (r7 == null) goto L28;
        if (r2.isVSFirstShow() == true) goto L20;
    L26:
        r0 = false;
    L27:
        EpisodeInteractivityTracer.c("check canStartSeekMessageFetchInFirstShow: " + r0);
        goto L28
    L20:
        if (((Number) r7.getTotalTime().getValue()).longValue() <= 0) goto L26;
        if (((Number) r7.getCurrentTime().getValue()).longValue() <= 0) goto L26;
        if ((((Number) r7.getTotalTime().getValue()).longValue() - ((Number) r7.getCurrentTime().getValue()).longValue()) <= (((Number) u1.a.getValue()).intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) goto L26;
    L28:
        return r0;
    }

    @JvmStatic
    public static final long b(DataCenter r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        if (r2 == null) goto L17;
        o r7 = IRoomContextService.a.a(r2, r6, 0, 2);
        if (r7 == null) goto L19;
        long r3 = System.currentTimeMillis();
        m r8 = r7.getSeiTimePair();
        if (r8 == null) goto L18;
        z0 r9 = (z0) r8.getValue();
        if (r9 != null) goto L16;
        return 0;
    L16:
        return r9.a + (r3 - r9.b);
    L18:
        return 0;
    L19:
        return 0;
    L17:
        return 0;
    }

    @JvmStatic
    public static final boolean c(DataCenter r2) {
        boolean r0 = false;
        if (r2 != null) goto L5;
        return false;
    L5:
        IVSPlayerService r1 = jc1.k.f(IVSPlayerService.class);
        if (r1 == null) goto L16;
        IPlayerProgressService r3 = r1.provideVSProgressService(r2);
        if (r3 == null) goto L16;
        PlayerProgressServiceContext r4 = r3.provideContext(r2);
        if (r4 == null) goto L16;
        Boolean r5 = r4.isPlaying();
        if (r5 == null) goto L15;
        r0 = r5.booleanValue();
    L15:
        EpisodeInteractivityTracer.c("check isPlaying: " + r0);
    L16:
        return r0;
    }
}
