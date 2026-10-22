package com.ss.android.lark.flow.chat;

import com.ss.android.lark.chatwindow.launcher.c;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatModule_Factory implements Factory<FlowChatModule> {
    private final Provider<c> chatLauncherV2Provider;
    private final Provider<uza.a> officeSDKSharePanelProvider;

    public FlowChatModule get() {
        FlowChatModule r0 = newInstance((c) this.chatLauncherV2Provider.get());
        r0.b = (uza.a) this.officeSDKSharePanelProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m25get() {
        return get();
    }

    public static FlowChatModule newInstance(c r1) {
        return new FlowChatModule(r1);
    }

    public FlowChatModule_Factory(Provider<c> r1, Provider<uza.a> r2) {
        this.chatLauncherV2Provider = r1;
        this.officeSDKSharePanelProvider = r2;
    }

    public static FlowChatModule_Factory create(Provider<c> r1, Provider<uza.a> r2) {
        return new FlowChatModule_Factory(r1, r2);
    }
}
