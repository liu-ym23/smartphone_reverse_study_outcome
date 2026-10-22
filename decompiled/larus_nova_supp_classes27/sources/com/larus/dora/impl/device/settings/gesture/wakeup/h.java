package com.larus.dora.impl.device.settings.gesture.wakeup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final GestureWakeupType a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        GestureWakeupType r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "GestureWakeupSideType(type=" + this.a + ", side=" + this.b + ')';
    }

    public final GestureWakeupType getType() {
        return this.a;
    }

    public h(GestureWakeupType r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
