package com.ss.android.common.applog;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AppLog$a extends PthreadThreadV2 {
    public final /* synthetic */ String v;
    public final /* synthetic */ boolean w;
    public final /* synthetic */ AppLog x;

    public final void run() {
        this.x.M(this.v, this.w);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AppLog$a(AppLog r1, String r2, boolean r3, long r4) {
        this.x = r1;
        this.v = r2;
        this.w = r3;
        super("plog/AppLog$2");
    }
}
