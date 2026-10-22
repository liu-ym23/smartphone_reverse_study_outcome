package com.ss.android.lark.im.sdk.utils;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ IGetDataCallback<T> a;

    public b(IGetDataCallback<T> r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        ErrorResult r7 = (Throwable) r6;
        if ((r7 instanceof ErrorResult) == false) goto L7;
        IGetDataCallback<T> r0 = this.a;
        if (r0 == null) goto L11;
        r0.onError(r7);
        return;
    L11:
        return;
    L7:
        IGetDataCallback<T> r1 = this.a;
        if (r1 == null) goto L13;
        Exception r2 = new Exception("unknown error");
        String r8 = r7.getMessage();
        ErrorResult r3 = new ErrorResult(0);
        ErrorResult.access$002(r3, -1);
        ErrorResult.access$102(r3, -9999);
        ErrorResult.access$202(r3, 0);
        ErrorResult.access$302(r3, r2);
        ErrorResult.access$402(r3, "");
        ErrorResult.access$502(r3, r8);
        ErrorResult.access$602(r3, "");
        ErrorResult.access$702(r3, "");
        ErrorResult.access$802(r3, 0);
        ErrorResult.access$902(r3, null);
        ErrorResult.access$1002(r3, null);
        ErrorResult.access$1102(r3, null);
        r1.onError(r3);
        return;
    }
}
