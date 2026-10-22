package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface b<T> extends Cloneable {
    n4.c a();

    void c(e<T> r10);

    void cancel();

    b<T> clone();

    a0<T> execute();

    boolean isCanceled();
}
