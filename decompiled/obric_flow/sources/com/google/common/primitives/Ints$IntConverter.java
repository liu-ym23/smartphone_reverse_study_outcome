package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Ints$IntConverter extends m implements Serializable {
    static final Ints$IntConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Ints$IntConverter();
    }

    private Ints$IntConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
        return doBackward((Integer) r5);
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doForward(Object r5) {
        return doForward((String) r5);
    }

    public String toString() {
        return "Ints.stringConverter()";
    }

    public String doBackward(Integer r5) {
        return r5.toString();
    }

    public Integer doForward(String r5) {
        return Integer.decode(r5);
    }
}
