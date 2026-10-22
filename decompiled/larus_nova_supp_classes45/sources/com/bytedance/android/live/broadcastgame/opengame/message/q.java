package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements com.bytedance.android.live.broadcastgame.a0 {
    public String a;
    public Long b;

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // com.bytedance.android.live.broadcastgame.a0
    public final boolean a(com.bytedance.android.live.broadcastgame.v r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        if ((r8 instanceof m) == true) goto L5;
    L28:
        return false;
    L5:
        if ((r8 instanceof f0) == false) goto L7;
        return false;
    L7:
        m r0 = (m) r8;
        if (r0.c != (-1)) goto L11;
        return false;
    L11:
        if ((r8 instanceof y) == true) goto L13;
    L15:
        String r9 = this.a;
        if (r9 != null) goto L18;
    L27:
        return true;
    L18:
        if (this.b == null) goto L27;
        if ((!Intrinsics.areEqual(r0.a, r9)) == true) goto L27;
        long r3 = r0.c;
        Long r11 = this.b;
        if (r11 == null) goto L27;
        if (r3 == r11.longValue()) goto L28;
    L13:
        if (((y) r8).f != 1) goto L15;
        return false;
    }
}
