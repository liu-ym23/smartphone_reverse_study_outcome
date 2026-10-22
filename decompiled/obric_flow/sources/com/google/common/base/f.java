package com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8656a;

    public f(c r5) {
        this.f8656a = r5;
    }

    @Override // com.google.common.base.z
    public final boolean apply(Object r5) {
        return b(((Character) r5).charValue());
    }

    @Override // com.google.common.base.g
    public final boolean b(char r5) {
        return !this.f8656a.b(r5);
    }

    @Override // java.util.function.Predicate
    public final Predicate negate() {
        return this.f8656a;
    }

    public final String toString() {
        String r5 = String.valueOf(this.f8656a);
        return androidx.room.jarjarred.org.antlr.runtime.a.l(r5.length() + 9, r5, ".negate()");
    }
}
