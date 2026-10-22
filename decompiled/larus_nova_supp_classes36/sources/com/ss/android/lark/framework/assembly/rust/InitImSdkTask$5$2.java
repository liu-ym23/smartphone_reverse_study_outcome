package com.ss.android.lark.framework.assembly.rust;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class InitImSdkTask$5$2 implements IGetDataCallback<Boolean> {
    final /* synthetic */ h this$1;
    final /* synthetic */ dzb.d val$callback;
    final /* synthetic */ boolean val$changed;

    public void onError(ErrorResult r3) {
        Log.i("InitImSdkTask", "onLoginEnvChanged failed changed = " + this.val$changed + "; userUnit=" + this.this$1.a.j().getUserUnit(), null);
    }

    public void onSuccess(Boolean r3) {
        ((epb.a) this.this$1.a.i.get()).setAppLogUriRuntime();
        Log.i("InitImSdkTask", "setEnv end, onLoginEnvChanged success changed = " + this.val$changed + "; userUnit=" + this.this$1.a.j().getUserUnit(), null);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Boolean) r1);
    }

    public InitImSdkTask$5$2(h r1, boolean r2, dzb.d r3) {
        this.this$1 = r1;
        this.val$changed = r2;
    }
}
