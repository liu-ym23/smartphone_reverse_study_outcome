package com.larksuite.framework.http.v2.internal.cookie;

import android.content.Context;
import d28.b;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarkCookiesImpl_Factory implements Factory<b> {
    private final Provider<Context> contextProvider;

    public b get() {
        return newInstance((Context) this.contextProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m317get() {
        return get();
    }

    public LarkCookiesImpl_Factory(Provider<Context> r1) {
        this.contextProvider = r1;
    }

    public static LarkCookiesImpl_Factory create(Provider<Context> r1) {
        return new LarkCookiesImpl_Factory(r1);
    }

    public static b newInstance(Context r1) {
        return new b(r1);
    }
}
