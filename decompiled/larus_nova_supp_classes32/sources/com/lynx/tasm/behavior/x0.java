package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x0 {
    public final ReadableMap a;
    public final MapBuffer b;

    public final boolean j() {
        ReadableMap r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        MapBuffer r1 = this.b;
        if (r1 != null) goto L9;
    L12:
        return true;
    L9:
        if (r1.count() == 0) goto L12;
    L11:
        return false;
    L5:
        if (r0.size() != 0) goto L11;
        goto L6
    }

    public final String toString() {
        return "{ " + x0.class.getSimpleName() + ": " + this.a.toString() + " }";
    }

    public x0(ReadableMap r2) {
        this.b = null;
        this.a = r2;
    }

    public final ReadableArray a(String r2) {
        return this.a.getArray(r2);
    }

    public final f6a.a d(String r2) {
        return this.a.getDynamic(r2);
    }

    public final ReadableMap g(String r2) {
        return this.a.getMap(r2);
    }

    public final String h(String r2) {
        return this.a.getString(r2);
    }

    public final boolean i(String r2) {
        return this.a.hasKey(r2);
    }

    public final boolean k(String r2) {
        return this.a.isNull(r2);
    }

    public x0(ReadableMap r2, MapBuffer r3) {
        this.b = null;
        this.a = r2;
        this.b = r3;
    }

    public final boolean b(String r2, boolean r3) {
        if (this.a.isNull(r2) == false) goto L6;
        return r3;
    L6:
        return this.a.getBoolean(r2);
    }

    public final double c(String r2, double r3) {
        if (this.a.isNull(r2) == false) goto L6;
        return r3;
    L6:
        return this.a.getDouble(r2);
    }

    public final float e(String r2, float r3) {
        if (this.a.isNull(r2) == false) goto L6;
        return r3;
    L6:
        return (float) this.a.getDouble(r2);
    }

    public final int f(String r2, int r3) {
        if (this.a.isNull(r2) == false) goto L6;
        return r3;
    L6:
        return this.a.getInt(r2);
    }
}
