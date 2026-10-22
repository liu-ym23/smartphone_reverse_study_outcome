package com.larus.audio.call.aec;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q {
    public final Queue<k> a;
    public k b;
    public long c;
    public long d;
    public long e;
    public boolean f;
    public boolean g;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Long) ((Pair) r1).getSecond(), (Long) ((Pair) r2).getSecond());
        }
    }

    static {
    }

    public final synchronized void f() {
        monitor-enter(this);
        com.larus.audio.call.util.e.a.i("AecRefSentence", "onResume");     // Catch: Throwable -> L6
        long r0 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L6
        this.e = r0;     // Catch: Throwable -> L6
        e(r0 - this.d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final long a() {
        k r0 = this.b;
        if (r0 != null) goto L10;
        r0 = (k) ((ConcurrentLinkedQueue) this.a).peek();
        if (r0 != null) goto L10;
        return -1;
    L10:
        return r0.a;
    }

    public final boolean d() {
        if ((!this.a.isEmpty()) == false) goto L5;
        return true;
    L5:
        if (this.b != null) goto L10;
        return false;
    L10:
        return true;
    }

    public final k g() {
        if (a() != (-1)) goto L7;
        com.larus.audio.call.util.e.a.v("AecRefSentence", "[REF][POP_BLOCK][NO_FIRST_BLOCK]");
        return null;
    L7:
        if (this.c != (-1)) goto L13;
        long r1 = SystemClock.elapsedRealtimeNanos() - a();
        if (r1 <= 300000000) goto L11;
        com.larus.audio.call.util.e.a.e("AecRefSentence", "[REF][POP_BLOCK][NOT_FIRST_FRAME_AFTER][" + (r1 / ((long) 1000000)) + "}ms]");
    L12:
        return null;
    L11:
        com.larus.audio.call.util.e.a.v("AecRefSentence", "[REF][POP_BLOCK][NOT_FIRST_FRAME_AFTER][" + (r1 / ((long) 1000000)) + "}ms]");
        goto L12
    L13:
        byte[] r2 = new byte[0];
        ArrayList r5 = new ArrayList();
        k r6 = this.b;
        this.b = null;
        String r9 = "][ratio:";
        if (r6 == null) goto L20;
        r5.add(r6);
        byte[] r12 = r6.c;
        int r13 = r12.length + 0;
        byte[] r3 = ArraysKt.plus(r2, r12);
        if ((r6.c.length % 2) != 1) goto L18;
        com.larus.audio.call.util.e.a.e("AecRefSentence", "[REF][POP_BLOCK][PENDING][BLOCK_SIZE_ERROR][pendingSize:" + r6.c.length + ']');
        String r4 = "AecRefSentence";
    L19:
        r2 = r3;
    L21:
        k r7 = (k) ((ConcurrentLinkedQueue) this.a).peek();
    L22:
        if (r7 == null) goto L33;
        if (r6 == null) goto L27;
        ArrayList r14 = r5;
        if (r6.b != r7.a) goto L34;
    L28:
        ((ConcurrentLinkedQueue) this.a).poll();
        r14.add(r7);
        byte[] r8 = r7.c;
        r13 = r13 + r8.length;
        r2 = ArraysKt.plus(r2, r8);
        if ((r7.c.length % 2) != 1) goto L31;
        com.larus.audio.call.util.e.a.e(r4, "[REF][POP_BLOCK][Q][BLOCK_SIZE_ERROR][append Size:" + r7.c.length + ']');
    L32:
        r6 = r7;
        r7 = (k) ((ConcurrentLinkedQueue) this.a).peek();
        r9 = r9;
        r5 = r14;
        goto L22
    L31:
        com.larus.audio.call.util.e r10 = com.larus.audio.call.util.e.a;
        StringBuilder r11 = new StringBuilder("[REF][POP_BLOCK][Q][");
        SimpleDateFormat r15 = c.a;
        r11.append(c.a(r7.a));
        r11.append(" - ");
        r11.append(c.a(r7.b));
        r11.append("][");
        r11.append(r7.c.length);
        r11.append(r9);
        r11.append((r7.b - r7.a) / ((long) r7.c.length));
        r11.append(']');
        r10.v(r4, r11.toString());
    L34:
        if (r6 == null) goto L36;
        if (r7 == null) goto L42;
        com.larus.audio.call.util.e r16 = com.larus.audio.call.util.e.a;
        StringBuilder r17 = new StringBuilder("[REF][POP_BLOCK][HAS_GAP][");
        SimpleDateFormat r19 = c.a;
        r17.append(c.a(r6.b));
        r17.append("]-[");
        r17.append(c.a(r7.a));
        r17.append(']');
        r16.e(r4, r17.toString());
    L42:
        byte[] r20 = new byte[r13];
        Iterator r21 = r14.iterator();
        int r22 = 0;
    L44:
        if (r21.hasNext() == false) goto L46;
        k r23 = (k) r21.next();
        byte[] r24 = r23.c;
        System.arraycopy(r24, 0, r20, r22, r24.length);
        r22 = r22 + r23.c.length;
        goto L44
    L46:
        long r25 = ((k) CollectionsKt.first(r14)).a;
        long r26 = r6.b;
        com.larus.audio.call.util.e r27 = com.larus.audio.call.util.e.a;
        StringBuilder r29 = new StringBuilder("[REF][POP_BLOCK][RES][");
        r29.append(c.a(r25));
        r29.append('-');
        r29.append(c.a(r26));
        r29.append("][");
        long r110 = r26 - r25;
        r29.append(r110);
        r29.append("][");
        r29.append(r13);
        r29.append(']');
        r29.append(r110 / ((long) r13));
        r27.v(r4, r29.toString());
        return new k(r25, r26, r20);
    L36:
        if (this.g == true) goto L53;
        com.larus.audio.call.util.e.a.v(r4, "[REF][POP_BLOCK][EMPTY]");
        return null;
    L53:
        return null;
    L27:
        r14 = r5;
        goto L28
    L33:
        r14 = r5;
        goto L34
    L18:
        com.larus.audio.call.util.e r111 = com.larus.audio.call.util.e.a;
        StringBuilder r112 = new StringBuilder("[REF][POP_BLOCK][PENDING][");
        SimpleDateFormat r113 = c.a;
        r112.append(c.a(r6.a));
        r112.append(" - ");
        r112.append(c.a(r6.b));
        r112.append("][");
        r112.append(r6.c.length);
        r112.append("][ratio:");
        r112.append((r6.b - r6.a) / ((long) r6.c.length));
        r112.append(']');
        r4 = "AecRefSentence";
        r111.v(r4, r112.toString());
        goto L19
    L20:
        r4 = "AecRefSentence";
        r6 = null;
        r13 = 0;
        goto L21
    }

    public static final void c(List<Pair<String, Object>> r15) {
        List<Pair<String, Object>> r16 = r15;
        String r2 = SequencesKt.joinToString$default(SequencesKt.sortedWith(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r16), new l()), new m()), new b()), " - ", null, null, 0, null, new n(), 30, null);
        String r17 = SequencesKt.joinToString$default(SequencesKt.filter(CollectionsKt.asSequence(r16), new o()), " - ", null, null, 0, null, new p(), 30, null);
        com.larus.audio.call.util.e.a.i("AecRefSentence", "[REF][POP][DETAIL][" + r2 + "][" + r17 + ']');
    }

    public final void e(long r7) {
        k r0 = g();
        this.b = r0;
        if (r0 == null) goto L5;
        this.b = k.a(r0, r0.a + r7, r0.b + r7);
    L5:
        ArrayList r1 = new ArrayList();
    L7:
        if ((!((ConcurrentLinkedQueue) this.a).isEmpty()) == false) goto L13;
        k r2 = (k) ((ConcurrentLinkedQueue) this.a).poll();
        if (r2 == null) goto L7;
        r1.add(k.a(r2, r2.a + r7, r2.b + r7));
        goto L7
    L13:
        if ((!r1.isEmpty()) == false) goto L21;
        ((ConcurrentLinkedQueue) this.a).addAll(r1);
        return;
    }

    public q(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "sentenceId");
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.a = new ConcurrentLinkedQueue();
        this.c = -1;
        this.d = -1;
        this.e = -1;
    }

    public final synchronized void b(long r29, long r30, byte[] r32) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r32, "outRefData");     // Catch: Throwable -> L67
        k r4 = g();     // Catch: Throwable -> L67
        if (r4 != null) goto L12;
        if (this.g == true) goto L9;
        this.g = true;     // Catch: Throwable -> L67
        com.larus.audio.call.util.e.a.i("AecRefSentence", "[REF][POP][NO_REF]");     // Catch: Throwable -> L67
    L9:
        monitor-exit(this);
        return;
    L12:
        this.g = false;     // Catch: Throwable -> L67
        Pair[] r7 = new Pair[5];     // Catch: Throwable -> L67
        r7[0] = TuplesKt.to("s_start", Long.valueOf(a()));     // Catch: Throwable -> L67
        k r9 = (k) CollectionsKt.lastOrNull(this.a);     // Catch: Throwable -> L67
        if (r9 != null) goto L17;
        r9 = this.b;     // Catch: Throwable -> L67
        if (r9 != null) goto L17;
        long r10 = -1;
    L19:
        r7[1] = TuplesKt.to("s_end", Long.valueOf(r10));     // Catch: Throwable -> L67
        r7[2] = TuplesKt.to("out_start", Long.valueOf(r29));     // Catch: Throwable -> L67
        r7[3] = TuplesKt.to("out_end", Long.valueOf(r30));     // Catch: Throwable -> L67
        r7[4] = TuplesKt.to("out_size", Integer.valueOf(r32.length));     // Catch: Throwable -> L67
        List r8 = CollectionsKt.mutableListOf(r7);     // Catch: Throwable -> L67
        long r11 = r29;
        long r12 = r11;
        int r13 = 0;
        int r14 = 0;
    L20:
        if (r4 == null) goto L65;
        r8.add(TuplesKt.to("block_" + r13 + "_start", Long.valueOf(r4.a)));     // Catch: Throwable -> L67
        r8.add(TuplesKt.to("block_" + r13 + "_end", Long.valueOf(r4.b)));     // Catch: Throwable -> L67
        r8.add(TuplesKt.to("block_" + r13 + "_size", Integer.valueOf(r4.c.length)));     // Catch: Throwable -> L67
        int r15 = r13 + 1;     // Catch: Throwable -> L67
        long r16 = r4.a;     // Catch: Throwable -> L67
        if (r30 < r16) goto L23;
        List r5 = r8;
        if (r11 < r4.b) goto L31;
        com.larus.audio.call.util.e.a.e("AecRefSentence", "[REF][POP][AFTER_REF]");     // Catch: Throwable -> L67
        r4 = g();     // Catch: Throwable -> L67
        r5 = r5;
    L64:
        r13 = r15;
        r8 = r5;
        goto L20
    L31:
        if (r16 != r11) goto L34;
    L36:
        int r17 = 0;
    L39:
        if (r4.b < r30) goto L41;
        com.larus.audio.call.util.e.a.i("AecRefSentence", "[REF][POP][IN_REF]");     // Catch: Throwable -> L67
        int r6 = r32.length - r14;     // Catch: Throwable -> L67
        long r19 = r30;
        boolean r110 = true;
    L43:
        if ((r6 % 2) != 1) goto L45;
        com.larus.audio.call.util.e r111 = com.larus.audio.call.util.e.a;     // Catch: Throwable -> L67
        boolean r23 = r110;
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L67
        long r24 = r19;
        r112.append("[REF][POP][LENGTH_ERROR][srcPos:");     // Catch: Throwable -> L67
        r112.append(r17);     // Catch: Throwable -> L67
        r112.append("][destPos:");     // Catch: Throwable -> L67
        r112.append(r14);     // Catch: Throwable -> L67
        r112.append("][length:");     // Catch: Throwable -> L67
        r112.append(r6);     // Catch: Throwable -> L67
        r112.append("][refSize:");     // Catch: Throwable -> L67
        r112.append(r4.c.length);     // Catch: Throwable -> L67
        r112.append("][outSize:");     // Catch: Throwable -> L67
        r112.append(r32.length);     // Catch: Throwable -> L67
        r112.append("][refStart:");     // Catch: Throwable -> L67
        r112.append(r4.a);     // Catch: Throwable -> L67
        r112.append("][outStart:");     // Catch: Throwable -> L67
        r112.append(r12);     // Catch: Throwable -> L67
        r112.append("][outEnd:");     // Catch: Throwable -> L67
        r112.append(r30);     // Catch: Throwable -> L67
        r112.append(']');     // Catch: Throwable -> L67
        r111.e("AecRefSentence", r112.toString());     // Catch: Throwable -> L67
    L52:
        int r20 = r6;
        System.arraycopy(r4.c, r17, r32, r14, r20);     // Catch: Throwable -> L67
        r14 = r14 + r20;     // Catch: Throwable -> L67
        int r21 = r20 + r17;     // Catch: Throwable -> L67
        if (r21 >= r4.c.length) goto L55;
        com.larus.audio.call.util.e r22 = com.larus.audio.call.util.e.a;     // Catch: Throwable -> L67
        r22.i("AecRefSentence", "[PENDING][BEFORE][duration:" + (r4.b - r4.a) + "][size:" + r4.c.length + "][ratio:" + ((r4.b - r4.a) / ((long) r4.c.length)) + ']');     // Catch: Throwable -> L67
        long r113 = r4.b;     // Catch: Throwable -> L67
        byte[] r25 = r4.c;     // Catch: Throwable -> L67
        this.b = new k(r24, r113, ArraysKt.copyOfRange(r25, r21, r25.length));     // Catch: Throwable -> L67
        StringBuilder r26 = new StringBuilder();     // Catch: Throwable -> L67
        r26.append("[PENDING][AFTER][duration:");     // Catch: Throwable -> L67
        k r27 = this.b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L67
        long r31 = r27.b;     // Catch: Throwable -> L67
        k r114 = this.b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L67
        r26.append(r31 - r114.a);     // Catch: Throwable -> L67
        r26.append("][size:");     // Catch: Throwable -> L67
        k r33 = this.b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r33);     // Catch: Throwable -> L67
        r26.append(r33.c.length);     // Catch: Throwable -> L67
        r26.append("][ratio:");     // Catch: Throwable -> L67
        k r34 = this.b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r34);     // Catch: Throwable -> L67
        long r35 = r34.b;     // Catch: Throwable -> L67
        k r115 = this.b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L67
        long r36 = r35 - r115.a;     // Catch: Throwable -> L67
        k r116 = this.b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L67
        r26.append(r36 / ((long) r116.c.length));     // Catch: Throwable -> L67
        r26.append(']');     // Catch: Throwable -> L67
        r22.i("AecRefSentence", r26.toString());     // Catch: Throwable -> L67
    L55:
        if (r23 == true) goto L56;
        r4 = g();     // Catch: Throwable -> L67
        if (r4 != null) goto L62;
        c(r5);     // Catch: Throwable -> L67
    L63:
        r12 = r29;
        r11 = r24;
        goto L64
    L62:
        com.larus.audio.call.util.e.a.e("AecRefSentence", "[REF][POP][CONTINUE]");     // Catch: Throwable -> L67
        goto L63
    L56:
        c(r5);     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L45:
        r24 = r19;
        r23 = r110;
        if ((r17 + r6) <= r4.c.length) goto L48;
    L51:
        c(r5);     // Catch: Throwable -> L67
        com.larus.audio.call.util.e.a.e("AecRefSentence", "[REF][POP][COPY_ERROR][src_dur:" + (r4.b - r4.a) + "][src_size:" + r4.c.length + "][out_dur:" + (r30 - r12) + "][out_size:" + r32.length + ']');     // Catch: Throwable -> L67
        goto L52
    L48:
        if ((r14 + r6) <= r32.length) goto L52;
    L41:
        com.larus.audio.call.util.e.a.w("AecRefSentence", "[REF][POP][PART_REF_L]");     // Catch: Throwable -> L67
        r19 = r4.b;     // Catch: Throwable -> L67
        r6 = r4.c.length - r17;     // Catch: Throwable -> L67
        r110 = false;
        goto L43
    L34:
        if (r11 >= r16) goto L37;
        com.larus.audio.call.util.e.a.w("AecRefSentence", "[REF][POP][PART_REF_R]");     // Catch: Throwable -> L67
        int r37 = r.a;     // Catch: Throwable -> L67
        int r38 = (int) ((((long) r32.length) * (r4.a - r12)) / (r30 - r12));     // Catch: Throwable -> L67
        r14 = r38 - (r38 % 2);     // Catch: Throwable -> L67
        goto L36
    L37:
        com.larus.audio.call.util.e.a.w("AecRefSentence", "[REF][POP][REMAIN_REF][may paused]");     // Catch: Throwable -> L67
        int r39 = r.a;     // Catch: Throwable -> L67
        long r40 = r4.c.length;     // Catch: Throwable -> L67
        long r117 = r4.a;     // Catch: Throwable -> L67
        int r41 = (int) ((r40 * (r11 - r117)) / (r4.b - r117));     // Catch: Throwable -> L67
        r17 = r41 - (r41 % 2);     // Catch: Throwable -> L67
        r14 = 0;
        goto L39
    L23:
        com.larus.audio.call.util.e.a.e("AecRefSentence", "[REF][POP][AHEAD_REF]");     // Catch: Throwable -> L67
        this.b = r4;     // Catch: Throwable -> L67
        c(r8);     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L65:
        monitor-exit(this);
        return;
    L17:
        r10 = r9.b;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        throw th;
    }
}
