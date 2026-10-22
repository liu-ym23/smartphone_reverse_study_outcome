package com.bytedance.android.ec.core.async;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final void b(Disposable r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$globalScope");
    }

    public static final Disposable a(Disposable r1, b r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$addTo");
        Intrinsics.checkNotNullParameter(r10, "disposableScope");
        return r10.add(r1);
    }
}
