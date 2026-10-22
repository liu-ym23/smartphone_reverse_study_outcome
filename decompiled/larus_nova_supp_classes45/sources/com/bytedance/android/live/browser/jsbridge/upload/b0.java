package com.bytedance.android.live.browser.jsbridge.upload;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.browser.api.UploadApi;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 extends com.bytedance.ies.web.jsbridge2.f<b, c> implements com.bytedance.android.live.room.g.b {
    public com.bytedance.android.live.room.g a;
    public Fragment b;
    public Disposable c;
    public int d;

    public class a implements SingleObserver<Response<UploadResult>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ b0 b;

        public final void onError(Throwable r2) {
            Context r0 = this.b.b.getContext();
            if (r0 == null) goto L5;
            ExceptionUtils.handleException(r0, r2);
        L5:
            b0 r3 = this.b;
            k2 r1 = r3.a;
            if (r1 == null) goto L8;
            r1.e();
            r3.a = null;
        L8:
            r3.finishWithFailure();
        }

        public final void onSubscribe(Disposable r2) {
            this.b.c = r2;
        }

        public final void onSuccess(Object r5) {
            Response r6 = (Response) r5;
            ((UploadResult) ((BaseResponse) r6).data).setPath(this.a);
            b0 r0 = this.b;
            UploadResult r7 = (UploadResult) ((BaseResponse) r6).data;
            String r1 = this.a;
            k2 r2 = r0.a;
            if (r2 == null) goto L5;
            r2.e();
            r0.a = null;
        L5:
            String r8 = r7.getUri();
            o30.c.b.getClass();
            r0.finishWithResult(new c(r8, o30.c.a(r1)));
        }

        public a(b0 r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class b {

        @SerializedName("aspect_x")
        int aspect_x;

        @SerializedName("aspect_y")
        int aspect_y;

        @SerializedName("max_size")
        int max_size;

        @SerializedName("min_height")
        int min_height;

        @SerializedName("min_width")
        int min_width;

        public b() {
        }
    }

    public static final class c {

        @SerializedName("uri")
        String uri;

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        String url;

        public c(String r1, String r2) {
            this.uri = r1;
            this.url = r2;
        }
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e(String r1, String r2, String r3) {
    }

    public final /* synthetic */ void g(String r1, int r2) {
    }

    public final /* synthetic */ void h() {
    }

    public final /* synthetic */ void onError(String r1) {
    }

    public final void onCanceled() {
        k2 r0 = this.a;
        if (r0 == null) goto L5;
        r0.e();
        this.a = null;
    L5:
        finishWithFailure();
    }

    public final void onTerminate() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
        this.a.e();
    }

    public b0(Fragment r1) {
        this.b = r1;
    }

    public final void invoke(Object r13, CallContext r14) throws Exception {
        b r15 = (b) r13;
        int r16 = r15.max_size;
        if (r16 > 0) goto L6;
        r16 = Integer.MAX_VALUE;
    L6:
        this.d = r16;
        k2 r17 = jc1.k.f(ILiveSDKService.class).createImagePicker(null, this.b, "upload_photo_method", null, r15.aspect_x, r15.aspect_y, r15.min_width, r15.min_height, this, null, null);
        this.a = r17;
        if (r17 == null) goto L11;
        r17.u(false, false, -1);
        return;
    }

    public final void b(String r4, String r5, IThemeShowArea r6, ThemeUpLoadListener r7, int r8) {
        this.a.v();
        PolarisFileWrapper r9 = new PolarisFileWrapper(r4);
        if (r9.exists() == true) goto L9;
        k2 r11 = this.a;
        if (r11 == null) goto L7;
        r11.e();
        this.a = null;
    L7:
        finishWithFailure();
        return;
    L9:
        long r12 = r9.length();
        int r13 = this.d;
        if (r12 < r13) goto L13;
        f2.c(s1.C(2131919624, new Object[]{Integer.valueOf((r13 / RomUtils.SZ) / RomUtils.SZ)}), 0);
        return;
    L13:
        TypedOutput r14 = new MultipartTypedOutput();
        r14.addPart("data", new TypedFile("multipart/form-data", r9));
        ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r14).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r4));
    }
}
