package com.larus.common_ui.video;

import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ VideoPlayView a;
    public final /* synthetic */ long b;

    public /* synthetic */ m(VideoPlayView r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPlayView r0 = this.a;
        long r1 = this.b;
        int r3 = VideoPlayView.y1;
        if (r0.h(r1) == false) goto L42;
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("fitVideoSize isCenterCrop:");
        b r5 = r0.a;
        if (r5 == null) goto L8;
        Integer r6 = Integer.valueOf(r5.c);
    L9:
        r4.append(r6);
        r2.i("VideoPlayView", r4.toString());
        IVideoController r7 = r0.C;
        if (r7 == null) goto L12;
        r7.i(4);
    L12:
        String r8 = "";
        if (m5.c(r0.y) == false) goto L20;
        String r9 = r0.y;
        if (r9 == null) goto L18;
        r8 = r9;
    L18:
        r0.A(r8);
        return;
    L20:
        if (o0.d(r0.z) == false) goto L27;
        String r10 = r0.z;
        if (r10 == null) goto L25;
        r8 = r10;
    L25:
        r0.A(r8);
        return;
    L27:
        if (o0.d(r0.A) == false) goto L33;
        String r11 = r0.A;
        if (r11 == null) goto L32;
        r8 = r11;
    L32:
        r0.B(r8);
        return;
    L33:
        String r12 = r0.x;
        if (r12 == null) goto L37;
        r8 = r12;
    L37:
        r0.C(r8);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
