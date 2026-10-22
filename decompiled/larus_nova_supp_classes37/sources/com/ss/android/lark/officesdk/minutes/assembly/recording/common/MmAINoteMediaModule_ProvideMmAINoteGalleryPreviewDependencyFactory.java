package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory implements Factory<com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b> {
    private final d module;

    public com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b get() {
        return provideMmAINoteGalleryPreviewDependency(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m163get() {
        return get();
    }

    public MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory(d r1) {
        this.module = r1;
    }

    public static MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory create(d r1) {
        return new MmAINoteMediaModule_ProvideMmAINoteGalleryPreviewDependencyFactory(r1);
    }

    public static com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b provideMmAINoteGalleryPreviewDependency(d r1) {
        r1.getClass();
        String r2 = OfficeSDKManager.getCurrentUid();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Object r3 = (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) OfficeSDKManager.getHostUserService(r2, com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b.class);
        if (r3 != null) goto L9;
        r3 = new c();
    L9:
        return (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) Preconditions.checkNotNullFromProvides(r3);
    }
}
