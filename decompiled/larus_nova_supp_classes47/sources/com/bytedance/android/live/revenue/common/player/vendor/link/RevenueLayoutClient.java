package com.bytedance.android.live.revenue.common.player.vendor.link;

import android.graphics.RectF;
import com.bytedance.android.live.link.player.DeviceType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rc0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevenueLayoutClient implements rx0.a {
    public int a;
    public int b;
    public int c;
    public int d;
    public a e;
    public DeviceType f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public RevSeiFrame k;
    public zx0.b l;
    public int m;
    public zx0.a n;
    public float o;
    public final b p;

    @Override // rx0.a
    public final sx0.a a() {
        zx0.b r0 = this.l;
        if (r0 == null) goto L7;
        sx0.a r1 = r0.b;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new sx0.a.C0316a(1.0f, 0, 0.0f);
    }

    @Override // rx0.a
    public final RectF b() {
        zx0.b r0 = this.l;
        if (r0 == null) goto L7;
        RectF r1 = r0.a;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void c() {
        a r0 = this.e;
        boolean r2 = n.a(this.f);
        DeviceType r1 = this.f;
        Intrinsics.checkNotNullParameter(r1, "$this$isFoldFull");
        if (r1 != DeviceType.FOLD_FULL) goto L5;
        boolean r3 = true;
    L6:
        c r14 = new c(r2, r3, this.g, this.a, this.b, this.c, this.d, this.m, this.k, this.h, this.i, this.j);
        b r4 = this.p;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r14, "layoutContext");
        Iterator r5 = ((ArrayList) r4.a).iterator();
    L7:
        zx0.b r6 = null;
        if (r5.hasNext() == false) goto L12;
        Object r7 = r5.next();
        if (((zx0.a) r7).c(r14) == false) goto L7;
    L13:
        this.n = (zx0.a) r7;
        if (Intrinsics.areEqual(r0, a.b.a) == false) goto L19;
        zx0.a r8 = this.n;
        if (r8 == null) goto L26;
        r6 = r8.a(r14);
    L26:
        this.l = r6;
        return;
    L19:
        if ((r0 instanceof a.C0083a) == false) goto L29;
        RectF r9 = ((a.C0083a) r0).a;
        zx0.a r10 = this.n;
        if (r10 == null) goto L26;
        RectF r12 = r10.b(r14);
        if (r12 == null) goto L26;
        sx0.a.e r13 = new sx0.a.e(r9);
        float r15 = r12.centerX();
        float r16 = r12.centerY();
        float r17 = r12.width() * this.o;
        float r18 = r12.height() * this.o;
        float r19 = r17 / 2.0f;
        float r20 = r18 / 2.0f;
        r6 = new zx0.b(new RectF(RangesKt.coerceAtLeast(r15 - r19, 0.0f), RangesKt.coerceAtLeast(r16 - r20, 0.0f), RangesKt.coerceAtMost(r15 + r19, 1.0f), RangesKt.coerceAtMost(r16 + r20, 1.0f)), r13, null);
        goto L26
    L29:
        throw new NoWhenBranchMatchedException();
    L12:
        r7 = null;
        goto L13
    L5:
        r3 = false;
        goto L6
    }

    public RevenueLayoutClient() {
        this.e = a.b.a;
        this.f = DeviceType.NORMAL_MOBILE;
        this.g = true;
        RevSeiFrame.G.getClass();
        this.k = (RevSeiFrame) RevSeiFrame.D.getValue();
        this.o = 1.0f;
        this.p = new b(RevenueLayoutClient$strategyManager$1.INSTANCE);
    }

    @Override // rx0.a
    public final int getContainerWidth() {
        return this.a;
    }

    @Override // rx0.a
    public final int l() {
        return this.b;
    }
}
