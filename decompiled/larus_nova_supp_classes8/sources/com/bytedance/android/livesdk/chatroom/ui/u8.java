package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u8 {
    public final String a;
    public final long b;
    public final Function2<Long, RoomAuthStatus.Style, Unit> c;
    public final RoomAuthStatus.Style d;

    public u8() {
        throw null;
    }

    public u8(String r1, long r2, Function2 r4, RoomAuthStatus.Style r5, int r6) {
        if ((r6 & 8) == 0) goto L5;
        r5 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r4, "setAuthValue");
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
