package com.obric.assistant.chat.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageApiImpl$a {
    public final String a;
    public final long b;
    public final Deferred<MessageApiImpl$b> c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MessageApiImpl$a) == true) goto L8;
        return false;
    L8:
        MessageApiImpl$a r9 = (MessageApiImpl$a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "GetExtTask(scene=" + this.a + ", startTime=" + this.b + ", deferred=" + this.c + ')';
    }

    public MessageApiImpl$a(String r2, long r3, Deferred<MessageApiImpl$b> r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r5, "deferred");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
