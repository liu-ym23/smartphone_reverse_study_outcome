package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.lark.dependency.IMiraDependency;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.mira.UIGetPluginCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class MiraDependencyImpl$1 extends UIGetPluginCallback<Object> {
    final /* synthetic */ l0 this$0;
    final /* synthetic */ IMiraDependency.UIGetPluginCallback val$uiGetPluginCallback;

    @Override // com.ss.android.lark.mira.UIGetPluginCallback
    public void onPluginLoading() {
        tt5.a.h("MiraDependencyImpl", "onPluginLoading()...");
        IMiraDependency.UIGetPluginCallback r0 = this.val$uiGetPluginCallback;
        if (r0 == null) goto L6;
        r0.onPluginLoading();
        return;
    }

    public void onErrored(ErrorResult r3) {
        super.onErrored(r3);
        tt5.a.h("MiraDependencyImpl", "onErrored()...error = " + r3);
        IMiraDependency.UIGetPluginCallback r0 = this.val$uiGetPluginCallback;
        if (r0 == null) goto L6;
        r0.onErrored(r3);
        return;
    }

    public void onSuccessed(Object r3) {
        super.onSuccessed(r3);
        tt5.a.h("MiraDependencyImpl", "onSuccessed()...plugin = " + r3);
        IMiraDependency.UIGetPluginCallback r0 = this.val$uiGetPluginCallback;
        if (r0 == null) goto L6;
        r0.onSuccessed(r3);
        return;
    }

    public MiraDependencyImpl$1(l0 r1, IMiraDependency.UIGetPluginCallback r2) {
        this.this$0 = r1;
        this.val$uiGetPluginCallback = r2;
    }
}
