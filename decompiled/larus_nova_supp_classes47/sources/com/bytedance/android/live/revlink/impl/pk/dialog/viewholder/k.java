package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ PKListUserViewHolder a;
    public final /* synthetic */ y31.k b;
    public final /* synthetic */ IRivalExtraInfo c;
    public final /* synthetic */ int d;
    public final /* synthetic */ n2 e;

    public k(PKListUserViewHolder r1, y31.k r2, IRivalExtraInfo r3, int r4, n2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        PKListUserViewHolder r1 = this.a;
        y31.k r2 = this.b;
        IRoom r4 = r2.b;
        String r3 = r2.i;
        IRivalExtraInfo r6 = this.c;
        int r7 = this.d;
        m2 r8 = r2.a;
        boolean r5 = r2.m;
        n2 r9 = this.e;
        int r10 = PKListUserViewHolder.Q;
        r1.getClass();
        HashMap r12 = new HashMap();
        int r13 = UserListInviteType.a;
        r12.put("list_type", UserListInviteType.a(r1.z, null));
        if (r9 == null) goto L5;
        r12.put("right_user_status", String.valueOf(r9.getType()));
    L7:
        if (r1.P == false) goto L9;
        String r14 = "season_rank";
    L10:
        r12.put("source", r14);
        r12.put("request_id", r3);
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r12, "map");
        r16.putAll(r12);
        mz0.m r17 = new mz0.m();
        LogCommon r19 = LogCommon.ROOM;
        r17.b(r19);
        List<Object> r110 = r15.b;
        ArrayList r111 = (ArrayList) r110;
        r111.addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r112 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r113);
        ((mz0.i) ((f80.a) r113)).w3("livesdk_pk_invitee_banner_click", r15.a, r15.b);
        mz0.n r0 = new mz0.n();
        Map<String, String> r114 = r0.a;
        Intrinsics.checkNotNullParameter(r114, "map");
        Intrinsics.checkNotNullParameter(r12, "map");
        r114.putAll(r12);
        mz0.m r20 = new mz0.m();
        r20.b(r19);
        List<Object> r115 = r0.b;
        ArrayList r116 = (ArrayList) r115;
        r116.addAll(r20.a);
        Object r22 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_pk_invitee_banner1_click", r0.a, r0.b);
        boolean r23 = true;
        if (r9 != null) goto L13;
    L23:
        Intrinsics.checkNotNull(r4);
        if (((IRoomLinkExt) r4.castTo(IRoomLinkExt.class)).getLinkMicInfo() != null) goto L95;
        Intrinsics.checkNotNull(r4);
        if (r4.getLinkMap() == null) goto L28;
        r4.getLinkMap().containsKey(String.valueOf(8));
    L28:
        Intrinsics.checkNotNull(r4);
        if (r4.getLinkMap() != null) goto L31;
    L33:
        boolean r24 = false;
    L34:
        if (r24 == true) goto L95;
        if (r6 == null) goto L38;
        com.bytedance.android.livesdk.link.model.h r25 = r6.getAnchorBattleSetting();
    L39:
        if (r25 == null) goto L94;
        com.bytedance.android.livesdk.link.model.h r26 = r6.getAnchorBattleSetting();
        Intrinsics.checkNotNull(r26);
        if (r26.isTurnOn() == false) goto L94;
        if (r1.N != null) goto L46;
    L61:
        com.bytedance.android.live.revlink.impl.control.d r27 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r27 == null) goto L64;
        r27.setRequestId(r3);
    L64:
        if (r5 == false) goto L66;
    L69:
        boolean r28 = true;
    L70:
        if (r28 == false) goto L72;
        r1.M.onCancel(r4);
        return;
    L72:
        int r29 = v.a;
        v.e("ttlive_pk", "PKUserViewHolderBtnClickInvite");
        com.bytedance.android.live.revlink.impl.pk.service.b r30 = r1.a;
        if (r30 == null) goto L75;
        i11.b r117 = r30.getLinkUserCenter();
    L76:
        if (r117 == null) goto L89;
        i11.b r32 = r1.a.getLinkUserCenter();
        Intrinsics.checkNotNull(r32);
        if (r32.s().size() >= (r41.f.b - 1)) goto L89;
        HashMap<String, String> r118 = new HashMap();
        if (r8 == null) goto L87;
        List r33 = r8.getSemiFriendTags();
        if (r33 == null) goto L87;
        IBattleRivalTag r34 = (IBattleRivalTag) CollectionsKt.getOrNull(r33, 0);
        if (r34 == null) goto L87;
        String r35 = r34.getTagDesc();
        if (r35 == null) goto L87;
    L88:
        r118.put("relationship_tag_type", r35);
        r1.M.onInvite(r4, r1.z, r6, r7, r8, r1.I, r1.getLayoutPosition(), r1.K, r1.E, r118, Boolean.valueOf(r1.P));
        return;
    L87:
        r35 = "none";
    L89:
        Context r36 = s1.getContext();
        if (r41.f.a == false) goto L92;
        int r37 = 2131914801;
    L93:
        IESUIUtils.displayToast(r36, s1.B(r37));
        return;
    L92:
        r37 = 2131914799;
        goto L93
    L75:
        r117 = null;
        goto L76
    L66:
        if (r1.T3(r4.getOwner()) == true) goto L69;
        r28 = false;
        goto L70
    L46:
        if (r1.O == true) goto L61;
        ox0.a r38 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r38 == null) goto L50;
        int r39 = r38.a();
    L52:
        if (gd0.v.a(r39, 4) == false) goto L54;
        ToastUtil.a(2131917666, 0);
        return;
    L54:
        oq2.c r119 = com.bytedance.android.live.revenue.core.util.e.a(qr2.c.class).Qd();
        boolean r120 = gd0.v.a(r39, 32);
        if (r119 == null) goto L57;
        r119.a();
    L57:
        if (r120 == false) goto L59;
    L60:
        ToastUtil.a(2131917956, 0);
        return;
    L59:
        if (gd0.v.a(r39, 8) == false) goto L61;
    L50:
        r39 = 0;
    L94:
        int r40 = v.a;
        v.e("ttlive_pk", "PKUserViewHolderBtnClickReturnSettingOff");
        ToastUtil.a(2131917943, 0);
        return;
    L38:
        r25 = null;
        goto L39
    L31:
        if (r4.getLinkMap().containsKey(String.valueOf(7)) == false) goto L33;
        r24 = true;
    L95:
        int r42 = v.a;
        v.e("ttlive_pk", "PKUserViewHolderBtnClickReturnInLink");
        ToastUtil.a(2131917934, 0);
        return;
    L13:
        if (r9.getForbidden() == false) goto L23;
        if (r9.getDescription() != null) goto L17;
    L22:
        int r43 = ToastUtil.a;
        ToastUtil.b(s1.B(2131917834), 0);
        return;
    L17:
        if (r9.getDescription().length() == 0) goto L20;
        r23 = false;
    L20:
        if (r23 == true) goto L22;
        int r44 = ToastUtil.a;
        ToastUtil.b(r9.getDescription(), 0);
        return;
    L9:
        r14 = "pk";
        goto L10
    L5:
        r12.put("right_user_status", "2");
        goto L7
    }
}
