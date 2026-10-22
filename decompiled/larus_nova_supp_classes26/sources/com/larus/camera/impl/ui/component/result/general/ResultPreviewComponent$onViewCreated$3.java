package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$3", f = "ResultPreviewComponent.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$onViewCreated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $rawImageUri;
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;

    public ResultPreviewComponent$onViewCreated$3(String r1, CameraResultViewModel r2, Continuation<? super ResultPreviewComponent$onViewCreated$3> r3) {
        this.$rawImageUri = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResultPreviewComponent$onViewCreated$3(this.$rawImageUri, this.$viewModel, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Bitmap r7 = (Bitmap) r6;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[onViewCreated] load rawBitmap done: ");
        if (r7 != null) goto L15;
        r2 = false;
    L15:
        r4.append(r2);
        r4.append(", uri=");
        r4.append(this.$rawImageUri);
        r3.i("ResultPreviewComponent", r4.toString());
        if (r7 == null) goto L18;
        this.$viewModel.setRawBaseBitmap(r7);
    L18:
        this.$viewModel.setRawImageLoading(false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        ResultPreviewComponent$onViewCreated$3$rawBitmap$1 r5 = new ResultPreviewComponent$onViewCreated$3$rawBitmap$1(this.$rawImageUri, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r8, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
