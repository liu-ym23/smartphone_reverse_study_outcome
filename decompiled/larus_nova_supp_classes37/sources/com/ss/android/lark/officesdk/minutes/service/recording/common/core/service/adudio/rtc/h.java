package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final int a;
    public final int b;

    public h() {
        this(0);
    }

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
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "MmVolumeBean(interval=" + this.a + ", level=" + this.b + ')';
    }

    public h(int r1) {
        this.a = 400;
        this.b = -20;
    }
}
