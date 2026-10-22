package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.LoginResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v0 implements IUserInfoService.ILoginStatusCallback {
    public final /* synthetic */ IUserInfoService a;
    public final /* synthetic */ w0 b;

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILoginStatusCallback
    public final void onFail() {
        w0 r0 = this.b;
        LoginResultModel r1 = new LoginResultModel();
        r1.b(LoginResultModel.Code.Success);
        r1.a(Boolean.FALSE);
        LoginResultModel.Status r10 = LoginResultModel.Status.Cancelled;
        r1.d(r10.toString());
        r1.c(r10.toString());
        r0.finishWithResult(r1);
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILoginStatusCallback
    public final void onSuccess() {
        this.a.hasLogin();
        w0 r0 = this.b;
        LoginResultModel r1 = new LoginResultModel();
        r1.b(LoginResultModel.Code.Success);
        r1.a(Boolean.FALSE);
        LoginResultModel.Status r10 = LoginResultModel.Status.Cancelled;
        r1.d(r10.toString());
        r1.c(r10.toString());
        r0.finishWithResult(r1);
    }

    public v0(IUserInfoService r1, w0 r10) {
        this.a = r1;
        this.b = r10;
    }
}
