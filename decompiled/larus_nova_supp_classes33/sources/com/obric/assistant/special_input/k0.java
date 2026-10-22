package com.obric.assistant.special_input;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k0 {
    public final boolean a;
    public final String b;
    public final List<String> c;
    public final q0 d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r9 = (k0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        q0 r2 = this.d;
        if (r2 != null) goto L9;
        int r3 = 0;
    L10:
        int r4 = (r1 + r3) * 31;
        long r5 = this.e;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    L9:
        r3 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PhoneOperationAttachmentDraftContext(hasAttachment=" + this.a + ", localMsgId=" + this.b + ", fileIdentifiers=" + this.c + ", specialPanel=" + this.d + ", updatedAt=" + this.e + ')';
    }

    public k0(boolean r2, String r3, List<String> r4, q0 r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "localMsgId");
        Intrinsics.checkNotNullParameter(r4, "fileIdentifiers");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
