package com.ss.android.lark.newemoji.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import rsb.a;
import vsb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EmojiHiltModule_ProvideEmojiMapManagerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m1513get() {
        return provideEmojiMapManager((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1513get();
    }

    public EmojiHiltModule_ProvideEmojiMapManagerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static EmojiHiltModule_ProvideEmojiMapManagerFactory create(Provider<j> r1, Provider<v> r2) {
        return new EmojiHiltModule_ProvideEmojiMapManagerFactory(r1, r2);
    }

    public static a provideEmojiMapManager(j r1, v r2) {
        int r0 = vsb.a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        c r3 = new c(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
