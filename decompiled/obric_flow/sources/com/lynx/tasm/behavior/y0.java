package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableMap f10815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadableMapBuffer f10816b;

    public y0(ReadableMap r5) {
        this.f10816b = null;
        this.f10815a = r5;
    }

    public final double a(String r5, double r10) {
        ReadableMap r11 = this.f10815a;
        if (r11.isNull(r5) == false) goto L6;
        return r10;
    L6:
        return r11.getDouble(r5);
    }

    public final float b(float r5, String r10) {
        ReadableMap r11 = this.f10815a;
        if (r11.isNull(r10) == false) goto L6;
        return r5;
    L6:
        return (float) r11.getDouble(r10);
    }

    public final int c(String r5, int r10) {
        ReadableMap r11 = this.f10815a;
        if (r11.isNull(r5) == false) goto L6;
        return r10;
    L6:
        return r11.getInt(r5);
    }

    public final boolean d() {
        ReadableMap r5 = this.f10815a;
        if (r5 != null) goto L5;
    L6:
        ReadableMapBuffer r10 = this.f10816b;
        if (r10 != null) goto L9;
        return true;
    L9:
        if (r10.f21528b == 0) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r5.size() == 0) goto L6;
        return false;
    }

    public final boolean e(String r5, boolean r10) {
        ReadableMap r11 = this.f10815a;
        if (r11.isNull(r5) == false) goto L6;
        return r10;
    L6:
        return r11.getBoolean(r5);
    }

    public final String toString() {
        return "{ " + y0.class.getSimpleName() + ": " + this.f10815a.toString() + " }";
    }

    public y0(ReadableMap r5, ReadableMapBuffer r10) {
        this.f10815a = r5;
        this.f10816b = r10;
    }
}
