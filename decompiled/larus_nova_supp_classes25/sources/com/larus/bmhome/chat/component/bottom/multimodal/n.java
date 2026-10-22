package com.larus.bmhome.chat.component.bottom.multimodal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public final List<a> a;
    public final g1 b;
    public final h1 c;
    public final Map<String, String> d;
    public final m e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        h1 r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
        m r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultimodalData(attachments=" + this.a + ", processConfig=" + this.b + ", textMessage=" + this.c + ", eventExt=" + this.d + ", bizData=" + this.e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(List<? extends a> r2, g1 r3, h1 r4, Map<String, String> r5, m r6) {
        Intrinsics.checkNotNullParameter(r2, "attachments");
        Intrinsics.checkNotNullParameter(r3, "processConfig");
        Intrinsics.checkNotNullParameter(r5, "eventExt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ n(List r9, g1 r10, h1 r11, Map r12, m r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        h1 r5 = null;
    L7:
        if ((r14 & 8) == 0) goto L9;
        r12 = new LinkedHashMap();
    L9:
        Map r6 = r12;
        if ((r14 & 16) == 0) goto L12;
        m r7 = null;
    L13:
        this(r9, r10, r5, r6, r7);
        return;
    L12:
        r7 = r13;
        goto L13
    L5:
        r5 = r11;
        goto L7
    }
}
