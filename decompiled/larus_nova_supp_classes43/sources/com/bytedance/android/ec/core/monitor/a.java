package com.bytedance.android.ec.core.monitor;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Map<String, Long> a;
    public final Map<String, Long> b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public final String e;
    public final n f;

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "metricName");
        Long r0 = (Long) ((HashMap) this.a).get(r10);
        if (r0 == null) goto L8;
        long r1 = r0.longValue();
        long r11 = SystemClock.elapsedRealtime() - r1;
        if (r11 <= 0) goto L9;
        Map<String, Long> r12 = this.b;
        HashMap r13 = (HashMap) r12;
        r13.put(r10, Long.valueOf(r11));
        return;
    L9:
        return;
    }

    public a(String r10, n r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this.e = r10;
        this.f = r11;
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
    }
}
