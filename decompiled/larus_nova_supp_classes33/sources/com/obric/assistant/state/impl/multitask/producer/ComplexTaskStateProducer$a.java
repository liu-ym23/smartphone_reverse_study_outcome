package com.obric.assistant.state.impl.multitask.producer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ComplexTaskStateProducer$a {
    public final jha.l<aha.d> a;
    public final aha.d b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ComplexTaskStateProducer$a) == true) goto L8;
        return false;
    L8:
        ComplexTaskStateProducer$a r6 = (ComplexTaskStateProducer$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ActiveTask(handle=" + this.a + ", state=" + this.b + ')';
    }

    public ComplexTaskStateProducer$a(jha.l<aha.d> r2, aha.d r3) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        Intrinsics.checkNotNullParameter(r3, "state");
        this.a = r2;
        this.b = r3;
    }
}
