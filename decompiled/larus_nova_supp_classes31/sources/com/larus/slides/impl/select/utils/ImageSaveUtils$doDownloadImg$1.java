package com.larus.slides.impl.select.utils;

import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.select.utils.ImageSaveUtils$doDownloadImg$1", f = "GenerateImageSaveUtils.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSaveUtils$doDownloadImg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<a, Unit> $callback;
    final /* synthetic */ String $imgUrl;
    final /* synthetic */ String $targetSaveDir;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSaveUtils$doDownloadImg$1(String r1, String r2, Function1<? super a, Unit> r3, Continuation<? super ImageSaveUtils$doDownloadImg$1> r4) {
        this.$imgUrl = r1;
        this.$targetSaveDir = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSaveUtils$doDownloadImg$1(this.$imgUrl, this.$targetSaveDir, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L17:
        ((Boolean) r7).booleanValue();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Lazy r8 = ImageSaveUtils.a;
        String r9 = this.$imgUrl;
        final String r2 = this.$targetSaveDir;
        final Function1<a, Unit> r3 = this.$callback;
        this.label = 1;
        if (r9.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        FLogger.a.w("ImageSaveUtils", "url is null");
        r7 = Boxing.boxBoolean(false);
    L15:
        if (r7 != r0) goto L17;
        return r0;
    L14:
        final CompletableDeferred r5 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ImageLoaderKt.l(r9, "image_save", new d(r5, r2, r3), new e(), 20);
        r7 = r5.await(this);
        goto L15
    L11:
        r4 = false;
        goto L12
    }
}
