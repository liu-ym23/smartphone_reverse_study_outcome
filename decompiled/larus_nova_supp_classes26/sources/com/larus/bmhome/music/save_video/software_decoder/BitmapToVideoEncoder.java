package com.larus.bmhome.music.save_video.software_decoder;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BitmapToVideoEncoder {
    public static final BitmapToVideoEncoder a = null;
    public static int b;
    public static int c;

    static {
        a = new BitmapToVideoEncoder();
    }

    public BitmapToVideoEncoder() {
    }

    public final Object a(int r19, int r20, List<Bitmap> r21, String r22, Integer r23, Integer r24, Integer r25, Continuation<? super Integer> r26) {
        if ((r26 instanceof BitmapToVideoEncoder$startEncoding$1) == false) goto L7;
        BitmapToVideoEncoder$startEncoding$1 r6 = (BitmapToVideoEncoder$startEncoding$1) r26;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        ResultKt.throwOnFailure(r5);
    L51:
        return Boxing.boxInt(300);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        FLogger.a.d("save_music_video", "VideoSRSaverHelper startEncoding, width:" + r19 + ", height:" + r20 + ", bitRate:" + r23 + ", frameRate:" + r24 + ", iFrameInterval:" + r25);
        int r10 = MediaCodecList.getCodecCount();
        int r12 = 0;
    L16:
        if (r12 >= r10) goto L27;
        MediaCodecInfo r15 = MediaCodecList.getCodecInfoAt(r12);
        if (r15.isEncoder() == false) goto L26;
        String[] r11 = r15.getSupportedTypes();
        int r13 = r11.length;
        int r14 = 0;
    L21:
        if (r14 >= r13) goto L26;
        int r17 = r10;
        if (StringsKt.equals(r11[r14], "video/avc", true) == true) goto L28;
        r14 = r14 + 1;
        r10 = r17;
    L28:
        if (r15 == null) goto L30;
        FLogger.a.d("save_music_video", "Found codec: " + r15.getName());
        MediaCodec r16 = MediaCodec.createEncoderByType("video/avc");     // Catch: IOException -> L54
        Intrinsics.checkNotNull(r16);
        MediaFormat r0 = MediaFormat.createVideoFormat("video/avc", r19, r20);
        if (r23 == null) goto L36;
        int r1 = r23.intValue();
    L37:
        r0.setInteger("bitrate", r1);
        if (r24 == null) goto L40;
        int r2 = r24.intValue();
    L41:
        r0.setInteger("frame-rate", r2);
        r0.setInteger("color-format", 2135033992);
        if (r25 == null) goto L44;
        int r3 = r25.intValue();
    L45:
        r0.setInteger("i-frame-interval", r3);
        r16.configure(r0, null, null, 1);     // Catch: IOException -> L52
        r16.start();     // Catch: IOException -> L52
        MediaMuxer r4 = new MediaMuxer(r22, 0);     // Catch: IOException -> L52
        CoroutineDispatcher r18 = Dispatchers.getIO();
        BitmapToVideoEncoder$startEncoding$2 r27 = new BitmapToVideoEncoder$startEncoding$2(r16, r4, r21, r24, null);
        r6.label = 1;
        if (BuildersKt.withContext(r18, r27, r6) != r8) goto L51;
        return r8;
    L53:
        return Boxing.boxInt(304);
    L44:
        r3 = 10;
        goto L45
    L40:
        r2 = 5;
        goto L41
    L36:
        r1 = 2000000;
    L55:
        return Boxing.boxInt(303);
    L30:
        return Boxing.boxInt(302);
    L26:
        r12 = r12 + 1;
        r10 = r10;
        goto L16
    L27:
        r15 = null;
    L7:
        r6 = new BitmapToVideoEncoder$startEncoding$1(this, r26);
        goto L8
    }
}
