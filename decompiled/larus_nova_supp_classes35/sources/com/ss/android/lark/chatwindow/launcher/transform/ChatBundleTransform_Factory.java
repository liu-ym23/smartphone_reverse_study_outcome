package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatBundleTransform_Factory implements Factory<ChatBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    public ChatBundleTransform get() {
        return newInstance((b) this.chatLaunchServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m736get() {
        return get();
    }

    public ChatBundleTransform_Factory(Provider<b> r1) {
        this.chatLaunchServiceProvider = r1;
    }

    public static ChatBundleTransform_Factory create(Provider<b> r1) {
        return new ChatBundleTransform_Factory(r1);
    }

    public static ChatBundleTransform newInstance(b r1) {
        return new ChatBundleTransform(r1);
    }
}
