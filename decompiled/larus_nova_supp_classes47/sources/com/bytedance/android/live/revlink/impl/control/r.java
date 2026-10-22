package com.bytedance.android.live.revlink.impl.control;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public final long a;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof r) == true) goto L6;
        return false;
    L6:
        if (this.a == ((r) r5).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "MultiInfo(channelId=" + this.a + ")";
    }

    public r(long r1) {
        this.a = r1;
    }
}
