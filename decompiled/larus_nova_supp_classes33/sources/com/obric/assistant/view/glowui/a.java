package com.obric.assistant.view.glowui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final Function0<Float> a;
    public final Function1<Float, Unit> b;
    public final Function1<Float, Unit> c;
    public int d;
    public Function0<Float> e;
    public long f;
    public long g;
    public long h;
    public long i;
    public float j;
    public float k;

    /* JADX INFO: renamed from: com.obric.assistant.view.glowui.a$a, reason: collision with other inner class name */
    public static final class C0028a {
    }

    static {
    }

    public final void a(Function0<Float> r3) {
        Intrinsics.checkNotNullParameter(r3, "getAmplitude");
        if (this.d != 0) goto L5;
        return;
    L5:
        this.d = 0;
        this.e = r3;
        float r4 = ((Number) this.a.invoke()).floatValue();
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0.0f;
        this.k = r4;
    }

    public a(e r2, f r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "getVolume");
        Intrinsics.checkNotNullParameter(r3, "setVolume");
        Intrinsics.checkNotNullParameter(r4, "setTime");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 1;
    }
}
