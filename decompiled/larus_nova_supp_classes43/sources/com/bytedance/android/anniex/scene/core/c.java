package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String a;
    public final long b;

    public final String toString() {
        return "PageAttachEvent(name=" + this.a + ", timestamp=" + this.b + ')';
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof c) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.a, ((c) r10).a);
    }

    public c(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.a = r10;
        this.b = r11;
    }
}
