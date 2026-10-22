package com.lark.kmp.storage;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class GlobalLarkStorage {
    public final List<com.lark.kmp.storage.file.c> a;
    public final List<com.lark.kmp.storage.kv.b> b;
    public final f.a c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalLarkStorage(List<? extends com.lark.kmp.storage.file.c> r2, List<? extends com.lark.kmp.storage.kv.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "fileDelegateFactories");
        Intrinsics.checkNotNullParameter(r3, "kvDelegateFactories");
        this.a = r2;
        this.b = r3;
        this.c = new f.a(0);
        this.d = LazyKt.lazy(GlobalLarkStorage$storageConfiguration$2.INSTANCE);
        this.e = LazyKt.lazy(new GlobalLarkStorage$fs$2(this));
        this.f = LazyKt.lazy(new GlobalLarkStorage$kvs$2(this));
    }
}
