package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Shorts$ShortConverter extends m implements Serializable {
    static final Shorts$ShortConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Shorts$ShortConverter();
    }

    private Shorts$ShortConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
        return doBackward((Short) r5);
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doForward(Object r5) {
        return doForward((String) r5);
    }

    public String toString() {
        return "Shorts.stringConverter()";
    }

    public String doBackward(Short r5) {
        return r5.toString();
    }

    public Short doForward(String r5) {
        return Short.decode(r5);
    }
}
