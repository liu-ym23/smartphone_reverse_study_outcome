package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p5 implements IHostAction.BusinessInHomeSideBarCallback {
    public final /* synthetic */ q5 a;

    public p5(q5 r1) {
        this.a = r1;
    }

    public final void onResult(boolean r2) {
        IsBizEntryInHomeSideBarResultModel r0 = new IsBizEntryInHomeSideBarResultModel();
        r0.a(Boolean.valueOf(r2));
        this.a.finishWithResult(r0);
    }
}
