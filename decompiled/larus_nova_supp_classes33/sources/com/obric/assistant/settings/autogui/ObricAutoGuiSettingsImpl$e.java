package com.obric.assistant.settings.autogui;

import com.obric.assistant.settings.ObricAppListMode;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricAutoGuiSettingsImpl$e {
    public final ObricAutoGuiSettingsImpl$b a;
    public final ObricAppListMode b;
    public final List<com.obric.assistant.settings.r> c;
    public final Set<String> d;
    public final Set<String> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAutoGuiSettingsImpl$e) == true) goto L8;
        return false;
    L8:
        ObricAutoGuiSettingsImpl$e r6 = (ObricAutoGuiSettingsImpl$e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        List<com.obric.assistant.settings.r> r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Set<String> r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.e.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CloudAppPolicySnapshot(accountScope=" + this.a + ", mode=" + this.b + ", softBlacklist=" + this.c + ", whitelistPackages=" + this.d + ", whitelistNames=" + this.e + ')';
    }

    public ObricAutoGuiSettingsImpl$e(ObricAutoGuiSettingsImpl$b r2, ObricAppListMode r3, List<com.obric.assistant.settings.r> r4, Set<String> r5, Set<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r6, "whitelistNames");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
