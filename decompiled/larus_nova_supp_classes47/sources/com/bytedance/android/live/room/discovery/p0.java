package com.bytedance.android.live.room.discovery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 extends o70.b {
    public int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof p0) == true) goto L6;
        return false;
    L6:
        if (this.a == ((p0) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "SignalStatusEvent(status=" + this.a + ")";
    }

    public p0() {
        this.a = 1;
    }
}
