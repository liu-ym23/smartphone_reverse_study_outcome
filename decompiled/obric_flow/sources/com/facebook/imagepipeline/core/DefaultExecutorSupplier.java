package com.facebook.imagepipeline.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultExecutorSupplier implements ExecutorSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f8060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f8061c;
    public final ExecutorService d;

    public DefaultExecutorSupplier(int r5) {
        this.f8059a = Executors.newFixedThreadPool(2, new PriorityThreadFactory("FrescoIoBoundExecutor"));
        this.f8060b = Executors.newFixedThreadPool(r5, new PriorityThreadFactory("FrescoDecodeExecutor"));
        this.f8061c = Executors.newFixedThreadPool(r5, new PriorityThreadFactory("FrescoBackgroundExecutor"));
        this.d = Executors.newFixedThreadPool(1, new PriorityThreadFactory("FrescoLightWeightBackgroundExecutor"));
    }
}
