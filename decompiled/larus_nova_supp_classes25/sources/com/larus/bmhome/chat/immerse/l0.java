package com.larus.bmhome.chat.immerse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 {
    public final int a;
    public final int b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "LastRoundChatInfo(lastRoundHeight=" + this.a + ", lastSelfMessageIndex=" + this.b + ", lastBotMessageMiss=" + this.c + ')';
    }

    public l0(int r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
