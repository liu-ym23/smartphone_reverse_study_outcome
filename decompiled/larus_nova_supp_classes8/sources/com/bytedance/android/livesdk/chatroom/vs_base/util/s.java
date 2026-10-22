package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.ttm.player.LoadControl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s extends LoadControl {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public int f;

    public static final class a {
    }

    static {
    }

    public final int onCodecStackSelected(int r3) {
        if (r3 != 1) goto L5;
    L8:
        return 0;
    L5:
        if (r3 == 2) goto L8;
        return -1;
    }

    public final int onFilterStackSelected(int r3) {
        if (r3 != 1) goto L5;
    L8:
        return 0;
    L5:
        if (r3 == 2) goto L8;
        return -1;
    }

    public final int onTrackSelected(int r3) {
        if (r3 != 1) goto L5;
    L8:
        return 0;
    L5:
        if (r3 == 2) goto L8;
        return -1;
    }

    public s() {
        this.a = 400;
        this.b = 800;
        this.c = 500;
        this.d = 5000;
        this.e = 0.9f;
    }

    public final boolean shouldStartPlayback(long r5, float r7, boolean r8) {
        if (r8 == false) goto L8;
        int r9 = this.c;
        long r10 = (long) Math.min(r9 + ((this.f * this.e) * r9), this.d);
        ALogger.d("ReplayPlayerLoadControl", "needBufferedMs = " + r10);
        if (r5 < r10) goto L6;
        this.f++;
        ALogger.d("ReplayPlayerLoadControl", " parameters:  sdp " + this.a + " sdnp " + this.b + " rdi " + this.c + " rdm " + this.d + " rif " + this.e + " rit 0");
        StringBuilder r0 = new StringBuilder(" buffer end:  rebuf count ");
        r0.append(this.f);
        r0.append(", need buf ");
        r0.append(r10);
        r0.append(", now buf ");
        r0.append(r5);
        ALogger.d("ReplayPlayerLoadControl", r0.toString());
        return true;
    L6:
        return false;
    L8:
        Intrinsics.checkNotNull(null);
        throw null;
    }
}
