package com.ss.android.lark.keyboard.event;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements q {
    public final int a;
    public final int b;
    public final long c;
    public final TimeInterpolator d;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return "AnimateHeightChange: {from:" + this.a + ", to:" + this.b + ", dur: " + this.c + '}';
    }

    public final String toString() {
        return getTag();
    }

    public a(int r1, int r2, long r3, TimeInterpolator r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
