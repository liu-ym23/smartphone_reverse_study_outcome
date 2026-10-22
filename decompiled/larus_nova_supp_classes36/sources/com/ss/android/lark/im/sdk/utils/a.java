package com.ss.android.lark.im.sdk.utils;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ IGetDataCallback<T> a;

    public a(IGetDataCallback<T> r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        IGetDataCallback<T> r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }
}
