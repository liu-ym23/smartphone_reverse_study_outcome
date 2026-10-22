package com.suite.lark.platform.component.widget.floatingpanel.impl.integration;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import yoc.h;
import zoc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatingPanelInitTask_Factory implements Factory<b> {
    private final Provider<h> repositoryProvider;

    public static b newInstance() {
        return new b();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m1766get() {
        b r0 = newInstance();
        r0.a = DoubleCheck.lazy(this.repositoryProvider);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1766get();
    }

    public FloatingPanelInitTask_Factory(Provider<h> r1) {
        this.repositoryProvider = r1;
    }

    public static FloatingPanelInitTask_Factory create(Provider<h> r1) {
        return new FloatingPanelInitTask_Factory(r1);
    }
}
