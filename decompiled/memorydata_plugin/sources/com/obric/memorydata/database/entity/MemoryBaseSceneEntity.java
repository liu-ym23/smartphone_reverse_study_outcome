package com.obric.memorydata.database.entity;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryBaseSceneEntity;", "", "sceneId", "", ActivityLifecycle.NAME, "description", Params.CONTENT, "sourceType", "isUserDefined", "", "status", "requirementIds", "createTime", "", "updateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)V", "getSceneId", "()Ljava/lang/String;", "getName", "getDescription", "getContent", "getSourceType", "()I", "getStatus", "getRequirementIds", "getCreateTime", "()J", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBaseSceneEntity {
    private final String content;
    private final long createTime;
    private final String description;
    private final int isUserDefined;
    private final String name;
    private final String requirementIds;
    private final String sceneId;
    private final String sourceType;
    private final String status;
    private final long updateTime;

    public MemoryBaseSceneEntity(String r2, String r3, String r4, String r5, String r6, int r7, String r8, String r9, long r10, long r12) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r6, "sourceType");
        Intrinsics.checkNotNullParameter(r8, "status");
        Intrinsics.checkNotNullParameter(r9, "requirementIds");
        this.sceneId = r2;
        this.name = r3;
        this.description = r4;
        this.content = r5;
        this.sourceType = r6;
        this.isUserDefined = r7;
        this.status = r8;
        this.requirementIds = r9;
        this.createTime = r10;
        this.updateTime = r12;
    }

    public /* synthetic */ MemoryBaseSceneEntity(String r14, String r15, String r16, String r17, String r18, int r19, String r20, String r21, long r22, long r24, int r26, DefaultConstructorMarker r27) {
        String r2 = "";
        if ((r26 & 2) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r26 & 4) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r26 & 8) != 0) goto L15;
        r2 = r17;
    L15:
        if ((r26 & 16) == 0) goto L17;
        String r4 = "default";
    L19:
        if ((r26 & 32) == 0) goto L21;
        int r5 = 0;
    L23:
        if ((r26 & 64) == 0) goto L25;
        String r6 = "active";
    L27:
        if ((r26 & 128) == 0) goto L29;
        String r7 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L30:
        long r9 = 0;
        if ((r26 & 256) == 0) goto L33;
        long r11 = 0;
    L35:
        if ((r26 & 512) != 0) goto L38;
        r9 = r24;
    L38:
        this(r14, r1, r3, r2, r4, r5, r6, r7, r11, r9);
        return;
    L33:
        r11 = r22;
        goto L35
    L29:
        r7 = r21;
        goto L30
    L25:
        r6 = r20;
        goto L27
    L21:
        r5 = r19;
        goto L23
    L17:
        r4 = r18;
        goto L19
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }

    public static /* synthetic */ MemoryBaseSceneEntity copy$default(MemoryBaseSceneEntity r14, String r15, String r16, String r17, String r18, String r19, int r20, String r21, String r22, long r23, long r25, int r27, Object r28) {
        if ((r27 & 1) == 0) goto L5;
        String r2 = r14.sceneId;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r3 = r14.name;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r4 = r14.description;
    L15:
        if ((r27 & 8) == 0) goto L17;
        String r5 = r14.content;
    L19:
        if ((r27 & 16) == 0) goto L21;
        String r6 = r14.sourceType;
    L23:
        if ((r27 & 32) == 0) goto L25;
        int r7 = r14.isUserDefined;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r8 = r14.status;
    L31:
        if ((r27 & 128) == 0) goto L33;
        String r9 = r14.requirementIds;
    L35:
        if ((r27 & 256) == 0) goto L37;
        long r10 = r14.createTime;
    L39:
        if ((r27 & 512) == 0) goto L41;
        long r12 = r14.updateTime;
    L43:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12);
    L41:
        r12 = r25;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final String component1() {
        return this.sceneId;
    }

    public final long component10() {
        return this.updateTime;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.sourceType;
    }

    public final int component6() {
        return this.isUserDefined;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.requirementIds;
    }

    public final long component9() {
        return this.createTime;
    }

    public final MemoryBaseSceneEntity copy(String r15, String r16, String r17, String r18, String r19, int r20, String r21, String r22, long r23, long r25) {
        Intrinsics.checkNotNullParameter(r15, "sceneId");
        Intrinsics.checkNotNullParameter(r16, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r17, "description");
        Intrinsics.checkNotNullParameter(r18, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r19, "sourceType");
        Intrinsics.checkNotNullParameter(r21, "status");
        Intrinsics.checkNotNullParameter(r22, "requirementIds");
        return new MemoryBaseSceneEntity(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryBaseSceneEntity.class) == true) goto L8;
        return false;
    L8:
        MemoryBaseSceneEntity r10 = (MemoryBaseSceneEntity) ZeusTransformUtils.preCheckCast(r9, MemoryBaseSceneEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.sceneId, r10.sceneId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r10.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceType, r10.sourceType) == true) goto L24;
        return false;
    L24:
        if (this.isUserDefined == r10.isUserDefined) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.requirementIds, r10.requirementIds) == true) goto L33;
        return false;
    L33:
        if (this.createTime == r10.createTime) goto L36;
        return false;
    L36:
        if (this.updateTime == r10.updateTime) goto L38;
        return false;
    L38:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRequirementIds() {
        return this.requirementIds;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final String getStatus() {
        return this.status;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((((((this.sceneId.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.content.hashCode()) * 31) + this.sourceType.hashCode()) * 31) + Integer.hashCode(this.isUserDefined)) * 31) + this.status.hashCode()) * 31) + this.requirementIds.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.updateTime);
    }

    public final int isUserDefined() {
        return this.isUserDefined;
    }

    public String toString() {
        return "MemoryBaseSceneEntity(sceneId=" + this.sceneId + ", name=" + this.name + ", description=" + this.description + ", content=" + this.content + ", sourceType=" + this.sourceType + ", isUserDefined=" + this.isUserDefined + ", status=" + this.status + ", requirementIds=" + this.requirementIds + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ')';
    }
}
