package com.ss.android.lark.flow.chat.page.flow.configurator;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMessageListConfigurator_Factory implements Factory<FlowMessageListConfigurator> {

    public static final class a {
        public static final FlowMessageListConfigurator_Factory a = null;

        static {
            a = new FlowMessageListConfigurator_Factory();
        }
    }

    public FlowMessageListConfigurator_Factory() {
    }

    public static FlowMessageListConfigurator newInstance() {
        return new FlowMessageListConfigurator();
    }

    public FlowMessageListConfigurator get() {
        return newInstance();
    }

    public static FlowMessageListConfigurator_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m126get() {
        return get();
    }
}
