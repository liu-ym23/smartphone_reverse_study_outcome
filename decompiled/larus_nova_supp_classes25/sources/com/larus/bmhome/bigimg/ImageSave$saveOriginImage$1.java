package com.larus.bmhome.bigimg;

import android.app.Application;
import android.os.SystemClock;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.platform.audit.BehaviorAuditApi;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$saveOriginImage$1", f = "ImageSave.kt", i = {0, 1, 2, 3, 3, 3, 4, 4}, l = {103, 108, DoraCallStateCode.DOUBAO_CMD_5, DoraCallStateCode.DOUBAO_CMD_14, 116}, m = "invokeSuspend", n = {"perf", "perf", "perf", "perf", "downloadUrl", "startStamp", "perf", "result"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "J$0", "L$0", "Z$0"})
public final class ImageSave$saveOriginImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, String, Long, Unit> $callback;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $checkBlock;
    final /* synthetic */ Map<String, String> $exifMap;
    final /* synthetic */ boolean $isAIGC;
    final /* synthetic */ Function1<Continuation<? super String>, Object> $onInterceptUrl;
    final /* synthetic */ String $url;
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.ImageSave$saveOriginImage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$saveOriginImage$1$1", f = "ImageSave.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Boolean, String, Long, Unit> $callback;
        final /* synthetic */ String $downloadUrl;
        final /* synthetic */ boolean $result;
        final /* synthetic */ long $startStamp;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(boolean r1, Function3<? super Boolean, ? super String, ? super Long, Unit> r2, String r3, long r4, String r6, Continuation<? super AnonymousClass1> r7) {
            this.$result = r1;
            this.$callback = r2;
            this.$downloadUrl = r3;
            this.$startStamp = r4;
            this.$url = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.$result, this.$callback, this.$downloadUrl, this.$startStamp, this.$url, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r13);
            if (this.$result == false) goto L10;
            t19.s r14 = t19.s.a;
            Application r3 = AppHost.a.getApplication();
            r14.getClass();
            t19.s.o(r3, 2131908983, false);
            Function3<Boolean, String, Long, Unit> r15 = this.$callback;
            if (r15 == null) goto L9;
            r15.invoke(Boxing.boxBoolean(true), this.$downloadUrl, Boxing.boxLong(SystemClock.elapsedRealtime() - this.$startStamp));
        L9:
            a2.b(1, SystemClock.elapsedRealtime() - this.$startStamp, "picture");
        L13:
            BehaviorAuditApi.c(new com.larus.platform.audit.b(null, null, null, null, "image", 15), MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "image"), TuplesKt.to("url", this.$url)}));
            return Unit.INSTANCE;
        L10:
            a2.b(0, SystemClock.elapsedRealtime() - this.$startStamp, "picture");
            t19.s r16 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r16.getClass();
            t19.s.b(r0, 2131908982, false);
            Function3<Boolean, String, Long, Unit> r17 = this.$callback;
            if (r17 == null) goto L13;
            r17.invoke(Boxing.boxBoolean(false), this.$downloadUrl, Boxing.boxLong(SystemClock.elapsedRealtime() - this.$startStamp));
            goto L13
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSave$saveOriginImage$1(String r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Map<String, String> r3, boolean r4, Function1<? super Continuation<? super String>, ? extends Object> r5, Function3<? super Boolean, ? super String, ? super Long, Unit> r6, Continuation<? super ImageSave$saveOriginImage$1> r7) {
        this.$url = r1;
        this.$checkBlock = r2;
        this.$exifMap = r3;
        this.$isAIGC = r4;
        this.$onInterceptUrl = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ImageSave$saveOriginImage$1(this.$url, this.$checkBlock, this.$exifMap, this.$isAIGC, this.$onInterceptUrl, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        WatermarkPerfLogger.a r2 = "onInterceptUrl execute failed, ";
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r10 = null;
        if (r0 == 0) goto L34;
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L24;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L14;
        if (r0 != 5) goto L13;
        boolean r1 = this.Z$0;
        r2 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L22
    L86:
        if (r1 == false) goto L88;
        WatermarkPerfLogger.Result r3 = WatermarkPerfLogger.Result.SUCCESS;     // Catch: Throwable -> L22
    L89:
        if (r1 == true) goto L91;
        r10 = "save_bitmap_false";
    L91:
        r2.b(r3, r10);     // Catch: Throwable -> L22
        return Unit.INSTANCE;
    L88:
        r3 = WatermarkPerfLogger.Result.FAIL;     // Catch: Throwable -> L22
        goto L89
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        long r5 = this.J$0;
        String r6 = (String) this.L$1;
        WatermarkPerfLogger.a r7 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L17
        String r14 = r6;
        long r15 = r5;
        r2 = r7;
        Object r8 = r20;
    L79:
        r1 = ((Boolean) r8).booleanValue();     // Catch: Throwable -> L22
        r2.a("saveBitmap");     // Catch: Throwable -> L22
        MainCoroutineDispatcher r9 = Dispatchers.getMain();     // Catch: Throwable -> L22
        if (r1 == false) goto L82;
        boolean r12 = true;
    L83:
        AnonymousClass1 r11 = new AnonymousClass1(r12, this.$callback, r14, r15, this.$url, null);     // Catch: Throwable -> L22
        this.L$0 = r2;     // Catch: Throwable -> L22
        this.L$1 = null;     // Catch: Throwable -> L22
        this.Z$0 = r1;     // Catch: Throwable -> L22
        this.label = 5;     // Catch: Throwable -> L22
        if (BuildersKt.withContext(r9, r11, this) != r4) goto L86;
        return r4;
    L82:
        r12 = false;
    L17:
        th = th;
    L99:
        r7.b(WatermarkPerfLogger.Result.FAIL, th.getClass().getSimpleName());
        throw th;
    L19:
        r2 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L22
        Object r13 = r20;
    L73:
        String r16 = (String) r13;     // Catch: Throwable -> L22
    L75:
        r2.a("watermark");     // Catch: Throwable -> L22
        long r17 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        ImageSave r18 = ImageSave.a;     // Catch: Throwable -> L22
        Map<String, String> r19 = this.$exifMap;     // Catch: Throwable -> L22
        boolean r110 = this.$isAIGC;     // Catch: Throwable -> L22
        this.L$0 = r2;     // Catch: Throwable -> L22
        this.L$1 = r16;     // Catch: Throwable -> L22
        this.J$0 = r17;     // Catch: Throwable -> L22
        this.label = 4;     // Catch: Throwable -> L22
        r8 = r18.o(r16, r19, r110, this);     // Catch: Throwable -> L22
        if (r8 != r4) goto L78;
        return r4;
    L78:
        r14 = r16;
        r15 = r17;
        goto L79
    L24:
        WatermarkPerfLogger.a r21 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L27
        Object r22 = r20;
    L52:
        String r23 = (String) r22;     // Catch: Throwable -> L27
        WatermarkPerfLogger.a r111 = r21;
    L55:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L57
    L61:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L97
        if (r25 == null) goto L65;
        FLogger.a.e("ImageSave [saveOriginImage]", "onInterceptUrl execute failed, " + r25);     // Catch: Throwable -> L97
    L65:
        if (Result.isFailure-impl(r24) == false) goto L67;
        r24 = null;
    L67:
        r16 = (String) r24;     // Catch: Throwable -> L97
        if (r16 != null) goto L74;
        ImageSave r26 = ImageSave.a;     // Catch: Throwable -> L97
        String r27 = this.$url;     // Catch: Throwable -> L97
        this.L$0 = r111;     // Catch: Throwable -> L97
        this.label = 3;     // Catch: Throwable -> L97
        r13 = ImageSave.a(r26, r27, this);     // Catch: Throwable -> L97
        if (r13 != r4) goto L72;
        return r4;
    L72:
        r2 = r111;
        goto L73
    L74:
        r2 = r111;
    L57:
        th = th;
        r21 = r111;
    L103:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L95
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L95
        r111 = r21;
    L95:
        th = th;
        r7 = r21;
    L27:
        th = th;
        goto L103
    L29:
        r111 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L32
    L112:
    L45:
        Function1<Continuation<? super String>, Object> r29 = this.$onInterceptUrl;     // Catch: Throwable -> L97
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L57
        if (r29 == null) goto L54;
        this.L$0 = r111;     // Catch: Throwable -> L57
        this.label = 2;     // Catch: Throwable -> L57
        r22 = r29.invoke(this);     // Catch: Throwable -> L57
        if (r22 != r4) goto L51;
        return r4;
    L51:
        r21 = r111;
        goto L52
    L54:
        r23 = null;
        goto L55
    L34:
        ResultKt.throwOnFailure(r20);
        int r31 = WatermarkPerfLogger.a;
        DownloadWatermarkService.a.getClass();
        if (DownloadWatermarkService.d() == false) goto L37;
        WatermarkPerfLogger.Version r32 = WatermarkPerfLogger.Version.ENTERPRISE;
    L38:
        r111 = WatermarkPerfLogger.a("image_save_origin", r32, DownloadWatermarkScene.CI_GEN_IMAGE_DOWNLOAD);
        WatermarkPerfLogger.Path.a r33 = WatermarkPerfLogger.Path.Companion;
        String r112 = this.$url;
        r33.getClass();
        r111.c(WatermarkPerfLogger.Path.a.a(r112));
        Function1<Continuation<? super Unit>, Object> r34 = this.$checkBlock;     // Catch: Throwable -> L32
        if (r34 == null) goto L112;
        this.L$0 = r111;     // Catch: Throwable -> L32
        this.label = 1;     // Catch: Throwable -> L32
        if (r34.invoke(this) != r4) goto L112;
        return r4;
    L37:
        r32 = WatermarkPerfLogger.Version.PERSONAL;
    L22:
        th = th;
        r7 = r2;
    L97:
        th = th;
        r7 = r111;
    L32:
        th = move-exception;
        FLogger.a.i("ImageSave", "checkBlock invoke error: " + th);     // Catch: Throwable -> L97
        goto L45
    }
}
