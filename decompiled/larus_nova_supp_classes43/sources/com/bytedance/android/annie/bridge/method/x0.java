package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.LogoutResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x0 implements IUserInfoService.ILogoutStatusCallback {
    public final /* synthetic */ y0 a;

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILogoutStatusCallback
    public final void onSuccess() {
        y0 r0 = this.a;
        LogoutResultModel r1 = new LogoutResultModel();
        r1.a(LogoutResultModel.Code.Success);
        r1.b("loggedOut success");
        r0.finishWithResult(r1);
    }

    public x0(y0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILogoutStatusCallback
    public final void onFail(String r10) {
        y0 r0 = this.a;
        LogoutResultModel r1 = new LogoutResultModel();
        r1.a(LogoutResultModel.Code.Success);
        if (r10 != null) goto L5;
        r10 = "loggedOut Fail";
    L5:
        r1.b(r10);
        r0.finishWithResult(r1);
    }
}
