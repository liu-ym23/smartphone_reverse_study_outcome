package com.bytedance.apm.l;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f1405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Runnable> f1406b;

    public d(String r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        BlockingQueue<Runnable> r0 = new LinkedTransferQueue();
    L6:
        this.f1406b = r0;
        this.f1405a = new Thread(new AnonymousClass1(this), r3);
        return;
    L5:
        r0 = new LinkedBlockingQueue();
        goto L6
    }

    static /* synthetic */ BlockingQueue a(d r0) {
        return r0.f1406b;
    }

    public void a() {
        this.f1405a.start();
    }

    public final boolean a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return this.f1406b.offer(r4);
    }
}
