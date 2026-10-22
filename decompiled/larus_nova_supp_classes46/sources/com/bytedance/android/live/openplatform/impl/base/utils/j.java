package com.bytedance.android.live.openplatform.impl.base.utils;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public j(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Function1 r0 = this.a;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r3);
        return;
    }
}
