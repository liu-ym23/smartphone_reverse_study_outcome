package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProEvaluationStatsEntity;", "", Api.KEY_UUID, "", "stat", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getStat", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProEvaluationStatsEntity {
    private final String stat;
    private final String uuid;

    /* JADX WARN: Multi-variable type inference failed */
    public AutoMemoryProEvaluationStatsEntity() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public AutoMemoryProEvaluationStatsEntity(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, Api.KEY_UUID);
        Intrinsics.checkNotNullParameter(r3, "stat");
        this.uuid = r2;
        this.stat = r3;
    }

    public /* synthetic */ AutoMemoryProEvaluationStatsEntity(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ AutoMemoryProEvaluationStatsEntity copy$default(AutoMemoryProEvaluationStatsEntity r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.uuid;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.stat;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.uuid;
    }

    public final String component2() {
        return this.stat;
    }

    public final AutoMemoryProEvaluationStatsEntity copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, Api.KEY_UUID);
        Intrinsics.checkNotNullParameter(r2, "stat");
        return new AutoMemoryProEvaluationStatsEntity(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProEvaluationStatsEntity.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryProEvaluationStatsEntity r6 = (AutoMemoryProEvaluationStatsEntity) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProEvaluationStatsEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.uuid, r6.uuid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stat, r6.stat) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getStat() {
        return this.stat;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return (this.uuid.hashCode() * 31) + this.stat.hashCode();
    }

    public String toString() {
        return "AutoMemoryProEvaluationStatsEntity(uuid=" + this.uuid + ", stat=" + this.stat + ')';
    }
}
