package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/entity/AgentWatermarkEntity;", "", "ruleId", "", "episodicLastTs", "semanticLastTs", "lastRunMs", "nextRunMs", "updateTimeMs", "<init>", "(JJJJJJ)V", "getRuleId", "()J", "getEpisodicLastTs", "getSemanticLastTs", "getLastRunMs", "getNextRunMs", "getUpdateTimeMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AgentWatermarkEntity {
    private final long episodicLastTs;
    private final long lastRunMs;
    private final long nextRunMs;
    private final long ruleId;
    private final long semanticLastTs;
    private final long updateTimeMs;

    public AgentWatermarkEntity(long r1, long r3, long r5, long r7, long r9, long r11) {
        this.ruleId = r1;
        this.episodicLastTs = r3;
        this.semanticLastTs = r5;
        this.lastRunMs = r7;
        this.nextRunMs = r9;
        this.updateTimeMs = r11;
    }

    public /* synthetic */ AgentWatermarkEntity(long r17, long r19, long r21, long r23, long r25, long r27, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 8) == 0) goto L5;
        long r10 = 0;
    L7:
        if ((r29 & 16) == 0) goto L9;
        long r12 = 0;
    L10:
        this(r17, r19, r21, r10, r12, r27);
        return;
    L9:
        r12 = r25;
        goto L10
    L5:
        r10 = r23;
        goto L7
    }

    public static /* synthetic */ AgentWatermarkEntity copy$default(AgentWatermarkEntity r13, long r14, long r16, long r18, long r20, long r22, long r24, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r1 = r13.ruleId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r3 = r13.episodicLastTs;
    L11:
        if ((r26 & 4) == 0) goto L13;
        long r5 = r13.semanticLastTs;
    L15:
        if ((r26 & 8) == 0) goto L17;
        long r7 = r13.lastRunMs;
    L19:
        if ((r26 & 16) == 0) goto L21;
        long r9 = r13.nextRunMs;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r11 = r13.updateTimeMs;
    L27:
        return r13.copy(r1, r3, r5, r7, r9, r11);
    L25:
        r11 = r24;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r14;
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

    public final AgentWatermarkEntity copy(long r15, long r17, long r19, long r21, long r23, long r25) {
        return new AgentWatermarkEntity(r15, r17, r19, r21, r23, r25);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AgentWatermarkEntity.class) == true) goto L8;
        return false;
    L8:
        AgentWatermarkEntity r10 = (AgentWatermarkEntity) ZeusTransformUtils.preCheckCast(r9, AgentWatermarkEntity.class, "com.obric.memorydata.plugin");
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
        if (this.updateTimeMs == r10.updateTimeMs) goto L26;
        return false;
    L26:
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
        return (((((((((Long.hashCode(this.ruleId) * 31) + Long.hashCode(this.episodicLastTs)) * 31) + Long.hashCode(this.semanticLastTs)) * 31) + Long.hashCode(this.lastRunMs)) * 31) + Long.hashCode(this.nextRunMs)) * 31) + Long.hashCode(this.updateTimeMs);
    }

    public String toString() {
        return "AgentWatermarkEntity(ruleId=" + this.ruleId + ", episodicLastTs=" + this.episodicLastTs + ", semanticLastTs=" + this.semanticLastTs + ", lastRunMs=" + this.lastRunMs + ", nextRunMs=" + this.nextRunMs + ", updateTimeMs=" + this.updateTimeMs + ')';
    }
}
