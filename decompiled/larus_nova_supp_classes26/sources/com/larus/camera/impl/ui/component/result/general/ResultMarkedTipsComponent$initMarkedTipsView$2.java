package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultMarkedTipsComponent$initMarkedTipsView$2", f = "ResultMarkedTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultMarkedTipsComponent$initMarkedTipsView$2 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ p this$0;

    public ResultMarkedTipsComponent$initMarkedTipsView$2(CameraResultViewModel r1, p r2, Continuation<? super ResultMarkedTipsComponent$initMarkedTipsView$2> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultMarkedTipsComponent$initMarkedTipsView$2 r0 = new ResultMarkedTipsComponent$initMarkedTipsView$2(this.$viewModel, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Pair) r1, (Continuation) r2);
    }

    public final Object invoke(Pair<Boolean, Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        Pair r6 = (Pair) this.L$0;
        boolean r0 = ((Boolean) r6.component1()).booleanValue();
        boolean r7 = ((Boolean) r6.component2()).booleanValue();
        FLogger.a.i("ResultMarkedTipsComponent", "initMarkedTipsView inMarkSelectMode=" + r0 + " inCropMode=" + r7);
        if (r0 == false) goto L10;
        if (r7 == true) goto L10;
        if (this.$viewModel.currentPreviewShouldHideEditControls() == true) goto L10;
        p r8 = this.this$0;
        int r1 = p.o;
        r8.q();
    L12:
        return Unit.INSTANCE;
    L10:
        p r9 = this.this$0;
        int r2 = p.o;
        com.larus.utils.e1.o(r9.p());
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
