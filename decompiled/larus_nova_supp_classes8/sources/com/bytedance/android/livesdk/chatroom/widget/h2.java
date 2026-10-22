package com.bytedance.android.livesdk.chatroom.widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h2 {
    public final long a;
    public final long b;
    public final long c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h2) == false) goto L12;
        h2 r7 = (h2) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "RevenuePreloadInfo(roomID=" + this.a + ", channelID=" + this.b + ", version=" + this.c + ")";
    }

    public h2(long r1, long r3, long r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }
}
