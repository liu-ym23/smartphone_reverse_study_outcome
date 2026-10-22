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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$showPreprocessedUploadingPreview$2", f = "ImageSelectorComponent.kt", i = {}, l = {1873}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$showPreprocessedUploadingPreview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onPreviewStateReady;
    final /* synthetic */ String $preprocessedLocalPath;
    final /* synthetic */ String $sourceLocalPath;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$showPreprocessedUploadingPreview$2(ImageSelectorComponent r1, String r2, String r3, Function0<Unit> r4, Continuation<? super ImageSelectorComponent$showPreprocessedUploadingPreview$2> r5) {
        this.this$0 = r1;
        this.$sourceLocalPath = r2;
        this.$preprocessedLocalPath = r3;
        this.$onPreviewStateReady = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageSelectorComponent$showPreprocessedUploadingPreview$2(this.this$0, this.$sourceLocalPath, this.$preprocessedLocalPath, this.$onPreviewStateReady, r8);
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
    L18:
        Bitmap r8 = (Bitmap) r7;
        if (r8 == null) goto L26;
        if (Intrinsics.areEqual(this.this$0.C, this.$sourceLocalPath) == false) goto L26;
        if ((this.this$0.X3().getCurState().getValue() instanceof sy9.b.e) == false) goto L26;
        ImageSelectorUploadPreviewHelper r2 = this.this$0.h4();
        int r3 = ImageSelectorUploadPreviewHelper.d;
        r2.d(r8, null);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        if (Intrinsics.areEqual(this.this$0.C, this.$sourceLocalPath) == false) goto L11;
        ImageSelectorComponent r9 = this.this$0;
        r9.D = this.$preprocessedLocalPath;
        r9.m.setValue(ry9.j.h.b);
        if ((this.this$0.X3().getCurState().getValue() instanceof sy9.b.e) == true) goto L15;
        ImageSelectorUploadPreviewHelper r10 = this.this$0.h4();
        int r4 = ImageSelectorUploadPreviewHelper.d;
        r10.d(null, null);
    L15:
        this.$onPreviewStateReady.invoke();
        CoroutineDispatcher r11 = Dispatchers.getIO();
        ImageSelectorComponent$showPreprocessedUploadingPreview$2$bitmap$1 r5 = new ImageSelectorComponent$showPreprocessedUploadingPreview$2$bitmap$1(this.this$0, this.$preprocessedLocalPath, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r11, r5, this);
        if (r7 != r0) goto L18;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
