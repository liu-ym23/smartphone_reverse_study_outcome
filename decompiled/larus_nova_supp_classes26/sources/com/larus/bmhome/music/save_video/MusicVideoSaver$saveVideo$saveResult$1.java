package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.view.Surface;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.bmhome.music.TTCNPAHelperKt;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver$saveVideo$saveResult$1", f = "MusicVideoSaver.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
final class MusicVideoSaver$saveVideo$saveResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ String $audioPath;
    final /* synthetic */ List<Bitmap> $bitmaps;
    final /* synthetic */ Context $context;
    final /* synthetic */ Pair<List<Bitmap>, j> $framesInfo;
    final /* synthetic */ MusicCreationContent $musicContent;
    final /* synthetic */ q $muxerConfig;
    final /* synthetic */ String $resultPath;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MusicVideoSaver$saveVideo$saveResult$1(Context r1, q r2, List<Bitmap> r3, String r4, Pair<? extends List<Bitmap>, j> r5, String r6, MusicCreationContent r7, Continuation<? super MusicVideoSaver$saveVideo$saveResult$1> r8) {
        this.$context = r1;
        this.$muxerConfig = r2;
        this.$bitmaps = r3;
        this.$audioPath = r4;
        this.$framesInfo = r5;
        this.$resultPath = r6;
        this.$musicContent = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MusicVideoSaver$saveVideo$saveResult$1(this.$context, this.$muxerConfig, this.$bitmaps, this.$audioPath, this.$framesInfo, this.$resultPath, this.$musicContent, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.larus.bmhome.music.save_video.a] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v31, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r4v36, types: [android.view.Surface] */
    public final Object invokeSuspend(Object r22) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        int r3 = 1;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
        return r22;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        r r1 = new r(this.$context, this.$muxerConfig);
        List<Bitmap> r4 = this.$bitmaps;
        String r5 = this.$audioPath;
        j r6 = (j) this.$framesInfo.getSecond();
        Intrinsics.checkNotNullParameter(r4, "imageList");
        FLogger r7 = FLogger.a;
        String r8 = r.d;
        r7.i(r8, "Generating video");
        if (r1.c.j == false) goto L11;
        int r9 = 3;
    L12:
        boolean r10 = false;
        int r11 = 0;
    L13:
        if (r11 >= r9) goto L104;
        r1.b.delete();
        r1.b.createNewFile();
        r1.c.k = new c(r1.b.getAbsolutePath(), r1.c.f);
        ?? r12 = new a(r1.a, r1.c, r5);
        Rect r14 = null;
        r12.d.configure(r12.c, null, null, r3);     // Catch: IOException -> L102
        r12.g = r12.d.createInputSurface();     // Catch: IOException -> L102
        r12.d.start();     // Catch: IOException -> L102
        r12.a(r10);     // Catch: IOException -> L102
        Iterator r13 = r4.iterator();
        int r15 = 0;
        ?? r16 = r3;
    L18:
        if (r13.hasNext() == false) goto L61;
        Object r17 = r13.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        if (r6 == null) goto L27;
        Integer r19 = r6.a.get(Integer.valueOf(r15));
        if (r19 == null) goto L26;
        int r20 = RangesKt.coerceAtLeast(r19.intValue(), r16 == true ? 1 : 0);
    L28:
        Intrinsics.checkNotNullParameter(r17, "image");
        int r110 = 0;
        ?? r21 = r16;
    L29:
        if (r110 >= r20) goto L60;
        Surface r23 = r12.g;
        if (r23 == null) goto L33;
        ?? r24 = r23.lockCanvas(r14);
    L34:
        List<Bitmap> r111 = r4;
        if ((r17 instanceof Integer) == false) goto L43;
        String r112 = r5;
        FLogger.a.i("FrameBuilder", "Trying to decode as @DrawableRes");
        Bitmap r25 = BitmapFactory.decodeResource(r12.a.getResources(), ((Number) r17).intValue());
        Intrinsics.checkNotNull(r25);
        if (r24 == 0) goto L39;
        r24.drawBitmap(r25, 0.0f, 0.0f, null);
    L39:
        ?? r26 = r12.g;
        if (r26 == 0) goto L42;
        r26.unlockCanvasAndPost(r24);
    L42:
        r12.a(false);
    L59:
        r110 = r110 + 1;
        r4 = r111;
        r5 = r112;
        r21 = 1;
        r14 = null;
        goto L29
    L43:
        r112 = r5;
        if ((r17 instanceof Bitmap) == false) goto L53;
        Bitmap r27 = (Bitmap) r17;
        if (r24 == 0) goto L48;
        r24.drawBitmap(r27, 0.0f, 0.0f, null);
    L48:
        ?? r28 = r12.g;
        if (r28 == 0) goto L51;
        r28.unlockCanvasAndPost(r24);
    L51:
        r12.a(false);
        goto L59
    L53:
        if ((r17 instanceof Canvas) == false) goto L58;
        Canvas r29 = (Canvas) r17;
        Surface r30 = r12.g;
        if (r30 == null) goto L57;
        r30.unlockCanvasAndPost(r29);
    L57:
        r12.a(false);
        goto L59
    L58:
        FLogger.a.e("FrameBuilder", "Image type " + r17 + " is not supported. Try using a Canvas or a Bitmap");
        goto L59
    L33:
        r24 = r14;
        goto L34
    L60:
        r15 = r18;
        r16 = r21;
        goto L18
    L26:
        r20 = 1;
        goto L28
    L27:
        r20 = r1.c.e;
        goto L28
    L61:
        List<Bitmap> r113 = r4;
        String r114 = r5;
        r12.a(r16);
        r12.d.stop();
        r12.d.release();
        Surface r31 = r12.g;
        if (r31 == null) goto L65;
        r31.release();
    L65:
        if (r12.h == null) goto L88;
        ByteBuffer r32 = ByteBuffer.allocate(262144);
        MediaCodec.BufferInfo r33 = new MediaCodec.BufferInfo();
        MediaExtractor r34 = r12.h;
        long r115 = 0;
        if (r34 == null) goto L70;
        r34.seekTo(0, 2);
    L70:
        b r35 = r12.f;
        if (r35 == null) goto L73;
        r115 = r35.d();
    L73:
        boolean r36 = false;
    L74:
        if (r36 == true) goto L88;
        r33.offset = 100;
        MediaExtractor r116 = r12.h;
        Intrinsics.checkNotNull(r116);
        int r117 = r116.readSampleData(r32, 100);
        r33.size = r117;
        if (r117 < 0) goto L77;
        MediaExtractor r118 = r12.h;
        Intrinsics.checkNotNull(r118);
        long r119 = r118.getSampleTime();
        r33.presentationTimeUs = r119;
        MediaExtractor r37 = r12.h;
        Intrinsics.checkNotNull(r37);
        r33.flags = r37.getSampleFlags();
        b r38 = r12.f;
        if (r38 == null) goto L81;
        Intrinsics.checkNotNull(r32);
        r38.a(r32, r33);
    L81:
        MediaExtractor r39 = r12.h;
        Intrinsics.checkNotNull(r39);
        r39.advance();
        if (r119 <= r115) goto L86;
        ByteBuffer r120 = r32;
        if ((r119 % r115) > (r12.b.e * 1000000)) goto L85;
    L87:
        r32 = r120;
    L85:
        r32 = r120;
        r36 = true;
        goto L74
    L86:
        r120 = r32;
        goto L87
    L77:
        r33.size = 0;
        r120 = r32;
    L88:
        MediaExtractor r40 = r12.h;
        if (r40 == null) goto L91;
        r40.release();
    L91:
        b r41 = r12.f;
        if (r41 == null) goto L94;
        r41.release();
    L94:
        PolarisFileInputStreamWrapper r42 = new PolarisFileInputStreamWrapper(r1.b);
        byte[] r43 = new byte[200];
        r42.read(r43);
        Intrinsics.checkNotNullParameter(r42, "<this>");
        r42.close();     // Catch: Throwable -> L97
    L98:
        String r44 = Arrays.toString(r43);
        FLogger.a.i("MediaMuxer", "file length " + r1.b.length() + " file head " + r44);
        if (StringsKt.startsWith$default(r44, "[0, 0, 0, 0, 0, 0", false, 2, null) == false) goto L104;
        r11 = r11 + 1;
        r4 = r113;
        r5 = r114;
        r3 = 1;
        r10 = false;
    L102:
        e = move-exception;
        FLogger.a.e(r8, "Start Encoder Failed");
        Object r45 = new s(e);
    L105:
        FLogger.a.i("save_music_video", "mux result is " + r45);
        if ((r45 instanceof t) == false) goto L108;
        MusicVideoSaver r46 = MusicVideoSaver.a;
        MusicVideoSaver.g("Encode bitmap to video");
        String r47 = this.$resultPath;
        MusicCreationContent r48 = this.$musicContent;
        this.label = 1;
        Object r49 = TTCNPAHelperKt.b(r47, r48, this);
        if (r49 != r2) goto L133;
        return r2;
    L133:
        return r49;
    L108:
        return Boxing.boxInt(301);
    L104:
        r45 = new t(r1.b);
        goto L105
    L11:
        r9 = 10;
        goto L12
    }
}
