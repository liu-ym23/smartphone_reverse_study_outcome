package com.ss.android.lark.chatwindow.launcher;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatLauncherModule_ProvideChatLauncherV2Factory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public c get() {
        return provideChatLauncherV2((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m734get() {
        return get();
    }

    public ChatLauncherModule_ProvideChatLauncherV2Factory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static ChatLauncherModule_ProvideChatLauncherV2Factory create(Provider<j> r1, Provider<v> r2) {
        return new ChatLauncherModule_ProvideChatLauncherV2Factory(r1, r2);
    }

    public static c provideChatLauncherV2(j r1, v r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        h.a(r3);
        return (c) Preconditions.checkNotNullFromProvides(r3);
    }
}
