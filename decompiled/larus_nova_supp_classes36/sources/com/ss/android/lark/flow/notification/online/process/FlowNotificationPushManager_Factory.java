package com.ss.android.lark.flow.notification.online.process;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowNotificationPushManager_Factory implements Factory<d> {
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    public d get() {
        return newInstance((m) this.passportProvider.get(), (l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m465get() {
        return get();
    }

    public FlowNotificationPushManager_Factory(Provider<m> r1, Provider<l> r2) {
        this.passportProvider = r1;
        this.rustClientProvider = r2;
    }

    public static FlowNotificationPushManager_Factory create(Provider<m> r1, Provider<l> r2) {
        return new FlowNotificationPushManager_Factory(r1, r2);
    }

    public static d newInstance(m r1, l r2) {
        return new d(r1, r2);
    }
}
