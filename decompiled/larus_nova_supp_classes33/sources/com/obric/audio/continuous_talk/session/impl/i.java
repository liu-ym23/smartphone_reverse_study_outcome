package com.obric.audio.continuous_talk.session.impl;

import com.larus.call_plugins_doubao_common.manager.n0;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements v {
    public final /* synthetic */ m a;
    public final /* synthetic */ Function1<Float, Unit> b;

    public final boolean b(lk9.g r4) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        FLogger r0 = FLogger.a;
        this.a.getClass();
        r0.i("ObricContTalkMediaManager", "canMixWith, applicant.scene: " + r4.getScene());
        this.a.getClass();
        if (m.n(r4) == false) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4.getScene(), "IM_TTS") == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r4.getScene(), "music") == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r4.getScene(), "music_gen") == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r4.getScene(), "NEWS") == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r4.getScene(), "AI_NOTE") == false) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r4.getScene(), "stream_player") == false) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r4.getScene(), "NAVIGATION") == true) goto L29;
        Map r1 = o0.a;
        return o0.a("CALL_TTS_PLAY", r4.getScene());
    L29:
        return false;
    }

    public final void e(lk9.g r5) {
        Intrinsics.checkNotNullParameter(r5, "applicant");
        v.a.d(r5);
        m r0 = this.a;
        final boolean r1 = r0.x;
        r0.x = false;
        FLogger r2 = FLogger.a;
        this.a.getClass();
        r2.i("ObricContTalkMediaManager", "onMediaInterrupted applicant=" + r5.getScene() + ", isInternalTakeover: " + r1);
        if (r1 == true) goto L5;
    L7:
        final m r6 = this.a;
        ((n0) r6).m.post(new g(r6, r1));
        return;
    L5:
        if ((r5 instanceof com.larus.media.model.a) == false) goto L7;
        Lazy r3 = MediaResourceManager.a;
        MediaResourceManager.a((com.larus.media.model.a) r5);
        goto L7
    }

    public final void f(MediaResourceManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public i(m r1, com.obric.audio.continuous_talk.session.impl.plugin.n r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(final lk9.g r4, final float r5) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        v.a.f(r4, r5);
        final m r0 = this.a;
        ((n0) r0).m.post(new d(r0, r4, r5));
    }

    public final void d(lk9.g r1, lk9.g r2) {
        v.a.c(r1, r2);
    }

    public final void g(lk9.g r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        v.a.g(r2, r3);
        this.b.invoke(Float.valueOf(r3));
    }

    public final void i(final lk9.g r4, final lk9.g r5) {
        Intrinsics.checkNotNullParameter(r4, "current");
        Intrinsics.checkNotNullParameter(r5, "applicant");
        v.a.e(r4, r5);
        final m r0 = this.a;
        ((n0) r0).m.post(new h(r0, r4, r5));
    }

    public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
        return v.a.a(this, r1, r2, r3);
    }

    public final MediaOccupyStrategy h(lk9.g r5, lk9.g r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "current");
        Intrinsics.checkNotNullParameter(r6, "applicant");
        FLogger r0 = FLogger.a;
        this.a.getClass();
        StringBuilder r1 = new StringBuilder("gainOccupiedStrategy: current=");
        r1.append(r5.getScene());
        r1.append(", applicant=");
        r1.append(r6.getScene());
        r1.append(", focusChange=");
        r1.append(r7);
        r1.append(", isThirdPartyApp=");
        this.a.getClass();
        r1.append(m.n(r6));
        r1.append(", isSystemNotification=");
        r1.append(Intrinsics.areEqual(r6.getScene(), "SYSTEM"));
        r0.i("ObricContTalkMediaManager", r1.toString());
        this.a.getClass();
        if (m.n(r6) == false) goto L8;
        ObricTtsControlDelegate r8 = ObricTtsControlDelegate.b;
        final m r9 = this.a;
        r8.i(new e(r9), new f(r9));
        MediaOccupyStrategy r10 = r8.x(r7);
        this.a.getClass();
        r0.i("ObricContTalkMediaManager", "gainOccupiedStrategy: third party app, strategy=" + r10);
        this.a.x = false;
        if (r10 == null) goto L7;
        return r10;
    L7:
        return MediaOccupyStrategy.INTERRUPT;
    L8:
        m r11 = this.a;
        r11.getClass();
        boolean r12 = Intrinsics.areEqual(r6.getScene(), "O_CALL");
        r11.x = r12;
        if (r12 == false) goto L12;
        r0.i("ObricContTalkMediaManager", "mark internal takeover by " + r6.getScene());
    L12:
        return MediaOccupyStrategy.INTERRUPT;
    }
}
