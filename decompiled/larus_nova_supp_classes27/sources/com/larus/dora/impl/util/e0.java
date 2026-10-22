package com.larus.dora.impl.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 {
    public final boolean a;

    public e0() {
        this(false);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (this.a == ((e0) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoraSoundAmbientVolumeUserConfig(hasUserModified=" + this.a + ')';
    }

    public e0(boolean r1) {
        this.a = r1;
    }
}
