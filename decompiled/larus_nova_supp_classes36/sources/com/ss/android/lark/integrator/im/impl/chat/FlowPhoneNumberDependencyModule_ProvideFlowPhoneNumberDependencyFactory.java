package com.ss.android.lark.integrator.im.impl.chat;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dza.a;
import smb.c;
import smb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory implements Factory<a> {
    private final d module;

    public a get() {
        return provideFlowPhoneNumberDependency(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m904get() {
        return get();
    }

    public FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory(d r1) {
        this.module = r1;
    }

    public static FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory create(d r1) {
        return new FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory(r1);
    }

    public static a provideFlowPhoneNumberDependency(d r0) {
        r0.getClass();
        Object r1 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r1 != null) goto L6;
        r1 = new c();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
