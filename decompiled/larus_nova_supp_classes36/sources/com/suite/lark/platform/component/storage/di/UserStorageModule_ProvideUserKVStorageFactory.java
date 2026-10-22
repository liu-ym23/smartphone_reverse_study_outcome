package com.suite.lark.platform.component.storage.di;

import android.app.Application;
import android.text.TextUtils;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import woc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserStorageModule_ProvideUserKVStorageFactory implements Factory<a> {
    private final Provider<Application> appProvider;
    private final Provider<String> uidProvider;

    public a get() {
        return provideUserKVStorage((Application) this.appProvider.get(), (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1746get() {
        return get();
    }

    public UserStorageModule_ProvideUserKVStorageFactory(Provider<Application> r1, Provider<String> r2) {
        this.appProvider = r1;
        this.uidProvider = r2;
    }

    public static UserStorageModule_ProvideUserKVStorageFactory create(Provider<Application> r1, Provider<String> r2) {
        return new UserStorageModule_ProvideUserKVStorageFactory(r1, r2);
    }

    public static a provideUserKVStorage(Application r1, String r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "app");
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (TextUtils.equals(r2, "absent_user") == false) goto L5;
        a r3 = LarkKVStorage.e(r1, "unlogin");
    L7:
        return (a) Preconditions.checkNotNullFromProvides(r3);
    L5:
        r3 = LarkKVStorage.e(r1, r2);
        goto L7
    }
}
