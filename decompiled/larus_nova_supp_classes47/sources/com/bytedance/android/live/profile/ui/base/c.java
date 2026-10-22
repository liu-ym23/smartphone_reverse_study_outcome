package com.bytedance.android.live.profile.ui.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;

    public c() {
        this(0, 0, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "ContainerConfig(containerId=" + this.a + ", bottomDependenceId=" + this.b + ", topDependenceId=" + this.c + ")";
    }

    public c(int r3, int r4, int r5) {
        int r1 = -1;
        if ((r5 & 1) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r5 & 4) != 0) goto L12;
        r1 = 0;
    L12:
        this.a = r3;
        this.b = r4;
        this.c = r1;
    }
}
