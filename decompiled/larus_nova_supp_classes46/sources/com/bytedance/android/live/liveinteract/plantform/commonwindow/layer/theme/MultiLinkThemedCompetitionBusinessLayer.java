package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.d;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionWinType;
import com.bytedance.android.livesdk.chatroom.model.interact.a2;
import com.bytedance.android.livesdk.chatroom.model.interact.b2;
import com.bytedance.android.livesdk.chatroom.model.interact.n1;
import com.bytedance.android.livesdk.message.model.fa;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkThemedCompetitionBusinessLayer extends jg0.b<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a d;
    public LinkMicQuickInteractView e;
    public ThemedCompetitionQuickInteractView f;
    public final g g;
    public final int h;
    public final MicSeatScene i;

    @Override // jg0.f
    public final void onDetach() {
    }

    public final ILinkPlayerInfoBridge g() {
        MultiLinkGuestViewBinder.a r0 = this.d;
        if (r0 == null) goto L7;
        e r1 = r0.k;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return null;
    }

    @Override // jg0.b, jg0.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.a(r3);
        View r4 = this.g.m(2131389576);
        if (r4 == null) goto L20;
        this.e = (LinkMicQuickInteractView) r4;
        View r5 = this.g.m(2131389836);
        if (r5 == null) goto L18;
        this.f = (ThemedCompetitionQuickInteractView) r5;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r6 = this.g.w();
        if (r6 == null) goto L12;
        ThemedCompetitionQuickInteractView r1 = this.f;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L11:
        r6.g = r1;
    L12:
        ThemedCompetitionQuickInteractView r7 = this.f;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L15:
        r7.setOnClickListener(x0.a(new MultiLinkThemedCompetitionBusinessLayer$onCreate$1(this)));
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView");
    }

    public final void m(int r6) {
        ThemedCompetitionQuickInteractView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L5:
        r0.setVisibility(r6);
        if (r6 != 0) goto L8;
        boolean r7 = true;
    L10:
        if (this.i != MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L22;
        ConstraintSet r1 = new ConstraintSet();
        View r2 = this.g.m(2131389586);
        if ((r2 instanceof ConstraintLayout) == true) goto L14;
        r2 = null;
    L14:
        ConstraintLayout r3 = (ConstraintLayout) r2;
        if (r3 == null) goto L23;
        r1.clone(r3);
        if (r7 == false) goto L19;
        r1.connect(2131389587, 7, 2131389836, 6);
    L20:
        r1.applyTo(r3);
        return;
    L19:
        r1.connect(2131389587, 7, 2131389576, 6);
        goto L20
    L23:
        return;
    L22:
        return;
    L8:
        r7 = false;
        goto L10
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        h((MultiLinkGuestViewBinder.a) r1, r2);
    }

    public final void h(MultiLinkGuestViewBinder.a r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "itemData");
        this.d = r10;
        ThemedCompetitionContext.a r12 = ThemedCompetitionContext.Companion;
        int r13 = r12.b();
        SelectionType r0 = SelectionType.SCORING;
        String r3 = "";
        boolean r5 = false;
        if (r13 != r0.getValue()) goto L17;
        ILinkPlayerInfoBridge r14 = g();
        if (r14 == null) goto L10;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L10;
        String r16 = r15.getIdString();
        if (r16 == null) goto L10;
    L12:
        if (r12.d(r16).getWinType() != ThemedCompetitionWinType.NOT_WIN.getValue()) goto L17;
        ThemedCompetitionQuickInteractView r17 = this.f;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L16:
        r17.setIconVisibility(false);
    L22:
        if (GuestBattleContext.Companion.e() == true) goto L101;
        if (SelfDisciplineContext.Companion.e() == true) goto L101;
        ILinkPlayerInfoBridge r18 = g();
        if (r12.g() == true) goto L29;
        m(8);
        LinkMicQuickInteractView r1 = this.e;
        if (r1 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L42:
        if (r18 != null) goto L44;
    L46:
        int r8 = 8;
    L47:
        r1.setVisibility(r8);
        if (r18 != null) goto L50;
    L57:
        ThemedCompetitionQuickInteractView r2 = this.f;
        if (r2 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L60:
        r2.j = "0";
        r2.i.f();
    L61:
        ThemedCompetitionQuickInteractView r4 = this.f;
        if (r4 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L65:
        if (r4.getVisibility() != 0) goto L101;
        if (r12.b() != r0.getValue()) goto L101;
        String r6 = null;
        if (r18 == null) goto L73;
        IBaseUser r7 = r18.getUser();
        if (r7 == null) goto L73;
        String r9 = r7.getIdString();
    L74:
        m r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r19 == null) goto L80;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L80;
        r6 = r20.getOwnerUserIdString();
    L80:
        if (Intrinsics.areEqual(r9, r6) == true) goto L99;
        if (r18 == null) goto L86;
        IBaseUser r110 = r18.getUser();
        if (r110 == null) goto L86;
        String r111 = r110.getIdString();
        if (r111 == null) goto L86;
    L87:
        Intrinsics.checkNotNullParameter(r111, "userId");
        ThemedCompetitionContext r21 = r12.getContext();
        if (r21 == null) goto L98;
        n<a2> r22 = r21.getInfo();
        if (r22 == null) goto L98;
        a2 r23 = (a2) r22.getValue();
        if (r23 == null) goto L98;
        b2 r24 = r23.getSetting();
        if (r24 == null) goto L98;
        Intrinsics.checkNotNullParameter(r24, "$this$judgesUserIdList");
        o0.a r25 = o0.a;
        r24.getJudgesAwemeIdList();
        List r26 = r24.getJudgesOpenIdList();
        r25.getClass();
        List r27 = o0.a.h(r26);
        if (r27 == null) goto L98;
        r5 = r27.contains(r111);
    L98:
        if (r5 == false) goto L101;
    L86:
        r111 = "";
    L99:
        m(8);
    L73:
        r9 = null;
        goto L74
    L50:
        if (r18.isBackground() != true) goto L57;
        if (r18.getSilenceStatus() == 0) goto L57;
        LinkMicQuickInteractView r28 = this.e;
        if (r28 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L56:
        r28.setVisibility(8);
        goto L57
    L44:
        if (r18.isOpenSendGift() != true) goto L46;
        r8 = 0;
        goto L47
    L29:
        if (r12.b() != SelectionType.NORMAL.getValue()) goto L34;
        if (r18 == null) goto L34;
        if (r18.isOpenSendGift() == true) goto L34;
        m(8);
    L35:
        LinkMicQuickInteractView r29 = this.e;
        if (r29 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("linkInteract");
    L38:
        r29.setVisibility(8);
    L34:
        m(0);
    L101:
        if (r12.g() == false) goto L128;
        ILinkPlayerInfoBridge r112 = g();
        if (r112 == null) goto L110;
        IBaseUser r113 = r112.getUser();
        if (r113 == null) goto L110;
        String r114 = r113.getIdString();
        if (r114 == null) goto L110;
        r3 = r114;
    L110:
        n1 r115 = r12.d(r3);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b r30 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0;
        ILinkPlayerInfoBridge r31 = g();
        r30.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r31) == false) goto L123;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r32 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r32 != null) goto L115;
    L119:
        ThemedCompetitionQuickInteractView r33 = this.f;
        if (r33 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L122:
        r33.getClass();
        Intrinsics.checkNotNullParameter(r115, "score");
        String r116 = r12.a(r115.getScoreFuzz());
        Intrinsics.checkNotNullParameter(r116, "score");
        r33.j = r116;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r117 = r33.i;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r116, "score");
        r117.f();
        f r118 = r117.f;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r116, "score");
        r118.a.setCurrentText(r116);
        r118.d = r116;
        return;
    L115:
        if (r32.isEmpty() == true) goto L119;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r119 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r119 == null) goto L129;
        int r34 = QuickInteractTask.n;
        r119.Si(QuickInteractTask.a.a(r115.getScoreFuzz(), (l) vh7.f.c(l.class)), true);
        return;
    L129:
        return;
    L123:
        ThemedCompetitionQuickInteractView r35 = this.f;
        if (r35 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L126:
        r35.getClass();
        Intrinsics.checkNotNullParameter(r115, "score");
        String r120 = r12.a(r115.getScoreFuzz());
        Intrinsics.checkNotNullParameter(r120, "score");
        r35.j = r120;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r121 = r35.i;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r120, "score");
        r121.f();
        f r122 = r121.f;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r120, "score");
        r122.a.setCurrentText(r120);
        r122.d = r120;
        return;
    L128:
        return;
    L10:
        r16 = "";
    L17:
        ThemedCompetitionQuickInteractView r123 = this.f;
        if (r123 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L20:
        r123.setIconVisibility(true);
        goto L22
    }

    public MultiLinkThemedCompetitionBusinessLayer(g r2, MicSeatScene r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "basicLayer");
        Intrinsics.checkNotNullParameter(r3, "scene");
        super(r4);
        this.g = r2;
        this.h = 12;
        this.i = r3;
        ThemedCompetitionWinType.NOT_WIN.getValue();
    }

    @Override // jg0.f
    public final void k(Object r9, int r10, Bundle r11) {
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r9;
        Intrinsics.checkNotNullParameter(r12, "itemData");
        Intrinsics.checkNotNullParameter(r11, "payload");
        this.d = r12;
        Iterator<String> r13 = r11.keySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L71;
        String r0 = r13.next();
        if (r0 == null) goto L4;
        Object r3 = null;
        switch(r0.hashCode()) {
            case -1998665887: goto L70;
            case -1902415957: goto L54;
            case 268668786: goto L51;
            case 781516935: goto L15;
            case 2014427442: goto L12;
            default: goto L4;
        };
    L12:
        if (r0.equals("payload_key_competition_open_status_update") == false) goto L4;
        h(r12, r10);
        goto L4
    L15:
        if (r0.equals("payload_key_competition_score_update") == false) goto L4;
        Object r1 = r12.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_CONTENT");
        if ((r1 instanceof fa) == false) goto L20;
        r3 = r1;
    L20:
        fa r4 = (fa) r3;
        if (r4 == null) goto L4;
        Intrinsics.checkNotNullParameter(r4, "content");
        n1 r2 = r4.getChangeUserScore();
        if (r2.getScore() != 0) goto L28;
        ThemedCompetitionQuickInteractView r5 = this.f;
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L27:
        r5.j = "0";
        r5.i.f();
    L28:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b r6 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0;
        ILinkPlayerInfoBridge r7 = g();
        r6.getClass();
        boolean r8 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r7);
        boolean r14 = true;
        if (r8 == true) goto L30;
        ThemedCompetitionQuickInteractView r15 = this.f;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L39:
        String r16 = r2.getScoreFuzz();
        r15.getClass();
        if (r16 != null) goto L42;
    L45:
        if (r14 == true) goto L4;
        if (TextUtils.equals(r15.j, r16) == true) goto L4;
        r15.b(ThemedCompetitionContext.Companion.a(r16));
        goto L4
    L42:
        if (r16.length() == 0) goto L45;
        r14 = false;
        goto L45
    L30:
        l r17 = r4.getQuickInteract();
        if (r17 != null) goto L33;
        r17 = (l) vh7.f.c(l.class);
    L33:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r18 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r18 == null) goto L4;
        int r19 = QuickInteractTask.n;
        r18.Si(QuickInteractTask.a.a(r2.getScoreFuzz(), r17), true);
        goto L4
    L51:
        if (r0.equals("payload_key_is_open_send_gift_update") == false) goto L4;
        h(r12, r10);
        goto L4
    L54:
        if (r0.equals("payload_key_interact_task_update") == false) goto L4;
        Object r20 = r12.k.d.get("EXT_KEY_QUICK_INTERACT_TASK");
        if ((r20 instanceof QuickInteractTask) == false) goto L59;
        r3 = r20;
    L59:
        final QuickInteractTask r21 = (QuickInteractTask) r3;
        if (r21 == null) goto L4;
        if (4 != r21.getType()) goto L4;
        r12.k.d.remove("EXT_KEY_QUICK_INTERACT_TASK");
        Intrinsics.checkNotNullParameter(r21, "task");
        Text r22 = r21.j;
        if (r22 != null) goto L65;
        ThemedCompetitionQuickInteractView r23 = this.f;
        if (r23 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L69:
        r23.a(r21);
        goto L4
    L65:
        d.a(r22, new MultiLinkThemedCompetitionBusinessLayer$onReceiveInteractTask$1(this, r21));
        goto L4
    L70:
        r0.equals("payload_key_video_status_update");
        goto L4
    }
}
