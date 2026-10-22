package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowOnlineNotificationController_Factory implements Factory<e> {
    private final Provider<m> passportServiceProvider;

    public e get() {
        return newInstance((m) this.passportServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m466get() {
        return get();
    }

    public FlowOnlineNotificationController_Factory(Provider<m> r1) {
        this.passportServiceProvider = r1;
    }

    public static FlowOnlineNotificationController_Factory create(Provider<m> r1) {
        return new FlowOnlineNotificationController_Factory(r1);
    }

    public static e newInstance(m r1) {
        return new e(r1);
    }
}
