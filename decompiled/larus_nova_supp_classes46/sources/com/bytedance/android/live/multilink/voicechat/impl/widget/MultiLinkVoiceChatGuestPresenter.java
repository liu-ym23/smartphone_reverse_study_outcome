package com.bytedance.android.live.multilink.voicechat.impl.widget;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContentKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkVoiceChatGuestPresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l {
    public int e;
    public int f;
    public String g;
    public final IRoom h;
    public final com.bytedance.android.livesdk.chatroom.u i;
    public boolean j;
    public final DataCenter k;
    public final CompositeDisposable l;
    public final c m;

    public interface IView extends IWidget {
        boolean D4(int r1, f6 r2);

        void V1();

        void f3(h1 r1);

        void g9(h1 r1);

        Context getContext();

        void q(int r1);

        bg6.a s2();

        void t6(h1 r1);
    }

    public final void detachView() {
        this.k.removeObserver("cmd_interact_state_change", this.m);
        this.l.dispose();
        super.detachView();
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r3) {
        super.c0(r3);
        vlc.d r4 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if (r4 == null) goto L5;
        r4.addMessageListener(MessageType.LINK_MIC.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINKER.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.CONTROL.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getWsMethod(), this);
    L5:
        this.k.observeForever("cmd_interact_state_change", this.m);
    }

    public final void onMessage(tlc.d r12) {
        if (((q46.b) this).a != null) goto L5;
        return;
    L5:
        boolean r4 = true;
        if ((r12 instanceof ILinkMicGuideMessageBridge) == false) goto L43;
        ILinkMicGuideMessageBridge r13 = (ILinkMicGuideMessageBridge) r12;
        if (r13.getGuidelineType() == 0) goto L10;
        return;
    L10:
        if (vm2.c.i() == true) goto L13;
    L37:
        if (r4 == false) goto L40;
        return;
    L40:
        if (((q46.b) this).a.D4(r13.getAudienceLimit(), r13.getAnchorGuideInfo()) == false) goto L151;
        this.j = false;
        ((ObservableSubscribeProxy) Observable.timer(vm2.c.a().audienceRateLimit, TimeUnit.SECONDS).as(d0())).subscribe(new d(this));
        return;
    L151:
        return;
    L13:
        if (this.j == true) goto L15;
        jy0.b.c("voice_chat", "intercept guide since message too often", null, 4);
        goto L37
    L15:
        com.bytedance.android.livesdk.chatroom.u r0 = this.i;
        if (r0 != null) goto L18;
    L20:
        IView r1 = ((q46.b) this).a;
        if (r1 != null) goto L23;
    L25:
        boolean r2 = false;
    L26:
        if (r2 == true) goto L37;
        if (r13.getAnchorGuideInfo() != null) goto L31;
    L36:
        jy0.b.c("voice_chat", "intercept guide since message not complete", null, 4);
        goto L37
    L31:
        if (r13.getAnchorGuideInfo().getInfoItems() == null) goto L36;
        if (r13.getAnchorGuideInfo().getInfoItems().size() != 3) goto L36;
        r4 = false;
        goto L37
    L23:
        if (r1.s2() == null) goto L25;
        r2 = ((q46.b) this).a.s2().Ig();
        goto L26
    L18:
        if (((Boolean) r0.I1().getValue()).booleanValue() == false) goto L20;
        jy0.b.c("voice_chat", "intercept guide since in ktv mode", null, 4);
        goto L37
    L43:
        if ((r12 instanceof z0) == false) goto L82;
        z0 r14 = (z0) r12;
        long r7 = r14.getMessageId2();
        int r3 = (int) r14.getType2();
        if (r3 == 10) goto L61;
        if (r3 == 11) goto L61;
        if (r3 != 13) goto L50;
        com.bytedance.android.live.liveinteract.plantform.utils.x.b(r7, r14.getReplyType());
        InteractLinkFullLinkMonitor.K(r14);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.o0(r14);
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == true) goto L55;
        return;
    L55:
        if (r14.getReplyType() != 1) goto L57;
        return;
    L57:
        if (TextUtils.isEmpty(r14.getReplyPrompts()) == true) goto L59;
        f2.c(r14.getReplyPrompts(), 0);
        return;
    L59:
        f2.b(2131919242, 0);
        return;
    L50:
        if (r3 == 16) goto L61;
        return;
    L61:
        if (vm2.c.f() == true) goto L64;
        return;
    L64:
        if (r14.getToUserId().equals(jc1.k.f(IMiddlewareUserService.class).user().n()) == true) goto L66;
        return;
    L66:
        if (r14.getType2() != 10) goto L76;
        if (TextUtils.equals(String.valueOf(r14.getFromUserIdStr()), jc1.k.f(IMiddlewareUserService.class).user().n()) == true) goto L74;
        IView r5 = ((q46.b) this).a;
        if (r5 == null) goto L74;
        if (r5.s2() == null) goto L74;
        ((q46.b) this).a.s2().Z(r14.getToUserId(), r14.getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_MESSAGE);
    L74:
        com.bytedance.android.live.liveinteract.linksecurity.c r15 = com.bytedance.android.live.liveinteract.linksecurity.c.g;
        r15.getClass();
        com.bytedance.android.live.liveinteract.linksecurity.c.m(r15);
        ((q46.b) this).a.q(2);
        return;
    L76:
        if (r14.getType2() != 11) goto L79;
        ((q46.b) this).a.q(0);
        return;
    L79:
        if (r14.getType2() != 16) goto L160;
        ((q46.b) this).a.q(3);
        return;
    L160:
        return;
    L82:
        if ((r12 instanceof h1) == false) goto L133;
        h1 r6 = (h1) r12;
        int r8 = (int) r6.getType2();
        if (r8 == 12) goto L109;
        if (r8 == 56) goto L98;
        if (r8 != 70) goto L90;
        ((q46.b) this).a.g9(r6);
        return;
    L90:
        if (r8 != 36) goto L92;
        ((q46.b) this).a.t6(r6);
        return;
    L92:
        if (r8 != 37) goto L179;
        ((q46.b) this).a.f3(r6);
        return;
    L179:
        return;
    L98:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 1) goto L165;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L102;
        IVoiceChatGuestService.a.a().cancelApply(null, true, "leave_from_remove_apply_msg");
    L102:
        if (r12 == null) goto L166;
        LinkerRemoveWaitingUserContent r16 = ((h1) r12).getLinkerRemoveWaitingUserContent();
        if (r16 != null) goto L106;
        return;
    L106:
        if (r16.getWaitingUserToast() == null) goto L168;
        f2.c(r16.getWaitingUserToast(), 0);
        return;
    L168:
        return;
    L166:
        return;
    L165:
        return;
    L109:
        if (vm2.c.f() == true) goto L180;
        ILinkerUpdateUserContent r17 = r6.getMUpdateUser();
        if (r17 != null) goto L114;
        return;
    L114:
        if (ILinkerUpdateUserContentKt.isSilenceStatusUpdate(r17) == true) goto L117;
        return;
    L117:
        if (r6.getMUpdateUser() != null) goto L119;
        return;
    L119:
        if (Objects.equals(ILinkerUpdateUserContentKt.getToUserIdString(r17), jc1.k.f(IMiddlewareUserService.class).user().n()) == true) goto L121;
        return;
    L121:
        if (Objects.equals(ILinkerUpdateUserContentKt.getFromUserIdString(r17), ILinkerUpdateUserContentKt.getToUserIdString(r17)) == true) goto L181;
        int r9 = ILinkerUpdateUserContentKt.getSilenceStatus(r17);
        if (r9 != 2) goto L130;
        IView r10 = ((q46.b) this).a;
        if (r10 == null) goto L130;
        if (r10.s2() == null) goto L130;
        ((q46.b) this).a.s2().Z(ILinkerUpdateUserContentKt.getToUserIdString(r17), r6.getMUpdateUser().getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_MESSAGE);
    L130:
        ((q46.b) this).a.q(r9);
        return;
    L181:
        return;
    L180:
        return;
    L133:
        if ((r12 instanceof ILinkmicEnlargeGuestMessage) == false) goto L173;
        ILinkmicEnlargeGuestMessage r18 = (ILinkmicEnlargeGuestMessage) r12;
        if (r18.getTurn_on_content() == null) goto L142;
        this.f = r18.getTurn_on_content().getSource();
        this.g = r18.getTurn_on_content().getTrackingData();
        com.bytedance.android.livesdk.chatroom.u r11 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r11 == null) goto L142;
        if (r11.J() == null) goto L142;
        ((LivePlayModeLogContext) r11.J().getValue()).addPlayMode(13);
    L142:
        if (r18.getTurn_off_content() == null) goto L174;
        com.bytedance.android.livesdk.chatroom.u r19 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r19 != null) goto L146;
        return;
    L146:
        if (r19.J() == null) goto L176;
        ((LivePlayModeLogContext) r19.J().getValue()).removePlayMode(13);
        this.g = r18.getTurn_off_content().getTrackingData();
        return;
    L176:
        return;
    L174:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.multilink.voicechat.impl.widget.c] */
    public MultiLinkVoiceChatGuestPresenter(IRoom r3, DataCenter r4, com.bytedance.android.livesdk.chatroom.u r5) {
        this.e = 200;
        this.j = true;
        this.l = new CompositeDisposable();
        com.bytedance.android.livesdk.a.h.getClass();
        com.bytedance.android.livesdk.a r0 = com.bytedance.android.livesdk.a.a.b("ktv_pre_linkmic_warning");
        this.m = new c(this);
        this.h = r3;
        this.k = r4;
        this.i = r5;
        ((IInteractService) jc1.k.f(IInteractService.class)).addBusinessDegradeStrategy(r0);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getLinkerDetail() == null) goto L9;
        this.f = (int) r3.getLinkerDetail().getEnlargeGuestTurnOnSource();
        return;
    }
}
