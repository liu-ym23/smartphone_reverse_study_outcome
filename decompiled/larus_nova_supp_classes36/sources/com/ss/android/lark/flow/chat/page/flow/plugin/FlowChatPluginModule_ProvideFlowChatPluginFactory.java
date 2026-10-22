package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatPluginModule_ProvideFlowChatPluginFactory implements Factory<PagePlugin> {

    public static final class a {
        public static final FlowChatPluginModule_ProvideFlowChatPluginFactory a = null;

        static {
            a = new FlowChatPluginModule_ProvideFlowChatPluginFactory();
        }
    }

    public FlowChatPluginModule_ProvideFlowChatPluginFactory() {
    }

    public static PagePlugin provideFlowChatPlugin() {
        int r0 = d.a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(FlowChatPluginModule$provideFlowChatPlugin$1.INSTANCE));
    }

    public PagePlugin get() {
        return provideFlowChatPlugin();
    }

    public static FlowChatPluginModule_ProvideFlowChatPluginFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m127get() {
        return get();
    }
}
