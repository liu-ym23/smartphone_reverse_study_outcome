package com.ss.android.lark.integrator.im.impl.mediapreview;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kza.d;
import wmb.a;
import wmb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory implements Factory<d> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m913get() {
        return provideOpenFeishuGalleryPreviewDependency(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m913get();
    }

    public MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory(b r1) {
        this.module = r1;
    }

    public static MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory create(b r1) {
        return new MediaPreviewModule_ProvideOpenFeishuGalleryPreviewDependencyFactory(r1);
    }

    public static d provideOpenFeishuGalleryPreviewDependency(b r0) {
        r0.getClass();
        Object r1 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r1 != null) goto L6;
        r1 = new a();
    L6:
        return (d) Preconditions.checkNotNullFromProvides(r1);
    }
}
