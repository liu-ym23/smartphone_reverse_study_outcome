package com.obric.aiagent.messenger.stub;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$b {
    public final String a;
    public final CompletableDeferred<Boolean> b;
    public boolean c;

    public MessageIDLStub$b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageIDLStub$b) == true) goto L8;
        return false;
    L8:
        MessageIDLStub$b r6 = (MessageIDLStub$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ForegroundWidgetSyncWaiter(conversationId=" + this.a + ", completion=" + this.b + ", hasFailure=" + this.c + ')';
    }

    public MessageIDLStub$b(String r2, CompletableDeferred r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "completion");
        this.a = r2;
        this.b = r3;
        this.c = false;
    }
}
