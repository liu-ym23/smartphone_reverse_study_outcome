package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        SelectMediaResultModel r0 = new SelectMediaResultModel();
        r0.a(SelectMediaResultModel.Code.Success);
        SelectMediaResultModel.a r1 = new SelectMediaResultModel.a();
        r0.b(r1);
        r1.a((List) r3);
        this.a.finishWithResult(r0);
    }
}
