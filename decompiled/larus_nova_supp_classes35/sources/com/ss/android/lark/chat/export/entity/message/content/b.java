package com.ss.android.lark.chat.export.entity.message.content;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends e {
    public final ChatterToolTipType c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.c.hashCode() * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ChatterToolTip(toolTipType=" + this.c + ", clickable=" + this.d + ')';
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.e
    public final boolean a() {
        return this.d;
    }

    public b(ChatterToolTipType r3) {
        Intrinsics.checkNotNullParameter(r3, "toolTipType");
        super(3, false);
        this.c = r3;
        this.d = false;
    }
}
