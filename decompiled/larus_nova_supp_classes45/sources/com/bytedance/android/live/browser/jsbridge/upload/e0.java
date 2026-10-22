package com.bytedance.android.live.browser.jsbridge.upload;

import android.content.Context;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 implements SingleObserver<Response<UploadResult>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ File b;
    public final /* synthetic */ f0 c;

    public final void onError(Throwable r5) {
        Context r0 = this.c.a.getContext();
        if (r0 == null) goto L6;
        ExceptionUtils.handleException(r0, r5);
    L6:
        if (this.b.length() > 0) goto L8;
        this.c.getClass();
        return;
    L8:
        f2.b(2131921350, 0);
        this.c.o();
    }

    public final void onSubscribe(Disposable r2) {
        this.c.e = r2;
    }

    public final void onSuccess(Object r5) {
        Response r6 = (Response) r5;
        ((UploadResult) ((BaseResponse) r6).data).setPath(this.a);
        f0 r0 = this.c;
        UploadResult r7 = (UploadResult) ((BaseResponse) r6).data;
        String r1 = this.a;
        r0.n();
        String r8 = r7.getUri();
        o30.c.b.getClass();
        r0.finishWithResult(new f0.b(r8, o30.c.a(r1)));
    }

    public e0(f0 r1, String r2, PolarisFileWrapper r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
