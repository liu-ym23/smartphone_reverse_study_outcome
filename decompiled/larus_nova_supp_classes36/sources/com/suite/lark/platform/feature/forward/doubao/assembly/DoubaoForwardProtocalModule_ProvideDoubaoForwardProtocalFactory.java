package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory implements Factory<mpc.e> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public mpc.e m1817get() {
        return provideDoubaoForwardProtocal(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1817get();
    }

    public DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory(b r1) {
        this.module = r1;
    }

    public static DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory create(b r1) {
        return new DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory(r1);
    }

    public static mpc.e provideDoubaoForwardProtocal(b r0) {
        r0.getClass();
        Object r1 = (mpc.e) OfficeSDKManager.getHostGlobalService(mpc.e.class);
        if (r1 != null) goto L6;
        r1 = new c();
    L6:
        return (mpc.e) Preconditions.checkNotNullFromProvides(r1);
    }
}
