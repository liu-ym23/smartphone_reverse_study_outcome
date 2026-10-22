package com.bytedance.android.live.pushstream;

import io.reactivex.functions.Function;
import java.io.File;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T, R> implements Function {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final Object apply(Object r2) {
        File r3 = (File) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return ArraysKt.toList(r3.listFiles());
    }
}
