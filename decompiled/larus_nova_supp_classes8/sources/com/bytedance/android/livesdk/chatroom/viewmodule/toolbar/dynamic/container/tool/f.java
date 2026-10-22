package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public final int a;
    public final View b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        View r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "DataViewItem(id=" + this.a + ", view=" + this.b + ")";
    }

    public f(int r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.a = r2;
        this.b = r3;
    }
}
