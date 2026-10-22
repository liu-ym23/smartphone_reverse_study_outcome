package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.config.ik1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends com.bytedance.android.live.broadcastgame.xplay.screendetect.a {
    public static final /* synthetic */ int k = 0;
    public volatile boolean d;
    public long e;
    public long f;
    public final long[] g;
    public int h;
    public long i;
    public final b j;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ f a;

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            if (r5.what != 1) goto L6;
            this.a.b("no frame receive, during " + this.a.h().a());
            f.i(this.a, "ttlive_xplay_anchor_screen_detect_no_frame", 0, "during", 2);
            return;
        }

        public b(f r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void f() {
        if (this.d == true) goto L5;
        return;
    L5:
        this.d = false;
        if (this.f == 0) goto L8;
    L10:
        this.j.removeCallbacksAndMessages(null);
        long[] r1 = this.g;
        int r2 = r1.length;
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r5 >= r2) goto L13;
        long r7 = r1[r5];
        this.g[r6] = 0;
        r5 = r5 + 1;
        r6 = r6 + 1;
        goto L11
    L13:
        this.f = 0;
        this.i = 0;
        this.e = 0;
        this.h = 0;
        return;
    L8:
        if ((System.currentTimeMillis() - this.e) <= h().a()) goto L10;
        b("onStop, not receive frame");
        i(this, "ttlive_xplay_anchor_screen_detect_no_frame", 0, "onStop", 2);
        goto L10
    }

    public final ik1.a h() {
        return this.a.a();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void e() {
        if (h().b() == true) goto L6;
        return;
    L6:
        if (this.d == false) goto L8;
        return;
    L8:
        this.d = true;
        this.e = System.currentTimeMillis();
        this.h = 0;
        this.j.sendEmptyMessageDelayed(1, h().a());
    }

    public f(c r2) {
        super(r2);
        this.g = new long[h().d()];
        this.j = new b(this, Looper.getMainLooper());
    }

    public static void i(final f r6, String r7, int r8, String r9, int r11) {
        if ((r11 & 2) == 0) goto L5;
        final int r2 = -1;
    L7:
        if ((r11 & 4) == 0) goto L9;
        r9 = "";
    L9:
        final String r3 = r9;
        r6.getClass();
        final long r4 = System.currentTimeMillis();
        long r12 = r6.i;
        if (r12 != 0) goto L12;
    L14:
        r6.i = r4;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a.d(r6, r7, com.bytedance.android.live.broadcastgame.xplay.screendetect.a.a(r6, new XplayAnchorScreenDetector$reportDetectRes$1(r6, r2, r3, r4)));
        return;
    L12:
        if (((r4 - r12) / ((long) 1000)) >= r6.h().e()) goto L14;
        return;
    L5:
        r2 = r8;
        goto L7
    }
}
