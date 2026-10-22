package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    static final class ExecutorCallbackCall<T> implements Call<T>, IMetricsCollect {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor r3, Call<T> r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            Call<T> r6 = (Call) ZeusTransformUtils.wrapperContextForParams(r4, Call.class, "com.obric.memorydata.plugin");
            this.callbackExecutor = r5;
            this.delegate = r6;
        }

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // com.bytedance.retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m114clone() {
            return clone();
        }

        @Override // com.bytedance.retrofit2.IMetricsCollect
        public void doCollect() {
            if (ZeusTransformUtils.instanceOf(this.delegate, IMetricsCollect.class) == false) goto L6;
            ((IMetricsCollect) ZeusTransformUtils.preCheckCast(this.delegate, IMetricsCollect.class, "com.obric.memorydata.plugin")).doCollect();
            return;
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(Callback<T> r3) {
            final Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
            Utils.checkNotNull(r4, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(this, r4));
        }

        @Override // com.bytedance.retrofit2.Call
        @Deprecated
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

        public boolean setThrottleNetSpeed(long r3) {
            if (ZeusTransformUtils.instanceOf(this.delegate, SsHttpCall.class) == true) goto L5;
            return false;
        L5:
            return ((SsHttpCall) ZeusTransformUtils.preCheckCast(this.delegate, SsHttpCall.class, "com.obric.memorydata.plugin")).setThrottleNetSpeed(r3);
        }
    }

    ExecutorCallAdapterFactory(Executor r3) {
        this.callbackExecutor = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r3, Annotation[] r4, Retrofit r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        final Executor r1 = null;
        if (getRawType(r6) == Call.class) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L14;
        final Type r7 = Utils.getCallResponseType(r6);
        if (Utils.isAnnotationPresent(r4, SkipCallbackExecutor.class) == true) goto L12;
        r1 = this.callbackExecutor;
    L12:
        return new AnonymousClass1(this, r7, r1);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
