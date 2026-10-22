package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyClientError;", "Ljava/io/Serializable;", "code", "", "errorMsg", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class WebProxyClientError implements Serializable {
    public static final a Companion = null;

    @SerializedName("code")
    private final int code;

    @SerializedName("errorMsg")
    private final String errorMsg;

    public static final class a {
        public a() {
        }

        public static WebProxyClientError a(WebProxyErrorCode r2) {
            Intrinsics.checkNotNullParameter(r2, "errorCode");
            return new WebProxyClientError(r2.getValue(), r2.getMessage());
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ WebProxyClientError copy$default(WebProxyClientError r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.errorMsg;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final WebProxyClientError copy(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        return new WebProxyClientError(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebProxyClientError) == true) goto L8;
        return false;
    L8:
        WebProxyClientError r6 = (WebProxyClientError) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.code * 31) + this.errorMsg.hashCode();
    }

    public String toString() {
        return "WebProxyClientError(code=" + this.code + ", errorMsg=" + this.errorMsg + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public WebProxyClientError(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        this.code = r2;
        this.errorMsg = r3;
    }
}
