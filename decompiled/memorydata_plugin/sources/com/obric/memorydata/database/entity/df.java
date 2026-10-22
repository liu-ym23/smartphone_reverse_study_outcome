package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9019b;
    private final String c;
    private final int d;
    private final String e;
    private final long f;
    private final long g;
    private final long h;
    private final Long i;
    private final long j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, df.class) == true) goto L8;
        return false;
    L8:
        df r10 = (df) ZeusTransformUtils.preCheckCast(r9, df.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9018a, r10.f9018a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9019b, r10.f9019b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((this.f9018a.hashCode() * 31) + this.f9019b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31;
        Long r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((r0 + r3) * 31) + Long.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        String r5 = this.n;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemorySynthesisRun(runId=").append(this.f9018a).append(", requestId=").append(this.f9019b).append(", requestHash=").append(this.c).append(", attempt=").append(this.d).append(", status=").append(this.e).append(", nowMs=").append(this.f).append(", startedAt=").append(this.g).append(", deadlineAt=").append(this.h).append(", finishedAt=").append(this.i).append(", updatedAt=").append(this.j).append(", configJson=").append(this.k).append(", statsJson=");
        r0.append(this.l).append(", reviewHistoryJson=").append(this.m).append(", errorCode=").append(this.n).append(')');
        return r0.toString();
    }
}
