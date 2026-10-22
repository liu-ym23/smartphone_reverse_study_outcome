package com.obric.assistant.state.impl.multitask.producer;

import aha.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AiNoteStateProducer$a {
    public final String a;
    public final jha.l<b> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AiNoteStateProducer$a) == true) goto L8;
        return false;
    L8:
        AiNoteStateProducer$a r6 = (AiNoteStateProducer$a) r5;
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
        return "ActiveRecording(meetingId=" + this.a + ", handle=" + this.b + ')';
    }

    public AiNoteStateProducer$a(String r2, jha.l<b> r3) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        Intrinsics.checkNotNullParameter(r3, "handle");
        this.a = r2;
        this.b = r3;
    }
}
