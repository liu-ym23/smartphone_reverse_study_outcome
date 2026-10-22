package com.bytedance.android.live.browser.jsbridge.newmethods;

import androidx.core.util.Consumer;
import com.bytedance.android.live.browser.jsbridge.base.ShareItemResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class lc<T> implements Consumer {
    public final /* synthetic */ mc a;

    public lc(mc r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((Boolean) r4).booleanValue() == false) goto L5;
        mc r5 = this.a;
        ShareItemResultModel r0 = new ShareItemResultModel();
        ShareItemResultModel.a r1 = new ShareItemResultModel.a();
        r1.a(Boolean.TRUE);
        Unit r2 = Unit.INSTANCE;
        r0.a(r1);
        r5.finishWithResult(r0);
        return;
    L5:
        mc r6 = this.a;
        ShareItemResultModel r3 = new ShareItemResultModel();
        ShareItemResultModel.a r7 = new ShareItemResultModel.a();
        r7.a(Boolean.FALSE);
        Unit r8 = Unit.INSTANCE;
        r3.a(r7);
        r6.finishWithResult(r3);
    }
}
