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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "saveDataURL")
public final class SaveDataURLMethod extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public final IHybridComponent a;
    public final com.bytedance.android.annie.container.fragment.q b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "a", "(Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;)V", "", MessageIndication.MESSAGE_TYPE_MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "filePath", "getFilePath", "b", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class SaveDataURLResModel implements e7.k0 {

        @SerializedName("code")
        private Code code;

        @SerializedName("filePath")
        private String filePath;

        @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
        private String msg;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$SaveDataURLResModel$Code;", "", "Le7/j0;", "", "getCode", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "Success", "Failed", "Failed_-3", "FailedPermissionRejected", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final enum Code extends Enum<Code> implements e7.j0 {
            public static final Code Failed = null;
            public static final Code FailedPermissionRejected = null;

            /* JADX INFO: renamed from: Failed_-3, reason: not valid java name */
            public static final Code f3Failed_3 = null;
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
                Code r10 = new Code("Failed_-3", 2, -3);
                f3Failed_3 = r10;
                Code r11 = new Code("FailedPermissionRejected", 3, -6);
                FailedPermissionRejected = r11;
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

        public SaveDataURLResModel() {
        }

        public final void a(Code r1) {
            this.code = r1;
        }

        public final void b(String r1) {
            this.filePath = r1;
        }

        public final void c(String r1) {
            this.msg = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/SaveDataURLMethod$a;", "", "", "filename", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFilename", "(Ljava/lang/String;)V", "dataURL", "a", "setDataURL", "extension", "b", "setExtension", "saveToAlbum", "d", "setSaveToAlbum", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("dataURL")
        private String dataURL;

        @SerializedName("extension")
        private String extension;

        @SerializedName("filename")
        private String filename;

        @SerializedName("saveToAlbum")
        private String saveToAlbum;

        public a() {
        }

        public final String a() {
            return this.dataURL;
        }

        public final String b() {
            return this.extension;
        }

        public final String c() {
            return this.filename;
        }

        public final String d() {
            return this.saveToAlbum;
        }
    }

    public final void onTerminate() {
    }

    public SaveDataURLMethod(m16.b r10) {
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

    public SaveDataURLMethod(IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridComponent");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        a r12 = (a) r10;
        Intrinsics.checkNotNullParameter(r12, "model");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.a();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        SaveDataURLResModel r14 = new SaveDataURLResModel();
        r14.a(SaveDataURLResModel.Code.f3Failed_3);
        r14.c("dataURL must be provided");
        finishWithResult(r14);
        return;
    L11:
        String r15 = r12.c();
        if (r15 != null) goto L14;
    L17:
        boolean r16 = true;
    L18:
        if (r16 == false) goto L20;
        SaveDataURLResModel r17 = new SaveDataURLResModel();
        r17.a(SaveDataURLResModel.Code.f3Failed_3);
        r17.c("filename must be provided ");
        finishWithResult(r17);
        return;
    L20:
        String r18 = r12.b();
        if (r18 != null) goto L23;
    L26:
        boolean r19 = true;
    L27:
        if (r19 == false) goto L29;
        SaveDataURLResModel r20 = new SaveDataURLResModel();
        r20.a(SaveDataURLResModel.Code.f3Failed_3);
        r20.c("extension must be provided");
        finishWithResult(r20);
        return;
    L29:
        Context r21 = r11.getContext();
        File r22 = r21.getExternalCacheDir();
        if (r22 != null) goto L32;
        r22 = r21.getCacheDir();
    L32:
        if (r22 == null) goto L34;
        String r23 = r22.getAbsolutePath();
    L35:
        if (r23 != null) goto L37;
    L40:
        if (r1 == false) goto L42;
        SaveDataURLResModel r24 = new SaveDataURLResModel();
        r24.a(SaveDataURLResModel.Code.Failed);
        r24.c("cacheDir is null");
        finishWithResult(r24);
        return;
    L42:
        String r25 = r23 + '/' + (r12.c() + '.' + r12.b());
        if (new PolarisFileWrapper(r25).exists() == false) goto L45;
        SaveDataURLResModel r26 = new SaveDataURLResModel();
        r26.a(SaveDataURLResModel.Code.Failed);
        r26.c("file path already exist");
        finishWithResult(r26);
        return;
    L45:
        TTExecutors.getNormalExecutor().execute(new y1(r12, r25, this, r21));
        return;
    L37:
        if (StringsKt.isBlank(r23) == true) goto L40;
        r1 = false;
        goto L40
    L34:
        r23 = null;
        goto L35
    L23:
        if (StringsKt.isBlank(r18) == true) goto L26;
        r19 = false;
        goto L27
    L14:
        if (StringsKt.isBlank(r15) == true) goto L17;
        r16 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r13 = false;
        goto L9
    }
}
