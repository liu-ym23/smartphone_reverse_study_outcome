package com.ss.android.lark.create.groupchat.impl.service;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CreateGroupErrorHandle_Factory implements Factory<b> {
    private final Provider<Map<InterceptorType, Provider<c>>> mapProvider;

    public b get() {
        return newInstance((Map) this.mapProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1115get() {
        return get();
    }

    public CreateGroupErrorHandle_Factory(Provider<Map<InterceptorType, Provider<c>>> r1) {
        this.mapProvider = r1;
    }

    public static CreateGroupErrorHandle_Factory create(Provider<Map<InterceptorType, Provider<c>>> r1) {
        return new CreateGroupErrorHandle_Factory(r1);
    }

    public static b newInstance(Map<InterceptorType, Provider<c>> r1) {
        return new b(r1);
    }
}
