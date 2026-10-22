package com.lark.kmp.storage;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UserLarkStorage {
    public final String a;
    public final List<com.lark.kmp.storage.file.c> b;
    public final List<com.lark.kmp.storage.kv.b> c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    /* JADX WARN: Multi-variable type inference failed */
    public UserLarkStorage(String r2, List<? extends com.lark.kmp.storage.file.c> r3, List<? extends com.lark.kmp.storage.kv.b> r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "fileDelegateFactories");
        Intrinsics.checkNotNullParameter(r4, "kvDelegateFactories");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(UserLarkStorage$storageConfiguration$2.INSTANCE);
        this.e = LazyKt.lazy(new UserLarkStorage$fs$2(this));
        this.f = LazyKt.lazy(new UserLarkStorage$kvs$2(this));
    }
}
