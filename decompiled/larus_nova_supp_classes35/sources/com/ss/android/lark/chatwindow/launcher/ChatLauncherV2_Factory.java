package com.ss.android.lark.chatwindow.launcher;

import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatLauncherV2_Factory implements Factory<ChatLauncherV2> {
    private final Provider<m> passportProvider;
    private final Provider<Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>>> startersProvider;
    private final Provider<Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>>> transformersProvider;

    public ChatLauncherV2 get() {
        return newInstance((m) this.passportProvider.get(), (Map) this.transformersProvider.get(), (Map) this.startersProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m735get() {
        return get();
    }

    public ChatLauncherV2_Factory(Provider<m> r1, Provider<Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>>> r2, Provider<Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>>> r3) {
        this.passportProvider = r1;
        this.transformersProvider = r2;
        this.startersProvider = r3;
    }

    public static ChatLauncherV2_Factory create(Provider<m> r1, Provider<Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>>> r2, Provider<Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>>> r3) {
        return new ChatLauncherV2_Factory(r1, r2, r3);
    }

    public static ChatLauncherV2 newInstance(m r1, Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>> r2, Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>> r3) {
        return new ChatLauncherV2(r1, r2, r3);
    }
}
