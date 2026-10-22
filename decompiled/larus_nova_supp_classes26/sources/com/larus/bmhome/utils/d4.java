package com.larus.bmhome.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d4 {
    public long a;
    public boolean b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d4) == true) goto L8;
        return false;
    L8:
        d4 r9 = (d4) r8;
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
        if (this.b == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "VisitEventStep(triggerTime=" + this.a + ", triggered=" + this.b + ')';
    }

    public d4() {
        this.a = 0;
        this.b = false;
    }
}
