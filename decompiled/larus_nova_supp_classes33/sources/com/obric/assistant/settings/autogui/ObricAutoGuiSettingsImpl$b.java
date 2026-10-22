package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricAutoGuiSettingsImpl$b {
    public final String a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ObricAutoGuiSettingsImpl$b) == true) goto L8;
        return false;
    L8:
        ObricAutoGuiSettingsImpl$b r9 = (ObricAutoGuiSettingsImpl$b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "AccountScope(userId=" + this.a + ", generation=" + this.b + ')';
    }

    public ObricAutoGuiSettingsImpl$b(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.a = r2;
        this.b = r3;
    }
}
