package com.bytedance.android.annie.bridge;

import com.bytedance.ai.event.MessageIndication;
import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019¨\u0006,"}, d2 = {"Lcom/bytedance/android/annie/bridge/UploadFileResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/UploadFileResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/UploadFileResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/UploadFileResultModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/UploadFileResultModel$Code;)V", "", "clientCode", "Ljava/lang/Number;", "getClientCode", "()Ljava/lang/Number;", "a", "(Ljava/lang/Number;)V", "httpCode", "getHttpCode", "c", "", MessageIndication.MESSAGE_TYPE_MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "", "header", "Ljava/util/Map;", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "", "response", "getResponse", "e", com.bytedance.android.ec.core.event.a.KEY_URL, "getUrl", "f", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class UploadFileResultModel implements k0 {

    @SerializedName("clientCode")
    private Number clientCode;

    @SerializedName("code")
    private Code code;

    @SerializedName("header")
    private Map<String, ? extends Object> header;

    @SerializedName("httpCode")
    private Number httpCode;

    @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
    private String msg;

    @SerializedName("response")
    private Map<String, Object> response;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/UploadFileResultModel$Code;", "", "Le7/j0;", "", "getCode", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "Success", "Failed", "InvalidParam", "NetworkUnreachable", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code InvalidParam = null;
        public static final Code NetworkUnreachable = null;
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
            Code r10 = new Code("InvalidParam", 2, -3);
            InvalidParam = r10;
            Code r11 = new Code("NetworkUnreachable", 3, -1001);
            NetworkUnreachable = r11;
            a = new Code[]{r0, r1, r10, r11};
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

    public UploadFileResultModel() {
    }

    public final void a(Number r1) {
        this.clientCode = r1;
    }

    public final void b(Code r1) {
        this.code = r1;
    }

    public final void c(Number r1) {
        this.httpCode = r1;
    }

    public final void d(String r1) {
        this.msg = r1;
    }

    public final void e(Map<String, Object> r1) {
        this.response = r1;
    }

    public final void f(String r1) {
        this.url = r1;
    }
}
