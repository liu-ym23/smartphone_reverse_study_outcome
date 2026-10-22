package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/IndexBacklogDbRow;", "", "rawDbId", "", "entityType", "", "buildType", "", "backlogRoundStartedAt", "<init>", "(JILjava/lang/String;J)V", "getRawDbId", "()J", "getEntityType", "()I", "getBuildType", "()Ljava/lang/String;", "getBacklogRoundStartedAt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9324b;
    private final String c;
    private final long d;

    public aa(long r2, int r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "buildType");
        this.f9323a = r2;
        this.f9324b = r4;
        this.c = r5;
        this.d = r6;
    }

    public final long a() {
        return this.f9323a;
    }

    public final int b() {
        return this.f9324b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aa.class) == true) goto L8;
        return false;
    L8:
        aa r10 = (aa) ZeusTransformUtils.preCheckCast(r9, aa.class, "com.obric.memorydata.plugin");
        if (this.f9323a == r10.f9323a) goto L12;
        return false;
    L12:
        if (this.f9324b == r10.f9324b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9323a) * 31) + Integer.hashCode(this.f9324b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "IndexBacklogDbRow(rawDbId=" + this.f9323a + ", entityType=" + this.f9324b + ", buildType=" + this.c + ", backlogRoundStartedAt=" + this.d + ')';
    }
}
