package com.larus.bot.impl.repository;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final Lazy<b> a = null;

    public static final class a {
    }

    public b() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.bot.impl.repository.a());
    }
}
