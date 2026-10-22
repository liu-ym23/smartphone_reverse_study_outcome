package com.larus.bmhome.chat.model;

import android.graphics.Bitmap;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.MessageShareViewModel$doShareMessageWithPic$1$2$1", f = "MessageShareViewModel.kt", i = {0, 0}, l = {338}, m = "invokeSuspend", n = {"$this$launch", "perf"}, s = {"L$0", "L$1"})
public final class MessageShareViewModel$doShareMessageWithPic$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Integer, Bitmap, Unit> $callback;
    final /* synthetic */ int $code;
    final /* synthetic */ Bitmap $sharePic;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageShareViewModel$doShareMessageWithPic$1$2$1(Function2<? super Integer, ? super Bitmap, Unit> r1, int r2, Bitmap r3, Continuation<? super MessageShareViewModel$doShareMessageWithPic$1$2$1> r4) {
        this.$callback = r1;
        this.$code = r2;
        this.$sharePic = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MessageShareViewModel$doShareMessageWithPic$1$2$1 r0 = new MessageShareViewModel$doShareMessageWithPic$1$2$1(this.$callback, this.$code, this.$sharePic, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        String r3 = null;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        Bitmap r4 = (Bitmap) this.L$2;
        WatermarkPerfLogger.a r5 = (WatermarkPerfLogger.a) this.L$1;
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
    L36:
        com.larus.platform.service.watermark.g.d r11 = (com.larus.platform.service.watermark.g) r10;     // Catch: Throwable -> L8
        if ((r11 instanceof com.larus.platform.service.watermark.g.d) == false) goto L47;
        com.larus.platform.service.watermark.c.a r12 = r11.a;     // Catch: Throwable -> L8
        if ((r12 instanceof com.larus.platform.service.watermark.c.a) == false) goto L41;
        com.larus.platform.service.watermark.c.a r13 = r12;     // Catch: Throwable -> L8
    L42:
        if (r13 == null) goto L47;
        Bitmap r14 = r13.a;     // Catch: Throwable -> L8
        if (r14 == null) goto L47;
        r4 = r14;
        goto L47
    L41:
        r13 = null;
    L47:
        Object r15 = Result.constructor-impl(r4);     // Catch: Throwable -> L8
    L52:
        Bitmap r7 = this.$sharePic;
        if (Result.isFailure-impl(r15) == false) goto L55;
        r15 = r7;
    L55:
        Bitmap r16 = (Bitmap) r15;
        r5.a("applyWatermarkToLocalImage");
        Bitmap r8 = this.$sharePic;
        if (r16 != r8) goto L58;
    L64:
        Function2<Integer, Bitmap, Unit> r9 = this.$callback;
        if (r9 == null) goto L68;
        r9.invoke(Boxing.boxInt(this.$code), r16);
    L68:
        if (r16 != this.$sharePic) goto L71;
        r2 = false;
    L71:
        if (r2 == false) goto L73;
        WatermarkPerfLogger.Result r17 = WatermarkPerfLogger.Result.SUCCESS;
    L74:
        if (r2 == true) goto L76;
        r3 = "fallback_to_origin";
    L76:
        r5.b(r17, r3);
        return Unit.INSTANCE;
    L73:
        r17 = WatermarkPerfLogger.Result.FAIL;
        goto L74
    L58:
        if (r8.isRecycled() == true) goto L64;
        this.$sharePic.recycle();     // Catch: Throwable -> L62
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = th;
        WatermarkPerfLogger.a r19 = r5;
    L51:
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        r5 = r19;
        goto L52
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        DownloadWatermarkService r21 = DownloadWatermarkService.a;
        r21.getClass();
        if (DownloadWatermarkService.d() == true) goto L16;
        r21 = null;
    L16:
        int r22 = WatermarkPerfLogger.a;
        if (r21 != null) goto L19;
        WatermarkPerfLogger.Version r23 = WatermarkPerfLogger.Version.PERSONAL;
    L20:
        DownloadWatermarkScene r24 = DownloadWatermarkScene.MESSAGE_LONG_IMAGE;
        r19 = WatermarkPerfLogger.a("message_long_image", r23, r24);
        if (r21 != null) goto L23;
        WatermarkPerfLogger.Path r25 = WatermarkPerfLogger.Path.NONE;
    L24:
        r19.c(r25);
        if (r21 != null) goto L31;
        Function2<Integer, Bitmap, Unit> r111 = this.$callback;
        if (r111 == null) goto L29;
        r111.invoke(Boxing.boxInt(this.$code), this.$sharePic);
    L29:
        r19.b(WatermarkPerfLogger.Result.SUCCESS, null);
        return Unit.INSTANCE;
    L31:
        LocalImageWatermarkRequest r26 = new LocalImageWatermarkRequest(new com.larus.platform.service.watermark.b.a(this.$sharePic), LocalImageWatermarkRequest.OutputPreference.AS_BITMAP, r24);
        Bitmap r27 = this.$sharePic;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L50
        this.L$0 = r110;     // Catch: Throwable -> L50
        this.L$1 = r19;     // Catch: Throwable -> L50
        this.L$2 = r27;     // Catch: Throwable -> L50
        this.label = 1;     // Catch: Throwable -> L50
        r10 = r21.b(r26, this);     // Catch: Throwable -> L50
        if (r10 != r0) goto L35;
        return r0;
    L35:
        r5 = r19;
        r4 = r27;
    L50:
        th = th;
        goto L51
    L23:
        r25 = WatermarkPerfLogger.Path.B_LOCAL;
        goto L24
    L19:
        r23 = WatermarkPerfLogger.Version.ENTERPRISE;
        goto L20
    }
}
