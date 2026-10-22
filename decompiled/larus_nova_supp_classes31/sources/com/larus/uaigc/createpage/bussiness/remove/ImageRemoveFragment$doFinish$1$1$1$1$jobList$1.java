package com.larus.uaigc.createpage.bussiness.remove;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doFinish$1$1$1$1$jobList$1", f = "ImageRemoveFragment.kt", i = {0}, l = {630}, m = "invokeSuspend", n = {"sendImgPath"}, s = {"L$0"})
public final class ImageRemoveFragment$doFinish$1$1$1$1$jobList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $pathBitmap;
    final /* synthetic */ ImageEditDataWithMask $resultData;
    final /* synthetic */ Bitmap $viewBitmap;
    Object L$0;
    int label;

    public ImageRemoveFragment$doFinish$1$1$1$1$jobList$1(Bitmap r1, ImageEditDataWithMask r2, Bitmap r3, Continuation<? super ImageRemoveFragment$doFinish$1$1$1$1$jobList$1> r4) {
        this.$pathBitmap = r1;
        this.$resultData = r2;
        this.$viewBitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageRemoveFragment$doFinish$1$1$1$1$jobList$1(this.$pathBitmap, this.$resultData, this.$viewBitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
    L26:
        if (((Boolean) r12).booleanValue() == false) goto L28;
        this.$resultData.setSendMsgImgStoragePath(r2);
    L30:
        return Unit.INSTANCE;
    L28:
        FLogger.a.d("ImageRemoveFragment", "save send image failed");
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Bitmap r13 = this.$pathBitmap;
        Bitmap r3 = this.$viewBitmap;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r13, "other");
        long r4 = System.currentTimeMillis();
        Object r6 = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        Bitmap r8 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
        Canvas r9 = new Canvas(r8);     // Catch: Throwable -> L11
        r9.drawBitmap(r3, 0.0f, 0.0f, null);     // Catch: Throwable -> L11
        r9.drawBitmap(r13, 0.0f, 0.0f, null);     // Catch: Throwable -> L11
        FLogger.a.d("BitmapHelper", "concat bitmap cost " + (System.currentTimeMillis() - r4) + "ms");     // Catch: Throwable -> L11
        Object r14 = Result.constructor-impl(r8);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r14) == true) goto L17;
        r6 = r14;
    L17:
        Bitmap r10 = (Bitmap) r6;
        if (r10 == null) goto L20;
        String r15 = IAIChatUploadMediaService.a.a("jpeg", false);
        this.L$0 = r15;
        this.label = 1;
        Object r5 = BitmapHelperKt.e(r10, r15, 85, this);
        if (r5 != r0) goto L24;
        return r0;
    L24:
        r2 = r15;
        r12 = r5;
        goto L26
    L20:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
