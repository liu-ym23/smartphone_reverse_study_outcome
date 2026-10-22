package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class qd implements SingleObserver<Response<UploadResult>> {
    public final /* synthetic */ UploadScreenMethod a;
    public final /* synthetic */ String b;

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        UploadScreenMethod.b r0 = new UploadScreenMethod.b();
        this.a.k(r0);
        ALogger.e("UploadScreenMethod", "upload error", r3);
        UploadScreenMethod.j(this.a);
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.a = r2;
    }

    public final void onSuccess(Object r8) {
        Response r9 = (Response) r8;
        Intrinsics.checkNotNullParameter(r9, "response");
        UploadScreenMethod r0 = this.a;
        UploadResult r1 = (UploadResult) ((BaseResponse) r9).data;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getUri();
    L6:
        String r4 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "filepath");
        UploadScreenMethod.b r5 = new UploadScreenMethod.b();
        if (r3 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r0.k(r5);
    L16:
        StringBuilder r7 = new StringBuilder("upload success,uri is ");
        UploadResult r11 = (UploadResult) ((BaseResponse) r9).data;
        if (r11 == null) goto L19;
        r2 = r11.getUri();
    L19:
        r7.append(r2);
        ALogger.i("UploadScreenMethod", r7.toString());
        UploadScreenMethod.j(this.a);
        return;
    L15:
        r5.b(r3);
        r5.a(r4);
        r0.finishWithResult(new UploadScreenMethod.c(0, "成功", r5));
        goto L16
    L9:
        if (r3.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public qd(UploadScreenMethod r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
