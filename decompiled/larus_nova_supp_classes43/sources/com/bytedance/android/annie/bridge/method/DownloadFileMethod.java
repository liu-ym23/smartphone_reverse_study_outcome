package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.security.MessageDigest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "downloadFile")
public final class DownloadFileMethod extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public final IHybridComponent a;
    public final com.bytedance.android.annie.container.fragment.q b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;)V", "", MessageIndication.MESSAGE_TYPE_MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "", "clientCode", "Ljava/lang/Integer;", "getClientCode", "()Ljava/lang/Integer;", "a", "(Ljava/lang/Integer;)V", "httpCode", "getHttpCode", "e", "", "", "header", "Ljava/util/Map;", "getHeader", "()Ljava/util/Map;", "d", "(Ljava/util/Map;)V", "response", "getResponse", "setResponse", "filePath", "getFilePath", "c", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class DownloadFileResModel implements e7.k0 {

        @SerializedName("clientCode")
        private Integer clientCode;

        @SerializedName("code")
        private Code code;

        @SerializedName("filePath")
        private String filePath;

        @SerializedName("header")
        private Map<String, ? extends Object> header;

        @SerializedName("httpCode")
        private Integer httpCode;

        @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
        private String msg;

        @SerializedName("response")
        private Map<String, ? extends Object> response;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$DownloadFileResModel$Code;", "", "Le7/j0;", "", "getCode", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "Success", "Failed", "FailedPermissionRejected", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final enum Code extends Enum<Code> implements e7.j0 {
            public static final Code Failed = null;
            public static final Code FailedPermissionRejected = null;
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
                Code r10 = new Code("FailedPermissionRejected", 2, -6);
                FailedPermissionRejected = r10;
                a = new Code[]{r0, r1, r10};
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

        public DownloadFileResModel() {
            this.clientCode = 0;
            this.httpCode = 0;
        }

        public final void a(Integer r1) {
            this.clientCode = r1;
        }

        public final void b(Code r1) {
            this.code = r1;
        }

        public final void c(String r1) {
            this.filePath = r1;
        }

        public final void d(Map<String, ? extends Object> r1) {
            this.header = r1;
        }

        public final void e(Integer r1) {
            this.httpCode = r1;
        }

        public final void f(String r1) {
            this.msg = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/annie/bridge/method/DownloadFileMethod$a;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "extension", "a", "setExtension", "", "header", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "params", "d", "setParams", "", "needCommonParams", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setNeedCommonParams", "(Ljava/lang/Boolean;)V", "saveToAlbum", "e", "setSaveToAlbum", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("extension")
        private String extension;

        @SerializedName("header")
        private Map<String, ? extends Object> header;

        @SerializedName("needCommonParams")
        private Boolean needCommonParams;

        @SerializedName("params")
        private Map<String, ? extends Object> params;

        @SerializedName("saveToAlbum")
        private String saveToAlbum;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
        private String url;

        public a() {
            this.needCommonParams = Boolean.TRUE;
        }

        public final String a() {
            return this.extension;
        }

        public final Map<String, Object> b() {
            return this.header;
        }

        public final Boolean c() {
            return this.needCommonParams;
        }

        public final Map<String, Object> d() {
            return this.params;
        }

        public final String e() {
            return this.saveToAlbum;
        }

        public final String f() {
            return this.url;
        }
    }

    public final void onTerminate() {
    }

    public DownloadFileMethod(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        IHybridComponent r0 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r0 == null) goto L5;
        this.a = r0;
    L5:
        com.bytedance.android.annie.container.fragment.q r11 = (com.bytedance.android.annie.container.fragment.q) r10.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r11 == null) goto L9;
        this.b = r11;
        return;
    }

    public DownloadFileMethod(IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridComponent");
        this.a = r10;
    }

    public final void invoke(Object r14, CallContext r15) {
        a r1 = (a) r14;
        Intrinsics.checkNotNullParameter(r1, "model");
        Intrinsics.checkNotNullParameter(r15, "context");
        String r16 = r1.f();
        boolean r0 = false;
        if (r16 != null) goto L5;
    L8:
        boolean r17 = true;
    L9:
        if (r17 == false) goto L11;
        DownloadFileResModel r18 = new DownloadFileResModel();
        r18.b(DownloadFileResModel.Code.Failed);
        r18.f("url  is  null");
        finishWithResult(r18);
        return;
    L11:
        Context r10 = r15.getContext();
        String r19 = r1.f();
        if (r19 != null) goto L14;
    L17:
        boolean r110 = true;
    L18:
        String r11 = null;
        if (r110 == true) goto L35;
        StringBuilder r111 = new StringBuilder();
        char[] r12 = com.bytedance.android.annie.util.j.a;
        String r13 = r1.f();
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNullParameter(r13, "string");
        byte[] r20 = r13.getBytes(Charsets.UTF_8);     // Catch: Exception -> L31
        MessageDigest r21 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L28
        r21.update(r20);     // Catch: Exception -> L28
        byte[] r22 = r21.digest();     // Catch: Exception -> L28
        char[] r23 = new char[32];     // Catch: Exception -> L28
        int r24 = 0;
        int r25 = 0;
    L24:
        if (r24 >= 16) goto L26;
        byte r26 = r22[r24];     // Catch: Exception -> L28
        int r112 = r25 + 1;     // Catch: Exception -> L28
        char[] r113 = com.bytedance.android.annie.util.j.a;     // Catch: Exception -> L28
        r23[r25] = r113[(r26 >>> 4) & 15];     // Catch: Exception -> L28
        r25 = r112 + 1;     // Catch: Exception -> L28
        r23[r112] = r113[r26 & 15];     // Catch: Exception -> L28
        r24 = r24 + 1;     // Catch: Exception -> L28
        goto L24
    L26:
        String r27 = r23.toString();     // Catch: Exception -> L28
    L34:
        r111.append(r27);
        r111.append('_');
        r111.append(System.currentTimeMillis());
        String r114 = r111.toString();
    L36:
        String r115 = r114 + '.' + r1.a();
        File r28 = r10.getExternalCacheDir();
        if (r28 != null) goto L39;
        r28 = r10.getCacheDir();
    L39:
        if (r28 == null) goto L41;
        r11 = r28.getAbsolutePath();
    L41:
        if (r11 != null) goto L43;
    L44:
        r0 = true;
    L45:
        if (r0 == false) goto L47;
        DownloadFileResModel r116 = new DownloadFileResModel();
        r116.b(DownloadFileResModel.Code.Failed);
        r116.f("cacheDir is null");
        finishWithResult(r116);
        return;
    L47:
        String r29 = r11 + '/' + r115;
        if (new PolarisFileWrapper(r29).exists() == false) goto L50;
        DownloadFileResModel r117 = new DownloadFileResModel();
        r117.b(DownloadFileResModel.Code.Failed);
        r117.f("file path already exist");
        finishWithResult(r117);
        return;
    L50:
        TTExecutors.getNormalExecutor().execute(new r(r1, this, r15, r29, r10));
        return;
    L43:
        if (StringsKt.isBlank(r11) == false) goto L45;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L31
    L33:
        r27 = null;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L35:
        r114 = "base64_" + System.currentTimeMillis();
        goto L36
    L14:
        if (StringsKt.isBlank(r19) == true) goto L17;
        r110 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r16) == true) goto L8;
        r17 = false;
        goto L9
    }
}
