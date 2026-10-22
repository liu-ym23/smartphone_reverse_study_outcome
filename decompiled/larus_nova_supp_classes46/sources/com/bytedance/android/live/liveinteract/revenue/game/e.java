package com.bytedance.android.live.liveinteract.revenue.game;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final boolean a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final String f;
    public final List<Long> g;
    public long h;
    public int i;

    public final String toString() {
        return "LinkMicGameState(isOpen=" + this.a + ", gameId=" + this.b + ", gameCategory=" + this.c + ", runningType=" + this.d + ", publicStreamType=" + this.e + ", audienceToast=" + this.f + ", kickOutUserIds=" + this.g + ", targetUiLayout=" + this.h + ", source=" + this.i + ')';
    }

    public e(boolean r1, String r2, String r3, Integer r4, Integer r5, String r6, List<Long> r7, long r8, int r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r10;
    }
}
