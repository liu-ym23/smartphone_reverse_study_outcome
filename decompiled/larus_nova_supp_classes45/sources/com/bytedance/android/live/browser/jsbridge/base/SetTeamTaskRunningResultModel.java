package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetTeamTaskRunningResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/model/IResultModel;", "Lcom/bytedance/android/live/browser/jsbridge/base/SetTeamTaskRunningResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/SetTeamTaskRunningResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/SetTeamTaskRunningResultModel$Code;", "setCode", "(Lcom/bytedance/android/live/browser/jsbridge/base/SetTeamTaskRunningResultModel$Code;)V", "", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SetTeamTaskRunningResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private String data;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetTeamTaskRunningResultModel$Code;", "", "Le7/j0;", "Lcom/bytedance/android/live/browser/jsbridge/model/IResultCode;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        static {
            Code r1 = new Code("Success", 0, 1);
            Success = r1;
            Code r2 = new Code("Failed", 1, 0);
            Failed = r2;
            a = new Code[]{r1, r2};
        }

        public static Code valueOf(String r1) {
            return (Code) a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

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

    public SetTeamTaskRunningResultModel() {
    }
}
