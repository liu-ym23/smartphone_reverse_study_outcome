package com.suite.lark.platform.component.qrcode.di;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import soc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class QRCodeHandlerProvider_Factory implements Factory<c> {
    private final Provider<Set<dxa.c>> interceptorsProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m1735get() {
        return newInstance((Set) this.interceptorsProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1735get();
    }

    public QRCodeHandlerProvider_Factory(Provider<Set<dxa.c>> r1) {
        this.interceptorsProvider = r1;
    }

    public static QRCodeHandlerProvider_Factory create(Provider<Set<dxa.c>> r1) {
        return new QRCodeHandlerProvider_Factory(r1);
    }

    public static c newInstance(Set<dxa.c> r1) {
        return new c(r1);
    }
}
