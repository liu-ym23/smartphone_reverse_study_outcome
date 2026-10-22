package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class G2OtaFacade$a {
    private final boolean active;
    private final d49.a lastState;
    private final String ownerId;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof G2OtaFacade$a) == true) goto L8;
        return false;
    L8:
        G2OtaFacade$a r6 = (G2OtaFacade$a) r5;
        if (Intrinsics.areEqual(this.ownerId, r6.ownerId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lastState, r6.lastState) == true) goto L15;
        return false;
    L15:
        if (this.active == r6.active) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.ownerId.hashCode() * 31;
        d49.a r1 = this.lastState;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.active == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "LegacyObservation(ownerId=" + this.ownerId + ", lastState=" + this.lastState + ", active=" + this.active + ')';
    }

    public final boolean b() {
        return this.active;
    }

    public final d49.a c() {
        return this.lastState;
    }

    public final String d() {
        return this.ownerId;
    }

    public G2OtaFacade$a(String r2, d49.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ownerId");
        this.ownerId = r2;
        this.lastState = r3;
        this.active = r4;
    }

    public static G2OtaFacade$a a(G2OtaFacade$a r2, d49.a r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        String r0 = r2.ownerId;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r3 = r2.lastState;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = r2.active;
    L12:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "ownerId");
        return new G2OtaFacade$a(r0, r3, r4);
    L5:
        r0 = null;
        goto L7
    }
}
