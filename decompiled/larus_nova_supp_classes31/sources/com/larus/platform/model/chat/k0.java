package com.larus.platform.model.chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k0 {
    public final boolean a;

    public k0() {
        this(true);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof k0) == true) goto L9;
        return false;
    L9:
        if (this.a == ((k0) r4).a) goto L11;
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
        return "PreviewPageConfig(previewUpdatesEnable=" + this.a + ')';
    }

    public k0(boolean r1) {
        this.a = r1;
    }
}
