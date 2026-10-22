package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z extends p {
    public z(BlockingQueue r9, n r10) {
        super("reject", 3, 3, 10, r9, r10);
        allowCoreThreadTimeOut(true);
        this.b = this.a + "-CPUExecutor";
    }
}
