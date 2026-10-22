package com.larus.voicecall.impl.plugins;

import android.os.SystemClock;
import com.larus.audio.call.arch.c;
import com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager;
import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeSwitchMicroPlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> {
    public final String f;
    public b3 g;
    public boolean h;
    public int i;
    public final Lazy j;
    public long k;
    public final Lazy l;

    public static final class a implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ RealtimeSwitchMicroPlugin<C> b;

        public final String getName() {
            return this.a;
        }

        public a(RealtimeSwitchMicroPlugin<C> r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r9, jd9.c r10) {
            Intrinsics.checkNotNullParameter(r9, "oldState");
            Intrinsics.checkNotNullParameter(r10, "newState");
            boolean r0 = r10 instanceof jd9.c.a;
            if (r0 == false) goto L21;
            RealtimeSwitchMicroPlugin<C> r1 = this.b;
            int r2 = r1.i;
            if (r1.getContext().params().v == false) goto L7;
            int r3 = 2;
        L8:
            if (r2 >= r3) goto L21;
            if (com.larus.platform.service.z2.a.getRealCallSoundConfig().b == false) goto L21;
            if ((SystemClock.elapsedRealtime() - r1.k) <= ((Number) r1.j.getValue()).intValue()) goto L21;
            RealtimeCallUtil.a.getClass();
            com.larus.voicecall.impl.scene.o r4 = RealtimeCallUtil.l;
            if (r4 == null) goto L19;
            SceneModel r5 = r4.a;
            if (r5 == null) goto L19;
            String r6 = r5.getKey();
            if (r6 == null) goto L19;
        L20:
            RealtimeSwitchMicroPlugin.j3(r1, "tryTriggerPlayMicroVoiceOnConnected", r6, "answer_the_phone", "uninterrupt_bot");
            r1.i++;
        L19:
            r6 = NameKeys.UnloadStrategy_No_Strategy;
            goto L20
        L7:
            r3 = 1;
        L21:
            FLogger r7 = FLogger.a;
            String r8 = this.b.f;
            StringBuilder r11 = new StringBuilder("onConnectionStateChanged, oldState:");
            r11.append(r9);
            r11.append(", newState:");
            r11.append(r10);
            r11.append("  old_isPreConnect:");
            Boolean r12 = null;
            if ((r9 instanceof jd9.c.a) == false) goto L24;
            jd9.c.a r13 = (jd9.c.a) r9;
        L25:
            if (r13 == null) goto L27;
            Boolean r14 = Boolean.valueOf(r13.c);
        L28:
            r11.append(r14);
            r11.append("  new_isPreConnect:");
            if (r0 == false) goto L31;
            jd9.c.a r15 = (jd9.c.a) r10;
        L32:
            if (r15 == null) goto L34;
            r12 = Boolean.valueOf(r15.c);
        L34:
            r11.append(r12);
            r7.i(r8, r11.toString());
            return;
        L31:
            r15 = null;
            goto L32
        L27:
            r14 = null;
            goto L28
        L24:
            r13 = null;
            goto L25
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public boolean a;
        public final String b;
        public final /* synthetic */ RealtimeSwitchMicroPlugin<C> c;

        public final String g() {
            return this.b;
        }

        public b(RealtimeSwitchMicroPlugin<C> r1) {
            this.c = r1;
            this.b = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof pf9.a0) == false) goto L8;
            if (this.a == false) goto L25;
            this.a = false;
            return;
        L25:
            return;
        L8:
            if ((r3 instanceof pf9.d0) == false) goto L11;
            this.c.getClass();
            return;
        L11:
            if ((r3 instanceof pf9.e0) == false) goto L14;
            this.c.h = true;
            return;
        L14:
            if ((r3 instanceof pf9.z) == false) goto L17;
            this.a = true;
            return;
        L17:
            if ((r3 instanceof pf9.c0) == false) goto L20;
            this.c.getClass();
            return;
        L20:
            if ((r3 instanceof pf9.r) == false) goto L31;
            int r0 = sf9.b.a;
            if (sf9.b.a(((pf9.r) r3).getType()) == false) goto L32;
            this.c.getClass();
            return;
        L32:
            return;
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return new a(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final void X2() {
        if (com.larus.platform.service.z2.a.getRealCallSoundConfig().a == false) goto L15;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.v == true) goto L16;
        FLogger.a.i(this.f, "[interrupt] triggerPlayMicroVoice start");
        com.larus.voicecall.impl.scene.o r0 = RealtimeCallUtil.l;
        if (r0 == null) goto L12;
        SceneModel r1 = r0.a;
        if (r1 == null) goto L12;
        String r2 = r1.getKey();
        if (r2 == null) goto L12;
    L13:
        j3(this, "manual_interrupt", r2, "bot_finish_speaking", "manual_interrupte_bot");
        return;
    L12:
        r2 = NameKeys.UnloadStrategy_No_Strategy;
        goto L13
    L16:
        return;
    }

    public final void b3() {
        if (com.larus.platform.service.z2.a.getRealCallSoundConfig().d == false) goto L6;
        com.larus.utils.t0.a(new w2(this));
    L6:
        ((AudioSoundAppeaseManager) this.l.getValue()).f();
    }

    public final void e3() {
        super.e3();
        b3 r0 = new b3(this);
        this.g = r0;
        com.larus.audio.call.arch.b.a(getContext()).e0().i(r0);
    }

    public final void g3() {
        super.g3();
        CoroutineScope r1 = getContext().r();
        if (r1 == null) goto L5;
        BuildersKt.launch$default(r1, Dispatchers.getMain(), null, new RealtimeSwitchMicroPlugin$onStop$1(this, null), 2, null);
    L5:
        b3 r2 = this.g;
        if (r2 == null) goto L8;
        com.larus.audio.call.arch.b.a(getContext()).e0().j(r2);
    L8:
        this.g = null;
    }

    public final String T2() {
        return this.f;
    }

    public RealtimeSwitchMicroPlugin(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeSwitchMicroPlugin";
        this.j = LazyKt.lazy(new z2());
        this.l = LazyKt.lazy(new a3());
    }

    public static void j3(final RealtimeSwitchMicroPlugin r6, String r7, String r8, String r9, String r10) {
        if (r6.getContext().n().u == false) goto L6;
        return;
    L6:
        if (ObricFeatureServiceDelegate.b.a() == true) goto L8;
    L12:
        r6.k = SystemClock.elapsedRealtime();
        FLogger.a.i(r6.f, "[triggerPlayMicroVoice] start, from:".concat(r7));
        com.larus.utils.t0.a.post(new v2(r6));
        r6.getContext().k().l(r6.getContext().params().e, r6.getContext().params().o.h, r8, r9, r10);
        return;
    L8:
        if (r6.getContext().n().u == true) goto L14;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.G == true) goto L12;
        return;
    }
}
