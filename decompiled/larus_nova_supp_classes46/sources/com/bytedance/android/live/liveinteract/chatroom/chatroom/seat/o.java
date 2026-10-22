package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends d {
    public d b;
    public d c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void c(d r1) {
    }

    public o() {
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final d a() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        d r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        if (this.b != null) goto L5;
        this.b = r2;
        this.c = r2;
        return;
    L5:
        d r0 = this.c;
        if (r0 == null) goto L8;
        r0.c(r2);
    L8:
        this.c = r2;
    }
}
