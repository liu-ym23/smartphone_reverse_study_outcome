package go1;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceAnchorWidget;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceGuestWidget;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.config.ks;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z implements BaseLinkMultiControlWidget.a {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ hh1.v0 b;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.e0 d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.c f;

    public static final class a implements gd0.p {
        public final /* synthetic */ z a;
        public final /* synthetic */ String b;

        public final void a(Widget r3) {
            Intrinsics.checkNotNullParameter(r3, "selfWidget");
            this.a.a.getClass();
            if (MultiLinkLoadWidgetUtils.f() == true) goto L5;
            return;
        L5:
            if ((r3 instanceof qd0.d) == true) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual("fast_init_mode", this.b) == false) goto L9;
            Room r0 = d90.c.q(this.a.d);
            Intrinsics.checkNotNull(r0);
            ((qd0.d) r3).h0(r0);
            return;
        L9:
            Room r1 = d90.c.q(this.a.d);
            Intrinsics.checkNotNull(r1);
            ((qd0.d) r3).U0(r1);
        }

        public a(z r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements gd0.p {
        public final /* synthetic */ z a;
        public final /* synthetic */ String b;

        public final void a(Widget r3) {
            Intrinsics.checkNotNullParameter(r3, "selfWidget");
            this.a.a.getClass();
            if (MultiLinkLoadWidgetUtils.f() == true) goto L5;
            return;
        L5:
            if ((r3 instanceof rj0.o) == true) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual("fast_init_mode", this.b) == false) goto L9;
            Room r0 = d90.c.q(this.a.d);
            Intrinsics.checkNotNull(r0);
            ((rj0.o) r3).h0(r0);
            return;
        L9:
            Room r1 = d90.c.q(this.a.d);
            Intrinsics.checkNotNull(r1);
            ((rj0.o) r3).U0(r1);
        }

        public b(z r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void A4() {
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.c;
        j70.f r1 = com.bytedance.android.livesdk.chatroom.ui.framework.f.a;
        r0.vi(com.bytedance.android.livesdk.chatroom.ui.framework.f.S);
    }

    public final View c() {
        gd0.f r0 = ho1.a.b(this.d);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        if (r0 == null) goto L7;
        return r0.c();
    L7:
        yh0.c r1 = ho1.a.m(this.d);
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.c();
    }

    public final View j() {
        yh0.c r0 = ho1.a.m(this.d);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    public final com.bytedance.android.live.ui.c y4() {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L8;
        gd0.f r0 = ho1.a.b(this.d);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y0();
    L8:
        yh0.c r1 = ho1.a.m(this.d);
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.Y0();
    }

    public final void k(Widget r3) {
        this.c.Uj(r3);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((d90.d) this.d).h, "unloadWidget", String.valueOf(r3));
    }

    public final Widget z4(int r12, String r13) {
        boolean r0 = k60.b.a();
        Widget r2 = null;
        if (r12 != 0) goto L5;
        IInteractService r14 = jc1.k.f(IInteractService.class);
        if (r14 != null) goto L74;
    L76:
        this.c.Ro(2131380990, r2, r0, r0);
        return r2;
    L74:
        if (r14.getInteractAudienceService() == null) goto L76;
        r2 = new InteractAudienceAnchorWidget(this.b, tc0.c.h());
        goto L76
    L5:
        if (r12 != 1) goto L7;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 != null) goto L68;
    L70:
        this.c.Ro(2131380990, r2, r0, r0);
        return r2;
    L68:
        if (r15.getInteractAudienceService() == null) goto L70;
        r2 = new InteractAudienceGuestWidget();
        goto L70
    L7:
        if (r12 != 3) goto L9;
        Lazy r16 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((d90.d) this.d).h, "loadVoiceChatRoomGuestContainerWidget", "isAsyncLoad = " + this.e);
        hh1.w0 r17 = this.f.J1();
        a r1 = new a(this, r13);
        IInteractService r18 = jc1.k.f(IInteractService.class);
        if (r18 == null) goto L64;
        qd0.a r19 = r18.getAudioTalkService();
        if (r19 == null) goto L64;
        r2 = r19.createVoiceChatRoomGuestWidget(r17, r1);
    L64:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r110 = this.c;
        boolean r111 = this.e;
        r110.Ro(2131380990, r2, r111, r111);
        MultiLinkLoadWidgetUtils.n(((d90.d) this.d).h, "loadVoiceChatRoomGuestContainerWidget", "call mWidgetManager.load finish.");
        return r2;
    L9:
        if (r12 != 5) goto L11;
        Lazy r112 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((d90.d) this.d).h, "loadVideoTalkRoomGuestWidget", "isAsyncLoad = " + this.e + ", source = " + r13);
        b r113 = new b(this, r13);
        IInteractService r114 = jc1.k.f(IInteractService.class);
        if (r114 == null) goto L55;
        rj0.m r115 = r114.getVideoTalkService();
        if (r115 == null) goto L55;
        r2 = r115.y(r113);
    L55:
        if (ks.a.getValue().booleanValue() == false) goto L57;
        this.c.Ro(2131392393, r2, false, this.e);
    L58:
        MultiLinkLoadWidgetUtils.n(((d90.d) this.d).h, "loadVideoTalkRoomGuestWidget", "call mWidgetManager.load finish.");
        return r2;
    L57:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r116 = this.c;
        boolean r3 = this.e;
        r116.Ro(2131392393, r2, r3, r3);
        goto L58
    L11:
        if (r12 == 9) goto L43;
        switch(r12) {
            case 13: goto L31;
            case 14: goto L22;
            case 15: goto L18;
            case 16: goto L14;
            default: goto L86;
        };
    L14:
        IInteractService r117 = jc1.k.f(IInteractService.class);
        if (r117 == null) goto L17;
        r2 = r117.createMultiLinkDataCenterWidget();
    L17:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(this.c, r2, 4);
        return r2;
    L18:
        IInteractService r118 = jc1.k.f(IInteractService.class);
        if (r118 == null) goto L21;
        r2 = r118.createMultiLinkUIWidget();
    L21:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131380070, r2, false, 8);
        return r2;
    L22:
        IRadioService r119 = jc1.k.f(IRadioService.class);
        if (r119 == null) goto L25;
        Widget r120 = r119.createRadioWidget();
    L27:
        if ((r120 instanceof Widget) == false) goto L30;
        r2 = r120;
    L30:
        Widget r4 = r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131383618, r4, false, 8);
        return r4;
    L25:
        r120 = null;
        goto L27
    L31:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r121 = this.d;
        if (r121 == null) goto L34;
        IRoom r6 = d90.c.q(r121);
    L35:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r122 = this.d;
        if (r122 == null) goto L38;
        LiveMode r7 = d90.c.o(r122);
    L39:
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L42;
        r2 = r5.createLiveThemeBgUIWidget(false, null, r6, r7, null, null, null);
    L42:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131375543, r2, false, 8);
        return r2;
    L38:
        r7 = null;
        goto L39
    L34:
        r6 = null;
        goto L35
    L86:
        return null;
    L43:
        IInteractService r123 = jc1.k.f(IInteractService.class);
        if (r123 != null) goto L46;
    L48:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.c, 2131381836, r2, false, 8);
        return r2;
    L46:
        if (r123.getProfileCardOutService() == null) goto L48;
        r2 = new PaidProfileCardWidget();
        goto L48
    }

    public z(b0 r1, hh1.v0 r2, com.bytedance.android.livesdk.chatroom.ui.framework.a r3, com.bytedance.android.livesdk.widgetdescriptor.e0 r4, boolean r5, com.bytedance.android.livesdk.chatroom.ui.framework.c r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
