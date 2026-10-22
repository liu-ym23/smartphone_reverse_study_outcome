package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {
    public final int a;
    public final FeedEntityPreview b;
    public final long c;
    public final long d;
    public final int e;
    public final int f;
    public final int g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r9 = (n) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        FeedEntityPreview r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        long r4 = this.c;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        return ((((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkFeedInfo(badgeCount=" + this.a + ", latestPreview=" + this.b + ", rankTimeMs=" + this.c + ", version=" + this.d + ", badgeCountWithoutDoubao=" + this.e + ", messageOnTopBadgeCount=" + this.f + ", messageWithoutDoubaoOnTopBadgeCount=" + this.g + ')';
    }

    public n(int r1, FeedEntityPreview r2, long r3, long r5, int r7, int r8, int r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
