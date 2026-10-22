package com.bytedance.keva;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class KevaImpl$6 implements Runnable {
    final /* synthetic */ KevaImpl this$0;
    final /* synthetic */ String val$reportedKey;
    final /* synthetic */ String val$value;
    final /* synthetic */ int val$valueLength;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_keva_KevaImpl$6_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_keva_KevaImpl$6__run$___twin___() {
        KevaImpl.sMonitor.reportWarning(3, KevaImpl.access$500(this.this$0), this.val$reportedKey, this.val$value, "value too big, size=" + this.val$valueLength);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_keva_KevaImpl$6_com_larus_apm_impl_protector_RunnableLancet_run(KevaImpl$6 r1) {
        r1.com_bytedance_keva_KevaImpl$6__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public KevaImpl$6(KevaImpl r1, String r2, String r3, int r4) {
        this.this$0 = r1;
        this.val$reportedKey = r2;
        this.val$value = r3;
        this.val$valueLength = r4;
    }
}
