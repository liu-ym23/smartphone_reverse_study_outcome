package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ ih0.h a;

    public q(ih0.h r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        ALogger.w("LynxSettingPanelHandler", "get_client_settings fail, readon=" + r5.getMessage());
        ih0.h r0 = this.a;
        UpdateLinkmicStatusResultModel.Code r1 = UpdateLinkmicStatusResultModel.Code.Failed;
        String r6 = r5.getMessage();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.a(r1, r6, null);
    }
}
