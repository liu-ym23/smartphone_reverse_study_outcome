package com.larus.bmhome.bigimg;

import android.graphics.Bitmap;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$saveOriginImageForShare$1", f = "ImageSave.kt", i = {}, l = {317, 321}, m = "invokeSuspend", n = {}, s = {})
final class ImageSave$saveOriginImageForShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ Map<String, String> $exifMap;
    final /* synthetic */ boolean $isAIGC;
    final /* synthetic */ Function1<Continuation<? super String>, Object> $onInterceptUrl;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSave$saveOriginImageForShare$1(String r1, Function1<? super String, Unit> r2, Map<String, String> r3, boolean r4, Bitmap r5, Function1<? super Continuation<? super String>, ? extends Object> r6, Continuation<? super ImageSave$saveOriginImageForShare$1> r7) {
        this.$url = r1;
        this.$callback = r2;
        this.$exifMap = r3;
        this.$isAIGC = r4;
        this.$bitmap = r5;
        this.$onInterceptUrl = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ImageSave$saveOriginImageForShare$1(this.$url, this.$callback, this.$exifMap, this.$isAIGC, this.$bitmap, this.$onInterceptUrl, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r5 = null;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L55:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L11
    L21:
        String r14 = (String) r13;     // Catch: Throwable -> L11
    L23:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L11
    L26:
        Throwable r2 = Result.exceptionOrNull-impl(r15);
        if (r2 == null) goto L30;
        FLogger.a.e("ImageSave", "saveOriginImageForShare onInterceptUrl execute failed, " + r2);
    L30:
        if (Result.isFailure-impl(r15) == true) goto L33;
        r5 = r15;
    L33:
        String r6 = (String) r5;
        if (r6 != null) goto L36;
        r6 = this.$url;
    L36:
        ImageSave r7 = ImageSave.a;
        Function1<String, Unit> r8 = this.$callback;
        Map<String, String> r9 = this.$exifMap;
        boolean r10 = this.$isAIGC;
        this.label = 2;
        if (ImageSave.c(r7, r6, r8, r9, r10, this) != r0) goto L55;
        return r0;
    L13:
        ResultKt.throwOnFailure(r13);
        if (com.larus.utils.o0.d(this.$url) == false) goto L39;
        Function1<Continuation<? super String>, Object> r16 = this.$onInterceptUrl;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        if (r16 == null) goto L22;
        this.label = 1;     // Catch: Throwable -> L11
        r13 = r16.invoke(this);     // Catch: Throwable -> L11
        if (r13 != r0) goto L21;
        return r0;
    L22:
        r14 = null;
        goto L23
    L39:
        Bitmap r17 = this.$bitmap;
        if (r17 != null) goto L42;
    L53:
        this.$callback.invoke(null);
        goto L55
    L42:
        if (r17.isRecycled() == true) goto L53;
        ImageSave r18 = ImageSave.a;
        Bitmap r4 = this.$bitmap;
        Map<String, String> r11 = this.$exifMap;
        boolean r12 = this.$isAIGC;
        Function1<String, Unit> r19 = this.$callback;
        r18.getClass();
        if (r4 != null) goto L46;
        r19.invoke(null);
        goto L55
    L46:
        String r110 = "share_" + System.currentTimeMillis() + ".jpeg";
        String r20 = i1.b();
        if (i1.e(r4, r20, r110) == false) goto L52;
        String r111 = r20 + File.separator + r110;
        yq8.a.a(r111, r11, "jpeg");
        if (r12 == false) goto L51;
        com.larus.platform.service.e.a(r111);
    L51:
        r19.invoke(r111);
        goto L55
    L52:
        r19.invoke(null);
        FLogger.a.w("ImageSave", "save failed");
    L11:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
