package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ t1 b;

    public /* synthetic */ q1(String r1, t1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        t1 r1 = this.b;
        FLogger.a.i("NestedFileView", "[removeUplinkProgressObserver] localMessageId:" + r0);
        NestedFileCacheManagerService.b.g(r0).removeObserver(r1.s);
    }
}
