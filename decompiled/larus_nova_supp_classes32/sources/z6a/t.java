package z6a;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t {
    public final int a;
    public final float b;

    public final int hashCode() {
        return (this.a * 31) + Float.floatToIntBits(this.b);
    }

    public t(ReadableArray r3) {
        this.b = (float) r3.getDouble(0);
        this.a = r3.getInt(1);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (t.class != r5.getClass()) goto L17;
        t r6 = (t) r5;
        if (this.b == r6.b) goto L13;
    L15:
        return false;
    L13:
        if (this.a != r6.a) goto L15;
        return true;
    }
}
