package com.larus.bmhome.chat.deepresearch.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f1 {
    public final boolean a;

    public f1() {
        this(false);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f1) == true) goto L9;
        return false;
    L9:
        if (this.a == ((f1) r4).a) goto L11;
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
        return "MessageBoxConfig(useSubscribedColor=" + this.a + ')';
    }

    public f1(boolean r1) {
        this.a = r1;
    }
}
