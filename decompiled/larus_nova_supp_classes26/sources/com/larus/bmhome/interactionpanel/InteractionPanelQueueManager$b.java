package com.larus.bmhome.interactionpanel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class InteractionPanelQueueManager$b {
    public final String a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InteractionPanelQueueManager$b) == true) goto L8;
        return false;
    L8:
        InteractionPanelQueueManager$b r6 = (InteractionPanelQueueManager$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "InteractionPanelCmdDebounceKey(conversationId=" + this.a + ", threadId=" + this.b + ", blockId=" + this.c + ')';
    }

    public InteractionPanelQueueManager$b(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "threadId");
        Intrinsics.checkNotNullParameter(r4, "blockId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
