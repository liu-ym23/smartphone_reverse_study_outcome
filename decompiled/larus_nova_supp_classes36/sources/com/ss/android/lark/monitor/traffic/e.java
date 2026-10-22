package com.ss.android.lark.monitor.traffic;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.TakeTrafficDataRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ RustSdkTrafficHandler a;

    @Override // java.lang.Runnable
    public final void run() {
        RustSdkTrafficHandler.RustSDKTrafficCallback r0 = this.a.d;     // Catch: Throwable -> L6
        if (((com.ss.android.lark.monitor.c) ClaymoreServiceLoader.loadFirst(com.ss.android.lark.monitor.c.class)).isLogin() == false) goto L9;
        com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b r1 = com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.b.a;     // Catch: Throwable -> L6
        TakeTrafficDataRequest.Builder r2 = new TakeTrafficDataRequest.Builder();     // Catch: Throwable -> L6
        Log.i("AppStateSyncService", "start async take SdkTraffic data");     // Catch: Throwable -> L6
        SdkSender.asynSendRequestNonWrap(Command.TAKE_TRAFFIC_DATA, r2, r0, new com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.c());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public e(RustSdkTrafficHandler r1) {
        this.a = r1;
    }
}
