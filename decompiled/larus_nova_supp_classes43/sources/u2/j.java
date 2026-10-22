package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bytedance/ai/applet/granting/LocalLoginData;", "", "privacyURL", "", "termsOfServiceURL", "privacyContent", "mobileMask", "loginDescription", "requestId", "timeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getPrivacyURL", "()Ljava/lang/String;", "getTermsOfServiceURL", "getPrivacyContent", "getMobileMask", "getLoginDescription", "getRequestId", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/applet/granting/LocalLoginData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("bizLoginDescription")
    private final String loginDescription;

    @SerializedName("mobileMask")
    private final String mobileMask;

    @SerializedName("bizPrivacyContent")
    private final String privacyContent;

    @SerializedName("privacyURL")
    private final String privacyURL;

    @SerializedName("requestId")
    private final String requestId;

    @SerializedName("termsOfServiceURL")
    private final String termsOfServiceURL;

    @SerializedName("timeout")
    private final Integer timeout;

    public j() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (Intrinsics.areEqual(this.privacyURL, r11.privacyURL) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.termsOfServiceURL, r11.termsOfServiceURL) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.privacyContent, r11.privacyContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobileMask, r11.mobileMask) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.loginDescription, r11.loginDescription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestId, r11.requestId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeout, r11.timeout) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.privacyURL;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.termsOfServiceURL;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.privacyContent;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.mobileMask;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.loginDescription;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.requestId;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.timeout;
        if (r27 == null) goto L31;
        r1 = r27.hashCode();
    L31:
        return r26 + r1;
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
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

    public final String toString() {
        return "LocalLoginData(privacyURL=" + this.privacyURL + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyContent=" + this.privacyContent + ", mobileMask=" + this.mobileMask + ", loginDescription=" + this.loginDescription + ", requestId=" + this.requestId + ", timeout=" + this.timeout + ')';
    }

    public final String b() {
        return this.loginDescription;
    }

    public final String c() {
        return this.mobileMask;
    }

    public final String d() {
        return this.privacyContent;
    }

    public final String e() {
        return this.privacyURL;
    }

    public final String f() {
        return this.termsOfServiceURL;
    }

    public j(String r1, String r10, String r11, String r12, String r13, String r14, Integer r15) {
        this.privacyURL = r1;
        this.termsOfServiceURL = r10;
        this.privacyContent = r11;
        this.mobileMask = r12;
        this.loginDescription = r13;
        this.requestId = r14;
        this.timeout = r15;
    }

    public static j a(j r10, String r11, String r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        r11 = r10.privacyURL;
    L5:
        String r1 = r11;
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.termsOfServiceURL;
    L8:
        String r17 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.privacyContent;
    L11:
        String r18 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.mobileMask;
    L14:
        String r19 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.loginDescription;
    L17:
        String r20 = r15;
        if ((r16 & 32) == 0) goto L20;
        String r21 = r10.requestId;
    L22:
        if ((r16 & 64) == 0) goto L24;
        Integer r22 = r10.timeout;
    L25:
        r10.getClass();
        return new j(r1, r17, r18, r19, r20, r21, r22);
    L24:
        r22 = null;
        goto L25
    L20:
        r21 = null;
        goto L22
    }
}
