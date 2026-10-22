package com.bytedance.android.livesdk.chatroom.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public final int a;
    public final int b;
    public final boolean c;

    public k(int r3, int r4, boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = false;
    L8:
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
