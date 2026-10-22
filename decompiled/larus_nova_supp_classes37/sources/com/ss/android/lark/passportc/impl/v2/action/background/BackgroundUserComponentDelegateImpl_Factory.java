package com.ss.android.lark.passportc.impl.v2.action.background;

import com.ss.android.lark.passportc.internal.y;
import com.ss.android.lark.passportc.task.g;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BackgroundUserComponentDelegateImpl_Factory implements Factory<a> {
    private final Provider<g> taskOrderProvider;
    private final Provider<y> userComponentManagerProvider;

    public a get() {
        return newInstance((y) this.userComponentManagerProvider.get(), (g) this.taskOrderProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m711get() {
        return get();
    }

    public BackgroundUserComponentDelegateImpl_Factory(Provider<y> r1, Provider<g> r2) {
        this.userComponentManagerProvider = r1;
        this.taskOrderProvider = r2;
    }

    public static BackgroundUserComponentDelegateImpl_Factory create(Provider<y> r1, Provider<g> r2) {
        return new BackgroundUserComponentDelegateImpl_Factory(r1, r2);
    }

    public static a newInstance(y r1, g r2) {
        return new a(r1, r2);
    }
}
