package com.bytedance.ai.applet.login;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0003R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/applet/login/d;", "", "", "a", "Ljava/lang/String;", "getMiniAppDescription", "()Ljava/lang/String;", "miniAppDescription", "b", "miniAppIcon", "c", "miniAppID", "d", "miniAppName", "e", "miniAppVersion", "", "f", "I", "()I", "loginType", "g", "getRequestId", Constant.REQUEST_ID, "Lcom/bytedance/ai/applet/login/d$a;", "h", "Lcom/bytedance/ai/applet/login/d$a;", "getPrivacyInfo", "()Lcom/bytedance/ai/applet/login/d$a;", "privacyInfo", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("doubaoMiniAppDescription")
    private final String f1739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("doubaoMiniAppIcon")
    private final String f1740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("doubaoMiniAppKey")
    private final String f1741c;

    @SerializedName("doubaoMiniAppName")
    private final String d;

    @SerializedName("doubaoMiniAppVersion")
    private final String e;

    @SerializedName("loginType")
    private final int f;

    @SerializedName(Constant.REQUEST_ID)
    private final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("privacyInfo")
    private final a f1742h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/applet/login/d$a;", "", "", "a", "Ljava/lang/String;", "getPrivacyContent", "()Ljava/lang/String;", "privacyContent", "b", "getPrivacyURL", "privacyURL", "c", "getTermsOfServiceURL", "termsOfServiceURL", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("privacyContent")
        private final String f1743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("privacyURL")
        private final String f1744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("termsOfServiceURL")
        private final String f1745c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r10 = (a) r5;
            if (Intrinsics.areEqual(this.f1743a, r10.f1743a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1744b, r10.f1744b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f1745c, r10.f1745c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r5 = this.f1743a.hashCode() * 31;
            int r10 = kk.a.b(this.f1744b, r5, 31);
            return this.f1745c.hashCode() + r10;
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("PrivacyInfo(privacyContent=");
            r5.append(this.f1743a);
            r5.append(", privacyURL=");
            r5.append(this.f1744b);
            r5.append(", termsOfServiceURL=");
            return j0.p(r5, this.f1745c, ')');
        }
    }

    public final String a() {
        return this.f1741c;
    }

    public final String b() {
        return this.f1740b;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        if (Intrinsics.areEqual(this.f1739a, r10.f1739a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1740b, r10.f1740b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f1741c, r10.f1741c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f1742h, r10.f1742h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f1739a.hashCode() * 31;
        int r10 = kk.a.b(this.f1740b, r5, 31);
        int r11 = kk.a.b(this.f1741c, r10, 31);
        int r12 = kk.a.b(this.d, r11, 31);
        int r13 = kk.a.b(this.e, r12, 31);
        int r14 = k5.d.a(this.f, r13);
        int r15 = kk.a.b(this.g, r14, 31);
        return this.f1742h.hashCode() + r15;
    }

    public final String toString() {
        return "LoginData(miniAppDescription=" + this.f1739a + ", miniAppIcon=" + this.f1740b + ", miniAppID=" + this.f1741c + ", miniAppName=" + this.d + ", miniAppVersion=" + this.e + ", loginType=" + this.f + ", requestId=" + this.g + ", privacyInfo=" + this.f1742h + ')';
    }
}
