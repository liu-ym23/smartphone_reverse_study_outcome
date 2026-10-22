package com.larus.community.impl.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q1 {
    public final long a;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q1) == true) goto L9;
        return false;
    L9:
        if (this.a == ((q1) r8).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "InvokeNotifyEvent(uniqueId=" + this.a + ')';
    }

    public q1(long r1) {
        this.a = r1;
    }
}
