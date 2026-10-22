package com.bytedance.android.live.liveinteract.linkcast;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.b9;
import com.bytedance.android.livesdk.message.model.c9;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tf0.o;
import uf2.m1;
import uf2.z;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkcast/LinkCastGuestWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "Lrj0/f;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkCastGuestWidget extends MiddlewareRoomWidget implements l, rj0.f {
    public final CompositeDisposable a;
    public final o.a b;

    @Override // rj0.f
    public final boolean isLinkCasting() {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        z5 r2 = r1.getLinkerDetail();
        if (r2 == null) goto L11;
        List r3 = r2.getPlayModes();
        if (r3 == null) goto L11;
        boolean r4 = r3.contains(Long.valueOf(20));
    L12:
        LinkCastGuestDataContext r5 = LinkCastGuestDataContext.Companion.getContext();
        if (r5 == null) goto L17;
        n<s0> r6 = r5.getMLinkCastInfo();
        if (r6 == null) goto L17;
        s0 r7 = (s0) r6.getValue();
    L18:
        if (r7 != null) goto L20;
        if (r4 == true) goto L20;
        return false;
    L20:
        return true;
    L17:
        r7 = null;
    L11:
        r4 = false;
        goto L12
    }

    public final void onCreate() {
        super.onCreate();
        t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new AnonymousClass1(this));
    L7:
        Pair r2 = com.bytedance.live.datacontext.d.a(LinkCastGuestWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((LinkCastGuestDataContext) r2.getFirst(), vf0.b.class);
        this.a.add((Disposable) r2.getSecond());
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r3 == null) goto L12;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L12;
        long r5 = r4.getRoomId();
    L13:
        long r6 = 20;
        m r7 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r7 == null) goto L24;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L24;
        z5 r9 = r8.getLinkerDetail();
        if (r9 == null) goto L24;
        List r10 = r9.getPlayModes();
        if (r10 == null) goto L24;
        if (r10.contains(Long.valueOf(r6)) != true) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L28;
        this.a.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).fetchPlayModeInfo(r5, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this), f.a));
        return;
    L28:
        return;
    L24:
        r11 = false;
    L12:
        r5 = 0;
        goto L13
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new C03041(this));
    L7:
        this.a.dispose();
    }

    public LinkCastGuestWidget(o.a r1) {
        this.b = r1;
        this.a = new CompositeDisposable();
    }

    public final void onMessage(tlc.d r18) {
        if (r18 != null) goto L6;
        return;
    L6:
        if ((r18 instanceof ILinkmicProfitMessage) == false) goto L87;
        ILinkmicProfitMessage r1 = (ILinkmicProfitMessage) r18;
        int r2 = r1.getMsgType();
        z.a r9 = null;
        if (r2 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_InteractiveScreenCastOpen.getValue()) goto L54;
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r3 == null) goto L18;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L18;
        z5 r5 = r4.getLinkerDetail();
        if (r5 == null) goto L18;
        List r6 = r5.getPlayModes();
        if (r6 == null) goto L18;
        List r7 = CollectionsKt.toMutableList(r6);
    L19:
        if (r7 == null) goto L21;
        r7.add(Long.valueOf(20));
    L21:
        m r8 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r8 == null) goto L28;
        IRoom r10 = (IRoom) r8.getValue();
        if (r10 == null) goto L28;
        z5 r11 = r10.getLinkerDetail();
        if (r11 == null) goto L28;
        r11.setPlayModes(r7);
    L28:
        c9 r12 = r1.getInteractScreenCastInfoOpenContent();
        if (r12 == null) goto L31;
        s0 r13 = r12.getScreenCastInfo();
    L32:
        if (r13 == null) goto L45;
        m r14 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).E2();
        if (r14 == null) goto L36;
        r14.setValue(Boolean.TRUE);
    L36:
        LinkCastGuestDataContext r15 = LinkCastGuestDataContext.Companion.getContext();
        if (r15 == null) goto L42;
        n<s0> r16 = r15.getMLinkCastInfo();
        if (r16 == null) goto L42;
        r16.setValue(r13);
    L42:
        if (r13.getItemType() != LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue()) goto L44;
        ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).hideMiniAppExplainCard();
    L44:
        int r17 = d.a;
        int r19 = r13.getItemType();
        String r20 = r13.getAppId();
        Intrinsics.checkNotNull(r20);
        Intrinsics.checkNotNullParameter(r20, "programId");
        JSONObject r110 = new JSONObject();
        r110.put("program_type", r19);
        r110.put("program_id", r20);
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastReceiveOpenData, r110, 0, null, false, 28);
    L45:
        g.b.getClass();
        g.a.g();
        int r21 = d.a;
        Intrinsics.checkNotNullParameter("startLinkCastMsg", "source");
        JSONObject r111 = new JSONObject();
        r111.put("source", "startLinkCastMsg");
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastGuestSetAnchorLayerFit, r111, 0, null, false, 28);
        o.a r22 = this.b;
        if (r22 == null) goto L48;
        r9 = r22.c3(tc0.c.h().f());
    L48:
        if (r9 == null) goto L88;
        m1.b r23 = r9.Y();
        if (r23 == null) goto L52;
        r23.g();
    L52:
        r9.b();
        return;
    L88:
        return;
    L31:
        r13 = null;
    L18:
        r7 = null;
        goto L19
    L54:
        if (r2 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_InteractiveScreenCastClose.getValue()) goto L90;
        m r24 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r24 == null) goto L66;
        IRoom r25 = (IRoom) r24.getValue();
        if (r25 == null) goto L66;
        z5 r26 = r25.getLinkerDetail();
        if (r26 == null) goto L66;
        List r27 = r26.getPlayModes();
        if (r27 == null) goto L66;
        List r28 = CollectionsKt.toMutableList(r27);
        if (r28 == null) goto L66;
        r28.remove(Long.valueOf(20));
    L66:
        b9 r29 = r1.getInteractScreenCastInfoCloseContent();
        Intrinsics.checkNotNull(r29);
        s0 r30 = r29.getScreenCastInfo();
        LinkCastGuestDataContext r31 = LinkCastGuestDataContext.Companion.getContext();
        if (r31 == null) goto L71;
        n<s0> r32 = r31.getMLinkCastInfo();
        if (r32 == null) goto L71;
        r32.setValue(null);
    L71:
        if (r30 != null) goto L73;
    L76:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L91;
        g.a r33 = g.b;
        rj0.l r34 = rj0.l.a.a();
        Intrinsics.checkNotNull(r34);
        boolean r35 = r34.isEngineOn();
        r33.getClass();
        g.a.h(r35);
        int r36 = d.a;
        Intrinsics.checkNotNullParameter("stopLinkCastMsg", "source");
        JSONObject r112 = new JSONObject();
        r112.put("source", "stopLinkCastMsg");
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastGuestResetAnchorLayer, r112, 0, null, false, 28);
        o.a r37 = this.b;
        if (r37 == null) goto L81;
        r9 = r37.c3(tc0.c.h().f());
    L81:
        if (r9 == null) goto L92;
        m1.b r38 = r9.Y();
        if (r38 == null) goto L85;
        r38.g();
    L85:
        r9.b();
        return;
    L92:
        return;
    L91:
        return;
    L73:
        if (r30.getItemType() != LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue()) goto L75;
        ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).showMiniAppExplainCard();
    L75:
        int r39 = d.a;
        int r40 = r30.getItemType();
        String r41 = r30.getAppId();
        Intrinsics.checkNotNull(r41);
        Intrinsics.checkNotNullParameter(r41, "programId");
        JSONObject r113 = new JSONObject();
        r113.put("program_type", r40);
        r113.put("program_id", r41);
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastReceiveCloseData, r113, 0, null, false, 28);
        goto L76
    L90:
        return;
    }
}
