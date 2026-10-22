package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatIdBundleTransform_Factory implements Factory<ChatIdBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    public ChatIdBundleTransform get() {
        return newInstance((b) this.chatLaunchServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m737get() {
        return get();
    }

    public ChatIdBundleTransform_Factory(Provider<b> r1) {
        this.chatLaunchServiceProvider = r1;
    }

    public static ChatIdBundleTransform_Factory create(Provider<b> r1) {
        return new ChatIdBundleTransform_Factory(r1);
    }

    public static ChatIdBundleTransform newInstance(b r1) {
        return new ChatIdBundleTransform(r1);
    }
}
