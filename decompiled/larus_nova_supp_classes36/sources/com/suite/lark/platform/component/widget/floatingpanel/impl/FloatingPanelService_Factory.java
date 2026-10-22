package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatingPanelService_Factory implements Factory<FloatingPanelService> {
    private final Provider<m> passportProvider;

    public FloatingPanelService get() {
        return newInstance((m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1764get() {
        return get();
    }

    public FloatingPanelService_Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static FloatingPanelService_Factory create(Provider<m> r1) {
        return new FloatingPanelService_Factory(r1);
    }

    public static FloatingPanelService newInstance(m r1) {
        return new FloatingPanelService(r1);
    }
}
