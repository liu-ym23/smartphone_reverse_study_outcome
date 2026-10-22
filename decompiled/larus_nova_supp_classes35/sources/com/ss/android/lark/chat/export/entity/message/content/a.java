package com.ss.android.lark.chat.export.entity.message.content;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends e {
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.c.hashCode() * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "ActionUrl(localUrl=" + this.c + ", commonUrl=" + this.d + ')';
    }

    public a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "localUrl");
        Intrinsics.checkNotNullParameter(r4, "commonUrl");
        super(0, true);
        this.c = r3;
        this.d = r4;
    }
}
