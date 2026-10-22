package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$startAlbumUploadingUiForPipeline$2", f = "ImageSelectorComponent.kt", i = {}, l = {1849}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$startAlbumUploadingUiForPipeline$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromInit;
    final /* synthetic */ Function0<Unit> $onPreviewStateReady;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$startAlbumUploadingUiForPipeline$2(ImageSelectorComponent r1, Uri r2, boolean r3, Function0<Unit> r4, Continuation<? super ImageSelectorComponent$startAlbumUploadingUiForPipeline$2> r5) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$fromInit = r3;
        this.$onPreviewStateReady = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageSelectorComponent$startAlbumUploadingUiForPipeline$2(this.this$0, this.$uri, this.$fromInit, this.$onPreviewStateReady, r8);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        if (Intrinsics.areEqual(r10, Boxing.boxBoolean(true)) == false) goto L15;
        this.$onPreviewStateReady.invoke();
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ImageSelectorComponent r5 = this.this$0;
        Uri r4 = this.$uri;
        boolean r6 = this.$fromInit;
        this.label = 1;
        Lazy<Long> r11 = ImageSelectorComponent.X;
        r5.getClass();
        r10 = BuildersKt.withContext(Dispatchers.getIO(), new ImageSelectorComponent$preShowUploadingUri$2(r4, r5, r6, false, null), this);
        if (r10 != r0) goto L12;
        return r0;
    }
}
