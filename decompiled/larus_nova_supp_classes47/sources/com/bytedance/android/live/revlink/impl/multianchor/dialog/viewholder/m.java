package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import dq2.w;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ MultiLinkRivalsSearchViewHolder a;
    public final /* synthetic */ x8 b;

    public m(MultiLinkRivalsSearchViewHolder r1, x8 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        MultiLinkRivalsSearchViewHolder r15 = this.a;
        x8 r0 = this.b;
        int r1 = MultiLinkRivalsSearchViewHolder.w;
        r15.getClass();
        IRoom r2 = r0.getRoom();
        if (r2 != null) goto L5;
        return;
    L5:
        if (r15.q == null) goto L137;
        int r3 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
        w r4 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        Intrinsics.checkNotNull(r4);
        if (r4.w() <= 0) goto L10;
        boolean r5 = true;
    L12:
        if (v.a(r3, 32) == false) goto L18;
        if (r5 == false) goto L18;
        if (r2.getLinkMap().containsKey(String.valueOf(7)) == false) goto L17;
        ToastUtil.a(2131917514, 0);
        return;
    L17:
        ToastUtil.a(2131917515, 0);
        return;
    L18:
        z5 r6 = ((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkerDetail();
        String r7 = null;
        if (r6 == null) goto L25;
        List r8 = r6.getPlayModes();
        if (r8 == null) goto L25;
        if (r8.contains(3L) != true) goto L25;
        jy0.b.b("ttlive_pk", "ignore apply btn click for playmodes container MULTI_PK", null);
        return;
    L25:
        i11.b r9 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r2.getLinkMap().containsKey(String.valueOf(7)) == false) goto L96;
        if (r0.getRivalExtraInfo() == null) goto L41;
        IRivalExtraInfo r10 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r10);
        if (r10.getLinkerInfo() == null) goto L41;
        IRivalExtraInfo r12 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r12);
        d6 r13 = r12.getLinkerInfo();
        Intrinsics.checkNotNull(r13);
        if (r13.getLinkedUserInfos() == null) goto L41;
        IRivalExtraInfo r16 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r16);
        d6 r17 = r16.getLinkerInfo();
        Intrinsics.checkNotNull(r17);
        List r18 = r17.getLinkedUserInfos();
        Intrinsics.checkNotNull(r18);
        if (r18.size() != r41.f.b) goto L41;
        Context r19 = s1.getContext();
        if (r41.f.a == false) goto L38;
        String r20 = s1.B(2131914801);
    L39:
        IESUIUtils.displayToast(r19, r20);
        return;
    L38:
        r20 = s1.B(2131914799);
    L41:
        if (r15.V3(r2.getOwner()) == false) goto L43;
        r15.v.jm(r0, 1);
        return;
    L43:
        Long r22 = (Long) r2.getLinkMap().get(String.valueOf(7));
        LinkCrossRoomDataHolder r23 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r23 == null) goto L46;
        Long r24 = Long.valueOf(r23.c());
    L48:
        if ((!Intrinsics.areEqual(r22, r24)) == true) goto L50;
        return;
    L50:
        if (r15.m != SearchSourceFlag.INVITE_LINKING) goto L60;
        if (r9 != null) goto L53;
    L55:
        if (r9 != null) goto L57;
        return;
    L57:
        if (r9.d().size() >= r41.f.b) goto L130;
        r15.v.Ko(r15.l, r0);
        return;
    L130:
        return;
    L53:
        if (r9.getOnlineUserList().size() != r41.f.b) goto L55;
        IESUIUtils.displayToast(s1.getContext(), s1.B(2131914766));
        return;
    L60:
        if (r9 != null) goto L62;
    L64:
        if (r9 != null) goto L66;
    L70:
        if (r9 != null) goto L72;
    L74:
        IESUIUtils.displayToast(s1.getContext(), s1.B(2131914737));
    L75:
        HashMap r110 = new HashMap();
        JSONArray r25 = new JSONArray();
        if (r0.getRivalExtraInfo() == null) goto L91;
        IRivalExtraInfo r26 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r26);
        if (r26.getLinkerInfo() == null) goto L91;
        IRivalExtraInfo r27 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r27);
        d6 r28 = r27.getLinkerInfo();
        Intrinsics.checkNotNull(r28);
        if (r28.getLinkedUserInfos() == null) goto L91;
        IRivalExtraInfo r29 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r29);
        d6 r30 = r29.getLinkerInfo();
        Intrinsics.checkNotNull(r30);
        List r32 = r30.getLinkedUserInfos();
        Intrinsics.checkNotNull(r32);
        r110.put("anchor_connect_status", String.valueOf(r32.size()));
        IRivalExtraInfo r33 = r0.getRivalExtraInfo();
        Intrinsics.checkNotNull(r33);
        d6 r34 = r33.getLinkerInfo();
        Intrinsics.checkNotNull(r34);
        List r35 = r34.getLinkedUserInfos();
        Intrinsics.checkNotNull(r35);
        Iterator r36 = r35.iterator();
    L83:
        if (r36.hasNext() == false) goto L91;
        t5 r37 = (t5) r36.next();
        String r38 = r37.getUserId();
        LinkCrossRoomDataHolder r39 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r39 == null) goto L87;
        String r40 = r39.g();
    L89:
        if (TextUtils.equals(r38, r40) == true) goto L83;
        r25.put(r37.getUserId());
        goto L83
    L87:
        r40 = null;
    L91:
        r110.put("connecting_list", r25.toString());
        LinkCrossRoomDataHolder r42 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r42 == null) goto L94;
        r7 = r42.g();
    L94:
        r110.put("right_user_id", String.valueOf(r7));
        mz0.n r43 = new mz0.n();
        Map<String, String> r44 = r43.a;
        Intrinsics.checkNotNullParameter(r44, "map");
        Intrinsics.checkNotNullParameter(r110, "map");
        r44.putAll(r110);
        mz0.m r111 = new mz0.m();
        r111.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder.a r45 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.a(r111);
        ((ArrayList) r43.b).addAll(r111.a);
        cy0.e.a.getClass();
        cy0.j r112 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r113);
        ((mz0.i) ((f80.a) r113)).w3("livesdk_apply_icon_click", r43.a, r43.b);
        return;
    L72:
        if (r9.n().isEmpty() == false) goto L74;
        r15.v.v6(r15.l, r0, r15.u);
        goto L75
    L66:
        if (r9.getOnlineUserList().isEmpty() == true) goto L70;
        if (r9.n().isEmpty() == false) goto L70;
        com.bytedance.android.live.revlink.impl.pk.ui.h.a r46 = new com.bytedance.android.live.revlink.impl.pk.ui.h.a(r15.p);
        r46.a = s1.B(2131914744);
        r46.b = s1.B(2131914743);
        String r47 = s1.B(2131914747);
        r46.c = j.a;
        r46.d = r47;
        String r48 = s1.B(2131922197);
        r46.e = new MultiLinkRivalsSearchViewHolder$handleClick$4(r15, r0);
        r46.f = r48;
        r46.a();
        goto L75
    L62:
        if (r9.getInviteeList().isEmpty() == true) goto L64;
        com.bytedance.android.live.revlink.impl.pk.ui.h.a r49 = new com.bytedance.android.live.revlink.impl.pk.ui.h.a(r15.p);
        r49.a = s1.B(2131914744);
        r49.b = s1.B(2131914742);
        String r50 = s1.B(2131914747);
        r49.c = h.a;
        r49.d = r50;
        String r52 = s1.B(2131922197);
        r49.e = new i(r15, r9, r0);
        r49.f = r52;
        r49.a();
        goto L75
    L46:
        r24 = null;
        goto L48
    L96:
        if (r15.W3(r2.getOwner()) == false) goto L98;
        r15.v.jm(r0, 0);
        return;
    L98:
        if (r9 != null) goto L100;
    L102:
        if (r9 != null) goto L104;
    L106:
        if (r9 != null) goto L108;
    L110:
        Context r114 = s1.getContext();
        if (r41.f.a == false) goto L113;
        String r53 = s1.B(2131914801);
    L114:
        IESUIUtils.displayToast(r114, r53);
        return;
    L113:
        r53 = s1.B(2131914799);
        goto L114
    L108:
        if (r9.d().size() >= r41.f.b) goto L110;
        r15.v.Ko(r15.l, r0);
        return;
    L104:
        if (r9.getOnlineUserList().size() != r41.f.b) goto L106;
        IESUIUtils.displayToast(s1.getContext(), s1.B(2131914766));
        return;
    L100:
        if (r9.n().isEmpty() == true) goto L102;
        com.bytedance.android.live.revlink.impl.pk.ui.h.a r54 = new com.bytedance.android.live.revlink.impl.pk.ui.h.a(r15.p);
        r54.a = s1.B(2131914751);
        r54.b = s1.B(2131914750);
        String r55 = s1.B(2131914747);
        r54.c = k.a;
        r54.d = r55;
        String r56 = s1.B(2131922197);
        r54.e = new l(r15, r9, r0);
        r54.f = r56;
        r54.a();
        return;
    L10:
        r5 = false;
        goto L12
    }
}
