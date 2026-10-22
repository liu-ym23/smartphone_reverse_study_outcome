package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "obj");
        r3.printStackTrace();
    }
}
