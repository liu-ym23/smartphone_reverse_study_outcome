package com.bytedance.common.wschannel;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class WsChannelMultiProcessSharedProvider$1 implements Runnable {
    final /* synthetic */ WsChannelMultiProcessSharedProvider this$0;
    final /* synthetic */ String val$key;
    final /* synthetic */ String val$type;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$1__run$___twin___() {
        WsChannelMultiProcessSharedProvider r0 = this.this$0;
        WsChannelMultiProcessSharedProvider.access$000(r0, WsChannelMultiProcessSharedProvider.getContentUri(r0.getContext(), this.val$key, this.val$type));
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$1_com_larus_apm_impl_protector_RunnableLancet_run(WsChannelMultiProcessSharedProvider$1 r1) {
        r1.com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public WsChannelMultiProcessSharedProvider$1(WsChannelMultiProcessSharedProvider r1, String r2, String r3) {
        this.this$0 = r1;
        this.val$key = r2;
        this.val$type = r3;
    }
}
