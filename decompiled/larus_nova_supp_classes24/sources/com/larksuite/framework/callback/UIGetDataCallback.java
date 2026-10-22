package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UIGetDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ UIGetDataCallback b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.b.isCanceled() == true) goto L13;
            UIGetDataCallback r0 = this.b;     // Catch: Throwable -> L10
            T r1 = r0.callback;     // Catch: Throwable -> L10
            if (r1 == 0) goto L7;
            ((IGetDataCallback) r1).onSuccess(this.a);     // Catch: Throwable -> L10
        L8:
            this.b.cancel();     // Catch: Throwable -> L10
            return;
        L7:
            r0.onSuccessed(this.a);     // Catch: Throwable -> L10
            goto L8
        }

        public a(UIGetDataCallback r1, Object r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ErrorResult a;
        public final /* synthetic */ UIGetDataCallback b;

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.b.isCanceled() == true) goto L13;
            UIGetDataCallback r0 = this.b;     // Catch: Throwable -> L10
            T r1 = r0.callback;     // Catch: Throwable -> L10
            if (r1 == 0) goto L7;
            ((IGetDataCallback) r1).onError(this.a);     // Catch: Throwable -> L10
        L8:
            this.b.cancel();     // Catch: Throwable -> L10
            return;
        L7:
            r0.onErrored(this.a);     // Catch: Throwable -> L10
            goto L8
        }

        public b(UIGetDataCallback r1, ErrorResult r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public void onErrored(ErrorResult r1) {
    }

    public void onSuccessed(Data r1) {
    }

    public UIGetDataCallback() {
    }

    public UIGetDataCallback(IGetDataCallback<Data> r1) {
        super(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public final void onError(ErrorResult r2) {
        UICallbackExecutor.execute(new b(this, r2));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public final void onSuccess(Data r2) {
        UICallbackExecutor.execute(new a(this, r2));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }
}
