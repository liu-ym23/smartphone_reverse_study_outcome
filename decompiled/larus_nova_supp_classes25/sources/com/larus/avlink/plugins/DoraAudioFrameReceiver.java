package com.larus.avlink.plugins;

import android.os.SystemClock;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.l;
import com.larus.settings.value.e10;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class DoraAudioFrameReceiver extends com.larus.audio.call.plugins.e<n4> {
    public final Function0<com.larus.im.service.audio.s> l;
    public final boolean m;
    public String n;

    public static final class a {
    }

    static {
    }

    public void R1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "caller");
        l4 r0 = getContext().c(Reflection.getOrCreateKotlinClass(l4.class), null);
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.l0() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        com.larus.avlink.n1.d(((com.larus.audio.call.plugins.e) this).g, "skip prepare to play after env observe stop conversation, caller=".concat(r10));
        return;
    L11:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraAudioFrameReceiver$prepareToPlay$1(this, r10, null), 3, null);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void j3(Object r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        l4 r0 = getContext().c(Reflection.getOrCreateKotlinClass(l4.class), null);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
    L19:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L24;
        com.larus.avlink.n1.d(((com.larus.audio.call.plugins.e) this).g, "drop audio data after env observe stop conversation");
        return;
    L24:
        boolean r4 = r8 instanceof l;
        if (r4 == false) goto L27;
        l r5 = (l) r8;
    L28:
        if (r5 == null) goto L37;
        t4 r6 = (t4) getContext().c(Reflection.getOrCreateKotlinClass(t4.class), null);
        if (r6 != null) goto L32;
    L34:
        boolean r7 = false;
    L35:
        if (r7 != true) goto L37;
        r1 = true;
        goto L37
    L32:
        if (r6.L1(r5) != true) goto L34;
        r7 = true;
    L37:
        if (r1 == false) goto L41;
        com.larus.avlink.n1.d(((com.larus.audio.call.plugins.e) this).g, "skip normal tts player for TTSPlay frame");
        return;
    L41:
        if (getContext().params().s != AudioSessionType.SAMI) goto L45;
        String r9 = ((com.larus.audio.call.plugins.e) this).g;
        StringBuilder r10 = new StringBuilder("settings: ");
        e10 r11 = e10.a;
        r10.append(e10.p());
        r10.append(", avSessionType: ");
        r10.append(getContext().params().s);
        com.larus.avlink.n1.d(r9, r10.toString());
        super.j3(r8);
        return;
    L45:
        if (((com.larus.audio.call.plugins.e) this).i.a() == true) goto L49;
        com.larus.avlink.n1.d(((com.larus.audio.call.plugins.e) this).g, "old logic");
        return;
    L49:
        if ((r8 instanceof com.larus.audio.call.play.h.c) == false) goto L51;
        return;
    L51:
        if ((r8 instanceof com.larus.audio.call.play.h.b) == true) goto L58;
        if (r4 == false) goto L59;
        long r12 = SystemClock.elapsedRealtime();
        l r13 = (l) r8;
        l r14 = ((com.larus.im.service.audio.s) this.l.invoke()).a(r13);
        long r15 = SystemClock.elapsedRealtime();
        k3(r13, r14);
        long r16 = SystemClock.elapsedRealtime() - r12;
        long r17 = r15 - r12;
        if (r17 <= 12) goto L60;
        com.larus.avlink.n1.b(((com.larus.audio.call.plugins.e) this).g, "[handleData] process " + r17 + "ms, all " + r16 + "ms.");
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L27:
        r5 = null;
        goto L28
    L11:
        if ((r8 instanceof l) == false) goto L13;
    L20:
        r3 = true;
        goto L21
    L13:
        if ((r8 instanceof com.larus.audio.call.play.h.a) == true) goto L20;
        if ((r8 instanceof com.larus.audio.call.play.h.c) == true) goto L20;
        if ((r8 instanceof com.larus.audio.call.play.h.b) == false) goto L19;
    L5:
        if (r0.l0() != true) goto L7;
        r2 = true;
        goto L8
    }

    public void k3(l r6, l r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "handledFrame");
        t4 r8 = (t4) getContext().c(Reflection.getOrCreateKotlinClass(t4.class), null);
        if (r8 == null) goto L5;
        r8.G2();
    L5:
        String r9 = r7.c() + '_' + ((String) r7.i.getValue()) + '_' + sf9.a.d(r7.b(), "task_id");
        int r0 = sf9.a.b(r7.b(), "status", 0);
        com.larus.avlink.n1.d(((com.larus.audio.call.plugins.e) this).g, "handleFrameOnNotSAMISession, audioId: " + r9 + ", audioStatus: " + r0);
        if (r0 != 1) goto L9;
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.a(r7.a, r7.d(), r7.c(), r7.b()));
        com.larus.audio.call.arch.b.a(getContext()).p0(com.larus.audio.call.play.h.b.a);
        return;
    L9:
        if (Intrinsics.areEqual(r9, this.n) == true) goto L11;
        this.n = r9;
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.c(null));
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.a(r7.a, r7.d(), r7.c(), r7.b()));
        return;
    L11:
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.a(r7.a, r7.d(), r7.c(), r7.b()));
    }

    public DoraAudioFrameReceiver(n4 r2, com.larus.audio.call.arch.n r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "postProcessor");
        super(r2, r3);
        this.l = r3;
        this.m = r4;
    }
}
