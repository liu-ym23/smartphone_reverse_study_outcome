package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final boolean a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof m) == true) goto L6;
        return false;
    L6:
        if (this.a == ((m) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r0 = this.a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public final String toString() {
        return "SwitchSceneEvent(resetData=" + this.a + ")";
    }

    public m(boolean r1) {
        this.a = r1;
    }
}
