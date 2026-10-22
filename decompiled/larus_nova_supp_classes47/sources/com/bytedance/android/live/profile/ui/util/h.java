package com.bytedance.android.live.profile.ui.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final Map<String, List<String>> a;
    public Map<String, String> b;

    public final void b() {
        List<String> r0 = this.a.get("actions");
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        List<String> r1 = this.a.get("others");
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        Map<String, String> r2 = this.b;
        if (r2 == null) goto L12;
        ((LinkedHashMap) r2).clear();
        return;
    }

    public h() {
        this.a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actions", new ArrayList()), TuplesKt.to("others", new ArrayList())});
    }

    public final void a(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List<String> r0 = this.a.get("actions");
        if (r0 == null) goto L8;
        r0.add(r3);
        return;
    }
}
