package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.scope.o;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements o, com.bytedance.android.live.broadcastgame.xplay.littlewindow.a {
    public int a;
    public d0 b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        d0 r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L6;
        XplayLog.b("XplayCaptureService", "roomContext is null");
        return;
    L6:
        com.bytedance.android.live.pushstream.d r1 = (com.bytedance.android.live.pushstream.d) r0.getLiveStream().getValue();
        if (r1 == null) goto L9;
        r4 = r1.A();
    L9:
        if (r4 != null) goto L12;
        XplayLog.b("XplayCaptureService", "liveCore is null");
        return;
    L12:
        this.b = r4;
    }

    public final void onStop() {
        if (this.a == (-1)) goto L8;
        int r0 = XplayLog.a;
        XplayLog.c("XplayCaptureService", "restore video device: " + this.a);
        d0 r1 = this.b;
        if (r1 == null) goto L7;
        r1.o();
    L7:
        this.a = -1;
    L8:
        this.b = null;
    }

    public j() {
        this.a = -1;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.a
    public final void setRadioMode(boolean r4) {
        d0 r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = XplayLog.a;
        XplayLog.c("XplayCaptureService", "setRadioMode " + r4 + ", old video device=" + this.a);
        if (r4 == false) goto L12;
        if (this.a != (-1)) goto L10;
        this.a = r0.g();
    L10:
        r0.o();
        return;
    L12:
        if (this.a == (-1)) goto L16;
        r0.o();
        this.a = -1;
        return;
    }
}
