package com.ss.android.lark.chameleonv2.lkapi.usercomponent;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import q1b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LkApiUserComponentImpl_Factory implements Factory<c> {
    private final Provider<m> pProvider;
    private final Provider<l> rProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m75get() {
        return newInstance((m) this.pProvider.get(), (l) this.rProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m75get();
    }

    public LkApiUserComponentImpl_Factory(Provider<m> r1, Provider<l> r2) {
        this.pProvider = r1;
        this.rProvider = r2;
    }

    public static LkApiUserComponentImpl_Factory create(Provider<m> r1, Provider<l> r2) {
        return new LkApiUserComponentImpl_Factory(r1, r2);
    }

    public static c newInstance(m r1, l r2) {
        return new c(r1, r2);
    }
}
