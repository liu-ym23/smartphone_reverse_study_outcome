package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UIGetContinualDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ UIGetContinualDataCallback b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            T r0 = this.b.callback;     // Catch: Throwable -> L6
            if (r0 == 0) goto L9;
            ((IGetDataCallback) r0).onSuccess(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(UIGetContinualDataCallback r1, Object r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ErrorResult a;
        public final /* synthetic */ UIGetContinualDataCallback b;

        @Override // java.lang.Runnable
        public final void run() {
            T r0 = this.b.callback;     // Catch: Throwable -> L6
            if (r0 == 0) goto L9;
            ((IGetDataCallback) r0).onError(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(UIGetContinualDataCallback r1, ErrorResult r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public UIGetContinualDataCallback(IGetDataCallback<Data> r1) {
        super(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r2) {
        UICallbackExecutor.execute(new b(this, r2));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r2) {
        UICallbackExecutor.execute(new a(this, r2));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }
}
