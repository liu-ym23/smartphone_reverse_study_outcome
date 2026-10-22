package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public static final /* synthetic */ int d = 0;
    public final boolean a;
    public final PreviewSendFailureReason b;
    public final boolean c;

    public static final class a {
        public static v a(PreviewSendFailureReason r3) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            return new v(false, r3, 4);
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        PreviewSendFailureReason r3 = this.b;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return r5 + r1;
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewSendResult(success=" + this.a + ", reason=" + this.b + ", closePreview=" + this.c + ')';
    }

    public v(boolean r2, PreviewSendFailureReason r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        boolean r5 = r2;
    L9:
        this.a = r2;
        this.b = r3;
        this.c = r5;
        return;
    L8:
        r5 = false;
        goto L9
    }
}
