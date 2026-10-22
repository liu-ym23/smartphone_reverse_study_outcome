package com.obric.assistant.state.impl.multitask.consumer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class InteractionProjectionServiceImpl$c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InteractionProjectionServiceImpl$c) == true) goto L8;
        return false;
    L8:
        InteractionProjectionServiceImpl$c r6 = (InteractionProjectionServiceImpl$c) r5;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "PendingRound(botId=" + this.a + ", sessionId=" + this.b + ", conversationId=" + this.c + ", messageId=" + this.d + ')';
    }

    public InteractionProjectionServiceImpl$c(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
