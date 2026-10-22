package com.larus.voicecall.impl.ui;

import android.view.OrientationEventListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends OrientationEventListener {
    public final /* synthetic */ RealtimeCallActivity a;

    public d(RealtimeCallActivity r2) {
        this.a = r2;
        super(r2, 3);
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r6) {
        int r0 = 0;
        if (r6 < 0) goto L6;
        if (r6 >= 46) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
    L36:
        r0 = 1;
    L37:
        FLogger.a.i("RealtimeCallActivity", "setPad newOrientation=" + r0 + ", orientationValue=" + r6);
        this.a.setRequestedOrientation(r0);
        RealtimeCallActivity r7 = this.a;
        OrientationEventListener r1 = r7.h;
        if (r1 == null) goto L40;
        r1.disable();
    L40:
        r7.h = null;
        return;
    L9:
        if (315 <= r6) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L36;
        if (46 > r6) goto L20;
        if (r6 >= 136) goto L20;
        boolean r2 = true;
    L21:
        if (r2 == false) goto L24;
        r0 = 8;
        goto L37
    L24:
        if (136 > r6) goto L27;
        if (r6 >= 226) goto L27;
        boolean r5 = true;
    L28:
        if (r5 == false) goto L30;
        r0 = 9;
        goto L37
    L30:
        if (226 > r6) goto L33;
        if (r6 >= 315) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L36;
    L33:
        r8 = false;
    L27:
        r5 = false;
    L20:
        r2 = false;
        goto L21
    L11:
        if (r6 >= 361) goto L13;
        r4 = true;
    L6:
        r3 = false;
        goto L7
    }
}
