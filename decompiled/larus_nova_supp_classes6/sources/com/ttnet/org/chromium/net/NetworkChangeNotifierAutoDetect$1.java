package com.ttnet.org.chromium.net;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NetworkChangeNotifierAutoDetect$1 implements Runnable {
    final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$1__run$___twin___() {
        if (NetworkChangeNotifierAutoDetect.access$1100(this.this$0) == false) goto L6;
        NetworkChangeNotifierAutoDetect.access$1102(this.this$0, false);
        return;
    L6:
        NetworkChangeNotifierAutoDetect.access$400(this.this$0);
    }

    public NetworkChangeNotifierAutoDetect$1(NetworkChangeNotifierAutoDetect r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$1_com_larus_apm_impl_protector_RunnableLancet_run(NetworkChangeNotifierAutoDetect$1 r1) {
        r1.com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
