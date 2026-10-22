package com.bytedance.android.livesdk.interactivity.medialink.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements x32.b {
    public static final /* synthetic */ int c = 0;
    public final x32.c a;
    public final x32.d b;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null, null, 3);
    }

    public final int hashCode() {
        x32.c r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        x32.d r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MediaLinkSwitchExtraContext(multiLinkAnchorSwitchContext=" + this.a + ", multiLinkAudienceSwitchContext=" + this.b + ")";
    }

    @Override // x32.b
    public final x32.d W0() {
        return this.b;
    }

    @Override // x32.b
    public final x32.c a() {
        return this.a;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L10;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public e(f r3, g r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this.a = r3;
        this.b = r4;
    }
}
