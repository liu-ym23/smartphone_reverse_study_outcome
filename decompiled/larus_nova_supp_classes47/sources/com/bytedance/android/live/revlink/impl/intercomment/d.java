package com.bytedance.android.live.revlink.impl.intercomment;

import com.bytedance.android.livesdk.log.filter.v;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements v {
    public static final Map<String, com.bytedance.android.livesdk.log.filter.m> a = null;
    public static final d b = null;

    public d() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        b = new d();
        a = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("InIntercomInjector", new c())});
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        if (Intrinsics.areEqual(r3, "livesdk_audience_live_message") == false) goto L5;
        List r5 = com.bytedance.revenue.platform.api.core.c.a(new String[]{"InIntercomInjector"});
    L6:
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        String r0 = (String) r6.next();
        com.bytedance.android.livesdk.log.filter.m r1 = (com.bytedance.android.livesdk.log.filter.m) ((LinkedHashMap) a).get(r0);
        if (r1 == null) goto L8;
        r1.a(r4);
        goto L8
    L12:
        return;
    L5:
        r5 = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
        goto L6
    }
}
