package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadableArray f10754c;

    public k(pm.a r5, int r10) {
        if (r10 != 2) goto L5;
        this.f10754c = r5.asArray();
    L9:
        this.f10752a = r10;
        return;
    L5:
        if (r10 != 0) goto L7;
    L8:
        this.f10753b = (float) r5.asDouble();
        goto L9
    L7:
        if (r10 != 1) goto L9;
        goto L8
    }

    public static float b(ReadableArray r10, float r11, int r12, float r13) {
        if (r12 == 1) goto L5;
        if (r12 != 0) goto L9;
        return r11;
    L9:
        if (r12 != 2) goto L23;
        int r14 = 0;
        float r5 = 0.0f;
    L12:
        if (r14 >= r10.size()) goto L22;
        int r15 = r10.getInt(r14 + 1);
        if (r15 != 2) goto L17;
        ReadableArray r16 = r10.getArray(r14);
    L16:
        float r17 = 0.0f;
    L21:
        r5 = r5 + b(r16, r17, r15, r13);
        r14 = r14 + 2;
        goto L12
    L17:
        r16 = null;
        if (r15 == 0) goto L20;
        if (r15 != 1) goto L16;
    L20:
        r17 = (float) r10.getDouble(r14);
        goto L21
    L22:
        return r5;
    L23:
        return 0.0f;
    L5:
        return r11 * r13;
    }

    public final float a() {
        if (this.f10752a == 0) goto L5;
        return 0.0f;
    L5:
        return this.f10753b;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        k r10 = (k) r5;
        int r11 = r10.f10752a;
        int r12 = this.f10752a;
        if (r12 == r11) goto L9;
        return false;
    L9:
        if (r12 == 2) goto L13;
        return com.lynx.tasm.utils.a.k(this.f10753b, r10.f10753b);
    L13:
        return this.f10754c.asArrayList().equals(r10.f10754c.asArrayList());
    }

    public k(float r5) {
        this.f10753b = r5;
        this.f10752a = 0;
    }
}
