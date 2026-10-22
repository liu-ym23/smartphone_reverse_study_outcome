package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public interface ObservableSupplier<E> extends Supplier<E> {
    E addObserver(Callback<E> r8);

    void removeObserver(Callback<E> r8);
}
