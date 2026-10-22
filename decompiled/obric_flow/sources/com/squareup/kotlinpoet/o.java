package com.squareup.kotlinpoet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f15190a = null;

    static {
        f15190a = new o();
    }

    @Override // java.lang.Appendable
    public final Appendable append(char r5) {
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        return this;
    }
}
