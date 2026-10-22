package com.obric.memorydata.database.index;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/DatabaseExecutionHandle;", "Lcom/obric/memorydata/database/index/ExecutionHandle;", "ownerDbType", "", "rawDbId", "", "entityType", "", "roundId", "pendingId", "expectedTimestamp", "<init>", "(Ljava/lang/String;JIJJJ)V", "getOwnerDbType", "()Ljava/lang/String;", "getRawDbId", "()J", "getEntityType", "()I", "getRoundId", "getPendingId", "getExpectedTimestamp", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class l implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9424b;
    private final int c;
    private final long d;
    private final long e;
    private final long f;

    public l(String r2, long r3, int r5, long r6, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r2, "ownerDbType");
        this.f9423a = r2;
        this.f9424b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r10;
    }

    public final String a() {
        return this.f9423a;
    }

    public final long b() {
        return this.f9424b;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public final long f() {
        return this.f;
    }
}
