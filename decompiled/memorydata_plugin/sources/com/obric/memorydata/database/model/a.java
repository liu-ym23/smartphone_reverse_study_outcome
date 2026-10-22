package com.obric.memorydata.database.model;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "", "rawDbId", "", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "expectedModifyTime", "expectedHash", "", "expectedTimestamp", "<init>", "(JLjava/lang/String;Ljava/lang/String;JIJ)V", "getRawDbId", "()J", "getEntityId", "()Ljava/lang/String;", "getPackageName", "getExpectedModifyTime", "getExpectedHash", "()I", "getExpectedTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9606b;
    private final String c;
    private final long d;
    private final int e;
    private final long f;

    public a(long r2, String r4, String r5, long r6, int r8, long r9) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.f9605a = r2;
        this.f9606b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r9;
    }

    public static /* synthetic */ a a(a r10, long r11, String r13, String r14, long r15, int r17, long r18, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = r10.f9605a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.f9606b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r7 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r8 = r10.f;
    L27:
        return r10.a(r1, r3, r4, r5, r7, r8);
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final long a() {
        return this.f9605a;
    }

    public final a a(long r12, String r14, String r15, long r16, int r18, long r19) {
        Intrinsics.checkNotNullParameter(r14, "entityId");
        Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return new a(r12, r14, r15, r16, r18, r19);
    }

    public final String b() {
        return this.f9606b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
        if (this.f9605a == r10.f9605a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9606b, r10.f9606b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
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

    public final long f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f9605a) * 31) + this.f9606b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "CallHistorySourceNumberBackfillCandidate(rawDbId=" + this.f9605a + ", entityId=" + this.f9606b + ", packageName=" + this.c + ", expectedModifyTime=" + this.d + ", expectedHash=" + this.e + ", expectedTimestamp=" + this.f + ')';
    }
}
