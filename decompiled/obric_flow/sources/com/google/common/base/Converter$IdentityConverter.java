package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Converter$IdentityConverter<T> extends m implements Serializable {
    static final Converter$IdentityConverter<?> INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new Converter$IdentityConverter();
    }

    private Converter$IdentityConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.m
    public <S> m doAndThen(m r5) {
        b0.n(r5, "otherConverter");
        return r5;
    }

    @Override // com.google.common.base.m
    public T doBackward(T r5) {
        return r5;
    }

    @Override // com.google.common.base.m
    public T doForward(T r5) {
        return r5;
    }

    @Override // com.google.common.base.m
    public Converter$IdentityConverter<T> reverse() {
        return this;
    }

    public String toString() {
        return "Converter.identity()";
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ m reverse() {
        return reverse();
    }
}
