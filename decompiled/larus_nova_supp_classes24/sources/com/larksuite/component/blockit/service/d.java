package com.larksuite.component.blockit.service;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends z18.b<BaseResponse> {
    public final /* synthetic */ BlockitService.g a;
    public final /* synthetic */ IGetDataCallback b;

    @Override // z18.b
    public final void a(ErrorResult r4) {
        this.a.onError(new com.larksuite.framework.callback.Entity.ErrorResult(-1, r4.getErrorMessage()));
    }

    @Override // z18.c
    public final void onSuccess(Object r6) {
        BaseResponse r7 = (BaseResponse) r6;
        AppBrandLogger.i("BlockitService", new Object[]{"onSuccess: resp code ", Integer.valueOf(r7.code())});     // Catch: IOException -> L8
        if (r7.isSuccessful() == false) goto L6;
        this.a.a(r7.message(), r7.headers());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.b.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r7.code()));     // Catch: IOException -> L8
    L8:
        e = move-exception;
        AppBrandLogger.e("BlockitService", new Object[]{"createBlockEntity fail: parse message error " + e.getMessage()});
        e.printStackTrace();
    }

    public d(c r1, IGetDataCallback r2) {
        this.a = r1;
        this.b = r2;
    }
}
