package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ PkCancelMatchDialog a;

    public b(PkCancelMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        PkCancelMatchDialog r15 = this.a;
        if (r15.e != null) goto L5;
        return;
    L5:
        PkCancelMatchDialog.T90(r15, "cancel");
        Intrinsics.checkNotNull(this.a.e);
        com.bytedance.android.live.revlink.impl.global.b.j();
        h41.g.a("pop_window");
        LinkCrossRoomDataHolder r16 = com.bytedance.android.live.revlink.impl.global.b.j();
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L35;
        IRoom r1 = r0.k();
        if (r1 == null) goto L36;
        this.a.getClass();
        HashMap r2 = new HashMap();
        w31.b.a(r2);
        w31.c r3 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r3 == null) goto L23;
        IPKLinkBizDataService r4 = r3.g();
        if (r4 == null) goto L23;
        String r5 = r4.getFlexActivityId();
        if (r5.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L23;
        r2.put("flex_activity_id", r5);
        com.bytedance.android.live.revlink.impl.control.dialog.e r7 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), r5);
        if (r7 == null) goto L23;
        Map<String, String> r8 = r7.f;
        if (r8 == null) goto L23;
        r2.putAll(r8);
        goto L23
    L16:
        r6 = false;
    L23:
        r2.put("anchor_connection_type", "invite");
        r2.put("connection_type", "manual_pk");
        r2.put("source", "pk_banner");
        mz0.n r9 = new mz0.n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r10.putAll(r2);
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.ROOM);
        ((ArrayList) r9.b).addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_connection_invite_cancel", r9.a, r9.b);
        com.bytedance.android.live.revenuelink.connect.n r18 = this.a.g;
        if (r18 != null) goto L26;
        return;
    L26:
        if (r16 == null) goto L28;
        long r19 = r16.c();
    L29:
        long r20 = r1.getId();
        String r22 = iz.a.a(r1.getOwner());
        IBaseUser r110 = r1.getOwner();
        if (r110 == null) goto L32;
        Intrinsics.checkNotNullParameter(r110, "$this$secUidExt");
        String r23 = r110.getCastSecUid();
    L33:
        r18.e(new d11.c(1, r19, r20, r22, r23, 0, "click_cancel_dialog"), null);
        return;
    L32:
        r23 = null;
        goto L33
    L28:
        r19 = 0;
        goto L29
    L36:
        return;
    }
}
