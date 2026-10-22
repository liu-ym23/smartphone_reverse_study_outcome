package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ConcurrentCronetSsCall a;
    public final /* synthetic */ BaseHttpRequestInfo b;
    public final /* synthetic */ BaseHttpRequestInfo c;

    public /* synthetic */ a(ConcurrentCronetSsCall r1, BaseHttpRequestInfo r2, BaseHttpRequestInfo r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentCronetSsCall.b(this.a, this.b, this.c);
    }
}
