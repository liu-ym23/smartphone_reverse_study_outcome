package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$refreshUploadFailedState$2", f = "ImageSelectorComponent.kt", i = {}, l = {1957}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSelectorComponent$refreshUploadFailedState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cachedPathSnapshot;
    final /* synthetic */ String $previewSource;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$refreshUploadFailedState$2(ImageSelectorComponent r1, String r2, String r3, Continuation<? super ImageSelectorComponent$refreshUploadFailedState$2> r4) {
        this.this$0 = r1;
        this.$cachedPathSnapshot = r2;
        this.$previewSource = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSelectorComponent$refreshUploadFailedState$2(this.this$0, this.$cachedPathSnapshot, this.$previewSource, r5);
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
    L11:
        Bitmap r8 = (Bitmap) r7;
        if (Intrinsics.areEqual(this.this$0.C, this.$cachedPathSnapshot) == false) goto L19;
        if ((this.this$0.m.getValue() instanceof ry9.j.f) == false) goto L19;
        this.this$0.h4().c(r8);
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        ImageSelectorComponent$refreshUploadFailedState$2$bitmap$1 r2 = new ImageSelectorComponent$refreshUploadFailedState$2$bitmap$1(this.this$0, this.$previewSource, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r9, r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
