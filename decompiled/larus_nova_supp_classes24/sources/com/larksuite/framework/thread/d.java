package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends p {
    public static final int h = 0;

    static {
        h = Math.max(Runtime.getRuntime().availableProcessors() * 8, 64);
    }

    public d(BlockingQueue r9, n r10) {
        super(CoreThreadPool.DEFAULT_IO_POOLNAME, 1, h, 30, r9, r10);
        this.b = this.a + "-IOExecutor";
    }
}
