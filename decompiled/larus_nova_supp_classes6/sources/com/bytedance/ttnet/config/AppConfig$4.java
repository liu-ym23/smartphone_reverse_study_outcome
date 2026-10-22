package com.bytedance.ttnet.config;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AppConfig$4 extends ThreadPlus {
    final /* synthetic */ AppConfig this$0;
    final /* synthetic */ Map val$providerMap;

    public void run() {
        com_bytedance_ttnet_config_AppConfig$4_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_config_AppConfig$4__run$___twin___() {
        TTNetInit.getTTNetDepend().saveMapToProvider(AppConfig.access$000(this.this$0), this.val$providerMap);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_config_AppConfig$4_com_larus_apm_impl_protector_RunnableLancet_run(AppConfig$4 r1) {
        r1.com_bytedance_ttnet_config_AppConfig$4__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AppConfig$4(AppConfig r1, String r2, Map r3) {
        this.this$0 = r1;
        this.val$providerMap = r3;
        super(r2);
    }
}
