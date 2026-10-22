package com.bytedance.android.live.room.incentiveinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import y81.d0;
import y81.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements u81.c<w81.a, u81.d> {
    public final Map<CarouselTabType, Integer> a;
    public com.bytedance.android.live.room.incentiveinfo.datamonitor.d<w81.a> b;
    public final List<w81.a> c;
    public final DataCenter d;
    public final View e;

    public static final class a {
    }

    static {
    }

    @Override // u81.c
    public final int getItemSize() {
        return this.c.size();
    }

    @Override // u81.c
    public final void b(IncentiveInfoLayout.b r1) {
        this.b = r1;
    }

    @Override // u81.c
    public final w81.a getData(int r2) {
        return (w81.a) x81.a.d(this.c, r2);
    }

    @Override // u81.c
    public final int getDataPosition(w81.a r2) {
        w81.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        return this.c.indexOf(r3);
    }

    @Override // u81.c
    public final int getItemViewType(int r2) {
        w81.a r3 = (w81.a) x81.a.d(this.c, r2);
        if (r3 == null) goto L5;
        CarouselTabType r4 = r3.e;
    L6:
        Integer r5 = this.a.get(r4);
        if (r5 != null) goto L11;
        return 0;
    L11:
        return r5.intValue();
    L5:
        r4 = null;
        goto L6
    }

    @Override // u81.c
    public final void a(u81.d r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "vh");
        ALogger.d("IncentiveInfoAdapter", "bindHolder, holder type: " + r3.getItemType());
        r3.g((w81.a) x81.a.d(this.c, r4));
    }

    public d(List r4, DataCenter r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "dataList");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "parentView");
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(CarouselTabType.DOU_PLUS, 1), TuplesKt.to(CarouselTabType.FRESHMAN_SUPPORT, 2), TuplesKt.to(CarouselTabType.ANCHOR_TRAFFIC_SUPPORT, 3), TuplesKt.to(CarouselTabType.ROOM_INDICATOR, 4)});
    }

    @Override // u81.c
    public final y81.b c(ViewGroup r12, int r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        ALogger.e("IncentiveInfoAdapter", "create carousel holder type: " + r13);
        if (r13 != CarouselTabType.DOU_PLUS.getValue()) goto L6;
        int r15 = l.U;
        DataCenter r16 = this.d;
        View r1 = this.e;
        Intrinsics.checkNotNullParameter(r16, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r1, "parentView");
        int r2 = y81.b.i;
        return new l(r16, y81.b.a.a(r12), r13, r1);
    L6:
        if (r13 != CarouselTabType.FRESHMAN_SUPPORT.getValue()) goto L9;
        int r17 = y81.c.M;
        DataCenter r18 = this.d;
        View r3 = this.e;
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        int r4 = y81.b.i;
        return new y81.c(r18, y81.b.a.a(r12), r13, r3);
    L9:
        if (r13 != CarouselTabType.ANCHOR_TRAFFIC_SUPPORT.getValue()) goto L12;
        int r5 = y81.a.O;
        DataCenter r6 = this.d;
        View r9 = this.e;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r9, "parentView");
        int r7 = y81.b.i;
        return new y81.a(r6, y81.b.a.a(r12), r13, r9, r14);
    L12:
        if (r13 != CarouselTabType.ROOM_INDICATOR.getValue()) goto L15;
        d0.a r8 = d0.h0;
        DataCenter r10 = this.d;
        View r19 = this.e;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r19, "parentView");
        Intrinsics.checkNotNullParameter(r12, "parent");
        return new d0(r10, LayoutInflater.from(r12.getContext()).inflate(2131566639, r12, false), r13, r19, r14);
    L15:
        String r110 = "不符合预期的itemType：" + r13;
        if (v.a() == true) goto L20;
        ALogger.e("IncentiveInfoAdapter", r110);
        int r111 = y81.c.M;
        DataCenter r112 = this.d;
        View r20 = this.e;
        Intrinsics.checkNotNullParameter(r112, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r20, "parentView");
        int r22 = y81.b.i;
        return new y81.c(r112, y81.b.a.a(r12), r13, r20);
    L20:
        throw new IllegalArgumentException(r110);
    }
}
