package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import android.content.Context;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends com.bytedance.android.livesdk.interactivity.comment.record.guide.a {
    public final d b;

    public p(d r2) {
        Intrinsics.checkNotNullParameter(r2, "downloadHandler");
        this.b = r2;
    }

    public static final Observable c(p r1, com.bytedance.android.livesdk.interactivity.comment.record.guide.n r2, long r3, Context r5) {
        return r1.b.c(r2).subscribeOn(Schedulers.io()).flatMap(new n(r3, r2)).flatMap(new o(r5));
    }
}
