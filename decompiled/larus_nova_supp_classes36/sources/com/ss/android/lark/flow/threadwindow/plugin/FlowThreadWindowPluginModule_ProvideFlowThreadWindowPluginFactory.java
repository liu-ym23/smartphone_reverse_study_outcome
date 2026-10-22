package com.ss.android.lark.flow.threadwindow.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory implements Factory<PagePlugin> {

    public static final class a {
        public static final FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory a = null;

        static {
            a = new FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory();
        }
    }

    public FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory() {
    }

    public static PagePlugin provideFlowThreadWindowPlugin() {
        int r0 = i.a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(FlowThreadWindowPluginModule$provideFlowThreadWindowPlugin$1.INSTANCE));
    }

    public PagePlugin get() {
        return provideFlowThreadWindowPlugin();
    }

    public static FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m539get() {
        return get();
    }
}
