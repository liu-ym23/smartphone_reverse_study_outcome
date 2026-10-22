package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ py.k a;

    public n(py.k r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((py.k) r2, "it");
        return com.bytedance.android.livesdk.chatroom.utils.a1.k(this.a);
    }
}
