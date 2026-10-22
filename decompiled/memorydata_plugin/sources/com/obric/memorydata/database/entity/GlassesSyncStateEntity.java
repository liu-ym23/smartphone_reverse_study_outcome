package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/entity/GlassesSyncStateEntity;", "", "accountScope", "", "lastSuccessWindowEnd", "", "<init>", "(Ljava/lang/String;J)V", "getAccountScope", "()Ljava/lang/String;", "getLastSuccessWindowEnd", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlassesSyncStateEntity {
    private final String accountScope;
    private final long lastSuccessWindowEnd;

    public GlassesSyncStateEntity(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        this.accountScope = r2;
        this.lastSuccessWindowEnd = r3;
    }

    public /* synthetic */ GlassesSyncStateEntity(String r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ GlassesSyncStateEntity copy$default(GlassesSyncStateEntity r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.accountScope;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.lastSuccessWindowEnd;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.accountScope;
    }

    public final long component2() {
        return this.lastSuccessWindowEnd;
    }

    public final GlassesSyncStateEntity copy(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "accountScope");
        return new GlassesSyncStateEntity(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, GlassesSyncStateEntity.class) == true) goto L8;
        return false;
    L8:
        GlassesSyncStateEntity r8 = (GlassesSyncStateEntity) ZeusTransformUtils.preCheckCast(r7, GlassesSyncStateEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.accountScope, r8.accountScope) == true) goto L12;
        return false;
    L12:
        if (this.lastSuccessWindowEnd == r8.lastSuccessWindowEnd) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAccountScope() {
        return this.accountScope;
    }

    public final long getLastSuccessWindowEnd() {
        return this.lastSuccessWindowEnd;
    }

    public int hashCode() {
        return (this.accountScope.hashCode() * 31) + Long.hashCode(this.lastSuccessWindowEnd);
    }

    public String toString() {
        return "GlassesSyncStateEntity(accountScope=" + this.accountScope + ", lastSuccessWindowEnd=" + this.lastSuccessWindowEnd + ')';
    }
}
