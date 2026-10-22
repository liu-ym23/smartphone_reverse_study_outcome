package com.ss.android.socialbase.downloader.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f15448b;
    private final boolean c;

    public a(String r2, boolean r3) {
        this.f15448b = new AtomicInteger();
        this.f15447a = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        Thread r1 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"), this.f15447a + "-" + this.f15448b.incrementAndGet());
        if (this.c == false) goto L5;
    L10:
        return r1;
    L5:
        if (r1.isDaemon() == false) goto L8;
        r1.setDaemon(false);
    L8:
        if (r1.getPriority() == 5) goto L10;
        r1.setPriority(5);
        goto L10
    }
}
