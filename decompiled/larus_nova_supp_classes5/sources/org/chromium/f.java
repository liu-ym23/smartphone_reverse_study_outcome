package org.chromium;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements TTAppSecurityManager.ITTSystemApiSandbox {
    public static volatile f a;

    public static f a() {
        if (a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final String getNetworkOperator() {
        c r0 = c.h();
        r0.getClass();
        String r1 = "";
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r1;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r2 = r0.b;     // Catch: Throwable -> L14
        if (r2 == null) goto L17;
        r1 = r2.getNetworkOperator();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r3 = r0.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L17;
        r1 = (String) yx5.a.b(r3).call("getNetworkOperator").get();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final String getSimOperator() {
        c r0 = c.h();
        r0.getClass();
        String r1 = "";
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r1;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r2 = r0.b;     // Catch: Throwable -> L14
        if (r2 == null) goto L17;
        r1 = r2.getSimOperator();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r3 = r0.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L17;
        r1 = (String) yx5.a.b(r3).call("getSimOperator").get();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final int getWifiFrequency() {
        c r0 = c.h();
        r0.getClass();
        int r1 = 0;
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r1;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r2 = r0.b;     // Catch: Throwable -> L14
        if (r2 == null) goto L17;
        r1 = r2.getWifiFrequency();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r3 = r0.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L17;
        r1 = ((Integer) yx5.a.b(r3).call("getWifiFrequency").get()).intValue();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final int getWifiRssi() {
        c r0 = c.h();
        r0.getClass();
        int r1 = 0;
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r1;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r2 = r0.b;     // Catch: Throwable -> L14
        if (r2 == null) goto L17;
        r1 = r2.getWifiRssi();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r3 = r0.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L17;
        r1 = ((Integer) yx5.a.b(r3).call("getWifiRssi").get()).intValue();     // Catch: Throwable -> L14
        goto L17
    }

    public f() {
    }
}
