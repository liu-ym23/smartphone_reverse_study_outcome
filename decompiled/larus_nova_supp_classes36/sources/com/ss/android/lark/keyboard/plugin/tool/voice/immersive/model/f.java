package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final int a;
    public final boolean b;

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
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ElapseCountDownData(countDown=" + this.a + ", shouldHideWaveBar=" + this.b + ')';
    }

    public f(int r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
