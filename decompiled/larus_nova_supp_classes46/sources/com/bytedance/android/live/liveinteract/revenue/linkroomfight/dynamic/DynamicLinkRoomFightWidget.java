package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.bytedance.android.live.base.model.data.i;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.n;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.FinishReason;
import com.bytedance.android.livesdkapi.depend.model.live.linker.FinishType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sh0.d0;
import vlc.l;
import xh0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/dynamic/DynamicLinkRoomFightWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/b;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicLinkRoomFightWidget extends AbsPlayModeWidget implements com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b, l {
    public static final /* synthetic */ int h = 0;
    public final String a;
    public com.bytedance.android.live.liveinteract.multiscene.a b;
    public o2 c;
    public vlc.d d;
    public LinkRoomFightContext e;
    public final CompositeDisposable f;
    public DynamicRoomBattleRandomMatchVM g;

    public static final class a {
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        return null;
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    public final boolean wq(int r2) {
        if (r2 != 2) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 3) goto L10;
        if (r2 == 5) goto L10;
        return false;
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(16, s1.B(2131916085));
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b
    public final boolean r2() {
        Integer[] r0 = (Integer[]) vm2.d.t4.getValue(null, vm2.d.a[277(0x115, float:3.88E-43)]);
        if (r0 != null) goto L5;
        return false;
    L5:
        return ArraysKt.contains(r0, Integer.valueOf(je0.d.f()));
    }

    public DynamicLinkRoomFightWidget() {
        this.a = "[LinkRoomFight]DynamicLinkRoomFightWidget";
        this.f = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b
    public final boolean A4() {
        if (je0.d.f() != 16) goto L5;
        boolean r0 = true;
    L6:
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L13;
        ih0.b r2 = r1.dynamicService(((Widget) this).dataCenter);
        if (r2 == null) goto L13;
        if (r2.jl("room_battle") != true) goto L13;
        boolean r3 = true;
    L14:
        if (r0 == false) goto L18;
        if (r3 == true) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        r3 = false;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b
    public final boolean isFightShowing() {
        if (je0.d.f() != 16) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L15;
        ih0.b r2 = r1.dynamicService(((Widget) this).dataCenter);
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.jl("room_battle") == true) goto L13;
        return false;
    L15:
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // xh0.b
    public final boolean isOpen() {
        return isFightShowing();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.d = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINKER.getIntType(), this);
    L5:
        vlc.d r1 = this.d;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.LINK_MIC_PROFIT.getIntType(), this);
    L8:
        Pair r2 = com.bytedance.live.datacontext.d.a(DynamicLinkRoomFightWidget$initDataContext$pair$1.INSTANCE);
        LinkRoomFightContext r3 = (LinkRoomFightContext) r2.getFirst();
        r3.getWidget().d(this);
        r3.setDynamic(true);
        com.bytedance.live.datacontext.b.a(r3, com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.a.class);
        this.f.add((Disposable) r2.getSecond());
        this.e = r3;
        IInteractService r4 = (IInteractService) k.f(IInteractService.class);
        if (r4 == null) goto L13;
        ih0.b r5 = r4.dynamicService(((Widget) this).dataCenter);
        if (r5 == null) goto L13;
        r5.E6("room_battle", new b(this));
    L13:
        ne0.e r6 = getStore().d(d0.b, new c(this));
        r6.d(bj0.a.b, new d(this));
        r6.d(bj0.b.b, new e(this));
        r6.d(bj0.d.b, new f());
        Disposable r7 = xs2.b.a().b(jd0.l.class).subscribe(new g(this));
        Intrinsics.checkNotNullParameter(r7, "$this$bind");
        this.f.add(r7);
        DataCenter r8 = ((Widget) this).dataCenter;
        this.g = new DynamicRoomBattleRandomMatchVM(r8, a0.n(r8));
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L7;
        ih0.b r1 = r0.dynamicService(((Widget) this).dataCenter);
        if (r1 == null) goto L7;
        r1.jc("room_battle");
    L7:
        DynamicRoomBattleRandomMatchVM r2 = this.g;
        if (r2 == null) goto L11;
        r2.onDestroy();
    L11:
        if (isFightShowing() == true) goto L13;
    L19:
        this.f.dispose();
        vlc.d r3 = this.d;
        if (r3 == null) goto L23;
        r3.removeMessageListener(this);
        return;
    L23:
        return;
    L13:
        if (gh0.a.d() == false) goto L15;
        g2 r4 = zi0.d.b;
        zi0.d.c(this.c);
        goto L19
    L15:
        if (hd0.c.f().h() == false) goto L17;
        g2 r5 = zi0.d.b;
        zi0.d.f(this.b);
    L17:
        g2 r6 = zi0.d.b;
        zi0.d.g(this.b);
        i0 r7 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c0();
        goto L19
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b
    public final com.bytedance.android.live.liveinteract.multiscene.a L1() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b
    public final DynamicRoomBattleRandomMatchVM S7() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget
    public final boolean handleGuideMessage(ILinkMicGuideMessageBridge r20) {
        Intrinsics.checkNotNullParameter(r20, MultiLinkOpenSource.MESSAGE);
        if (r20.getGuidelineType() != 13) goto L43;
        eb r1 = r20.getPlayModeGuideBubbleContent();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.getPlayMode() != 16) goto L46;
        eb r2 = r20.getPlayModeGuideBubbleContent();
        if (r2 == null) goto L47;
        Intrinsics.checkNotNullParameter(r2, "bubbleContent");
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        if (r2.getEnhanceType() != ILinkMicGuideMessageBridge.BubbleEnhanceType.TEXT_AND_SCHEMA.getValue()) goto L36;
        g2 r4 = zi0.d.b;
        Map r5 = r2.getExtra();
        if (r5 == null) goto L32;
        i0 r6 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r5);
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.d r7 = MultiRevenueDataContext.a.f();
        if (r7 != null) goto L18;
    L20:
        com.bytedance.android.live.liveinteract.revenuebase.a r8 = MultiRevenueDataContext.a.a();
        if (r8 != null) goto L23;
    L25:
        com.bytedance.android.live.profit.vote.e r9 = yt0.c.m();
        if (r9 != null) goto L28;
    L30:
        r5.put("location_from", "bottom");
        goto L32
    L28:
        if (r9.fi() != true) goto L30;
        r5.put("play_mode", "gift_vote");
        goto L30
    L23:
        if (r8.isGameShowing() != true) goto L25;
        r5.put("play_mode", "bomb");
        goto L30
    L18:
        if (r7.isTeamFightShowing() != true) goto L20;
        r5.put("play_mode", "grouppk");
    L32:
        if (r2.getRichText() == null) goto L42;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r r10 = r.g;
        a5 r11 = r2.getRichText();
        Intrinsics.checkNotNull(r11);
        r10.d(r11, null, new y(0.0f), new com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic.a(this, r3, r2));
    L42:
        return true;
    L36:
        if (r2() == false) goto L42;
        r3.element = new pp1.c(r2.getToast(), null, null, 0, null, null, 1001, 0, MapsKt.mapOf(TuplesKt.to("message_type", "room_grouppk")), 0, 7870);
        if (r2.getAnchorShowPosition() != 2) goto L41;
        ((Widget) this).dataCenter.put("cmd_show_self_bubble_on_room_link", (pp1.c) r3.element);
        goto L42
    L41:
        ((Widget) this).dataCenter.put("cmd_show_self_bubble_on_openplatform_behavior", (pp1.c) r3.element);
        goto L42
    L47:
        return false;
    L46:
        return false;
    L43:
        return false;
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof h1) == false) goto L17;
        h1 r7 = (h1) r6;
        if (r7.getType2() != 41) goto L18;
        StringBuilder r0 = new StringBuilder("静音消息更新 linkermap ");
        i r1 = r7.getLinkerCrossRoomUpdateContentExt();
        if (r1 == null) goto L9;
        Map r2 = r1.getLinkerContentMap();
    L10:
        r0.append(r2);
        ALogger.d(LinkRoomFightContext.TAG, r0.toString());
        i r8 = r7.getLinkerCrossRoomUpdateContentExt();
        if (r8 == null) goto L19;
        tc0.c.h().l(r8.getLinkerContentMap());
        LinkRoomFightContext r3 = this.e;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightContext");
    L15:
        r3.getLinkRoomUpdateContent().setValue(r8);
        return;
    L19:
        return;
    L9:
        r2 = null;
        goto L10
    L18:
        return;
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r4) {
        FinishType r1 = (FinishType) r4.get("finishType");
        FinishReason r5 = (FinishReason) r4.get("finishReason");
        if (r1 == null) goto L8;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r1, "finishType");
        Intrinsics.checkNotNullParameter(r5, "finishReason");
        JsonObject r0 = new JsonObject();
        r0.addProperty("finish_type", Integer.valueOf(r1.getValue()));
        r0.addProperty("reason", Integer.valueOf(r5.getValue()));
        r0.addProperty("room_id", Long.valueOf(a0.n(((Widget) this).dataCenter).getId()));
        xq("playmode_request_api_end", r0);
        ALogger.i(this.a, "LinkRoomFight.Request.Finish.Send");
        return;
    L9:
        return;
    }

    public final void xq(String r4, JsonObject r5) {
        ih0.b r0 = ((IInteractService) k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r0 == null) goto L6;
        r0.Dk("room_battle", r4, r5, false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b
    public final void Ui(String r13, JsonObject r14, ih0.h r15) {
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "extra");
        int r0 = r13.hashCode();
        if (r0 == (-302323862)) goto L14;
        if (r0 == (-27011313)) goto L8;
    L50:
        if (r15 == null) goto L53;
        r15.a(UpdateLinkmicStatusResultModel.Code.Success, "use dynamic", null);
        return;
    L53:
        return;
    L8:
        if (r13.equals("show_feedback_reply_room_battle") == false) goto L50;
        com.bytedance.android.live.liveinteract.multiscene.a r16 = this.b;
        int r17 = TalkRoomFeedbackDialog.r;
        boolean r4 = gh0.a.d();
        n r8 = new n("您提前结束本场跨房玩法的原因是？", "感谢您的反馈，我们将致力于提升您的体验", "本次跨房玩法中，你是否遇到了以下问题：");
        LinkRoomFightContext r18 = this.e;
        if (r18 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightContext");
    L12:
        p8.a(TalkRoomFeedbackDialog.a.a(16, r4, "finish", null, true, r8, 16, new zi0.d.a(r16, (com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r18.getFightState().getValue()), 24), ((Widget) this).context);
        goto L50
    L14:
        if (r13.equals("lifecycle") == false) goto L50;
        ALogger.i(this.a, "handleLynxCmd." + r13 + ",extra:" + r14);
        JsonElement r19 = r14.get("kind");
        if (r19 == null) goto L18;
        String r110 = r19.getAsString();
    L19:
        JsonElement r1 = r14.get("lifecycle");
        if (r1 == null) goto L22;
        String r2 = r1.getAsString();
    L23:
        JsonElement r111 = r14.get("is_link_room");
        if (r111 == null) goto L26;
        String r112 = r111.getAsString();
    L27:
        ALogger.i(this.a, "handleLynxCmd.isLinkRoomOpen:" + r112);
        if (r112 == null) goto L31;
        i0 r5 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        TalkRoomLogUtils.s = r112;
    L31:
        if (Intrinsics.areEqual(r110, "link") == false) goto L45;
        if (Intrinsics.areEqual(r2, "onStart") == false) goto L39;
        if (gh0.a.d() == false) goto L37;
        i0 r113 = TalkRoomLogUtils.a;
        LinkedHashMap r114 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r114);
        TalkRoomLogUtils.B0(r114, null, null, 6);
        TalkRoomLogUtils.V0(r114);
        r114.put("play_mode", "link_room");
        r114.put("source", "link_setting_panel");
        r114.put("is_link_room", TalkRoomLogUtils.s);
        zi0.d.b(r114, false);
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r114, new Object[]{IRoom.class});
        goto L50
    L37:
        i0 r115 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.u = System.currentTimeMillis();
        LinkedHashMap r116 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r116);
        TalkRoomLogUtils.B0(r116, null, null, 6);
        TalkRoomLogUtils.V0(r116);
        r116.put("play_mode", "link_room");
        r116.put("is_link_room", TalkRoomLogUtils.s);
        TalkRoomLogUtils.c1(r116);
        zi0.d.b(r116, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r116, new Object[]{IRoom.class});
        goto L50
    L39:
        if (Intrinsics.areEqual(r2, "onEnd") == false) goto L50;
        if (gh0.a.d() == false) goto L43;
        i0 r117 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter("link_setting_panel", "source");
        LinkedHashMap r118 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r118);
        TalkRoomLogUtils.B0(r118, null, null, 6);
        TalkRoomLogUtils.V0(r118);
        r118.put("play_mode", "link_room");
        r118.put("source", "link_setting_panel");
        r118.put("is_link_room", TalkRoomLogUtils.s);
        zi0.d.b(r118, true);
        j0.l().sendLog("livesdk_anchor_playmode_over", r118, new Object[]{IRoom.class});
        goto L50
    L43:
        i0 r119 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c0();
        goto L50
    L45:
        if (Intrinsics.areEqual(r110, PbRequest.SwitchType.PK) == false) goto L50;
        if (Intrinsics.areEqual(r2, "onStart") == false) goto L50;
        if (r112 == null) goto L50;
        i0 r120 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        TalkRoomLogUtils.s = r112;
        goto L50
    L26:
        r112 = null;
        goto L27
    L22:
        r2 = null;
        goto L23
    L18:
        r110 = null;
        goto L19
    }
}
