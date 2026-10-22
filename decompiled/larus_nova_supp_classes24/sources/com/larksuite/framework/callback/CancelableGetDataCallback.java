package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CancelableGetDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {
    public CancelableGetDataCallback(IGetDataCallback r1) {
        super(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r2) {
        T r0 = this.callback;
        if (r0 == 0) goto L6;
        ((IGetDataCallback) r0).onError(r2);
        cancel();
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r2) {
        T r0 = this.callback;
        if (r0 == 0) goto L6;
        ((IGetDataCallback) r0).onSuccess(r2);
        cancel();
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }
}
