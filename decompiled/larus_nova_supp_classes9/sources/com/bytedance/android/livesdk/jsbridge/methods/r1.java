package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveTryLoadCertPluginResultModel;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r1 implements IHostOCRApiProxy.LiveCertPreloadListener {
    public final /* synthetic */ s1 a;

    public r1(s1 r1) {
        this.a = r1;
    }

    public final void onCertPluginLoaded(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        s1 r4 = this.a;
        LiveTryLoadCertPluginResultModel r5 = new LiveTryLoadCertPluginResultModel();
        r5.a(LiveTryLoadCertPluginResultModel.Code.Success);
        r5.b("cert plugin loaded");
        Unit r0 = Unit.INSTANCE;
        r4.finishWithResult(r5);
        return;
    L4:
        if (r3 == false) goto L6;
        s1 r6 = this.a;
        LiveTryLoadCertPluginResultModel r7 = new LiveTryLoadCertPluginResultModel();
        r7.a(LiveTryLoadCertPluginResultModel.Code.Cancel);
        r7.b("cert plugin load canceled");
        Unit r1 = Unit.INSTANCE;
        r6.finishWithResult(r7);
        return;
    L6:
        s1 r8 = this.a;
        LiveTryLoadCertPluginResultModel r9 = new LiveTryLoadCertPluginResultModel();
        r9.a(LiveTryLoadCertPluginResultModel.Code.Failed);
        r9.b("cert plugin load failed");
        Unit r10 = Unit.INSTANCE;
        r8.finishWithResult(r9);
    }
}
