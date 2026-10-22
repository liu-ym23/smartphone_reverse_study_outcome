package com.obric.assistant.cocreationreview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h5 {
    public final long a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h5) == true) goto L8;
        return false;
    L8:
        h5 r9 = (h5) r8;
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
        return "LabelingObserveWindow(earliestTimeMillis=" + this.a + ", latestTimeMillis=" + this.b + ')';
    }

    public h5(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
