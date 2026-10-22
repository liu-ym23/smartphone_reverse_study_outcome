package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptCryptoRequest;", "", "suite", "", "clientPub", "salt", "nonce", "ts", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getSuite", "()Ljava/lang/String;", "getClientPub", "getSalt", "getNonce", "getTs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformDekDecryptCryptoRequest {

    @SerializedName("client_pub")
    private final String clientPub;
    private final String nonce;
    private final String salt;
    private final String suite;
    private final long ts;

    public OpenPlatformDekDecryptCryptoRequest() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ OpenPlatformDekDecryptCryptoRequest copy$default(OpenPlatformDekDecryptCryptoRequest r10, String r11, String r12, String r13, String r14, long r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.suite;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.clientPub;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.salt;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.nonce;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.ts;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.suite;
    }

    public final String component2() {
        return this.clientPub;
    }

    public final String component3() {
        return this.salt;
    }

    public final String component4() {
        return this.nonce;
    }

    public final long component5() {
        return this.ts;
    }

    public final OpenPlatformDekDecryptCryptoRequest copy(String r10, String r11, String r12, String r13, long r14) {
        return new OpenPlatformDekDecryptCryptoRequest(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformDekDecryptCryptoRequest) == true) goto L8;
        return false;
    L8:
        OpenPlatformDekDecryptCryptoRequest r11 = (OpenPlatformDekDecryptCryptoRequest) r10;
        if (Intrinsics.areEqual(this.suite, r11.suite) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clientPub, r11.clientPub) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.salt, r11.salt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nonce, r11.nonce) == true) goto L21;
        return false;
    L21:
        if (this.ts == r11.ts) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.suite;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.clientPub;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.salt;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.nonce;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        int r19 = (r17 + r1) * 31;
        long r20 = this.ts;
        return r19 + ((int) (r20 ^ (r20 >>> 32)));
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformDekDecryptCryptoRequest(suite=" + this.suite + ", clientPub=" + this.clientPub + ", salt=" + this.salt + ", nonce=" + this.nonce + ", ts=" + this.ts + ')';
    }

    public final String getClientPub() {
        return this.clientPub;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getSalt() {
        return this.salt;
    }

    public final String getSuite() {
        return this.suite;
    }

    public final long getTs() {
        return this.ts;
    }

    public OpenPlatformDekDecryptCryptoRequest(String r1, String r10, String r11, String r12, long r13) {
        this.suite = r1;
        this.clientPub = r10;
        this.salt = r11;
        this.nonce = r12;
        this.ts = r13;
    }

    public /* synthetic */ OpenPlatformDekDecryptCryptoRequest(String r10, String r11, String r12, String r13, long r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = "ECDH_P256_HKDF_SHA256_AES_256_GCM";
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = null;
    L8:
        String r17 = r11;
        String r0 = "";
        if ((r15 & 4) == 0) goto L11;
        String r1 = "";
    L13:
        if ((r15 & 8) != 0) goto L17;
        r0 = r13;
    L17:
        if ((r15 & 16) == 0) goto L19;
        r14 = 0;
    L19:
        long r18 = r14;
        this(r10, r17, r1, r0, r18);
        return;
    L11:
        r1 = r12;
        goto L13
    }
}
