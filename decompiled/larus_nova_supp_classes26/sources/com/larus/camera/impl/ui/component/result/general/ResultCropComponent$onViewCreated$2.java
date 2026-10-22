package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import com.larus.bmhome.view.crop.ImageCropView;
import com.larus.camera.impl.databinding.LarusLayoutViewCropComponentBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultCropComponent$onViewCreated$2", f = "ResultCropComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultCropComponent$onViewCreated$2 extends SuspendLambda implements Function2<Bitmap, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultCropComponent this$0;

    public ResultCropComponent$onViewCreated$2(ResultCropComponent r1, Continuation<? super ResultCropComponent$onViewCreated$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultCropComponent$onViewCreated$2 r0 = new ResultCropComponent$onViewCreated$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Bitmap r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Bitmap) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        Bitmap r3 = (Bitmap) this.L$0;
        if (r3 == null) goto L12;
        LarusLayoutViewCropComponentBinding r0 = this.this$0.m;
        if (r0 == null) goto L12;
        ImageCropView r1 = r0.c;
        if (r1 == null) goto L12;
        r1.setImageBitmap(r3);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
