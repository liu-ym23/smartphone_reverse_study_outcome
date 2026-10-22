package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ String a;

    public f(String r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        m.h.i(((Long) r5).longValue(), this.a, "ViewCache");
    }
}
