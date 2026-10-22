package com.bytedance.android.live.liveinteract.interactivesong.panel;

import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final IMVTab a;
    public final List<i> b;

    public f() {
        this(null, 3);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
        IMVTab r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<i> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MvSelectTabBean(tabName=" + this.a + ", mvList=" + this.b + ")";
    }

    public /* synthetic */ f(IMVTab r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = (IMVTab) vh7.f.c(IMVTab.class);
    L6:
        if ((r3 & 2) == 0) goto L8;
        ArrayList r4 = new ArrayList();
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public f(IMVTab r2, List<i> r3) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        Intrinsics.checkNotNullParameter(r3, "mvList");
        this.a = r2;
        this.b = r3;
    }
}
