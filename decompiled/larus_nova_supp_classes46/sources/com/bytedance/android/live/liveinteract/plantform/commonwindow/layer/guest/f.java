package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.utils.g0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends MultiLinkCommonGuestMicSeatBasicLayer {

    public static final class a implements View.OnTouchListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return false;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer
    public final void M() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131566605;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer
    public final void I() {
        ConstraintLayout r0 = this.g;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        HSImageView r1 = this.h;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        HSImageView r2 = this.f;
        if (r2 == null) goto L12;
        r2.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer
    public final void J() {
        TextView r0 = this.k;
        if (r0 == null) goto L5;
        r0.setText(s1.B(2131918663));
    L5:
        ConstraintLayout r1 = this.g;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        HSImageView r2 = this.h;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        AnchorPauseTipsView r3 = this.j;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        MultiLinkGuestViewBinder.a r4 = this.e;
        String r5 = null;
        if (r4 == null) goto L23;
        ch0.e r6 = r4.k;
        if (r6 == null) goto L23;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L23;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L23;
        String r9 = r8.getIdString();
    L24:
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L29;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L29;
        r5 = r11.getOwnerUserIdString();
    L29:
        boolean r12 = Intrinsics.areEqual(r9, r5);
        AnchorPauseTipsView r13 = this.j;
        if (r13 == null) goto L32;
        r13.S5(r12);
    L32:
        MultiLinkMicSeatGiftIconElement r14 = this.m;
        if (r14 == null) goto L35;
        r14.e(4);
    L35:
        HSImageView r15 = this.f;
        if (r15 == null) goto L39;
        r15.setVisibility(0);
        return;
    L39:
        return;
    L23:
        r9 = null;
        goto L24
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer
    public final void K() {
        HSImageView r0 = this.h;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        super.K();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkFixedFloatWindowFirstUserBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        IBaseUser r0 = r6.k.a.getUser();
        Object r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getIdString();
    L6:
        Room r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r3 == null) goto L9;
        String r4 = r3.getOwnerUserIdString();
    L10:
        boolean r5 = Intrinsics.areEqual(r2, r4);
        LinkMicQuickInteractView r8 = (LinkMicQuickInteractView) q().findViewById(2131389578);
        LinkMicQuickInteractView r9 = (LinkMicQuickInteractView) q().findViewById(2131389576);
        if (r5 == false) goto L17;
        MultiLinkMicSeatGiftIconElement r10 = this.m;
        if (r10 == null) goto L15;
        r10.c = r8;
    L15:
        if (r10 == null) goto L22;
        r10.e(8);
    L22:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r11 = this.s;
        if (r11 == null) goto L29;
        MultiLinkMicSeatGiftIconElement r12 = this.m;
        if (r12 == null) goto L27;
        LinkMicQuickInteractView r13 = r12.c;
    L28:
        r11.e = r13;
        r11.f = r12;
        goto L29
    L27:
        r13 = null;
    L29:
        super.A(r6, r7);
        if (r7 != 0) goto L32;
        q().setOnTouchListener(a.a);
        q().setOnClickListener(null);
        q().setClickable(false);
    L32:
        IBaseUser r14 = r6.k.a.getUser();
        if (r14 == null) goto L35;
        String r15 = r14.getIdString();
    L36:
        Room r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r16 == null) goto L39;
        String r17 = r16.getOwnerUserIdString();
    L41:
        if (Intrinsics.areEqual(r15, r17) == false) goto L43;
        ((LinearLayout) q().findViewById(2131372617)).setVisibility(8);
    L44:
        HashMap r18 = g0.a;
        g0.c r19 = g0.b.a("get_enlarge_userbar_translation", null);
        if (r19 == null) goto L60;
        float r20 = 0.0f;
        r19.a = Float.valueOf(0.0f);
        Boolean r21 = Boolean.valueOf(r19.b());
        if (r21.booleanValue() == true) goto L50;
        r21 = null;
    L50:
        if (r21 == null) goto L61;
        r21.booleanValue();
        LinearLayout r22 = (LinearLayout) q().findViewById(2131372617);
        Object r23 = r19.a;
        if ((r23 instanceof Float) == false) goto L55;
        r1 = r23;
    L55:
        Float r24 = (Float) r1;
        if (r24 == null) goto L58;
        r20 = r24.floatValue();
    L58:
        r22.setTranslationY(r20);
        return;
    L61:
        return;
    L60:
        return;
    L43:
        ((LinearLayout) q().findViewById(2131372617)).setVisibility(0);
        goto L44
    L39:
        r17 = null;
        goto L41
    L35:
        r15 = null;
        goto L36
    L17:
        MultiLinkMicSeatGiftIconElement r25 = this.m;
        if (r25 == null) goto L20;
        r25.c = r9;
    L20:
        if (r8 == null) goto L22;
        r8.setVisibility(8);
        goto L22
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public f(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, MicSeatScene r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfig");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        super.B(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
