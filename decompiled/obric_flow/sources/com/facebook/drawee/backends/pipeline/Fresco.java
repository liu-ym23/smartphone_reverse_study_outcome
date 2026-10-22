package com.facebook.drawee.backends.pipeline;

import android.app.Application;
import android.content.Context;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.Lazy;
import com.facebook.drawee.controller.IAbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.nativecode.NativeCodeInitializer;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Fresco {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7726a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IAbstractDraweeControllerBuilder f7727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f7728c;

    /* JADX INFO: renamed from: com.facebook.drawee.backends.pipeline.Fresco$2, reason: invalid class name */
    final class AnonymousClass2 implements IAbstractDraweeControllerBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile PipelineDraweeControllerBuilderSupplier f7729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7730b;

        public AnonymousClass2(Context r5) {
            this.f7730b = r5;
            this.f7729a = null;
        }

        @Override // com.facebook.drawee.controller.IAbstractDraweeControllerBuilder
        public final PipelineDraweeControllerBuilderSupplier a() {
            if (this.f7729a != null) goto L15;
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L6:
            if (this.f7729a != null) goto L10;
            this.f7729a = new PipelineDraweeControllerBuilderSupplier(this.f7730b, (ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!"));     // Catch: Throwable -> L8
        L10:
            monitor-exit(this);     // Catch: Throwable -> L8
        L15:
            return this.f7729a;
        }
    }

    static {
        f7726a = new AnonymousClass1();
        f7728c = false;
    }

    public static ImagePipelineFactory a() {
        return (ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!");
    }

    public static void a(Application r5) {
        FrescoSystrace.a().getClass();
        if (f7728c == false) goto L5;
        FLog.a(Fresco.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
    L7:
        if (NativeLoader.a() == true) goto L35;
        FrescoSystrace.a().getClass();
        NativeCodeInitializer.class.getMethod("init", new Class[]{Context.class}).invoke(null, new Object[]{r5});     // Catch: Throwable -> L11 NoSuchMethodException -> L13 InvocationTargetException -> L18 IllegalAccessException -> L23 ClassNotFoundException -> L28
    L32:
        FrescoSystrace.a().getClass();
        goto L35
    L11:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    L28:
        NativeLoader.a(new SystemDelegate());     // Catch: Throwable -> L11 IllegalStateException -> L30
    L23:
        NativeLoader.a(new SystemDelegate());     // Catch: Throwable -> L11 IllegalStateException -> L25
    L13:
        NativeLoader.a(new SystemDelegate());     // Catch: Throwable -> L11 IllegalStateException -> L15
    L18:
        NativeLoader.a(new SystemDelegate());     // Catch: Throwable -> L11 IllegalStateException -> L20
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L35:
        Context r10 = r5.getApplicationContext();
        monitor-enter(ImagePipelineFactory.class);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L41
        ImagePipelineFactory.a(new ImagePipelineConfig(new ImagePipelineConfig.Builder(r10)));     // Catch: Throwable -> L41
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L41
        monitor-exit(ImagePipelineFactory.class);
        FrescoSystrace.a().getClass();
        AnonymousClass2 r11 = new AnonymousClass2(r10);
        f7727b = r11;
        SimpleDraweeView.initialize(r11);
        FrescoSystrace.a().getClass();
        FrescoSystrace.a().getClass();
        return;
    L41:
        th = move-exception;
        throw th;
    L5:
        f7728c = true;
        goto L7
    }
}
