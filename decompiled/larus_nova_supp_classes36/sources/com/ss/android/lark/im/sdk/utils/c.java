package com.ss.android.lark.im.sdk.utils;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ IGetDataCallback<Void> a;

    public c(IGetDataCallback<Void> r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        IGetDataCallback<Void> r3 = this.a;
        if (r3 == null) goto L6;
        r3.onSuccess(null);
        return;
    }
}
