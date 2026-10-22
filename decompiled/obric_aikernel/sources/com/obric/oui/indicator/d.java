package com.obric.oui.indicator;

import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6835c;

    public d() {
        this.f6833a = "OnPageChangeHelper";
        this.f6834b = -1;
        this.f6835c = -1;
    }

    public abstract boolean a();

    public abstract int b();

    public final void c(int r10, float r11) {
        float r12 = r10 + r11;
        float r13 = b() - 1;
        if (r12 != r13) goto L5;
        r12 = r13 - 1.0E-4f;
    L5:
        int r14 = (int) r12;
        int r15 = r14 + 1;
        float r16 = r15;
        if (r16 > r13) goto L8;
    L10:
        if (r16 > r13) goto L78;
        if (r14 != (-1)) goto L60;
        return;
    L60:
        d(r14, r15, r12 % 1);     // Catch: Exception -> L16
    L21:
        int r17 = this.f6834b;
        if (r17 == (-1)) goto L54;
        if (r14 <= r17) goto L37;
        Iterator<Integer> r18 = RangesKt.until(r17, r14).iterator();
    L26:
        if (r18.hasNext() == false) goto L37;
        int r19 = ((IntIterator) r18).nextInt();
        if (r19 == r15) goto L26;
        e(r19);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == true) goto L35;
        com.obric.oui.common.util.d.f6398b.b(this.f6833a, "抓住了一个Exception并ignore", e);
        goto L26
    L35:
        com.obric.oui.common.util.d.f6398b.d(this.f6833a, "OIndicator: " + e.getMessage());
    L37:
        int r20 = this.f6835c;
        if (r15 >= r20) goto L54;
        if (r20 > r13) goto L54;
        Iterator<Integer> r21 = new IntRange(r15 + 1, this.f6835c).iterator();
    L43:
        if (r21.hasNext() == false) goto L54;
        int r110 = ((IntIterator) r21).nextInt();
        if (r110 == r14) goto L43;
        e(r110);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == true) goto L52;
        com.obric.oui.common.util.d.f6398b.b(this.f6833a, "抓住了一个Exception并ignore", e);
        goto L43
    L52:
        com.obric.oui.common.util.d.f6398b.d(this.f6833a, "OIndicator: " + e.getMessage());
    L54:
        this.f6834b = r14;
        this.f6835c = r15;
        return;
    L16:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == false) goto L20;
        com.obric.oui.common.util.d.f6398b.d(this.f6833a, "OIndicator: " + e.getMessage());
        goto L21
    L20:
        com.obric.oui.common.util.d.f6398b.b(this.f6833a, "抓住了一个Exception并ignore", e);
        goto L21
    L78:
        return;
    L8:
        if (a() == false) goto L10;
        r15 = 0;
        goto L60
    }

    public abstract void d(int r10, int r11, float r12);

    public abstract void e(int r10);
}
