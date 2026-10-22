package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.link.model.o2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import dq2.w;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorInviteListUserViewHolder a;
    public final /* synthetic */ y31.k b;
    public final /* synthetic */ IRivalExtraInfo c;
    public final /* synthetic */ n2 d;

    public f(MultiAnchorInviteListUserViewHolder r1, y31.k r2, IRivalExtraInfo r3, int r4, n2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        MultiAnchorInviteListUserViewHolder r15 = this.a;
        y31.k r0 = this.b;
        IRoom r2 = r0.b;
        String r1 = r0.i;
        m2 r4 = r0.a;
        boolean r3 = r0.m;
        n2 r5 = this.d;
        int r6 = MultiAnchorInviteListUserViewHolder.D;
        r15.getClass();
        HashMap r7 = new HashMap();
        int r8 = UserListInviteType.a;
        int r9 = r15.q;
        Map<Integer, String> r10 = r15.z;
        Intrinsics.checkNotNullParameter(r10, "inviteTypeToListType");
        r7.put("list_type", UserListInviteType.a(r9, r10));
        if (r5 == null) goto L5;
        r7.put("right_user_status", String.valueOf(r5.getType()));
    L6:
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r13.putAll(r7);
        mz0.m r16 = new mz0.m();
        LogCommon r17 = LogCommon.ROOM;
        r16.b(r17);
        List<Object> r18 = r12.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((mz0.i) ((f80.a) r110)).w3("livesdk_pk_invitee_banner_click", r12.a, r12.b);
        mz0.n r22 = new mz0.n();
        Map<String, String> r111 = r22.a;
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r111.putAll(r7);
        mz0.m r23 = new mz0.m();
        r23.b(r17);
        List<Object> r24 = r22.b;
        ArrayList r25 = (ArrayList) r24;
        r25.addAll(r23.a);
        Object r26 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r26);
        ((mz0.i) ((f80.a) r26)).w3("livesdk_pk_invitee_banner1_click", r22.a, r22.b);
        boolean r27 = true;
        if (r5 != null) goto L9;
    L19:
        int r28 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
        w r29 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        Intrinsics.checkNotNull(r29);
        if (r29.w() <= 0) goto L22;
        boolean r30 = true;
    L24:
        if (v.a(r28, 32) == false) goto L27;
        if (r30 == false) goto L27;
        ToastUtil.a(2131917515, 0);
        return;
    L27:
        Intrinsics.checkNotNull(r4);
        if (o2.a(r4) == true) goto L65;
        Intrinsics.checkNotNull(r2);
        if (((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkMicInfo() != null) goto L56;
        Intrinsics.checkNotNull(r2);
        if (r2.getLinkMap() != null) goto L34;
    L36:
        boolean r32 = false;
    L37:
        if (r32 == false) goto L49;
        Intrinsics.checkNotNull(r2);
        if (((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkerDetail() == null) goto L47;
        z5 r33 = ((IRoomLinkExt) r2.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r33 == null) goto L43;
        String r34 = r33.getFunctionType2();
    L45:
        if (TextUtils.equals(r34, "new_audience") == false) goto L47;
        boolean r35 = true;
    L48:
        if (r35 == false) goto L56;
    L43:
        r34 = null;
    L47:
        r35 = false;
    L49:
        Intrinsics.checkNotNull(r2);
        if (r2.getLinkMap() != null) goto L52;
    L54:
        boolean r36 = false;
    L55:
        if (r36 == false) goto L65;
    L52:
        if (r2.getLinkMap().containsKey(String.valueOf(7)) == false) goto L54;
        r36 = true;
        goto L55
    L34:
        if (r2.getLinkMap().containsKey(String.valueOf(8)) == false) goto L36;
        r32 = true;
    L56:
        int r112 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_anchor_link", "PKUserViewHolderBtnClickReturnInLink");
        Intrinsics.checkNotNull(r2);
        if (r2.getLinkMap() != null) goto L59;
    L61:
        r27 = false;
    L62:
        if (r27 == false) goto L64;
        ToastUtil.a(2131918003, 0);
        return;
    L64:
        ToastUtil.a(2131918002, 0);
        return;
    L59:
        if (r2.getLinkMap().containsKey(String.valueOf(7)) == false) goto L61;
    L65:
        com.bytedance.android.live.revlink.impl.control.d r37 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r37 == null) goto L68;
        r37.setRequestId(r1);
    L68:
        if (r3 == false) goto L70;
        x31.m r113 = r15.C;
        Intrinsics.checkNotNull(r113);
        r113.l30(r2, r4);
        return;
    L70:
        int r38 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_anchor_link", "MultiAnchorInviteListViewHolderBtnClickInvite");
        x31.m r39 = r15.C;
        Intrinsics.checkNotNull(r39);
        r39.zC(r2, r15.q, r4, r15.getLayoutPosition(), Boolean.valueOf(r15.r), r15.A, r15.w);
        return;
    L22:
        r30 = false;
        goto L24
    L9:
        if (r5.getForbidden() == false) goto L19;
        if (r5.getDescription() != null) goto L13;
    L18:
        int r114 = ToastUtil.a;
        ToastUtil.b(s1.B(2131917691), 0);
        return;
    L13:
        if (r5.getDescription().length() == 0) goto L16;
        r27 = false;
    L16:
        if (r27 == true) goto L18;
        int r115 = ToastUtil.a;
        ToastUtil.b(r5.getDescription(), 0);
        return;
    L5:
        r7.put("right_user_status", "2");
        goto L6
    }
}
