package com.ss.android.lark.officesdk.container;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKGlobalComponentManagerImpl_Factory implements Factory<OfficeSDKGlobalComponentManagerImpl> {
    private final Provider<OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder> builderProvider;

    public OfficeSDKGlobalComponentManagerImpl get() {
        return newInstance((OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder) this.builderProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m37get() {
        return get();
    }

    public OfficeSDKGlobalComponentManagerImpl_Factory(Provider<OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder> r1) {
        this.builderProvider = r1;
    }

    public static OfficeSDKGlobalComponentManagerImpl_Factory create(Provider<OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder> r1) {
        return new OfficeSDKGlobalComponentManagerImpl_Factory(r1);
    }

    public static OfficeSDKGlobalComponentManagerImpl newInstance(OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder r1) {
        return new OfficeSDKGlobalComponentManagerImpl(r1);
    }
}
