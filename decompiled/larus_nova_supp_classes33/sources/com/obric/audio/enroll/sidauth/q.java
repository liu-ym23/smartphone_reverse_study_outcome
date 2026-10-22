package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import com.obric.audio.continuous_talk.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Segment(startBytes=" + this.a + ", endBytes=" + this.b + ", isOpenEnded=" + this.c + ')';
        }

        public a(int r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r2 - r1;
        }
    }

    static {
    }

    public static long a(int r4) {
        return (((long) r4) * 1000) / ((long) 32000);
    }

    public static a b(s0 r22, byte[] r23) {
        byte[] r1 = r23;
        long r2 = a(r1.length);
        int r6 = 0;
        float[] r7 = null;
        float[] r8 = null;
        int r9 = 0;
    L4:
        if (r6 >= r1.length) goto L43;
        if ((r6 % 2) == 0) goto L10;
        r6 = r6 - 1;
    L10:
        if (r6 >= r1.length) goto L43;
        int r10 = RangesKt.coerceAtMost(r6 + 16000, r1.length);
        if ((r10 % 2) == 0) goto L15;
        r10 = r10 - 1;
    L15:
        if (r10 <= r6) goto L43;
        int r11 = r10 - r6;
        boolean r15 = r22.b(r1, r6, r11);
        Object r4 = r22.c;
        monitor-enter(r4);
        float[] r5 = r22.h;     // Catch: Throwable -> L40
        if (r5 == null) goto L22;
        float[] r12 = Arrays.copyOf(r5, r5.length);     // Catch: Throwable -> L40
    L23:
        monitor-exit(r4);
        if (r12 == null) goto L26;
        float[] r13 = Arrays.copyOf(r12, r12.length);
    L27:
        if (r13 != null) goto L29;
    L35:
        FLogger r14 = FLogger.a;
        StringBuilder r16 = new StringBuilder("vad frame result index=");
        r16.append(r9);
        r16.append(" startMs=");
        r16.append(a(r6));
        r16.append(" endMs=");
        r16.append(a(r10));
        r16.append(" frameDurationMs=");
        r16.append(a(r11));
        r16.append(" hasFeature=");
        r16.append(r15);
        r16.append(" featureValuesMs=");
        if (r13 == null) goto L38;
        String r0 = Arrays.toString(r13);
    L39:
        r16.append(r0);
        r14.i("SidAuthVadAudioSlicer", r16.toString());
        r9 = r9 + 1;
        r1 = r23;
        r7 = r13;
        r6 = r10;
        goto L4
    L38:
        r0 = null;
        goto L39
    L29:
        if (r13.length != 0) goto L31;
        boolean r17 = true;
    L33:
        if ((!r17) == false) goto L35;
        r8 = r13;
        goto L35
    L31:
        r17 = false;
        goto L33
    L26:
        r13 = null;
        goto L27
    L22:
        r12 = null;
    L40:
        th = move-exception;
        throw th;
    L43:
        if (r7 == null) goto L52;
        if (r7.length != 0) goto L47;
        boolean r18 = true;
    L49:
        if ((!r18) == false) goto L52;
    L61:
        if (r7 != null) goto L63;
    L141:
        FLogger.a.i("SidAuthVadAudioSlicer", "findLongestVoiceSegment no valid featureValues, pcmDurationMs=" + r2);
        return null;
    L63:
        if (r7.length != 0) goto L65;
        boolean r19 = true;
    L66:
        if (r19 == true) goto L141;
        ArrayList r3 = new ArrayList();
        int r20 = 0;
    L70:
        if (r20 >= r7.length) goto L101;
        long r21 = RangesKt.coerceAtLeast(MathKt.roundToLong(r7[r20]), 0);
        Float r24 = ArraysKt.getOrNull(r7, r20 + 1);
        if (r24 == null) goto L74;
        Long r25 = Long.valueOf(MathKt.roundToLong(r24.floatValue()));
    L75:
        if (r25 != null) goto L77;
    L80:
        boolean r110 = true;
    L81:
        if (r110 == false) goto L83;
        long r111 = r2;
    L84:
        long r26 = RangesKt.coerceAtMost(r21, r2);
        long r112 = RangesKt.coerceAtMost(r111, r2);
        ArrayList r27 = r3;
        long r28 = 32000;
        int r29 = r20;
        int r30 = (int) ((r26 * r28) / 1000);
        if ((r30 % 2) == 0) goto L88;
        r30 = r30 - 1;
    L88:
        int r31 = (int) ((r28 * r112) / 1000);
        if ((r31 % 2) == 0) goto L92;
        r31 = r31 - 1;
    L92:
        float[] r32 = r7;
        int r33 = (int) (((long) 32) * r2);
        if ((r33 % 2) == 0) goto L96;
        r33 = r33 - 1;
    L96:
        int r34 = RangesKt.coerceAtMost(r31, r33);
        if (r34 <= r30) goto L99;
        a r35 = new a(r30, r34, r110);
        ArrayList r36 = r27;
        r36.add(r35);
    L100:
        r7 = r32;
        r20 = r29 + 2;
        r3 = r36;
        goto L70
    L99:
        r36 = r27;
        FLogger.a.w("SidAuthVadAudioSlicer", "skip invalid vad segment startMs=" + r26 + " endMs=" + r112 + " isOpenEnded=" + r110 + " featureValuesMs=" + Arrays.toString(r32));
        goto L100
    L83:
        r111 = RangesKt.coerceAtLeast(r25.longValue(), r21);
        goto L84
    L77:
        if (r25.longValue() <= 0) goto L80;
        r110 = false;
        goto L81
    L74:
        r25 = null;
        goto L75
    L101:
        ArrayList r37 = r3;
        FLogger.a.i("SidAuthVadAudioSlicer", "vad final featureValuesMs=" + Arrays.toString(r7) + " pcmDurationMs=" + r2);
        Iterator r38 = r37.iterator();
        int r39 = 0;
    L103:
        if (r38.hasNext() == false) goto L108;
        Object r40 = r38.next();
        int r41 = r39 + 1;
        if (r39 >= 0) goto L107;
        CollectionsKt.throwIndexOverflow();
    L107:
        a r42 = (a) r40;
        FLogger.a.i("SidAuthVadAudioSlicer", "vad segment[" + r39 + "] startMs=" + a(r42.a) + " endMs=" + a(r42.b) + " durationMs=" + a(r42.d) + " isOpenEnded=" + r42.c);
        r39 = r41;
        goto L103
    L108:
        ArrayList r43 = new ArrayList();
        Iterator r44 = r37.iterator();
    L110:
        if (r44.hasNext() == false) goto L118;
        Object r45 = r44.next();
        if (((a) r45).d <= 0) goto L114;
        boolean r46 = true;
    L115:
        if (r46 == false) goto L110;
        r43.add(r45);
        goto L110
    L114:
        r46 = false;
        goto L115
    L118:
        if (r43.isEmpty() == false) goto L120;
        a r47 = null;
    L135:
        if (r47 != null) goto L138;
        FLogger.a.i("SidAuthVadAudioSlicer", "findLongestVoiceSegment no valid segment after select, pcmDurationMs=" + a(r23.length));
        return null;
    L138:
        FLogger.a.i("SidAuthVadAudioSlicer", "findLongestVoiceSegment final startMs=" + a(r47.a) + " endMs=" + a(r47.b) + " durationMs=" + a(r47.d) + " isOpenEnded=" + r47.c);
        return r47;
    L120:
        Iterator r48 = r43.iterator();
        if (r48.hasNext() == true) goto L123;
        Object r49 = null;
    L132:
        r47 = (a) r49;
        if (r47 == null) goto L135;
        FLogger.a.i("SidAuthVadAudioSlicer", "selectLongestSegment use longest segment startMs=" + a(r47.a) + " endMs=" + a(r47.b) + " durationMs=" + a(r47.d) + " isOpenEnded=" + r47.c);
        goto L135
    L123:
        r49 = r48.next();
        if (r48.hasNext() == false) goto L132;
        int r50 = ((a) r49).d;
    L127:
        Object r51 = r48.next();
        int r52 = ((a) r51).d;
        if (r50 >= r52) goto L131;
        r49 = r51;
        r50 = r52;
    L131:
        if (r48.hasNext() == true) goto L127;
    L65:
        r19 = false;
        goto L66
    L47:
        r18 = false;
    L52:
        if (r8 != null) goto L54;
    L60:
        r7 = null;
        goto L61
    L54:
        if (r8.length != 0) goto L56;
        boolean r53 = true;
    L58:
        if ((!r53) == false) goto L60;
        r7 = r8;
        goto L61
    L56:
        r53 = false;
        goto L58
    }
}
