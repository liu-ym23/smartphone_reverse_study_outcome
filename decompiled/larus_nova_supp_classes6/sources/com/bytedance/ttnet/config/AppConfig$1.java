package com.bytedance.ttnet.config;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AppConfig$1 extends ThreadPlus {
    final /* synthetic */ AppConfig this$0;

    public void run() {
        com_bytedance_ttnet_config_AppConfig$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_config_AppConfig$1__run$___twin___() {
        this.this$0.tryLoadDomainConfig4OtherProcess();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_config_AppConfig$1_com_larus_apm_impl_protector_RunnableLancet_run(AppConfig$1 r1) {
        r1.com_bytedance_ttnet_config_AppConfig$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AppConfig$1(AppConfig r1, String r2) {
        this.this$0 = r1;
        super(r2);
    }
}
