package com.bytedance.android.live.browser.jsbridge.upload;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.GetPictureResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w<TTaskResult, TContinuationResult> implements Continuation {
    public final /* synthetic */ x a;
    public final /* synthetic */ String b;

    public w(x r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object then(Task r6) {
        x r0 = this.a;
        GetPictureResultModel r1 = new GetPictureResultModel();
        GetPictureResultModel.a r2 = new GetPictureResultModel.a();
        r2.b("file://" + this.b);
        r2.a("data:image/png;base64," + ((String) r6.getResult()));
        Unit r7 = Unit.INSTANCE;
        r1.a(r2);
        r0.finishWithResult(r1);
        return Unit.INSTANCE;
    }
}
