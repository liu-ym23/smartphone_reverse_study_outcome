package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import rj0.l;
import sh0.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkCommonGuestMicSeatBasicLayer extends g {
    public static final /* synthetic */ int u = 0;
    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b s;
    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d t;

    @Override // jg0.c
    public int o() {
        return 2131566596;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void C() {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        MultiLinkGuestViewBinder.a r1 = this.e;
        ch0.e r2 = null;
        if (r1 == null) goto L5;
        ch0.e r3 = r1.k;
    L6:
        boolean r4 = false;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r3, null) == false) goto L20;
        HSImageView r5 = this.f;
        if (r5 == null) goto L11;
        r5.setVisibility(8);
    L11:
        ConstraintLayout r6 = this.g;
        if (r6 == null) goto L14;
        r6.setVisibility(8);
    L14:
        MultiLinkGuestViewBinder.a r7 = this.e;
        if (r7 == null) goto L19;
        xg0.a r8 = this.c;
        if (r8 == null) goto L19;
        r8.m3(r7, true);
    L19:
        F();
    L31:
        MultiLinkGuestViewBinder.a r9 = this.e;
        if (r9 == null) goto L38;
        ch0.e r10 = r9.k;
        if (r10 == null) goto L38;
        if (ch0.f.b(r10) != true) goto L38;
        r4 = true;
    L38:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r11 = this.s;
        if (r11 == null) goto L45;
        MultiLinkGuestViewBinder.a r12 = this.e;
        if (r12 == null) goto L43;
        r2 = r12.k;
    L43:
        r11.d(r4, r2);
        return;
    L45:
        return;
    L20:
        HSImageView r13 = this.f;
        if (r13 == null) goto L23;
        r13.setVisibility(0);
    L23:
        ConstraintLayout r14 = this.g;
        if (r14 == null) goto L26;
        r14.setVisibility(0);
    L26:
        MultiLinkGuestViewBinder.a r15 = this.e;
        if (r15 == null) goto L31;
        xg0.a r16 = this.c;
        if (r16 == null) goto L31;
        r16.m3(r15, false);
        goto L31
    L5:
        r3 = null;
        goto L6
    }

    public void I() {
        HSImageView r0 = this.f;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        ConstraintLayout r1 = this.g;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    }

    public void J() {
        AnchorPauseTipsView r0 = this.j;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        TextView r1 = this.k;
        if (r1 == null) goto L8;
        r1.setText(s1.B(2131918663));
    L8:
        MultiLinkMicSeatGiftIconElement r2 = this.m;
        if (r2 == null) goto L11;
        r2.e(4);
    L11:
        HSImageView r3 = this.f;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        ConstraintLayout r4 = this.g;
        if (r4 == null) goto L18;
        r4.setVisibility(0);
        return;
    }

    public void K() {
        TextView r0 = this.k;
        if (r0 == null) goto L15;
        MultiLinkGuestViewBinder.a r2 = this.e;
        if (r2 == null) goto L13;
        ch0.e r3 = r2.k;
        if (r3 == null) goto L13;
        ILinkPlayerInfoBridge r4 = r3.a;
        if (r4 == null) goto L13;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L13;
        String r6 = r5.getRealNickName();
    L14:
        r0.setText(r6);
    L13:
        r6 = null;
    L15:
        AnchorPauseTipsView r1 = this.j;
        if (r1 == null) goto L18;
        r1.setVisibility(8);
    L18:
        MultiLinkGuestViewBinder.a r7 = this.e;
        if (r7 == null) goto L43;
        ch0.e r8 = r7.k;
        if (r8 == null) goto L43;
        ILinkPlayerInfoBridge r9 = r8.a;
        if (r9 == null) goto L43;
        if (r9.isOpenSendGift() != true) goto L43;
        if (GuestBattleContext.Companion.e() == true) goto L43;
        if (SelfDisciplineContext.Companion.e() == true) goto L43;
        if (ThemedCompetitionContext.Companion.g() == true) goto L43;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r10 = MultiRevenueDataContext.a.b();
        if (r10 != null) goto L35;
    L40:
        MultiLinkMicSeatGiftIconElement r11 = this.m;
        if (r11 == null) goto L43;
        r11.e(0);
        goto L43
    L35:
        if (r10.isFightShowing() != true) goto L40;
        com.bytedance.android.live.liveinteract.revenuebase.b r12 = MultiRevenueDataContext.a.b();
        if (r12 == null) goto L43;
        if (r12.A4() == true) goto L40;
    L43:
        MultiLinkFrequencyOptConfig r13 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        MultiLinkGuestViewBinder.a r14 = this.e;
        if (r14 == null) goto L46;
        ch0.e r15 = r14.k;
    L48:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r15, null) == false) goto L55;
        HSImageView r16 = this.f;
        if (r16 == null) goto L52;
        r16.setVisibility(8);
    L52:
        ConstraintLayout r17 = this.g;
        if (r17 == null) goto L62;
        r17.setVisibility(8);
        return;
    L62:
        return;
    L55:
        HSImageView r18 = this.f;
        if (r18 == null) goto L58;
        r18.setVisibility(0);
    L58:
        ConstraintLayout r19 = this.g;
        if (r19 == null) goto L64;
        r19.setVisibility(0);
        return;
    L64:
        return;
    L46:
        r15 = null;
        goto L48
    }

    public void M() {
        AnchorPauseTipsView r0 = this.j;
        if (r0 == null) goto L22;
        r0.R5();
        Integer r1 = je0.d.h();
        if (r1 != null) goto L8;
    L9:
        if (r1 != null) goto L12;
    L13:
        if (r1 != null) goto L16;
    L18:
        float r2 = 10.0f;
    L20:
        AnchorPauseTipsView.U5(r0, r2);
        r0.c = true;
        r0.d = 0;
        r0.requestLayout();
        return;
    L16:
        if (r1.intValue() != 109) goto L18;
    L19:
        r2 = 5.0f;
        goto L20
    L12:
        if (r1.intValue() == 111) goto L19;
    L8:
        if (r1.intValue() == 109) goto L19;
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r0 = this.s;
        if (r0 == null) goto L16;
        MultiLinkGuestViewBinder.a r1 = this.e;
        if (r1 == null) goto L13;
        ch0.e r2 = r1.k;
        if (r2 == null) goto L13;
        ILinkPlayerInfoBridge r3 = r2.a;
        if (r3 == null) goto L13;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L13;
        String r5 = r4.getIdString();
    L14:
        r0.b(r5);
        return;
    L13:
        r5 = null;
        goto L14
    }

    @Override // jg0.c
    public String p() {
        return VerticalNitaInflate.Tag.MultiLinkCommonGuestMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b w() {
        return this.s;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void E(boolean r8) {
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L71;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L72;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L74;
        boolean r3 = false;
        if (r2.getSilenceStatus() == 0) goto L12;
        boolean r4 = true;
    L13:
        IBaseUser r5 = r2.getUser();
        ch0.e r6 = null;
        if (r5 == null) goto L16;
        String r7 = r5.getIdString();
    L17:
        m r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r9 == null) goto L22;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L22;
        String r11 = r10.getOwnerUserIdString();
    L23:
        boolean r12 = Intrinsics.areEqual(r7, r11);
        if (je0.d.D() == true) goto L47;
        l.n2.getClass();
        l r13 = l.a.a();
        if (r13 != null) goto L28;
    L30:
        if (r8 == true) goto L32;
        LayerBackgroundStatus r14 = LayerBackgroundStatus.Normal;
    L54:
        int r15 = b.a[r14.ordinal()];
        if (r15 != 1) goto L57;
        K();
    L64:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r16 = this.s;
        if (r16 == null) goto L73;
        MultiLinkGuestViewBinder.a r17 = this.e;
        if (r17 == null) goto L69;
        r6 = r17.k;
    L69:
        r16.g(r8, r6);
        return;
    L73:
        return;
    L57:
        if (r15 != 2) goto L59;
        I();
        goto L64
    L59:
        if (r15 != 3) goto L64;
        J();
        goto L64
    L32:
        if (r2.getSilenceStatus() == 0) goto L40;
        IBaseUser r18 = r2.getUser();
        if (r18 == null) goto L36;
        String r19 = r18.getIdString();
    L38:
        if ((!Intrinsics.areEqual(r19, je0.d.b0())) == false) goto L40;
        r3 = true;
        goto L40
    L36:
        r19 = null;
    L40:
        if (r3 == true) goto L44;
        if (r12 == true) goto L44;
        r14 = LayerBackgroundStatus.Audio;
    L44:
        r14 = LayerBackgroundStatus.Leave;
        goto L54
    L28:
        if (r13.isEngineOn() != true) goto L30;
    L47:
        if (r2.isSelfBackground() == true) goto L49;
        r14 = LayerBackgroundStatus.Normal;
        goto L54
    L49:
        if (r4 == true) goto L53;
        if (r12 == true) goto L53;
        r14 = LayerBackgroundStatus.Audio;
    L53:
        r14 = LayerBackgroundStatus.Leave;
    L22:
        r11 = null;
        goto L23
    L16:
        r7 = null;
        goto L17
    L12:
        r4 = false;
        goto L13
    L74:
        return;
    L72:
        return;
    }

    public final void L(boolean r5) {
        MultiLinkGuestViewBinder.a r0 = this.e;
        tf0.d r1 = null;
        if (r0 == null) goto L7;
        HashMap<String, tf0.d> r2 = r0.i;
        if (r2 == null) goto L7;
        tf0.d r3 = r2.get(SeatItemId.SEAT_WIDGET.name());
    L9:
        if ((r3 instanceof nh0.m) == false) goto L12;
        r1 = r3;
    L12:
        nh0.m r4 = (nh0.m) r1;
        MultiLinkGuestViewBinder.a r6 = this.e;
        if (r6 == null) goto L19;
        ch0.e r7 = r6.k;
        if (r7 == null) goto L19;
        if (ch0.f.b(r7) != true) goto L19;
        boolean r8 = true;
    L20:
        if (r5 == false) goto L24;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r9 = this.s;
        if (r9 == null) goto L28;
        r9.c(r4, r8, true);
        return;
    L28:
        return;
    L24:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r10 = this.s;
        if (r10 == null) goto L30;
        r10.c(r4, r8, false);
        return;
    L30:
        return;
    L19:
        r8 = false;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.a(r10);
        new j22.c(this.i);
        MultiLinkGuestViewBinder.a r11 = this.e;
        LinkMicQuickInteractView r0 = null;
        if (r11 == null) goto L9;
        int r12 = r11.a;
        xg0.a r1 = this.c;
        if (r1 == null) goto L7;
        ig0.b r13 = r1.P6(r12);
    L8:
        ig0.b r4 = r13;
    L10:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r14 = new com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b(q(), r4, je0.d.r(), this.c);
        this.s = r14;
        MultiLinkMicSeatGiftIconElement r2 = this.m;
        if (r2 == null) goto L13;
        r0 = r2.c;
    L13:
        r14.e = r0;
        r14.f = r2;
        boolean r15 = r.a;
        if (r.l() == false) goto L17;
        this.t = new com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d(this.b, q(), r4, je0.d.r(), false, this.c, 48);
        return;
    L17:
        return;
    L7:
        r13 = null;
        goto L8
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void c(d6 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof d6.a) == false) goto L14;
        wj0.b r4 = ((d6.a) r3).a;
        if (r4 == null) goto L15;
        TalkRoomBaseDynamicEmoji r0 = r4.b;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isRandomEmoji != true) goto L17;
        xg0.a r1 = this.c;
        if (r1 == null) goto L18;
        r1.N0(ag1.b.b(r4));
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        M();
    }

    public MultiLinkCommonGuestMicSeatBasicLayer(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void A(MultiLinkGuestViewBinder.a r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "itemData");
        super.A(r18, r19);
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r2 = this.s;
        k r3 = null;
        if (r2 == null) goto L10;
        MultiLinkGuestViewBinder.a r4 = this.e;
        if (r4 == null) goto L7;
        Integer r5 = Integer.valueOf(r4.a);
    L8:
        r2.d = r5;
        goto L10
    L7:
        r5 = null;
    L10:
        if (n() != 0) goto L16;
        q().setOnClickListener(x0.a(new MultiLinkCommonGuestMicSeatBasicLayer$onBind$1(this)));
        MultiLinkMicSeatGiftIconElement r6 = this.m;
        if (r6 == null) goto L16;
        View.OnClickListener r7 = x0.a(new MultiLinkCommonGuestMicSeatBasicLayer$onBind$2(this));
        Intrinsics.checkNotNullParameter(r7, "clickListener");
        LinkMicQuickInteractView r8 = r6.c;
        if (r8 == null) goto L16;
        r8.setOnClickListener(r7);
    L16:
        MultiLinkMicSeatGiftIconElement r9 = this.m;
        if (r9 == null) goto L33;
        int r10 = (int) w2.a(10.0f);
        LinkMicQuickInteractView r11 = r9.c;
        if (r11 == null) goto L33;
        UIUtils.updateLayout(r11.f, r10, r10);
        View r12 = r11.m.getCurrentView();
        if ((r12 instanceof TextView) == true) goto L23;
        r12 = null;
    L23:
        TextView r13 = (TextView) r12;
        if (r13 == null) goto L26;
        r13.setTextSize(2, 9.0f);
    L26:
        View r14 = r11.m.getNextView();
        if ((r14 instanceof TextView) == true) goto L29;
        r14 = null;
    L29:
        TextView r15 = (TextView) r14;
        if (r15 == null) goto L32;
        r15.setTextSize(2, 9.0f);
    L32:
        r11.h.setTextSize(2, 9.0f);
    L33:
        MultiLinkGuestViewBinder.a r16 = this.e;
        if (r16 == null) goto L40;
        ch0.e r17 = r16.k;
        if (r17 == null) goto L40;
        ILinkPlayerInfoBridge r20 = r17.a;
        if (r20 == null) goto L40;
        r20.getMediaType();
        C();
    L40:
        AnchorPauseTipsView r21 = this.j;
        if (r21 == null) goto L43;
        r21.setVisibility(8);
    L43:
        MultiLinkGuestViewBinder.a r22 = this.e;
        if (r22 == null) goto L48;
        ch0.e r23 = r22.k;
        if (r23 == null) goto L48;
        ILinkPlayerInfoBridge r24 = r23.a;
    L50:
        if (r24 == null) goto L61;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L61;
        if (r25.isMysteryMan() != true) goto L61;
        HSImageView r26 = this.f;
        if (r26 == null) goto L58;
        r26.setController(null);
    L58:
        HSImageView r27 = this.f;
        if (r27 == null) goto L72;
        r27.setBackgroundColor(ColorProtector.parseColor("#ffa393c8"));
    L72:
        MultiLinkGuestViewBinder.a r28 = this.e;
        if (r28 == null) goto L81;
        ch0.e r29 = r28.k;
        if (r29 == null) goto L81;
        ILinkPlayerInfoBridge r30 = r29.a;
        if (r30 == null) goto L81;
        if (r30.isBackground() != true) goto L81;
        boolean r31 = true;
    L82:
        E(r31);
        L(true);
        N(r19, true);
        com.bytedance.android.live.liveinteract.revenue.fight.b r32 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r32 == null) goto L86;
        r32.F1(this, SceneType.SCENE_VIDEO_TALKROOM);
    L86:
        if (aj0.b.c(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout()) == false) goto L89;
        int r33 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.g(this, r19);
        return;
    L89:
        return;
    L81:
        r31 = false;
    L61:
        if (r24 != null) goto L63;
    L65:
        int r34 = 15;
    L66:
        HSImageView r35 = this.f;
        if (r24 == null) goto L71;
        IBaseUser r36 = r24.getUser();
        if (r36 == null) goto L71;
        r3 = je0.d.n(r36, AvatarType.AVATAR_MEDIUM.getValue());
    L71:
        ImageLoader.bindImageAntiFlink(r35, r3, null, (int) 0, -1, -1, new l3(r34), null, false, false, true);
        goto L72
    L63:
        if (r24.isAnonymous() != true) goto L65;
        r34 = 50;
    L48:
        r24 = null;
        goto L50
    }

    public final void N(int r3, boolean r4) {
        if (r4 == false) goto L6;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r5 = this.t;
        if (r5 == null) goto L6;
        ALogger.w("RandomEmojiManager", "reset隐藏");
        r5.k.setVisibility(8);
    L6:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r6 = this.t;
        if (r6 == null) goto L21;
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L17;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L17;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L17;
        boolean r7 = true;
        if (r2.isEnlarged() != true) goto L17;
    L18:
        r6.g = r7;
        String r8 = r6.f;
        if (r8 == null) goto L21;
        r6.b(Intrinsics.areEqual(r6.c(), r8));
    L17:
        r7 = false;
    L21:
        MultiLinkGuestViewBinder.a r9 = this.e;
        tf0.d r10 = null;
        if (r9 == null) goto L26;
        HashMap<String, tf0.d> r11 = r9.i;
        if (r11 == null) goto L26;
        tf0.d r12 = r11.get(SeatItemId.RANDOM_EMOJI.name());
    L28:
        if ((r12 instanceof nh0.i) == false) goto L31;
        r10 = r12;
    L31:
        nh0.i r13 = (nh0.i) r10;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r14 = this.t;
        if (r14 == null) goto L35;
        r14.d(r3, r13);
        return;
    L35:
        return;
    L26:
        r12 = null;
        goto L28
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void B(MultiLinkGuestViewBinder.a r8, int r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r10, "payload");
        super.B(r8, r9, r10);
        Iterator<String> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L45;
        String r0 = r11.next();
        if (r0 == null) goto L4;
        int r1 = r0.hashCode();
        if (r1 != (-201720105)) goto L11;
        if (r0.equals("payload_key_dynamic_data_update_for_seat_widget_info") == false) goto L4;
        L(false);
        goto L4
    L11:
        if (r1 != 1713471578) goto L13;
        if (r0.equals("payload_key_is_seat_anim_action_update") == false) goto L4;
        Object r2 = r8.k.d.remove("EXT_KEY_SEAT_ANIM_ACTION");
        Object r3 = null;
        if ((r2 instanceof Boolean) == true) goto L23;
        r2 = null;
    L23:
        Boolean r4 = (Boolean) r2;
        Object r5 = r8.k.d.remove("EXT_KEY_SEAT_ANIM_ACTION_PAYLOAD");
        gh0.a.b("ShowSeatAnim", "ShowSeatAnim " + r4 + ' ' + r5, 4);
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L4;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r6 = this.s;
        if (r6 == null) goto L4;
        if ((r5 instanceof c0) == false) goto L31;
        r3 = r5;
    L31:
        c0 r7 = (c0) r3;
        if (r7 == null) goto L4;
        String r12 = r7.c;
        if (r12 == null) goto L4;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r13 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b(r12, 0, UriProtector.parse(r7.b));
        Integer r14 = r6.d;
        if (r14 == null) goto L4;
        int r15 = r14.intValue();
        xg0.a r16 = r6.k;
        if (r16 == null) goto L4;
        ig0.b r17 = r16.P6(r15);
        if (r17 == null) goto L4;
        r17.b(r13);
        goto L4
    L13:
        if (r1 != 2069147793) goto L4;
        if (r0.equals("payload_key_dynamic_data_update_for_seat_random_emoji_info") == false) goto L4;
        N(r9, false);
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
