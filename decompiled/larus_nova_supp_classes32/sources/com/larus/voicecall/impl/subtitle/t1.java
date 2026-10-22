package com.larus.voicecall.impl.subtitle;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t1 implements com.larus.bmhome.upload.audio.l {
    public final /* synthetic */ c a;
    public final /* synthetic */ SubtitleSingleImageHolder b;

    public final void G0(float r2) {
        this.b.a.c.setProgress(r2);
    }

    public t1(c r1, SubtitleSingleImageHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void H0(com.larus.bmhome.upload.audio.b r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "req");
        FLogger.a.i("SubtitleSingleImageHolder", "upload photo failed. reason=" + r4);
        x3a.a r5 = this.a.i;
        if (r5 == null) goto L5;
        r5.i = Boolean.TRUE;
    L5:
        this.b.U3(true);
    }

    public final void I0(com.larus.bmhome.upload.audio.i r2, com.larus.bmhome.upload.audio.h r3) {
        Intrinsics.checkNotNullParameter(r2, "totalRes");
        Intrinsics.checkNotNullParameter(r3, "res");
        x3a.a r4 = this.a.i;
        if (r4 == null) goto L8;
        String r5 = r3.c();
        if (r5 != null) goto L7;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.g = r5;
    L8:
        com.larus.utils.e1.o(this.b.a.e);
        com.larus.utils.e1.o(this.b.a.c);
        FLogger.a.i("SubtitleSingleImageHolder", "upload photo success.");
    }
}
