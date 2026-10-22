package com.larus.asr.session.clicktalk;

import com.larus.asr.session.e2;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.voicecall.api.autostop.AutoStopAsrServiceProviderDelegate;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t implements l {
    public final k a;
    public final a3a.c b;

    @Override // com.larus.asr.session.clicktalk.l
    public final void stop() {
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void a() {
        Intrinsics.checkNotNullParameter("", "endMethod");
        this.a.onEvent(new j.e(""));
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void p() {
        this.b.p();
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void q() {
        this.b.q();
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void release() {
        this.b.release();
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void r(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        this.b.r(r4);     // Catch: Throwable -> L6
        this.a.onEvent(j.m.a);
        return;
    L6:
        th = move-exception;
        k r0 = this.a;
        String r5 = th.getMessage();
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r0.onEvent(new j.d(null, null, r5, null));
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void updateScreenshotForAsr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tosKey");
        this.b.updateScreenshotForAsr(r2);
    }

    public t(Function0 r3, e2 r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r4, "eventListener");
        this.a = r4;
        this.b = AutoStopAsrServiceProviderDelegate.b.a(new s(this), r3, null);
    }
}
