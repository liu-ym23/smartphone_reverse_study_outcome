package com.larus.dora.impl.onboarding;

import android.animation.ValueAnimator;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.platform.api.IVideoController;
import com.larus.utils.t0;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r {
    public static final /* synthetic */ int h = 0;
    public final Lazy a;
    public final String b;
    public final Lazy c;
    public ValueAnimator d;
    public ValueAnimator e;
    public volatile boolean f;
    public final com.larus.media.model.a g;

    public interface a {
    }

    public static final class b {
    }

    public static final class c implements com.larus.media.v {
        public final /* synthetic */ r a;

        public c(r r1) {
            this.a = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public final void e(lk9.g r3) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.d(r3);
            r.e(this.a, null, 3);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            com.larus.media.v.a.f(r1, r2);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    static {
    }

    public final IVideoController a() {
        return (IVideoController) this.a.getValue();
    }

    public final void b() {
        if (this.f == false) goto L5;
        d(null);
    L5:
        IVideoController r0 = a();
        if (r0 == null) goto L8;
        r0.t();
    L8:
        IVideoController r1 = a();
        if (r1 == null) goto L12;
        r1.release();
        return;
    }

    public r() {
        this.a = LazyKt.lazy(new h());
        this.b = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + File.separator + "dora_onboarding_background_music.mp3";
        this.c = LazyKt.lazy(new i());
        this.g = new com.larus.media.model.a(null, "DORA_ONBOARDING_BACKGROUND", false, 0, 2, false, 0, false, false, 0, false, new c(this), 2029);
    }

    public final void d(Function0<Unit> r4) {
        g49.d.a("DoraOnboardingBgMusicPlayer", "stopPlay: isPlaying=" + this.f);     // Catch: Exception -> L9
        if (this.f == false) goto L11;
        this.f = false;     // Catch: Exception -> L9
        IVideoController r1 = a();     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        r1.stop();     // Catch: Exception -> L9
    L11:
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.g);
        if (r4 == null) goto L17;
        r4.invoke();
        return;
    L17:
        return;
    L9:
        e = move-exception;
        g49.d.c("DoraOnboardingBgMusicPlayer", "stopPlay: error", e);
        goto L11
    }

    public static void c(final r r8, final Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ValueAnimator r0 = r8.d;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isRunning() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        g49.d.a("DoraOnboardingBgMusicPlayer", "[playAudio] globalAnimator isRunning ");
        return;
    L10:
        ValueAnimator r2 = r8.d;
        if (r2 == null) goto L13;
        r2.cancel();
    L13:
        ValueAnimator r10 = tk9.b.a(0.0f, 1.0f, 200, new l(r8, r9), new m(r8), new n(r8));
        r8.d = r10;
        r10.start();
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static void e(final r r2, final Function0 r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        final long r0 = 11000;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        r2.getClass();
        t0.e(new o(r2, r0, r3));
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
