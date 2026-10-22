package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ RoomContext d;
    public final /* synthetic */ Context e;

    public c0(long r1, int r3, RoomContext r4, String r5, Context r6) {
        this.a = r1;
        this.b = true;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r11) {
        ExtraResponse r12 = (ExtraResponse) r11;
        ALogger.i("XplayGlobalService", "getInteractEntranceItem success");
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.utils.n r1 = r0.getLinkMicGameTraceUtils();
        if (r1 == null) goto L7;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r1, true, "/webcast/anchor_mount/interact_entrance/target_cell/", "logId: " + r12.logId, 4);
    L7:
        InteractEntranceCell r2 = ((XplayApi.c) r12.data).interactEntranceItem;
        if (r2 == null) goto L39;
        com.bytedance.android.live.broadcastgame.api.xplay.l r3 = com.bytedance.android.live.broadcastgame.api.xplay.m.a(r2.i());
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L15;
        com.bytedance.android.live.liveinteract.utils.l r5 = r4.getLinkMicGameFullLinkMonitor();
        if (r5 == null) goto L15;
        com.bytedance.android.live.liveinteract.utils.l.a.c(r5, LinkMonitorData.InteractEntranceTargetCellApi, System.currentTimeMillis() - this.a, r12.logId);
    L15:
        if (this.b == false) goto L17;
    L24:
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        r13.element = false;
        boolean r6 = ((Boolean) this.d.isAnchor().getValue()).booleanValue();
        final b0 r7 = new b0(r6, r3, r13, this);
        if (r6 == true) goto L27;
    L37:
        r7.run();
        return;
    L27:
        if (XplayGlobalServiceImpl.b == null) goto L37;
        r13.element = true;
        InteractGameContext.Companion r14 = InteractGameContext.Companion;
        InteractGameContext r8 = r14.getContext();
        if (r8 == null) goto L33;
        com.bytedance.live.datacontext.m<Long> r9 = r8.getLastSwitchGameTime();
        if (r9 == null) goto L33;
        r9.setValue(Long.valueOf(System.currentTimeMillis()));
    L33:
        IInteractGameService r15 = (IInteractGameService) jc1.k.f(IInteractGameService.class);
        if (r15 == null) goto L36;
        r15.stopRunningPlugin("switch_game");
    L36:
        r14.a(new XplayGlobalServiceImpl$startXplay$2$1$1(r7));
        return;
    L17:
        if (r3.m.contains(Integer.valueOf(this.c)) == true) goto L24;
        ALogger.i("XplayGlobalService", "startXplay failed, cause: not in supportLiveScene");
        IInteractService r16 = jc1.k.f(IInteractService.class);
        if (r16 == null) goto L23;
        com.bytedance.android.live.liveinteract.utils.n r17 = r16.getLinkMicGameTraceUtils();
        if (r17 == null) goto L23;
        r17.a(true, "/webcast/anchor_mount/interact_entrance/target_cell/", -1, "startXplay failed, cause: not in supportLiveScene");
    L23:
        f2.c("该场景暂不支持此玩法", 0);
        return;
    }
}
