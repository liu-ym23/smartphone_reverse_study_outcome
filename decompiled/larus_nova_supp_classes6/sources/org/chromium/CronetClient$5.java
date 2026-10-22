package org.chromium;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.ttnet.org.chromium.net.UrlRequest$StatusListener;
import yx5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetClient$5 extends UrlRequest$StatusListener {
    final /* synthetic */ CronetClient this$0;
    final /* synthetic */ String val$key;

    @Override // com.ttnet.org.chromium.net.UrlRequest$StatusListener
    public void onStatus(int r9) {
        e r0 = e.a();
        String r1 = this.val$key;
        if (r0.a == false) goto L25;
        c r2 = c.h();
        r2.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r1 + " status = " + r9);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r3 = r2.b;     // Catch: Throwable -> L18
        if (r3 == null) goto L21;
        r3.onMappingRequestStatus(r1, r9);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r4 = r2.a;     // Catch: Throwable -> L18
        if (r4 == null) goto L21;
        a.b(r4).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r1, Integer.valueOf(r9)});     // Catch: Throwable -> L18
        goto L21
    }

    public CronetClient$5(CronetClient r1, String r2) {
        this.this$0 = r1;
        this.val$key = r2;
    }
}
