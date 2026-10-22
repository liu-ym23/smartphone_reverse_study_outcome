package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T> implements Consumer {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "obj");
        r3.printStackTrace();
    }
}
