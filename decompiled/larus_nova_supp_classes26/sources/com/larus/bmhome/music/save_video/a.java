package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final C0027a i = null;
    public final Context a;
    public final q b;
    public final MediaFormat c;
    public final MediaCodec d;
    public final MediaCodec.BufferInfo e;
    public final b f;
    public Surface g;
    public final MediaExtractor h;

    /* JADX INFO: renamed from: com.larus.bmhome.music.save_video.a$a, reason: collision with other inner class name */
    public static final class C0027a {
        public C0027a() {
        }

        public static MediaFormat b(q r3) {
            MediaFormat r0 = MediaFormat.createVideoFormat(r3.d, r3.b, r3.c);
            r0.setInteger("color-format", 2130708361);
            r0.setInteger("bitrate", r3.g);
            r0.setFloat("frame-rate", r3.f);
            r0.setInteger("i-frame-interval", r3.h);
            return r0;
        }

        public static Pair a(MediaCodecList r5, int r6, int r7, q r8) {
            Iterator r9 = ArrayIteratorKt.iterator(r5.getCodecInfos());
        L4:
            if (r9.hasNext() == false) goto L22;
            MediaCodecInfo r0 = (MediaCodecInfo) r9.next();
            if (r0.isEncoder() == false) goto L4;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            Object r2 = Result.constructor-impl(r0.getCapabilitiesForType(r8.d).getVideoCapabilities());     // Catch: Throwable -> L9
        L12:
            if (Result.isFailure-impl(r2) == false) goto L14;
            r2 = null;
        L14:
            MediaCodecInfo.VideoCapabilities r3 = (MediaCodecInfo.VideoCapabilities) r2;
            if (r3 == null) goto L4;
            int r4 = (((r3.getWidthAlignment() + r6) - 1) / r3.getWidthAlignment()) * r3.getWidthAlignment();
            int r10 = (((r3.getHeightAlignment() + r7) - 1) / r3.getHeightAlignment()) * r3.getHeightAlignment();
            if (r3.areSizeAndRateSupported(r4, r10, r8.f) == false) goto L4;
            return TuplesKt.to(Integer.valueOf(r4), Integer.valueOf(r10));
        L9:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        L22:
            return TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r7));
        }
    }

    static {
        i = new C0027a();
    }

    public final void a(boolean r13) {
        q r0 = this.b;
        long r1 = r0.i;
        boolean r2 = r0.j;
        long r3 = SystemClock.elapsedRealtime();
        if (r13 == false) goto L5;
        this.d.signalEndOfInputStream();
    L5:
        ByteBuffer[] r5 = this.d.getOutputBuffers();
    L6:
        int r6 = this.d.dequeueOutputBuffer(this.e, 10000);
        if (r2 == false) goto L15;
        if (r1 <= 0) goto L15;
        if (r13 == false) goto L15;
        long r8 = SystemClock.elapsedRealtime() - r3;
        if (r8 < r1) goto L15;
        FLogger.a.e("FrameBuilder", "drainCodec overall timeout, waitMs=" + r8 + ", timeoutMs=" + r1);
        return;
    L15:
        if (r6 == (-1)) goto L16;
        if (r6 == (-3)) goto L20;
        boolean r9 = true;
        if (r6 == (-2)) goto L23;
        if (r6 < 0) goto L6;
        if (r5 == null) goto L64;
        ByteBuffer r7 = r5[r6];
        if (r7 == null) goto L64;
        MediaCodec.BufferInfo r10 = this.e;
        if ((r10.flags & 2) == 0) goto L44;
        r10.size = 0;
    L44:
        if (r10.size == 0) goto L65;
        b r11 = this.f;
        if (r11 != null) goto L48;
    L50:
        r9 = false;
    L51:
        if (r9 == false) goto L56;
        b r12 = this.f;
        if (r12 == null) goto L65;
        r12.b(r7, this.e);
        goto L65
    L56:
        throw new RuntimeException("muxer hasn't started");
    L48:
        if (r11.isStarted() != true) goto L50;
    L65:
        this.d.releaseOutputBuffer(r6, false);     // Catch: Exception -> L59
    L61:
        if ((this.e.flags & 4) == 0) goto L6;
        return;
    L64:
        throw new RuntimeException("encoderOutputBuffer  " + r6 + " was null");
    L23:
        b r14 = this.f;
        if (r14 != null) goto L26;
    L28:
        r9 = false;
    L29:
        if (r9 == true) goto L34;
        MediaFormat r15 = this.d.getOutputFormat();
        FLogger.a.i("FrameBuilder", "encoder output format changed: " + r15);
        b r16 = this.f;
        if (r16 == null) goto L6;
        r16.c(r15, this.h);
        goto L6
    L34:
        throw new RuntimeException("format changed twice");
    L26:
        if (r14.isStarted() != true) goto L28;
    L20:
        r5 = this.d.getOutputBuffers();
        goto L6
    L16:
        if (r13 == true) goto L6;
    }

    public a(Context r3, q r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "muxerConfig");
        this.a = r3;
        this.b = r4;
        i.getClass();
        MediaFormat r6 = C0027a.b(r4);
        this.c = r6;
        this.d = MediaCodec.createByCodecName(new MediaCodecList(0).findEncoderForFormat(r6));
        this.e = new MediaCodec.BufferInfo();
        this.f = r4.k;
        if (r5 == null) goto L5;
        MediaExtractor r7 = new MediaExtractor();
        r7.setDataSource(r5);
    L6:
        this.h = r7;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
