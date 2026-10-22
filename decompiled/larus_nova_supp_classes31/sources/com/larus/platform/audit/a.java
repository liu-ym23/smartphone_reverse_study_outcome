package com.larus.platform.audit;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final BehaviorAuditOperation a;
    public final b b;
    public final String c;
    public final String d;
    public final Map<String, Object> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
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
        int r0 = this.a.hashCode() * 31;
        b r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.e.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BehaviorAuditEvent(operation=" + this.a + ", fileInfo=" + this.b + ", operatorId=" + this.c + ", shareChannel=" + this.d + ", extras=" + this.e + ')';
    }

    public /* synthetic */ a(BehaviorAuditOperation r9, b r10, String r11, Map r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        b r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        r12 = MapsKt.emptyMap();
    L13:
        this(r9, r4, null, r6, r12);
        return;
    L9:
        r6 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public a(BehaviorAuditOperation r2, b r3, String r4, String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        Intrinsics.checkNotNullParameter(r6, "extras");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
