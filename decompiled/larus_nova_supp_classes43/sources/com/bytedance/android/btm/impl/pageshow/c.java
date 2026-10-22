package com.bytedance.android.btm.impl.pageshow;

import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Runnable {
    public final /* synthetic */ PageInfo a;
    public final /* synthetic */ String b;

    public c(PageInfo r1) {
        this.a = r1;
        this.b = PageInfo.SCENE_KILL;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PageShowLog r0 = PageShowLog.e;     // Catch: Throwable -> L4
        PageInfo r1 = this.a;     // Catch: Throwable -> L4
        String r10 = this.b;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        PageShowLog.h(r1, r10, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
