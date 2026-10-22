package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyResponse;", "Ljava/io/Serializable;", "proxyRequestId", "", "success", "", "responseBase64", "clientError", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;", "errorBase64", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;Ljava/lang/String;)V", "getProxyRequestId", "()Ljava/lang/String;", "getSuccess", "()Z", "getResponseBase64", "getClientError", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;", "getErrorBase64", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class WebProxyResponse implements Serializable {
    public static final a Companion = null;

    @SerializedName("clientError")
    private final WebProxyClientError clientError;

    @SerializedName("errorBase64")
    private final String errorBase64;

    @SerializedName("proxyRequestId")
    private final String proxyRequestId;

    @SerializedName("responseBase64")
    private final String responseBase64;

    @SerializedName("success")
    private final boolean success;

    public static final class a {
        public a() {
        }

        public static WebProxyResponse a(String r9, WebProxyClientError r10) {
            Intrinsics.checkNotNullParameter(r9, "proxyRequestId");
            Intrinsics.checkNotNullParameter(r10, "error");
            return new WebProxyResponse(r9, false, null, r10, null, 20, null);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ WebProxyResponse copy$default(WebProxyResponse r3, String r4, boolean r5, String r6, WebProxyClientError r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.proxyRequestId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.success;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.responseBase64;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.clientError;
    L14:
        WebProxyClientError r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.errorBase64;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.proxyRequestId;
    }

    public final boolean component2() {
        return this.success;
    }

    public final String component3() {
        return this.responseBase64;
    }

    public final WebProxyClientError component4() {
        return this.clientError;
    }

    public final String component5() {
        return this.errorBase64;
    }

    public final WebProxyResponse copy(String r8, boolean r9, String r10, WebProxyClientError r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "proxyRequestId");
        return new WebProxyResponse(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebProxyResponse) == true) goto L8;
        return false;
    L8:
        WebProxyResponse r6 = (WebProxyResponse) r5;
        if (Intrinsics.areEqual(this.proxyRequestId, r6.proxyRequestId) == true) goto L12;
        return false;
    L12:
        if (this.success == r6.success) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.responseBase64, r6.responseBase64) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clientError, r6.clientError) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.errorBase64, r6.errorBase64) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.proxyRequestId.hashCode() * 31;
        if (this.success == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.responseBase64;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        WebProxyClientError r7 = this.clientError;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.errorBase64;
        if (r10 == null) goto L19;
        r4 = r10.hashCode();
    L19:
        return r9 + r4;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "WebProxyResponse(proxyRequestId=" + this.proxyRequestId + ", success=" + this.success + ", responseBase64=" + this.responseBase64 + ", clientError=" + this.clientError + ", errorBase64=" + this.errorBase64 + ')';
    }

    public final WebProxyClientError getClientError() {
        return this.clientError;
    }

    public final String getErrorBase64() {
        return this.errorBase64;
    }

    public final String getProxyRequestId() {
        return this.proxyRequestId;
    }

    public final String getResponseBase64() {
        return this.responseBase64;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public WebProxyResponse(String r2, boolean r3, String r4, WebProxyClientError r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "proxyRequestId");
        this.proxyRequestId = r2;
        this.success = r3;
        this.responseBase64 = r4;
        this.clientError = r5;
        this.errorBase64 = r6;
    }

    public /* synthetic */ WebProxyResponse(String r8, boolean r9, String r10, WebProxyClientError r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        WebProxyClientError r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        String r6 = null;
    L14:
        this(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
