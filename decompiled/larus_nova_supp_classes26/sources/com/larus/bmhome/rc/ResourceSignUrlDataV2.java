package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0007\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/larus/bmhome/rc/ResourceSignUrlDataV2;", "", "statusCode", "", "message", "", "mainUrl", "isEncrypted", "", "decryptionKey", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getMainUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDecryptionKey", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/bmhome/rc/ResourceSignUrlDataV2;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceSignUrlDataV2 {

    @SerializedName("decryption_key")
    private final String decryptionKey;

    @SerializedName("is_encrypted")
    private final Boolean isEncrypted;

    @SerializedName("main_url")
    private final String mainUrl;

    @SerializedName("message")
    private final String message;

    @SerializedName("status_code")
    private final Integer statusCode;

    public ResourceSignUrlDataV2() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResourceSignUrlDataV2 copy$default(ResourceSignUrlDataV2 r3, Integer r4, String r5, String r6, Boolean r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.statusCode;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.message;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.mainUrl;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isEncrypted;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.decryptionKey;
    L17:
        Integer r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.mainUrl;
    }

    public final Boolean component4() {
        return this.isEncrypted;
    }

    public final String component5() {
        return this.decryptionKey;
    }

    public final ResourceSignUrlDataV2 copy(Integer r8, String r9, String r10, Boolean r11, String r12) {
        return new ResourceSignUrlDataV2(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceSignUrlDataV2) == true) goto L8;
        return false;
    L8:
        ResourceSignUrlDataV2 r6 = (ResourceSignUrlDataV2) r5;
        if (Intrinsics.areEqual(this.statusCode, r6.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainUrl, r6.mainUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isEncrypted, r6.isEncrypted) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.decryptionKey, r6.decryptionKey) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.statusCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mainUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isEncrypted;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.decryptionKey;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "ResourceSignUrlDataV2(statusCode=" + this.statusCode + ", message=" + this.message + ", mainUrl=" + this.mainUrl + ", isEncrypted=" + this.isEncrypted + ", decryptionKey=" + this.decryptionKey + ')';
    }

    public final String getDecryptionKey() {
        return this.decryptionKey;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final Boolean isEncrypted() {
        return this.isEncrypted;
    }

    public ResourceSignUrlDataV2(Integer r1, String r2, String r3, Boolean r4, String r5) {
        this.statusCode = r1;
        this.message = r2;
        this.mainUrl = r3;
        this.isEncrypted = r4;
        this.decryptionKey = r5;
    }

    public /* synthetic */ ResourceSignUrlDataV2(Integer r4, String r5, String r6, Boolean r7, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 0;
    L5:
        String r0 = null;
        if ((r9 & 2) == 0) goto L8;
        String r11 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        String r1 = null;
    L14:
        if ((r9 & 8) == 0) goto L16;
        r7 = Boolean.FALSE;
    L16:
        Boolean r2 = r7;
        if ((r9 & 16) != 0) goto L20;
        r0 = r8;
    L20:
        this(r4, r11, r1, r2, r0);
        return;
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
