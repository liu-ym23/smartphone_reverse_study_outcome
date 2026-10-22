package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map.Entry[] f9220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9221b;

    public x3(int r5) {
        this.f9220a = new Map.Entry[r5];
        this.f9221b = 0;
    }

    public ImmutableMap a() {
        return d();
    }

    public final ImmutableMap b(boolean r5) {
        int r10 = this.f9221b;
        if (r10 == 0) goto L11;
        if (r10 != 1) goto L7;
        Map.Entry r11 = this.f9220a[0];
        Objects.requireNonNull(r11);
        return ImmutableMap.of(r11.getKey(), r11.getValue());
    L7:
        return RegularImmutableMap.fromEntryArray(r10, this.f9220a, r5);
    L11:
        return ImmutableMap.of();
    }

    public ImmutableMap c() {
        return b(false);
    }

    public ImmutableMap d() {
        return b(true);
    }

    public x3 e(x3 r10) {
        r10.getClass();
        f(this.f9221b + r10.f9221b);
        System.arraycopy(r10.f9220a, 0, this.f9220a, this.f9221b, r10.f9221b);
        this.f9221b += r10.f9221b;
        return this;
    }

    public final void f(int r5) {
        Map.Entry[] r10 = this.f9220a;
        if (r5 <= r10.length) goto L6;
        this.f9220a = (Map.Entry[]) Arrays.copyOf(r10, p7.B(r10.length, r5));
        return;
    }

    public x3 g(Object r5, Object r10) {
        f(this.f9221b + 1);
        Map.Entry r11 = ImmutableMap.entryOf(r5, r10);
        Map.Entry[] r12 = this.f9220a;
        int r13 = this.f9221b;
        this.f9221b = r13 + 1;
        r12[r13] = r11;
        return this;
    }

    public x3 h(Set r5) {
        if ((r5 instanceof Collection) == false) goto L5;
        int r10 = this.f9221b;
        f(r5.size() + r10);
    L5:
        Iterator r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r12 = (Map.Entry) r11.next();
        g(r12.getKey(), r12.getValue());
        goto L7
    L9:
        return this;
    }

    public void i(ImmutableMap r5) {
        h(r5.entrySet());
    }
}
