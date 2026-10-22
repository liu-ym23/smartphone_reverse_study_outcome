package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import android.util.Base64;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyRequest;", "Ljava/io/Serializable;", "proxyRequestId", "", "command", "", "requestBase64", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getProxyRequestId", "()Ljava/lang/String;", "getCommand", "()I", "getRequestBase64", "decodeRequest", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class WebProxyRequest implements Serializable {

    @SerializedName("command")
    private final int command;

    @SerializedName("proxyRequestId")
    private final String proxyRequestId;

    @SerializedName("requestBase64")
    private final String requestBase64;

    public static /* synthetic */ WebProxyRequest copy$default(WebProxyRequest r0, String r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.proxyRequestId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.command;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.requestBase64;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.proxyRequestId;
    }

    public final int component2() {
        return this.command;
    }

    public final String component3() {
        return this.requestBase64;
    }

    public final WebProxyRequest copy(String r2, int r3, String r4) {
        return new WebProxyRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebProxyRequest) == true) goto L8;
        return false;
    L8:
        WebProxyRequest r6 = (WebProxyRequest) r5;
        if (Intrinsics.areEqual(this.proxyRequestId, r6.proxyRequestId) == true) goto L12;
        return false;
    L12:
        if (this.command == r6.command) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestBase64, r6.requestBase64) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.proxyRequestId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.command) * 31;
        String r4 = this.requestBase64;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "WebProxyRequest(proxyRequestId=" + this.proxyRequestId + ", command=" + this.command + ", requestBase64=" + this.requestBase64 + ')';
    }

    public final byte[] decodeRequest() {
        String r0 = this.requestBase64;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return Base64.decode(r0, 2);
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getProxyRequestId() {
        return this.proxyRequestId;
    }

    public final String getRequestBase64() {
        return this.requestBase64;
    }

    public WebProxyRequest(String r1, int r2, String r3) {
        this.proxyRequestId = r1;
        this.command = r2;
        this.requestBase64 = r3;
    }
}
