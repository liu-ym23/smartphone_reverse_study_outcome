package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final Function1<Continuation<? super Unit>, Object> a;

    public a(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.a = r2;
    }
}
