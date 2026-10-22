package com.ttnet.org.chromium.net;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NetworkChangeNotifierAutoDetect$MyNetworkCallback$3 implements Runnable {
    final /* synthetic */ NetworkChangeNotifierAutoDetect.MyNetworkCallback this$1;
    final /* synthetic */ long val$netId;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$MyNetworkCallback$3_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$MyNetworkCallback$3__run$___twin___() {
        NetworkChangeNotifierAutoDetect.access$700(this.this$1.this$0).onNetworkSoonToDisconnect(this.val$netId);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$MyNetworkCallback$3_com_larus_apm_impl_protector_RunnableLancet_run(NetworkChangeNotifierAutoDetect$MyNetworkCallback$3 r1) {
        r1.com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$MyNetworkCallback$3__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public NetworkChangeNotifierAutoDetect$MyNetworkCallback$3(NetworkChangeNotifierAutoDetect.MyNetworkCallback r1, long r2) {
        this.this$1 = r1;
        this.val$netId = r2;
    }
}
