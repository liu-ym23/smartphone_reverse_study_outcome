package com.bytedance.android.live.revlink.impl.preload;

import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.live.kmp.util.e;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import r11.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Pair r12 = (Pair) r10;
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.a.d == true) goto L58;
        i r0 = com.bytedance.android.live.revlink.impl.global.b.h0();
        Long r1 = null;
        int r2 = 0;
        boolean r3 = true;
        if (r0 != null) goto L9;
    L11:
        long r4 = e.b() - ((Number) l51.a.t0.getValue(null, l51.a.a[81])).longValue();
        b51.b r5 = b51.b.c0;
        if (r4 >= r5.e().getInterval()) goto L14;
    L13:
        r3 = false;
    L20:
        if (r3 == true) goto L60;
        IRivalRankRecommendResponse r6 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r12.getSecond()).c;
        if (r6 == null) goto L26;
        r1 = Long.valueOf(r6.getLoadType());
    L26:
        if (r1.longValue() != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L59;
        IRivalRankRecommendResponse r7 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r12.getSecond()).c;
        if (r7 == null) goto L38;
        s2 r8 = r7.getTabRivals();
        if (r8 == null) goto L38;
        Map r9 = r8.getGroupRivals();
        if (r9 == null) goto L38;
        IGroupRivals r13 = (IGroupRivals) r9.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r13 == null) goto L38;
        List r14 = r13.getRivals();
        if (r14 == null) goto L38;
        r2 = r14.size();
    L38:
        i r15 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r15 != null) goto L41;
    L55:
        this.a.b = r2;
        return;
    L41:
        if (r15.k3() == true) goto L55;
        if (Intrinsics.areEqual((String) r12.getFirst(), "timer") == false) goto L55;
        if (r2 <= 0) goto L55;
        if (this.a.b >= r2) goto L55;
        long r16 = System.currentTimeMillis() - this.a.c;
        b51.b r17 = b51.b.c0;
        if (r16 <= r17.e().Y0()) goto L55;
        this.a.c = System.currentTimeMillis();
        i r18 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r18 == null) goto L55;
        s r19 = r17.e();
        Intrinsics.checkNotNullParameter(r19, "$this$getValidFollowUpdateTip");
        String r110 = r19.X2();
        if (r110 != null) goto L54;
        r110 = "有好友上线，快来一起连线互动吧";
    L54:
        r18.J2(r110);
        goto L55
    L59:
        return;
    L60:
        return;
    L14:
        i r20 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r20 == null) goto L20;
        s r22 = r5.e();
        Intrinsics.checkNotNullParameter(r22, "$this$getValidRestoreTip");
        String r23 = r22.F2();
        if (r23 != null) goto L19;
        r23 = "快来一起连线互动吧";
    L19:
        r20.J2(r23);
        goto L20
    L9:
        if (r0.k3() != true) goto L11;
    }
}
