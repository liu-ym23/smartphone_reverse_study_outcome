package com.ss.android.lark.flow.chat.page.starter;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;
import tgb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatStarter_Factory implements Factory<a> {
    private final Provider<d> dataPreloaderProvider;
    private final Provider<g> fgServiceProvider;
    private final Provider<UserSession> userSessionProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m147get() {
        a r0 = newInstance((g) this.fgServiceProvider.get(), (d) this.dataPreloaderProvider.get());
        r0.c = (UserSession) this.userSessionProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m147get();
    }

    public static a newInstance(g r1, d r2) {
        return new a(r1, r2);
    }

    public FlowChatStarter_Factory(Provider<g> r1, Provider<d> r2, Provider<UserSession> r3) {
        this.fgServiceProvider = r1;
        this.dataPreloaderProvider = r2;
        this.userSessionProvider = r3;
    }

    public static FlowChatStarter_Factory create(Provider<g> r1, Provider<d> r2, Provider<UserSession> r3) {
        return new FlowChatStarter_Factory(r1, r2, r3);
    }
}
