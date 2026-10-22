package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UIDelayContinualGetDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {
    private int mDelayTime;
    private long mStartTime;

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ UIDelayContinualGetDataCallback b;

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

        public a(UIDelayContinualGetDataCallback r1, Object r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ErrorResult a;
        public final /* synthetic */ UIDelayContinualGetDataCallback b;

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

        public b(UIDelayContinualGetDataCallback r1, ErrorResult r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r5) {
        long r0 = System.currentTimeMillis() - this.mStartTime;
        long r1 = Math.max(((long) this.mDelayTime) - r0, 0);
        UICallbackExecutor.executeDelayed(new b(this, r5), r1);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r5) {
        long r0 = System.currentTimeMillis() - this.mStartTime;
        long r1 = Math.max(((long) this.mDelayTime) - r0, 0);
        UICallbackExecutor.executeDelayed(new a(this, r5), r1);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }

    public UIDelayContinualGetDataCallback(IGetDataCallback<Data> r3, int r4) {
        super(r3);
        this.mStartTime = System.currentTimeMillis();
        this.mDelayTime = r4;
    }
}
