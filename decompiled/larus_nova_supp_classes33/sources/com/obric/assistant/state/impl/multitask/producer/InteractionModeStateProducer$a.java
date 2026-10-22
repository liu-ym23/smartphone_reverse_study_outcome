package com.obric.assistant.state.impl.multitask.producer;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class InteractionModeStateProducer$a {
    public final aha.l.c a;
    public final jha.l<aha.l> b;
    public final Long c;
    public Map<String, ? extends Object> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InteractionModeStateProducer$a) == true) goto L8;
        return false;
    L8:
        InteractionModeStateProducer$a r6 = (InteractionModeStateProducer$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Long r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActiveMode(state=" + this.a + ", handle=" + this.b + ", baseTimeoutMillis=" + this.c + ", ext=" + this.d + ')';
    }

    public InteractionModeStateProducer$a(aha.l.c r2, jha.l<aha.l> r3, Long r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "handle");
        Intrinsics.checkNotNullParameter(r5, "ext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
