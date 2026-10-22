package com.ss.android.lark.integrator.im.impl.page;

import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import l3c.c;
import zmb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ConfiguratorFactoryImpl_Factory implements Factory<a> {
    private final Provider<Map<ConfiguratorType, Provider<c>>> mapProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m917get() {
        return newInstance((Map) this.mapProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m917get();
    }

    public ConfiguratorFactoryImpl_Factory(Provider<Map<ConfiguratorType, Provider<c>>> r1) {
        this.mapProvider = r1;
    }

    public static ConfiguratorFactoryImpl_Factory create(Provider<Map<ConfiguratorType, Provider<c>>> r1) {
        return new ConfiguratorFactoryImpl_Factory(r1);
    }

    public static a newInstance(Map<ConfiguratorType, Provider<c>> r1) {
        return new a(r1);
    }
}
