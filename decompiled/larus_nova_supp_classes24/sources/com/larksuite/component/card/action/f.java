package com.larksuite.component.card.action;

import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public final dz7.b a;
    public final dz7.a b;
    public final String c;
    public final HashMap<String, Object> d;
    public final UniversalCardMonitorData e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        HashMap<String, Object> r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "UniversalCardActionRequestEntity(cardActionRequestParams=" + this.a + ", cardActionContext=" + this.b + ", callbackEventName=" + this.c + ", sendLynxParams=" + this.d + ", monitorData=" + this.e + ')';
    }

    public f(dz7.b r3, dz7.a r4, HashMap r5, UniversalCardMonitorData r6) {
        Intrinsics.checkNotNullParameter(r3, "cardActionRequestParams");
        Intrinsics.checkNotNullParameter(r4, "cardActionContext");
        Intrinsics.checkNotNullParameter("updateCardState", "callbackEventName");
        Intrinsics.checkNotNullParameter(r6, "monitorData");
        this.a = r3;
        this.b = r4;
        this.c = "updateCardState";
        this.d = r5;
        this.e = r6;
    }
}
