package com.larus.bmhome.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageList$c {
    public final int a;
    public final int b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatMessageList$c) == true) goto L8;
        return false;
    L8:
        ChatMessageList$c r6 = (ChatMessageList$c) r5;
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
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "PendingUnreadProgressAnchor(position=" + this.a + ", visibleHeight=" + this.b + ", itemHeight=" + this.c + ')';
    }

    public ChatMessageList$c(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
