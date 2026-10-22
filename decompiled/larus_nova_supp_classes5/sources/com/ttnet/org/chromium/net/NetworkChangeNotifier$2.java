package com.ttnet.org.chromium.net;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class NetworkChangeNotifier$2 implements Runnable {
    final /* synthetic */ NetworkChangeNotifier this$0;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_NetworkChangeNotifier$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_NetworkChangeNotifier$2__run$___twin___() {
        NetworkChangeNotifier r0 = this.this$0;
        r0.notifyObserversOfConnectionTypeChange(NetworkChangeNotifier.access$100(r0));
    }

    public NetworkChangeNotifier$2(NetworkChangeNotifier r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier$2_com_larus_apm_impl_protector_RunnableLancet_run(NetworkChangeNotifier$2 r1) {
        r1.com_ttnet_org_chromium_net_NetworkChangeNotifier$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
