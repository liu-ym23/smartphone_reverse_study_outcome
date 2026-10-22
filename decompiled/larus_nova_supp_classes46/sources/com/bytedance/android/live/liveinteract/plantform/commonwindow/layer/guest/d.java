package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends MultiLinkCommonGuestMicSeatBasicLayer {
    public com.bytedance.android.live.liveinteract.videotalk.utils.c v;
    public final m w;

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
        return 2131566602;
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
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
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
        return VerticalNitaInflate.Tag.MultiLinkDynamicFloatWindowFirstUserBasicLayer.name();
    }

    public final void O(boolean r3) {
        ALogger.i("MultiLinkDynamicFloatWindowFirstUserMicSeatBasicLayer", "updateGuestInfoVisibility, isVisible: " + r3);
        if (r3 == false) goto L10;
        HSImageView r4 = this.f;
        if (r4 == null) goto L7;
        r4.setAlpha(1.0f);
    L7:
        ConstraintLayout r5 = this.g;
        if (r5 == null) goto L17;
        r5.setAlpha(1.0f);
        return;
    L17:
        return;
    L10:
        HSImageView r6 = this.f;
        if (r6 == null) goto L13;
        r6.setAlpha(0.0f);
    L13:
        ConstraintLayout r7 = this.g;
        if (r7 == null) goto L19;
        r7.setAlpha(0.0f);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        IBaseUser r0 = r6.k.a.getUser();
        String r1 = null;
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
        q().post(new c(this));
        IBaseUser r14 = r6.k.a.getUser();
        if (r14 == null) goto L35;
        String r15 = r14.getIdString();
    L36:
        IRoom r16 = r6.h;
        if (r16 == null) goto L40;
        r1 = r16.getOwnerUserIdString();
    L40:
        if (Intrinsics.areEqual(r15, r1) == false) goto L42;
        ((LinearLayout) q().findViewById(2131372617)).setVisibility(8);
        return;
    L42:
        ((LinearLayout) q().findViewById(2131372617)).setVisibility(0);
        return;
    L35:
        r15 = null;
        goto L36
    L17:
        MultiLinkMicSeatGiftIconElement r17 = this.m;
        if (r17 == null) goto L20;
        r17.c = r9;
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

    public d(m r2, MicSeatScene r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfig");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r3, r4);
        this.w = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Intrinsics.checkNotNullParameter(r5, "payload");
        super.B(r3, r4, r5);
        Iterator<String> r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L16;
        String r7 = r6.next();
        if (r7 == null) goto L4;
        if (r7.hashCode() != (-1834355226)) goto L4;
        if (r7.equals("payload_key_not_audio_user_position_list") == false) goto L4;
        List<Integer> r8 = r3.o;
        HSImageView r0 = this.f;
        if (r0 == null) goto L4;
        r0.post(new e(this, r8));
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.d
    public final void e(int r2, p r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        super.e(r2, r3, r4);
        if (Intrinsics.areEqual(r3, ti0.b.b) == false) goto L9;
        ALogger.i("MultiLinkDynamicFloatWindowFirstUserMicSeatBasicLayer", "dispatchAction, UpdateXplayRunningState: " + r4);
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L7;
        O(false);
        return;
    L7:
        O(true);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
