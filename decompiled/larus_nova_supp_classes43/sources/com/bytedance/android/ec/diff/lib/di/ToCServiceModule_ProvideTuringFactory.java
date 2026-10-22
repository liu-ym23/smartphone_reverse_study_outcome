package com.bytedance.android.ec.diff.lib.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gi.c;
import hi.a;
import hi.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ToCServiceModule_ProvideTuringFactory implements Factory<a> {
    private final c module;

    public a get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1498get() {
        return get();
    }

    public ToCServiceModule_ProvideTuringFactory(c r1) {
        this.module = r1;
    }

    public static ToCServiceModule_ProvideTuringFactory create(c r1) {
        return new ToCServiceModule_ProvideTuringFactory(r1);
    }

    public static a provideInstance(c r0) {
        return proxyProvideTuring(r0);
    }

    public static a proxyProvideTuring(c r1) {
        r1.getClass();
        return (a) Preconditions.checkNotNull(b.a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
