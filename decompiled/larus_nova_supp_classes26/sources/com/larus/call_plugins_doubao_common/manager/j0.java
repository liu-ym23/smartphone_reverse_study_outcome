package com.larus.call_plugins_doubao_common.manager;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j0 implements com.larus.media.v {
    public final /* synthetic */ n0 a;

    public j0(n0 r1) {
        this.a = r1;
    }

    public final boolean b(lk9.g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
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
        r0.m.post(new h0(r0, r4, r5));
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

    public final MediaOccupyStrategy h(final lk9.g r4, final lk9.g r5, final int r6) {
        Intrinsics.checkNotNullParameter(r4, "current");
        Intrinsics.checkNotNullParameter(r5, "applicant");
        if (this.a.i(r6) == false) goto L6;
        FLogger.a.i(this.a.h(), "temporary loss focus, not pause by recordApplicant");
        return MediaOccupyStrategy.REJECT;
    L6:
        final n0 r0 = this.a;
        r0.m.post(new i0(r0, r4, r5, r6));
        return MediaOccupyStrategy.PAUSE;
    }
}
