package com.ss.android.lark.integrator.im.impl.chat;

import com.ss.android.lark.biz.im.api.t;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import smb.a;
import smb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory implements Factory<t> {
    private final b module;

    public t get() {
        return provideDoubaoMergeForwardService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m903get() {
        return get();
    }

    public DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory(b r1) {
        this.module = r1;
    }

    public static DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory create(b r1) {
        return new DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory(r1);
    }

    public static t provideDoubaoMergeForwardService(b r0) {
        r0.getClass();
        return (t) Preconditions.checkNotNullFromProvides(new a());
    }
}
