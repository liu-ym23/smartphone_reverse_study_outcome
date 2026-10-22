package com.ss.android.lark.reaction.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReactionHiltModule_ProvideReactionServiceFactory implements Factory<m2c.b> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public m2c.b m3465get() {
        return provideReactionService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m3465get();
    }

    public ReactionHiltModule_ProvideReactionServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static ReactionHiltModule_ProvideReactionServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new ReactionHiltModule_ProvideReactionServiceFactory(r1, r2);
    }

    public static m2c.b provideReactionService(j r1, v r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        c r3 = new c(r1, r2);
        h.a(r3);
        return (m2c.b) Preconditions.checkNotNullFromProvides(r3);
    }
}
