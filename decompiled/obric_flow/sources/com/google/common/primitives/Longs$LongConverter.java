package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Longs$LongConverter extends m implements Serializable {
    static final Longs$LongConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Longs$LongConverter();
    }

    private Longs$LongConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
        return doBackward((Long) r5);
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doForward(Object r5) {
        return doForward((String) r5);
    }

    public String toString() {
        return "Longs.stringConverter()";
    }

    public String doBackward(Long r5) {
        return r5.toString();
    }

    public Long doForward(String r5) {
        return Long.decode(r5);
    }
}
