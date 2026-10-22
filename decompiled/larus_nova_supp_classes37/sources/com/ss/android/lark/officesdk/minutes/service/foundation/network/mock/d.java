package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.squareup.wire.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final String a;
    public final String b;
    public final c c;
    public final Message<?, ?> d;

    public d() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        c r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Message<?, ?> r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMockRequestContext(type=" + this.a + ", key=" + this.b + ", http=" + this.c + ", pbInput=" + this.d + ')';
    }

    public final String getType() {
        return this.a;
    }

    public d(String r3, String r4, c r5, Message r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "key");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
