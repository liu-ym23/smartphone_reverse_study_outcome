package com.larus.community.impl.applet;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AICreationAppletNavigator$a {
    public final String a;
    public final Bundle b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AICreationAppletNavigator$a) == true) goto L8;
        return false;
    L8:
        AICreationAppletNavigator$a r6 = (AICreationAppletNavigator$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AppletRootPage(path=" + this.a + ", args=" + this.b + ')';
    }

    public AICreationAppletNavigator$a(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "args");
        this.a = r2;
        this.b = r3;
    }
}
