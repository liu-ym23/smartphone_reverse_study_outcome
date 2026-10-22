package com.larus.audio.call.aec;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public Long a;
    public Long b;
    public boolean c;
    public long d;
    public long e;
    public AecConsumeResult f;
    public final CopyOnWriteArrayList<Pair<Long, Long>> g;
    public Long h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.audio.call.aec.b$b, reason: collision with other inner class name */
    public static final class C0078b<T> implements Comparator {
        public C0078b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Long) ((Pair) r1).getSecond(), (Long) ((Pair) r2).getSecond());
        }
    }

    static {
    }

    public final List<Pair<String, Long>> d() {
        Long r0 = this.a;
        Long r1 = this.b;
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        StringBuilder r7 = new StringBuilder("[sentence-start:");
        SimpleDateFormat r8 = c.a;
        r7.append(c.b(r0.longValue()));
        List r2 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(r7.toString(), r0), TuplesKt.to("sentence-end:" + c.b(r1.longValue()) + ']', r1)});
    L8:
        List r3 = r2;
        CopyOnWriteArrayList<Pair<Long, Long>> r4 = this.g;
        ArrayList r6 = new ArrayList();
        Iterator<Pair<Long, Long>> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        Pair<Long, Long> r9 = r5.next();
        CollectionsKt.addAll(r6, CollectionsKt.listOf(new Pair[]{TuplesKt.to("[gap-start:" + ((Number) r9.getFirst()).longValue(), r9.getFirst()), TuplesKt.to("gap-end:" + ((Number) r9.getSecond()).longValue() + ']', r9.getSecond())}));
        goto L10
    L12:
        List<Pair<String, Long>> r10 = CollectionsKt.plus(r3, r6);
        if (this.d <= 0) goto L17;
        StringBuilder r11 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r12 = c.a;
        r11.append(c.b(this.d));
        return CollectionsKt.plus(r10, CollectionsKt.listOf(new Pair[]{TuplesKt.to(r11.toString(), Long.valueOf(this.d)), TuplesKt.to("last-audio-end:" + c.b(this.e) + ']', Long.valueOf(this.e))}));
    L17:
        return r10;
    L7:
        r2 = CollectionsKt.emptyList();
        goto L8
    }

    public b() {
        this.c = true;
        this.g = new CopyOnWriteArrayList();
    }

    public static String c(List r9) {
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(r9, new C0078b()), " - ", null, null, 0, null, new com.larus.audio.call.aec.a(), 30, null);
    }

    public final void b(z r21) {
        Intrinsics.checkNotNullParameter(r21, "data");
        Long r2 = this.a;
        Long r3 = this.b;
        if (r2 != null) goto L5;
    L23:
        com.larus.audio.call.util.e.a.e("Aec_Consume", "[ERROR][Ref][enqueueTtsData] but no start sentence");
        return;
    L5:
        if (this.c == true) goto L23;
        if (r2.longValue() == 0) goto L19;
        if (r3 == null) goto L19;
        if (r21.a >= this.e) goto L14;
        StringBuilder r6 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r7 = c.a;
        r6.append(c.b(this.d));
        String r4 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r6.toString(), Long.valueOf(this.d)), TuplesKt.to("last-audio-end:" + c.b(this.e) + ']', Long.valueOf(this.e)), TuplesKt.to("[sentence-start:" + c.b(r2.longValue()), r2), TuplesKt.to("sentence-end:" + c.b(r3.longValue()) + ']', r3), TuplesKt.to("[new-part-start:" + c.b(r21.a), Long.valueOf(r21.a)), TuplesKt.to("new-part-end:" + c.b(r21.b) + ']', Long.valueOf(r21.b))}));
        com.larus.audio.call.util.e r5 = com.larus.audio.call.util.e.a;
        StringBuilder r8 = new StringBuilder("[Ref][ERROR][CONTINUE][TTS DELAY], ");
        r8.append(r4);
        r5.e("Aec_Consume", r8.toString());
    L18:
        this.b = Long.valueOf(r21.b);
        return;
    L14:
        long r9 = r3.longValue();
        long r12 = r21.a;
        if (r9 >= r12) goto L17;
        this.g.add(TuplesKt.to(r3, Long.valueOf(r12)));
        StringBuilder r10 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r11 = c.a;
        r10.append(c.b(this.d));
        String r13 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r10.toString(), Long.valueOf(this.d)), TuplesKt.to("last-audio-end:" + c.b(this.e) + ']', Long.valueOf(this.e)), TuplesKt.to("[sentence-start:" + c.b(r2.longValue()), r2), TuplesKt.to("sentence-end:" + c.b(r3.longValue()) + ']', r3), TuplesKt.to("[new-part-start:" + c.b(r21.a), Long.valueOf(r21.a)), TuplesKt.to("new-part-end:" + c.b(r21.b) + ']', Long.valueOf(r21.b))}));
        com.larus.audio.call.util.e r14 = com.larus.audio.call.util.e.a;
        StringBuilder r15 = new StringBuilder("[Ref][ERROR][CONTINUE][TTS GAP], ");
        r15.append(r13);
        r14.e("Aec_Consume", r15.toString());
        goto L18
    L17:
        StringBuilder r16 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r17 = c.a;
        r16.append(c.b(this.d));
        String r19 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r16.toString(), Long.valueOf(this.d)), TuplesKt.to("last-audio-end:" + c.b(this.e) + ']', Long.valueOf(this.e)), TuplesKt.to("[sentence-start:" + c.b(r2.longValue()), r2), TuplesKt.to("sentence-end:" + c.b(r3.longValue()) + ']', r3), TuplesKt.to("[new-part-start:" + c.b(r21.a), Long.valueOf(r21.a)), TuplesKt.to("new-part-end:" + c.b(r21.b) + ']', Long.valueOf(r21.b))}));
        com.larus.audio.call.util.e r20 = com.larus.audio.call.util.e.a;
        StringBuilder r22 = new StringBuilder("[Ref][CONTINUE], ");
        r22.append(r19);
        r20.i("Aec_Consume", r22.toString());
    L19:
        this.a = Long.valueOf(r21.a);
        this.b = Long.valueOf(r21.b);
        com.larus.audio.call.util.e r23 = com.larus.audio.call.util.e.a;
        StringBuilder r24 = new StringBuilder("[Ref][SentenceStart][");
        SimpleDateFormat r25 = c.a;
        r24.append(c.b(r21.a));
        r24.append(" - ");
        r24.append(c.b(r21.b));
        r24.append("][");
        r24.append(r21.b - r21.a);
        r24.append(']');
        r23.i("Aec_Consume", r24.toString());
        if (r21.a >= this.e) goto L26;
        String r1 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to("[last-audio-start:" + c.b(this.d), Long.valueOf(this.d)), TuplesKt.to("last-audio-end:" + c.b(this.e) + ']', Long.valueOf(this.e)), TuplesKt.to("[sentence-start:" + c.b(r21.a), Long.valueOf(r21.a)), TuplesKt.to("sentence-end:" + c.b(r21.b) + ']', Long.valueOf(r21.b))}));
        StringBuilder r26 = new StringBuilder("[Ref][ERROR][START][TTS DELAY], ");
        r26.append(r1);
        r23.e("Aec_Consume", r26.toString());
        return;
    }

    public final void a(long r8, long r10, AecConsumeResult r12) {
        Intrinsics.checkNotNullParameter(r12, "result");
        if (this.e <= r8) goto L10;
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        StringBuilder r1 = new StringBuilder("[Mic][WRONG SCOPE], LAST[");
        SimpleDateFormat r4 = c.a;
        r1.append(c.b(this.d));
        r1.append(" - ");
        r1.append(c.b(this.e));
        r1.append("]【");
        AecConsumeResult r6 = this.f;
        if (r6 == null) goto L7;
        String r7 = r6.getMessage();
    L8:
        r1.append(r7);
        r1.append("】, NEW[");
        r1.append(c.b(r8));
        r1.append(" - ");
        r1.append(c.b(r10));
        r1.append("]【");
        r1.append(r12.getMessage());
        r1.append(12305);
        r0.e("Aec_Consume", r1.toString());
    L12:
        this.d = r8;
        this.e = r10;
        this.f = r12;
        return;
    L7:
        r7 = null;
        goto L8
    L10:
        if (this.f == r12) goto L12;
        String r2 = c(CollectionsKt.plus(d(), CollectionsKt.listOf(new Pair[]{TuplesKt.to("[audio-start:" + c.b(r8), Long.valueOf(r8)), TuplesKt.to("audio-end:" + c.b(r10) + ']', Long.valueOf(r10))})));
        com.larus.audio.call.util.e.a.i("Aec_Consume", "[Mic]【" + r12.getMessage() + 12305 + r2 + ' ');
        goto L12
    }
}
