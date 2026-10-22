package com.bytedance.ttnet.utils;

import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.retrofit2.Call;
import java.net.URI;
import lx5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RetrofitUtils$1 implements d {
    final /* synthetic */ Call val$finalCall;
    final /* synthetic */ String val$url;

    public void abort() {
        Call r0 = this.val$finalCall;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.cancel();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public URI getURI() {
        return l.b(this.val$url);
    L4:
        return null;
    }

    public RetrofitUtils$1(String r1, Call r2) {
        this.val$url = r1;
        this.val$finalCall = r2;
    }
}
