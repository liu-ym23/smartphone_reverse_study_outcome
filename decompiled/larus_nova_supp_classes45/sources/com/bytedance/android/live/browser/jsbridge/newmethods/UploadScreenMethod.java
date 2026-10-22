package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.browser.api.UploadApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "uploadScreenshot")
public final class UploadScreenMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, c> {
    public Disposable a;
    public final Lazy b;
    public ProgressDialog c;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "", "", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "localUrl", "getLocalUrl", "setLocalUrl", "localImg", "getLocalImg", "a", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("local_img")
        private String localImg;

        @SerializedName("local_url")
        private String localUrl;

        @SerializedName("uri")
        private String uri;

        public b() {
        }

        public final void a(String r1) {
            this.localImg = r1;
        }

        public final void b(String r1) {
            this.uri = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$c;", "", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "status", "getStatus", "setStatus", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "data", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;", "setData", "(Lcom/bytedance/android/live/browser/jsbridge/newmethods/UploadScreenMethod$b;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("code")
        private Integer code;

        @SerializedName("data")
        private b data;

        @SerializedName("status")
        private Integer status;

        @SerializedName("status_msg")
        private String statusMsg;

        public c() {
        }

        public c(int r2, String r3, b r4) {
            Intrinsics.checkNotNullParameter(r3, "statusMsg");
            Intrinsics.checkNotNullParameter(r4, "data");
            this.code = 1;
            this.status = Integer.valueOf(r2);
            this.statusMsg = r3;
            this.data = r4;
        }
    }

    static {
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public UploadScreenMethod() {
        this.b = LazyKt.lazy(UploadScreenMethod$offlineResourceInterceptor$2.INSTANCE);
    }

    public static final void j(UploadScreenMethod r3) {
        ProgressDialog r4 = r3.c;
        if (r4 == null) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(r4);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r4);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r4));
        return;
    }

    public final void k(b r4) {
        finishWithResult(new c(1, "失败", r4));
    }

    public final void invoke(Object r9, CallContext r11) {
        JSONObject r12 = (JSONObject) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r1 = r12.optString("scene");
        b r2 = new b();
        String r3 = com.bytedance.android.livesdk.utils.i0.a;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        k(r2);
        ALogger.e("UploadScreenMethod", "path is null");
        return;
    L12:
        if (r1 == null) goto L65;
        int r6 = r1.hashCode();
        if (r6 == (-838595071)) goto L30;
        if (r6 == 3529469) goto L20;
        return;
    L20:
        if (r1.equals("show") == false) goto L60;
        o30.c.b.b(r11.getContext().getCacheDir().getCanonicalPath());     // Catch: IOException -> L23
    L25:
        com.bytedance.android.annie.util.q r13 = com.bytedance.android.annie.util.g.a(r11.getContext(), r3);
        if (r13.a == false) goto L28;
        b r14 = new b();
        o30.c r0 = (o30.c) this.b.getValue();
        String r15 = r13.b;
        r0.getClass();
        r14.a(o30.c.a(r15));
        Unit r16 = Unit.INSTANCE;
        finishWithResult(new c(0, "成功", r14));
        ALogger.i("UploadScreenMethod", "show finish success");
        return;
    L28:
        k(r2);
        return;
    L23:
        e = move-exception;
        ALogger.e("UploadScreenMethod", e);
        goto L25
    L60:
        return;
    L30:
        if (r1.equals("upload") == false) goto L63;
        Intrinsics.checkNotNullParameter(r3, "filePath");
        Intrinsics.checkNotNullParameter(r12, "params");
        PolarisFileWrapper r17 = new PolarisFileWrapper(r3);
        if (r17.exists() == true) goto L34;
        k(new b());
        ALogger.e("UploadScreenMethod", "upload error,file is not exist");
        return;
    L34:
        TypedOutput r4 = new MultipartTypedOutput();
        r4.addPart("data", new TypedFile("multipart/form-data", r17));
        if (this.c != null) goto L39;
        ProgressDialog r18 = new ProgressDialog(getCallContext().getContext());
        this.c = r18;
        r18.setMessage(com.bytedance.android.live.core.utils.s1.B(2131920031));
        ProgressDialog r19 = this.c;
        if (r19 == null) goto L39;
        r19.setCancelable(false);
    L39:
        ProgressDialog r110 = this.c;
        if (r110 != null) goto L42;
    L48:
        boolean r111 = r12.optBoolean("use_fe_url", false);
        String r21 = r12.optString(LiveSlardarConstants.EXTRA_KEY_URL);
        if (r111 == false) goto L51;
        Single<Response<UploadResult>> r22 = ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r21, r4);
    L52:
        ((du2.c) r22.compose(RxUtil.rxSchedulerHelper()).as(new du2.d())).a(pd.a).subscribe(new qd(this, r3));
        return;
    L51:
        r22 = ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r4);
        goto L52
    L42:
        if (r110.isShowing() == true) goto L48;
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L55;
        DialogLancet.handleBlockedDialogShow(r110);
        goto L48
    L55:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L47:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L48
    L63:
        return;
    L65:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r5 = false;
        goto L10
    }
}
