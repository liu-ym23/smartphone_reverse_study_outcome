package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static final l e = null;
    public final float a;
    public final int b;
    public final float c;
    public final int d;

    static {
        e = new l();
    }

    public l() {
        this.a = 0.5f;
        this.b = 1;
        this.c = 0.5f;
        this.d = 1;
    }

    public l(ReadableArray r4) {
        this.a = (float) r4.getDouble(0);
        this.b = r4.getInt(1);
        if (r4.size() < 4) goto L5;
        this.c = (float) r4.getDouble(2);
        this.d = r4.getInt(3);
        return;
    L5:
        this.c = 0.5f;
        this.d = 1;
    }
}
