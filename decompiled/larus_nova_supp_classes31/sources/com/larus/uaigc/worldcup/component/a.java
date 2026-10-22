package com.larus.uaigc.worldcup.component;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements t1a.c {
    public final Bundle a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "WorldCupArgumentData(arguments=" + this.a + ')';
    }

    public final String a() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("action_bar_key");
    }

    public final String b() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("enter_method");
    }

    public a(Bundle r1) {
        this.a = r1;
    }
}
