package go1;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceGuestWidget;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.config.ks;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Objects;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements BaseLinkMultiControlWidget.a {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a a;
    public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.e0 b;
    public final /* synthetic */ hh1.v0 c;

    public final void A4() {
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.a;
        j70.f r1 = com.bytedance.android.livesdk.chatroom.ui.framework.f.a;
        r0.vi(com.bytedance.android.livesdk.chatroom.ui.framework.f.S);
    }

    public final View c() {
        gd0.f r0 = ho1.a.b(this.b);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        if (r0 == null) goto L7;
        return r0.c();
    L7:
        yh0.c r1 = ho1.a.m(this.b);
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.c();
    }

    public final View j() {
        yh0.c r0 = ho1.a.m(this.b);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    public final com.bytedance.android.live.ui.c y4() {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L8;
        gd0.f r0 = ho1.a.b(this.b);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y0();
    L8:
        yh0.c r1 = ho1.a.m(this.b);
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.Y0();
    }

    public final void k(Widget r3) {
        this.a.Uj(r3);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((d90.d) this.b).h, "unloadWidget", String.valueOf(r3));
    }

    public final Widget z4(int r12, String r13) {
        boolean r14 = k60.b.a();
        Widget r1 = null;
        if (r12 != 1) goto L5;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 != null) goto L57;
    L59:
        this.a.Ro(2131380990, r1, r14, r14);
        return r1;
    L57:
        if (r15.getInteractAudienceService() == null) goto L59;
        r1 = new InteractAudienceGuestWidget();
        goto L59
    L5:
        if (r12 != 5) goto L7;
        IInteractService r16 = jc1.k.f(IInteractService.class);
        if (r16 == null) goto L51;
        rj0.m r17 = r16.getVideoTalkService();
        if (r17 == null) goto L51;
        r1 = r17.y(new gd0.w());
    L51:
        if (ks.a.getValue().booleanValue() == false) goto L53;
        this.a.Ro(2131392393, r1, false, r14);
        return r1;
    L53:
        this.a.Ro(2131392393, r1, r14, r14);
        return r1;
    L7:
        if (r12 == 9) goto L39;
        switch(r12) {
            case 13: goto L27;
            case 14: goto L18;
            case 15: goto L14;
            case 16: goto L10;
            default: goto L68;
        };
    L10:
        IInteractService r18 = jc1.k.f(IInteractService.class);
        if (r18 == null) goto L13;
        r1 = r18.createMultiLinkDataCenterWidget();
    L13:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(this.a, r1, 4);
        return r1;
    L14:
        IInteractService r19 = jc1.k.f(IInteractService.class);
        if (r19 == null) goto L17;
        r1 = r19.createMultiLinkUIWidget();
    L17:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131380070, r1, false, 8);
        return r1;
    L18:
        IRadioService r110 = jc1.k.f(IRadioService.class);
        if (r110 == null) goto L21;
        Widget r111 = r110.createRadioWidget();
    L23:
        if ((r111 instanceof Widget) == false) goto L26;
        r1 = r111;
    L26:
        Widget r2 = r1;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131383618, r2, false, 8);
        return r2;
    L21:
        r111 = null;
        goto L23
    L27:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r112 = this.b;
        if (r112 == null) goto L30;
        IRoom r6 = d90.c.q(r112);
    L31:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r113 = this.b;
        if (r113 == null) goto L34;
        LiveMode r7 = d90.c.o(r113);
    L35:
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L38;
        r1 = r3.createLiveThemeBgUIWidget(false, null, r6, r7, null, null, null);
    L38:
        Objects.toString(r1);
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131375543, r1, false, 8);
        return r1;
    L34:
        r7 = null;
        goto L35
    L30:
        r6 = null;
        goto L31
    L68:
        return null;
    L39:
        IInteractService r114 = jc1.k.f(IInteractService.class);
        if (r114 != null) goto L42;
    L44:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131381836, r1, false, 8);
        return r1;
    L42:
        if (r114.getProfileCardOutService() == null) goto L44;
        r1 = new PaidProfileCardWidget();
        goto L44
    }

    public a0(com.bytedance.android.livesdk.chatroom.ui.framework.a r1, com.bytedance.android.livesdk.widgetdescriptor.e0 r2, hh1.v0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
