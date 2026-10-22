package com.ss.android.lark.passportc.task;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.q;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class InitStaticUserConventionTask_Factory implements Factory<h> {
    private final Provider<Set<q>> staticConventionsProvider;
    private final Provider<m> userServiceProvider;

    public static h newInstance() {
        return new h();
    }

    public h get() {
        h r0 = newInstance();
        r0.a = (m) this.userServiceProvider.get();
        r0.b = (Set) this.staticConventionsProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m751get() {
        return get();
    }

    public InitStaticUserConventionTask_Factory(Provider<m> r1, Provider<Set<q>> r2) {
        this.userServiceProvider = r1;
        this.staticConventionsProvider = r2;
    }

    public static InitStaticUserConventionTask_Factory create(Provider<m> r1, Provider<Set<q>> r2) {
        return new InitStaticUserConventionTask_Factory(r1, r2);
    }
}
