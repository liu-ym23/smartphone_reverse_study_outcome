package com.obric.assistant.state.impl.multitask.producer;

import aha.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TtsStateProducer$a {
    public final jha.l<e0> a;
    public final e0 b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TtsStateProducer$a) == true) goto L8;
        return false;
    L8:
        TtsStateProducer$a r6 = (TtsStateProducer$a) r5;
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
        return "ActiveTtsTask(handle=" + this.a + ", state=" + this.b + ')';
    }

    public TtsStateProducer$a(jha.l<e0> r2, e0 r3) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        Intrinsics.checkNotNullParameter(r3, "state");
        this.a = r2;
        this.b = r3;
    }
}
