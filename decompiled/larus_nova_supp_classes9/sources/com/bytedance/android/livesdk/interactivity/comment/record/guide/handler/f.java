package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ h a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.n b;

    public f(h r1, com.bytedance.android.livesdk.interactivity.comment.record.guide.n r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.interactivity.comment.record.guide.n) r2, "it");
        return this.a.b.c(this.b);
    }
}
