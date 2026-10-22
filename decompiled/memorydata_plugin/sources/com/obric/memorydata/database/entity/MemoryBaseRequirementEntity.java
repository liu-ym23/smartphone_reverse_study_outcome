package com.obric.memorydata.database.entity;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryBaseRequirementEntity;", "", "requirementId", "", Params.CONTENT, AILabCheckPermissionTask.KEY_SOURCE, "status", "sceneId", "errorMessage", "createTime", "", "updateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getRequirementId", "()Ljava/lang/String;", "getContent", "getSource", "getStatus", "getSceneId", "getErrorMessage", "getCreateTime", "()J", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBaseRequirementEntity {
    private final String content;
    private final long createTime;
    private final String errorMessage;
    private final String requirementId;
    private final String sceneId;
    private final String source;
    private final String status;
    private final long updateTime;

    public MemoryBaseRequirementEntity(String r2, String r3, String r4, String r5, String r6, String r7, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r2, "requirementId");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "status");
        Intrinsics.checkNotNullParameter(r6, "sceneId");
        Intrinsics.checkNotNullParameter(r7, "errorMessage");
        this.requirementId = r2;
        this.content = r3;
        this.source = r4;
        this.status = r5;
        this.sceneId = r6;
        this.errorMessage = r7;
        this.createTime = r8;
        this.updateTime = r10;
    }

    public /* synthetic */ MemoryBaseRequirementEntity(String r12, String r13, String r14, String r15, String r16, String r17, long r18, long r20, int r22, DefaultConstructorMarker r23) {
        String r2 = "";
        if ((r22 & 2) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r22 & 4) == 0) goto L9;
        String r3 = "user";
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r4 = "PENDING";
    L15:
        if ((r22 & 16) == 0) goto L17;
        String r5 = "user_defined_memory_requirements";
    L19:
        if ((r22 & 32) != 0) goto L22;
        r2 = r17;
    L22:
        long r7 = 0;
        if ((r22 & 64) == 0) goto L25;
        long r9 = 0;
    L27:
        if ((r22 & 128) != 0) goto L30;
        r7 = r20;
    L30:
        this(r12, r1, r3, r4, r5, r2, r9, r7);
        return;
    L25:
        r9 = r18;
        goto L27
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    public static /* synthetic */ MemoryBaseRequirementEntity copy$default(MemoryBaseRequirementEntity r12, String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r2 = r12.requirementId;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r3 = r12.content;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r4 = r12.source;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r5 = r12.status;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r6 = r12.sceneId;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r7 = r12.errorMessage;
    L27:
        if ((r23 & 64) == 0) goto L29;
        long r8 = r12.createTime;
    L31:
        if ((r23 & 128) == 0) goto L33;
        long r10 = r12.updateTime;
    L35:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r10);
    L33:
        r10 = r21;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.requirementId;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.source;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.sceneId;
    }

    public final String component6() {
        return this.errorMessage;
    }

    public final long component7() {
        return this.createTime;
    }

    public final long component8() {
        return this.updateTime;
    }

    public final MemoryBaseRequirementEntity copy(String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21) {
        Intrinsics.checkNotNullParameter(r13, "requirementId");
        Intrinsics.checkNotNullParameter(r14, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r15, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r16, "status");
        Intrinsics.checkNotNullParameter(r17, "sceneId");
        Intrinsics.checkNotNullParameter(r18, "errorMessage");
        return new MemoryBaseRequirementEntity(r13, r14, r15, r16, r17, r18, r19, r21);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryBaseRequirementEntity.class) == true) goto L8;
        return false;
    L8:
        MemoryBaseRequirementEntity r10 = (MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(r9, MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.requirementId, r10.requirementId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r10.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sceneId, r10.sceneId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errorMessage, r10.errorMessage) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r10.createTime) goto L30;
        return false;
    L30:
        if (this.updateTime == r10.updateTime) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getRequirementId() {
        return this.requirementId;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStatus() {
        return this.status;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((this.requirementId.hashCode() * 31) + this.content.hashCode()) * 31) + this.source.hashCode()) * 31) + this.status.hashCode()) * 31) + this.sceneId.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.updateTime);
    }

    public String toString() {
        return "MemoryBaseRequirementEntity(requirementId=" + this.requirementId + ", content=" + this.content + ", source=" + this.source + ", status=" + this.status + ", sceneId=" + this.sceneId + ", errorMessage=" + this.errorMessage + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ')';
    }
}
