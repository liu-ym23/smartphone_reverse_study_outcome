package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {
        public static final MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory a = null;

        static {
            a = new MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel");
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m382get();
    }

    public static MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m382get() {
        return provide();
    }
}
