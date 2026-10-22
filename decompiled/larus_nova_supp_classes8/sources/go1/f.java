package go1;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.AnchorInteractionData;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceAnchorWidget;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceGuestWidget;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements BaseLinkMultiControlWidget.a {
    public final /* synthetic */ g a;
    public final /* synthetic */ hh1.v0 b;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.c d;
    public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.e0 e;

    public final void A4() {
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.c;
        j70.f r1 = com.bytedance.android.livesdk.chatroom.ui.framework.f.a;
        r0.vi(com.bytedance.android.livesdk.chatroom.ui.framework.f.S);
    }

    public final View c() {
        gd0.f r0 = ho1.a.b(this.e);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        if (r0 == null) goto L7;
        return r0.c();
    L7:
        yh0.c r1 = ho1.a.m(this.e);
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.c();
    }

    public final View j() {
        yh0.c r0 = ho1.a.m(this.e);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    public final com.bytedance.android.live.ui.c y4() {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L8;
        gd0.f r0 = ho1.a.b(this.e);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y0();
    L8:
        yh0.c r1 = ho1.a.m(this.e);
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.Y0();
    }

    public final void k(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.c.Uj(r2);
    }

    public final Widget z4(int r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "source");
        Widget r2 = null;
        if (r12 != 0) goto L5;
        IInteractService r14 = jc1.k.f(IInteractService.class);
        if (r14 != null) goto L81;
    L83:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131380990, r2, false, 8);
        return r2;
    L81:
        if (r14.getInteractAudienceService() == null) goto L83;
        r2 = new InteractAudienceAnchorWidget(this.b, tc0.c.h());
        goto L83
    L5:
        if (r12 != 1) goto L7;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 != null) goto L75;
    L77:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131380990, r2, false, 8);
        return r2;
    L75:
        if (r15.getInteractAudienceService() == null) goto L77;
        r2 = new InteractAudienceGuestWidget();
        goto L77
    L7:
        if (r12 != 3) goto L9;
        FragmentManager r16 = this.d.getChildFragmentManager();
        com.bytedance.android.live.pushstream.d r3 = this.d.getLiveStream();
        hh1.w0 r4 = this.d.J1();
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L71;
        qd0.a r6 = r5.getAudioTalkService();
        if (r6 == null) goto L71;
        r2 = r6.w(r16, r3, r4);
    L71:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131380990, r2, false, 8);
        return r2;
    L9:
        if (r12 != 5) goto L11;
        com.bytedance.android.live.pushstream.d r17 = this.d.getLiveStream();
        g r18 = this.a;
        RoomContext r7 = this.e.b();
        r18.getClass();
        if (r7 == null) goto L56;
        com.bytedance.live.datacontext.j r19 = r7.getAnchorRoomScopeViewModel();
        if (r19 == null) goto L56;
        nz.l r110 = (nz.l) r19.getValue();
        if (r110 == null) goto L56;
        nz.w r111 = (nz.w) r110.a();
    L57:
        nz.f0.d r8 = nz.f0.d.b;
        int r9 = nz.a.a.a;
        new AnchorInteractionData("", 5L, 20L, "");
        if (r111 == null) goto L60;
        int r10 = nz.b.a.a;
        r111.a();
    L60:
        IInteractService r112 = jc1.k.f(IInteractService.class);
        if (r112 == null) goto L65;
        rj0.m r113 = r112.getVideoTalkService();
        if (r113 == null) goto L65;
        r2 = r113.g(this.b, r17);
    L65:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131392393, r2, false, 8);
        return r2;
    L56:
        r111 = null;
        goto L57
    L11:
        if (r12 == 9) goto L43;
        switch(r12) {
            case 13: goto L31;
            case 14: goto L22;
            case 15: goto L18;
            case 16: goto L14;
            default: goto L93;
        };
    L14:
        IInteractService r114 = jc1.k.f(IInteractService.class);
        if (r114 == null) goto L17;
        r2 = r114.createMultiLinkDataCenterWidget();
    L17:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(this.c, r2, 4);
        return r2;
    L18:
        IInteractService r115 = jc1.k.f(IInteractService.class);
        if (r115 == null) goto L21;
        r2 = r115.createMultiLinkUIWidget();
    L21:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131380070, r2, false, 8);
        return r2;
    L22:
        IRadioService r116 = jc1.k.f(IRadioService.class);
        if (r116 == null) goto L25;
        Widget r117 = r116.createRadioWidget();
    L27:
        if ((r117 instanceof Widget) == false) goto L30;
        r2 = r117;
    L30:
        Widget r11 = r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131383618, r11, false, 8);
        return r11;
    L25:
        r117 = null;
        goto L27
    L31:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r118 = this.e;
        if (r118 == null) goto L34;
        IRoom r20 = d90.c.q(r118);
    L35:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r119 = this.e;
        if (r119 == null) goto L38;
        LiveMode r21 = d90.c.o(r119);
    L39:
        IInteractService r22 = jc1.k.f(IInteractService.class);
        if (r22 == null) goto L42;
        r2 = r22.createLiveThemeBgUIWidget(false, null, r20, r21, null, null, null);
    L42:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131375543, r2, false, 8);
        return r2;
    L38:
        r21 = null;
        goto L39
    L34:
        r20 = null;
        goto L35
    L93:
        return null;
    L43:
        IInteractService r120 = jc1.k.f(IInteractService.class);
        if (r120 != null) goto L46;
    L48:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131381836, r2, false, 8);
        return r2;
    L46:
        if (r120.getProfileCardOutService() == null) goto L48;
        r2 = new PaidProfileCardWidget();
        goto L48
    }

    public f(g r1, hh1.v0 r2, com.bytedance.android.livesdk.chatroom.ui.framework.a r3, com.bytedance.android.livesdk.chatroom.ui.framework.c r4, com.bytedance.android.livesdk.widgetdescriptor.e0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
