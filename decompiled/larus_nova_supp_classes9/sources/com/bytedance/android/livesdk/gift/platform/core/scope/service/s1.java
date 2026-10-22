package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class s1 implements com.bytedance.android.scope.o {
    public final Map<String, String> a;
    public Map<String, String> b;
    public Map<String, String> c;

    public void onStart() {
        g(new IntRange(0, 7));
    }

    public s1() {
        this.a = new LinkedHashMap();
    }

    public final void a(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$addLocationInfo");
        String r0 = (String) ((LinkedHashMap) this.a).get("start_row_location");
        String r2 = BuildConfig.FLAVOR;
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        r4.put("start_row_location", r0);
        String r1 = (String) ((LinkedHashMap) this.a).get("end_row_location");
        if (r1 == null) goto L9;
        r2 = r1;
    L9:
        r4.put("end_row_location", r2);
    }

    public final void d(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$addTabInfo");
        String r0 = (String) ((LinkedHashMap) this.a).get("tab_name");
        String r2 = BuildConfig.FLAVOR;
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        r4.put("tab_name", r0);
        String r1 = (String) ((LinkedHashMap) this.a).get("tab_location");
        if (r1 == null) goto L9;
        r2 = r1;
    L9:
        r4.put("tab_location", r2);
    }

    public final void f(int r3) {
        if (r3 == (-1)) goto L6;
        this.a.put("diy_card_chosen_type", String.valueOf(r3));
        return;
    }

    public final void g(IntRange r4) {
        Intrinsics.checkNotNullParameter(r4, "giftRange");
        this.a.put("start_row_location", String.valueOf((r4.getFirst() / 4) + 1));
        this.a.put("end_row_location", String.valueOf((r4.getLast() / 4) + 1));
    }

    public final void h(int r3, int r4) {
        this.a.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r4));
        this.a.put("tab_location", String.valueOf(r3 + 1));
    }

    public final void c(int r3, int r4, int r5) {
        this.a.put("from_tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r3));
        this.a.put("from_tab_location", String.valueOf(r4 + 1));
        this.a.put("tab_gift_cnt", String.valueOf(r5));
    }
}
