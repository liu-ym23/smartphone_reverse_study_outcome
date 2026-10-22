package com.bytedance.android.monitorV2;

import android.os.Handler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f3607a = null;

    static {
        f3607a = new k((((int) Runtime.getRuntime().maxMemory()) / 1024) / 8, 0);
    }

    public static String a(String r12, List r13) {
        Intrinsics.checkNotNullParameter(r12, "url");
        String r5 = "";
        if (r13 != null) goto L5;
    L21:
        return r5;
    L5:
        if (r13.isEmpty() == true) goto L21;
        long r10 = System.currentTimeMillis();
        k r11 = f3607a;
        String r14 = (String) r11.get(r12);
        if (r14 == null) goto L11;
        System.out.println("hit cache: ".concat(r14));
        Map r15 = i.f3604a;
        Map r16 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r12), TuplesKt.to("hit_cache", String.valueOf(true))});
        Map r17 = MapsKt.mapOf(TuplesKt.to("regex_match_time", Long.valueOf(System.currentTimeMillis() - r10)));
        Intrinsics.checkNotNullParameter("regex_perf", "event");
        Handler r18 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new InternalWatcher$notice$1(null, "regex_perf", r16, r17));
        return r14;
    L11:
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r13, "regexList");
        Iterator r19 = r13.iterator();
    L13:
        if (r19.hasNext() == false) goto L17;
        a5.a r20 = (a5.a) r19.next();
        if (r20.a().containsMatchIn(r12) == false) goto L13;
        System.out.print(r20.a() + " match " + r20.f94a);
    L18:
        if (r20 == null) goto L20;
        r5 = r20.f94a;
    L20:
        r11.put(r12, r5);
        Map r110 = i.f3604a;
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r12), TuplesKt.to("hit_cache", String.valueOf(false))});
        Map r112 = MapsKt.mapOf(TuplesKt.to("regex_match_time", Long.valueOf(System.currentTimeMillis() - r10)));
        Intrinsics.checkNotNullParameter("regex_perf", "event");
        Handler r21 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new InternalWatcher$notice$1(null, "regex_perf", r111, r112));
        goto L21
    L17:
        r20 = null;
        goto L18
    }
}
