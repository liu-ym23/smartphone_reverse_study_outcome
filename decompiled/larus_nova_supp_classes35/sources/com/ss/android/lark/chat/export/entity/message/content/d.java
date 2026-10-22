package com.ss.android.lark.chat.export.entity.message.content;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends e {
    public final int c;
    public final ByteString d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.c * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "LarkCommand(cmd=" + this.c + ", payload=" + this.d + ')';
    }

    public d(int r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        super(1, true);
        this.c = r2;
        this.d = r3;
    }
}
