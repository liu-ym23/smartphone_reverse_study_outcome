package com.ss.android.lark.officesdk.miaoda.impl;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MiaodaPrewarmCapacityImpl_Factory implements Factory<a> {
    private final Provider<l> rustClientProvider;

    public a get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m155get() {
        return get();
    }

    public MiaodaPrewarmCapacityImpl_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static MiaodaPrewarmCapacityImpl_Factory create(Provider<l> r1) {
        return new MiaodaPrewarmCapacityImpl_Factory(r1);
    }

    public static a newInstance(l r1) {
        return new a(r1);
    }
}
