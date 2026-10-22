package com.bytedance.android.accessibilityLib_Core.tool;

import com.byted.cast.sink.api.IServerListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final int a;
    public final int b;

    public d() {
        this(0, 3);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == false) goto L10;
        d r11 = (d) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "TimeFrequencyTrigger(internalLimit=" + this.a + ", frequencyLimit=" + this.b + ")";
    }

    public d(int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r10 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
    L6:
        if ((r11 & 2) == 0) goto L8;
        int r12 = 10;
    L9:
        this.a = r10;
        this.b = r12;
        return;
    L8:
        r12 = 0;
        goto L9
    }
}
