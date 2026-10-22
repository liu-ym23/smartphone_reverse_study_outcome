package com.ss.android.lark.integrator.im.impl.page;

import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import zmb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PluginFactoryImpl_Factory implements Factory<b> {
    private final Provider<Map<PluginType, Provider<PagePlugin>>> mapProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m918get() {
        return newInstance((Map) this.mapProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m918get();
    }

    public PluginFactoryImpl_Factory(Provider<Map<PluginType, Provider<PagePlugin>>> r1) {
        this.mapProvider = r1;
    }

    public static PluginFactoryImpl_Factory create(Provider<Map<PluginType, Provider<PagePlugin>>> r1) {
        return new PluginFactoryImpl_Factory(r1);
    }

    public static b newInstance(Map<PluginType, Provider<PagePlugin>> r1) {
        return new b(r1);
    }
}
