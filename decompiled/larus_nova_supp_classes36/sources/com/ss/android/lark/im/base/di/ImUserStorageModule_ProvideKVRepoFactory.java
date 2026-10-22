package com.ss.android.lark.im.base.di;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImUserStorageModule_ProvideKVRepoFactory implements Factory<KVRepo> {
    private final Provider<a> kvStorageProvider;
    private final gkb.a module;

    public KVRepo get() {
        return provideKVRepo(this.module, (a) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m708get() {
        return get();
    }

    public ImUserStorageModule_ProvideKVRepoFactory(gkb.a r1, Provider<a> r2) {
        this.module = r1;
        this.kvStorageProvider = r2;
    }

    public static ImUserStorageModule_ProvideKVRepoFactory create(gkb.a r1, Provider<a> r2) {
        return new ImUserStorageModule_ProvideKVRepoFactory(r1, r2);
    }

    public static KVRepo provideKVRepo(gkb.a r1, a r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "kvStorage");
        LarkKVStorage r3 = LarkKVStorage.a;
        com.ss.android.lark.storage.a r0 = com.ss.android.lark.im.base.a.b;
        r3.getClass();
        return (KVRepo) Preconditions.checkNotNullFromProvides(LarkKVStorage.l(r2, r0, null));
    }
}
