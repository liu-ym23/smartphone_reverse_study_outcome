package com.obric.aiagent.messenger.stub;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$a {
    public final String a;
    public final String b;
    public final Map<String, String> c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MessageIDLStub$a) == true) goto L8;
        return false;
    L8:
        MessageIDLStub$a r9 = (MessageIDLStub$a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "ConfirmedWidgetUpdate(localMessageId=" + this.a + ", messageId=" + this.b + ", renderDataByBlockId=" + this.c + ", expiresAtElapsedRealtime=" + this.d + ')';
    }

    public MessageIDLStub$a(String r2, String r3, Map<String, String> r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "renderDataByBlockId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
