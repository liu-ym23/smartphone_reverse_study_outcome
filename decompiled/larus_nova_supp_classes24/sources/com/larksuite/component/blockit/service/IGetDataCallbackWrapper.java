package com.larksuite.component.blockit.service;

import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface IGetDataCallbackWrapper<Data> extends IGetDataCallback<Data> {

    /* JADX INFO: renamed from: com.larksuite.component.blockit.service.IGetDataCallbackWrapper$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<Data> {
        public static void $default$onSuccess(IGetDataCallbackWrapper r4, Object r5) {
            r4.onSuccess(r5, new a(false, 0));
        }
    }

    public static class a {
        public final boolean a;
        public final long b;

        public a(boolean r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    void onSuccess(Data r1);

    void onSuccess(Data r1, a r2);
}
