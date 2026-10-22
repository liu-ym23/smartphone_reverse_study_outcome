package com.ss.android.lark.integrator.im.impl.share;

import cnb.a;
import cnb.b;
import com.ss.android.lark.biz.im.api.r;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory implements Factory<r> {
    private final b module;

    public r get() {
        return provideDoubaoMergeForwardService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m923get() {
        return get();
    }

    public DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory(b r1) {
        this.module = r1;
    }

    public static DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory create(b r1) {
        return new DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory(r1);
    }

    public static r provideDoubaoMergeForwardService(b r0) {
        r0.getClass();
        Object r1 = (r) OfficeSDKManager.getHostGlobalService(r.class);
        if (r1 != null) goto L6;
        r1 = new a();
    L6:
        return (r) Preconditions.checkNotNullFromProvides(r1);
    }
}
