package com.larus.bmhome.chat.component.bottom.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r7 implements t1a.c {
    public final int a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof r7) == true) goto L9;
        return false;
    L9:
        if (this.a == ((r7) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "CoreInputConfig(initalStatus=" + this.a + ')';
    }

    public r7() {
        this.a = -1;
    }
}
