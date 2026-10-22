package com.bytedance.android.live.room.api.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int e = 0;
    public final PanelName a;
    public final int b;
    public final ActionType c;
    public final int d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        PanelName r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        ActionType r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.d;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PanelInfo(panelName=" + this.a + ", unionId=" + this.b + ", actionType=" + this.c.getType() + ", panelHeight=" + this.d + ')';
    }

    public e(PanelName r2, int r3, ActionType r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "panelName");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
