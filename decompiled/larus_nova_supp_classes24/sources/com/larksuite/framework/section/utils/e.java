package com.larksuite.framework.section.utils;

import android.view.View;
import com.larksuite.component.universe_design.button.UDButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final View a;
    public long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
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
        return "DebounceView(view=" + this.a + ", lastClickTime=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(UDButton r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.a = r3;
        this.b = 0;
    }
}
