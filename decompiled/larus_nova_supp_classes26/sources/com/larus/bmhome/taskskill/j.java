package com.larus.bmhome.taskskill;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final List<RemoteControlAuthorizationMode> a;
    public final RemoteControlAuthorizationMode b;
    public final String c;

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
        if (this.b == r6.b) goto L15;
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
        return "RemoteControlAuthorizationModeState(availableModes=" + this.a + ", selectedMode=" + this.b + ", remotePcDeviceId=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends RemoteControlAuthorizationMode> r2, RemoteControlAuthorizationMode r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "availableModes");
        Intrinsics.checkNotNullParameter(r3, "selectedMode");
        Intrinsics.checkNotNullParameter(r4, "remotePcDeviceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
