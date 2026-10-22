package com.bytedance.lark.lark_biz_feed_android;

import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.FeedCardEntity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public final String a;
    public final FeedCardType b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "FeedCardEntity(feedId=" + this.a + ", feedType=" + this.b + ')';
    }

    public final FeedCardEntity a() {
        return new FeedCardEntity(this.a, this.b.into());
    }

    public j(String r2, FeedCardType r3) {
        Intrinsics.checkNotNullParameter(r2, "feedId");
        Intrinsics.checkNotNullParameter(r3, "feedType");
        this.a = r2;
        this.b = r3;
    }
}
