package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public long a;
    public int b;
    public EXGaugeLevel c;

    public static final class a {
    }

    static {
    }

    public h() {
        this.c = EXGaugeLevel.INNATE;
    }

    public final void a(int r8, boolean r9) {
        long r0 = System.currentTimeMillis();
        long r2 = this.a;
        if (r2 != 0) goto L5;
        float r3 = 1.0f;
    L7:
        if (RangesKt.coerceAtLeast((int) ((r8 - this.b) / r3), 1) >= 4) goto L9;
        EXGaugeLevel r10 = EXGaugeLevel.INNATE;
    L12:
        this.c = r10;
        this.a = r0;
        this.b = r8;
        return;
    L9:
        if (r9 == false) goto L11;
        r10 = EXGaugeLevel.OVERHEATED;
        goto L12
    L11:
        r10 = EXGaugeLevel.HEATED;
        goto L12
    L5:
        r3 = (r0 - r2) / 1000.0f;
        goto L7
    }
}
