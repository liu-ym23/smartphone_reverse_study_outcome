package com.squareup.kotlinpoet;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15191a;

    public p(List r5) {
        Intrinsics.checkNotNullParameter(r5, "originatingElements");
        this.f15191a = r5;
    }

    @Override // com.squareup.kotlinpoet.r
    public final List a() {
        return this.f15191a;
    }
}
