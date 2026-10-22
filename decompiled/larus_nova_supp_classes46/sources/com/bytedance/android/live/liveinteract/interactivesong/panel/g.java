package com.bytedance.android.live.liveinteract.interactivesong.panel;

import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public final IMVTab a;
    public final List<IMVTab> b;
    public final f c;

    public g() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L12;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IMVTab r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<IMVTab> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        f r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MvSelectUIState(defaultTab=" + this.a + ", tabList=" + this.b + ", tabMvData=" + this.c + ")";
    }

    public /* synthetic */ g(int r5) {
        this(vh7.f.c(IMVTab.class), CollectionsKt.emptyList(), new f(null, 3));
    }

    public g(IMVTab r2, List<? extends IMVTab> r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "defaultTab");
        Intrinsics.checkNotNullParameter(r3, "tabList");
        Intrinsics.checkNotNullParameter(r4, "tabMvData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static g a(g r1, IMVTab r2, List r3, f r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = r1.c;
    L11:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "defaultTab");
        Intrinsics.checkNotNullParameter(r3, "tabList");
        Intrinsics.checkNotNullParameter(r4, "tabMvData");
        return new g(r2, r3, r4);
    }
}
