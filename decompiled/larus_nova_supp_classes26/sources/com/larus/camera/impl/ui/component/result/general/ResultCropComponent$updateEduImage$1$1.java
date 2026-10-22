package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.widget.EduCaptureTipView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultCropComponent$updateEduImage$1$1", f = "ResultCropComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultCropComponent$updateEduImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ nx8.m $this_apply;
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ ResultCropComponent this$0;

    public ResultCropComponent$updateEduImage$1$1(CameraResultViewModel r1, ResultCropComponent r2, nx8.m r3, Bitmap r4, Continuation<? super ResultCropComponent$updateEduImage$1$1> r5) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$this_apply = r3;
        this.$bitmap = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ResultCropComponent$updateEduImage$1$1(this.$viewModel, this.this$0, this.$this_apply, this.$bitmap, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r7);
        String r8 = this.$viewModel.getParamAlbumUrl();
        int r0 = this.$viewModel.getParamOrientation();
        int r1 = com.larus.camera.impl.utils.c0.d;
        int r2 = (int) com.larus.camera.impl.utils.c0.a.a(r0, true);
        int r3 = EduCaptureTipView.l;
        Pair r4 = EduCaptureTipView.a.a(this.this$0.getContext(), r2);
        int r5 = ((Number) r4.component1()).intValue();
        int r6 = ((Number) r4.component2()).intValue();
        if (r8.length() <= 0) goto L7;
        boolean r9 = true;
    L8:
        String r10 = null;
        if (r9 == true) goto L12;
        r8 = null;
    L12:
        if (r8 != null) goto L16;
        OutputParam r11 = this.$viewModel.getCurrentDisplayOutputParam();
        if (r11 == null) goto L17;
        r8 = r11.getPath();
    L17:
        if (r10 == null) goto L20;
        nx8.m r12 = this.$this_apply;
        Bitmap r13 = this.$bitmap;
        r12.f(r5, r6);
        r12.o(r13, r10, r2, true);
    L20:
        return Unit.INSTANCE;
    L16:
        r10 = r8;
        goto L17
    L7:
        r9 = false;
        goto L8
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
