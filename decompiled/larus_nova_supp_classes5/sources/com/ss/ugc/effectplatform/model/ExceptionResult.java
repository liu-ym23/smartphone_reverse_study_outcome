package com.ss.ugc.effectplatform.model;

import bytekn.foundation.io.file.IOException;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.exception.JsonException;
import com.ss.ugc.effectplatform.exception.MD5Exception;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.StatusCodeException;
import com.ss.ugc.effectplatform.exception.UnzipException;
import com.ss.ugc.effectplatform.exception.UrlNotExistException;
import com.ss.ugc.effectplatform.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\tB;\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001a\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J\u0016\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J$\u0010\u001d\u001a\u00020\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\bR\u0016\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ExceptionResult;", "", "errorCode", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ILjava/lang/Exception;)V", "(I)V", "(Ljava/lang/Exception;)V", "requestUrl", "", "selectedHost", "remoteIp", "(Ljava/lang/Exception;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "logId", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "msg", "getMsg", "setMsg", "getException", "setException", "", "setTrackParams", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class ExceptionResult {
    private int errorCode;
    private Exception exception;
    private String logId;
    private String msg;
    private String remoteIp;
    private String requestUrl;
    private String selectedHost;

    public String toString() {
        if (this.exception == null) goto L9;
        StringBuilder r0 = new StringBuilder("ExceptionResult{errorCode=");
        r0.append(this.errorCode);
        r0.append(", msg='");
        r0.append(this.msg);
        r0.append("', requestUrl='");
        r0.append(this.requestUrl);
        r0.append("', selectedHost='");
        r0.append(this.selectedHost);
        r0.append("', remoteIp='");
        r0.append(this.remoteIp);
        r0.append("', exception=");
        Exception r1 = this.exception;
        if (r1 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r0.append(r1.getMessage());
        r0.append('}');
        return r0.toString();
    L9:
        return "ExceptionResult{errorCode=" + this.errorCode + ", msg='" + this.msg + ", requestUrl='" + this.requestUrl + "', selectedHost='" + this.selectedHost + "', remoteIp='" + this.remoteIp + "'}";
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ExceptionResult(int r1) {
        this.errorCode = r1;
        this.msg = i.a(r1);
        this.exception = null;
    }

    public final void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public final void setException(Exception r1) {
        this.exception = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public final void setMsg(String r1) {
        this.msg = r1;
    }

    public ExceptionResult(Exception r2) {
        this(r2, null, null, null);
    }

    public ExceptionResult(int r1, Exception r2) {
        this.errorCode = r1;
        this.msg = i.a(r1);
        this.exception = r2;
    }

    public final void setTrackParams(String r1, String r2, String r3) {
        this.requestUrl = r1;
        this.selectedHost = r2;
        this.remoteIp = r3;
    }

    public ExceptionResult(Exception r2, String r3, String r4, String r5) {
        this.errorCode = -1;
        this.requestUrl = r3;
        this.selectedHost = r4;
        this.remoteIp = r5;
        this.exception = r2;
        if ((r2 instanceof NetException) == false) goto L6;
        this.errorCode = ((NetException) r2).getStatus_code();
        this.msg = r2.getMessage();
        return;
    L6:
        if ((r2 instanceof StatusCodeException) == false) goto L9;
        this.errorCode = ((StatusCodeException) r2).getStatusCode();
        this.msg = r2.getMessage();
        return;
    L9:
        if ((r2 instanceof JsonException) == false) goto L12;
        this.errorCode = 10008;
        this.msg = r2.getMessage();
        return;
    L12:
        if ((r2 instanceof UrlNotExistException) == false) goto L15;
        this.errorCode = 10015;
        this.msg = r2.getMessage();
        return;
    L15:
        if ((r2 instanceof UnzipException) == false) goto L18;
        this.errorCode = 10013;
        this.msg = r2.getMessage();
        return;
    L18:
        if ((r2 instanceof MD5Exception) == false) goto L21;
        this.errorCode = 10010;
        this.msg = r2.getMessage();
        return;
    L21:
        if ((r2 instanceof IOException) == false) goto L24;
        this.errorCode = 10012;
        this.msg = r2.getMessage();
        return;
    L24:
        if ((r2 instanceof CurrentEditingException) == false) goto L26;
        this.errorCode = 10021;
        this.msg = r2.getMessage();
        return;
    L26:
        boolean r6 = true;
        if (r2 != null) goto L29;
        this.errorCode = 1;
        this.msg = i.a(1);
        return;
    L29:
        if (Intrinsics.areEqual("network unavailable", r2.getMessage()) == false) goto L31;
        int r7 = 10011;
    L32:
        this.errorCode = r7;
        String r8 = r2.getMessage();
        this.msg = r8;
        if (r8 != null) goto L35;
    L38:
        if (r6 == false) goto L50;
        this.msg = r2.toString();
        return;
    L50:
        return;
    L35:
        if (r8.length() == 0) goto L38;
        r6 = false;
        goto L38
    L31:
        r7 = 10005;
        goto L32
    }

    public /* synthetic */ ExceptionResult(Exception r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
