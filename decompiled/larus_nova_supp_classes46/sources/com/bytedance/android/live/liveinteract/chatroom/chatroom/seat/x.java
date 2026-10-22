package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x extends w {
    public final String a;
    public final String b;

    public final String toString() {
        return "ThemedCompetitionSeatAnimEvent{ userId=" + this.a + ", url=" + this.b + '}';
    }

    public x(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.a = r2;
        this.b = r3;
    }
}
