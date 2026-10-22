package com.ss.android.lark.image;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.impl.PerfCompressPicMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Consumer<Throwable> {
    public final /* synthetic */ IGetDataCallback a;

    public h(IGetDataCallback r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        PerfCompressPicMonitor.sendCompressPicFailedToTea();
        this.a.onError(new ErrorResult(new RuntimeException((Throwable) r4)));
    }
}
