package rg0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongMicSeatView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.h;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.ugc.effectplatform.util.r;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import pg0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends jg0.a<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a e;
    public RequestSongMicSeatView f;
    public final e g;
    public final g h;

    /* JADX INFO: renamed from: rg0.a$a, reason: collision with other inner class name */
    public static final class C0265a {
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return 0;
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        RequestSongMicSeatView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L5:
        r0.n();
        this.h.onDetach();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r16) {
        Intrinsics.checkNotNullParameter(r16, "context");
        this.f = new RequestSongMicSeatView(r16, null, 0, true, 6);
        e r1 = this.g;
        Object r3 = null;
        if (r1 == null) goto L5;
        Object r2 = r1.m(2131389701);
    L7:
        if ((r2 instanceof PositionNameTv) == true) goto L9;
        r2 = null;
    L9:
        PositionNameTv r4 = (PositionNameTv) r2;
        e r5 = this.g;
        if (r5 == null) goto L12;
        Object r6 = r5.m(2131389764);
    L14:
        if ((r6 instanceof SeatPosTagLabelTextView) == true) goto L16;
        r6 = null;
    L16:
        SeatPosTagLabelTextView r7 = (SeatPosTagLabelTextView) r6;
        if (r4 == null) goto L21;
        if (r7 == null) goto L21;
        PositionNameTv r8 = r4;
        SeatPosTagLabelTextView r9 = r7;
    L37:
        RequestSongMicSeatView r10 = this.f;
        if (r10 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L40:
        MicSeatScene r11 = this.b;
        if (n() <= 0) goto L43;
        boolean r12 = true;
    L44:
        RequestSongMicSeatView.m(r10, r16, r11, r8, r9, false, false, false, r12, this.h instanceof l, this.c, 112);
        RequestSongMicSeatView r13 = this.f;
        if (r13 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L47:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        this.a = r13;
        return;
    L43:
        r12 = false;
    L21:
        g r14 = this.h;
        if (r14 == null) goto L24;
        Object r15 = r14.m(2131389701);
    L26:
        if ((r15 instanceof PositionNameTv) == true) goto L28;
        r15 = null;
    L28:
        PositionNameTv r17 = (PositionNameTv) r15;
        g r18 = this.h;
        if (r18 == null) goto L31;
        View r19 = r18.m(2131389764);
    L33:
        if ((r19 instanceof SeatPosTagLabelTextView) == false) goto L36;
        r3 = r19;
    L36:
        r8 = r17;
        r9 = (SeatPosTagLabelTextView) r3;
        goto L37
    L31:
        r19 = null;
        goto L33
    L24:
        r15 = null;
        goto L26
    L12:
        r6 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkGuestViewBinder.a) r1, r2);
    }

    public final void r(MultiLinkGuestViewBinder.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        this.e = r6;
        boolean r0 = false;
        if (r6 == null) goto L5;
        int r1 = r6.d;
    L7:
        if (r1 <= 0) goto L28;
        IBaseUser r8 = r6.k.a.getUser();
        String r2 = null;
        if (r8 == null) goto L11;
        String r9 = r8.getIdString();
    L12:
        IRoom r3 = r6.h;
        if (r3 == null) goto L15;
        r2 = r3.getAnchorId();
    L15:
        boolean r10 = Intrinsics.areEqual(r9, r2);
        MultiLinkGuestViewBinder.a r4 = this.e;
        if (r4 == null) goto L42;
        pf0.a r5 = r4.m;
        if (r5 == null) goto L43;
        RequestSongMicSeatView r11 = this.f;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L22:
        int r12 = r5.b;
        ILinkPlayerInfoBridge r13 = r6.k.a;
        wg0.a r14 = r6.n;
        if (r14 != null) goto L25;
    L27:
        r11.t(r12, r13, r10, r0);
        return;
    L25:
        if (r14.a != true) goto L27;
        r0 = true;
        goto L27
    L43:
        return;
    L42:
        return;
    L11:
        r9 = null;
        goto L12
    L28:
        if (r6 == null) goto L37;
        ch0.e r15 = r6.k;
        if (r15 == null) goto L37;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L37;
        RequestSongMicSeatView r17 = this.f;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L36:
        r17.l(r16, r7);
    L37:
        RequestSongMicSeatView r18 = this.f;
        if (r18 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L40:
        r18.p();
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // jg0.f
    public final void k(Object r7, int r8, Bundle r9) {
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r7;
        Intrinsics.checkNotNullParameter(r10, "itemData");
        Intrinsics.checkNotNullParameter(r9, "payload");
        this.e = r10;
        Iterator<String> r11 = r9.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L138;
        String r0 = r11.next();
        if (r0 == null) goto L4;
        String r3 = null;
        Object r4 = null;
        String r5 = null;
        r5 = null;
        Object r6 = null;
        switch(r0.hashCode()) {
            case -2054590407: goto L127;
            case -1236292194: goto L105;
            case -715388833: goto L102;
            case -703589172: goto L99;
            case 236305799: goto L34;
            case 1416202744: goto L12;
            default: goto L4;
        };
    L12:
        if (r0.equals("payload_key_interact_song_golden_mic_display_state") == false) goto L4;
        Object r1 = r10.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC");
        if ((r1 instanceof Boolean) == false) goto L17;
        r4 = r1;
    L17:
        Boolean r12 = (Boolean) r4;
        if (r12 == null) goto L4;
        boolean r2 = r12.booleanValue();
        MultiLinkGuestViewBinder.a r13 = this.e;
        if (r13 == null) goto L29;
        ch0.e r14 = r13.k;
        if (r14 == null) goto L29;
        ILinkPlayerInfoBridge r15 = r14.a;
        if (r15 == null) goto L29;
        RequestSongMicSeatView r16 = this.f;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L28:
        r16.setMCurPositionInfo(r15);
    L29:
        RequestSongMicSeatView r17 = this.f;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L32:
        r17.y(r2);
        goto L4
    L34:
        if (r0.equals("payload_key_feedview_interact_song_golden_mic_online_state") == false) goto L4;
        Object r18 = r10.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE");
        if ((r18 instanceof IMicrophoneItem) == true) goto L38;
        r18 = null;
    L38:
        IMicrophoneItem r19 = (IMicrophoneItem) r18;
        if (r19 == null) goto L4;
        MultiLinkGuestViewBinder.a r20 = this.e;
        if (r20 == null) goto L50;
        ch0.e r21 = r20.k;
        if (r21 == null) goto L50;
        ILinkPlayerInfoBridge r22 = r21.a;
        if (r22 == null) goto L50;
        RequestSongMicSeatView r23 = this.f;
        if (r23 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L49:
        r23.setMCurPositionInfo(r22);
    L50:
        MultiLinkGuestViewBinder.a r24 = this.e;
        if (r24 == null) goto L55;
        ch0.e r25 = r24.k;
        if (r25 == null) goto L55;
        ILinkPlayerInfoBridge r26 = r25.a;
    L56:
        Intrinsics.checkNotNullParameter(r19, "microphoneItem");
        MultiLinkGuestViewBinder.a r27 = this.e;
        if (r27 == null) goto L59;
        int r28 = r27.d;
    L61:
        if (h.f(r28) == false) goto L4;
        MultiLinkGuestViewBinder.a r29 = this.e;
        if (r29 == null) goto L71;
        ch0.e r30 = r29.k;
        if (r30 == null) goto L71;
        ILinkPlayerInfoBridge r31 = r30.a;
        if (r31 == null) goto L71;
        IBaseUser r32 = r31.getUser();
        if (r32 == null) goto L71;
        String r33 = r32.getIdString();
    L72:
        MultiLinkGuestViewBinder.a r34 = this.e;
        if (r34 == null) goto L77;
        IRoom r35 = r34.h;
        if (r35 == null) goto L77;
        String r36 = r35.getAnchorId();
    L78:
        boolean r37 = Intrinsics.areEqual(r33, r36);
        boolean r38 = false;
        if (r37 == false) goto L88;
        int r39 = r.a;
        MultiLinkGuestViewBinder.a r40 = this.e;
        if (r40 == null) goto L86;
        IRoom r41 = r40.h;
        if (r41 == null) goto L86;
        r5 = r41.getAnchorId();
    L86:
        if (r.b(r5) == true) goto L88;
        boolean r42 = true;
    L89:
        RequestSongMicSeatView r43 = this.f;
        if (r43 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L92:
        int r44 = r19.getMicroPhoneNum();
        MultiLinkGuestViewBinder.a r45 = this.e;
        if (r45 == null) goto L97;
        wg0.a r46 = r45.n;
        if (r46 == null) goto L97;
        r38 = r46.a;
    L97:
        r43.t(r44, r26, r42, r38);
    L88:
        r42 = false;
    L77:
        r36 = null;
    L71:
        r33 = null;
        goto L72
    L59:
        r28 = -1;
    L55:
        r26 = null;
        goto L56
    L99:
        if (r0.equals("payload_key_user_position") == false) goto L4;
    L103:
        r(r10, r8);
        goto L4
    L102:
        if (r0.equals("payload_key_is_c_position_update") == false) goto L4;
    L105:
        if (r0.equals("payload_key_interact_song_golden_mic_info_update") == false) goto L4;
        Object r47 = r10.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO");
        if ((r47 instanceof pf0.a) == false) goto L110;
        r6 = r47;
    L110:
        pf0.a r48 = (pf0.a) r6;
        if (r48 == null) goto L4;
        MultiLinkGuestViewBinder.a r49 = this.e;
        if (r49 == null) goto L122;
        ch0.e r50 = r49.k;
        if (r50 == null) goto L122;
        ILinkPlayerInfoBridge r51 = r50.a;
        if (r51 == null) goto L122;
        RequestSongMicSeatView r52 = this.f;
        if (r52 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L121:
        r52.setMCurPositionInfo(r51);
    L122:
        Intrinsics.checkNotNullParameter(r48, "info");
        RequestSongMicSeatView r53 = this.f;
        if (r53 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L125:
        r53.z(r48);
        goto L4
    L127:
        if (r0.equals("payload_key_play_mode_state_update") == false) goto L4;
        IBaseUser r54 = r10.k.a.getUser();
        if (r54 == null) goto L131;
        String r55 = r54.getIdString();
    L132:
        IRoom r56 = r10.h;
        if (r56 == null) goto L136;
        r3 = r56.getAnchorId();
    L136:
        if (Intrinsics.areEqual(r55, r3) == false) goto L4;
        r(r10, r8);
        goto L4
    L131:
        r55 = null;
        goto L132
    }

    public a(MicSeatScene r2, sg0.b r3, MultiLinkAudioCommonGuestMicSeatBasicLayer r4, xg0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "basicLayer");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        super(r2, r5);
        this.g = r3;
        this.h = r4;
    }
}
