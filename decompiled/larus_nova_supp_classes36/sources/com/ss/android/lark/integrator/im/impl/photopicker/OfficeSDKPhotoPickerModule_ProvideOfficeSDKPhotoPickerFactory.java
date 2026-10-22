package com.ss.android.lark.integrator.im.impl.photopicker;

import anb.b;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import rza.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory implements Factory<a> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m919get() {
        return provideOfficeSDKPhotoPicker(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m919get();
    }

    public OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory(b r1) {
        this.module = r1;
    }

    public static OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory create(b r1) {
        return new OfficeSDKPhotoPickerModule_ProvideOfficeSDKPhotoPickerFactory(r1);
    }

    public static a provideOfficeSDKPhotoPicker(b r0) {
        r0.getClass();
        Object r1 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r1 != null) goto L6;
        r1 = new anb.a();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
