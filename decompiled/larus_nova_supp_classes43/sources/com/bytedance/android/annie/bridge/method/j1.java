package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j1<T> implements Consumer {
    public final /* synthetic */ n1 a;

    public j1(n1 r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        n1 r0 = this.a;
        PreloadResourceResultModel r1 = new PreloadResourceResultModel();
        r1.a(PreloadResourceResultModel.Code.Failed);
        r1.b(((Throwable) r10).getMessage());
        r0.finishWithResult(r1);
    }
}
