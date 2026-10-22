package com.larus.audio.utils;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AudioLoadManager$a implements com.larus.media.v {
    public ValueAnimator a;

    public AudioLoadManager$a() {
    }

    public final boolean b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        return true;
    }

    public final void e(g r3) {
        Intrinsics.checkNotNullParameter(r3, "applicant");
        if (Intrinsics.areEqual(r3.getScene(), "dora") == false) goto L5;
        com.larus.utils.t0.e(new o(this));
    L10:
        com.larus.media.v.a.d(r3);
        return;
    L5:
        AudioLoadManager r0 = AudioLoadManager.a;
        IVideoController r1 = AudioLoadManager.b();
        if (r1 == null) goto L8;
        final float r2 = r1.g();
    L9:
        com.larus.utils.t0.e(new p(this, r2));
        goto L10
    L8:
        r2 = 1.0f;
        goto L9
    }

    public final void f(MediaResourceManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void a(g r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        AudioLoadManager r0 = AudioLoadManager.a;
        com.larus.media.v.a.f(r2, r3);
    }

    public final void d(g r1, g r2) {
        com.larus.media.v.a.c(r1, r2);
    }

    public final void g(g r4, final float r5) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        com.larus.media.v.a.g(r4, r5);
        AudioLoadManager r0 = AudioLoadManager.a;
        FLogger.a.i("AudioLoadManager", "audio focus onMediaVolumeChange. applicant:" + r4 + ", volumeFactor: " + r5 + '.');
        new Handler(Looper.getMainLooper()).post(new q(this, r5));
    }

    public final void i(g r1, g r2) {
        com.larus.media.v.a.e(r1, r2);
    }

    public final MediaOccupyStrategy c(g r1, g r2, int r3) {
        return com.larus.media.v.a.a(this, r1, r2, r3);
    }

    public final MediaOccupyStrategy h(g r1, g r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "current");
        Intrinsics.checkNotNullParameter(r2, "applicant");
        return MediaOccupyStrategy.INTERRUPT;
    }
}
