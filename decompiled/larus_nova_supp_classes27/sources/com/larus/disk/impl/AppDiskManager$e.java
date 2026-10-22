package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$e {
    public int a;

    public AppDiskManager$e() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AppDiskManager$e) == true) goto L9;
        return false;
    L9:
        if (this.a == ((AppDiskManager$e) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "DiskScanHealth(unreadablePathCount=" + this.a + ')';
    }

    public AppDiskManager$e(int r1) {
        this.a = 0;
    }
}
