package com.bytedance.retrofit2;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RetrofitMetrics$1 implements Runnable {
    final /* synthetic */ RetrofitMetrics this$0;
    final /* synthetic */ Throwable val$requestException;
    final /* synthetic */ Object val$requestInfoObj;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_retrofit2_RetrofitMetrics$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_retrofit2_RetrofitMetrics$1__run$___twin___() {
        RetrofitMetrics.access$000(this.this$0, this.val$requestInfoObj, this.val$requestException);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_retrofit2_RetrofitMetrics$1_com_larus_apm_impl_protector_RunnableLancet_run(RetrofitMetrics$1 r1) {
        r1.com_bytedance_retrofit2_RetrofitMetrics$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public RetrofitMetrics$1(RetrofitMetrics r1, Object r2, Throwable r3) {
        this.this$0 = r1;
        this.val$requestInfoObj = r2;
        this.val$requestException = r3;
    }
}
