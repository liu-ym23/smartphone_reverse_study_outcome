package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/entity/AuditorySyncStateEntity;", "", "accountScope", "", "lastFileEndMs", "", "lastQueryEndMs", "<init>", "(Ljava/lang/String;JJ)V", "getAccountScope", "()Ljava/lang/String;", "getLastFileEndMs", "()J", "getLastQueryEndMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuditorySyncStateEntity {
    private final String accountScope;
    private final long lastFileEndMs;
    private final long lastQueryEndMs;

    public AuditorySyncStateEntity(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        this.accountScope = r2;
        this.lastFileEndMs = r3;
        this.lastQueryEndMs = r5;
    }

    public /* synthetic */ AuditorySyncStateEntity(String r9, long r10, long r12, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r14 & 4) == 0) goto L9;
        long r6 = 0;
    L10:
        this(r9, r4, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }

    public static /* synthetic */ AuditorySyncStateEntity copy$default(AuditorySyncStateEntity r2, String r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.accountScope;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.lastFileEndMs;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.lastQueryEndMs;
    L11:
        String r5 = r3;
        return r2.copy(r5, r0, r6);
    }

    public final String component1() {
        return this.accountScope;
    }

    public final long component2() {
        return this.lastFileEndMs;
    }

    public final long component3() {
        return this.lastQueryEndMs;
    }

    public final AuditorySyncStateEntity copy(String r7, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r7, "accountScope");
        return new AuditorySyncStateEntity(r7, r8, r10);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AuditorySyncStateEntity.class) == true) goto L8;
        return false;
    L8:
        AuditorySyncStateEntity r10 = (AuditorySyncStateEntity) ZeusTransformUtils.preCheckCast(r9, AuditorySyncStateEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.accountScope, r10.accountScope) == true) goto L12;
        return false;
    L12:
        if (this.lastFileEndMs == r10.lastFileEndMs) goto L15;
        return false;
    L15:
        if (this.lastQueryEndMs == r10.lastQueryEndMs) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAccountScope() {
        return this.accountScope;
    }

    public final long getLastFileEndMs() {
        return this.lastFileEndMs;
    }

    public final long getLastQueryEndMs() {
        return this.lastQueryEndMs;
    }

    public int hashCode() {
        return (((this.accountScope.hashCode() * 31) + Long.hashCode(this.lastFileEndMs)) * 31) + Long.hashCode(this.lastQueryEndMs);
    }

    public String toString() {
        return "AuditorySyncStateEntity(accountScope=" + this.accountScope + ", lastFileEndMs=" + this.lastFileEndMs + ", lastQueryEndMs=" + this.lastQueryEndMs + ')';
    }
}
