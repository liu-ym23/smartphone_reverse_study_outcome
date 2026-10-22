package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends w {
    public boolean a;
    public boolean b;
    public final String c;
    public final int d;
    public final int e;
    public final Uri f;
    public final String g;
    public final String h;
    public final Function0<Unit> i;

    public final String toString() {
        return "GuestBattleSeatAnimEvent(userId=" + this.c + ", type=" + this.d + ", level=" + this.e + ", uri=" + this.f + ", animEnd=" + this.i + ", stop=" + this.a + ", forceCallback=" + this.b + ')';
    }

    public final int getType() {
        return this.d;
    }

    public /* synthetic */ b(String r9, int r10, Uri r11) {
        this(r9, r10, -1, r11, null, null, null);
    }

    public b(String r2, int r3, int r4, Uri r5, String r6, String r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }
}
