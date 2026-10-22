package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T>, IMetricsCollect {
        final Executor callbackExecutor;
        final Call<T> delegate;

        public ExecutorCallbackCall(Executor r8, Call<T> r10) {
            this.callbackExecutor = r8;
            this.delegate = r10;
        }

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // com.bytedance.retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        @Override // com.bytedance.retrofit2.IMetricsCollect
        public void doCollect() {
            Call<T> r8 = this.delegate;
            if ((r8 instanceof IMetricsCollect) == false) goto L6;
            ((IMetricsCollect) r8).doCollect();
            return;
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(final Callback<T> r8) {
            if (r8 == null) goto L6;
            this.delegate.enqueue(new AnonymousClass1(this, r8));
            return;
        L6:
            throw new NullPointerException("callback == null");
        }

        @Override // com.bytedance.retrofit2.Call
        public SsResponse execute() {
            return this.delegate.execute();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // com.bytedance.retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        public boolean setThrottleNetSpeed(long r8) {
            Call<T> r10 = this.delegate;
            if ((r10 instanceof SsHttpCall) == true) goto L5;
            return false;
        L5:
            return ((SsHttpCall) r10).setThrottleNetSpeed(r8);
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m4clone() {
            return clone();
        }
    }

    public ExecutorCallAdapterFactory(Executor r8) {
        this.callbackExecutor = r8;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<Call<?>> get(Type r8, Annotation[] r10, Retrofit r11) {
        if (CallAdapter.Factory.getRawType(r8) == Call.class) goto L6;
        return null;
    L6:
        final Type r12 = Utils.getCallResponseType(r8);
        return new AnonymousClass1(this, r12);
    }
}
