package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.components.DeferredReleaserConcurrentImpl;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;

/* JADX INFO: loaded from: classes2.dex */
public class PipelineDraweeControllerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Resources f7741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DeferredReleaserConcurrentImpl f7742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UiThreadImmediateExecutorService f7743c;
    public InstrumentedMemoryCache d;

    public PipelineDraweeControllerFactory() {
    }
}
