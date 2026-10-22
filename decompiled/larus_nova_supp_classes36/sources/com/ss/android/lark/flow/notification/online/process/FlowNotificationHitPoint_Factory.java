package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowNotificationHitPoint_Factory implements Factory<c> {
    private final Provider<m> passportServiceProvider;

    public c get() {
        return newInstance((m) this.passportServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m464get() {
        return get();
    }

    public FlowNotificationHitPoint_Factory(Provider<m> r1) {
        this.passportServiceProvider = r1;
    }

    public static FlowNotificationHitPoint_Factory create(Provider<m> r1) {
        return new FlowNotificationHitPoint_Factory(r1);
    }

    public static c newInstance(m r1) {
        return new c(r1);
    }
}
