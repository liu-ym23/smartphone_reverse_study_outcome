package com.ss.android.lark.integrator.im.urlpreview;

import com.ss.android.lark.chat.preview.service.d;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import fnb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UrlPreviewModuleExport_Factory implements Factory<a> {
    private final Provider<d> lazeUrlPreviewPushProvider;
    private final Provider<UrlPreviewService> lazeUrlPreviewServiceProvider;

    public a get() {
        return newInstance(DoubleCheck.lazy(this.lazeUrlPreviewServiceProvider), DoubleCheck.lazy(this.lazeUrlPreviewPushProvider));
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m929get() {
        return get();
    }

    public UrlPreviewModuleExport_Factory(Provider<UrlPreviewService> r1, Provider<d> r2) {
        this.lazeUrlPreviewServiceProvider = r1;
        this.lazeUrlPreviewPushProvider = r2;
    }

    public static UrlPreviewModuleExport_Factory create(Provider<UrlPreviewService> r1, Provider<d> r2) {
        return new UrlPreviewModuleExport_Factory(r1, r2);
    }

    public static a newInstance(Lazy<UrlPreviewService> r1, Lazy<d> r2) {
        return new a(r1, r2);
    }
}
