package com.larus.account.saas.runtime.internal.delegate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final d b;
    public final d c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "SaasLoginContext(appName=" + this.a + ", serviceAgreement=" + this.b + ", privacyPolicy=" + this.c + ')';
    }

    public b(String r2, d r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, "serviceAgreement");
        Intrinsics.checkNotNullParameter(r4, "privacyPolicy");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
