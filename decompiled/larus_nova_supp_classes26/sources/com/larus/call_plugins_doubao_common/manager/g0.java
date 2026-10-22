package com.larus.call_plugins_doubao_common.manager;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.audio.ObricAudioServiceDelegate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 implements com.larus.media.v {
    public final /* synthetic */ n0 a;

    public g0(n0 r1) {
        this.a = r1;
    }

    public final boolean b(lk9.g r4) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        if (Intrinsics.areEqual(r4.getScene(), "SYSTEM") == false) goto L15;
        if (ObricAudioServiceDelegate.a.e() == false) goto L8;
        return false;
    L8:
        if (((Boolean) this.a.h.invoke()).booleanValue() == false) goto L10;
        return true;
    L10:
        if (((Boolean) this.a.e.invoke()).booleanValue() == false) goto L22;
        return false;
    L22:
        return true;
    L15:
        if (z2.a.realtimeCallAllSceneMixEnable() == true) goto L17;
    L19:
        Map r0 = com.larus.media.o0.a;
        return com.larus.media.o0.a("CALL_TTS_PLAY", r4.getScene());
    L17:
        if (o0.a.contains(r4.getScene()) == false) goto L19;
        return true;
    }

    public final void e(lk9.g r1) {
        com.larus.media.v.a.d(r1);
    }

    public final void f(MediaResourceManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void a(final lk9.g r4, final float r5) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        com.larus.media.v.a.f(r4, r5);
        final n0 r0 = this.a;
        r0.m.post(new f0(r0, r4, r5));
    }

    public final void d(lk9.g r1, lk9.g r2) {
        com.larus.media.v.a.c(r1, r2);
    }

    public final void g(lk9.g r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        com.larus.media.v.a.g(r2, r3);
        this.a.d.invoke(Float.valueOf(r3));
    }

    public final void i(final lk9.g r4, final lk9.g r5) {
        Intrinsics.checkNotNullParameter(r4, "current");
        Intrinsics.checkNotNullParameter(r5, "applicant");
        com.larus.media.v.a.e(r4, r5);
        final n0 r0 = this.a;
        r0.m.post(new e0(r0, r4, r5));
    }

    public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
        return com.larus.media.v.a.a(this, r1, r2, r3);
    }

    public final MediaOccupyStrategy h(lk9.g r2, lk9.g r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "current");
        Intrinsics.checkNotNullParameter(r3, "applicant");
        Map r0 = com.larus.media.o0.a;
        MediaOccupyStrategy r5 = com.larus.media.o0.b(r2.getScene(), r3.getScene());
        if (r5 == MediaOccupyStrategy.PAUSE) goto L5;
        return r5;
    L5:
        if (this.a.i(r4) == false) goto L9;
        FLogger.a.i(this.a.h(), "temporary loss focus, not pause by playGain/DuckApplicant");
        return MediaOccupyStrategy.REJECT;
    L9:
        return r5;
    }
}
