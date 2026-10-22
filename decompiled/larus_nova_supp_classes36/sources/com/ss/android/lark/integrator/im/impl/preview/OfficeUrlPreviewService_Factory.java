package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeUrlPreviewService_Factory implements Factory<b> {
    private final Provider<com.ss.android.lark.chat.preview.service.d> urlPreviewPushProvider;
    private final Provider<UrlPreviewService> urlPreviewServiceProvider;

    public b get() {
        return newInstance(DoubleCheck.lazy(this.urlPreviewServiceProvider), DoubleCheck.lazy(this.urlPreviewPushProvider));
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m920get() {
        return get();
    }

    public OfficeUrlPreviewService_Factory(Provider<UrlPreviewService> r1, Provider<com.ss.android.lark.chat.preview.service.d> r2) {
        this.urlPreviewServiceProvider = r1;
        this.urlPreviewPushProvider = r2;
    }

    public static OfficeUrlPreviewService_Factory create(Provider<UrlPreviewService> r1, Provider<com.ss.android.lark.chat.preview.service.d> r2) {
        return new OfficeUrlPreviewService_Factory(r1, r2);
    }

    public static b newInstance(Lazy<UrlPreviewService> r1, Lazy<com.ss.android.lark.chat.preview.service.d> r2) {
        return new b(r1, r2);
    }
}
