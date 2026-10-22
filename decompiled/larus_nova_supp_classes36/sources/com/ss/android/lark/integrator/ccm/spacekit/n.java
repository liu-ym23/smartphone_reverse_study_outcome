package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements Consumer<Throwable> {
    public final /* synthetic */ IGetDataCallback a;

    public n(IGetDataCallback r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        Throwable r5 = (Throwable) r4;
        IGetDataCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(new ErrorResult(new Exception(r5)));
        return;
    }
}
