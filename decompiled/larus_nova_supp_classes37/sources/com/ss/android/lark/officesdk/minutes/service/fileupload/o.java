package com.ss.android.lark.officesdk.minutes.service.fileupload;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o {
    public final eub.f a;
    public final eub.g b;
    public final String c;
    public final List<String> d;
    public final Map<String, Boolean> e;
    public final Map<String, Long> f;
    public final Map<String, Long> g;
    public final Map<String, String> h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        long r1 = this.i;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.j;
        return ((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.k) * 31) + this.l;
    }

    public final String toString() {
        return "MmMinutesFileUploadStoredTask(param=" + this.a + ", status=" + this.b + ", uploadToken=" + this.c + ", uploadTaskIds=" + this.d + ", uploadTaskDoneMap=" + this.e + ", uploadTaskTransferredBytes=" + this.f + ", uploadTaskTotalBytes=" + this.g + ", uploadFileTokenMap=" + this.h + ", lastTotalTransferredBytes=" + this.i + ", lastCallbackTs=" + this.j + ", lastSpeedKBps=" + this.k + ", pipelineRetryCount=" + this.l + ')';
    }

    public o() {
        this(new eub.f(null, null, null, null, null, null, null, null, null, 511), new eub.g(null, null, 255), "", CollectionsKt.emptyList(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), 0, 0, 0, 0);
    }

    public o(eub.f r2, eub.g r3, String r4, List<String> r5, Map<String, Boolean> r6, Map<String, Long> r7, Map<String, Long> r8, Map<String, String> r9, long r10, long r12, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "status");
        Intrinsics.checkNotNullParameter(r4, "uploadToken");
        Intrinsics.checkNotNullParameter(r5, "uploadTaskIds");
        Intrinsics.checkNotNullParameter(r6, "uploadTaskDoneMap");
        Intrinsics.checkNotNullParameter(r7, "uploadTaskTransferredBytes");
        Intrinsics.checkNotNullParameter(r8, "uploadTaskTotalBytes");
        Intrinsics.checkNotNullParameter(r9, "uploadFileTokenMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r14;
        this.l = r15;
    }
}
