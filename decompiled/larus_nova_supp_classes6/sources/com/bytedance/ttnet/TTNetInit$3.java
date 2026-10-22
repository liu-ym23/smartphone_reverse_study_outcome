package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.tnc.TNCManager;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTNetInit$3 extends ThreadPlus {
    final /* synthetic */ Context val$context;
    final /* synthetic */ boolean val$forceInitCookie;

    public void run() {
        com_bytedance_ttnet_TTNetInit$3_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_TTNetInit$3__run$___twin___() {
        AppConfig.getInstance(this.val$context).tryLoadLocalConfig();
        AppConfig.getInstance(this.val$context).tryRefreshConfig(TNCManager.TNCUpdateSource.TTSERVER, true);
        TTNetInit.access$200(this.val$context, false, this.val$forceInitCookie);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_TTNetInit$3_com_larus_apm_impl_protector_RunnableLancet_run(TTNetInit$3 r1) {
        r1.com_bytedance_ttnet_TTNetInit$3__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public TTNetInit$3(String r1, Context r2, boolean r3) {
        this.val$context = r2;
        this.val$forceInitCookie = r3;
        super(r1);
    }
}
