package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public final String a;
    public final String b;
    public final String c;
    public final JSONObject d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "IntentCardOperationRequest(op=" + this.a + ", requestId=" + this.b + ", scene=" + this.c + ", payload=" + this.d + ')';
    }

    public j(String r2, String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "op");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "payload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
