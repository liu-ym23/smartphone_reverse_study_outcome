package com.obric.assistant.network.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricNetworkServiceImpl$b {
    public final ObricNetworkServiceImpl$OmniUploadPayloadKind a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricNetworkServiceImpl$b) == true) goto L8;
        return false;
    L8:
        ObricNetworkServiceImpl$b r6 = (ObricNetworkServiceImpl$b) r5;
        if (this.a == r6.a) goto L12;
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
        ObricNetworkServiceImpl$OmniUploadPayloadKind r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "OmniUploadPayloadInput(kind=" + this.a + ", path=" + this.b + ", mime=" + this.c + ')';
    }

    public ObricNetworkServiceImpl$b(ObricNetworkServiceImpl$OmniUploadPayloadKind r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
