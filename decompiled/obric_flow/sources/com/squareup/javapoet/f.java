package com.squareup.javapoet;

import java.util.function.Supplier;
import kotlin.sequences.Sequence;
import kotlin.streams.jdk8.StreamsKt;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14964b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f14963a = r10;
        this.f14964b = r5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch(this.f14963a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return StreamsKt.a((Sequence) this.f14964b);
    L7:
        return new h(new g(), (String) this.f14964b);
    }
}
