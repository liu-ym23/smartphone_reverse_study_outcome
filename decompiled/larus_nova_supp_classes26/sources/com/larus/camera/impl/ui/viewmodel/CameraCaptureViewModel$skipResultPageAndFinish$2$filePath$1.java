package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;
    final /* synthetic */ CameraCaptureViewModel this$0;

    public CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1(CameraCaptureViewModel r1, Bitmap r2, Continuation<? super CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1> r3) {
        this.this$0 = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1(this.this$0, this.$bitmap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        return CameraCaptureViewModel.access$ability(this.this$0).k(this.$bitmap, 0, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
