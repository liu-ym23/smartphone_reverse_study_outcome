package com.larus.common_ui.widget.input;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AudioVisualizerOpt$a {
    public int a;
    public int b;
    public float c;
    public float d;
    public float e;

    public AudioVisualizerOpt$a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioVisualizerOpt$a) == true) goto L8;
        return false;
    L8:
        AudioVisualizerOpt$a r6 = (AudioVisualizerOpt$a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
    }

    public final String toString() {
        return "BarParam(barType=" + this.a + ", groupType=" + this.b + ", barHeight=" + this.c + ", curBarHeight=" + this.d + ", change=" + this.e + ')';
    }

    public AudioVisualizerOpt$a(int r1) {
        this.a = 2;
        this.b = 2;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
    }
}
