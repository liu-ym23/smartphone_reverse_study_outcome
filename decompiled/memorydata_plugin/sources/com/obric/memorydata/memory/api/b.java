package com.obric.memorydata.memory.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/api/InAppTraceReportItem;", "", "tosUri", "", "startTimestamp", "", "endTimestamp", "<init>", "(Ljava/lang/String;JJ)V", "getTosUri", "()Ljava/lang/String;", "getStartTimestamp", "()J", "getEndTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10061b;
    private final long c;

    public b(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "tosUri");
        this.f10060a = r2;
        this.f10061b = r3;
        this.c = r5;
    }

    public static /* synthetic */ b a(b r2, String r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.f10060a;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.f10061b;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.c;
    L11:
        String r5 = r3;
        return r2.a(r5, r0, r6);
    }

    public final b a(String r7, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r7, "tosUri");
        return new b(r7, r8, r10);
    }

    public final String a() {
        return this.f10060a;
    }

    public final long b() {
        return this.f10061b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10060a, r10.f10060a) == true) goto L12;
        return false;
    L12:
        if (this.f10061b == r10.f10061b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f10060a.hashCode() * 31) + Long.hashCode(this.f10061b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "InAppTraceReportItem(tosUri=" + this.f10060a + ", startTimestamp=" + this.f10061b + ", endTimestamp=" + this.c + ')';
    }
}
