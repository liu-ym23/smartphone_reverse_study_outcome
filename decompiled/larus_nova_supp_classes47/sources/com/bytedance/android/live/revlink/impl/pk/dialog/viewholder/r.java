package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import dq2.w;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ PKRivalsRankViewHolder a;
    public final /* synthetic */ IRoom b;
    public final /* synthetic */ m2 c;
    public final /* synthetic */ IRivalExtraInfo d;
    public final /* synthetic */ SearchSourceFlag e;

    public r(PKRivalsRankViewHolder r1, IRoom r2, m2 r3, IRivalExtraInfo r4, SearchSourceFlag r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        PKRivalsRankViewHolder r1 = this.a;
        IRoom r2 = this.b;
        m2 r3 = this.c;
        IRivalExtraInfo r4 = this.d;
        boolean r5 = r1.s;
        SearchSourceFlag r6 = this.e;
        int r7 = 2131914801;
        Object r12 = null;
        if (r5 == false) goto L102;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r1.p == null) goto L241;
        int r8 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
        w r13 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        Intrinsics.checkNotNull(r13);
        if (r13.w() <= 0) goto L11;
        boolean r14 = true;
    L13:
        if (v.a(r8, 32) == false) goto L20;
        if (r14 == false) goto L20;
        if (((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkMap().containsKey(String.valueOf(7)) == false) goto L18;
        ToastUtil.a(2131917514, 0);
        return;
    L18:
        ToastUtil.a(2131917515, 0);
        return;
    L20:
        if (((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkMicInfo() == null) goto L23;
        return;
    L23:
        if (((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkerDetail() == null) goto L36;
        z5 r9 = ((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r9 == null) goto L27;
        List r10 = r9.getPlayModes();
    L28:
        if (r10 == null) goto L36;
        z5 r15 = ((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r15 == null) goto L36;
        List r16 = r15.getPlayModes();
        if (r16 == null) goto L36;
        if (r16.contains(3L) != true) goto L36;
        jy0.b.b("ttlive_pk", "ignore apply btn click for playmodes container MULTI_PK", null);
        return;
    L27:
        r10 = null;
    L36:
        if (r4 == null) goto L38;
        d6 r17 = r4.getLinkerInfo();
    L39:
        if (r17 == null) goto L49;
        d6 r19 = r4.getLinkerInfo();
        if (r19 == null) goto L45;
        List r20 = r19.getLinkedUserInfos();
        if (r20 == null) goto L45;
        int r22 = r20.size();
    L47:
        if (r22 < r41.f.b) goto L49;
        return;
    L45:
        r22 = 0;
    L49:
        i11.b r23 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r6 != SearchSourceFlag.MAIN_LINK) goto L83;
        if (r2.getLinkMap().containsKey(String.valueOf(7)) == false) goto L83;
        if (r1.V3(r2.getOwner()) == false) goto L56;
        r1.v.a(r3, 1);
        return;
    L56:
        Long r24 = (Long) r2.getLinkMap().get(String.valueOf(7));
        LinkCrossRoomDataHolder r25 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r25 == null) goto L59;
        Long r26 = Long.valueOf(r25.c());
    L61:
        if ((!Intrinsics.areEqual(r24, r26)) == true) goto L63;
        return;
    L63:
        if (r23 != null) goto L65;
    L67:
        if (r23 != null) goto L69;
    L73:
        if (r23 != null) goto L75;
    L77:
        IESUIUtils.displayToast(s1.getContext(), s1.B(2131914737));
    L78:
        HashMap r27 = new HashMap();
        LinkCrossRoomDataHolder r28 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r28 == null) goto L81;
        r12 = r28.g();
    L81:
        r27.put("right_user_id", String.valueOf(r12));
        mz0.n r29 = new mz0.n();
        Map<String, String> r30 = r29.a;
        Intrinsics.checkNotNullParameter(r30, "map");
        Intrinsics.checkNotNullParameter(r27, "map");
        r30.putAll(r27);
        mz0.m r32 = new mz0.m();
        r32.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder.a r33 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.a(r32);
        ((ArrayList) r29.b).addAll(r32.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((mz0.i) ((f80.a) r35)).w3("livesdk_apply_icon_click", r29.a, r29.b);
        return;
    L75:
        if (r23.n().isEmpty() == false) goto L77;
        r1.v.b(r1.k, r3);
        goto L78
    L69:
        if (r23.getOnlineUserList().isEmpty() == true) goto L73;
        if (r23.n().isEmpty() == false) goto L73;
        com.bytedance.android.live.revlink.impl.pk.ui.h.a r36 = new com.bytedance.android.live.revlink.impl.pk.ui.h.a(r1.o);
        r36.a = s1.B(2131914744);
        r36.b = s1.B(2131914743);
        String r37 = s1.B(2131914747);
        r36.c = o.a;
        r36.d = r37;
        String r38 = s1.B(2131922197);
        r36.e = new PKRivalsRankViewHolder$handleMultiLinkClick$4(r1, r3);
        r36.f = r38;
        r36.a();
        goto L78
    L65:
        if (r23.getInviteeList().isEmpty() == true) goto L67;
        com.bytedance.android.live.revlink.impl.pk.ui.h.a r39 = new com.bytedance.android.live.revlink.impl.pk.ui.h.a(r1.o);
        r39.a = s1.B(2131914744);
        r39.b = s1.B(2131914742);
        String r40 = s1.B(2131914747);
        r39.c = m.a;
        r39.d = r40;
        String r42 = s1.B(2131922197);
        r39.e = new n(r1, r23, r3);
        r39.f = r42;
        r39.a();
        goto L78
    L59:
        r26 = null;
    L83:
        if (r1.W3(r2.getOwner()) == false) goto L85;
        r1.v.a(r3, 0);
        return;
    L85:
        if (r23 != null) goto L87;
    L89:
        if (r23 != null) goto L91;
    L93:
        if (r23 != null) goto L95;
    L97:
        Context r43 = s1.getContext();
        if (r41.f.a == true) goto L101;
        r7 = 2131914799;
    L101:
        IESUIUtils.displayToast(r43, s1.B(r7));
        return;
    L95:
        if (r23.d().size() >= r41.f.b) goto L97;
        r1.v.c(r1.k, r3);
        return;
    L91:
        if (r23.getOnlineUserList().size() != r41.f.b) goto L93;
        IESUIUtils.displayToast(s1.getContext(), s1.B(2131914766));
        return;
    L87:
        if (r23.n().isEmpty() == true) goto L89;
        com.bytedance.android.live.revlink.impl.pk.ui.h.a r44 = new com.bytedance.android.live.revlink.impl.pk.ui.h.a(r1.o);
        r44.a = s1.B(2131914751);
        r44.b = s1.B(2131914750);
        String r45 = s1.B(2131914747);
        r44.c = p.a;
        r44.d = r45;
        String r46 = s1.B(2131922197);
        r44.e = new q(r1, r23, r3);
        r44.f = r46;
        r44.a();
        return;
    L38:
        r17 = null;
        goto L39
    L11:
        r14 = false;
        goto L13
    L241:
        return;
    L102:
        yz0.k r47 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r47 == null) goto L105;
        IRoom r48 = r47.getRoom();
    L106:
        if (r48 == null) goto L109;
        HashMap r49 = new HashMap();
        r49.put("anchor_id", String.valueOf(r48.getAnchorId()));
        r49.put("room_id", String.valueOf(r48.getRoomId()));
        r49.put("to_anchor_id", String.valueOf(r2.getAnchorId()));
        int r50 = UserListInviteType.a;
        r49.put("rank_type", UserListInviteType.a(r1.k, null));
        mz0.n r52 = new mz0.n();
        Map<String, String> r110 = r52.a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Intrinsics.checkNotNullParameter(r49, "map");
        r110.putAll(r49);
        mz0.m r53 = new mz0.m();
        r53.b(LogCommon.ROOM);
        ((ArrayList) r52.b).addAll(r53.a);
        cy0.e.a.getClass();
        cy0.j r54 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r55 = com.bytedance.android.scope.m.b(r54).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r55);
        ((mz0.i) ((f80.a) r55)).w3("livesdk_pksearch_anchor_click", r52.a, r52.b);
    L109:
        if (((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkMicInfo() == null) goto L111;
    L205:
        ToastUtil.a(2131917934, 0);
        return;
    L111:
        if (PKRivalsRankViewHolder.Y3(r2) == true) goto L205;
        if (r1.Z3(r2) == false) goto L117;
        if (com.bytedance.android.live.revlink.impl.pk.utils.n.a() == false) goto L205;
    L117:
        if (r1.X3(r2) == true) goto L205;
        if (r2.getLinkMap() != null) goto L121;
    L123:
        boolean r56 = false;
    L124:
        if (r56 == true) goto L205;
        if (r4 == null) goto L128;
        com.bytedance.android.livesdk.link.model.h r57 = r4.getAnchorBattleSetting();
    L129:
        if (r57 == null) goto L204;
        com.bytedance.android.livesdk.link.model.h r58 = r4.getAnchorBattleSetting();
        Intrinsics.checkNotNull(r58);
        if (r58.isTurnOn() == false) goto L204;
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L154;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r59 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r59 == null) goto L138;
        i11.b r60 = r59.getLinkUserCenter();
    L139:
        if (r60 == null) goto L154;
        Iterator<com.bytedance.android.livesdk.link.model.p> r62 = r60.d().iterator();
        boolean r63 = false;
    L142:
        if (r62.hasNext() == false) goto L156;
        com.bytedance.android.livesdk.link.model.p r64 = r62.next();
        if (r64.getStatus() != 1) goto L142;
        if (r64.getUser() == null) goto L142;
        IBaseUser r65 = r64.getUser();
        if (r65 == null) goto L150;
        String r66 = r65.getIdString();
    L152:
        if (TextUtils.equals(r66, iz.a.a(r2.getOwner())) == false) goto L142;
        r63 = true;
        goto L142
    L150:
        r66 = null;
    L156:
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L173;
        com.bytedance.android.live.revlink.impl.pk.service.b r67 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r67);
        i11.b r68 = r67.getLinkUserCenter();
        if (r68 == null) goto L173;
        Iterator<com.bytedance.android.livesdk.link.model.p> r69 = r68.d().iterator();
    L161:
        if (r69.hasNext() == false) goto L173;
        com.bytedance.android.livesdk.link.model.p r70 = r69.next();
        if (r70.getStatus() != 1) goto L161;
        if (r70.getUser() == null) goto L161;
        IBaseUser r72 = r70.getUser();
        if (r72 == null) goto L169;
        String r73 = r72.getIdString();
    L171:
        if (TextUtils.equals(r73, iz.a.a(r2.getOwner())) == false) goto L161;
        r63 = true;
        goto L161
    L169:
        r73 = null;
    L173:
        com.bytedance.android.live.revlink.impl.service.internal.a r74 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r74 == null) goto L176;
        int r75 = r74.getCurrentMode();
    L177:
        if (r75 != 0) goto L179;
    L180:
        w31.c r76 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r76 == null) goto L183;
        String r77 = r76.c();
    L185:
        if (TextUtils.equals(r77, iz.a.a(r2.getOwner())) == false) goto L187;
        r63 = true;
    L187:
        if (r63 == false) goto L192;
        r1.v.a(r3, 0);
        if (com.bytedance.android.live.revlink.impl.global.b.O() == null) goto L191;
        com.bytedance.android.live.revlink.impl.pk.utils.j.f();
    L191:
        r1.f.setBackgroundResource(2131249467);
        r1.f.setText(2131919636);
        r1.f.setTextColor(ColorProtector.parseColor("#ffffff"));
        return;
    L192:
        com.bytedance.android.live.revlink.impl.pk.service.b r78 = r1.q;
        if (r78 == null) goto L195;
        r12 = r78.getLinkUserCenter();
    L195:
        if (r12 == null) goto L199;
        i11.b r79 = r1.q.getLinkUserCenter();
        Intrinsics.checkNotNull(r79);
        if (r79.s().size() >= (r41.f.b - 1)) goto L199;
        r1.v.c(r1.k, r3);
        return;
    L199:
        Context r80 = s1.getContext();
        if (r41.f.a == false) goto L202;
        String r82 = s1.B(2131914801);
    L203:
        IESUIUtils.displayToast(r80, r82);
        return;
    L202:
        r82 = s1.B(2131914799);
        goto L203
    L183:
        r77 = null;
        goto L185
    L179:
        if (r75 != 2) goto L187;
    L176:
        r75 = 0;
        goto L177
    L138:
        r60 = null;
    L154:
        r63 = false;
    L204:
        ToastUtil.a(2131917943, 0);
        return;
    L128:
        r57 = null;
        goto L129
    L121:
        if (r2.getLinkMap().containsKey(String.valueOf(5)) == false) goto L123;
        r56 = true;
        goto L124
    L105:
        r48 = null;
        goto L106
    }
}
