package com.facebook.datasource;

import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DataSources {
    public static SimpleDataSource a(Exception r5) {
        SimpleDataSource r10 = new SimpleDataSource();
        r5.getClass();
        r10.a(r5, null);
        return r10;
    }

    public static Supplier a(final NullPointerException r5) {
        return new AnonymousClass1(r5);
    }
}
