package com.bytedance.android.bcm.impl2;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl2.model.BcmAllowMode;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.impl.page.BtmPageFinder;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ScopedBcmHolder implements lc.c {
    public final String a;

    public static final class a {
    }

    static {
    }

    public ScopedBcmHolder(String r1) {
        this.a = r1;
    }

    @Override // lc.c
    public final kc.a a(PageFinder r10, int r11) {
        int r12 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r11, 0), 20);
        if (r10 != null) goto L5;
    L7:
        PageInfo r13 = null;
    L8:
        if (r13 != null) goto L11;
        String r14 = BtmPageRecorder.a;
        r13 = BtmPageRecorder.j(com.bytedance.android.btm.impl.page.b.b);
    L11:
        if (r13 != null) goto L22;
        String r15 = com.bytedance.android.btm.impl.page.b.d;
        if (r15 != null) goto L15;
    L18:
        boolean r16 = true;
    L19:
        if (r16 == false) goto L22;
        ALogger.d.a("_ScopedBcmHolder", false, ScopedBcmHolder$getBcmChainByFinder$1.INSTANCE);
        return null;
    L15:
        if (r15.length() == 0) goto L18;
        r16 = false;
    L22:
        kc.a r1 = new kc.a();
        if (r13 == null) goto L26;
        r1.a.add(e(r13.getPageBtm(), ScopedBcmRecorder.a(r13).snapshot(CollectionsKt.listOf(this.a), BcmAllowMode.MANUAL), r13.getPageShowId()));
        d(r13.getBtmPre(), CollectionsKt.listOf(this.a), r12, r1);
    L29:
        if (r1.a.size() >= 2) goto L31;
        ALogger.d.a("_ScopedBcmHolder", false, ScopedBcmHolder$getBcmChainByFinder$2.INSTANCE);
    L31:
        return r1;
    L26:
        if (BtmSetting.d.c().c().u() != 1) goto L29;
        d(com.bytedance.android.btm.impl.page.b.d, CollectionsKt.listOf(this.a), r12, r1);
        goto L29
    L5:
        if (r10.isEmpty() == true) goto L7;
        String r17 = BtmPageRecorder.a;
        String r18 = BtmPageFinder.a;
        r13 = BtmPageRecorder.j(BtmPageFinder.a(r10));
        goto L8
    }

    @Override // lc.c
    public final boolean b(PageFinder r10, final Map<String, ? extends Object> r11) {
        if (BtmSetting.d.c().a() == 1) goto L5;
        return false;
    L5:
        ALogger r0 = ALogger.d;
        r0.a("_ScopedBcmHolder", false, new ScopedBcmHolder$setUnitParams$1(r11));
        String r12 = BtmPageFinder.a;
        Object r13 = BtmPageFinder.a(r10);
        String r14 = BtmPageRecorder.a;
        PageInfo r15 = BtmPageRecorder.j(r13);
        if (r15 != null) goto L9;
        r0.a("_ScopedBcmHolder", false, ScopedBcmHolder$setUnitParams$2.INSTANCE);
        return false;
    L9:
        ScopedBcmContent r16 = ScopedBcmRecorder.a(r15);
        if ((!r11.isEmpty()) == false) goto L13;
        r16.mergeUnitParams(this.a, r11);
        return true;
    L13:
        return false;
    }

    @Override // lc.c
    public final boolean c(PageFinder r10, final Map<String, ? extends Object> r11) {
        if (BtmSetting.d.c().a() == 1) goto L5;
        return false;
    L5:
        ALogger r0 = ALogger.d;
        r0.a("_ScopedBcmHolder", false, new ScopedBcmHolder$setPageParams$1(r11));
        String r12 = BtmPageFinder.a;
        Object r13 = BtmPageFinder.a(r10);
        String r14 = BtmPageRecorder.a;
        PageInfo r15 = BtmPageRecorder.j(r13);
        if (r15 != null) goto L9;
        r0.a("_ScopedBcmHolder", false, ScopedBcmHolder$setPageParams$2.INSTANCE);
        return false;
    L9:
        ScopedBcmContent r16 = ScopedBcmRecorder.a(r15);
        if ((!r11.isEmpty()) == false) goto L13;
        r16.mergePageParams(this.a, r11);
        return true;
    L13:
        return false;
    }

    public static kc.a.C0174a e(String r10, Pair r11, String r12) {
        kc.a.C0174a r0 = new kc.a.C0174a();
        if (BtmSetting.d.c().c().D() == 1) goto L5;
        r0.b = BtmFormatUtils.c(r10);
    L5:
        r0.d = r10;
        r0.c = BtmFormatUtils.g(r10);
        r0.e = r12;
        if (r11 == null) goto L8;
        kc.a.C0174a.C0175a r13 = new kc.a.C0174a.C0175a();
        r13.a = (BcmParams) r11.getFirst();
        r13.b = (BcmParams) r11.getSecond();
        r0.g = r13;
    L8:
        return r0;
    }

    public final void d(String r10, List r11, int r12, kc.a r13) {
        final JSONArray r0 = new JSONArray();
    L3:
        if (r10 == null) goto L15;
        r0.put(r10);
        if (Intrinsics.areEqual(BtmFormatUtils.g(r10), "a0.b0.c0.d0") == true) goto L15;
        if (r13.a.size() >= r12) goto L15;
        List<kc.a.C0174a> r1 = r13.a;
        ScopedBcmContent r14 = ScopedBcmRecorder.a.get(r10);
        if (r14 == null) goto L13;
        Pair<BcmParams, BcmParams> r15 = r14.snapshot(r11, BcmAllowMode.MANUAL);
    L14:
        String r16 = BtmPageRecorder.a;
        r1.add(e(r10, r15, BtmPageRecorder.g(r10)));
        r10 = com.bytedance.android.btm.impl.b.e.c().c(r10);
        goto L3
    L13:
        r15 = null;
    L15:
        ALogger.d.a("_ScopedBcmHolder", false, new ScopedBcmHolder$getBcmRawChainByBtmId$1(this, r0));
    }
}
