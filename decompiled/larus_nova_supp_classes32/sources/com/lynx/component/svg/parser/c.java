package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public SVG.b a;
    public final float b;
    public final float c;

    public c(c r2) {
        this.a = null;
        this.b = 14.0f;
        this.c = 14.0f;
        if (r2 != null) goto L5;
        return;
    L5:
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
    }

    public c(float r2, float r3) {
        this.a = null;
        this.b = 14.0f;
        this.c = 14.0f;
        this.b = r2;
        this.c = r3;
    }
}
