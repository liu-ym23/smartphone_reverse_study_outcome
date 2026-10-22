package com.obric.assistant.view.listening;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements b {
    public final long a;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L9;
        return false;
    L9:
        if (this.a == ((i) r8).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "ObricLocalListeningUiTarget(generation=" + this.a + ')';
    }

    public i(long r1) {
        this.a = r1;
    }
}
