package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.SetEnvResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class InitImSdkTask$5$1 implements IGetDataCallback<SetEnvResponse> {
    final /* synthetic */ h this$1;
    final /* synthetic */ dzb.d val$callback;
    final /* synthetic */ boolean val$changed;
    final /* synthetic */ int val$envType;
    final /* synthetic */ String val$tenantBrand;
    final /* synthetic */ String val$userUnit;

    public void onError(ErrorResult r3) {
        Log.i("InitImSdkTask", "onLoginEnvChanged failed changed = " + this.val$changed + "; userUnit=" + this.this$1.a.j().getUserUnit(), null);
    }

    public void onSuccess(SetEnvResponse r9) {
        if (r9 == null) goto L9;
        DomainSettings r1 = r9.domain_settings;
        if (r1 == null) goto L9;
        if (CollectionUtils.isEmpty(r1.pairs) == true) goto L9;
        jcb.b.c().K0("absent_user", InitSDKRequest.EnvType.fromValue(this.val$envType), this.val$userUnit, this.val$tenantBrand, r9.domain_settings);
        Log.i("InitImSdkTask", "update domain, absent_user");
    L9:
        ((epb.a) this.this$1.a.i.get()).setAppLogUriRuntime();
        Log.i("InitImSdkTask", "setEnv end, onLoginEnvChanged success changed = " + this.val$changed + "; userUnit=" + this.this$1.a.j().getUserUnit(), null);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((SetEnvResponse) r1);
    }

    public InitImSdkTask$5$1(h r1, int r2, String r3, String r4, boolean r5, dzb.d r6) {
        this.this$1 = r1;
        this.val$envType = r2;
        this.val$userUnit = r3;
        this.val$tenantBrand = r4;
        this.val$changed = r5;
    }
}
