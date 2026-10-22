package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.key;

import dagger.internal.Factory;
import v3b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatDataPreloadKeyProviderV2_Factory implements Factory<b> {

    public static final class a {
        public static final ChatDataPreloadKeyProviderV2_Factory a = null;

        static {
            a = new ChatDataPreloadKeyProviderV2_Factory();
        }
    }

    public ChatDataPreloadKeyProviderV2_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m326get();
    }

    public static ChatDataPreloadKeyProviderV2_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m326get() {
        return newInstance();
    }
}
