package com.bytedance.android.livesdk.floatview;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.dx;
import com.bytedance.android.livesdkapi.floatview.FloatWindowRevisitParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t extends rx1.c {
    public final /* synthetic */ VideoFloatWindowManager a;

    @Override // rx1.c, rx1.e
    public final void b() {
    }

    @Override // rx1.c, rx1.e
    public final void c() {
    }

    @Override // rx1.c, rx1.e
    public final void d() {
    }

    @Override // rx1.c, rx1.e
    public final void onHide() {
    }

    @Override // rx1.e
    public final void onShow() {
    }

    @Override // rx1.c, rx1.e
    public final void a() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    @Override // rx1.c, rx1.e
    public final void onClick() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.a.e;
        if (r0 == null) goto L5;
        int r2 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r0.k(null, null);
    L5:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L8;
        r1.setFloatWindowRevisitParam(new FloatWindowRevisitParam("out", SystemClock.elapsedRealtime(), "content", "1", null, 16, null));
    L8:
        String r3 = "";
        if (dx.a.getValue().booleanValue() == true) goto L17;
        IFloatWindowManager.a.a(this.a, false, 3);
        int r4 = l.a;
        Application r5 = jc1.a.b();
        Application r6 = jc1.a.b();
        if (r6 == null) goto L16;
        String r7 = r6.getPackageName();
        if (r7 == null) goto L16;
        r3 = r7;
    L16:
        l.b(r5, r3);
        return;
    L17:
        int r8 = l.a;
        Application r9 = jc1.a.b();
        Application r10 = jc1.a.b();
        if (r10 == null) goto L24;
        String r11 = r10.getPackageName();
        if (r11 == null) goto L24;
        r3 = r11;
    L24:
        if (l.b(r9, r3) != true) goto L28;
        IFloatWindowManager.a.a(this.a, false, 3);
        return;
    }

    public t(VideoFloatWindowManager r1) {
        this.a = r1;
    }
}
