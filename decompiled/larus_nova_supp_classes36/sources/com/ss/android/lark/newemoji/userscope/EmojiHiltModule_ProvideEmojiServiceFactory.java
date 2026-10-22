package com.ss.android.lark.newemoji.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import rsb.b;
import vsb.a;
import vsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EmojiHiltModule_ProvideEmojiServiceFactory implements Factory<b> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m1514get() {
        return provideEmojiService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1514get();
    }

    public EmojiHiltModule_ProvideEmojiServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static EmojiHiltModule_ProvideEmojiServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new EmojiHiltModule_ProvideEmojiServiceFactory(r1, r2);
    }

    public static b provideEmojiService(j r1, v r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        h.a(r3);
        return (b) Preconditions.checkNotNullFromProvides(r3);
    }
}
