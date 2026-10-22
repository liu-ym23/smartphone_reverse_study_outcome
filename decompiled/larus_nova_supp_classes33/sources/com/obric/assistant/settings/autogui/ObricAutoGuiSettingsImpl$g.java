package com.obric.assistant.settings.autogui;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricAutoGuiSettingsImpl$g {
    public final Set<String> a;
    public final boolean b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAutoGuiSettingsImpl$g) == true) goto L8;
        return false;
    L8:
        ObricAutoGuiSettingsImpl$g r6 = (ObricAutoGuiSettingsImpl$g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "LauncherPackageSnapshot(packages=" + this.a + ", isComplete=" + this.b + ')';
    }

    public ObricAutoGuiSettingsImpl$g(Set<String> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "packages");
        this.a = r2;
        this.b = r3;
    }
}
