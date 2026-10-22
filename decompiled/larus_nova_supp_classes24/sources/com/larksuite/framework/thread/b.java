package com.larksuite.framework.thread;

import com.larksuite.component.ui.toast.LKUIToast;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends p {
    public static final int j = 0;
    public static final int k = 0;
    public long h;
    public long i;

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        j = r0;
        k = r0 + 3;
    }

    public b(String r9, int r10, int r11, BlockingQueue<Runnable> r12, n r13) {
        super(r9, r10, r11, 30, r12, r13);
        this.h = LKUIToast.DURATION_SHORT;
        this.i = 1000;
        this.b = this.a + "-CPUExecutor";
        this.h = LKUIToast.DURATION_SHORT;
        this.i = 1000;
    }
}
