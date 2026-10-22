package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements Consumer<Throwable> {
    public final /* synthetic */ IGetDataCallback a;

    public k(IGetDataCallback r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        this.a.onError(new ErrorResult(new Exception((Throwable) r4)));
    }
}
