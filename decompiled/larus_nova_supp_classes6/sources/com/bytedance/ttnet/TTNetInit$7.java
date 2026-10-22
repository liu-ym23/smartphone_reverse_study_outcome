package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.utils.TTReflectIOException;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTNetInit$7 extends hx5.a {
    public void run() {
        com_bytedance_ttnet_TTNetInit$7_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_TTNetInit$7__run$___twin___() {
        yx5.a.d("com.ttnet.org.chromium.net.urlconnection.SegmentPool").call("checkAndReleaseIdleSegments");     // Catch: Exception -> L8
        return;
    L5:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_TTNetInit$7_com_larus_apm_impl_protector_RunnableLancet_run(TTNetInit$7 r1) {
        r1.com_bytedance_ttnet_TTNetInit$7__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public TTNetInit$7(long r1, long r3) {
        super(r1, r3);
    }
}
