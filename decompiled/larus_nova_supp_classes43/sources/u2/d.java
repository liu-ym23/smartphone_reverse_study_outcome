package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/ai/applet/granting/FirstPartyLoginData;", "", "authLink", "", "bizLoginDescription", "awemeLoginDescription", "awemeLoginCommonPrivacyURL", "requestId", "timeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAuthLink", "()Ljava/lang/String;", "getBizLoginDescription", "getAwemeLoginDescription", "getAwemeLoginCommonPrivacyURL", "getRequestId", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/applet/granting/FirstPartyLoginData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("authLink")
    private final String authLink;

    @SerializedName("awemeLoginCommonPrivacyURL")
    private final String awemeLoginCommonPrivacyURL;

    @SerializedName("awemeLoginDescription")
    private final String awemeLoginDescription;

    @SerializedName("bizLoginDescription")
    private final String bizLoginDescription;

    @SerializedName("requestId")
    private final String requestId;

    @SerializedName("timeout")
    private final Integer timeout;

    public d() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.authLink, r11.authLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizLoginDescription, r11.bizLoginDescription) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.awemeLoginDescription, r11.awemeLoginDescription) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.awemeLoginCommonPrivacyURL, r11.awemeLoginCommonPrivacyURL) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestId, r11.requestId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.timeout, r11.timeout) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.authLink;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.bizLoginDescription;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.awemeLoginDescription;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.awemeLoginCommonPrivacyURL;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.requestId;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        Integer r24 = this.timeout;
        if (r24 == null) goto L27;
        r1 = r24.hashCode();
    L27:
        return r23 + r1;
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
        return "FirstPartyLoginData(authLink=" + this.authLink + ", bizLoginDescription=" + this.bizLoginDescription + ", awemeLoginDescription=" + this.awemeLoginDescription + ", awemeLoginCommonPrivacyURL=" + this.awemeLoginCommonPrivacyURL + ", requestId=" + this.requestId + ", timeout=" + this.timeout + ')';
    }

    public final String b() {
        return this.authLink;
    }

    public final String c() {
        return this.awemeLoginCommonPrivacyURL;
    }

    public final String d() {
        return this.awemeLoginDescription;
    }

    public final String e() {
        return this.bizLoginDescription;
    }

    public final Integer f() {
        return this.timeout;
    }

    public d(String r1, String r10, String r11, String r12, String r13, Integer r14) {
        this.authLink = r1;
        this.bizLoginDescription = r10;
        this.awemeLoginDescription = r11;
        this.awemeLoginCommonPrivacyURL = r12;
        this.requestId = r13;
        this.timeout = r14;
    }

    public static d a(d r10, String r11, String r12, String r13, String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r11 = r10.authLink;
    L5:
        String r1 = r11;
        if ((r15 & 2) == 0) goto L8;
        r12 = r10.bizLoginDescription;
    L8:
        String r16 = r12;
        if ((r15 & 4) == 0) goto L11;
        r13 = r10.awemeLoginDescription;
    L11:
        String r17 = r13;
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.awemeLoginCommonPrivacyURL;
    L14:
        String r18 = r14;
        if ((r15 & 16) == 0) goto L17;
        String r19 = r10.requestId;
    L19:
        if ((r15 & 32) == 0) goto L21;
        Integer r20 = r10.timeout;
    L22:
        r10.getClass();
        return new d(r1, r16, r17, r18, r19, r20);
    L21:
        r20 = null;
        goto L22
    L17:
        r19 = null;
        goto L19
    }
}
