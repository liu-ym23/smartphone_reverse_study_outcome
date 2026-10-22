package com.ss.android.lark.officesdk.feed.impl;

import android.app.Application;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DoubaoIMFeatureOpenedSyncer_Factory implements Factory<a> {
    private final Provider<Application> applicationProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    public a get() {
        return newInstance((l) this.rustClientProvider.get(), (Application) this.applicationProvider.get(), (m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m70get() {
        return get();
    }

    public DoubaoIMFeatureOpenedSyncer_Factory(Provider<l> r1, Provider<Application> r2, Provider<m> r3) {
        this.rustClientProvider = r1;
        this.applicationProvider = r2;
        this.passportProvider = r3;
    }

    public static DoubaoIMFeatureOpenedSyncer_Factory create(Provider<l> r1, Provider<Application> r2, Provider<m> r3) {
        return new DoubaoIMFeatureOpenedSyncer_Factory(r1, r2, r3);
    }

    public static a newInstance(l r1, Application r2, m r3) {
        return new a(r1, r2, r3);
    }
}
