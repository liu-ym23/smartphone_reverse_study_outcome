package com.obric.memorydata.union.build;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\"J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0096\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\nHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u00069"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticData;", "", "description", "", "keyPhrase", "tagPath", "type", "entityId", "sources", "evidenceCount", "", "userEdit", "", "createTime", "", "modifyTime", "businessType", "mainSourceEntityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getKeyPhrase", "getTagPath", "getType", "getEntityId", "getSources", "getEvidenceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserEdit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getModifyTime", "getBusinessType", "getMainSourceEntityId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/union/build/UnionSemanticData;", "equals", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionSemanticData {
    private final String businessType;
    private final Long createTime;
    private final String description;

    @SerializedName("entity_id")
    private final String entityId;

    @SerializedName("evidenceCount")
    private final Integer evidenceCount;

    @SerializedName("key_phrase")
    private final String keyPhrase;

    @SerializedName("mainSourceEntityId")
    private final String mainSourceEntityId;
    private final Long modifyTime;
    private final String sources;

    @SerializedName("tag_path")
    private final String tagPath;
    private final String type;

    @SerializedName("userEdit")
    private final Boolean userEdit;

    public UnionSemanticData(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, Boolean r9, Long r10, Long r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r3, "keyPhrase");
        Intrinsics.checkNotNullParameter(r4, "tagPath");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r12, "businessType");
        this.description = r2;
        this.keyPhrase = r3;
        this.tagPath = r4;
        this.type = r5;
        this.entityId = r6;
        this.sources = r7;
        this.evidenceCount = r8;
        this.userEdit = r9;
        this.createTime = r10;
        this.modifyTime = r11;
        this.businessType = r12;
        this.mainSourceEntityId = r13;
    }

    public /* synthetic */ UnionSemanticData(String r17, String r18, String r19, String r20, String r21, String r22, Integer r23, Boolean r24, Long r25, Long r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r29 & 2048) == 0) goto L9;
        String r15 = null;
    L10:
        this(r4, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r15);
        return;
    L9:
        r15 = r28;
        goto L10
    L5:
        r4 = r17;
        goto L7
    }

    public static /* synthetic */ UnionSemanticData copy$default(UnionSemanticData r13, String r14, String r15, String r16, String r17, String r18, String r19, Integer r20, Boolean r21, Long r22, Long r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.description;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.keyPhrase;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.tagPath;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.type;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.entityId;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.sources;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Integer r8 = r13.evidenceCount;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Boolean r9 = r13.userEdit;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Long r10 = r13.createTime;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Long r11 = r13.modifyTime;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.businessType;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.mainSourceEntityId;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.description;
    }

    public final Long component10() {
        return this.modifyTime;
    }

    public final String component11() {
        return this.businessType;
    }

    public final String component12() {
        return this.mainSourceEntityId;
    }

    public final String component2() {
        return this.keyPhrase;
    }

    public final String component3() {
        return this.tagPath;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.entityId;
    }

    public final String component6() {
        return this.sources;
    }

    public final Integer component7() {
        return this.evidenceCount;
    }

    public final Boolean component8() {
        return this.userEdit;
    }

    public final Long component9() {
        return this.createTime;
    }

    public final UnionSemanticData copy(String r15, String r16, String r17, String r18, String r19, String r20, Integer r21, Boolean r22, Long r23, Long r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r16, "keyPhrase");
        Intrinsics.checkNotNullParameter(r17, "tagPath");
        Intrinsics.checkNotNullParameter(r18, "type");
        Intrinsics.checkNotNullParameter(r25, "businessType");
        return new UnionSemanticData(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UnionSemanticData.class) == true) goto L8;
        return false;
    L8:
        UnionSemanticData r6 = (UnionSemanticData) ZeusTransformUtils.preCheckCast(r5, UnionSemanticData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keyPhrase, r6.keyPhrase) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagPath, r6.tagPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sources, r6.sources) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.evidenceCount, r6.evidenceCount) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userEdit, r6.userEdit) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.modifyTime, r6.modifyTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.businessType, r6.businessType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.mainSourceEntityId, r6.mainSourceEntityId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final Integer getEvidenceCount() {
        return this.evidenceCount;
    }

    public final String getKeyPhrase() {
        return this.keyPhrase;
    }

    public final String getMainSourceEntityId() {
        return this.mainSourceEntityId;
    }

    public final Long getModifyTime() {
        return this.modifyTime;
    }

    public final String getSources() {
        return this.sources;
    }

    public final String getTagPath() {
        return this.tagPath;
    }

    public final String getType() {
        return this.type;
    }

    public final Boolean getUserEdit() {
        return this.userEdit;
    }

    public int hashCode() {
        String r0 = this.description;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.keyPhrase.hashCode()) * 31) + this.tagPath.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r4 = this.entityId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sources;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.evidenceCount;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.userEdit;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.createTime;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.modifyTime;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((r18 + r20) * 31) + this.businessType.hashCode()) * 31;
        String r22 = this.mainSourceEntityId;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UnionSemanticData(description=").append(this.description).append(", keyPhrase=").append(this.keyPhrase).append(", tagPath=").append(this.tagPath).append(", type=").append(this.type).append(", entityId=").append(this.entityId).append(", sources=").append(this.sources).append(", evidenceCount=").append(this.evidenceCount).append(", userEdit=").append(this.userEdit).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", businessType=").append(this.businessType).append(", mainSourceEntityId=");
        r0.append(this.mainSourceEntityId).append(')');
        return r0.toString();
    }
}
