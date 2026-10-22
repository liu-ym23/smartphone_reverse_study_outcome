package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.common.spi.security.ObricSecurityServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/rc/ResourceUploadAuthToken;", "", "accessKey", "", "secretKey", "sessionToken", "expiredTime", "currentTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getSecretKey", "getSessionToken", "getExpiredTime", "getCurrentTime", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceUploadAuthToken {

    @SerializedName("access_key")
    private final String accessKey;

    @SerializedName("current_time")
    private final String currentTime;

    @SerializedName("expired_time")
    private final String expiredTime;

    @SerializedName("secret_key")
    private final String secretKey;

    @SerializedName("session_token")
    private final String sessionToken;

    public ResourceUploadAuthToken() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResourceUploadAuthToken copy$default(ResourceUploadAuthToken r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.accessKey;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.secretKey;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.sessionToken;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.expiredTime;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.currentTime;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.accessKey;
    }

    public final String component2() {
        return this.secretKey;
    }

    public final String component3() {
        return this.sessionToken;
    }

    public final String component4() {
        return this.expiredTime;
    }

    public final String component5() {
        return this.currentTime;
    }

    public final ResourceUploadAuthToken copy(String r8, String r9, String r10, String r11, String r12) {
        return new ResourceUploadAuthToken(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceUploadAuthToken) == true) goto L8;
        return false;
    L8:
        ResourceUploadAuthToken r6 = (ResourceUploadAuthToken) r5;
        if (Intrinsics.areEqual(this.accessKey, r6.accessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secretKey, r6.secretKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sessionToken, r6.sessionToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expiredTime, r6.expiredTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentTime, r6.currentTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.accessKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.secretKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sessionToken;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.expiredTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.currentTime;
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
        StringBuilder r0 = new StringBuilder("ResourceUploadAuthToken(accessKey=");
        ObricSecurityServiceDelegate r1 = ObricSecurityServiceDelegate.b;
        r0.append(r1.a(this.accessKey));
        r0.append(", secretKey=");
        r0.append(r1.a(this.secretKey));
        r0.append(", sessionToken=");
        r0.append(r1.a(this.sessionToken));
        r0.append(", expiredTime=");
        r0.append(this.expiredTime);
        r0.append(", currentTime=");
        r0.append(this.currentTime);
        r0.append(')');
        return r0.toString();
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }

    public final String getExpiredTime() {
        return this.expiredTime;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public ResourceUploadAuthToken(String r1, String r2, String r3, String r4, String r5) {
        this.accessKey = r1;
        this.secretKey = r2;
        this.sessionToken = r3;
        this.expiredTime = r4;
        this.currentTime = r5;
    }

    public /* synthetic */ ResourceUploadAuthToken(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
