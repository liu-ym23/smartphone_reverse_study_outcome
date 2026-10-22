package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends k {
    public final String f;
    public final String g;
    public final String h;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{appId:");
        r0.append(this.a);
        r0.append(", roomId:");
        r0.append(this.b);
        r0.append(", seqNum:");
        r0.append(this.d);
        r0.append(", connId:");
        r0.append(this.c);
        r0.append(", sendType:");
        r0.append(this.e);
        r0.append(", data:");
        r0.append(this.f);
        r0.append(", audienceOpenId:");
        String r1 = this.g;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        r0.append(", extra:");
        String r3 = this.h;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    }

    public a(String r13, long r14, long r16, long r18, String r21, long r22, String r23) {
        Intrinsics.checkNotNullParameter(r13, "appId");
        Intrinsics.checkNotNullParameter(r21, "data");
        super(r13, r14, r16, r18, r22);
        this.f = r21;
        this.g = r23;
        this.h = null;
    }
}
