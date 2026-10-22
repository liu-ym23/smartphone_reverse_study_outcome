package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface v<T> {
    Disposable subscribe(Consumer<? super T> r1);
}
