package com.bytedance.frameworks.baselib.network.b;

import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.asynctask.b;
import com.bytedance.retrofit2.AsyncLogReporter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements AsyncLogReporter {
    public a() {
    }

    @Override // com.bytedance.retrofit2.AsyncLogReporter
    public void postDelayed(Runnable r9, final long r10) {
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.memorydata.plugin");
        final long r4 = 0;
        b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass1(this, r10, r4, r6));
    }
}
