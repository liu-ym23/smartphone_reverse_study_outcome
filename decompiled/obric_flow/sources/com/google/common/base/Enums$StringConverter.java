package com.google.common.base;

import java.io.Serializable;
import java.lang.Enum;

/* JADX INFO: loaded from: classes2.dex */
final class Enums$StringConverter<T extends Enum<T>> extends m implements Serializable {
    private static final long serialVersionUID = 0;
    private final Class<T> enumClass;

    public Enums$StringConverter(Class<T> r5) {
        r5.getClass();
        this.enumClass = r5;
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
        return doBackward((Enum) r5);
    }

    @Override // com.google.common.base.m
    public /* bridge */ /* synthetic */ Object doForward(Object r5) {
        return doForward((String) r5);
    }

    @Override // com.google.common.base.m, com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Enums$StringConverter) == true) goto L5;
        return false;
    L5:
        return this.enumClass.equals(((Enums$StringConverter) r5).enumClass);
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        String r5 = this.enumClass.getName();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 29, "Enums.stringConverter(", r5, ".class)");
    }

    public String doBackward(T r5) {
        return r5.name();
    }

    public T doForward(String r5) {
        return (T) Enum.valueOf(this.enumClass, r5);
    }
}
