package com.bytedance.android.anniex.detect;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public boolean a;
    public final boolean b;
    public boolean c;
    public Long d;
    public boolean e;
    public boolean f;
    public Long g;
    public Boolean h;
    public final boolean i;
    public boolean j;
    public Long k;
    public Boolean l;
    public final StringBuilder m;
    public final List<String> n;
    public final List<String> o;
    public final List<Float> p;

    public g() {
        this(null);
    }

    public final String toString() {
        return "isDetectFinish:" + this.a + ", isPitayaReady:" + this.b + ", isPixelCopySuccess" + this.c + ", isPixelCopyCost" + this.d + ", isPureBlank" + this.e + ", isPureBlankTimeout" + this.f + ", pureBlankCost" + this.g + ", isPartialBlank" + this.i + ", isPartialBlankTimeout" + this.j + ", partialBlankCost" + this.k + ", errorMsg" + this.m + "bboxs" + this.n + ", classLabels" + this.o + ", scores" + this.p;
    }

    public g(Object r10) {
        Boolean r11 = Boolean.FALSE;
        StringBuilder r0 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r0, "errorMsg");
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = r11;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = r11;
        this.m = r0;
        this.n = null;
        this.o = null;
        this.p = null;
    }
}
