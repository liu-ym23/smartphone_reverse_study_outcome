package com.larus.platform.model.upload;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003JÆ\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\bHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001e¨\u0006="}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadFingerprintMeta;", "Ljava/io/Serializable;", "originHash", "", "transformPolicyId", "policyFamily", "policyDigest", "policySchemaVersion", "", "policyDefinition", "", "fileSize", "", "mimeType", "fileName", "dataType", "bizDomain", "uploadScene", "preCheckMeta", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getOriginHash", "()Ljava/lang/String;", "getTransformPolicyId", "getPolicyFamily", "getPolicyDigest", "getPolicySchemaVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPolicyDefinition", "()Ljava/util/Map;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMimeType", "getFileName", "getDataType", "getBizDomain", "getUploadScene", "getPreCheckMeta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/platform/model/upload/ResourceUploadFingerprintMeta;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ResourceUploadFingerprintMeta implements Serializable {
    private final String bizDomain;
    private final String dataType;
    private final String fileName;
    private final Long fileSize;
    private final String mimeType;
    private final String originHash;
    private final Map<String, String> policyDefinition;
    private final String policyDigest;
    private final String policyFamily;
    private final Integer policySchemaVersion;
    private final Map<String, String> preCheckMeta;
    private final String transformPolicyId;
    private final String uploadScene;

    public ResourceUploadFingerprintMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceUploadFingerprintMeta copy$default(ResourceUploadFingerprintMeta r14, String r15, String r16, String r17, String r18, Integer r19, Map r20, Long r21, String r22, String r23, String r24, String r25, String r26, Map r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = r14.originHash;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.transformPolicyId;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.policyFamily;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.policyDigest;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Integer r6 = r14.policySchemaVersion;
    L23:
        if ((r28 & 32) == 0) goto L25;
        Map r7 = r14.policyDefinition;
    L27:
        if ((r28 & 64) == 0) goto L29;
        Long r8 = r14.fileSize;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r9 = r14.mimeType;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r10 = r14.fileName;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r11 = r14.dataType;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r12 = r14.bizDomain;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = r14.uploadScene;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        Map r1 = r14.preCheckMeta;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
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
        return this.originHash;
    }

    public final String component10() {
        return this.dataType;
    }

    public final String component11() {
        return this.bizDomain;
    }

    public final String component12() {
        return this.uploadScene;
    }

    public final Map<String, String> component13() {
        return this.preCheckMeta;
    }

    public final String component2() {
        return this.transformPolicyId;
    }

    public final String component3() {
        return this.policyFamily;
    }

    public final String component4() {
        return this.policyDigest;
    }

    public final Integer component5() {
        return this.policySchemaVersion;
    }

    public final Map<String, String> component6() {
        return this.policyDefinition;
    }

    public final Long component7() {
        return this.fileSize;
    }

    public final String component8() {
        return this.mimeType;
    }

    public final String component9() {
        return this.fileName;
    }

    public final ResourceUploadFingerprintMeta copy(String r16, String r17, String r18, String r19, Integer r20, Map<String, String> r21, Long r22, String r23, String r24, String r25, String r26, String r27, Map<String, String> r28) {
        return new ResourceUploadFingerprintMeta(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceUploadFingerprintMeta) == true) goto L8;
        return false;
    L8:
        ResourceUploadFingerprintMeta r6 = (ResourceUploadFingerprintMeta) r5;
        if (Intrinsics.areEqual(this.originHash, r6.originHash) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transformPolicyId, r6.transformPolicyId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.policyFamily, r6.policyFamily) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.policyDigest, r6.policyDigest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.policySchemaVersion, r6.policySchemaVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.policyDefinition, r6.policyDefinition) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileSize, r6.fileSize) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mimeType, r6.mimeType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dataType, r6.dataType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bizDomain, r6.bizDomain) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.uploadScene, r6.uploadScene) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.preCheckMeta, r6.preCheckMeta) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r0 = this.originHash;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.transformPolicyId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.policyFamily;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.policyDigest;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.policySchemaVersion;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.policyDefinition;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.fileSize;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.mimeType;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.fileName;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.dataType;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.bizDomain;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.uploadScene;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Map<String, String> r37 = this.preCheckMeta;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
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
        return "ResourceUploadFingerprintMeta(originHash=" + this.originHash + ", transformPolicyId=" + this.transformPolicyId + ", policyFamily=" + this.policyFamily + ", policyDigest=" + this.policyDigest + ", policySchemaVersion=" + this.policySchemaVersion + ", policyDefinition=" + this.policyDefinition + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + ", fileName=" + this.fileName + ", dataType=" + this.dataType + ", bizDomain=" + this.bizDomain + ", uploadScene=" + this.uploadScene + ", preCheckMeta=" + this.preCheckMeta + ')';
    }

    public final String getBizDomain() {
        return this.bizDomain;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getOriginHash() {
        return this.originHash;
    }

    public final Map<String, String> getPolicyDefinition() {
        return this.policyDefinition;
    }

    public final String getPolicyDigest() {
        return this.policyDigest;
    }

    public final String getPolicyFamily() {
        return this.policyFamily;
    }

    public final Integer getPolicySchemaVersion() {
        return this.policySchemaVersion;
    }

    public final Map<String, String> getPreCheckMeta() {
        return this.preCheckMeta;
    }

    public final String getTransformPolicyId() {
        return this.transformPolicyId;
    }

    public final String getUploadScene() {
        return this.uploadScene;
    }

    public ResourceUploadFingerprintMeta(String r1, String r2, String r3, String r4, Integer r5, Map<String, String> r6, Long r7, String r8, String r9, String r10, String r11, String r12, Map<String, String> r13) {
        this.originHash = r1;
        this.transformPolicyId = r2;
        this.policyFamily = r3;
        this.policyDigest = r4;
        this.policySchemaVersion = r5;
        this.policyDefinition = r6;
        this.fileSize = r7;
        this.mimeType = r8;
        this.fileName = r9;
        this.dataType = r10;
        this.bizDomain = r11;
        this.uploadScene = r12;
        this.preCheckMeta = r13;
    }

    public /* synthetic */ ResourceUploadFingerprintMeta(String r15, String r16, String r17, String r18, Integer r19, Map r20, Long r21, String r22, String r23, String r24, String r25, String r26, Map r27, int r28, DefaultConstructorMarker r29) {
        Map r2 = null;
        if ((r28 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        Map r7 = null;
    L27:
        if ((r28 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r2 = r27;
    L54:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2);
        return;
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
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
        r1 = r15;
        goto L7
    }
}
