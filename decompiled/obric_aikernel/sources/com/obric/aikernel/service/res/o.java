package com.obric.aikernel.service.res;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5533b;

    public o(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "callerPackageName");
        Intrinsics.checkNotNullParameter(r11, "triggerScene");
        this.f5532a = r10;
        this.f5533b = r11;
    }

    public final String a() {
        return this.f5532a;
    }

    public final String b() {
        return this.f5533b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (Intrinsics.areEqual(this.f5532a, r11.f5532a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5533b, r11.f5533b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f5532a.hashCode() * 31) + this.f5533b.hashCode();
    }

    public String toString() {
        return "UpdateCallerTrackFields(callerPackageName=" + this.f5532a + ", triggerScene=" + this.f5533b + ')';
    }
}
