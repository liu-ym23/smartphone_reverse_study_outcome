package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final /* synthetic */ int c = 0;
    public final int a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        return "MmRecordingAudioFormat(sampleRateHz=" + this.a + ", channelCount=" + this.b + ')';
    }

    public f(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
