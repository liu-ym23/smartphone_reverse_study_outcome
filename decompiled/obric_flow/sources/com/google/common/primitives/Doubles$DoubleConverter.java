package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Doubles$DoubleConverter extends m implements Serializable {
    static final Doubles$DoubleConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Doubles$DoubleConverter();
    }

    private Doubles$DoubleConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
        return doBackward((Double) r5);
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doForward(Object r5) {
        return doForward((String) r5);
    }

    public String toString() {
        return "Doubles.stringConverter()";
    }

    public String doBackward(Double r5) {
        return r5.toString();
    }

    public Double doForward(String r5) {
        return Double.valueOf(r5);
    }
}
