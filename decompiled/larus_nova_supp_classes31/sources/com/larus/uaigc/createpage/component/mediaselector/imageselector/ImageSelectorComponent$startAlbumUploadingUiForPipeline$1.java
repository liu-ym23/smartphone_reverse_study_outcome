package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$startAlbumUploadingUiForPipeline$1", f = "ImageSelectorComponent.kt", i = {}, l = {1840}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$startAlbumUploadingUiForPipeline$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$startAlbumUploadingUiForPipeline$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$startAlbumUploadingUiForPipeline$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageSelectorComponent$startAlbumUploadingUiForPipeline$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        if (com.larus.utils.o0.d(this.this$0.T) == false) goto L16;
        ICoreInputAbility r2 = (ICoreInputAbility) this.this$0.w.getValue();
        if (r2 == null) goto L16;
        ICoreInputAbility.b.d(r2, String.valueOf(this.this$0.T), false, false, null, null, false, 62);
    L16:
        ImageSelectorComponent r10 = this.this$0;
        r10.T = null;
        py9.a r11 = r10.Q3();
        if (r11 == null) goto L20;
        r11.Bl("onAlbumSelected");
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L12;
        return r0;
    }
}
