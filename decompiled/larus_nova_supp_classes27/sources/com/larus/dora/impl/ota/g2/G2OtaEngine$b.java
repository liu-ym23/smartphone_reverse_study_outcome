package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class G2OtaEngine$b {
    private final e device;
    private final String token;
    private final DeadlineType type;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof G2OtaEngine$b) == true) goto L8;
        return false;
    L8:
        G2OtaEngine$b r6 = (G2OtaEngine$b) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.device, r6.device) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.type.hashCode() * 31;
        e r1 = this.device;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.token.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DeadlineKey(type=" + this.type + ", device=" + this.device + ", token=" + this.token + ')';
    }

    public final e a() {
        return this.device;
    }

    public final String b() {
        return this.token;
    }

    public final DeadlineType getType() {
        return this.type;
    }

    public G2OtaEngine$b(DeadlineType r2, e r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "token");
        this.type = r2;
        this.device = r3;
        this.token = r4;
    }
}
