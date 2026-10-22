package com.obric.memorydata.database.legacy.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/AgentWatermarkEntityOld;", "", "ruleId", "", "episodicLastTs", "semanticLastTs", "lastRunMs", "nextRunMs", "updateTimeMs", "personalDbSplitMigrated", "", "<init>", "(JJJJJJZ)V", "getRuleId", "()J", "getEpisodicLastTs", "getSemanticLastTs", "getLastRunMs", "getNextRunMs", "getUpdateTimeMs", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AgentWatermarkEntityOld {
    private final long episodicLastTs;
    private final long lastRunMs;
    private final long nextRunMs;
    private final boolean personalDbSplitMigrated;
    private final long ruleId;
    private final long semanticLastTs;
    private final long updateTimeMs;

    public AgentWatermarkEntityOld(long r1, long r3, long r5, long r7, long r9, long r11, boolean r13) {
        this.ruleId = r1;
        this.episodicLastTs = r3;
        this.semanticLastTs = r5;
        this.lastRunMs = r7;
        this.nextRunMs = r9;
        this.updateTimeMs = r11;
        this.personalDbSplitMigrated = r13;
    }

    public /* synthetic */ AgentWatermarkEntityOld(long r18, long r20, long r22, long r24, long r26, long r28, boolean r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 8) == 0) goto L5;
        long r10 = 0;
    L7:
        if ((r31 & 16) == 0) goto L9;
        long r12 = 0;
    L11:
        if ((r31 & 64) == 0) goto L13;
        boolean r16 = false;
    L14:
        this(r18, r20, r22, r10, r12, r28, r16);
        return;
    L13:
        r16 = r30;
        goto L14
    L9:
        r12 = r26;
        goto L11
    L5:
        r10 = r24;
        goto L7
    }

    public static /* synthetic */ AgentWatermarkEntityOld copy$default(AgentWatermarkEntityOld r14, long r15, long r17, long r19, long r21, long r23, long r25, boolean r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        long r1 = r14.ruleId;
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r3 = r14.episodicLastTs;
    L11:
        if ((r28 & 4) == 0) goto L13;
        long r5 = r14.semanticLastTs;
    L15:
        if ((r28 & 8) == 0) goto L17;
        long r7 = r14.lastRunMs;
    L19:
        if ((r28 & 16) == 0) goto L21;
        long r9 = r14.nextRunMs;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r11 = r14.updateTimeMs;
    L27:
        if ((r28 & 64) == 0) goto L29;
        boolean r13 = r14.personalDbSplitMigrated;
    L31:
        return r14.copy(r1, r3, r5, r7, r9, r11, r13);
    L29:
        r13 = r27;
        goto L31
    L25:
        r11 = r25;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }

    public final long component1() {
        return this.ruleId;
    }

    public final long component2() {
        return this.episodicLastTs;
    }

    public final long component3() {
        return this.semanticLastTs;
    }

    public final long component4() {
        return this.lastRunMs;
    }

    public final long component5() {
        return this.nextRunMs;
    }

    public final long component6() {
        return this.updateTimeMs;
    }

    public final boolean component7() {
        return this.personalDbSplitMigrated;
    }

    public final AgentWatermarkEntityOld copy(long r16, long r18, long r20, long r22, long r24, long r26, boolean r28) {
        return new AgentWatermarkEntityOld(r16, r18, r20, r22, r24, r26, r28);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AgentWatermarkEntityOld.class) == true) goto L8;
        return false;
    L8:
        AgentWatermarkEntityOld r10 = (AgentWatermarkEntityOld) ZeusTransformUtils.preCheckCast(r9, AgentWatermarkEntityOld.class, "com.obric.memorydata.plugin");
        if (this.ruleId == r10.ruleId) goto L12;
        return false;
    L12:
        if (this.episodicLastTs == r10.episodicLastTs) goto L15;
        return false;
    L15:
        if (this.semanticLastTs == r10.semanticLastTs) goto L18;
        return false;
    L18:
        if (this.lastRunMs == r10.lastRunMs) goto L21;
        return false;
    L21:
        if (this.nextRunMs == r10.nextRunMs) goto L24;
        return false;
    L24:
        if (this.updateTimeMs == r10.updateTimeMs) goto L27;
        return false;
    L27:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L29;
        return false;
    L29:
        return true;
    }

    public final long getEpisodicLastTs() {
        return this.episodicLastTs;
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

    public final long getSemanticLastTs() {
        return this.semanticLastTs;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.ruleId) * 31) + Long.hashCode(this.episodicLastTs)) * 31) + Long.hashCode(this.semanticLastTs)) * 31) + Long.hashCode(this.lastRunMs)) * 31) + Long.hashCode(this.nextRunMs)) * 31) + Long.hashCode(this.updateTimeMs)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public String toString() {
        return "AgentWatermarkEntityOld(ruleId=" + this.ruleId + ", episodicLastTs=" + this.episodicLastTs + ", semanticLastTs=" + this.semanticLastTs + ", lastRunMs=" + this.lastRunMs + ", nextRunMs=" + this.nextRunMs + ", updateTimeMs=" + this.updateTimeMs + ", personalDbSplitMigrated=" + this.personalDbSplitMigrated + ')';
    }
}
