package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u<V> implements Callable {
    public final /* synthetic */ PrefetchNetworkExecutorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map<String, String> c;
    public final /* synthetic */ Map<String, String> d;
    public final /* synthetic */ t9.b e;

    public u(PrefetchNetworkExecutorImpl r1, String r10, Map<String, String> r11, Map<String, String> r12, t9.b r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.ies.tools.prefetch.i.b call() {
        PrefetchNetworkExecutorImpl r0 = this.a;
        IAnnieNetworkService r1 = (IAnnieNetworkService) Annie.getService$default(IAnnieNetworkService.class, null, 2, null);
        String r10 = this.b;
        PrefetchNetworkExecutorImpl r11 = this.a;
        Map<String, String> r12 = this.c;
        Map<String, String> r13 = this.d;
        if (this.e != null) goto L5;
        boolean r14 = true;
    L7:
        return PrefetchNetworkExecutorImpl.e(r0, r1.get(r10, PrefetchNetworkExecutorImpl.d(r11, PrefetchNetworkExecutorImpl.c(r11, r12, r13, r14))).execute(), this.b, this.d, this.e);
    L5:
        r14 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
