package com.suite.lark.platform.component.storage.di;

import com.ss.android.lark.storage.file.FileStorage;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GlobalStorageModule_ProvideGlobalFileStorageFactory implements Factory<FileStorage> {

    public static final class a {
        public static final GlobalStorageModule_ProvideGlobalFileStorageFactory a = null;

        static {
            a = new GlobalStorageModule_ProvideGlobalFileStorageFactory();
        }
    }

    public GlobalStorageModule_ProvideGlobalFileStorageFactory() {
    }

    public static FileStorage provideGlobalFileStorage() {
        int r0 = woc.a.a;
        return (FileStorage) Preconditions.checkNotNullFromProvides(LarkFileStorage.b());
    }

    public FileStorage get() {
        return provideGlobalFileStorage();
    }

    public static GlobalStorageModule_ProvideGlobalFileStorageFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1743get() {
        return get();
    }
}
