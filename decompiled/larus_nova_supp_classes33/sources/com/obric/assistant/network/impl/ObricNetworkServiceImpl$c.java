package com.obric.assistant.network.impl;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricNetworkServiceImpl$c {
    public final ObricNetworkServiceImpl$OmniUploadPayloadKind a;
    public final File b;
    public final k c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricNetworkServiceImpl$c) == true) goto L8;
        return false;
    L8:
        ObricNetworkServiceImpl$c r6 = (ObricNetworkServiceImpl$c) r5;
        if (this.a == r6.a) goto L12;
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
        return "OmniUploadPreparedPayload(kind=" + this.a + ", file=" + this.b + ", encryptedPayload=" + this.c + ", mime=" + this.d + ')';
    }

    public ObricNetworkServiceImpl$c(ObricNetworkServiceImpl$OmniUploadPayloadKind r2, File r3, k r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "encryptedPayload");
        Intrinsics.checkNotNullParameter(r5, "mime");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
