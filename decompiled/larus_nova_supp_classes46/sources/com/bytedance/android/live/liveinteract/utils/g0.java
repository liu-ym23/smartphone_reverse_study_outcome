package com.bytedance.android.live.liveinteract.utils;

import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 {
    public static final /* synthetic */ int g = 0;
    public final h0 a;
    public int b;
    public boolean c;
    public long d;
    public final IRoom e;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> f;

    public static final class a {
    }

    static {
    }

    public final void c(int r3) {
        if (this.c == false) goto L5;
        return;
    L5:
        ALogger.i("LinkInfoReportHelper", "release: linkCount=" + this.b);
        this.f.T4(this.a);
        this.c = true;
        if (this.b <= 0) goto L8;
        d(r3, null);
    L8:
        this.b = 0;
    }

    public g0(IRoom r2, com.bytedance.android.live.liveinteract.plantform.core.y r3) {
        Intrinsics.checkNotNullParameter(r3, "userCenter");
        this.e = r2;
        this.f = r3;
        h0 r4 = new h0(this);
        this.a = r4;
        r3.Q4(r4);
        r4.onOnlineListChanged(r3.c);
    }

    public final void d(int r9, Integer r10) {
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestConnectionDuration: showStartTime=" + this.d);
        if (this.d <= 0) goto L25;
        long r2 = SystemClock.elapsedRealtime() - this.d;
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestConnectionDuration: livesdk_audience_guest_connection_duration, duration=" + r2 + " ms");
        LinkedHashMap r0 = new LinkedHashMap();
        if (vm2.h.R() == false) goto L9;
        IRoom r1 = this.e;
        if (r1 == null) goto L9;
        r0.put("room_id", String.valueOf(r1.getId()));
        r0.put("anchor_id", String.valueOf(this.e.getAnchorId()));
        LiveMode r3 = this.e.getStreamType();
        int r6 = com.bytedance.android.live.core.utils.h1.a;
        r0.put("live_type", com.bytedance.android.live.core.utils.i1.a(r3));
    L9:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r0, "logMap");
        TalkRoomLogUtils.J0(r0);
        if (r9 == 0) goto L12;
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r9), r10);
    L13:
        r0.put("duration", String.valueOf(r2));
        TalkRoomLogUtils.O0(r0);
        if (r10 == null) goto L17;
        r10.intValue();
        String r11 = com.bytedance.android.live.liveinteract.plantform.utils.i.a(r9, r10.intValue(), false);
        if (r11 == null) goto L17;
    L18:
        r0.put("function_type2", r11);
        if (r10 == null) goto L21;
    L23:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_guest_connection_duration", r0, new Object[]{IRoom.class, am2.x.class});
        this.d = 0;
        return;
    L21:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L23;
        r0.put("function_type2", "new_audience");
    L17:
        r11 = TalkRoomLogUtils.h;
        goto L18
    L12:
        TalkRoomLogUtils.B0(r0, null, r10, 2);
        goto L13
    }

    public final void e(int r5, Integer r6) {
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestShow: livesdk_audience_guest_connection_show");
        this.d = SystemClock.elapsedRealtime();
        LinkedHashMap r0 = new LinkedHashMap();
        if (vm2.h.R() == false) goto L7;
        IRoom r1 = this.e;
        if (r1 == null) goto L7;
        r0.put("room_id", String.valueOf(r1.getId()));
        r0.put("anchor_id", String.valueOf(this.e.getAnchorId()));
        LiveMode r2 = this.e.getStreamType();
        int r3 = com.bytedance.android.live.core.utils.h1.a;
        r0.put("live_type", com.bytedance.android.live.core.utils.i1.a(r2));
    L7:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r0, "logMap");
        TalkRoomLogUtils.J0(r0);
        if (r5 == 0) goto L10;
        TalkRoomLogUtils.B0(r0, Integer.valueOf(r5), null, 4);
    L11:
        TalkRoomLogUtils.O0(r0);
        if (r6 == null) goto L15;
        r6.intValue();
        String r7 = com.bytedance.android.live.liveinteract.plantform.utils.i.a(r5, r6.intValue(), false);
        if (r7 == null) goto L15;
    L16:
        r0.put("function_type2", r7);
        if (r6 == null) goto L19;
    L21:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_guest_connection_show", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L19:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L21;
        r0.put("function_type2", "new_audience");
    L15:
        r7 = TalkRoomLogUtils.h;
        goto L16
    L10:
        TalkRoomLogUtils.B0(r0, null, null, 6);
        goto L11
    }

    public final void b(int r3, int r4, int r5) {
        if (this.c == false) goto L5;
        return;
    L5:
        ALogger.i("LinkInfoReportHelper", "onPlayModeChange: currScene=" + r3 + ", fromUILayout=" + r4 + ", toUILayout=" + r5 + ", linkCount=" + this.b);
        if (this.b <= 0) goto L9;
        d(r3, Integer.valueOf(r4));
        e(r3, Integer.valueOf(r5));
        return;
    }

    public final void a(int r3, Integer r4, int r5, Integer r6) {
        if (this.c == false) goto L5;
        return;
    L5:
        ALogger.i("LinkInfoReportHelper", "onSceneChange: from=" + r3 + ", to=" + r5 + ", linkCount=" + this.b);
        if (this.b <= 0) goto L9;
        d(r3, r4);
        e(r5, r6);
        return;
    }
}
