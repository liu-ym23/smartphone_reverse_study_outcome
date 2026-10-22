package com.bytedance.android.live.multilink.voicechat.impl.widget;

import android.content.Context;
import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkVoiceChatAnchorPresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l {
    public int e;
    public String f;
    public boolean g;
    public final com.bytedance.android.livesdk.chatroom.u h;
    public final CompositeDisposable i;

    public interface IView extends IWidget {
        boolean D4(int r1, f6 r2);

        void f3(h1 r1);

        void g9(h1 r1);

        Context getContext();

        void t6(h1 r1);

        void ug(h1 r1);
    }

    public final void detachView() {
        this.i.dispose();
        super.detachView();
    }

    public MultiLinkVoiceChatAnchorPresenter(com.bytedance.android.livesdk.chatroom.u r2) {
        this.g = true;
        this.i = new CompositeDisposable();
        this.h = r2;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.s().getValue()).a().subscribe(new b());
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r2) {
        super.c0(r2);
        vlc.d r3 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if (r3 == null) goto L6;
        r3.addMessageListener(MessageType.LINK_MIC.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINKER.getWsMethod(), this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getWsMethod(), this);
        return;
    }

    public final void onMessage(tlc.d r6) {
        if (((q46.b) this).a != null) goto L6;
        return;
    L6:
        if ((r6 instanceof ILinkMicGuideMessageBridge) == false) goto L25;
        ILinkMicGuideMessageBridge r7 = (ILinkMicGuideMessageBridge) r6;
        if (r7.getGuidelineType() == 0) goto L10;
        return;
    L10:
        if (this.g == true) goto L12;
        jy0.b.c("voice_chat", "intercept guide since message too often", null, 4);
    L17:
        boolean r0 = true;
    L19:
        if (r0 == false) goto L22;
        return;
    L22:
        if (((q46.b) this).a.D4(r7.getAudienceLimit(), r7.getAnchorGuideInfo()) == false) goto L48;
        this.g = false;
        ((ObservableSubscribeProxy) Observable.timer(vm2.c.a().anchorRateLimit, TimeUnit.SECONDS).as(d0())).subscribe(new a(this));
        return;
    L48:
        return;
    L12:
        com.bytedance.android.livesdk.chatroom.u r1 = this.h;
        if (r1 != null) goto L15;
    L18:
        r0 = false;
        goto L19
    L15:
        if (((Boolean) r1.I1().getValue()).booleanValue() == false) goto L18;
        jy0.b.c("voice_chat", "intercept guide since in ktv mode", null, 4);
        goto L17
    L25:
        if ((r6 instanceof h1) == false) goto L35;
        h1 r8 = (h1) r6;
        int r2 = r8.getMType();
        if (r2 == 70) goto L33;
        switch(r2) {
            case 36: goto L32;
            case 37: goto L31;
            case 38: goto L30;
            default: goto L57;
        };
    L30:
        ((q46.b) this).a.ug(r8);
        return;
    L31:
        ((q46.b) this).a.f3(r8);
        return;
    L32:
        ((q46.b) this).a.t6(r8);
        return;
    L57:
        return;
    L33:
        ((q46.b) this).a.g9(r8);
        return;
    L35:
        if ((r6 instanceof ILinkmicEnlargeGuestMessage) == false) goto L54;
        ILinkmicEnlargeGuestMessage r9 = (ILinkmicEnlargeGuestMessage) r6;
        if (r9.getTurn_on_content() == null) goto L42;
        this.e = r9.getTurn_on_content().getSource();
        this.f = r9.getTurn_on_content().getTrackingData();
        com.bytedance.android.livesdk.chatroom.u r3 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r3 == null) goto L42;
        ((LivePlayModeLogContext) r3.J().getValue()).addPlayMode(13);
    L42:
        if (r9.getTurn_off_content() == null) goto L55;
        com.bytedance.android.livesdk.chatroom.u r4 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        this.f = r9.getTurn_off_content().getTrackingData();
        if (r4 == null) goto L56;
        ((LivePlayModeLogContext) r4.J().getValue()).removePlayMode(13);
        return;
    L56:
        return;
    L55:
        return;
    }
}
