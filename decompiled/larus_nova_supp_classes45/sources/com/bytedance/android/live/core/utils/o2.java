package com.bytedance.android.live.core.utils;

import android.graphics.Bitmap;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o2<T> implements ObservableOnSubscribe {
    public static final o2 a = null;

    static {
        a = new o2();
    }

    public o2() {
    }

    public final void subscribe(ObservableEmitter<Bitmap> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
    }
}
