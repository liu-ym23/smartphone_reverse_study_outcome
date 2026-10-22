package com.larus.audio.call.aec;

import android.os.Handler;
import android.os.SystemClock;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.f;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements w {
    public final AtomicBoolean a;
    public final ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> b;
    public final f c;
    public q d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.aec.w
    public final void d() {
        if (this.d != null) goto L6;
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[onRefSentenceEnded] refSentence is null");
        return;
    L6:
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("AecProcessor2", "[onRefSentenceEnded]");
        q r1 = this.d;
        if (r1 == null) goto L10;
        r0.i("AecRefSentence", "onDataEnd");
        r1.f = true;
        return;
    }

    @Override // com.larus.audio.call.aec.w
    public final void e() {
        if (this.d != null) goto L6;
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[onRefSentencePlayFirstFrame] refSentence is null");
        return;
    L6:
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("AecProcessor2", "[onRefSentencePlayFirstFrame]");
        q r1 = this.d;
        if (r1 != null) goto L9;
        return;
    L9:
        monitor-enter(r1);
        r1.c = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r3 = r1.a();     // Catch: Throwable -> L21
        if (r3 != (-1)) goto L18;
        r0.e("AecRefSentence", "onFirstFrame:NO_REF");     // Catch: Throwable -> L21
        if (f.c().appContext().g() == true) goto L17;
        monitor-exit(r1);
        return;
    L17:
        throw new IllegalStateException("no ref when first frame");     // Catch: Throwable -> L21
    L18:
        long r5 = r1.c - r3;     // Catch: Throwable -> L21
        StringBuilder r8 = new StringBuilder("onFirstFrame:");     // Catch: Throwable -> L21
        SimpleDateFormat r2 = c.a;     // Catch: Throwable -> L21
        r8.append(c.a(r1.c));     // Catch: Throwable -> L21
        r8.append(", firstBlock:");     // Catch: Throwable -> L21
        r8.append(c.a(r3));     // Catch: Throwable -> L21
        r8.append(", gap:");     // Catch: Throwable -> L21
        r8.append(r5 / ((long) 1000000));     // Catch: Throwable -> L21
        r8.append("ms");     // Catch: Throwable -> L21
        r0.i("AecRefSentence", r8.toString());     // Catch: Throwable -> L21
        r1.e(r5);     // Catch: Throwable -> L21
        monitor-exit(r1);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final boolean k() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    @Override // com.larus.audio.call.aec.w
    public final void release() {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        StringBuilder r1 = new StringBuilder("[release][true][");
        if (this.d == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(']');
        r0.i("AecProcessor2", r1.toString());
        this.a.set(false);
        i("release", false);
        com.larus.audio.call.util.c.a(new AecProcessor2$release$1(this, null));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public i() {
        this.a = new AtomicBoolean(false);
        this.b = new ConcurrentLinkedQueue();
        this.c = new f();
        this.e = -1;
        this.f = -1;
        this.h = true;
        this.i = LazyKt.lazy(new h());
    }

    @Override // com.larus.audio.call.aec.w
    public final boolean a(com.larus.audio.call.plugins.m r6) {
        Intrinsics.checkNotNullParameter(r6, "onAudioDataReceived");
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return true;
    L5:
        this.c.b(f.b(true), f.a(true, k(), null), k(), r6);
        f r7 = this.c;
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r0 = this.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "queue");
        r7.d = r0;
        boolean r8 = this.c.f;
        com.larus.audio.call.util.e.a.i("AecProcessor2", "[init]:" + r8);
        return r8;
    }

    @Override // com.larus.audio.call.aec.w
    public final void c(byte[] r26) {
        Intrinsics.checkNotNullParameter(r26, "data");
        if (this.d != null) goto L6;
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[onReceiveRefData] refSentence is null");
        return;
    L6:
        com.larus.audio.call.util.e r2 = com.larus.audio.call.util.e.a;
        r2.i("AecProcessor2", "[onReceiveRefData]");
        q r8 = this.d;
        if (r8 == null) goto L54;
        int r3 = r.a;
        boolean r4 = k();
        Intrinsics.checkNotNullParameter(r26, "array");
        long r6 = ((((long) r26.length) * 1000000) * ((long) CommandStatus.DORA_TRACE)) / ((long) (f.a(true, r4, null).c * 2));
        monitor-enter(r8);
        Intrinsics.checkNotNullParameter(r26, "data");     // Catch: Throwable -> L51
        if (r8.f == false) goto L15;
        r2.e("AecRefSentence", "[REF][APPEND][AFTER_END]");     // Catch: Throwable -> L51
        monitor-exit(r8);
        return;
    L15:
        long r12 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L51
        long r14 = r8.a();     // Catch: Throwable -> L51
        k r5 = (k) CollectionsKt.lastOrNull(r8.a);     // Catch: Throwable -> L51
        if (r5 != null) goto L20;
        r5 = r8.b;     // Catch: Throwable -> L51
        if (r5 != null) goto L20;
        long r0 = -1;
    L23:
        if (r14 <= 0) goto L25;
        boolean r21 = true;
    L27:
        if (r21 == true) goto L29;
        long r7 = r6 + r12;     // Catch: Throwable -> L51
        r2.w("AecRefSentence", "[REF][FIRST][" + c.a(r12) + " - " + c.a(r7) + ']');     // Catch: Throwable -> L51
    L45:
        long r9 = r7;
        long r10 = r12;
    L48:
        ((ConcurrentLinkedQueue) r8.a).offer(new k(r10, r9, r26));     // Catch: Throwable -> L51
        monitor-exit(r8);
        return;
    L29:
        long r11 = r8.d;     // Catch: Throwable -> L51
        if (r11 <= r8.e) goto L32;
        boolean r16 = true;
    L33:
        if (r16 == false) goto L39;
        if (r11 > r0) goto L37;
        long r13 = r6 + r0;     // Catch: Throwable -> L51
        r2.i("AecRefSentence", "[REF][APPEND][PAUSE][" + c.a(r14) + " - " + c.a(r0) + " - " + c.a(r13) + "][NOW:" + c.a(r12) + ']');     // Catch: Throwable -> L51
    L47:
        r9 = r13;
        r10 = r0;
        goto L48
    L37:
        long r1 = r6 + r12;     // Catch: Throwable -> L51
        r2.e("AecRefSentence", "[REF][RESET][PAUSE][" + c.a(r12) + " - " + c.a(r1) + ']');     // Catch: Throwable -> L51
        r7 = r1;
        goto L45
    L39:
        if (r8.c != (-1)) goto L41;
        long r15 = 0;
    L43:
        if (r15 <= 0) goto L46;
        r2.e("AecRefSentence", "[REF][RESET][GAP][" + c.a(r14) + " - " + c.a(r0) + "][NOW:" + c.a(r12) + ']');     // Catch: Throwable -> L51
        r7 = r6 + r12;     // Catch: Throwable -> L51
        goto L45
    L46:
        r13 = r6 + r0;     // Catch: Throwable -> L51
        r2.i("AecRefSentence", "[REF][APPEND][" + c.a(r14) + " - " + c.a(r0) + " - " + c.a(r13) + "][NOW:" + c.a(r12) + ']');     // Catch: Throwable -> L51
        goto L47
    L41:
        r15 = r12 - r0;     // Catch: Throwable -> L51
        goto L43
    L32:
        r16 = false;
        goto L33
    L25:
        r21 = false;
    L20:
        r0 = r5.b;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized void f(String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "reason");     // Catch: Throwable -> L18
        com.larus.audio.call.util.e r1 = com.larus.audio.call.util.e.a;     // Catch: Throwable -> L18
        StringBuilder r3 = new StringBuilder("[resume][");     // Catch: Throwable -> L18
        r3.append(r8);     // Catch: Throwable -> L18
        r3.append("][");     // Catch: Throwable -> L18
        boolean r0 = true;
        if (this.d == null) goto L7;
        boolean r9 = true;
    L8:
        r3.append(r9);     // Catch: Throwable -> L18
        r3.append(']');     // Catch: Throwable -> L18
        r1.i("AecProcessor2", r3.toString());     // Catch: Throwable -> L18
        this.h = false;     // Catch: Throwable -> L18
        q r10 = this.d;     // Catch: Throwable -> L18
        if (r10 != null) goto L11;
    L16:
        monitor-exit(this);
        return;
    L11:
        if (r10.d > r10.e) goto L14;
        r0 = false;
    L14:
        if (r0 == false) goto L16;
        r10.f();     // Catch: Throwable -> L18
        goto L16
    L7:
        r9 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final void g(Map<String, String> r6) {
        String r0 = "";
        if (r6 == null) goto L6;
        String r1 = r6.get("sentence_id");
        if (r1 == null) goto L6;
    L7:
        if (r6 == null) goto L10;
        String r2 = r6.get("message_id");
        if (r2 == null) goto L10;
    L11:
        if (r6 == null) goto L16;
        String r7 = r6.get("tts_content_scene");
        if (r7 == null) goto L16;
        r0 = r7;
    L16:
        com.larus.audio.call.util.e.a.i("AecProcessor2", "[onRefSentenceStart] sentenceId: " + r1 + ", messageId: " + r2 + ", scene: " + r0);
        this.d = new q(r2, r1, r0);
        return;
    L10:
        r2 = "";
    L6:
        r1 = "";
        goto L7
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized byte[] b(byte[] r14, Long r15) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r14, "micData");     // Catch: Throwable -> L38
        if (this.a.get() == true) goto L7;
    L35:
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[CalcRefData] return, init:" + this.a.get() + ", modelInit:" + this.c.f);     // Catch: Throwable -> L38
        monitor-exit(this);
        return null;
    L7:
        if (this.c.f == false) goto L35;
        if (this.h == false) goto L14;
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[CalcRefData][isAecPaused]");     // Catch: Throwable -> L38
        monitor-exit(this);
        return null;
    L14:
        long r2 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L38
        int r1 = r.a;     // Catch: Throwable -> L38
        boolean r3 = k();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r14, "originData");     // Catch: Throwable -> L38
        v58.a r4 = f.b(r3);     // Catch: Throwable -> L38
        if (r4.b != 12) goto L17;
        int r5 = 2;
    L18:
        long r6 = ((((long) r14.length) * 1000000) * ((long) CommandStatus.DORA_TRACE)) / ((long) ((r4.a * 2) * r5));     // Catch: Throwable -> L38
        int r7 = r.a(r14, k());     // Catch: Throwable -> L38
        byte[] r12 = new byte[r7];     // Catch: Throwable -> L38
        if (r6 > 0) goto L26;
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[CalcRefData][INVALID], micDuration:" + r6 + ", refSize: " + r7);     // Catch: Throwable -> L38
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r16 = this.b;     // Catch: Throwable -> L38
        SAMICoreVoiceAssistantAudioData r0 = new SAMICoreVoiceAssistantAudioData();     // Catch: Throwable -> L38
        r0.data = r14;     // Catch: Throwable -> L38
        r0.refData = r12;     // Catch: Throwable -> L38
        r16.offer(r0);     // Catch: Throwable -> L38
        f r17 = this.c;     // Catch: Throwable -> L38
        Handler r19 = r17.i;     // Catch: Throwable -> L38
        if (r19 == null) goto L23;
        r19.post(new d(r17));     // Catch: Throwable -> L38
    L23:
        monitor-exit(this);
        return r12;
    L26:
        Pair<Long, Long> r110 = j(r15, r2, r6);     // Catch: Throwable -> L38
        q r8 = this.d;     // Catch: Throwable -> L38
        if (r8 == null) goto L29;
        r8.b(((Number) r110.getFirst()).longValue(), ((Number) r110.getSecond()).longValue(), r12);     // Catch: Throwable -> L38
    L29:
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r9 = this.b;     // Catch: Throwable -> L38
        SAMICoreVoiceAssistantAudioData r10 = new SAMICoreVoiceAssistantAudioData();     // Catch: Throwable -> L38
        r10.data = r14;     // Catch: Throwable -> L38
        r10.refData = r12;     // Catch: Throwable -> L38
        r9.offer(r10);     // Catch: Throwable -> L38
        f r111 = this.c;     // Catch: Throwable -> L38
        Handler r11 = r111.i;     // Catch: Throwable -> L38
        if (r11 == null) goto L32;
        r11.post(new d(r111));     // Catch: Throwable -> L38
    L32:
        this.e = ((Number) r110.getFirst()).longValue();     // Catch: Throwable -> L38
        this.f = ((Number) r110.getSecond()).longValue();     // Catch: Throwable -> L38
        monitor-exit(this);
        return r12;
    L17:
        r5 = 1;
    L38:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized void h(String r12, boolean r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "reason");     // Catch: Throwable -> L23
        long r2 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L23
        com.larus.audio.call.util.e r4 = com.larus.audio.call.util.e.a;     // Catch: Throwable -> L23
        StringBuilder r6 = new StringBuilder("[pause-start][");     // Catch: Throwable -> L23
        r6.append(r12);     // Catch: Throwable -> L23
        r6.append("][pauseRef:");     // Catch: Throwable -> L23
        r6.append(r13);     // Catch: Throwable -> L23
        r6.append("][hasSentence:");     // Catch: Throwable -> L23
        q r1 = this.d;     // Catch: Throwable -> L23
        boolean r7 = false;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        r6.append(r3);     // Catch: Throwable -> L23
        r6.append("][");     // Catch: Throwable -> L23
        r6.append(r2);     // Catch: Throwable -> L23
        r6.append(']');     // Catch: Throwable -> L23
        r4.i("AecProcessor2", r6.toString());     // Catch: Throwable -> L23
        this.h = true;     // Catch: Throwable -> L23
        this.e = -1;     // Catch: Throwable -> L23
        this.f = -1;     // Catch: Throwable -> L23
        if (r13 == false) goto L15;
        q r5 = this.d;     // Catch: Throwable -> L23
        if (r5 == null) goto L15;
        r4.i("AecRefSentence", "onPause");     // Catch: Throwable -> L23
        r5.d = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L23
    L15:
        StringBuilder r8 = new StringBuilder("[pause-end][");     // Catch: Throwable -> L23
        r8.append(r12);     // Catch: Throwable -> L23
        r8.append("][pauseRef:");     // Catch: Throwable -> L23
        r8.append(r13);     // Catch: Throwable -> L23
        r8.append("][hasSentence:");     // Catch: Throwable -> L23
        q r14 = this.d;     // Catch: Throwable -> L23
        if (r14 != null) goto L18;
    L20:
        r8.append(r7);     // Catch: Throwable -> L23
        r8.append("][");     // Catch: Throwable -> L23
        r8.append(r2);     // Catch: Throwable -> L23
        r8.append(']');     // Catch: Throwable -> L23
        r4.i("AecProcessor2", r8.toString());     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L18:
        if (r14.d() != true) goto L20;
        r7 = true;
        goto L20
    L7:
        if (r1.d() != true) goto L9;
        r3 = true;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final void i(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        StringBuilder r1 = new StringBuilder("[clearData][");
        r1.append(r5);
        r1.append("][continueRecord:");
        r1.append(r6);
        r1.append("][hasSentence:");
        q r7 = this.d;
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        r1.append(r8);
        r1.append(']');
        r0.i("AecProcessor2", r1.toString());
        q r9 = this.d;
        if (r9 == null) goto L11;
        r0.i("AecRefSentence", "onDataEnd");
        r9.f = true;
    L11:
        if (r6 == true) goto L14;
        this.e = -1;
        this.f = -1;
        return;
    L14:
        return;
    L5:
        if (r7.d() != true) goto L7;
        r8 = true;
        goto L8
    }

    public final Pair<Long, Long> j(Long r7, long r8, long r10) {
        if (this.e == (-1)) goto L12;
        long r0 = this.f;
        if (r0 == (-1)) goto L12;
        long r11 = r10 + r0;
        long r9 = r11 - r8;
        if (r9 <= this.g) goto L11;
        com.larus.audio.call.util.e.a.e("AecProcessor2", "[FATAL][CalcRefData] return, endTime-now Gap:" + r9 + ", maxGap:" + this.g);
    L11:
        return TuplesKt.to(Long.valueOf(r0), Long.valueOf(r11));
    L12:
        if (r7 == null) goto L14;
        long r1 = r8 - r7.longValue();
    L15:
        this.g = r1;
        com.larus.audio.call.util.e.a.i("AecProcessor2", "MAX_GAP: " + this.g);
        return TuplesKt.to(Long.valueOf(r8 - r10), Long.valueOf(r8));
    L14:
        r1 = 20000000;
        goto L15
    }
}
