package com.obric.assistant.state.impl.multitask.producer;

import aha.g;
import kl9.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricAigcGenerationStateProducer$a {
    public final jha.l<g> a;
    public final u b;
    public final String c;
    public final aha.u d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAigcGenerationStateProducer$a) == true) goto L8;
        return false;
    L8:
        ObricAigcGenerationStateProducer$a r6 = (ObricAigcGenerationStateProducer$a) r5;
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
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "ActiveTask(handle=" + this.a + ", taskInfo=" + this.b + ", conversationId=" + this.c + ", taskMetadata=" + this.d + ')';
    }

    public ObricAigcGenerationStateProducer$a(jha.l<g> r2, u r3, String r4, aha.u r5) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        Intrinsics.checkNotNullParameter(r3, "taskInfo");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "taskMetadata");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
