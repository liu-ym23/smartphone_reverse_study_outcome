package com.bytedance.android.live.liveinteract.plantform.utils;

import android.view.KeyEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ m0 a;

    public l0(m0 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.livesdk.event.a r6 = (com.bytedance.android.livesdk.event.a) r5;
        if (r6 == null) goto L32;
        m0 r0 = this.a;
        if (r0.a() == true) goto L40;
        float r2 = r0.a.getStreamVolume(0) / r0.a.getStreamMaxVolume(0);
        KeyEvent r7 = r6.c;
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.getKeyCode());
    L11:
        if (r8 != null) goto L14;
    L22:
        if (r8 != null) goto L25;
        return;
    L25:
        if (r8.intValue() != 25) goto L37;
        int r9 = r0.b;
        if (r9 <= 100) goto L38;
        int r10 = r9 - r0.c;
        r0.b = r10;
        hg6.g r1 = r0.h;
        if (r1 == null) goto L39;
        r1.d(r10);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (r8.intValue() != 24) goto L22;
        if (r2 < 0.5f) goto L33;
        int r11 = r0.b;
        if (r11 >= 180) goto L34;
        int r12 = r11 + r0.c;
        r0.b = r12;
        hg6.g r3 = r0.h;
        if (r3 == null) goto L35;
        r3.d(r12);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L10:
        r8 = null;
        goto L11
    L40:
        return;
    }
}
