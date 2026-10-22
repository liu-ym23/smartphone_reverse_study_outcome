package com.ss.android.lark.im.sdk.service;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v<T, R> implements Function {
    public final /* synthetic */ z a;

    public v(z r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.lark.rustclient.api.x) r2, "it");
        this.a.a.getId();
        return new y4b.a();
    }
}
