package com.larus.bmhome.chat.messagetransfer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final long a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "ForwardMessageContent(messageId=" + this.a + ", contentSizeBytes=" + this.b + ')';
    }

    public i(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
