package com.bytedance.android.live.profit.vote.model;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final long d = 0;
    public long a;
    public long b;
    public long c;

    public static final class a {
    }

    static {
        d = -1;
    }

    public static long c() {
        i97.a r0 = i97.a.a;
        return SystemClock.elapsedRealtime();
    }

    public final boolean b() {
        long r0 = this.a;
        long r2 = d;
        if (r0 != r2) goto L5;
    L7:
        return false;
    L5:
        if (this.c == r2) goto L7;
        return true;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("VoteClock(start=");
        r0.append(this.a);
        r0.append(", pause=");
        r0.append(this.b);
        r0.append(", finish=");
        r0.append(this.c);
        r0.append(", total=");
        if (b() == false) goto L7;
        long r1 = this.c - this.a;
        if (r1 >= 0) goto L8;
        r1 = 0;
    L8:
        r0.append(r1);
        r0.append(", remain=");
        r0.append(a());
        r0.append(')');
        return r0.toString();
    L7:
        r1 = d;
        goto L8
    }

    public d() {
        long r0 = d;
        this.a = r0;
        this.b = r0;
        this.c = r0;
    }

    public final long a() {
        boolean r0 = b();
        long r1 = d;
        if (r0 == false) goto L14;
        long r3 = this.b;
        if (r3 != r1) goto L9;
        long r2 = this.c - c();
        if (r2 < 0) goto L15;
    L13:
        return r2;
    L15:
        return 0;
    L9:
        r2 = this.c - r3;
        if (r2 >= 0) goto L13;
    L14:
        return r1;
    }
}
