package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel$Code;", "a", "(Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel$Code;)V", "", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "b", "(Ljava/lang/Object;)V", "", MessageIndication.MESSAGE_TYPE_MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class GetStorageItemResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private Object data;

    @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel$Code;", "", "Le7/j0;", "", "getCode", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "Success", "Failed", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        public static Code valueOf(String r1) {
            return (Code) r27.a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        static {
            Code r0 = new Code("Success", 0, 1);
            Success = r0;
            Code r1 = new Code("Failed", 1, 0);
            Failed = r1;
            a = new Code[]{r0, r1};
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r10, int r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public GetStorageItemResultModel() {
    }

    public final void a(Code r1) {
        this.code = r1;
    }

    public final void b(Object r1) {
        this.data = r1;
    }

    public final void c(String r1) {
        this.msg = "SUCCESS";
    }
}
