package com.larus.call_plugins_doubao_common.manager;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.audio.ObricAudioServiceDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m0 implements com.larus.media.v {
    public final /* synthetic */ n0 a;

    public m0(n0 r1) {
        this.a = r1;
    }

    public final boolean b(lk9.g r4) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        if (Intrinsics.areEqual(r4.getScene(), "SYSTEM") == false) goto L16;
        if (ObricAudioServiceDelegate.a.e() == true) goto L16;
        if (((Boolean) this.a.g.invoke()).booleanValue() == false) goto L9;
        return true;
    L9:
        if (z2.a.realtimeSceneMixEnable() == true) goto L11;
    L13:
        return false;
    L11:
        if (((Boolean) this.a.e.invoke()).booleanValue() == true) goto L13;
        return true;
    L16:
        if (((Boolean) this.a.g.invoke()).booleanValue() == true) goto L18;
    L20:
        return false;
    L18:
        if (o0.a.contains(r4.getScene()) == false) goto L20;
        return true;
    }

    public final void e(lk9.g r1) {
        com.larus.media.v.a.d(r1);
    }

    public final void f(MediaResourceManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void a(lk9.g r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        com.larus.media.v.a.f(r2, r3);
        final n0 r4 = this.a;
        r4.m.post(new l0(r4));
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
        if (Intrinsics.areEqual(r5.getScene(), "dora") == true) goto L19;
        if (this.a.i(r6) == false) goto L9;
        FLogger.a.i(this.a.h(), "temporary loss focus, not pause by recordPlayApplicant");
        return MediaOccupyStrategy.REJECT;
    L9:
        if (((Boolean) this.a.g.invoke()).booleanValue() == true) goto L11;
    L16:
        final n0 r0 = this.a;
        r0.m.post(new k0(r0, r4, r5, r6));
        return MediaOccupyStrategy.PAUSE;
    L11:
        if (b(r5) == false) goto L16;
        if (Intrinsics.areEqual(r5.getScene(), "SYSTEM") == false) goto L16;
        FLogger.a.i(this.a.h(), "recordPlayApplicant#gainOccupiedStrategy() reject(keep call playing). applicant=" + r5.getScene() + " focusChange=" + r6);
        return MediaOccupyStrategy.REJECT;
    L19:
        return MediaOccupyStrategy.INTERRUPT;
    }
}
