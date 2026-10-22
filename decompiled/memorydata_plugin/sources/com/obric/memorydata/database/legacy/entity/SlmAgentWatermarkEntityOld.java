package com.obric.memorydata.database.legacy.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/SlmAgentWatermarkEntityOld;", "", "ruleId", "", "batchId", "", "lastRunMs", "nextRunMs", "updateTimeMs", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;JJJZ)V", "getRuleId", "()J", "getBatchId", "()Ljava/lang/String;", "getLastRunMs", "getNextRunMs", "getUpdateTimeMs", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlmAgentWatermarkEntityOld {
    private final String batchId;
    private final long lastRunMs;
    private final long nextRunMs;
    private final boolean personalDbSplitMigrated;
    private final long ruleId;
    private final long updateTimeMs;

    public SlmAgentWatermarkEntityOld() {
        this(0, null, 0, 0, 0, false, 63, null);
    }

    public SlmAgentWatermarkEntityOld(long r2, String r4, long r5, long r7, long r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r4, "batchId");
        this.ruleId = r2;
        this.batchId = r4;
        this.lastRunMs = r5;
        this.nextRunMs = r7;
        this.updateTimeMs = r9;
        this.personalDbSplitMigrated = r11;
    }

    public /* synthetic */ SlmAgentWatermarkEntityOld(long r3, String r5, long r6, long r8, long r10, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r5 = "";
    L9:
        if ((r13 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r8 = 0;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r10 = 0;
    L18:
        if ((r13 & 32) == 0) goto L20;
        r12 = false;
    L20:
        this(r3, r5, r6, r8, r10, r12);
    }

    public static /* synthetic */ SlmAgentWatermarkEntityOld copy$default(SlmAgentWatermarkEntityOld r11, long r12, String r14, long r15, long r17, long r19, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.ruleId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.batchId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r4 = r11.lastRunMs;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r6 = r11.nextRunMs;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r8 = r11.updateTimeMs;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r10 = r11.personalDbSplitMigrated;
    L27:
        return r11.copy(r1, r3, r4, r6, r8, r10);
    L25:
        r10 = r21;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
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

    public final boolean component6() {
        return this.personalDbSplitMigrated;
    }

    public final SlmAgentWatermarkEntityOld copy(long r13, String r15, long r16, long r18, long r20, boolean r22) {
        Intrinsics.checkNotNullParameter(r15, "batchId");
        return new SlmAgentWatermarkEntityOld(r13, r15, r16, r18, r20, r22);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SlmAgentWatermarkEntityOld.class) == true) goto L8;
        return false;
    L8:
        SlmAgentWatermarkEntityOld r10 = (SlmAgentWatermarkEntityOld) ZeusTransformUtils.preCheckCast(r9, SlmAgentWatermarkEntityOld.class, "com.obric.memorydata.plugin");
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
        if (this.updateTimeMs == r10.updateTimeMs) goto L24;
        return false;
    L24:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L26;
        return false;
    L26:
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

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final long getRuleId() {
        return this.ruleId;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.ruleId) * 31) + this.batchId.hashCode()) * 31) + Long.hashCode(this.lastRunMs)) * 31) + Long.hashCode(this.nextRunMs)) * 31) + Long.hashCode(this.updateTimeMs)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public String toString() {
        return "SlmAgentWatermarkEntityOld(ruleId=" + this.ruleId + ", batchId=" + this.batchId + ", lastRunMs=" + this.lastRunMs + ", nextRunMs=" + this.nextRunMs + ", updateTimeMs=" + this.updateTimeMs + ", personalDbSplitMigrated=" + this.personalDbSplitMigrated + ')';
    }
}
