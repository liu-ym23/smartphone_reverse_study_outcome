package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c) == true) goto L6;
        return false;
    L6:
        if (this.a == ((c) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "FirstDiscountModeChangeEvent(discountMode=" + this.a + ")";
    }

    public c(int r1) {
        this.a = r1;
    }
}
