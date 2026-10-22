package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.RevenueSetRtcEffectEnableResultModel;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.rd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 extends wy0.b<rd, RevenueSetRtcEffectEnableResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final com.bytedance.android.live.revlink.impl.multianchor.service.g m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L9;
        RevLinkWindowRegionContext r1 = r0.P8();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r2 = r1.getPartnerService();
        if (r2 == null) goto L9;
        return (com.bytedance.android.live.revlink.impl.multianchor.service.g) r2.getValue();
    L9:
        return null;
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public d0(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(rd.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r12, CallContext r13) {
        rd r14 = (rd) r12;
        Intrinsics.checkNotNullParameter(r14, "param");
        Intrinsics.checkNotNullParameter(r13, "callContext");
        RevenueSetRtcEffectEnableResultModel r15 = new RevenueSetRtcEffectEnableResultModel();
        String r0 = r14.getScene();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r3 = r0;
        boolean r1 = Intrinsics.areEqual(r14.getEnable(), Boolean.TRUE);
        rd.b r2 = r14.getExtra();
        List<String> r4 = null;
        if (r2 == null) goto L8;
        List r7 = r2.w();
    L9:
        rd.b r5 = r14.getExtra();
        if (r5 == null) goto L12;
        String r6 = r5.G();
    L13:
        rd.b r8 = r14.getExtra();
        if (r8 == null) goto L16;
        String r9 = r8.c();
    L18:
        if (r1 == false) goto L35;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r10 = m();
        if (r10 != null) goto L22;
    L25:
        d51.b r16 = d51.b.m;
        r16.getClass();
        if (((Boolean) d51.b.l.getValue(r16, d51.b.a[10])).booleanValue() == false) goto L43;
        if (r7 == null) goto L43;
        List r17 = CollectionsKt.toList(r7);
        if (r17 == null) goto L43;
        if ((!r17.isEmpty()) != true) goto L43;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r18 = m();
        if (r18 == null) goto L43;
        r18.f0(false);
    L43:
        r15.a(RevenueSetRtcEffectEnableResultModel.Code.Success);
        jy0.b.d("SetRtcEffectEnableMethod", "param：" + r14 + ' ');
        finishWithSuccess();
        return;
    L22:
        if (r7 == null) goto L24;
        r4 = CollectionsKt.toList(r7);
    L24:
        r10.i(true, r3, r4, r9, r6);
        goto L25
    L35:
        com.bytedance.android.live.revlink.impl.multianchor.service.g r19 = m();
        if (r19 == null) goto L38;
        r19.i(false, r3, null, null, null);
    L38:
        d51.b r20 = d51.b.m;
        r20.getClass();
        if (((Boolean) d51.b.l.getValue(r20, d51.b.a[10])).booleanValue() == false) goto L43;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r22 = m();
        if (r22 == null) goto L43;
        r22.f0(true);
        goto L43
    L16:
        r9 = null;
        goto L18
    L12:
        r6 = null;
        goto L13
    L8:
        r7 = null;
        goto L9
    }
}
