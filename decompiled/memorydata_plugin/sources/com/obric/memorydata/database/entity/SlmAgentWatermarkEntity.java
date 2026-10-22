package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/entity/SlmAgentWatermarkEntity;", "", "ruleId", "", "batchId", "", "lastRunMs", "nextRunMs", "updateTimeMs", "<init>", "(JLjava/lang/String;JJJ)V", "getRuleId", "()J", "getBatchId", "()Ljava/lang/String;", "getLastRunMs", "getNextRunMs", "getUpdateTimeMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlmAgentWatermarkEntity {
    private final String batchId;
    private final long lastRunMs;
    private final long nextRunMs;
    private final long ruleId;
    private final long updateTimeMs;

    public SlmAgentWatermarkEntity() {
        this(0, null, 0, 0, 0, 31, null);
    }

    public SlmAgentWatermarkEntity(long r2, String r4, long r5, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r4, "batchId");
        this.ruleId = r2;
        this.batchId = r4;
        this.lastRunMs = r5;
        this.nextRunMs = r7;
        this.updateTimeMs = r9;
    }

    public /* synthetic */ SlmAgentWatermarkEntity(long r3, String r5, long r6, long r8, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r5 = "";
    L9:
        if ((r12 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r8 = 0;
    L15:
        if ((r12 & 16) == 0) goto L17;
        r10 = 0;
    L17:
        this(r3, r5, r6, r8, r10);
    }

    public static /* synthetic */ SlmAgentWatermarkEntity copy$default(SlmAgentWatermarkEntity r10, long r11, String r13, long r14, long r16, long r18, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = r10.ruleId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.batchId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r4 = r10.lastRunMs;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r6 = r10.nextRunMs;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r8 = r10.updateTimeMs;
    L23:
        return r10.copy(r1, r3, r4, r6, r8);
    L21:
        r8 = r18;
        goto L23
    L17:
        r6 = r16;
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

    public final long component1() {
        return this.ruleId;
    }

    public final String component2() {
        return this.batchId;
    }

    public final long component3() {
        return this.lastRunMs;
    }

    public final long component4() {
        return this.nextRunMs;
    }

    public final long component5() {
        return this.updateTimeMs;
    }

    public final SlmAgentWatermarkEntity copy(long r12, String r14, long r15, long r17, long r19) {
        Intrinsics.checkNotNullParameter(r14, "batchId");
        return new SlmAgentWatermarkEntity(r12, r14, r15, r17, r19);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SlmAgentWatermarkEntity.class) == true) goto L8;
        return false;
    L8:
        SlmAgentWatermarkEntity r10 = (SlmAgentWatermarkEntity) ZeusTransformUtils.preCheckCast(r9, SlmAgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        if (this.ruleId == r10.ruleId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.batchId, r10.batchId) == true) goto L15;
        return false;
    L15:
        if (this.lastRunMs == r10.lastRunMs) goto L18;
        return false;
    L18:
        if (this.nextRunMs == r10.nextRunMs) goto L21;
        return false;
    L21:
        if (this.updateTimeMs == r10.updateTimeMs) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final long getLastRunMs() {
        return this.lastRunMs;
    }

    public final long getNextRunMs() {
        return this.nextRunMs;
    }

    public final long getRuleId() {
        return this.ruleId;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.ruleId) * 31) + this.batchId.hashCode()) * 31) + Long.hashCode(this.lastRunMs)) * 31) + Long.hashCode(this.nextRunMs)) * 31) + Long.hashCode(this.updateTimeMs);
    }

    public String toString() {
        return "SlmAgentWatermarkEntity(ruleId=" + this.ruleId + ", batchId=" + this.batchId + ", lastRunMs=" + this.lastRunMs + ", nextRunMs=" + this.nextRunMs + ", updateTimeMs=" + this.updateTimeMs + ')';
    }
}
