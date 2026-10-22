package com.larus.dora.impl.ota.g2;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p5 {
    private final e device;
    private final Map<String, String> fields;
    private final String name;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p5) == true) goto L8;
        return false;
    L8:
        p5 r6 = (p5) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.device, r6.device) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fields, r6.fields) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.name.hashCode() * 31;
        e r1 = this.device;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.fields.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "TelemetryRecord(name=" + this.name + ", device=" + this.device + ", fields=" + this.fields + ')';
    }

    public final e a() {
        return this.device;
    }

    public final Map<String, String> b() {
        return this.fields;
    }

    public final String c() {
        return this.name;
    }

    public p5(String r2, e r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r4, "fields");
        this.name = r2;
        this.device = r3;
        this.fields = r4;
    }
}
