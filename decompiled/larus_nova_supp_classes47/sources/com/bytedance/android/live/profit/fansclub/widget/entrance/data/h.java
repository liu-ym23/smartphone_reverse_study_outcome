package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.message.model.e6;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        e6 r9 = (e6) r8;
        if (r9 == null) goto L40;
        com.bytedance.android.live.base.model.user.j r10 = r9.vipInfo();
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.getType() != this.a.h()) goto L42;
        IBaseUser r0 = this.a.getRoom().getOwner();
        if (r0 == null) goto L12;
        r0.setCommonVipInfo(r10);
    L12:
        int r12 = j.a;
        DataCenter r13 = i.a(this.a);
        HashMap r1 = new HashMap();
        i r14 = fu0.b.a(r13);
        if (r14 == null) goto L38;
        boolean r2 = r14.A();
        String r3 = DataType.TRUE;
        if (r2 == false) goto L18;
        Object r4 = DataType.TRUE;
    L19:
        r1.put("is_anchor", r4);
        r1.put("member_type", String.valueOf(r14.h()));
        com.bytedance.android.live.base.model.user.j r5 = r14.g();
        if (r5 != null) goto L22;
    L24:
        boolean r6 = false;
    L25:
        if (r6 == true) goto L28;
        r3 = DataType.FALSE;
    L28:
        r1.put("is_member", r3);
        String r7 = r14.getRoom().getAnchorId();
        if (r7 != null) goto L31;
        r7 = "";
    L31:
        r1.put("anchor_id", r7);
        com.bytedance.android.live.base.model.user.j r15 = r14.g();
        if (r15 == null) goto L34;
        Map r16 = r15.getTrackingParams();
    L35:
        if (r16 == null) goto L37;
        r1.putAll(r16);
    L37:
        n r17 = new n();
        Map<String, String> r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r18.putAll(r1);
        m r19 = new m();
        r19.b(LogCommon.ROOM);
        r19.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r20 = r17.b;
        ArrayList r22 = (ArrayList) r20;
        r22.addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_member_entrance_update", r17.a, r17.b);
        goto L38
    L34:
        r16 = null;
        goto L35
    L22:
        if (r5.isMember() != true) goto L24;
        r6 = true;
        goto L25
    L18:
        r4 = DataType.FALSE;
    L38:
        i r25 = this.a;
        r25.J(r25.getRoom().getOwner(), "EntranceDataSource-subscribeEvent", true, new EntranceDataSource$subscribeEvent$9$$special$$inlined$let$lambda$1(this));
        return;
    L42:
        return;
    }
}
