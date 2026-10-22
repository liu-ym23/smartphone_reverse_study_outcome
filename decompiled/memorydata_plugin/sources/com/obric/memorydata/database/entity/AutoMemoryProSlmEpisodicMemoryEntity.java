package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0083\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\rHÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00064"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProSlmEpisodicMemoryEntity;", "", OaidModel.KEY_ID, "", "data", "", "targetRuleId", "createTimestamp", "userActionTimestamp", "location", "locationState", "packageNames", "retryCount", "", "stepState", "enableState", "batchId", "<init>", "(JLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getId", "()J", "getData", "()Ljava/lang/String;", "getTargetRuleId", "getCreateTimestamp", "getUserActionTimestamp", "getLocation", "getLocationState", "getPackageNames", "getRetryCount", "()I", "getStepState", "getEnableState", "getBatchId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProSlmEpisodicMemoryEntity {
    private final String batchId;
    private final long createTimestamp;
    private final String data;
    private final int enableState;
    private final long id;
    private final String location;
    private final String locationState;
    private final String packageNames;
    private final int retryCount;
    private final int stepState;
    private final String targetRuleId;
    private final long userActionTimestamp;

    public AutoMemoryProSlmEpisodicMemoryEntity() {
        this(0, null, null, 0, 0, null, null, null, 0, 0, 0, null, 4095, null);
    }

    public AutoMemoryProSlmEpisodicMemoryEntity(long r9, String r11, String r12, long r13, long r15, String r17, String r18, String r19, int r20, int r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r12, "targetRuleId");
        Intrinsics.checkNotNullParameter(r17, "location");
        Intrinsics.checkNotNullParameter(r18, "locationState");
        Intrinsics.checkNotNullParameter(r19, "packageNames");
        this.id = r9;
        this.data = r11;
        this.targetRuleId = r12;
        this.createTimestamp = r13;
        this.userActionTimestamp = r15;
        this.location = r17;
        this.locationState = r18;
        this.packageNames = r19;
        this.retryCount = r20;
        this.stepState = r21;
        this.enableState = r22;
        this.batchId = r23;
    }

    public /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntity(long r17, String r19, String r20, long r21, long r23, String r25, String r26, String r27, int r28, int r29, int r30, String r31, int r32, DefaultConstructorMarker r33) {
        long r2 = 0;
        if ((r32 & 1) == 0) goto L5;
        long r4 = 0;
    L6:
        String r6 = "";
        if ((r32 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r32 & 16) != 0) goto L23;
        r2 = r23;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r32 & 128) != 0) goto L34;
        r6 = r27;
    L34:
        int r13 = 0;
        if ((r32 & 256) == 0) goto L37;
        int r12 = 0;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r14 = 0;
    L43:
        if ((r32 & 1024) != 0) goto L47;
        r13 = r30;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r0 = null;
    L50:
        this(r4, r1, r7, r8, r2, r10, r11, r6, r12, r14, r13, r0);
        return;
    L49:
        r0 = r31;
        goto L50
    L41:
        r14 = r29;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L29:
        r11 = r26;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L17:
        r8 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r1 = r19;
        goto L11
    L5:
        r4 = r17;
        goto L6
    }

    public static /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntity copy$default(AutoMemoryProSlmEpisodicMemoryEntity r16, long r17, String r19, String r20, long r21, long r23, String r25, String r26, String r27, int r28, int r29, int r30, String r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = r16.data;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = r16.targetRuleId;
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r6 = r16.createTimestamp;
    L19:
        if ((r32 & 16) == 0) goto L21;
        long r8 = r16.userActionTimestamp;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r10 = r16.location;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r11 = r16.locationState;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r12 = r16.packageNames;
    L35:
        if ((r32 & 256) == 0) goto L37;
        int r13 = r16.retryCount;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r14 = r16.stepState;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        int r15 = r16.enableState;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r1 = r16.batchId;
    L51:
        return r16.copy(r2, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r1);
    L49:
        r1 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L43
    L37:
        r13 = r28;
        goto L39
    L33:
        r12 = r27;
        goto L35
    L29:
        r11 = r26;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.stepState;
    }

    public final int component11() {
        return this.enableState;
    }

    public final String component12() {
        return this.batchId;
    }

    public final String component2() {
        return this.data;
    }

    public final String component3() {
        return this.targetRuleId;
    }

    public final long component4() {
        return this.createTimestamp;
    }

    public final long component5() {
        return this.userActionTimestamp;
    }

    public final String component6() {
        return this.location;
    }

    public final String component7() {
        return this.locationState;
    }

    public final String component8() {
        return this.packageNames;
    }

    public final int component9() {
        return this.retryCount;
    }

    public final AutoMemoryProSlmEpisodicMemoryEntity copy(long r18, String r20, String r21, long r22, long r24, String r26, String r27, String r28, int r29, int r30, int r31, String r32) {
        Intrinsics.checkNotNullParameter(r20, "data");
        Intrinsics.checkNotNullParameter(r21, "targetRuleId");
        Intrinsics.checkNotNullParameter(r26, "location");
        Intrinsics.checkNotNullParameter(r27, "locationState");
        Intrinsics.checkNotNullParameter(r28, "packageNames");
        return new AutoMemoryProSlmEpisodicMemoryEntity(r18, r20, r21, r22, r24, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProSlmEpisodicMemoryEntity.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryProSlmEpisodicMemoryEntity r10 = (AutoMemoryProSlmEpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProSlmEpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetRuleId, r10.targetRuleId) == true) goto L18;
        return false;
    L18:
        if (this.createTimestamp == r10.createTimestamp) goto L21;
        return false;
    L21:
        if (this.userActionTimestamp == r10.userActionTimestamp) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.location, r10.location) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.locationState, r10.locationState) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.packageNames, r10.packageNames) == true) goto L33;
        return false;
    L33:
        if (this.retryCount == r10.retryCount) goto L36;
        return false;
    L36:
        if (this.stepState == r10.stepState) goto L39;
        return false;
    L39:
        if (this.enableState == r10.enableState) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.batchId, r10.batchId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final long getCreateTimestamp() {
        return this.createTimestamp;
    }

    public final String getData() {
        return this.data;
    }

    public final int getEnableState() {
        return this.enableState;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLocationState() {
        return this.locationState;
    }

    public final String getPackageNames() {
        return this.packageNames;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final int getStepState() {
        return this.stepState;
    }

    public final String getTargetRuleId() {
        return this.targetRuleId;
    }

    public final long getUserActionTimestamp() {
        return this.userActionTimestamp;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((Long.hashCode(this.id) * 31) + this.data.hashCode()) * 31) + this.targetRuleId.hashCode()) * 31) + Long.hashCode(this.createTimestamp)) * 31) + Long.hashCode(this.userActionTimestamp)) * 31) + this.location.hashCode()) * 31) + this.locationState.hashCode()) * 31) + this.packageNames.hashCode()) * 31) + Integer.hashCode(this.retryCount)) * 31) + Integer.hashCode(this.stepState)) * 31) + Integer.hashCode(this.enableState)) * 31;
        String r3 = this.batchId;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutoMemoryProSlmEpisodicMemoryEntity(id=").append(this.id).append(", data=").append(this.data).append(", targetRuleId=").append(this.targetRuleId).append(", createTimestamp=").append(this.createTimestamp).append(", userActionTimestamp=").append(this.userActionTimestamp).append(", location=").append(this.location).append(", locationState=").append(this.locationState).append(", packageNames=").append(this.packageNames).append(", retryCount=").append(this.retryCount).append(", stepState=").append(this.stepState).append(", enableState=").append(this.enableState).append(", batchId=");
        r0.append(this.batchId).append(')');
        return r0.toString();
    }
}
