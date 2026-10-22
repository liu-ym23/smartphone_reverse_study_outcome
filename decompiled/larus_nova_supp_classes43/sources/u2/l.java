package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/ai/applet/granting/QSMusicLoginData;", "", "authLink", "", "title", "subTitle", "refuseText", "buttonLogin", "buttonRefuse", "requestId", "timeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAuthLink", "()Ljava/lang/String;", "getTitle", "getSubTitle", "getRefuseText", "getButtonLogin", "getButtonRefuse", "getRequestId", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/applet/granting/QSMusicLoginData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("authLink")
    private final String authLink;

    @SerializedName("buttonLogin")
    private final String buttonLogin;

    @SerializedName("buttonRefuse")
    private final String buttonRefuse;

    @SerializedName("refuseText")
    private final String refuseText;

    @SerializedName("requestId")
    private final String requestId;

    @SerializedName("subTitle")
    private final String subTitle;

    @SerializedName("timeout")
    private final Integer timeout;

    @SerializedName("title")
    private final String title;

    public l() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof l) == true) goto L8;
        return false;
    L8:
        l r11 = (l) r10;
        if (Intrinsics.areEqual(this.authLink, r11.authLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r11.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subTitle, r11.subTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.refuseText, r11.refuseText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonLogin, r11.buttonLogin) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonRefuse, r11.buttonRefuse) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.requestId, r11.requestId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.timeout, r11.timeout) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.authLink;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.title;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.subTitle;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.refuseText;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.buttonLogin;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.buttonRefuse;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.requestId;
        if (r27 != null) goto L29;
        int r28 = 0;
    L30:
        int r29 = (r26 + r28) * 31;
        Integer r30 = this.timeout;
        if (r30 == null) goto L35;
        r1 = r30.hashCode();
    L35:
        return r29 + r1;
    L29:
        r28 = r27.hashCode();
        goto L30
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
        return "QSMusicLoginData(authLink=" + this.authLink + ", title=" + this.title + ", subTitle=" + this.subTitle + ", refuseText=" + this.refuseText + ", buttonLogin=" + this.buttonLogin + ", buttonRefuse=" + this.buttonRefuse + ", requestId=" + this.requestId + ", timeout=" + this.timeout + ')';
    }

    public final String b() {
        return this.authLink;
    }

    public final String c() {
        return this.buttonLogin;
    }

    public final String d() {
        return this.buttonRefuse;
    }

    public final String e() {
        return this.refuseText;
    }

    public final String f() {
        return this.subTitle;
    }

    public final String g() {
        return this.title;
    }

    public l(String r1, String r10, String r11, String r12, String r13, String r14, String r15, Integer r16) {
        this.authLink = r1;
        this.title = r10;
        this.subTitle = r11;
        this.refuseText = r12;
        this.buttonLogin = r13;
        this.buttonRefuse = r14;
        this.requestId = r15;
        this.timeout = r16;
    }

    public static l a(l r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        String r10 = r12.authLink;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r11 = r12.title;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r20 = r12.subTitle;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r21 = r12.refuseText;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r22 = r12.buttonLogin;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r23 = r12.buttonRefuse;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r110 = r12.requestId;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Integer r111 = r12.timeout;
    L34:
        r12.getClass();
        return new l(r10, r11, r20, r21, r22, r23, r110, r111);
    L33:
        r111 = null;
        goto L34
    L29:
        r110 = null;
        goto L31
    L25:
        r23 = r18;
        goto L27
    L21:
        r22 = r17;
        goto L23
    L17:
        r21 = r16;
        goto L19
    L13:
        r20 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }
}
