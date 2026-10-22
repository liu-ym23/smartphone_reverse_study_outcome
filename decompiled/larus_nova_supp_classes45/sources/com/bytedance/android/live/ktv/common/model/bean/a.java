package com.bytedance.android.live.ktv.common.model.bean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final a c = null;
    public final long a;
    public final long b;

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.model.bean.a$a, reason: collision with other inner class name */
    public static final class C0213a {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L10;
        a r7 = (a) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "CountDownEvent(totalTime=" + this.a + ", leftTime=" + this.b + ")";
    }

    static {
        c = new a(1, 0);
    }

    public a(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
