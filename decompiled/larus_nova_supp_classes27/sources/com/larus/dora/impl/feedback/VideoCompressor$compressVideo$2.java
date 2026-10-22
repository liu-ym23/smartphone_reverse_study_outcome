package com.larus.dora.impl.feedback;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.VideoCompressor$compressVideo$2", f = "VideoCompressor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {170}, m = "invokeSuspend", n = {"outputFile", "extractor", "encoder", "decoder", "muxer", "bufferInfo", "duration", "outputTrackIndex", "isExtractorDone", "isDecoderDone", "isEncoderDone", "lastProgress"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4"})
final class VideoCompressor$compressVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ String $inputFilePath;
    final /* synthetic */ String $outputFileName;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.VideoCompressor$compressVideo$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.VideoCompressor$compressVideo$2$1", f = "VideoCompressor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Integer, Unit> $callback;
        final /* synthetic */ int $progress;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Integer, Unit> r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$progress = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$progress, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$callback.invoke(Boxing.boxInt(this.$progress));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoCompressor$compressVideo$2(String r1, String r2, Function1<? super Integer, Unit> r3, Continuation<? super VideoCompressor$compressVideo$2> r4) {
        this.$inputFilePath = r1;
        this.$outputFileName = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoCompressor$compressVideo$2(this.$inputFilePath, this.$outputFileName, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static String a(MediaMetadataRetriever r110) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {9};
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r1, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r110.extractMetadata(9);
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x01f1 -> B:70:0x0253). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0238 -> B:69:0x0241). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0268 -> B:75:0x0287). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r31) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L10;
        if (r4 != 1) goto L9;
        int r0 = this.I$4;
        int r2 = this.I$3;
        int r5 = this.I$2;
        int r14 = this.I$1;
        int r15 = this.I$0;
        long r6 = this.J$0;
        MediaCodec.BufferInfo r8 = (MediaCodec.BufferInfo) this.L$5;
        MediaMuxer r9 = (MediaMuxer) this.L$4;
        MediaCodec r7 = (MediaCodec) this.L$3;
        MediaCodec r11 = (MediaCodec) this.L$2;
        MediaExtractor r12 = (MediaExtractor) this.L$1;
        File r10 = (File) this.L$0;
        ResultKt.throwOnFailure(r31);     // Catch: Exception -> L95
        MediaCodec r17 = r11;
        File r13 = r10;
        VideoCompressor$compressVideo$2 r16 = this;
    L69:
        VideoCompressor$compressVideo$2 r18 = r16;
        File r110 = r13;
        MediaCodec.BufferInfo r111 = r8;
        MediaCodec r20 = r17;
        MediaExtractor r27 = r12;
        int r112 = r0;
        MediaCodec r1 = r7;
        int r21 = r14;
        long r28 = r6;
        MediaExtractor r22 = r27;
        int r23 = r15;
        long r113 = r28;
    L71:
        if ((r111.flags & 4) == 0) goto L73;
        r20.signalEndOfInputStream();     // Catch: Exception -> L95
        r5 = 1;
    L73:
        int r32 = r2;
        int r114 = r21;
        long r115 = r113;
        r18 = r18;
        long r24 = 10000;
        MediaExtractor r116 = r22;
    L75:
        int r25 = r20.dequeueOutputBuffer(r111, r24);     // Catch: Exception -> L95
        if (r25 == (-3)) goto L91;
        if (r25 != (-2)) goto L80;
        r23 = r9.addTrack(r20.getOutputFormat());     // Catch: Exception -> L95
        r9.start();     // Catch: Exception -> L95
        goto L91
    L80:
        if (r25 == (-1)) goto L87;
        ByteBuffer r26 = r20.getOutputBuffer(r25);     // Catch: Exception -> L95
        if (r23 == (-1)) goto L84;
        Intrinsics.checkNotNull(r26);     // Catch: Exception -> L95
        r9.writeSampleData(r23, r26, r111);     // Catch: Exception -> L95
    L84:
        r20.releaseOutputBuffer(r25, false);     // Catch: Exception -> L95
        if ((r111.flags & 4) == 0) goto L91;
        r2 = 1;
    L88:
        MediaExtractor r30 = r116;
        int r117 = r114;
        long r118 = r115;
    L41:
        if (r2 != 0) goto L92;
        if (r117 != 0) goto L50;
        long r119 = r118;
        int r120 = r1.dequeueInputBuffer(10000);     // Catch: Exception -> L95
        if (r120 < 0) goto L49;
        ByteBuffer r121 = r1.getInputBuffer(r120);     // Catch: Exception -> L95
        Intrinsics.checkNotNull(r121);     // Catch: Exception -> L95
        int r122 = r30.readSampleData(r121, 0);     // Catch: Exception -> L95
        if (r122 >= 0) goto L48;
        r18 = r18;
        r23 = r23;
        r116 = r30;
        MediaCodec r123 = r20;
        r9 = r9;
        r110 = r110;
        r111 = r111;
        r1.queueInputBuffer(r120, 0, 0, 0, 4);     // Catch: Exception -> L95
        r21 = 1;
    L52:
        if (r5 != 0) goto L74;
        int r33 = r1.dequeueOutputBuffer(r111, 10000);     // Catch: Exception -> L95
        if (r33 == (-3)) goto L74;
        if (r33 == (-2)) goto L74;
        if (r33 == (-1)) goto L74;
        r1.releaseOutputBuffer(r33, true);     // Catch: Exception -> L95
        int r34 = (int) ((r111.presentationTimeUs / ((long) 10)) / r119);     // Catch: Exception -> L95
        if (r112 != (-1)) goto L62;
    L65:
        MainCoroutineDispatcher r35 = Dispatchers.getMain();     // Catch: Exception -> L95
        r16 = r18;
        AnonymousClass1 r36 = new AnonymousClass1(r16.$callback, r34, null);     // Catch: Exception -> L95
        r13 = r110;
        r16.L$0 = r13;     // Catch: Exception -> L95
        r16.L$1 = r116;     // Catch: Exception -> L95
        r16.L$2 = r123;     // Catch: Exception -> L95
        r16.L$3 = r1;     // Catch: Exception -> L95
        r16.L$4 = r9;     // Catch: Exception -> L95
        r16.L$5 = r111;     // Catch: Exception -> L95
        r17 = r123;
        long r124 = r119;
        r16.J$0 = r124;     // Catch: Exception -> L95
        int r37 = r23;
        r16.I$0 = r37;     // Catch: Exception -> L95
        r16.I$1 = r21;     // Catch: Exception -> L95
        r16.I$2 = r5;     // Catch: Exception -> L95
        r16.I$3 = r2;     // Catch: Exception -> L95
        r16.I$4 = r34;     // Catch: Exception -> L95
        MediaCodec.BufferInfo r125 = r111;
        r16.label = 1;     // Catch: Exception -> L95
        if (BuildersKt.withContext(r35, r36, r16) != r3) goto L68;
        return r3;
    L68:
        r9 = r9;
        r14 = r21;
        r7 = r1;
        r0 = r34;
        r6 = r124;
        r12 = r116;
        r15 = r37;
        r8 = r125;
        goto L69
    L62:
        if ((r34 - r112) > 5) goto L65;
        r111 = r111;
        r20 = r123;
        r9 = r9;
        r22 = r116;
        r113 = r119;
        r23 = r23;
        r110 = r110;
    L74:
        int r38 = r112;
        MediaCodec r126 = r123;
        r32 = r2;
        r114 = r21;
        r18 = r18;
        r110 = r110;
        r9 = r9;
        r111 = r111;
        r24 = 10000;
        r115 = r119;
        r112 = r38;
        r23 = r23;
        r20 = r126;
        goto L75
    L48:
        MediaExtractor r127 = r30;
        r123 = r20;
        r116 = r127;
        r1.queueInputBuffer(r120, 0, r122, r127.getSampleTime(), 0);     // Catch: Exception -> L95
        Boxing.boxBoolean(r116.advance());     // Catch: Exception -> L95
    L51:
        r21 = r117;
        goto L52
    L49:
        r116 = r30;
        r123 = r20;
        goto L51
    L50:
        r123 = r20;
        r119 = r118;
        r116 = r30;
        goto L51
    L92:
        MediaCodec r128 = r20;
        MediaMuxer r129 = r9;
        File r130 = r110;
        r129.stop();     // Catch: Exception -> L95
        r129.release();     // Catch: Exception -> L95
        r128.stop();     // Catch: Exception -> L95
        r128.release();     // Catch: Exception -> L95
        r1.stop();     // Catch: Exception -> L95
        r1.release();     // Catch: Exception -> L95
        r30.release();     // Catch: Exception -> L95
        t0 r40 = t0.a;     // Catch: Exception -> L95
        r130.getAbsolutePath();     // Catch: Exception -> L95
        Result.Companion r41 = Result.Companion;     // Catch: Exception -> L95
        Object r42 = Result.constructor-impl(r130.getAbsolutePath());     // Catch: Exception -> L95
    L98:
        return Result.box-impl(r42);
    L87:
        r2 = r32;
    L91:
        r24 = 10000;
        goto L75
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r31);
        File r43 = new PolarisFileWrapper(this.$inputFilePath).getParentFile();     // Catch: Exception -> L95
        if (r43.exists() == true) goto L14;
        r43.mkdirs();     // Catch: Exception -> L95
    L14:
        File r44 = new PolarisFileWrapper(r43, this.$outputFileName + ".mp4");     // Catch: Exception -> L95
        if (r44.exists() == false) goto L17;
        r44.delete();     // Catch: Exception -> L95
    L17:
        MediaExtractor r45 = new MediaExtractor();     // Catch: Exception -> L95
        r45.setDataSource(this.$inputFilePath);     // Catch: Exception -> L95
        int r46 = r45.getTrackCount();     // Catch: Exception -> L95
        int r47 = 0;
    L20:
        if (r47 >= r46) goto L30;
        MediaFormat r48 = r45.getTrackFormat(r47);     // Catch: Exception -> L95
        String r131 = r48.getString("mime");     // Catch: Exception -> L95
        if (r131 != null) goto L24;
    L26:
        boolean r132 = false;
    L27:
        if (r132 == true) goto L28;
        r47 = r47 + 1;     // Catch: Exception -> L95
        goto L20
    L28:
        int r50 = -1;
    L31:
        if (r47 == r50) goto L93;
        if (r48 == null) goto L93;
        r45.selectTrack(r47);     // Catch: Exception -> L95
        MediaMetadataRetriever r51 = new MediaMetadataRetriever();     // Catch: Exception -> L95
        r51.setDataSource(this.$inputFilePath);     // Catch: Exception -> L95
        String r52 = a(r51);     // Catch: Exception -> L95
        if (r52 == null) goto L39;
        Long r53 = StringsKt.toLongOrNull(r52);     // Catch: Exception -> L95
        if (r53 == null) goto L39;
        long r54 = r53.longValue();     // Catch: Exception -> L95
    L40:
        int r133 = r48.getInteger("width");     // Catch: Exception -> L95
        int r134 = r48.getInteger("height");     // Catch: Exception -> L95
        int r135 = RangesKt.coerceAtMost(r48.getInteger("frame-rate"), 30);     // Catch: Exception -> L95
        MediaFormat r136 = MediaFormat.createVideoFormat("video/avc", r133, r134);     // Catch: Exception -> L95
        r136.setInteger("bitrate", 2000000);     // Catch: Exception -> L95
        r136.setInteger("frame-rate", r135);     // Catch: Exception -> L95
        r136.setInteger("i-frame-interval", 10);     // Catch: Exception -> L95
        r136.setInteger("color-format", 2130708361);     // Catch: Exception -> L95
        MediaCodec r55 = MediaCodec.createEncoderByType("video/avc");     // Catch: Exception -> L95
        r55.configure(r136, null, null, 1);     // Catch: Exception -> L95
        Surface r56 = r55.createInputSurface();     // Catch: Exception -> L95
        String r57 = r48.getString("mime");     // Catch: Exception -> L95
        Intrinsics.checkNotNull(r57);     // Catch: Exception -> L95
        MediaCodec r58 = MediaCodec.createDecoderByType(r57);     // Catch: Exception -> L95
        r58.configure(r48, r56, null, 0);     // Catch: Exception -> L95
        MediaMuxer r60 = new MediaMuxer(r44.getAbsolutePath(), 0);     // Catch: Exception -> L95
        r58.start();     // Catch: Exception -> L95
        r55.start();     // Catch: Exception -> L95
        r110 = r44;
        r118 = r54;
        r111 = new MediaCodec.BufferInfo();     // Catch: Exception -> L95
        r23 = -1;
        r112 = -1;
        r117 = 0;
        r18 = this;
        r9 = r60;
        r30 = r45;
        r2 = 0;
        r5 = 0;
        r20 = r55;
        r1 = r58;
    L39:
        r54 = 0;
    L93:
        Result.Companion r61 = Result.Companion;     // Catch: Exception -> L95
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("No video track found"))));
    L24:
        if (StringsKt.startsWith$default(r131, "video/", false, 2, null) != true) goto L26;
        r132 = true;
        goto L27
    L30:
        r50 = -1;
        r47 = -1;
        r48 = null;
    L95:
        e = move-exception;
        t0 r62 = t0.a;
        Result.Companion r63 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(e));
        goto L98
    }
}
