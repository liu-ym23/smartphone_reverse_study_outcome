package com.ss.android.lark.coremd.ext;

import com.ss.android.lark.coremd.ext.f;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExtendProviderImpl<E extends f> implements h<E> {
    public final Class<E> c;

    @Override // com.ss.android.lark.coremd.ext.h
    public final E a() {
        ConcurrentHashMap<Class<?>, Object> r0 = k.a;
        return (E) k.a(this.c);
    }

    public ExtendProviderImpl(Class<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        this.c = r2;
    }

    public final <R> R b(final Function1<? super E, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        return (R) i.a(this.c, new ExtendProviderImpl$invoke$1(r3));
    }
}
