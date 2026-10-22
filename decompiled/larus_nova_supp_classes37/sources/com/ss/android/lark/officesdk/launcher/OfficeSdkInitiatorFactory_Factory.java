package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSdkInitiatorFactory_Factory implements Factory<g> {
    private final Provider<com.ss.android.lark.app.initiator.d> mainProcessInitiatorProvider;

    public g get() {
        return newInstance((com.ss.android.lark.app.initiator.d) this.mainProcessInitiatorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m138get() {
        return get();
    }

    public OfficeSdkInitiatorFactory_Factory(Provider<com.ss.android.lark.app.initiator.d> r1) {
        this.mainProcessInitiatorProvider = r1;
    }

    public static OfficeSdkInitiatorFactory_Factory create(Provider<com.ss.android.lark.app.initiator.d> r1) {
        return new OfficeSdkInitiatorFactory_Factory(r1);
    }

    public static g newInstance(com.ss.android.lark.app.initiator.d r1) {
        return new g(r1);
    }
}
