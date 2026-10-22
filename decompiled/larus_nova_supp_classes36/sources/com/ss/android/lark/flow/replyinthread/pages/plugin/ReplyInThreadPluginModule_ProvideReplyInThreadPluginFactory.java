package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory implements Factory<PagePlugin> {

    public static final class a {
        public static final ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory a = null;

        static {
            a = new ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory();
        }
    }

    public ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory() {
    }

    public static PagePlugin provideReplyInThreadPlugin() {
        int r0 = n.a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(ReplyInThreadPluginModule$provideReplyInThreadPlugin$1.INSTANCE));
    }

    public PagePlugin get() {
        return provideReplyInThreadPlugin();
    }

    public static ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m501get() {
        return get();
    }
}
