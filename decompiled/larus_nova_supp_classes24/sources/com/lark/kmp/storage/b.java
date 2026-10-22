package com.lark.kmp.storage;

import okio.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements g {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.lark.kmp.storage.g
    public final com.lark.kmp.storage.kv.f a() {
        return new com.lark.kmp.storage.kv.f();
    }

    @Override // com.lark.kmp.storage.g
    public final a b() {
        return new a();
    }

    @Override // com.lark.kmp.storage.g
    public final com.lark.kmp.storage.file.a c() {
        return new com.lark.kmp.storage.file.a(l.a);
    }
}
