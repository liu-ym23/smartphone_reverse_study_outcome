package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public interface d<T> {

    public interface a<T> {
        void a(Exception r1);

        void a(T r1);
    }

    Class<T> a();

    void a(Priority r1, a<? super T> r2);

    void b();

    void c();

    DataSource d();
}
