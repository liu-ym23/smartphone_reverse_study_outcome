package com.bytedance.android.ec.diff.lib.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fi.a;
import fi.b;
import gi.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ToCServiceModule_ProvideFactory implements Factory<b> {
    private final c module;

    public b get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1497get() {
        return get();
    }

    public ToCServiceModule_ProvideFactory(c r1) {
        this.module = r1;
    }

    public static ToCServiceModule_ProvideFactory create(c r1) {
        return new ToCServiceModule_ProvideFactory(r1);
    }

    public static b provideInstance(c r0) {
        return proxyProvide(r0);
    }

    public static b proxyProvide(c r1) {
        r1.getClass();
        return (b) Preconditions.checkNotNull(a.b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
