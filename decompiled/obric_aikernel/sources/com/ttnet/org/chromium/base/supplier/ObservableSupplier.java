package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes2.dex */
public interface ObservableSupplier<E> extends Supplier<E> {
    E addObserver(Callback<E> r10);

    void removeObserver(Callback<E> r10);
}
