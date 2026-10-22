package com.ss.android.lark.passport.flow.idp_auth;

import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/passport/flow/idp_auth/FlowIdpLoginResult;", "Ljava/io/Serializable;", "<init>", "()V", "state", "", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "message", "getMessage", "setMessage", "logId", "getLogId", "setLogId", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowIdpLoginResult implements Serializable {
    public static final a Companion = null;
    private int code;

    @JSONField(name = "log_id")
    private String logId;
    private String message;
    private String state;

    public static final class a {
        public a() {
        }

        public static FlowIdpLoginResult a(String r5, String r6) {
            if (r5 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            Object r1 = null;
            if (r0 == false) goto L41;
            PassportLog.b("FlowIdpLoginResult", "decode " + r6 + " failed: encoded content is blank");
            return null;
        L41:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
            Object r3 = Result.constructor-impl(Base64.decode(r5, 2));     // Catch: Throwable -> L16
        L19:
            if (Result.exceptionOrNull-impl(r3) == null) goto L22;
            r3 = Base64.decode(r5, 10);     // Catch: Throwable -> L24
        L22:
            Object r7 = Result.constructor-impl((FlowIdpLoginResult) JSON.parseObject(new String((byte[]) r3, StandardCharsets.UTF_8), FlowIdpLoginResult.class));     // Catch: Throwable -> L24
        L27:
            if (Result.isSuccess-impl(r7) == true) goto L29;
        L32:
            Throwable r4 = Result.exceptionOrNull-impl(r7);
            if (r4 == null) goto L36;
            PassportLog.b("FlowIdpLoginResult", "decode " + r6 + " failed: " + r4.getClass().getSimpleName());
        L36:
            if (Result.isFailure-impl(r7) == true) goto L40;
            r1 = r7;
        L40:
            return (FlowIdpLoginResult) r1;
        L29:
            if (((FlowIdpLoginResult) r7) == null) goto L31;
            PassportLog.d("FlowIdpLoginResult", "decode " + r6 + " success");
            goto L32
        L31:
            PassportLog.b("FlowIdpLoginResult", "decode " + r6 + " failed: result is null");
        L16:
            th = move-exception;
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
            r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L27
        L4:
            if (StringsKt.isBlank(r5) == true) goto L7;
            r0 = false;
            goto L8
        }
    }

    public FlowIdpLoginResult() {
    }

    static {
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getState() {
        return this.state;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setState(String r1) {
        this.state = r1;
    }
}
