package com.bytedance.android.livesdk.interactivity.api.base;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final PublicScreenAreaPageType a;
    public final long b;
    public final PublicScreenAreaPageChangeSource c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L12;
        d r7 = (d) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PublicScreenAreaPageType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        PublicScreenAreaPageChangeSource r5 = this.c;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PublicScreenAreaPageState(pageType=" + this.a + ", currentPageId=" + this.b + ", changeSource=" + this.c + ")";
    }

    public d(PublicScreenAreaPageType r2, long r3, PublicScreenAreaPageChangeSource r5) {
        Intrinsics.checkNotNullParameter(r2, "pageType");
        Intrinsics.checkNotNullParameter(r5, "changeSource");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
