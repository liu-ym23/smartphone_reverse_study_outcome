package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.runtime.MutableState;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.universe_design.dialog.compose.UDListPanelDialogKt$ListPanelContent$1$2$1", f = "UDListPanelDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UDListPanelDialogKt$ListPanelContent$1$2$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Float> $accumulatedDrag$delegate;
    final /* synthetic */ float $hideThresholdPx;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    int label;

    public UDListPanelDialogKt$ListPanelContent$1$2$1(float r1, Function0<Unit> r2, MutableState<Float> r3, Continuation<? super UDListPanelDialogKt$ListPanelContent$1$2$1> r4) {
        this.$hideThresholdPx = r1;
        this.$onDismissRequest = r2;
        this.$accumulatedDrag$delegate = r3;
        super(3, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((CoroutineScope) r1, ((Number) r2).floatValue(), (Continuation) r3);
    }

    public final Object invoke(CoroutineScope r3, float r4, Continuation<? super Unit> r5) {
        return new UDListPanelDialogKt$ListPanelContent$1$2$1(this.$hideThresholdPx, this.$onDismissRequest, this.$accumulatedDrag$delegate, r5).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if (((Number) this.$accumulatedDrag$delegate.getValue()).floatValue() < this.$hideThresholdPx) goto L7;
        this.$onDismissRequest.invoke();
    L7:
        this.$accumulatedDrag$delegate.setValue(Float.valueOf(0.0f));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
