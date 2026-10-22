package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g6 extends mk1.b {
    public final int a;
    public final RoomAuthStatus.Style b;

    public final mk1.a a() {
        int r0 = this.a;
        String r2 = null;
        if (r0 != 0) goto L5;
        RoomAuthStatus.Style r3 = this.b;
        if (r3 == null) goto L29;
        r2 = r3.getContent();
    L29:
        return new mk1.a(0, r2, this.b);
    L5:
        if (r0 != 1) goto L7;
        RoomAuthStatus.Style r1 = this.b;
        if (r1 == null) goto L33;
        r2 = r1.getContent();
    L33:
        return new mk1.a(1, r2, this.b);
    L7:
        if (r0 == 2) goto L12;
        RoomAuthStatus.Style r4 = this.b;
        if (r4 == null) goto L30;
        r2 = r4.getContent();
    L30:
        return new mk1.a(0, r2, this.b);
    L12:
        RoomAuthStatus.Style r5 = this.b;
        if (r5 != null) goto L15;
    L17:
        RoomAuthStatus.Style r6 = this.b;
        if (r6 == null) goto L32;
        r2 = r6.getContent();
    L32:
        return new mk1.a(2, r2, this.b);
    L15:
        if (r5.getUnableStyle() != 1) goto L17;
        return new mk1.a(3, this.b.getContent(), this.b);
    }

    public final mk1.c b() {
        mk1.c r0 = mk1.c.b;
        return mk1.c.c;
    }

    public g6(boolean r3, RoomAuthStatus.Style r4) {
        if (r3 == false) goto L4;
        long r0 = 0;
    L5:
        this((int) r0, r4);
        return;
    L4:
        r0 = 2;
        goto L5
    }

    public g6(int r1, RoomAuthStatus.Style r2) {
        this.a = r1;
        this.b = r2;
    }
}
