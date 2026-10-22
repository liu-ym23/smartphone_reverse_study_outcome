package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Floats$FloatConverter extends m implements Serializable {
    static final Floats$FloatConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Floats$FloatConverter();
    }

    private Floats$FloatConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
        return doBackward((Float) r5);
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doForward(Object r5) {
        return doForward((String) r5);
    }

    public String toString() {
        return "Floats.stringConverter()";
    }

    public String doBackward(Float r5) {
        return r5.toString();
    }

    public Float doForward(String r5) {
        return Float.valueOf(r5);
    }
}
