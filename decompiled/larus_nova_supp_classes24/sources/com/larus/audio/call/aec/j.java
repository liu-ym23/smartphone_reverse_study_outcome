package com.larus.audio.call.aec;

import android.media.AudioRecord;
import android.os.Handler;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.f;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j implements v {
    public final ConcurrentLinkedQueue<z> a;
    public z b;
    public int c;
    public int d;
    public final String e;
    public boolean f;
    public long g;
    public long h;
    public boolean i;
    public int j;
    public final ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> k;
    public boolean l;
    public long m;
    public final boolean n;
    public final v58.a o;
    public final com.larus.audio.call.play.b p;
    public final String q;
    public final f r;
    public final b s;

    @Override // com.larus.audio.call.aec.w
    public final synchronized void e() {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.larus.audio.call.aec.v
    public final void R1() {
        com.larus.audio.call.util.e.a.i(this.e, "[unMute]");
        this.g = -1;
        z r0 = k(this.b);
        this.b = r0;
        if (r0 == null) goto L5;
        return;
    L5:
        if (this.a.size() > 0) goto L7;
        return;
    L7:
        if (this.a.size() <= 0) goto L17;
        z r1 = k(this.a.poll());
        if (r1 == null) goto L7;
        this.b = r1;
        return;
    }

    @Override // com.larus.audio.call.aec.w
    public final void d() {
        b r0 = this.s;
        if (r0 == null) goto L11;
        Long r1 = r0.a;
        Long r2 = r0.b;
        r0.c = true;
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        com.larus.audio.call.util.e r3 = com.larus.audio.call.util.e.a;
        StringBuilder r4 = new StringBuilder("[Ref] TTS End[");
        SimpleDateFormat r5 = c.a;
        r4.append(c.b(r1.longValue()));
        r4.append(" - ");
        r4.append(c.b(r2.longValue()));
        r4.append("][");
        r4.append(r2.longValue() - r1.longValue());
        r4.append(']');
        r3.i("Aec_Consume", r4.toString());
        return;
    L9:
        com.larus.audio.call.util.e.a.e("Aec_Consume", "[Ref][ERROR] TTS End; but no sentence");
        return;
    }

    public final z l() {
        z r0 = this.a.poll();
        if (r0 != null) goto L5;
        return r0;
    L5:
        if (r0.a == (-1)) goto L7;
        return r0;
    L7:
        if (r0.b != (-1)) goto L12;
        this.m = -1;
        return this.a.poll();
    L12:
        return r0;
    }

    @Override // com.larus.audio.call.aec.w
    public final void release() {
        com.larus.audio.call.util.e.a.i(this.e, "[release]");
        this.f = false;
        i("release", false);
        com.larus.audio.call.util.c.a(new AecProcessor$release$1(this, null));
    }

    public j() {
        this.a = new ConcurrentLinkedQueue();
        this.e = "AecProcessor" + hashCode();
        this.g = -1;
        this.h = -1;
        this.j = 1;
        this.k = new ConcurrentLinkedQueue();
        this.m = -1;
        boolean r0 = f.d().n;
        this.n = r0;
        this.o = f.b(true);
        this.p = f.a(true, r0, null);
        this.q = "";
        this.r = new f();
        this.s = new b();
    }

    public static z k(z r11) {
        long r1 = System.currentTimeMillis();
        if (r11 == null) goto L11;
        long r3 = r11.b;
        if (r3 > r1) goto L7;
        return null;
    L7:
        long r5 = r11.a;
        if (r1 <= r5) goto L11;
        byte[] r0 = r11.c;
        return z.a(r11, r1, 0, ArraysKt.sliceArray(r0, RangesKt.until((int) (((r1 - r5) / (r3 - r5)) * r0.length), r0.length)), false, 10);
    L11:
        return null;
    }

    @Override // com.larus.audio.call.aec.w
    public final boolean a(com.larus.audio.call.plugins.m r7) {
        Intrinsics.checkNotNullParameter(r7, "onAudioDataReceived");
        if (this.f == false) goto L6;
        com.larus.audio.call.util.e.a.i(this.e, "[init] return, already init");
        return true;
    L6:
        this.r.b(this.o, this.p, this.n, r7);
        this.f = true;
        v58.a r8 = this.o;
        int r0 = r8.c;
        int r2 = 2;
        if (r0 != 2) goto L9;
        int r3 = 2;
    L10:
        int r4 = r8.b;
        if (r4 == 12) goto L14;
        r2 = 1;
    L14:
        this.j = r2;
        int r9 = AudioRecord.getMinBufferSize(r8.a, r4, r0);
        int r1 = (((r9 * CommandStatus.DORA_TRACE) / this.o.a) / r3) / this.j;
        this.c = r1;
        this.d = ((r1 * this.p.c) * r3) / CommandStatus.DORA_TRACE;
        com.larus.audio.call.util.e.a.i(this.e, "[init] audioBufferSize:" + r9 + ", totalTimeInMs" + this.c + ", refDataSize" + this.d);
        return true;
    L9:
        r3 = 1;
        goto L10
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized void c(byte[] r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r14, "originData");     // Catch: Throwable -> L26
        if (this.f == true) goto L7;
    L23:
        com.larus.audio.call.util.e.a.i(this.e, "[RefData] return, init:" + this.f);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L7:
        if (this.r.f == false) goto L23;
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L26
        int r2 = r.a;     // Catch: Throwable -> L26
        boolean r3 = this.n;     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r14, "array");     // Catch: Throwable -> L26
        long r4 = (r14.length * CommandStatus.DORA_TRACE) / (f.a(true, r3, null).c * 2);     // Catch: Throwable -> L26
        long r5 = this.h;     // Catch: Throwable -> L26
        if (r5 != (-1)) goto L14;
        this.h = r0 + r4;     // Catch: Throwable -> L26
    L12:
        long r7 = r0;
        z r1 = new z(r7, r7 + r4, r14, false);     // Catch: Throwable -> L26
        b r15 = this.s;     // Catch: Throwable -> L26
        if (r15 == null) goto L20;
        r15.b(r1);     // Catch: Throwable -> L26
    L20:
        this.a.offer(r1);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L14:
        if (r0 >= r5) goto L16;
        r0 = r5;
    L16:
        this.h = r0 + r4;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final void f(String r13) {
        Intrinsics.checkNotNullParameter(r13, "caller");
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        String r1 = this.e;
        StringBuilder r2 = new StringBuilder("[resume][");
        r2.append(r13);
        r2.append("] sessionId: ");
        r2.append(this.q);
        r2.append(", pendingData is null:");
        if (this.b != null) goto L5;
        boolean r14 = true;
    L6:
        r2.append(r14);
        r0.i(r1, r2.toString());
        if (this.a.size() <= 0) goto L9;
    L10:
        this.m = System.currentTimeMillis();
        this.a.offer(new z(-1, -1, new byte[]{0}, false));
        b r15 = this.s;
        if (r15 == null) goto L20;
        long r3 = this.m;
        Long r5 = r15.h;
        if (r5 == null) goto L20;
        long r6 = r5.longValue();
        Long r7 = r15.b;
        if (r7 == null) goto L20;
        long r8 = r7.longValue();
        if (r6 >= r8) goto L20;
        r15.b = Long.valueOf(r8 + (r3 - r6));
        String r16 = b.c(CollectionsKt.plus(r15.d(), CollectionsKt.listOf(new Pair[]{TuplesKt.to("[pause:" + c.b(r6) + ']', Long.valueOf(r6)), TuplesKt.to("[resume:" + c.b(r3) + ']', Long.valueOf(r3))})));
        StringBuilder r4 = new StringBuilder("[Resume] ");
        r4.append(r16);
        r0.i("Aec_Consume", r4.toString());
    L20:
        f r17 = this.r;
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r9 = this.k;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r9, "queue");
        r17.d = r9;
        this.l = false;
        return;
    L9:
        if (this.b == null) goto L20;
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.larus.audio.call.aec.w
    public final void g(Map<String, String> r3) {
        b r4 = this.s;
        if (r4 == null) goto L6;
        r4.a = 0L;
        r4.b = null;
        r4.c = false;
        r4.g.clear();
        com.larus.audio.call.util.e.a.i("Aec_Consume", "[Ref] TTS Start");
        return;
    }

    public final z j(z r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        long r1 = this.m;
        if (r1 > 0) goto L8;
        return r11;
    L8:
        if (r11.d == true) goto L12;
        long r8 = r11.b - r11.a;
        z r12 = z.a(r11, r1, r1 + r8, null, true, 4);
        this.m += r8;
        return r12;
    L12:
        return r11;
    }

    @Override // com.larus.audio.call.aec.w
    public final byte[] b(byte[] r20, Long r21) {
        Intrinsics.checkNotNullParameter(r20, "originData");
        com.larus.audio.call.util.e r3 = com.larus.audio.call.util.e.a;
        r3.i(this.e, "calculateRefData with originalData " + r20.length);
        Intrinsics.checkNotNullParameter(r20, "originData");
        if (this.f == true) goto L5;
    L93:
        r3.i(this.e, "[calculateRefData] return, init:" + this.f + ", skipAec: " + this.l + ", model is init: " + this.r.f);
    L94:
        SAMICoreVoiceAssistantAudioData r2 = null;
    L95:
        if (r2 != null) goto L98;
        return null;
    L98:
        this.k.offer(r2);
        f r1 = this.r;
        Handler r4 = r1.i;
        if (r4 == null) goto L102;
        r4.post(new d(r1));
    L102:
        return r2.refData;
    L5:
        if (this.l == true) goto L93;
        f r5 = this.r;
        if (r5 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L93;
        r3.i(this.e, "origData size is " + r20.length);
        long r8 = System.currentTimeMillis();
        int r7 = r.a;
        boolean r9 = this.n;
        Intrinsics.checkNotNullParameter(r20, "originData");
        int r10 = r20.length;
        v58.a r11 = f.b(r9);
        if (r11.b != 12) goto L17;
        int r12 = 2;
    L18:
        int r13 = (r10 * CommandStatus.DORA_TRACE) / ((r11.a * 2) * r12);
        if (r13 <= 0) goto L94;
        long r14 = this.g;
        if (r14 != (-1)) goto L24;
        r3.i(this.e, "[calculateRefData] lastEndTime:" + this.g);
    L26:
        long r15 = r8;
    L27:
        this.g = r15;
        int r16 = r.a(r20, this.n);
        byte[] r17 = new byte[r16];
        int r19 = 0;
    L28:
        if (r19 >= r16) goto L30;
        r17[r19] = 0;
        r19 = r19 + 1;
        goto L28
    L30:
        Intrinsics.checkNotNullParameter(r17, "data");
        long r110 = r13;
        long r111 = r15 - r110;
        z r22 = this.b;
        if (r22 != null) goto L37;
        r22 = l();
        if (r22 != null) goto L37;
        b r112 = this.s;
        if (r112 == null) goto L92;
        r112.a(r111, r15, AecConsumeResult.EMPTY_QUEUE);
    L92:
        r2 = new SAMICoreVoiceAssistantAudioData();
        r2.data = r20;
        r2.refData = r17;
    L37:
        z r23 = j(r22);
        boolean r113 = false;
    L38:
        if (r23 == null) goto L56;
        if (r15 < r23.b) goto L56;
        long r114 = r23.a;
        if (r114 == r111) goto L46;
        if (r114 <= r111) goto L46;
        int r115 = (int) (((r114 - r111) * ((long) r16)) / r110);
    L47:
        byte[] r24 = r23.c;
        int r116 = 0;
    L48:
        if (r115 >= r16) goto L55;
        if (r116 >= r24.length) goto L55;
        if (this.i == true) goto L54;
        this.i = true;
    L54:
        r17[r115] = r24[r116];
        r115 = r115 + 1;
        r116 = r116 + 1;
    L55:
        r23 = j(l());
        r113 = true;
    L46:
        r115 = 0;
    L56:
        if (r23 != null) goto L65;
        this.b = null;
        if (r113 == false) goto L62;
        b r117 = this.s;
        if (r117 == null) goto L92;
        r117.a(r111, r15, AecConsumeResult.SENTENCE_END);
        goto L92
    L62:
        b r118 = this.s;
        if (r118 == null) goto L92;
        r118.a(r111, r15, AecConsumeResult.SENTENCE_END_NOVALID);
        goto L92
    L65:
        long r119 = r23.a;
        if (r15 > r119) goto L68;
        if (r113 == false) goto L88;
        b r120 = this.s;
        if (r120 == null) goto L91;
        r120.a(r111, r15, AecConsumeResult.SENTENCE_END_MORE_SENTENCE);
    L91:
        this.b = r23;
        goto L92
    L88:
        b r121 = this.s;
        if (r121 == null) goto L91;
        r121.a(r111, r15, AecConsumeResult.AHEAD_OF_SENTENCE);
        goto L91
    L68:
        if (r119 == r111) goto L72;
        if (r119 <= r111) goto L72;
        int r25 = (int) (((r119 - r111) * ((long) r16)) / r110);
    L73:
        byte[] r26 = r23.c;
        int r122 = 0;
    L74:
        if (r25 >= r16) goto L81;
        if (r122 >= r26.length) goto L81;
        if (this.i == true) goto L80;
        this.i = true;
    L80:
        r17[r25] = r26[r122];
        r25 = r25 + 1;
        r122 = r122 + 1;
    L81:
        long r123 = r23.b;
        byte[] r27 = r23.c;
        this.b = new z(r15, r123, ArraysKt.sliceArray(r27, RangesKt.until(r122, r27.length)), r23.d);
        b r124 = this.s;
        if (r124 == null) goto L92;
        r124.a(r111, r15, AecConsumeResult.SENTENCE_PART);
    L72:
        r25 = 0;
        goto L73
    L24:
        r8 = r14 + ((long) r13);
        r15 = 0;
        if (0 >= r8) goto L27;
    L17:
        r12 = 1;
        goto L18
    L9:
        if (r5.f == true) goto L11;
        r6 = true;
        goto L12
    }

    @Override // com.larus.audio.call.aec.w
    public final void h(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        com.larus.audio.call.util.e r8 = com.larus.audio.call.util.e.a;
        r8.i(this.e, "[pause]:".concat(r6));
        this.l = true;
        this.h = -1;
        this.g = -1;
        b r9 = this.s;
        if (r9 == null) goto L13;
        long r0 = System.currentTimeMillis();
        Long r2 = r9.b;
        if (r2 == null) goto L7;
        long r3 = r2.longValue();
    L9:
        if (r0 >= r3) goto L14;
        r9.h = Long.valueOf(r0);
        String r10 = b.c(CollectionsKt.plus(r9.d(), CollectionsKt.listOf(TuplesKt.to("[pause:" + c.b(r0) + ']', Long.valueOf(r0)))));
        StringBuilder r1 = new StringBuilder("[Pause] ");
        r1.append(r10);
        r8.i("Aec_Consume", r1.toString());
        return;
    L14:
        return;
    L7:
        r3 = 0;
        goto L9
    }

    @Override // com.larus.audio.call.aec.w
    public final void i(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        com.larus.audio.call.util.e.a.i(this.e, "[clear] [" + r5 + "] fromAsr=" + r6);
        this.a.clear();
        this.k.clear();
        Handler r7 = this.r.i;
        if (r7 == null) goto L5;
        r7.removeCallbacksAndMessages(null);
    L5:
        this.b = null;
        this.h = -1;
        if (r6 == true) goto L8;
        this.g = -1;
    L8:
        this.m = -1;
    }
}
