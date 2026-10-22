package com.suite.lark.platform.component.storage.di;

import android.text.TextUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import woc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserStorageModule_ProvideUserFileStorageFactory implements Factory<FileStorage> {
    private final Provider<String> uidProvider;

    public FileStorage get() {
        return provideUserFileStorage((String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1745get() {
        return get();
    }

    public UserStorageModule_ProvideUserFileStorageFactory(Provider<String> r1) {
        this.uidProvider = r1;
    }

    public static UserStorageModule_ProvideUserFileStorageFactory create(Provider<String> r1) {
        return new UserStorageModule_ProvideUserFileStorageFactory(r1);
    }

    public static FileStorage provideUserFileStorage(String r1) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "uid");
        if (TextUtils.equals(r1, "absent_user") == false) goto L5;
        FileStorage r2 = LarkFileStorage.f("");
    L7:
        return (FileStorage) Preconditions.checkNotNullFromProvides(r2);
    L5:
        r2 = LarkFileStorage.f(r1);
        goto L7
    }
}
