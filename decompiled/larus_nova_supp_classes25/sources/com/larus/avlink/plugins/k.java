package com.larus.avlink.plugins;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends com.larus.audio.call.plugins.a {
    public final m4 b;
    public volatile String c;
    public volatile SVResult d;
    public volatile boolean e;
    public volatile Boolean f;
    public final buc.a g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.d == null) goto L15;
        SVResult r0 = this.d;
        SVResult r4 = SVResult.NONE;
        if (r0 == r4) goto L7;
    L16:
        this.d = null;
        this.e = false;
        this.f = null;
        this.g.d(false);
        return;
    L7:
        if (this.e == false) goto L9;
    L10:
        com.larus.avlink.n1.d("DoraAudioSourceController", "svResult is queryEnd, isPause is " + this.e + ", isPlaying is " + m30getContext().e0().isPlaying() + ", stop current playing  in " + this.c);
        m30getContext().e0().d(true, true, "query end");
        m30getContext().a(TriggerMode.TTS_PLAYBACK_INTERRUPT);
        IRealtimeCallTracer r1 = m30getContext().U9();
        String r2 = this.c;
        Boolean r3 = this.f;
        if (r3 == null) goto L13;
        boolean r5 = r3.booleanValue();
    L14:
        r1.q0(r2, r5, r4.getValue());
        goto L16
    L13:
        r5 = false;
        goto L14
    L9:
        if (m30getContext().e0().isPlaying() == false) goto L16;
    L15:
        com.larus.avlink.n1.d("DoraAudioSourceController", "svResult is null in queryEnd in " + this.c);
        d("query end");
        goto L16
    }

    public /* bridge */ /* synthetic */ com.larus.audio.call.plugins.u0 getContext() {
        return m30getContext();
    }

    /* JADX INFO: renamed from: getContext, reason: collision with other method in class */
    public m4 m30getContext() {
        return this.b;
    }

    public k(BaseDoraCallAudioPlugin.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = r2;
        this.g = buc.b.a(false);
    }

    public final void a(pf9.a r11) {
        if (r11 == null) goto L79;
        Map r12 = r11.d;
        if (r12 == null) goto L79;
        String r13 = (String) r12.get("sv_result");
        if (r13 == null) goto L79;
        SVResult r2 = SVResult.NONE;
        String r6 = null;
        if (Intrinsics.areEqual(r13, r2.getValue()) == true) goto L11;
        SVResult r3 = SVResult.FALSE;
        boolean r7 = false;
        if (Intrinsics.areEqual(r13, r3.getValue()) == true) goto L27;
        SVResult r4 = SVResult.TRUE;
        if (Intrinsics.areEqual(r13, r4.getValue()) == true) goto L49;
        com.larus.avlink.n1.d("DoraAudioSourceController", "svResult is exception: " + r13 + " in " + this.c);
        d("query update");
        return;
    L49:
        if (this.d != r4) goto L53;
        com.larus.avlink.n1.d("DoraAudioSourceController", "Repetitive svResult is true  in " + this.c);
        return;
    L53:
        if (this.d != r3) goto L60;
        IRealtimeCallTracer r14 = m30getContext().U9();
        String r5 = this.c;
        Boolean r8 = this.f;
        if (r8 == null) goto L57;
        boolean r9 = r8.booleanValue();
    L58:
        r14.q0(r5, r9, r4.getValue());
        goto L60
    L57:
        r9 = false;
    L60:
        if (this.e == false) goto L62;
    L68:
        StringBuilder r15 = new StringBuilder("current svResult is true, pre svResult is ");
        SVResult r10 = this.d;
        if (r10 == null) goto L71;
        r6 = r10.getValue();
    L71:
        r15.append(r6);
        r15.append(", isPause is ");
        r15.append(this.e);
        r15.append(", isPlaying is ");
        r15.append(m30getContext().e0().isPlaying());
        r15.append(", stop current playing  in ");
        r15.append(this.c);
        com.larus.avlink.n1.d("DoraAudioSourceController", r15.toString());
        this.d = r4;
        m30getContext().e0().d(true, true, "query update");
        m30getContext().a(TriggerMode.TTS_PLAYBACK_INTERRUPT);
        this.e = false;
    L73:
        if (this.g.a(false, true) == false) goto L85;
        IRealtimeCallTracer r16 = m30getContext().U9();
        String r0 = this.c;
        Boolean r1 = this.f;
        if (r1 == null) goto L77;
        r7 = r1.booleanValue();
    L77:
        r16.q0(r0, r7, r4.getValue());
        return;
    L85:
        return;
    L62:
        if (m30getContext().e0().isPlaying() == true) goto L68;
        StringBuilder r17 = new StringBuilder("current svResult is true, pre svResult is ");
        SVResult r18 = this.d;
        if (r18 == null) goto L67;
        r6 = r18.getValue();
    L67:
        r17.append(r6);
        r17.append(", isPause is ");
        r17.append(this.e);
        r17.append(", isPlaying is ");
        r17.append(m30getContext().e0().isPlaying());
        r17.append(", no pause or playing, not stop  in ");
        r17.append(this.c);
        com.larus.avlink.n1.d("DoraAudioSourceController", r17.toString());
        this.d = r4;
        goto L73
    L27:
        if (this.d != r3) goto L31;
        com.larus.avlink.n1.d("DoraAudioSourceController", "Repetitive svResult is false  in " + this.c);
        return;
    L31:
        if (this.e == false) goto L36;
        StringBuilder r19 = new StringBuilder("current svResult is false, pre svResult is ");
        SVResult r20 = this.d;
        if (r20 == null) goto L35;
        r6 = r20.getValue();
    L35:
        r19.append(r6);
        r19.append(", isPause is true, isPlaying is ");
        r19.append(m30getContext().e0().isPlaying());
        r19.append(", resume current playing  in ");
        r19.append(this.c);
        com.larus.avlink.n1.d("DoraAudioSourceController", r19.toString());
        this.d = r3;
        m30getContext().e0().resume("query update");
        m30getContext().a(TriggerMode.TTS_PLAYBACK_RESUME);
        this.e = false;
    L41:
        if (this.g.a(false, true) == false) goto L83;
        IRealtimeCallTracer r110 = m30getContext().U9();
        String r21 = this.c;
        Boolean r22 = this.f;
        if (r22 == null) goto L45;
        r7 = r22.booleanValue();
    L45:
        r110.q0(r21, r7, r3.getValue());
        return;
    L83:
        return;
    L36:
        StringBuilder r111 = new StringBuilder("current svResult is false, pre svResult is ");
        SVResult r23 = this.d;
        if (r23 == null) goto L39;
        r6 = r23.getValue();
    L39:
        r111.append(r6);
        r111.append(", isPause is false, isPlaying is ");
        r111.append(m30getContext().e0().isPlaying());
        r111.append(", no pause, not resume  in ");
        r111.append(this.c);
        com.larus.avlink.n1.d("DoraAudioSourceController", r111.toString());
        this.d = r3;
        goto L41
    L11:
        if (this.d != r2) goto L15;
        com.larus.avlink.n1.d("DoraAudioSourceController", "Repetitive svResult is none in " + this.c);
        return;
    L15:
        if (m30getContext().e0().isPlaying() == false) goto L20;
        StringBuilder r112 = new StringBuilder("current svResult is none, pre svResult is ");
        SVResult r24 = this.d;
        if (r24 == null) goto L19;
        r6 = r24.getValue();
    L19:
        r112.append(r6);
        r112.append(", isPause is ");
        r112.append(this.e);
        r112.append(", isPlaying is true, pause current playing  in ");
        r112.append(this.c);
        com.larus.avlink.n1.d("DoraAudioSourceController", r112.toString());
        this.d = r2;
        m30getContext().e0().pause("query update");
        m30getContext().a(TriggerMode.TTS_PLAYBACK_PAUSE);
        this.e = true;
        this.f = Boolean.TRUE;
        return;
    L20:
        this.f = Boolean.FALSE;
        StringBuilder r113 = new StringBuilder("current svResult is none, pre svResult is ");
        SVResult r25 = this.d;
        if (r25 == null) goto L23;
        r6 = r25.getValue();
    L23:
        r113.append(r6);
        r113.append(", isPause is ");
        r113.append(this.e);
        r113.append(", isPlaying is false, no playing, not pause  in ");
        r113.append(this.c);
        com.larus.avlink.n1.d("DoraAudioSourceController", r113.toString());
        this.d = r2;
        return;
    L79:
        com.larus.avlink.n1.d("DoraAudioSourceController", "svResult is null in query update in " + this.c);
        d("query update");
    }

    public final void d(String r3) {
        if (m30getContext().e0().isPlaying() == false) goto L6;
        com.larus.avlink.n1.d("DoraAudioSourceController", "no svResult, stop current playing");
        m30getContext().e0().d(true, true, r3);
        m30getContext().a(TriggerMode.TTS_PLAYBACK_INTERRUPT);
        return;
    }

    public final void c(String r1, Boolean r2) {
        this.c = r1;
    }
}
