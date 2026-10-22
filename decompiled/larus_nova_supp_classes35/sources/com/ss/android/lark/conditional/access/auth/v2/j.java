package com.ss.android.lark.conditional.access.auth.v2;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public final int a;
    public final String b;
    public final ScheduledExecutorService c;

    public final synchronized x4c.g a() {
        monitor-enter(this);
        x4c.g r3 = new x4c.g(LarkContext.getApplication(), "im_read_" + this.b, this.a);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public j(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        this.a = r2;
        this.b = r3;
        this.c = CoreThreadPool.getDefault().getSingleScheduledThreadPool("im_read_pc_cache");
    }
}
