package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkResultContributeAvatarView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IAudienceLeaveInfoResponse;
import com.bytedance.android.livesdk.chatroom.model.IUserInfoInLinkmic;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceRecommendItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    public y(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkResultContributeAvatarView] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List] */
    public final void accept(Object r26) {
        ExtraResponse<IAudienceLeaveInfoResponse, Extra> r1 = (ExtraResponse) r26;
        this.a.n = r1;
        if (r1 == null) goto L7;
        IAudienceLeaveInfoResponse r3 = r1.data;
        if (r3 == null) goto L7;
        IUserInfoInLinkmic r4 = r3.getUserInfoInLinkmic();
    L9:
        if (r4 == null) goto L13;
        Long r6 = r4.getContributorCount();
        if (r6 == null) goto L13;
        long r7 = r6.longValue();
    L14:
        if (r4 == null) goto L18;
        Long r8 = r4.getFirstSendGiftContributorCount();
        if (r8 == null) goto L18;
        long r9 = r8.longValue();
    L19:
        if (r4 == null) goto L23;
        Long r10 = r4.getAddFollowersCount();
        if (r10 == null) goto L23;
        long r11 = r10.longValue();
    L25:
        if (r7 > 0) goto L33;
        if (r11 > 0) goto L33;
        if (r9 > 0) goto L33;
        this.a.S90(2131392491).setVisibility(8);
        ((FrameLayout) this.a.S90(2131372769)).setVisibility(8);
        r4 = r4;
    L66:
        int r5 = d0.a;
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L69;
        IRoom r13 = (IRoom) r12.getValue();
    L70:
        LinkResultDialogFragmentV2 r14 = this.a;
        int r15 = r14.j;
        int r16 = r14.l;
        HashMap r17 = new HashMap();
        if (r13 == null) goto L73;
        String r18 = com.bytedance.android.live.ktv.common.util.j.f(r13);
    L74:
        r17.put("live_type", r18);
        if (r13 == null) goto L78;
        String r2 = r13.getAnchorId();
        if (r2 == null) goto L78;
    L79:
        r17.put("anchor_id", r2);
        if (r13 == null) goto L82;
        long r19 = r13.getId();
    L83:
        r17.put("room_id", String.valueOf(r19));
        r17.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        r17.put("connection_over_type", d0.a(r15));
        r17.put("connection_over_type_detail", d0.b(Integer.valueOf(r16), r15));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_more_icon_show", r17, new Object[]{IRoom.class, am2.x.class});
        TextView r20 = (TextView) this.a.S90(2131390878);
        if (r20 == null) goto L86;
        r20.setOnClickListener(new x(this, r7));
    L86:
        if (r4 == null) goto L97;
        String r21 = r4.getTextInfo();
        if (r21 == null) goto L97;
        if (r21.length() <= 0) goto L92;
        boolean r22 = true;
        boolean r110 = true;
    L93:
        if (r110 != r22) goto L97;
        TextView r23 = (TextView) this.a.S90(2131391617);
        if (r23 == null) goto L97;
        r23.setText(r4.getTextInfo());
        goto L97
    L92:
        r22 = true;
        r110 = false;
    L97:
        LinkResultDialogFragmentV2 r24 = this.a;
        if (r4 == null) goto L102;
        Long r25 = r4.getLinkDuration();
        if (r25 == null) goto L102;
        long r27 = r25.longValue();
    L103:
        r24.f = r27;
        LinkResultDialogFragmentV2 r28 = this.a;
        if (r4 == null) goto L107;
        String r29 = r4.getAddFanTicketStr();
        if (r29 == null) goto L107;
    L108:
        r28.h = r29;
        LinkResultDialogFragmentV2 r30 = this.a;
        if (r4 == null) goto L113;
        Long r31 = r4.getAddFollowersCount();
        if (r31 == null) goto L113;
        long r32 = r31.longValue();
    L114:
        r30.g = r32;
        this.a.V90();
        LinkResultDialogFragmentV2 r33 = this.a;
        if (r1 == null) goto L119;
        IAudienceLeaveInfoResponse r34 = r1.data;
        if (r34 == null) goto L119;
        LinkmicAudienceRecommendItem r35 = r34.getLinkmicAudienceRecommendItem();
    L120:
        LinkResultDialogFragmentV2.U90(r33, r35);
        return;
    L119:
        r35 = null;
    L113:
        r32 = 0;
    L107:
        r29 = "0";
    L102:
        r27 = 0;
        goto L103
    L82:
        r19 = 0;
    L78:
        r2 = "";
        goto L79
    L73:
        r18 = "";
        goto L74
    L69:
        r13 = null;
    L33:
        if (r9 <= 0) goto L36;
        Pair r111 = new Pair(s1.C(2131918722, new Object[]{Long.valueOf(r9)}), "first_gift");
    L39:
        String r36 = (String) r111.component1();
        String r37 = (String) r111.component2();
        this.a.S90(2131392491).setVisibility(0);
        int r38 = d0.a;
        com.bytedance.live.datacontext.m r39 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r39 == null) goto L42;
        IRoom r40 = (IRoom) r39.getValue();
    L43:
        LinkResultDialogFragmentV2 r41 = this.a;
        int r112 = r41.j;
        int r42 = r41.l;
        Intrinsics.checkNotNullParameter(r37, "iconType");
        HashMap r113 = new HashMap();
        if (r40 == null) goto L46;
        String r43 = com.bytedance.android.live.ktv.common.util.j.f(r40);
    L47:
        r113.put("live_type", r43);
        if (r40 == null) goto L51;
        String r44 = r40.getAnchorId();
        if (r44 == null) goto L51;
    L52:
        r113.put("anchor_id", r44);
        if (r40 == null) goto L55;
        long r210 = r40.getId();
    L56:
        r113.put("room_id", String.valueOf(r210));
        r113.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        r113.put("connection_over_type", d0.a(r112));
        r113.put("connection_over_type_detail", d0.b(Integer.valueOf(r42), r112));
        r113.put("icon_type", r37);
        r113.put("userlist_num", String.valueOf(r7));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_giftuser_icon_show", r113, new Object[]{IRoom.class, am2.x.class});
        ((FrameLayout) this.a.S90(2131372769)).setVisibility(0);
        ((FrameLayout) this.a.S90(2131372769)).setOnClickListener(new w(this, r7, r37));
        ((TextView) this.a.S90(2131391303)).setText(HtmlCompat.fromHtml(r36, 63));
        if (r4 == 0) goto L64;
        List r45 = r4.getContributors();
        if (r45 == null) goto L64;
        List r46 = r45;
        ?? r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10));
        Iterator<T> r48 = r46.iterator();
    L62:
        if (r48.hasNext() == false) goto L65;
        r47.add(((IBaseUser) r48.next()).getAvatarThumbKt());
    L65:
        ((LinkResultContributeAvatarView) this.a.S90(2131392490)).setAvatarList(r47);
    L64:
        r47 = CollectionsKt.emptyList();
        goto L65
    L55:
        r210 = 0;
    L51:
        r44 = "";
        goto L52
    L46:
        r43 = "";
        goto L47
    L42:
        r40 = null;
        goto L43
    L36:
        if (r7 <= 0) goto L38;
        r111 = new Pair(s1.C(2131918721, new Object[]{Long.valueOf(r7)}), "send_gift");
        goto L39
    L38:
        r111 = new Pair(s1.C(2131918720, new Object[]{Long.valueOf(r11)}), "new_fans");
    L23:
        r11 = 0;
    L18:
        r9 = 0;
    L13:
        r7 = 0;
    L7:
        r4 = null;
        goto L9
    }
}
