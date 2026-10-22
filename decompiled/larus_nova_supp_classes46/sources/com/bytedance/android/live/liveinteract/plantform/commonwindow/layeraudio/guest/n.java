package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends q {
    public final Queue<Integer> D;
    public ViewGroup E;
    public View F;
    public ConstraintLayout G;

    public static final class a {
    }

    public static final class b extends ViewOutlineProvider {
        public final float a;

        public b(float r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r6, Outline r7) {
            Intrinsics.checkNotNullParameter(r6, "view");
            Intrinsics.checkNotNullParameter(r7, "outline");
            r7.setRoundRect(new Rect(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getWidth() - r6.getPaddingRight(), r6.getHeight() - r6.getPaddingBottom()), this.a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.e
    public final void i() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131565182;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final boolean z() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkHamletAvatarUserInfoLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final Integer y() {
        return Integer.valueOf(UtilityKotlinExtentionsKt.i(32));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q
    public final void R() {
        q().setVisibility(0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.e
    public final bd0.c f() {
        return super.f();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c, jg0.f
    public final void onDetach() {
        super.onDetach();
        this.z.dispose();
        ((LinkedList) this.D).clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void r() {
        super.r();
        ILinkPlayerInfoBridge r0 = J();
        if (r0 != null) goto L5;
    L9:
        View r1 = this.o;
        if (r1 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r1);
        return;
    L15:
        return;
    L5:
        if (r0.isEnlarged() != true) goto L9;
        View r2 = this.o;
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final View x() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void H(int r1) {
        if (r1 == 0) goto L6;
        View r2 = this.F;
        if (r2 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r2);
        return;
    L10:
        return;
    L6:
        View r3 = this.F;
        if (r3 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer
    public final void O(int r2) {
        ConstraintLayout r0 = this.G;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.a(r5);
        this.E = (ViewGroup) q().findViewById(2131392032);
        HSImageView r6 = q().findViewById(2131384394);
        TextView r7 = (TextView) q().findViewById(2131384396);
        LinearLayout r8 = (LinearLayout) q().findViewById(2131384395);
        this.F = q().findViewById(2131389588);
        ConstraintLayout r9 = q().findViewById(2131389690);
        this.G = r9;
        if (r9 == null) goto L5;
        r9.setOutlineProvider(new b(UtilityKotlinExtentionsKt.h(16)));
    L5:
        ConstraintLayout r10 = this.G;
        if (r10 == null) goto L8;
        r10.setClipToOutline(true);
    L8:
        TextView r11 = this.k;
        if (r11 == null) goto L11;
        r11.setFilters(new InputFilter[]{new je0.a(4)});
    L11:
        LinkFeedTypeConstant.Companion r12 = LinkFeedTypeConstant.Companion;
        if (r12.isFeedType(n()) == true) goto L14;
        return;
    L14:
        if (r12.isDouyinFullScreen(n()) == true) goto L41;
        ViewGroup r13 = this.E;
        if (r13 == null) goto L18;
        a1.m(r13, 0);
    L18:
        View r14 = q().findViewById(2131389896);
        if (r14 == null) goto L21;
        r14.setScaleX(0.6f);
        r14.setScaleY(0.6f);
    L21:
        View r15 = q().findViewById(2131374158);
        if (r15 == null) goto L24;
        r15.setScaleX(0.6f);
        r15.setScaleY(0.6f);
    L24:
        View r16 = q().findViewById(2131389564);
        if (r16 == null) goto L27;
        r16.setScaleX(0.6f);
        r16.setScaleY(0.6f);
    L27:
        View r17 = q().findViewById(2131392033);
        if (r17 == null) goto L30;
        r17.setScaleY(0.6f);
    L30:
        View r18 = q().findViewById(2131389583);
        if (r18 == null) goto L33;
        a1.m(r18, s1.f(2.0f));
        a1.o(r18, s1.f(8.0f));
    L33:
        View r19 = this.o;
        if (r19 == null) goto L36;
        r19.setScaleX(0.6f);
    L36:
        View r20 = this.o;
        if (r20 == null) goto L42;
        r20.setScaleY(0.6f);
        return;
    L42:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        super.A(r2, r3);
        ((LinkedList) this.D).clear();
        Q().b(r2.k.a);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public n(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
        this.D = new LinkedList();
        LiveCommonConstants.INSTANCE.getObjectTosPath();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r5, int r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        Intrinsics.checkNotNullParameter(r7, "payload");
        super.B(r5, r6, r7);
        Iterator<String> r8 = r7.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L51;
        String r0 = r8.next();
        if (r0 == null) goto L4;
        Object r2 = null;
        switch(r0.hashCode()) {
            case -2054590407: goto L40;
            case -715388833: goto L37;
            case -703589172: goto L34;
            case 1837268949: goto L21;
            case 1944873790: goto L12;
            default: goto L4;
        };
    L12:
        if (r0.equals("payload_key_feedview_interact_song_sub_ui_layout_update") == false) goto L4;
        Object r1 = r5.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_SUB_UI_LAYOUT");
        if ((r1 instanceof Integer) == false) goto L17;
        r2 = r1;
    L17:
        Integer r3 = (Integer) r2;
        if (r3 == null) goto L4;
        r3.intValue();
        R();
        goto L4
    L21:
        if (r0.equals("payload_key_interact_song_golden_mic_info_list_update") == false) goto L4;
        Object r4 = r5.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST");
        if (TypeIntrinsics.isMutableList(r4) == false) goto L26;
        r2 = r4;
    L26:
        List r9 = (List) r2;
        if (r9 == null) goto L4;
        Iterator r10 = r9.iterator();
    L30:
        if (r10.hasNext() == false) goto L32;
        Intrinsics.checkNotNullParameter((pf0.a) r10.next(), "info");
        goto L30
    L32:
        ALogger.d("MultiLinkHamletAvatarUserInfoLayer", "interact_song_golden_mic_info_list size: " + r9.size() + " and list clear");
        r9.clear();
        goto L4
    L34:
        if (r0.equals("payload_key_user_position") == false) goto L4;
    L38:
        A(r5, r6);
        goto L4
    L37:
        if (r0.equals("payload_key_is_c_position_update") == false) goto L4;
    L40:
        if (r0.equals("payload_key_play_mode_state_update") == false) goto L4;
        IBaseUser r11 = r5.k.a.getUser();
        if (r11 == null) goto L44;
        String r12 = r11.getIdString();
    L45:
        IRoom r13 = r5.h;
        if (r13 == null) goto L49;
        r2 = r13.getAnchorId();
    L49:
        if (Intrinsics.areEqual(r12, r2) == false) goto L4;
        A(r5, r6);
        goto L4
    L44:
        r12 = null;
        goto L45
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.q, com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
