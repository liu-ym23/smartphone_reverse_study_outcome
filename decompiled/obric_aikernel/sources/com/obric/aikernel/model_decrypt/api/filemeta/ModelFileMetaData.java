package com.obric.aikernel.model_decrypt.api.filemeta;

import d6.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelFileMetaData {

    @c("FEKCipher")
    private final String FEKCipher;

    @c("checkModelIntegrity")
    private final boolean checkModelIntegrity;

    @c("decryptKeyAlias")
    private final String decryptKeyAlias;

    @c("decryptKeyInfo")
    private final String decryptKeyInfo;

    @c("fileName")
    private final String fileName;

    @c("isDecrypted")
    private boolean isDecrypted;

    @c("isEncryptResource")
    private final boolean isEncryptResource;

    @c("isPresetToAssets")
    private final boolean isPresetToAssets;

    @c("isPresetToOS")
    private final boolean isPresetToOS;

    @c("md5")
    private final String md5;

    @c("modelName")
    private final String modelName;

    @c("originSizeBytes")
    private final long originSizeBytes;

    @c("presetKeyInfo")
    private final String presetKeyInfo;

    @c("presetPath")
    private final String presetPath;

    public ModelFileMetaData() {
        this(null, null, null, false, 0, false, false, null, null, null, null, null, false, false, 16383, null);
    }

    public ModelFileMetaData(String r11, String r12, String r13, boolean r14, long r15, boolean r17, boolean r18, String r19, String r20, String r21, String r22, String r23, boolean r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r11, "modelName");
        Intrinsics.checkNotNullParameter(r12, "fileName");
        Intrinsics.checkNotNullParameter(r13, "md5");
        Intrinsics.checkNotNullParameter(r19, "presetKeyInfo");
        Intrinsics.checkNotNullParameter(r20, "presetPath");
        Intrinsics.checkNotNullParameter(r21, "decryptKeyInfo");
        Intrinsics.checkNotNullParameter(r22, "decryptKeyAlias");
        Intrinsics.checkNotNullParameter(r23, "FEKCipher");
        this.modelName = r11;
        this.fileName = r12;
        this.md5 = r13;
        this.isEncryptResource = r14;
        this.originSizeBytes = r15;
        this.isPresetToAssets = r17;
        this.isPresetToOS = r18;
        this.presetKeyInfo = r19;
        this.presetPath = r20;
        this.decryptKeyInfo = r21;
        this.decryptKeyAlias = r22;
        this.FEKCipher = r23;
        this.isDecrypted = r24;
        this.checkModelIntegrity = r25;
    }

    public /* synthetic */ ModelFileMetaData(String r17, String r18, String r19, boolean r20, long r21, boolean r23, boolean r24, String r25, String r26, String r27, String r28, String r29, boolean r30, boolean r31, int r32, DefaultConstructorMarker r33) {
        String r10 = "";
        if ((r32 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r12 = "";
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r13 = "";
    L14:
        boolean r14 = false;
        if ((r32 & 8) == 0) goto L17;
        boolean r15 = false;
    L19:
        if ((r32 & 16) == 0) goto L21;
        long r16 = 0;
    L23:
        if ((r32 & 32) == 0) goto L25;
        boolean r22 = false;
    L27:
        if ((r32 & 64) == 0) goto L29;
        boolean r110 = false;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r111 = "";
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r113 = "";
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r114 = "";
    L47:
        if ((r32 & 2048) != 0) goto L51;
        r10 = r29;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        boolean r115 = false;
    L55:
        if ((r32 & 8192) != 0) goto L58;
        r14 = r31;
    L58:
        this(r11, r12, r13, r15, r16, r22, r110, r111, r112, r113, r114, r10, r115, r14);
        return;
    L53:
        r115 = r30;
        goto L55
    L45:
        r114 = r28;
        goto L47
    L41:
        r113 = r27;
        goto L43
    L37:
        r112 = r26;
        goto L39
    L33:
        r111 = r25;
        goto L35
    L29:
        r110 = r24;
        goto L31
    L25:
        r22 = r23;
        goto L27
    L21:
        r16 = r21;
        goto L23
    L17:
        r15 = r20;
        goto L19
    L13:
        r13 = r19;
        goto L14
    L9:
        r12 = r18;
        goto L11
    L5:
        r11 = r17;
        goto L7
    }

    public static /* synthetic */ ModelFileMetaData copy$default(ModelFileMetaData r16, String r17, String r18, String r19, boolean r20, long r21, boolean r23, boolean r24, String r25, String r26, String r27, String r28, String r29, boolean r30, boolean r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r10 = r16.modelName;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r11 = r16.fileName;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r12 = r16.md5;
    L15:
        if ((r32 & 8) == 0) goto L17;
        boolean r13 = r16.isEncryptResource;
    L19:
        if ((r32 & 16) == 0) goto L21;
        long r14 = r16.originSizeBytes;
    L23:
        if ((r32 & 32) == 0) goto L25;
        boolean r15 = r16.isPresetToAssets;
    L27:
        if ((r32 & 64) == 0) goto L29;
        boolean r22 = r16.isPresetToOS;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r110 = r16.presetKeyInfo;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r111 = r16.presetPath;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r112 = r16.decryptKeyInfo;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r113 = r16.decryptKeyAlias;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r114 = r16.FEKCipher;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        boolean r115 = r16.isDecrypted;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r34 = r16.checkModelIntegrity;
    L59:
        return r16.copy(r10, r11, r12, r13, r14, r15, r22, r110, r111, r112, r113, r114, r115, r34);
    L57:
        r34 = r31;
        goto L59
    L53:
        r115 = r30;
        goto L55
    L49:
        r114 = r29;
        goto L51
    L45:
        r113 = r28;
        goto L47
    L41:
        r112 = r27;
        goto L43
    L37:
        r111 = r26;
        goto L39
    L33:
        r110 = r25;
        goto L35
    L29:
        r22 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r21;
        goto L23
    L17:
        r13 = r20;
        goto L19
    L13:
        r12 = r19;
        goto L15
    L9:
        r11 = r18;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public final String component1() {
        return this.modelName;
    }

    public final String component10() {
        return this.decryptKeyInfo;
    }

    public final String component11() {
        return this.decryptKeyAlias;
    }

    public final String component12() {
        return this.FEKCipher;
    }

    public final boolean component13() {
        return this.isDecrypted;
    }

    public final boolean component14() {
        return this.checkModelIntegrity;
    }

    public final String component2() {
        return this.fileName;
    }

    public final String component3() {
        return this.md5;
    }

    public final boolean component4() {
        return this.isEncryptResource;
    }

    public final long component5() {
        return this.originSizeBytes;
    }

    public final boolean component6() {
        return this.isPresetToAssets;
    }

    public final boolean component7() {
        return this.isPresetToOS;
    }

    public final String component8() {
        return this.presetKeyInfo;
    }

    public final String component9() {
        return this.presetPath;
    }

    public final ModelFileMetaData copy(String r18, String r19, String r20, boolean r21, long r22, boolean r24, boolean r25, String r26, String r27, String r28, String r29, String r30, boolean r31, boolean r32) {
        Intrinsics.checkNotNullParameter(r18, "modelName");
        Intrinsics.checkNotNullParameter(r19, "fileName");
        Intrinsics.checkNotNullParameter(r20, "md5");
        Intrinsics.checkNotNullParameter(r26, "presetKeyInfo");
        Intrinsics.checkNotNullParameter(r27, "presetPath");
        Intrinsics.checkNotNullParameter(r28, "decryptKeyInfo");
        Intrinsics.checkNotNullParameter(r29, "decryptKeyAlias");
        Intrinsics.checkNotNullParameter(r30, "FEKCipher");
        return new ModelFileMetaData(r18, r19, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ModelFileMetaData) == true) goto L8;
        return false;
    L8:
        ModelFileMetaData r11 = (ModelFileMetaData) r10;
        if (Intrinsics.areEqual(this.modelName, r11.modelName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r11.fileName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.md5, r11.md5) == true) goto L18;
        return false;
    L18:
        if (this.isEncryptResource == r11.isEncryptResource) goto L21;
        return false;
    L21:
        if (this.originSizeBytes == r11.originSizeBytes) goto L24;
        return false;
    L24:
        if (this.isPresetToAssets == r11.isPresetToAssets) goto L27;
        return false;
    L27:
        if (this.isPresetToOS == r11.isPresetToOS) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.presetKeyInfo, r11.presetKeyInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.presetPath, r11.presetPath) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.decryptKeyInfo, r11.decryptKeyInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.decryptKeyAlias, r11.decryptKeyAlias) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.FEKCipher, r11.FEKCipher) == true) goto L45;
        return false;
    L45:
        if (this.isDecrypted == r11.isDecrypted) goto L48;
        return false;
    L48:
        if (this.checkModelIntegrity == r11.checkModelIntegrity) goto L50;
        return false;
    L50:
        return true;
    }

    public final boolean getCheckModelIntegrity() {
        return this.checkModelIntegrity;
    }

    public final String getDecryptKeyAlias() {
        return this.decryptKeyAlias;
    }

    public final String getDecryptKeyInfo() {
        return this.decryptKeyInfo;
    }

    public final String getFEKCipher() {
        return this.FEKCipher;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final long getOriginSizeBytes() {
        return this.originSizeBytes;
    }

    public final String getPresetKeyInfo() {
        return this.presetKeyInfo;
    }

    public final String getPresetPath() {
        return this.presetPath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r10 = ((((this.modelName.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.md5.hashCode()) * 31;
        boolean r11 = this.isEncryptResource;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L5;
        r13 = 1;
    L5:
        int r14 = (((r10 + r13) * 31) + Long.hashCode(this.originSizeBytes)) * 31;
        boolean r15 = this.isPresetToAssets;
        ?? r16 = r15;
        if (r15 == false) goto L8;
        r16 = 1;
    L8:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.isPresetToOS;
        ?? r19 = r18;
        if (r18 == false) goto L11;
        r19 = 1;
    L11:
        int r20 = (((((((((((r17 + r19) * 31) + this.presetKeyInfo.hashCode()) * 31) + this.presetPath.hashCode()) * 31) + this.decryptKeyInfo.hashCode()) * 31) + this.decryptKeyAlias.hashCode()) * 31) + this.FEKCipher.hashCode()) * 31;
        boolean r21 = this.isDecrypted;
        ?? r22 = r21;
        if (r21 == false) goto L14;
        r22 = 1;
    L14:
        int r23 = (r20 + r22) * 31;
        boolean r24 = this.checkModelIntegrity;
        if (r24 == true) goto L19;
        r12 = r24;
    L19:
        return r23 + r12;
    }

    public final boolean isDecrypted() {
        return this.isDecrypted;
    }

    public final boolean isEncryptResource() {
        return this.isEncryptResource;
    }

    public final boolean isPreset() {
        return this.isPresetToAssets;
    }

    public final boolean isPresetToAssets() {
        return this.isPresetToAssets;
    }

    public final boolean isPresetToOS() {
        return this.isPresetToOS;
    }

    public final boolean lackDecryptInfo() {
        if (this.FEKCipher.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L19;
        if (this.decryptKeyInfo.length() != 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
        return true;
    L13:
        if (this.decryptKeyAlias.length() != 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L19;
        return true;
    L15:
        r12 = false;
        goto L16
    L10:
        r11 = false;
    L19:
        return false;
    L5:
        r10 = false;
        goto L6
    }

    public final void setDecrypted(boolean r10) {
        this.isDecrypted = r10;
    }

    public String toString() {
        return "ModelFileMetaData(modelName=" + this.modelName + ", fileName=" + this.fileName + ", md5=" + this.md5 + ", isEncryptResource=" + this.isEncryptResource + ", originSizeBytes=" + this.originSizeBytes + ", isPresetToAssets=" + this.isPresetToAssets + ", isPresetToOS=" + this.isPresetToOS + ", presetKeyInfo=" + this.presetKeyInfo + ", presetPath=" + this.presetPath + ", decryptKeyInfo=" + this.decryptKeyInfo + ", decryptKeyAlias=" + this.decryptKeyAlias + ", FEKCipher=" + this.FEKCipher + ", isDecrypted=" + this.isDecrypted + ", checkModelIntegrity=" + this.checkModelIntegrity + ')';
    }
}
