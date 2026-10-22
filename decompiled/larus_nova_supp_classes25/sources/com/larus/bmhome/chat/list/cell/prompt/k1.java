package com.larus.bmhome.chat.list.cell.prompt;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k1 {
    public final CharSequence a;
    public final String b;
    public final Map<String, String> c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k1) == true) goto L8;
        return false;
    L8:
        k1 r6 = (k1) r5;
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
        CharSequence r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r4 = this.d;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PromptSendPayload(fillInputContent=" + this.a + ", sendContent=" + this.b + ", messageExt=" + this.c + ", skillPrefix=" + this.d + ')';
    }

    public final Map<String, String> a() {
        return this.c;
    }

    public k1(CharSequence r2, String r3, Map<String, String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "sendContent");
        Intrinsics.checkNotNullParameter(r4, "messageExt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
