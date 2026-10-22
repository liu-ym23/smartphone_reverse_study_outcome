package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v extends com.larus.audio.call.play.e {
    public final /* synthetic */ u<com.larus.audio.call.arch.c> a;

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void a() {
        com.larus.audio.call.util.e.a.i(this.a.T2(), "onTTSEnded");
        com.larus.audio.call.aec.w r0 = this.a.q3();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void c() {
        com.larus.audio.call.util.e.a.i(this.a.T2(), "onPlayFirstFrame");
        u<com.larus.audio.call.arch.c> r0 = this.a;
        r0.t = SystemClock.elapsedRealtime();
        com.larus.audio.call.aec.w r1 = this.a.q3();
        if (r1 == null) goto L6;
        r1.e();
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onPlayComplete() {
        com.larus.audio.call.util.e.a.i(this.a.T2(), "onPlayComplete");
        this.a.t = -1;
    }

    public v(u<com.larus.audio.call.arch.c> r1) {
        this.a = r1;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void b(Map<String, String> r4) {
        com.larus.audio.call.util.e.a.i(this.a.T2(), "onTTSStart");
        com.larus.audio.call.aec.w r0 = this.a.q3();
        if (r0 == null) goto L6;
        r0.g(r4);
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void d(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a.F1(r2);
        com.larus.audio.call.aec.w r0 = this.a.q3();
        if (r0 == null) goto L6;
        r0.c(r2.a);
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void e(boolean r3) {
        this.a.t = -1;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void f(TtsPlayEndType r5) {
        Intrinsics.checkNotNullParameter(r5, "endType");
        com.larus.audio.call.util.e.a.i(this.a.T2(), "onPlayEnd");
        Intrinsics.checkNotNullParameter(r5, "endType");
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "audio");
        this.a.i(r2);
    }
}
