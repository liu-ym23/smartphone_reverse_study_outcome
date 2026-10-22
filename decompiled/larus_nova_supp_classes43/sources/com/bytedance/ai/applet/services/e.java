package com.bytedance.ai.applet.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final String a;
    public final String b;
    public final int c;
    public final int d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "SnapshotUploadResult(messageId=" + this.a + ", mimeType=" + this.b + ", width=" + this.c + ", height=" + this.d + ')';
    }

    public e(String r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter(r11, "mimeType");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
