package com.larus.bmhome.video.download;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import nr9.g;
import tx9.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1", f = "VideoDownloadLoadingMgr.kt", i = {1, 2, 2}, l = {241, 267, 274}, m = "invokeSuspend", n = {"originalDownloadUrl", "saveVideoPlayData", "startTimeStamp"}, s = {"L$0", "L$0", "J$0"})
final class VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function4<Integer, String, Long, Boolean, Unit> $dismissLoadingCallback;
    final /* synthetic */ String $downloadTaskKey;
    final /* synthetic */ boolean $isAIGC;
    final /* synthetic */ Map<String, String> $metaDataMap;
    final /* synthetic */ Function1<Continuation<? super String>, Object> $onInterceptUrl;
    final /* synthetic */ WatermarkPerfLogger.a $perf;
    final /* synthetic */ String $resultPath;
    final /* synthetic */ Function0<Unit> $saveCreationTaskIdBlk;
    final /* synthetic */ g $videoPlayData;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1$1", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ Function0<Unit> $saveCreationTaskIdBlk;
        int label;
        final /* synthetic */ VideoDownloadLoadingMgr this$0;

        public AnonymousClass1(Function0<Unit> r1, VideoDownloadLoadingMgr r2, Continuation<? super AnonymousClass1> r3) {
            this.$saveCreationTaskIdBlk = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$saveCreationTaskIdBlk, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L19;
            ResultKt.throwOnFailure(r6);
            Function0<Unit> r7 = this.$saveCreationTaskIdBlk;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
            if (r7 == null) goto L8;
            r7.invoke();     // Catch: Throwable -> L11
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L11
        L13:
            VideoDownloadLoadingMgr r1 = this.this$0;
            Throwable r2 = Result.exceptionOrNull-impl(r9);
            if (r2 == null) goto L17;
            FLogger.a.i(r1.b, "aveCreationTaskIdBlk execute failed: " + r2);
        L17:
            return Result.box-impl(r9);
        L8:
            r8 = null;
        L11:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1(VideoDownloadLoadingMgr r1, String r2, g r3, WatermarkPerfLogger.a r4, Context r5, String r6, Map<String, String> r7, boolean r8, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r9, Function0<Unit> r10, Function1<? super Continuation<? super String>, ? extends Object> r11, Continuation<? super VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1> r12) {
        this.this$0 = r1;
        this.$resultPath = r2;
        this.$videoPlayData = r3;
        this.$perf = r4;
        this.$context = r5;
        this.$downloadTaskKey = r6;
        this.$metaDataMap = r7;
        this.$isAIGC = r8;
        this.$dismissLoadingCallback = r9;
        this.$saveCreationTaskIdBlk = r10;
        this.$onInterceptUrl = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1(this.this$0, this.$resultPath, this.$videoPlayData, this.$perf, this.$context, this.$downloadTaskKey, this.$metaDataMap, this.$isAIGC, this.$dismissLoadingCallback, this.$saveCreationTaskIdBlk, this.$onInterceptUrl, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        int r13 = 1;
        String r14 = null;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        long r1 = this.J$0;
        g r2 = (g) this.L$0;
        ResultKt.throwOnFailure(r25);
        long r16 = r1;
        Object r3 = r25;
    L54:
        nr9.e r4 = (nr9.e) r3;
        long r5 = SystemClock.elapsedRealtime() - r16;
        WatermarkPerfLogger.a r6 = this.$perf;
        if (r6 == null) goto L57;
        r6.a("saveVideo");
    L57:
        WatermarkPerfLogger.a r7 = this.$perf;
        if (r7 == null) goto L73;
        int r8 = r4.a;
        this.this$0.getClass();
        if (r8 != 0) goto L62;
        WatermarkPerfLogger.Result r9 = WatermarkPerfLogger.Result.SUCCESS;
    L63:
        Integer r10 = Boxing.boxInt(r4.a);
        VideoDownloadLoadingMgr r11 = this.this$0;
        int r15 = r10.intValue();
        r11.getClass();
        if (r15 == 0) goto L66;
        boolean r17 = true;
    L67:
        if (r17 == true) goto L70;
        r10 = null;
    L70:
        if (r10 == null) goto L72;
        r14 = "code_" + r10.intValue();
    L72:
        r7.b(r9, r14);
        goto L73
    L66:
        r17 = false;
        goto L67
    L62:
        r9 = WatermarkPerfLogger.Result.FAIL;
    L73:
        Function4<Integer, String, Long, Boolean, Unit> r18 = this.$dismissLoadingCallback;
        if (r18 == null) goto L76;
        r18.invoke(Boxing.boxInt(r4.a), r4.b, Boxing.boxLong(r5), r4.c);
    L76:
        this.this$0.l.invoke(r2);
        int r19 = r4.a;
        this.this$0.getClass();
        if (r19 == 0) goto L80;
        r13 = 0;
    L80:
        a2.b(r13, r5, "video");
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r20 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L13
        Object r21 = r25;
    L30:
        String r22 = (String) r21;     // Catch: Throwable -> L13
    L32:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L13
        String r24 = r20;
    L37:
        VideoDownloadLoadingMgr r26 = this.this$0;
        Throwable r27 = Result.exceptionOrNull-impl(r23);
        if (r27 == null) goto L41;
        FLogger.a.e(r26.b, "onInterceptUrl execute failed, " + r27);
    L41:
        if (Result.isFailure-impl(r23) == false) goto L43;
        r23 = null;
    L43:
        String r28 = (String) r23;
        if (r28 != null) goto L46;
        String r110 = r24;
    L47:
        WatermarkPerfLogger.a r29 = this.$perf;
        if (r29 == null) goto L50;
        r29.a("watermark");
    L50:
        g r30 = g.a(this.$videoPlayData, null, null, r110, null, null, null, null, 1019);
        long r31 = SystemClock.elapsedRealtime();
        VideoDownloadLoadingMgr r32 = this.this$0;
        Context r33 = this.$context;
        String r34 = this.$downloadTaskKey;
        String r35 = this.$resultPath;
        Map<String, String> r36 = this.$metaDataMap;
        String r37 = this.$videoPlayData.d;
        boolean r111 = this.$isAIGC;
        this.L$0 = r30;
        this.J$0 = r31;
        this.label = 3;
        r16 = r31;
        r3 = VideoDownloadLoadingMgr.e(r32, r33, r34, r30, r35, r36, r37, r24, r111, this);
        if (r3 != r12) goto L53;
        return r12;
    L53:
        r2 = r30;
        goto L54
    L46:
        r110 = r28;
    L13:
        th = th;
        String r38 = r20;
    L36:
        Result.Companion r39 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        r24 = r38;
        goto L37
    L15:
        ResultKt.throwOnFailure(r25);
    L23:
        r38 = this.$videoPlayData.c;
        Function1<Continuation<? super String>, Object> r40 = this.$onInterceptUrl;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L35
        if (r40 == null) goto L31;
        this.L$0 = r38;     // Catch: Throwable -> L35
        this.label = 2;     // Catch: Throwable -> L35
        r21 = r40.invoke(this);     // Catch: Throwable -> L35
        if (r21 != r12) goto L29;
        return r12;
    L29:
        r20 = r38;
        goto L30
    L31:
        r20 = r38;
        r22 = null;
    L35:
        th = th;
        goto L36
    L16:
        ResultKt.throwOnFailure(r25);
        VideoDownloadLoadingMgr r42 = this.this$0;
        final String r43 = this.$resultPath;
        r42.getClass();
        if (Build.VERSION.SDK_INT < 29) goto L20;
        l0.b(new a(r43));
    L20:
        CoroutineDispatcher r44 = Dispatchers.getIO();
        AnonymousClass1 r45 = new AnonymousClass1(this.$saveCreationTaskIdBlk, this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r44, r45, this) != r12) goto L23;
        return r12;
    }
}
