package com.obric.audio.continuous_talk.session.impl;

import android.os.Handler;
import com.larus.call_plugins_doubao_common.manager.n0;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.v;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l implements v {
    public final /* synthetic */ m a;
    public final /* synthetic */ Function0<Boolean> b;
    public final /* synthetic */ Function0<Unit> c;

    public final boolean b(lk9.g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        if (Intrinsics.areEqual(r2.getScene(), "SYSTEM") == true) goto L5;
        return false;
    L5:
        if (z2.a.realtimeSceneMixEnable() == true) goto L7;
        return false;
    L7:
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L13;
        return true;
    L13:
        return false;
    }

    public final void e(lk9.g r6) {
        Intrinsics.checkNotNullParameter(r6, "applicant");
        v.a.d(r6);
        com.larus.media.model.a r0 = this.a.c();
        m r1 = this.a;
        final boolean r2 = r1.x;
        r1.x = false;
        FLogger r3 = FLogger.a;
        this.a.getClass();
        r3.i("ObricContTalkMediaManager", "onMediaInterrupted applicant=" + r6.getScene() + ", isInternalTakeover: " + r2);
        if (r2 == false) goto L5;
        Lazy r7 = MediaResourceManager.a;
        MediaResourceManager.a(r0);
    L5:
        final m r8 = this.a;
        ((n0) r8).m.post(new j(r8, r2));
    }

    public final void f(MediaResourceManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void a(lk9.g r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "applicant");
        v.a.f(r3, r4);
        final m r5 = this.a;
        Handler r6 = ((n0) r5).m;
        final Function0<Unit> r0 = this.c;
        r6.post(new k(r5, r0));
    }

    public final void d(lk9.g r1, lk9.g r2) {
        v.a.c(r1, r2);
    }

    public final void g(lk9.g r1, float r2) {
        v.a.g(r1, r2);
    }

    public final void i(lk9.g r1, lk9.g r2) {
        v.a.e(r1, r2);
    }

    public l(m r1, Function0 r2, com.obric.audio.continuous_talk.session.impl.plugin.m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
        return v.a.a(this, r1, r2, r3);
    }

    public final MediaOccupyStrategy h(lk9.g r2, lk9.g r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "current");
        Intrinsics.checkNotNullParameter(r3, "applicant");
        if (Intrinsics.areEqual(r3.getScene(), "dora") == true) goto L9;
        if (this.a.i(r4) == false) goto L9;
        FLogger r5 = FLogger.a;
        this.a.getClass();
        r5.i("ObricContTalkMediaManager", "temporary loss focus, not pause by recordPlayApplicant");
        return MediaOccupyStrategy.REJECT;
    L9:
        return MediaOccupyStrategy.INTERRUPT;
    }
}
