package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z {
    public final String a;
    public final r0 b;
    public final a0 c;
    public final w d;
    public final long e;
    public final long f;
    public final Map<String, q0> g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof z) == true) goto L8;
        return false;
    L8:
        z r9 = (z) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.f;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "ResourceAccessSnapshot(taskId=" + this.a + ", key=" + this.b + ", state=" + this.c + ", request=" + this.d + ", createdAtMs=" + this.e + ", updatedAtMs=" + this.f + ", nodeStates=" + this.g + ')';
    }

    public z(String r2, r0 r3, a0 r4, w r5, long r6, long r8, Map<String, q0> r10) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r10, "nodeStates");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
    }

    public /* synthetic */ z(String r14, r0 r15, a0 r16, w r17, long r18, long r20, int r22) {
        if ((r22 & 16) == 0) goto L5;
        long r8 = 0;
    L7:
        if ((r22 & 32) == 0) goto L9;
        long r10 = 0;
    L11:
        if ((r22 & 64) == 0) goto L13;
        Map r0 = MapsKt.emptyMap();
    L14:
        this(r14, r15, r16, r17, r8, r10, r0);
        return;
    L13:
        r0 = null;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }
}
