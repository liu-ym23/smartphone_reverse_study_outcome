package com.bytedance.android.live.saas.middleware.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/base/IFunction;", "T", "C", "", "getImpl", "()Ljava/lang/Object;", "getTask", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface IFunction<T, C> {
    T getImpl();

    ISdkInitTask<C> getTask();
}
