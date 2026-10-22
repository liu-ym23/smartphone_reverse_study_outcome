package com.obric.assistant.settings.autogui;

import com.obric.assistant.settings.ObricAppListMode;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricAutoGuiSettingsImpl$d {
    public final ObricAppListMode a;
    public final List<com.obric.assistant.settings.r> b;
    public final Set<String> c;
    public final Set<String> d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAutoGuiSettingsImpl$d) == true) goto L8;
        return false;
    L8:
        ObricAutoGuiSettingsImpl$d r6 = (ObricAutoGuiSettingsImpl$d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        List<com.obric.assistant.settings.r> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Set<String> r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((r4 + r2) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L13;
        int r7 = 1231;
    L15:
        return r6 + r7;
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CloudAppPolicy(mode=" + this.a + ", softBlacklist=" + this.b + ", whitelistPackages=" + this.c + ", whitelistNames=" + this.d + ", isComplete=" + this.e + ')';
    }

    public ObricAutoGuiSettingsImpl$d(ObricAppListMode r2, List<com.obric.assistant.settings.r> r3, Set<String> r4, Set<String> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r5, "whitelistNames");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
