package com.larus.bmhome.bigimg;

import android.os.SystemClock;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$saveOriginImageWithOutToastResult$2", f = "ImageSave.kt", i = {0, 0, 1, 1, 2, 2}, l = {895, 897, 899}, m = "invokeSuspend", n = {"perf", "startStamp", "perf", "startStamp", "perf", "result"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "Z$0"})
final class ImageSave$saveOriginImageWithOutToastResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ImageSave.a, Unit> $callback;
    final /* synthetic */ Map<String, String> $exifMap;
    final /* synthetic */ String $url;
    long J$0;
    Object L$0;
    boolean Z$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.ImageSave$saveOriginImageWithOutToastResult$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$saveOriginImageWithOutToastResult$2$1", f = "ImageSave.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ImageSave.a, Unit> $callback;
        final /* synthetic */ boolean $result;
        final /* synthetic */ long $startStamp;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(long r1, boolean r3, Function1<? super ImageSave.a, Unit> r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.$startStamp = r1;
            this.$result = r3;
            this.$callback = r4;
            this.$url = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$startStamp, this.$result, this.$callback, this.$url, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r6);
            long r0 = SystemClock.elapsedRealtime() - this.$startStamp;
            if (this.$result == false) goto L10;
            Function1<ImageSave.a, Unit> r7 = this.$callback;
            if (r7 == null) goto L9;
            r7.invoke(new ImageSave.a.c(this.$url, r0));
        L9:
            a2.b(1, r0, "picture");
            return Unit.INSTANCE;
        L10:
            a2.b(0, r0, "picture");
            Function1<ImageSave.a, Unit> r8 = this.$callback;
            if (r8 == null) goto L13;
            r8.invoke(new ImageSave.a.b(this.$url, r0));
            return Unit.INSTANCE;
        L13:
            return null;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSave$saveOriginImageWithOutToastResult$2(String r1, Map<String, String> r2, Function1<? super ImageSave.a, Unit> r3, Continuation<? super ImageSave$saveOriginImageWithOutToastResult$2> r4) {
        this.$url = r1;
        this.$exifMap = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSave$saveOriginImageWithOutToastResult$2(this.$url, this.$exifMap, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.platform.service.watermark.WatermarkPerfLogger$a] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        WatermarkPerfLogger.a r1 = this.label;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        boolean r2 = this.Z$0;
        WatermarkPerfLogger.a r3 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L18
        r1 = r3;
    L39:
        if (r2 == false) goto L41;
        WatermarkPerfLogger.Result r16 = WatermarkPerfLogger.Result.SUCCESS;     // Catch: Throwable -> L18
    L42:
        if (r2 == true) goto L44;
        String r4 = "save_bitmap_false";
    L45:
        r1.b(r16, r4);     // Catch: Throwable -> L18
        return Unit.INSTANCE;
    L44:
        r4 = null;
        goto L45
    L41:
        r16 = WatermarkPerfLogger.Result.FAIL;     // Catch: Throwable -> L18
        goto L42
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        long r6 = this.J$0;
        WatermarkPerfLogger.a r5 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L18
        WatermarkPerfLogger.a r7 = r5;
    L14:
        long r8 = r6;
        boolean r17 = ((Boolean) r15).booleanValue();     // Catch: Throwable -> L18
        r7.a("saveBitmap");     // Catch: Throwable -> L18
        MainCoroutineDispatcher r9 = Dispatchers.getMain();     // Catch: Throwable -> L18
        if (r17 == false) goto L34;
        boolean r10 = true;
    L35:
        AnonymousClass1 r13 = new AnonymousClass1(r8, r10, this.$callback, this.$url, null);     // Catch: Throwable -> L18
        this.L$0 = r7;     // Catch: Throwable -> L18
        this.Z$0 = r17;     // Catch: Throwable -> L18
        this.label = 3;     // Catch: Throwable -> L18
        if (BuildersKt.withContext(r9, r13, this) != r0) goto L38;
        return r0;
    L38:
        r2 = r17;
        r1 = r7;
        goto L39
    L34:
        r10 = false;
        goto L35
    L15:
        r6 = this.J$0;
        WatermarkPerfLogger.a r11 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L18
        WatermarkPerfLogger.a r12 = r11;
    L28:
        r12.a("watermark");     // Catch: Throwable -> L18
        ImageSave r14 = ImageSave.a;     // Catch: Throwable -> L18
        Map<String, String> r18 = this.$exifMap;     // Catch: Throwable -> L18
        this.L$0 = r12;     // Catch: Throwable -> L18
        this.J$0 = r6;     // Catch: Throwable -> L18
        this.label = 2;     // Catch: Throwable -> L18
        r15 = r14.o((String) r15, r18, false, this);     // Catch: Throwable -> L18
        r7 = r12;
        if (r15 != r0) goto L14;
        return r0;
    L20:
        ResultKt.throwOnFailure(r15);
        int r19 = WatermarkPerfLogger.a;
        DownloadWatermarkService.a.getClass();
        if (DownloadWatermarkService.d() == false) goto L23;
        WatermarkPerfLogger.Version r110 = WatermarkPerfLogger.Version.ENTERPRISE;
    L24:
        WatermarkPerfLogger.a r20 = WatermarkPerfLogger.a("image_save_origin_silent", r110, DownloadWatermarkScene.CI_GEN_IMAGE_DOWNLOAD);
        WatermarkPerfLogger.Path.a r111 = WatermarkPerfLogger.Path.Companion;
        String r21 = this.$url;
        r111.getClass();
        r20.c(WatermarkPerfLogger.Path.a.a(r21));
        r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        ImageSave r112 = ImageSave.a;     // Catch: Throwable -> L18
        String r22 = this.$url;     // Catch: Throwable -> L18
        this.L$0 = r20;     // Catch: Throwable -> L18
        this.J$0 = r6;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r15 = ImageSave.a(r112, r22, this);     // Catch: Throwable -> L18
        r12 = r20;
        if (r15 != r0) goto L28;
        return r0;
    L23:
        r110 = WatermarkPerfLogger.Version.PERSONAL;
    L18:
        th = move-exception;
        r1.b(WatermarkPerfLogger.Result.FAIL, th.getClass().getSimpleName());
        throw th;
    }
}
