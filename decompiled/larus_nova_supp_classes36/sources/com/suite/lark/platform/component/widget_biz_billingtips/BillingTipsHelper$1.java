package com.suite.lark.platform.component.widget_biz_billingtips;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.role.GetAdminPermissionInfoResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class BillingTipsHelper$1 implements IGetDataCallback<GetAdminPermissionInfoResponse> {
    final /* synthetic */ IGetDataCallback val$callback;

    public BillingTipsHelper$1(IGetDataCallback r1) {
        this.val$callback = r1;
    }

    public void onError(ErrorResult r2) {
        this.val$callback.onError(r2);
    }

    public void onSuccess(GetAdminPermissionInfoResponse r2) {
        if (r2 != null) goto L5;
        onError(new ErrorResult("response is null"));
        return;
    L5:
        this.val$callback.onSuccess(r2.misSuperAdministrator);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((GetAdminPermissionInfoResponse) r1);
    }
}
