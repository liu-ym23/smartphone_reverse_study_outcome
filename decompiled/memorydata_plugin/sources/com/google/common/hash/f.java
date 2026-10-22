package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    <T> HashCode hashObject(T r1, Funnel<? super T> r2);

    g newHasher();
}
