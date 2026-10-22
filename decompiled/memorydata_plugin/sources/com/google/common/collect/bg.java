package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class bg<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator<? super T> f4672b;
    private final T[] c;
    private int d;
    private T e;

    private bg(Comparator<? super T> r4, int r5) {
        this.f4672b = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin"), "comparator"), Comparator.class, "com.obric.memorydata.plugin");
        this.f4671a = r5;
        boolean r6 = true;
        if (r5 < 0) goto L5;
        boolean r1 = true;
    L6:
        com.google.common.base.n.a(r1, "k (%s) must be >= 0", r5);
        if (r5 <= 1073741823) goto L10;
        r6 = false;
    L10:
        com.google.common.base.n.a(r6, "k (%s) must be <= Integer.MAX_VALUE / 2", r5);
        this.c = (T[]) new Object[com.google.common.math.c.c(r5, 2)];
        this.d = 0;
        this.e = null;
        return;
    L5:
        r1 = false;
        goto L6
    }

    private int a(int r4, int r5, int r6) {
        Object r0 = ao.a(this.c[r6]);
        T[] r1 = this.c;
        r1[r6] = r1[r5];
        int r7 = r4;
    L3:
        if (r4 >= r5) goto L8;
        if (this.f4672b.compare((Object) ao.a(this.c[r4]), r0) >= 0) goto L7;
        a(r7, r4);
        r7 = r7 + 1;
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        T[] r3 = this.c;
        r3[r5] = r3[r7];
        r3[r7] = r0;
        return r7;
    }

    public static <T> bg<T> a(int r2, Comparator<? super T> r3) {
        return new bg((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), r2);
    }

    private void a(int r3, int r4) {
        T[] r2 = this.c;
        T r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }

    private void b() {
        int r0 = (this.f4671a * 2) - 1;
        int r1 = com.google.common.math.c.a(r0 + 0, RoundingMode.CEILING) * 3;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int r5 = a(r2, r0, ((r2 + r0) + 1) >>> 1);
        int r6 = this.f4671a;
        if (r5 <= r6) goto L7;
        r0 = r5 - 1;
    L9:
        r3 = r3 + 1;
        if (r3 < r1) goto L3;
        Arrays.sort(this.c, r2, r0 + 1, this.f4672b);
        goto L12
    L7:
        if (r5 >= r6) goto L12;
        r2 = Math.max(r5, r2 + 1);
        r4 = r5;
    L12:
        this.d = this.f4671a;
        this.e = (T) ao.a(this.c[r4]);
    L13:
        r4 = r4 + 1;
        if (r4 >= this.f4671a) goto L19;
        if (this.f4672b.compare((Object) ao.a(this.c[r4]), (Object) ao.a(this.e)) <= 0) goto L13;
        this.e = this.c[r4];
        goto L13
    }

    public List<T> a() {
        T[] r0 = this.c;
        Arrays.sort(r0, 0, this.d, this.f4672b);
        int r1 = this.d;
        int r2 = this.f4671a;
        if (r1 <= r2) goto L6;
        T[] r3 = this.c;
        Arrays.fill(r3, r2, r3.length, null);
        int r4 = this.f4671a;
        this.d = r4;
        this.e = this.c[r4 - 1];
    L6:
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(r0, this.d)));
    }

    public void a(T r4) {
        int r0 = this.f4671a;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = this.d;
        if (r1 != 0) goto L8;
        this.c[0] = r4;
        this.e = r4;
        this.d = 1;
        return;
    L8:
        if (r1 >= r0) goto L13;
        T[] r2 = this.c;
        this.d = r1 + 1;
        r2[r1] = r4;
        if (this.f4672b.compare(r4, (Object) ao.a(this.e)) <= 0) goto L19;
        this.e = r4;
        return;
    L19:
        return;
    L13:
        if (this.f4672b.compare(r4, (Object) ao.a(this.e)) >= 0) goto L21;
        T[] r3 = this.c;
        int r5 = this.d;
        int r6 = r5 + 1;
        this.d = r6;
        r3[r5] = r4;
        if (r6 != (this.f4671a * 2)) goto L22;
        b();
        return;
    L22:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Iterator<? extends T> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
    L4:
        if (r4.hasNext() == false) goto L6;
        a(r4.next());
        goto L4
    }
}
