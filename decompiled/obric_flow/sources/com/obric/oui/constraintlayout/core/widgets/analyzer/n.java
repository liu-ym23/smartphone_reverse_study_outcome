package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f12583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f12584b;

    public static long a(g r10, long r11) {
        s r5 = r10.d;
        if ((r5 instanceof k) == false) goto L5;
        return r11;
    L5:
        ArrayList r12 = r10.f12577k;
        int r13 = r12.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        e r16 = (e) r12.get(r14);
        if ((r16 instanceof g) == false) goto L13;
        g r17 = (g) r16;
        if (r17.d == r5) goto L13;
        r15 = Math.min(r15, a(r17, ((long) r17.f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r5.f12596i) goto L22;
        long r18 = r5.j();
        g r19 = r5.f12595h;
        long r110 = r11 - r18;
        return Math.min(Math.min(r15, a(r19, r110)), r110 - ((long) r19.f));
    L22:
        return r15;
    }

    public static long b(g r10, long r11) {
        s r5 = r10.d;
        if ((r5 instanceof k) == false) goto L5;
        return r11;
    L5:
        ArrayList r12 = r10.f12577k;
        int r13 = r12.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        e r16 = (e) r12.get(r14);
        if ((r16 instanceof g) == false) goto L13;
        g r17 = (g) r16;
        if (r17.d == r5) goto L13;
        r15 = Math.max(r15, b(r17, ((long) r17.f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r5.f12595h) goto L22;
        long r18 = r5.j();
        g r19 = r5.f12596i;
        long r110 = r11 + r18;
        return Math.max(Math.max(r15, b(r19, r110)), r110 - ((long) r19.f));
    L22:
        return r15;
    }
}
