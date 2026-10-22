package com.ss.android.lark.passport.signinsdk_api.base;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0005J\b\u0010$\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;", "Ljava/io/Serializable;", "rawErrorCode", "", "errorMessage", "", "bizCode", "debugErrorMessage", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getRawErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getBizCode", "setBizCode", "(I)V", "getDebugErrorMessage", "setDebugErrorMessage", "errorCode", "getErrorCode", "setErrorCode", "httpCode", "getHttpCode", "setHttpCode", "throwable", "", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "httpStatusCode", "errorMsg", "debugMsg", "toString", "Companion", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class NetworkErrorResult implements Serializable {
    public static final int CODE_BIZ = -7;
    public static final int CODE_QRCODE_ERROR_ALERT = -8;
    public static final a Companion = null;
    public static final int NETWORK_TIME_OUT = -6;
    public static final int UNKNOWN_BIZ_CODE = -9999;
    public static final int UNKNOWN_ERROR_CODE = -1;
    private int bizCode;
    private String debugErrorMessage;
    private int errorCode;
    private String errorMessage;
    private int httpCode;
    private final int rawErrorCode;
    private Throwable throwable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NetworkErrorResult(int r8, String r9) {
        this(r8, r9, 0, null, 12, null);
    }

    public NetworkErrorResult(int r8, String r9, int r10) {
        this(r8, r9, r10, null, 8, null);
    }

    public String toString() {
        return "mErrorCode= " + this.errorCode + ", rawCode= " + this.rawErrorCode + ", mBizCode= " + this.bizCode + ", mErrorMessage= " + this.errorMessage + ", mDebugErrorMessage= " + this.debugErrorMessage + ", httpCode= " + this.httpCode;
    }

    public final int getBizCode() {
        return this.bizCode;
    }

    public final String getDebugErrorMessage() {
        return this.debugErrorMessage;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    public final int getRawErrorCode() {
        return this.rawErrorCode;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final NetworkErrorResult bizCode(int r1) {
        this.bizCode = r1;
        return this;
    }

    public final NetworkErrorResult debugMsg(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.debugErrorMessage = r1;
        return this;
    }

    public final NetworkErrorResult errorCode(int r1) {
        this.errorCode = r1;
        return this;
    }

    public final NetworkErrorResult errorMsg(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.errorMessage = r1;
        return this;
    }

    public final NetworkErrorResult httpCode(int r1) {
        this.httpCode = r1;
        return this;
    }

    public final void setBizCode(int r1) {
        this.bizCode = r1;
    }

    public final void setDebugErrorMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.debugErrorMessage = r2;
    }

    public final void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public final void setErrorMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.errorMessage = r2;
    }

    public final void setHttpCode(int r1) {
        this.httpCode = r1;
    }

    public final void setThrowable(Throwable r1) {
        this.throwable = r1;
    }

    public NetworkErrorResult(int r2, String r3, int r4, String r5) {
        this.httpCode = -1;
        this.rawErrorCode = r2;
        this.errorCode = r2;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.errorMessage = r3;
        this.bizCode = r4;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        this.debugErrorMessage = r5;
    }

    public /* synthetic */ NetworkErrorResult(int r1, String r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = UNKNOWN_BIZ_CODE;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = r2;
    L8:
        this(r1, r2, r3, r4);
    }
}
