package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.livesdk.interactivity.comment.y0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public d(y0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        e.c = true;
        e.a((x22.a) this.a.invoke());
    }
}
