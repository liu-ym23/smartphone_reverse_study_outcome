package com.obric.assistant.chat.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageApiImpl$b {
    public final Map<String, String> a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MessageApiImpl$b) == true) goto L8;
        return false;
    L8:
        MessageApiImpl$b r9 = (MessageApiImpl$b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.b;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetExtTaskResult(ext=" + this.a + ", endTime=" + this.b + ')';
    }

    public MessageApiImpl$b(Map<String, String> r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
