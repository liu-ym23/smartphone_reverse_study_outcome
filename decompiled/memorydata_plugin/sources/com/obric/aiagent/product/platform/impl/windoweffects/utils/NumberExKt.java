package com.obric.aiagent.product.platform.impl.windoweffects.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"equalsEpsilon", "", "", "other", "epsilon", "", "product-platform_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NumberExKt {
    public static final boolean equalsEpsilon(double r0, double r2, double r4) {
        if (Math.abs(r0 - r2) >= r4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean equalsEpsilon(float r0, float r1, float r2) {
        if (Math.abs(r0 - r1) >= r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean equalsEpsilon$default(double r6, double r8, double r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = 1.0E-9d;
    L6:
        return equalsEpsilon(r6, r8, r10);
    }

    public static /* synthetic */ boolean equalsEpsilon$default(float r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1.0E-6f;
    L6:
        return equalsEpsilon(r0, r1, r2);
    }
}
