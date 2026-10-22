package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public final String a;
    public final long b;
    public final String c;

    public final String toString() {
        return "ViewAttachEvent(url=" + this.a + ", timestamp=" + this.b + ", sessionId=" + this.c + ')';
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof k) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.a, ((k) r10).a);
    }

    public k(String r10, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
