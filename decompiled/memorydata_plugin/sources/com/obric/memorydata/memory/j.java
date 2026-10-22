package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;", "", "requestId", "", "observationId", "", "screenshotTimestamp", "result", "watermarkEventTimeMs", "completionReceived", "", "<init>", "(Ljava/lang/String;JJLjava/lang/String;JZ)V", "getRequestId", "()Ljava/lang/String;", "getObservationId", "()J", "getScreenshotTimestamp", "getResult", "getWatermarkEventTimeMs", "getCompletionReceived", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10229b;
    private final long c;
    private final String d;
    private final long e;
    private final boolean f;

    public j(String r2, long r3, long r5, String r7, long r8, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r7, "result");
        this.f10228a = r2;
        this.f10229b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r10;
    }

    public static /* synthetic */ j a(j r10, String r11, long r12, long r14, String r16, long r17, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.f10228a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        long r2 = r10.f10229b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r7 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r9 = r10.f;
    L27:
        return r10.a(r1, r2, r4, r6, r7, r9);
    L25:
        r9 = r19;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final j a(String r12, long r13, long r15, String r17, long r18, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "requestId");
        Intrinsics.checkNotNullParameter(r17, "result");
        return new j(r12, r13, r15, r17, r18, r20);
    }

    public final String a() {
        return this.f10228a;
    }

    public final long b() {
        return this.f10229b;
    }

    public final long c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10228a, r10.f10228a) == true) goto L12;
        return false;
    L12:
        if (this.f10229b == r10.f10229b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((this.f10228a.hashCode() * 31) + Long.hashCode(this.f10229b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "InAppSignalFlushCompletion(requestId=" + this.f10228a + ", observationId=" + this.f10229b + ", screenshotTimestamp=" + this.c + ", result=" + this.d + ", watermarkEventTimeMs=" + this.e + ", completionReceived=" + this.f + ')';
    }
}
