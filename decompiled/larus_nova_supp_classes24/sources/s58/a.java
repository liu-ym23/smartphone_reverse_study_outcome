package s58;

import android.media.MediaCodec;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import c68.b;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import r58.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final C0125a a = null;

    /* JADX INFO: renamed from: s58.a$a, reason: collision with other inner class name */
    public static final class C0125a {

        /* JADX INFO: renamed from: s58.a$a$a, reason: collision with other inner class name */
        public static final class C0126a {
            public final OutputStream a;
            public final int b;
            public final int c;
            public final int d;
            public final int e;
            public final int f;
            public int g;
            public final long[] h;

            public final void a() {
                ByteArrayOutputStream r0 = new ByteArrayOutputStream();
                Charset r1 = Charsets.UTF_8;
                r0.write("OpusHead".getBytes(r1));
                r0.write(1);
                r0.write(this.c);
                r0.write(this.d & 255);
                r0.write((this.d >>> 8) & 255);
                r0.write(this.b & 255);
                r0.write((this.b >>> 8) & 255);
                r0.write((this.b >>> 16) & 255);
                r0.write((this.b >>> 24) & 255);
                r0.write(0);
                r0.write(0);
                r0.write(0);
                byte[] r4 = r0.toByteArray();
                Intrinsics.checkNotNull(r4);
                b(r4, true, false, 0, 1);
                byte[] r2 = "Kotlin-Opus-Encoder".getBytes(r1);
                ByteArrayOutputStream r3 = new ByteArrayOutputStream();
                r3.write("OpusTags".getBytes(r1));
                r3.write(r2.length & 255);
                r3.write((r2.length >>> 8) & 255);
                r3.write((r2.length >>> 16) & 255);
                r3.write((r2.length >>> 24) & 255);
                r3.write(r2);
                r3.write(0);
                r3.write(0);
                r3.write(0);
                r3.write(0);
                byte[] r5 = r3.toByteArray();
                Intrinsics.checkNotNull(r5);
                b(r5, false, false, 0, 1);
            }

            public C0126a(PolarisFileOutputStreamWrapper r13) {
                Intrinsics.checkNotNullParameter(r13, "outputStream");
                this.a = r13;
                this.b = 16000;
                this.c = 1;
                this.d = 312;
                this.e = 27;
                this.f = new SecureRandom().nextInt();
                long[] r1 = new long[256];
                int r3 = 0;
            L3:
                if (r3 >= 256) goto L12;
                long r4 = ((long) r3) << 24;
                int r6 = 0;
            L6:
                if (r6 >= 8) goto L11;
                long r7 = 2147483648L & r4;
                long r5 = r4 << 1;
                if (r7 == 0) goto L10;
                r5 = r5 ^ 79764919;
            L10:
                r4 = r5 & 4294967295L;
                r6 = r6 + 1;
                goto L6
            L11:
                r1[r3] = r4;
                r3 = r3 + 1;
                goto L3
            L12:
                this.h = r1;
            }

            public final void b(byte[] r19, boolean r110, boolean r20, long r21, int r23) {
                int r3 = 0;
                if (r23 <= 0) goto L8;
                int r4 = r19.length;
                ArrayList r5 = new ArrayList();
            L5:
                if (r4 < 255) goto L7;
                r5.add((byte) -1);
                r4 = r4 - 255;
                goto L5
            L7:
                r5.add(Byte.valueOf((byte) r4));
                byte[] r6 = CollectionsKt.toByteArray(r5);
            L9:
                int r7 = (this.e + r6.length) + r19.length;
                byte[] r8 = new byte[r7];
                r8[0] = 79;
                r8[1] = 103;
                int r9 = 2;
                r8[2] = 103;
                r8[3] = 83;
                r8[4] = 0;
                if (r110 == true) goto L13;
                r9 = 0;
            L13:
                if (r20 == false) goto L15;
                r9 = r9 | 4;
            L15:
                r8[5] = (byte) r9;
                int r10 = 0;
            L17:
                if (r10 >= 8) goto L19;
                r8[r10 + 6] = (byte) (r21 >>> (r10 * 8));
                r10 = r10 + 1;
                goto L17
            L19:
                int r11 = 0;
            L20:
                if (r11 >= 4) goto L22;
                r8[r11 + 14] = (byte) (this.f >>> (r11 * 8));
                r11 = r11 + 1;
                goto L20
            L22:
                int r12 = 0;
            L23:
                if (r12 >= 4) goto L25;
                r8[r12 + 18] = (byte) (this.g >>> (r12 * 8));
                r12 = r12 + 1;
                goto L23
            L25:
                this.g++;
                r8[22] = 0;
                r8[23] = 0;
                char r13 = 24;
                r8[24] = 0;
                r8[25] = 0;
                r8[26] = (byte) r6.length;
                if (r6.length != 0) goto L28;
                boolean r14 = true;
            L30:
                if ((!r14) == false) goto L33;
                System.arraycopy(r6, 0, r8, 27, r6.length);
            L33:
                if (r19.length != 0) goto L35;
                boolean r15 = true;
            L37:
                if ((true ^ r15) == false) goto L39;
                System.arraycopy(r19, 0, r8, r6.length + 27, r19.length);
            L39:
                long r16 = 0;
            L40:
                if (r3 >= r7) goto L42;
                int r1 = (int) ((((long) (r8[r3] & 255)) ^ (r16 >>> r13)) & 255);
                r16 = this.h[r1] ^ ((r16 << 8) & 4294967295L);
                r3 = r3 + 1;
                r13 = 24;
                goto L40
            L42:
                int r2 = (int) r16;
                r8[22] = (byte) (r2 & 255);
                r8[23] = (byte) ((r2 >>> 8) & 255);
                r8[24] = (byte) ((r2 >>> 16) & 255);
                r8[25] = (byte) ((r2 >>> 24) & 255);
                this.a.write(r8);
                return;
            L35:
                r15 = false;
                goto L37
            L28:
                r14 = false;
                goto L30
            L8:
                r6 = new byte[0];
                goto L9
            }
        }

        public C0125a() {
        }

        public static Pair b(d r10) {
            Intrinsics.checkNotNullParameter(r10, "audioData");
            byte[] r0 = r10.b;
            int r11 = r10.a;
            int r2 = 0;
            if (r11 > 0) goto L7;
            int r1 = b.a;
            b.b("AudioUtils", "Original audio data size is invalid: " + r11);
            return TuplesKt.to(new d(0, new byte[0]), new d(0, new byte[0]));
        L7:
            if ((r11 % 8) == 0) goto L10;
            int r3 = b.a;
            b.b("AudioUtils", "Received audio data size (" + r11 + ") is not a multiple of 8, cannot separate channels.");
            return TuplesKt.to(new d(0, new byte[0]), new d(0, new byte[0]));
        L10:
            int r4 = (r11 / 4) * 2;
            byte[] r5 = new byte[r4];
            byte[] r6 = new byte[r4];
            IntProgression r12 = RangesKt.step(RangesKt.until(0, r11), 8);
            int r7 = r12.getFirst();
            int r8 = r12.getLast();
            int r13 = r12.getStep();
            if (r13 <= 0) goto L13;
            if (r7 > r8) goto L13;
        L15:
            int r9 = r7;
            int r14 = 0;
        L16:
            r5[r2] = r0[r9];
            r5[r2 + 1] = r0[r9 + 1];
            r5[r2 + 2] = r0[r9 + 2];
            r5[r2 + 3] = r0[r9 + 3];
            r2 = r2 + 4;
            r6[r14] = r0[r9 + 4];
            r6[r14 + 1] = r0[r9 + 5];
            r6[r14 + 2] = r0[r9 + 6];
            r6[r14 + 3] = r0[r9 + 7];
            r14 = r14 + 4;
            if (r9 == r8) goto L20;
            r9 = r9 + r13;
        L20:
            return TuplesKt.to(new d(r4, r5), new d(r4, r6));
        L13:
            if (r13 >= 0) goto L20;
            if (r8 > r7) goto L20;
            goto L15
        }

        public static void a(String r40, String r41) {
            String r1 = r41;
            Intrinsics.checkNotNullParameter(r40, "pcmFilePath");
            Intrinsics.checkNotNullParameter(r1, "opusFilePath");
            PolarisFileWrapper r2 = new PolarisFileWrapper(r40);
            PolarisFileWrapper r3 = new PolarisFileWrapper(r1);
            if (r2.exists() == true) goto L6;
            int r4 = b.a;
            b.b("AudioUtils", "PCM file not found: " + r40);
            return;
        L6:
            Unit r5 = null;
            String r9 = new MediaCodecList(0).findEncoderForFormat(MediaFormat.createAudioFormat("audio/opus", 16000, 1));
            if (r9 != null) goto L10;
            b.b("AudioUtils", "Opus encoder not available");
            return;
        L10:
            Ref.ObjectRef r10 = new Ref.ObjectRef();
            BufferedInputStream r0 = new PolarisFileInputStreamWrapper(r2);     // Catch: Throwable -> L150 Exception -> L152 IOException -> L168
            if ((r0 instanceof BufferedInputStream) == true) goto L210;
            BufferedInputStream r6 = new BufferedInputStream(r0, 8192);     // Catch: Throwable -> L150 Exception -> L152 IOException -> L168
        L227:
            Closeable r12 = new PolarisFileOutputStreamWrapper(r3);     // Catch: Throwable -> L138
            MediaFormat r7 = MediaFormat.createAudioFormat("audio/opus", 16000, 1);     // Catch: Throwable -> L128
            r7.setInteger("bitrate", 32000);     // Catch: Throwable -> L128
            int r8 = 640;
            r7.setInteger("max-input-size", 640);     // Catch: Throwable -> L128
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L23
            r7.setInteger("pcm-encoding", 2);     // Catch: Throwable -> L23
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
        L25:
            C0126a r13 = new C0126a(r12);     // Catch: Throwable -> L128
            r13.a();     // Catch: Throwable -> L128
            MediaCodec r14 = MediaCodec.createByCodecName(r9);     // Catch: Throwable -> L128
            r14.configure(r7, null, null, 1);     // Catch: Throwable -> L128
            r14.start();     // Catch: Throwable -> L128
            r10.element = r14;     // Catch: Throwable -> L128
            MediaCodec.BufferInfo r15 = new MediaCodec.BufferInfo();     // Catch: Throwable -> L128
            byte[] r16 = new byte[640];     // Catch: Throwable -> L128
            long r17 = 320;
            long r19 = 48000;
            long r110 = r17;
            long r111 = 16000;
            long r22 = (r17 * r19) / r111;     // Catch: Throwable -> L126
            long r112 = 0;
            long r26 = 0;
            long r29 = 312;
            boolean r20 = false;
            boolean r210 = false;
        L29:
            if (r210 == true) goto L100;
            r12 = r12;
            if (r20 == false) goto L216;
        L71:
            r20 = r20;
        L72:
            r112 = r112;
        L73:
            MediaCodec r21 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r21 == null) goto L76;
            int r23 = r21.dequeueOutputBuffer(r15, 10000);     // Catch: Throwable -> L35
        L77:
            if (r23 < 0) goto L97;
            MediaCodec r24 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r24 == null) goto L81;
            ByteBuffer r25 = r24.getOutputBuffer(r23);     // Catch: Throwable -> L35
        L82:
            if (r25 == null) goto L90;
            if (r15.size <= 0) goto L90;
            if ((r15.flags & 2) != 0) goto L90;
            r25.position(r15.offset);     // Catch: Throwable -> L35
            r25.limit(r15.offset + r15.size);     // Catch: Throwable -> L35
            byte[] r113 = new byte[r15.size];     // Catch: Throwable -> L35
            r25.get(r113);     // Catch: Throwable -> L35
            r29 = r29 + r22;     // Catch: Throwable -> L35
            Intrinsics.checkNotNullParameter(r113, "data");     // Catch: Throwable -> L35
            r13.b(r113, false, false, r29, 1);     // Catch: Throwable -> L35
        L90:
            MediaCodec r114 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r114 == null) goto L95;
            r114.releaseOutputBuffer(r23, false);     // Catch: Throwable -> L35
            Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L35
        L95:
            if ((r15.flags & 4) != 0) goto L96;
        L98:
            r110 = r110;
            r111 = r111;
            r8 = 640;
            goto L29
        L96:
            r110 = r110;
            r111 = r111;
            r8 = 640;
            r210 = true;
            goto L29
        L81:
            r25 = null;
            goto L82
        L97:
            r111 = r111;
            r110 = r110;
            goto L98
        L76:
            r23 = -1;
            goto L77
        L216:
            MediaCodec r30 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r30 == null) goto L37;
            int r31 = r30.dequeueInputBuffer(10000);     // Catch: Throwable -> L35
        L38:
            if (r31 < 0) goto L71;
            MediaCodec r115 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r115 == null) goto L42;
            ByteBuffer r116 = r115.getInputBuffer(r31);     // Catch: Throwable -> L35
        L43:
            if (r116 != null) goto L47;
            MediaCodec r32 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r32 == null) goto L60;
            r32.queueInputBuffer(r31, 0, 0, 0, 4);     // Catch: Throwable -> L35
            Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L35
        L60:
            r112 = r112;
            r20 = true;
            goto L73
        L47:
            r116.clear();     // Catch: Throwable -> L35
            int r117 = 0;
        L48:
            if (r117 >= r8) goto L53;
            int r34 = r6.read(r16, r117, 640 - r117);     // Catch: Throwable -> L35
            if (r34 <= 0) goto L51;
            r117 = r117 + r34;     // Catch: Throwable -> L35
            r112 = r112 + ((long) r34);     // Catch: Throwable -> L35
            r20 = r20;
            r8 = 640;
            goto L48
        L51:
            boolean r35 = true;
        L54:
            long r36 = ((r26 * r110) * 1000000) / r111;     // Catch: Throwable -> L35
            if (r117 != 0) goto L62;
            if (r35 == false) goto L62;
            MediaCodec r37 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r37 == null) goto L60;
            r37.queueInputBuffer(r31, 0, 0, r36, 4);     // Catch: Throwable -> L35
            Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L35
        L62:
            if (r117 >= 640) goto L67;
            ArraysKt.fill(r16, (byte) 0, r117, 640);     // Catch: Throwable -> L35
            r116.put(r16, 0, 640);     // Catch: Throwable -> L35
            MediaCodec r39 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r39 == null) goto L66;
            r39.queueInputBuffer(r31, 0, 640, r36, 4);     // Catch: Throwable -> L35
            Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L35
        L66:
            Unit r43 = Unit.INSTANCE;     // Catch: Throwable -> L35
            r20 = true;
        L70:
            r26 = r26 + 1;     // Catch: Throwable -> L35
            goto L72
        L67:
            r116.put(r16, 0, 640);     // Catch: Throwable -> L35
            MediaCodec r310 = (MediaCodec) r10.element;     // Catch: Throwable -> L35
            if (r310 == null) goto L70;
            r310.queueInputBuffer(r31, 0, 640, r36, 0);     // Catch: Throwable -> L35
            Unit r44 = Unit.INSTANCE;     // Catch: Throwable -> L35
            goto L70
        L53:
            r35 = false;
            goto L54
        L42:
            r116 = null;
            goto L43
        L37:
            r31 = -1;
        L35:
            th = move-exception;
            Throwable r45 = th;
            Closeable r46 = r12;
        L223:
            throw r45;     // Catch: Throwable -> L132
        L132:
            th = move-exception;
            CloseableKt.closeFinally(r46, r45);     // Catch: Throwable -> L136
            throw th;     // Catch: Throwable -> L136
        L100:
            Closeable r311 = r12;
            r13.b(new byte[0], false, true, (((r112 / (((long) 1) * 2)) * r19) / r111) + 312, 0);     // Catch: Throwable -> L124
            r13.a.flush();     // Catch: Throwable -> L124
            int r47 = b.a;     // Catch: Throwable -> L124
            b.a("AudioUtils", "PCM to Opus success! File: " + r1);     // Catch: Throwable -> L121
            Unit r48 = Unit.INSTANCE;     // Catch: Throwable -> L121
            CloseableKt.closeFinally(r311, null);     // Catch: Throwable -> L136
            CloseableKt.closeFinally(r6, null);     // Catch: Exception -> L146 IOException -> L148 Throwable -> L187
            Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L113
            MediaCodec r50 = (MediaCodec) r10.element;     // Catch: Throwable -> L113
            if (r50 == null) goto L110;
            r50.stop();     // Catch: Throwable -> L113
            Unit r51 = Unit.INSTANCE;     // Catch: Throwable -> L113
        L111:
            Result.constructor-impl(r51);     // Catch: Throwable -> L113
        L115:
            MediaCodec r52 = (MediaCodec) r10.element;     // Catch: Throwable -> L184
            if (r52 == null) goto L118;
            r52.release();     // Catch: Throwable -> L184
            Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L184
        L119:
            Result.constructor-impl(r118);     // Catch: Throwable -> L184
            return;
        L118:
            r118 = null;
            goto L119
        L110:
            r51 = null;
        L113:
            th = move-exception;
            Result.Companion r53 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L121:
            th = th;
        L122:
            r46 = r311;
        L130:
            r45 = th;
        L124:
            th = th;
        L126:
            th = th;
            r46 = r12;
            goto L130
        L23:
            th = move-exception;
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L128
            Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L128
        L128:
            th = th;
            r46 = r12;
        L136:
            th = th;
        L140:
            Throwable r54 = th;
            throw r54;     // Catch: Throwable -> L142
        L142:
            th = move-exception;
            CloseableKt.closeFinally(r6, r54);     // Catch: Exception -> L146 IOException -> L148 Throwable -> L187
            throw th;     // Catch: Exception -> L146 IOException -> L148 Throwable -> L187
        L138:
            th = th;
        L148:
            e = e;
        L170:
            int r55 = b.a;     // Catch: Throwable -> L187
            b.c(r1, "IOException: " + e.getMessage(), e);     // Catch: Throwable -> L187
            Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L177
            MediaCodec r57 = (MediaCodec) r10.element;     // Catch: Throwable -> L177
            if (r57 == null) goto L174;
            r57.stop();     // Catch: Throwable -> L177
            Unit r59 = Unit.INSTANCE;     // Catch: Throwable -> L177
        L175:
            Result.constructor-impl(r59);     // Catch: Throwable -> L177
        L179:
            MediaCodec r60 = (MediaCodec) r10.element;     // Catch: Throwable -> L184
            if (r60 == null) goto L183;
            r60.release();     // Catch: Throwable -> L184
            r118 = Unit.INSTANCE;     // Catch: Throwable -> L184
            goto L119
        L183:
            r118 = r5;
            goto L119
        L174:
            r59 = r5;
        L177:
            th = move-exception;
            Result.Companion r61 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L146:
            e = e;
        L154:
            int r62 = b.a;     // Catch: Throwable -> L187
            b.c(r1, "Encode failed: " + e.getMessage(), e);     // Catch: Throwable -> L187
            Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L161
            MediaCodec r64 = (MediaCodec) r10.element;     // Catch: Throwable -> L161
            if (r64 == null) goto L158;
            r64.stop();     // Catch: Throwable -> L161
            Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L161
        L159:
            Result.constructor-impl(r65);     // Catch: Throwable -> L161
        L163:
            MediaCodec r66 = (MediaCodec) r10.element;     // Catch: Throwable -> L184
            if (r66 == null) goto L167;
            r66.release();     // Catch: Throwable -> L184
            r118 = Unit.INSTANCE;     // Catch: Throwable -> L184
            goto L119
        L167:
            r118 = r5;
            goto L119
        L158:
            r65 = r5;
        L161:
            th = move-exception;
            Result.Companion r67 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L163
        L210:
            r6 = r0;
        L15:
            th = move-exception;
            Throwable r68 = th;
            r5 = null;
        L237:
            Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L195
            MediaCodec r70 = (MediaCodec) r10.element;     // Catch: Throwable -> L195
            if (r70 == null) goto L192;
            r70.stop();     // Catch: Throwable -> L195
            Unit r71 = Unit.INSTANCE;     // Catch: Throwable -> L195
        L193:
            Result.constructor-impl(r71);     // Catch: Throwable -> L195
        L228:
            MediaCodec r72 = (MediaCodec) r10.element;     // Catch: Throwable -> L203
            if (r72 == null) goto L200;
            r72.release();     // Catch: Throwable -> L203
            Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L203
        L201:
            Result.constructor-impl(r120);     // Catch: Throwable -> L203
            throw r68;
        L200:
            r120 = r5;
        L203:
            th = move-exception;
            Result.Companion r73 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            throw r68;
        L192:
            r71 = r5;
        L195:
            th = move-exception;
            Result.Companion r74 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L150:
            th = th;
            r5 = null;
        L188:
            r68 = th;
        L184:
            th = move-exception;
            Result.Companion r75 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L168:
            e = e;
            r1 = "AudioUtils";
            r5 = null;
        L152:
            e = e;
            r1 = "AudioUtils";
            r5 = null;
        L187:
            th = th;
            goto L188
        }
    }

    static {
        a = new C0125a();
    }
}
