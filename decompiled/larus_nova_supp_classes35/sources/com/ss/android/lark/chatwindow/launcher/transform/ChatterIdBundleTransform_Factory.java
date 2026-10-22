package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatterIdBundleTransform_Factory implements Factory<ChatterIdBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    public ChatterIdBundleTransform get() {
        return newInstance((b) this.chatLaunchServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m740get() {
        return get();
    }

    public ChatterIdBundleTransform_Factory(Provider<b> r1) {
        this.chatLaunchServiceProvider = r1;
    }

    public static ChatterIdBundleTransform_Factory create(Provider<b> r1) {
        return new ChatterIdBundleTransform_Factory(r1);
    }

    public static ChatterIdBundleTransform newInstance(b r1) {
        return new ChatterIdBundleTransform(r1);
    }
}
