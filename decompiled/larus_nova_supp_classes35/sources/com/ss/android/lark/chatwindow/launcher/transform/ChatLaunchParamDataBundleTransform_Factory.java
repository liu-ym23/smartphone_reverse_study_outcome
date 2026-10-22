package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatLaunchParamDataBundleTransform_Factory implements Factory<ChatLaunchParamDataBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    public ChatLaunchParamDataBundleTransform get() {
        return newInstance((b) this.chatLaunchServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m738get() {
        return get();
    }

    public ChatLaunchParamDataBundleTransform_Factory(Provider<b> r1) {
        this.chatLaunchServiceProvider = r1;
    }

    public static ChatLaunchParamDataBundleTransform_Factory create(Provider<b> r1) {
        return new ChatLaunchParamDataBundleTransform_Factory(r1);
    }

    public static ChatLaunchParamDataBundleTransform newInstance(b r1) {
        return new ChatLaunchParamDataBundleTransform(r1);
    }
}
