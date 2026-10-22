package com.larus.api.serviceimpl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AoEventServiceImpl$b {
    public final String a;
    public final JSONObject b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AoEventServiceImpl$b) == true) goto L8;
        return false;
    L8:
        AoEventServiceImpl$b r6 = (AoEventServiceImpl$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "TempEventBufferData(event=" + this.a + ", params=" + this.b + ", hostRawData=" + this.c + ')';
    }

    public AoEventServiceImpl$b(String r2, JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
