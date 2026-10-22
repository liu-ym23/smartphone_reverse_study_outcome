package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaserConcurrentImpl;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

/* JADX INFO: loaded from: classes2.dex */
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImagePipeline f7739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PipelineDraweeControllerFactory f7740c;

    public PipelineDraweeControllerBuilderSupplier(Context r5, ImagePipelineFactory r10) {
        this.f7738a = r5;
        ImagePipeline r11 = r10.e();
        this.f7739b = r11;
        PipelineDraweeControllerFactory r12 = new PipelineDraweeControllerFactory();
        this.f7740c = r12;
        Resources r13 = r5.getResources();
        monitor-enter(DeferredReleaser.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (DeferredReleaser.f7750a != null) goto L9;
        DeferredReleaser.f7750a = new DeferredReleaserConcurrentImpl();     // Catch: Throwable -> L7
    L9:
        DeferredReleaserConcurrentImpl r14 = DeferredReleaser.f7750a;     // Catch: Throwable -> L7
        monitor-exit(DeferredReleaser.class);     // Catch: Throwable -> L7
        r10.a();
        UiThreadImmediateExecutorService r15 = UiThreadImmediateExecutorService.b();
        InstrumentedMemoryCache r16 = r11.e;
        r12.f7741a = r13;
        r12.f7742b = r14;
        r12.f7743c = r15;
        r12.d = r16;
    }

    public final PipelineDraweeControllerBuilder a() {
        return new PipelineDraweeControllerBuilder(this.f7738a, this.f7740c, this.f7739b);
    }

    @Override // com.facebook.common.internal.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return a();
    }
}
