package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.animation.ValueAnimator;
import android.content.Context;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.platform.api.IVideoController;
import com.larus.utils.t0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final Lazy b;
    public ValueAnimator c;
    public ValueAnimator d;
    public volatile boolean e;
    public final com.larus.media.model.a f;

    public interface a {
    }

    public static final class b {
    }

    public static final class c implements com.larus.media.v {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public final void e(lk9.g r5) {
            Intrinsics.checkNotNullParameter(r5, "applicant");
            com.larus.media.v.a.d(r5);
            l r6 = this.a;
            r6.getClass();
            t0.e(new g(r6, 11000, null));
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
        if (this.e == false) goto L5;
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

    public l() {
        this.a = LazyKt.lazy(new h());
        this.b = LazyKt.lazy(new i());
        this.f = new com.larus.media.model.a(null, "DORA_ONBOARDING_BACKGROUND", false, 0, 2, false, 0, false, false, 0, false, new c(this), 2029);
    }

    public final void d(Function0<Unit> r4) {
        g49.d.a("DoraOnboardingBgMusicPlayerV2", "stopPlay: isPlaying=" + this.e);     // Catch: Exception -> L9
        if (this.e == false) goto L11;
        this.e = false;     // Catch: Exception -> L9
        IVideoController r1 = a();     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        r1.stop();     // Catch: Exception -> L9
    L11:
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.f);
        if (r4 == null) goto L17;
        r4.invoke();
        return;
    L17:
        return;
    L9:
        e = move-exception;
        g49.d.c("DoraOnboardingBgMusicPlayerV2", "stopPlay: error", e);
        goto L11
    }

    public static void c(final l r9, final Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter("dora_onboarding_background_music.mp3", "path");
        ValueAnimator r0 = r9.c;
        final boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L15;
        ValueAnimator r3 = r9.c;
        if (r3 == null) goto L13;
        r3.cancel();
    L13:
        ValueAnimator r11 = tk9.b.a(0.0f, 1.0f, 200, new d(r9, r10, r1), new e(r9), new f(r9));
        r9.c = r11;
        r11.start();
        return;
    L15:
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r2 = true;
        goto L8
    }
}
