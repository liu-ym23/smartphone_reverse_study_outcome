package lg0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongMicSeatView;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
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
import pg0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends jg0.a<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a e;
    public RequestSongMicSeatView f;
    public final b g;
    public final g h;

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        RequestSongMicSeatView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L5:
        r0.n();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r16) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Object r9 = null;
        this.f = new RequestSongMicSeatView(r16, null, 0, true, 6);
        Object r1 = this.g.m(2131389701);
        if ((r1 instanceof PositionNameTv) == true) goto L5;
        r1 = null;
    L5:
        PositionNameTv r2 = (PositionNameTv) r1;
        b r3 = this.g;
        if (r3 == null) goto L8;
        Object r4 = r3.m(2131389764);
    L10:
        if ((r4 instanceof SeatPosTagLabelTextView) == true) goto L12;
        r4 = null;
    L12:
        SeatPosTagLabelTextView r5 = (SeatPosTagLabelTextView) r4;
        if (r2 == null) goto L17;
        if (r5 == null) goto L17;
        PositionNameTv r6 = r2;
        SeatPosTagLabelTextView r7 = r5;
    L33:
        RequestSongMicSeatView r8 = this.f;
        if (r8 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L36:
        MicSeatScene r10 = this.b;
        if (n() <= 0) goto L39;
        boolean r11 = true;
    L40:
        RequestSongMicSeatView.m(r8, r16, r10, r6, r7, false, false, false, r11, false, this.c, 368);
        RequestSongMicSeatView r12 = this.f;
        if (r12 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L43:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.a = r12;
        return;
    L39:
        r11 = false;
    L17:
        g r13 = this.h;
        if (r13 == null) goto L20;
        Object r14 = r13.m(2131389701);
    L22:
        if ((r14 instanceof PositionNameTv) == true) goto L24;
        r14 = null;
    L24:
        PositionNameTv r15 = (PositionNameTv) r14;
        g r17 = this.h;
        if (r17 == null) goto L27;
        View r18 = r17.m(2131389764);
    L29:
        if ((r18 instanceof SeatPosTagLabelTextView) == false) goto L32;
        r9 = r18;
    L32:
        r6 = r15;
        r7 = (SeatPosTagLabelTextView) r9;
        goto L33
    L27:
        r18 = null;
        goto L29
    L20:
        r14 = null;
        goto L22
    L8:
        r4 = null;
        goto L10
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkGuestViewBinder.a) r1, r2);
    }

    public final void r(MultiLinkGuestViewBinder.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        this.e = r6;
        if (InteractiveSongContext.Companion.f() == true) goto L5;
        return;
    L5:
        MultiLinkGuestViewBinder.a r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L8;
        int r2 = r0.d;
    L10:
        if (r2 <= 0) goto L31;
        IBaseUser r8 = r6.k.a.getUser();
        String r3 = null;
        if (r8 == null) goto L14;
        String r9 = r8.getIdString();
    L15:
        IRoom r4 = r6.h;
        if (r4 == null) goto L18;
        r3 = r4.getAnchorId();
    L18:
        boolean r10 = Intrinsics.areEqual(r9, r3);
        MultiLinkGuestViewBinder.a r5 = this.e;
        if (r5 == null) goto L45;
        pf0.a r11 = r5.m;
        if (r11 == null) goto L46;
        RequestSongMicSeatView r12 = this.f;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L25:
        int r13 = r11.b;
        ILinkPlayerInfoBridge r14 = r6.k.a;
        wg0.a r15 = r6.n;
        if (r15 != null) goto L28;
    L30:
        r12.t(r13, r14, r10, r1);
        return;
    L28:
        if (r15.a != true) goto L30;
        r1 = true;
        goto L30
    L46:
        return;
    L45:
        return;
    L14:
        r9 = null;
        goto L15
    L31:
        RequestSongMicSeatView r16 = this.f;
        if (r16 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L34:
        r16.p();
        MultiLinkGuestViewBinder.a r17 = this.e;
        if (r17 == null) goto L48;
        e r18 = r17.k;
        if (r18 == null) goto L49;
        ILinkPlayerInfoBridge r19 = r18.a;
        if (r19 == null) goto L50;
        RequestSongMicSeatView r20 = this.f;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L43:
        r20.l(r19, r7);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L8:
        r2 = 0;
        goto L10
    }

    @Override // jg0.f
    public final void k(Object r7, int r8, Bundle r9) {
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r7;
        Intrinsics.checkNotNullParameter(r10, "itemData");
        Intrinsics.checkNotNullParameter(r9, "payload");
        this.e = r10;
        Iterator<String> r11 = r9.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L129;
        String r0 = r11.next();
        if (r0 == null) goto L4;
        Object r2 = null;
        Object r3 = null;
        String r4 = null;
        r4 = null;
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
        r3 = r1;
    L17:
        Boolean r5 = (Boolean) r3;
        if (r5 == null) goto L4;
        boolean r6 = r5.booleanValue();
        MultiLinkGuestViewBinder.a r12 = this.e;
        if (r12 == null) goto L29;
        e r13 = r12.k;
        if (r13 == null) goto L29;
        ILinkPlayerInfoBridge r14 = r13.a;
        if (r14 == null) goto L29;
        RequestSongMicSeatView r15 = this.f;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L28:
        r15.setMCurPositionInfo(r14);
    L29:
        RequestSongMicSeatView r16 = this.f;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L32:
        r16.y(r6);
        goto L4
    L34:
        if (r0.equals("payload_key_feedview_interact_song_golden_mic_online_state") == false) goto L4;
        Object r17 = r10.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE");
        if ((r17 instanceof IMicrophoneItem) == true) goto L38;
        r17 = null;
    L38:
        IMicrophoneItem r18 = (IMicrophoneItem) r17;
        if (r18 == null) goto L4;
        MultiLinkGuestViewBinder.a r19 = this.e;
        if (r19 == null) goto L50;
        e r20 = r19.k;
        if (r20 == null) goto L50;
        ILinkPlayerInfoBridge r21 = r20.a;
        if (r21 == null) goto L50;
        RequestSongMicSeatView r22 = this.f;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L49:
        r22.setMCurPositionInfo(r21);
    L50:
        MultiLinkGuestViewBinder.a r23 = this.e;
        if (r23 == null) goto L55;
        e r24 = r23.k;
        if (r24 == null) goto L55;
        ILinkPlayerInfoBridge r25 = r24.a;
    L56:
        Intrinsics.checkNotNullParameter(r18, "microphoneItem");
        MultiLinkGuestViewBinder.a r26 = this.e;
        if (r26 == null) goto L59;
        int r27 = r26.d;
    L61:
        if (h.f(r27) == false) goto L4;
        MultiLinkGuestViewBinder.a r28 = this.e;
        if (r28 == null) goto L71;
        e r29 = r28.k;
        if (r29 == null) goto L71;
        ILinkPlayerInfoBridge r30 = r29.a;
        if (r30 == null) goto L71;
        IBaseUser r31 = r30.getUser();
        if (r31 == null) goto L71;
        String r32 = r31.getIdString();
    L72:
        MultiLinkGuestViewBinder.a r33 = this.e;
        if (r33 == null) goto L77;
        IRoom r34 = r33.h;
        if (r34 == null) goto L77;
        String r35 = r34.getAnchorId();
    L78:
        boolean r36 = Intrinsics.areEqual(r32, r35);
        boolean r37 = false;
        if (r36 == false) goto L88;
        int r38 = r.a;
        MultiLinkGuestViewBinder.a r39 = this.e;
        if (r39 == null) goto L86;
        IRoom r40 = r39.h;
        if (r40 == null) goto L86;
        r4 = r40.getAnchorId();
    L86:
        if (r.b(r4) == true) goto L88;
        boolean r41 = true;
    L89:
        RequestSongMicSeatView r42 = this.f;
        if (r42 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L92:
        int r43 = r18.getMicroPhoneNum();
        MultiLinkGuestViewBinder.a r44 = this.e;
        if (r44 == null) goto L97;
        wg0.a r45 = r44.n;
        if (r45 == null) goto L97;
        r37 = r45.a;
    L97:
        r42.t(r43, r25, r41, r37);
    L88:
        r41 = false;
    L77:
        r35 = null;
    L71:
        r32 = null;
        goto L72
    L59:
        r27 = -1;
    L55:
        r25 = null;
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
        Object r46 = r10.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO");
        if ((r46 instanceof pf0.a) == false) goto L110;
        r2 = r46;
    L110:
        pf0.a r47 = (pf0.a) r2;
        if (r47 == null) goto L4;
        MultiLinkGuestViewBinder.a r48 = this.e;
        if (r48 == null) goto L122;
        e r49 = r48.k;
        if (r49 == null) goto L122;
        ILinkPlayerInfoBridge r50 = r49.a;
        if (r50 == null) goto L122;
        RequestSongMicSeatView r51 = this.f;
        if (r51 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L121:
        r51.setMCurPositionInfo(r50);
    L122:
        RequestSongMicSeatView r52 = this.f;
        if (r52 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestSongMicSeatView");
    L125:
        r52.z(r47);
        goto L4
    L127:
        if (r0.equals("payload_key_play_mode_state_update") == false) goto L4;
        r(r10, r8);
        goto L4
    }

    public a(MicSeatScene r2, b r3, MultiLinkCommonGuestMicSeatBasicLayer r4, xg0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "statusLayer");
        Intrinsics.checkNotNullParameter(r4, "basicLayer");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        super(r2, r5);
        this.g = r3;
        this.h = r4;
    }
}
