package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.camera.impl.widget.TabPickerView;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTabComponent$onViewCreated$3", f = "CaptureTabComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTabComponent$onViewCreated$3 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureTabComponent this$0;

    public CaptureTabComponent$onViewCreated$3(CameraCaptureViewModel r1, CaptureTabComponent r2, Continuation<? super CaptureTabComponent$onViewCreated$3> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CaptureTabComponent$onViewCreated$3 r0 = new CaptureTabComponent$onViewCreated$3(this.$viewModel, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Pair) r1, (Continuation) r2);
    }

    public final Object invoke(Pair<Integer, Integer> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r3);
        Pair r4 = (Pair) this.L$0;
        if (this.$viewModel.getCameraData().getCaptureModeList().isEmpty() == false) goto L9;
        return Unit.INSTANCE;
    L9:
        if (((Number) this.$viewModel.getAlbumThumbListStateChanged().getValue()).intValue() == ChangeState.SHOW.getState()) goto L11;
        int r0 = ((Number) r4.component1()).intValue();
        ((Number) r4.component2()).intValue();
        ((TabPickerView) this.this$0.h(2131388044)).e(-r0);
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
