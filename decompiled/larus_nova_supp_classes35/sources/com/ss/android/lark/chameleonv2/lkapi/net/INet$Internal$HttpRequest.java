package com.ss.android.lark.chameleonv2.lkapi.net;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'Jv\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b\r\u0010'\"\u0004\b(\u0010)R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b0\u0010'¨\u0006A"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "url", BuildConfig.FLAVOR, "method", "Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;", "headers", BuildConfig.FLAVOR, "body", "Lcom/alibaba/fastjson/JSONObject;", "bodyString", "credentialsX", "requestTagUserTriggeredValue", "isUserTriggered", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;Ljava/util/Map;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getMethod", "()Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;", "setMethod", "(Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getBody", "()Lcom/alibaba/fastjson/JSONObject;", "setBody", "(Lcom/alibaba/fastjson/JSONObject;)V", "getBodyString", "setBodyString", "getCredentialsX", "setCredentialsX", "getRequestTagUserTriggeredValue", "setRequestTagUserTriggeredValue", "()Ljava/lang/Boolean;", "setUserTriggered", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "credentials", "Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$Credentials;", "getCredentials", "()Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$Credentials;", "requestTagUserTriggered", "getRequestTagUserTriggered", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpMethod;Ljava/util/Map;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpRequest;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class INet$Internal$HttpRequest implements NonProguard {
    private JSONObject body;
    private String bodyString;
    private String credentialsX;
    private Map<String, String> headers;
    private Boolean isUserTriggered;
    private INet$Internal$HttpMethod method;
    private String requestTagUserTriggeredValue;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ INet$Internal$HttpRequest copy$default(INet$Internal$HttpRequest r9, String r10, INet$Internal$HttpMethod r11, Map r12, JSONObject r13, String r14, String r15, String r16, Boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.url;
    L7:
        if ((r18 & 2) == 0) goto L9;
        INet$Internal$HttpMethod r3 = r9.method;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Map r4 = r9.headers;
    L15:
        if ((r18 & 8) == 0) goto L17;
        JSONObject r5 = r9.body;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.bodyString;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.credentialsX;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.requestTagUserTriggeredValue;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Boolean r1 = r9.isUserTriggered;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.url;
    }

    public final INet$Internal$HttpMethod component2() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final JSONObject component4() {
        return this.body;
    }

    public final String component5() {
        return this.bodyString;
    }

    public final String component6() {
        return this.credentialsX;
    }

    public final String component7() {
        return this.requestTagUserTriggeredValue;
    }

    public final Boolean component8() {
        return this.isUserTriggered;
    }

    public final INet$Internal$HttpRequest copy(String r11, INet$Internal$HttpMethod r12, Map<String, String> r13, JSONObject r14, String r15, @JSONField(name = "credentials") String r16, @JSONField(name = "t") String r17, Boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "method");
        return new INet$Internal$HttpRequest(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof INet$Internal$HttpRequest) == true) goto L8;
        return false;
    L8:
        INet$Internal$HttpRequest r6 = (INet$Internal$HttpRequest) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (this.method == r6.method) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headers, r6.headers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.body, r6.body) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bodyString, r6.bodyString) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.credentialsX, r6.credentialsX) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.requestTagUserTriggeredValue, r6.requestTagUserTriggeredValue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isUserTriggered, r6.isUserTriggered) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.url.hashCode() * 31) + this.method.hashCode()) * 31;
        Map<String, String> r1 = this.headers;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        JSONObject r5 = this.body;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.bodyString;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.credentialsX;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.requestTagUserTriggeredValue;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.isUserTriggered;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "HttpRequest(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ", bodyString=" + this.bodyString + ", credentialsX=" + this.credentialsX + ", requestTagUserTriggeredValue=" + this.requestTagUserTriggeredValue + ", isUserTriggered=" + this.isUserTriggered + ')';
    }

    public final INet$Internal$Credentials getCredentials() {
        INet$Internal$Credentials.a r0 = INet$Internal$Credentials.Companion;
        String r1 = this.credentialsX;
        r0.getClass();
        INet$Internal$Credentials[] r2 = INet$Internal$Credentials.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        INet$Internal$Credentials r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r1) == true) goto L9;
        r4 = r4 + 1;
    L9:
        if (r5 == null) goto L12;
        return r5;
    L12:
        return INet$Internal$Credentials.Omit;
    L8:
        r5 = null;
        goto L9
    }

    public final Boolean getRequestTagUserTriggered() {
        Boolean r0 = this.isUserTriggered;
        if (r0 != null) goto L12;
        String r1 = this.requestTagUserTriggeredValue;
        if (Intrinsics.areEqual(r1, "1") == false) goto L8;
        return Boolean.TRUE;
    L8:
        if (Intrinsics.areEqual(r1, DocTabPayload.DocType.UNKNOWN) == true) goto L14;
        return null;
    L14:
        return Boolean.FALSE;
    L12:
        return r0;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final String getBodyString() {
        return this.bodyString;
    }

    public final String getCredentialsX() {
        return this.credentialsX;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final INet$Internal$HttpMethod getMethod() {
        return this.method;
    }

    public final String getRequestTagUserTriggeredValue() {
        return this.requestTagUserTriggeredValue;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean isUserTriggered() {
        return this.isUserTriggered;
    }

    public final void setBody(JSONObject r1) {
        this.body = r1;
    }

    public final void setBodyString(String r1) {
        this.bodyString = r1;
    }

    public final void setCredentialsX(String r1) {
        this.credentialsX = r1;
    }

    public final void setHeaders(Map<String, String> r1) {
        this.headers = r1;
    }

    public final void setMethod(INet$Internal$HttpMethod r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.method = r2;
    }

    public final void setRequestTagUserTriggeredValue(String r1) {
        this.requestTagUserTriggeredValue = r1;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    public final void setUserTriggered(Boolean r1) {
        this.isUserTriggered = r1;
    }

    public INet$Internal$HttpRequest(String r2, INet$Internal$HttpMethod r3, Map<String, String> r4, JSONObject r5, String r6, @JSONField(name = "credentials") String r7, @JSONField(name = "t") String r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.url = r2;
        this.method = r3;
        this.headers = r4;
        this.body = r5;
        this.bodyString = r6;
        this.credentialsX = r7;
        this.requestTagUserTriggeredValue = r8;
        this.isUserTriggered = r9;
    }
}
