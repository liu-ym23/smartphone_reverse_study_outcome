package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1", f = "ImageSelectorComponent.kt", i = {}, l = {778}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1(ImageSelectorComponent r1, Bitmap r2, Continuation<? super ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1> r3) {
        this.this$0 = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1(this.this$0, this.$bitmap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Context r5 = this.this$0.getContext();
        Bitmap r2 = this.$bitmap;
        this.label = 1;
        r4 = BitmapHelperKt.d(r5, r2, "image_selector_default_image.jpeg", this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
