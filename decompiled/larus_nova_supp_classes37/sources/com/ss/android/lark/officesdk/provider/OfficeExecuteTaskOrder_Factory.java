package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import nwb.b;
import nwb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeExecuteTaskOrder_Factory implements Factory<f> {
    private final Provider<Set<b>> taskOrderInjectorsProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public f m548get() {
        return newInstance((Set) this.taskOrderInjectorsProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m548get();
    }

    public OfficeExecuteTaskOrder_Factory(Provider<Set<b>> r1) {
        this.taskOrderInjectorsProvider = r1;
    }

    public static OfficeExecuteTaskOrder_Factory create(Provider<Set<b>> r1) {
        return new OfficeExecuteTaskOrder_Factory(r1);
    }

    public static f newInstance(Set<b> r1) {
        return new f(r1);
    }
}
