package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r27.a;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LynxReportResponseResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/LynxReportResponseResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/LynxReportResponseResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/LynxReportResponseResultModel$Code;", "a", "(Lcom/bytedance/android/live/browser/jsbridge/base/LynxReportResponseResultModel$Code;)V", "Lcom/google/gson/JsonObject;", "data", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "setData", "(Lcom/google/gson/JsonObject;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxReportResponseResultModel implements aa {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private JsonObject data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LynxReportResponseResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        static {
            Code r1 = new Code("Success", 0, 1);
            Success = r1;
            Code r2 = new Code("Failed", 1, 0);
            Failed = r2;
            Code r3 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r3;
            Code r4 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r4;
            a = new Code[]{r1, r2, r3, r4};
        }

        public static Code valueOf(String r1) {
            return (Code) a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        @Override // w20.z9
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public LynxReportResponseResultModel() {
    }

    public final void a(Code r1) {
        this.code = r1;
    }

    public final void b(String r1) {
        this.msg = "请求成功";
    }
}
