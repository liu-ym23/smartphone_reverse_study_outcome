package com.bytedance.ai.core.base;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final String a;
    public final String b;
    public final AtomicBoolean c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RuntimeTask(sessionId=" + this.a + ", taskName=" + this.b + ')';
    }

    public h(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "taskName");
        this.a = r10;
        this.b = r11;
        ConcurrentHashMap<String, String> r12 = x4.a.a;
        UUID.randomUUID().toString();
        this.c = new AtomicBoolean(false);
    }
}
