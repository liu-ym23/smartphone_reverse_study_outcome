package com.ss.android.lark.coremd.ext;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public static final <T extends f, R> R a(Class<T> r1, Function1<? super T, ? extends R> r2) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        return (R) r2.invoke(k.a(r1));
    }
}
