package com.ss.android.lark.flow.mergeforward.page.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MergeForwardPluginModule_ProvideMergeForwardPluginFactory implements Factory<PagePlugin> {

    public static final class a {
        public static final MergeForwardPluginModule_ProvideMergeForwardPluginFactory a = null;

        static {
            a = new MergeForwardPluginModule_ProvideMergeForwardPluginFactory();
        }
    }

    public MergeForwardPluginModule_ProvideMergeForwardPluginFactory() {
    }

    public static PagePlugin provideMergeForwardPlugin() {
        int r0 = b.a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(MergeForwardPluginModule$provideMergeForwardPlugin$1.INSTANCE));
    }

    public PagePlugin get() {
        return provideMergeForwardPlugin();
    }

    public static MergeForwardPluginModule_ProvideMergeForwardPluginFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m460get() {
        return get();
    }
}
