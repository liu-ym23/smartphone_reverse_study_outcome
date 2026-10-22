package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements Runnable {
    public final /* synthetic */ m.a a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            ALogger.i("AdventureLinkService", "leaveMultiLinkRoom, linkPlayerState onChanged: " + ((Integer) r4));
            if (hd0.c.f().h() == true) goto L6;
            ALogger.i("AdventureLinkService", "leaveMultiLinkRoom success");
            MainThreadPostUtils.c(new e(this), ((Number) vm2.d.p7.getValue(null, vm2.d.a[428(0x1ac, float:6.0E-43)])).longValue());
            hd0.c.f().e(g.h);
            g.h = null;
            return;
        }
    }

    public f(m.a r1) {
        this.a = r1;
    }

    public final void a() {
        boolean r0 = hd0.c.f().h();
        StringBuilder r1 = new StringBuilder("leaveMultiLinkRoom, isGuest: ");
        r1.append(r0);
        r1.append(", rtcRoomId: ");
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L7;
        Long r4 = Long.valueOf(r3.getRoomId());
    L8:
        r1.append(r4);
        ALogger.i("AdventureLinkService", r1.toString());
        if (r0 == false) goto L20;
        String r5 = ei0.a.a;
        JSONObject r6 = new JSONObject();
        r6.put("adventure_call_user_type", ei0.a.a);
        int r7 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_leave_multi_link", 0, null, r6, 88);
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("leaveMultiLink, extra: %s", Arrays.copyOf(new Object[]{r6}, 1)));
        g.h = new a(this);
        hd0.c.f().c(g.h);
        int r9 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (v.a(r9, 32) == false) goto L16;
        rj0.l.n2.getClass();
        rj0.l r10 = rj0.l.a.a();
        if (r10 == null) goto L24;
        rj0.l.b.d(r10, 204, false, false, 8);
        return;
    L24:
        return;
    L16:
        if (v.a(r9, 8) == false) goto L26;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r11 = IVoiceChatGuestService.a.a();
        if (r11 == null) goto L27;
        IVoiceChatGuestService.b.b(r11, 204, false, false, false, 16);
        return;
    L27:
        return;
    L26:
        return;
    L20:
        m.a r12 = this.a;
        if (r12 == null) goto L29;
        r12.a();
        return;
    L29:
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
