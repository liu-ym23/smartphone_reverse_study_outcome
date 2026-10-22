package com.obric.assistant.chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricChatUIServiceImpl$b {
    public final long a;
    public final int b;
    public final boolean c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ObricChatUIServiceImpl$b) == true) goto L8;
        return false;
    L8:
        ObricChatUIServiceImpl$b r9 = (ObricChatUIServiceImpl$b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "MessageHeightCache(time=" + this.a + ", height=" + this.b + ", isKeyguardTipsMessage=" + this.c + ')';
    }

    public ObricChatUIServiceImpl$b(long r1, int r3, boolean r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
