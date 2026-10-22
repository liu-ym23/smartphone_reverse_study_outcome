package com.obric.sva.sdk.effectplatform;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "", "model", "", "date", "version", "description", "authModelFile", "authModelVersion", "authModelMd5", "authKeyFile", "authKeyMd5", "authRawFileMd5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getDate", "getVersion", "getDescription", "getAuthModelFile", "getAuthModelVersion", "getAuthModelMd5", "getAuthKeyFile", "getAuthKeyMd5", "getAuthRawFileMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AuthModelManifest {

    @SerializedName("auth-key")
    private final String authKeyFile;

    @SerializedName("auth-key-md5")
    private final String authKeyMd5;

    @SerializedName("auth-file")
    private final String authModelFile;

    @SerializedName("auth-md5")
    private final String authModelMd5;

    @SerializedName("auth-model-version")
    private final String authModelVersion;

    @SerializedName("auth-rawfile-md5")
    private final String authRawFileMd5;

    @SerializedName("date")
    private final String date;

    @SerializedName("description")
    private final String description;

    @SerializedName("model")
    private final String model;

    @SerializedName("version")
    private final String version;

    public AuthModelManifest() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ AuthModelManifest copy$default(AuthModelManifest r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.model;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.date;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.version;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.description;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.authModelFile;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.authModelVersion;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.authModelMd5;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.authKeyFile;
    L35:
        if ((r22 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r11.authKeyMd5;
    L39:
        if ((r22 & ISmModel.VERSION_0200) == 0) goto L41;
        String r1 = r11.authRawFileMd5;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.model;
    }

    public final String component10() {
        return this.authRawFileMd5;
    }

    public final String component2() {
        return this.date;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.authModelFile;
    }

    public final String component6() {
        return this.authModelVersion;
    }

    public final String component7() {
        return this.authModelMd5;
    }

    public final String component8() {
        return this.authKeyFile;
    }

    public final String component9() {
        return this.authKeyMd5;
    }

    public final AuthModelManifest copy(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        return new AuthModelManifest(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AuthModelManifest) == true) goto L8;
        return false;
    L8:
        AuthModelManifest r6 = (AuthModelManifest) r5;
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authModelFile, r6.authModelFile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.authModelVersion, r6.authModelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.authModelMd5, r6.authModelMd5) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.authKeyFile, r6.authKeyFile) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.authKeyMd5, r6.authKeyMd5) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.authRawFileMd5, r6.authRawFileMd5) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.model;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.date;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.version;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.description;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.authModelFile;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.authModelVersion;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.authModelMd5;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.authKeyFile;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.authKeyMd5;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.authRawFileMd5;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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
        return "AuthModelManifest(model=" + this.model + ", date=" + this.date + ", version=" + this.version + ", description=" + this.description + ", authModelFile=" + this.authModelFile + ", authModelVersion=" + this.authModelVersion + ", authModelMd5=" + this.authModelMd5 + ", authKeyFile=" + this.authKeyFile + ", authKeyMd5=" + this.authKeyMd5 + ", authRawFileMd5=" + this.authRawFileMd5 + ')';
    }

    public final String getAuthKeyFile() {
        return this.authKeyFile;
    }

    public final String getAuthKeyMd5() {
        return this.authKeyMd5;
    }

    public final String getAuthModelFile() {
        return this.authModelFile;
    }

    public final String getAuthModelMd5() {
        return this.authModelMd5;
    }

    public final String getAuthModelVersion() {
        return this.authModelVersion;
    }

    public final String getAuthRawFileMd5() {
        return this.authRawFileMd5;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getVersion() {
        return this.version;
    }

    public AuthModelManifest(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        this.model = r1;
        this.date = r2;
        this.version = r3;
        this.description = r4;
        this.authModelFile = r5;
        this.authModelVersion = r6;
        this.authModelMd5 = r7;
        this.authKeyFile = r8;
        this.authKeyMd5 = r9;
        this.authRawFileMd5 = r10;
    }

    public /* synthetic */ AuthModelManifest(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & ISmModel.VERSION_0200) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
