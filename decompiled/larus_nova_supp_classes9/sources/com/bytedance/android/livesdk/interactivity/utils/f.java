package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final ArrayList<Long> a;
    public long b;
    public final ArrayList<Long> c;
    public long d;
    public int e;
    public int f;

    public final int a() {
        return RangesKt.random(new IntRange(this.f, this.e), Random.Default);
    }

    public final int b() {
        long r0 = RangesKt.random(new LongRange(0, this.d), Random.Default);
        Iterator<T> r2 = this.c.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r0 <= ((Number) r2.next()).longValue()) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return r4;
    L9:
        return 0;
    }

    public f() {
        this.a = new ArrayList();
        this.c = new ArrayList();
        this.e = 6;
        this.f = 3;
    }

    public final void c(List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r7) {
        Intrinsics.checkNotNullParameter(r7, "list");
        this.b = 0;
        this.a.clear();
        int r0 = r7.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        long r2 = ((com.bytedance.android.livesdk.interactivity.api.barrage.data.f) ListProtector.get(r7, r1)).f();
        long r4 = this.b + r2;
        this.b = r4;
        this.a.add(Long.valueOf(r4));
        r1 = r1 + 1;
        goto L3
    }

    public final void d(List<Long> r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "list");
        this.d = 0;
        this.c.clear();
        int r0 = ((ArrayList) r7).size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        long r2 = ((Number) ListProtector.get(r7, r1)).longValue();
        long r4 = this.d + r2;
        this.d = r4;
        this.c.add(Long.valueOf(r4));
        r1 = r1 + 1;
        goto L3
    L5:
        this.e = Math.max(r9, r8);
        this.f = Math.min(r9, r8);
    }
}
