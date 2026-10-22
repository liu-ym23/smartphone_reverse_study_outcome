package com.larus.bmhome.music.save_video.software_decoder;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaMuxer;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.software_decoder.BitmapToVideoEncoder$startEncoding$2", f = "BitmapToVideoEncoder.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapToVideoEncoder$startEncoding$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<Bitmap> $bitmaps;
    final /* synthetic */ Integer $frameRate;
    final /* synthetic */ MediaCodec $mediaCodec;
    final /* synthetic */ MediaMuxer $mediaMuxer;
    int label;

    public BitmapToVideoEncoder$startEncoding$2(MediaCodec r1, MediaMuxer r2, List<Bitmap> r3, Integer r4, Continuation<? super BitmapToVideoEncoder$startEncoding$2> r5) {
        this.$mediaCodec = r1;
        this.$mediaMuxer = r2;
        this.$bitmaps = r3;
        this.$frameRate = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BitmapToVideoEncoder$startEncoding$2(this.$mediaCodec, this.$mediaMuxer, this.$bitmaps, this.$frameRate, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r27);
        return r27;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r27);
        BitmapToVideoEncoder r3 = BitmapToVideoEncoder.a;
        MediaCodec r4 = this.$mediaCodec;
        MediaMuxer r11 = this.$mediaMuxer;
        List<Bitmap> r5 = this.$bitmaps;
        Integer r12 = this.$frameRate;
        this.label = 1;
        j r13 = new j(IntrinsicsKt.intercepted(this), 1);
        r13.C();
        FLogger.a.d("save_music_video", "Encoder started");
        Iterator r15 = r5.iterator();
    L10:
        if (r15.hasNext() == false) goto L61;
        Bitmap r6 = (Bitmap) r15.next();
        int r7 = r6.getWidth();
        int r8 = r6.getHeight();
        int r9 = r7 * r8;
        int[] r10 = new int[r9];
        r6.getPixels(r10, 0, r7, 0, 0, r7, r8);
        int r14 = (r9 * 3) / 2;
        byte[] r16 = new byte[r14];
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L12:
        if (r17 >= r8) goto L39;
        int r0 = 0;
    L14:
        if (r0 >= r7) goto L38;
        int r110 = r7;
        int r20 = r10[r19];
        int r21 = (r20 & 16711680) >> 16;
        int r22 = r8;
        int r23 = (r20 & 65280) >> 8;
        int[] r24 = r10;
        int r25 = (r20 & 255) >> 0;
        int r26 = (((((r21 * 66) + (r23 * 129)) + (r25 * 25)) + 128) >> 8) + 16;
        Iterator r28 = r15;
        int r111 = (((((r21 * (-38)) - (r23 * 74)) + (r25 * 112)) + 128) >> 8) + 128;
        int r29 = (((((r21 * 112) - (r23 * 94)) - (r25 * 18)) + 128) >> 8) + 128;
        int r30 = r18 + 1;
        if (r26 >= 0) goto L19;
        r26 = 0;
    L21:
        r16[r18] = (byte) r26;
        if ((r17 % 2) != 0) goto L37;
        if ((r19 % 2) != 0) goto L37;
        int r31 = r9 + 1;
        int r32 = 255;
        if (r111 >= 0) goto L28;
        r111 = 0;
    L30:
        r16[r9] = (byte) r111;
        r9 = r31 + 1;
        if (r29 >= 0) goto L33;
        r32 = 0;
    L36:
        r16[r31] = (byte) r32;
        goto L37
    L33:
        if (r29 > 255) goto L36;
        r32 = r29;
        goto L36
    L28:
        if (r111 <= 255) goto L30;
        r111 = 255;
    L37:
        r19 = r19 + 1;
        r0 = r0 + 1;
        r7 = r110;
        r18 = r30;
        r10 = r24;
        r8 = r22;
        r15 = r28;
        goto L14
    L19:
        if (r26 <= 255) goto L21;
        r26 = 255;
        goto L21
    L38:
        r17 = r17 + 1;
        goto L12
    L39:
        Iterator r210 = r15;
        r6.recycle();
        int r33 = r4.dequeueInputBuffer(500000);
        long r34 = BitmapToVideoEncoder.b;
        if (r12 == null) goto L42;
        int r35 = r12.intValue();
    L43:
        Integer r112 = r12;
        j r113 = r13;
        long r114 = ((long) 132) + ((r34 * ((long) 1000000)) / ((long) r35));
        if (r33 < 0) goto L46;
        ByteBuffer r36 = r4.getInputBuffer(r33);
        Intrinsics.checkNotNull(r36);
        r36.clear();
        r36.put(r16);
        r4.queueInputBuffer(r33, 0, r14, r114, 0);
        BitmapToVideoEncoder.b++;
    L46:
        MediaCodec.BufferInfo r37 = new MediaCodec.BufferInfo();
        int r38 = r4.dequeueOutputBuffer(r37, 500000);
        if (r38 != (-1)) goto L50;
        FLogger.a.e("save_music_video", "No output from encoder available");
    L60:
        r12 = r112;
        r13 = r113;
        r15 = r210;
        goto L10
    L50:
        if (r38 != (-2)) goto L52;
        BitmapToVideoEncoder.c = r11.addTrack(r4.getOutputFormat());
        r11.start();
        goto L60
    L52:
        if (r38 >= 0) goto L55;
        FLogger.a.e("save_music_video", "Unexpected result from encoder.dequeueOutputBuffer: " + r38);
        goto L60
    L55:
        if (r37.size == 0) goto L60;
        ByteBuffer r39 = r4.getOutputBuffer(r38);
        if (r39 != null) goto L59;
        FLogger.a.e("save_music_video", "EncoderOutputBuffer " + r38 + " was null");
        goto L60
    L59:
        r39.position(r37.offset);
        r39.limit(r37.offset + r37.size);
        r11.writeSampleData(BitmapToVideoEncoder.c, r39, r37);
        r4.releaseOutputBuffer(r38, false);
        goto L60
    L42:
        r35 = 5;
        goto L43
    L61:
        j r115 = r13;
        r4.stop();
        r4.release();
        r11.stop();
        r11.release();
        Result.Companion r40 = Result.Companion;
        r115.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
        Object r41 = r115.B();
        if (r41 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L64;
        DebugProbesKt.probeCoroutineSuspended(this);
    L64:
        if (r41 != r1) goto L79;
        return r1;
    L79:
        return r41;
    }
}
