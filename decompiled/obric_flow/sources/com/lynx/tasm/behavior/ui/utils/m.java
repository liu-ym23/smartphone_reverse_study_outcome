package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final m e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f10758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10760c;
    public final int d;

    static {
        e = new m();
    }

    public m() {
        this.f10758a = 0.5f;
        this.f10759b = 1;
        this.f10760c = 0.5f;
        this.d = 1;
    }

    public m(ReadableArray r5) {
        this.f10758a = (float) r5.getDouble(0);
        this.f10759b = r5.getInt(1);
        if (r5.size() < 4) goto L6;
        this.f10760c = (float) r5.getDouble(2);
        this.d = r5.getInt(3);
        return;
    L6:
        this.f10760c = 0.5f;
        this.d = 1;
    }
}
