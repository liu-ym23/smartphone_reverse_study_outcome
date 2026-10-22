package com.obric.assistant.omnidetailpage.localmedia;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q {
    public final boolean a;
    public final float b;

    public q() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + Float.floatToIntBits(this.b);
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskLocalAudioPlaybackState(isPlaying=" + this.a + ", progress=" + this.b + ')';
    }

    public /* synthetic */ q(int r2) {
        this(false, 0.0f);
    }

    public q(boolean r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
