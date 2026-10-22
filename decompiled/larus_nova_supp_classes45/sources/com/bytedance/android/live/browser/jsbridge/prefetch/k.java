package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<V> implements Callable {
    public final /* synthetic */ PrefetchNetworkExecutorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.protobuf.a e;

    public k(PrefetchNetworkExecutorImpl r1, String r2, Map r3, Map r4, com.bytedance.android.live.browser.jsbridge.protobuf.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.ies.tools.prefetch.i.b call() {
        PrefetchNetworkExecutorImpl r0 = this.a;
        INetworkService r1 = jc1.k.n(INetworkService.class);
        String r2 = this.b;
        PrefetchNetworkExecutorImpl r3 = this.a;
        Map r4 = this.c;
        Map r5 = this.d;
        if (this.e != null) goto L5;
        boolean r6 = true;
    L7:
        return PrefetchNetworkExecutorImpl.e(r0, (HttpResponse) r1.get(r2, PrefetchNetworkExecutorImpl.d(r3, PrefetchNetworkExecutorImpl.c(r3, r4, r5, r6))).execute(), this.b, this.d, this.e);
    L5:
        r6 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
