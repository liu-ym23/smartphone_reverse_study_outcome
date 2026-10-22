package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTitleComponent$onViewCreated$3", f = "CaptureTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTitleComponent$onViewCreated$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ CaptureTitleComponent this$0;

    public CaptureTitleComponent$onViewCreated$3(CaptureTitleComponent r1, CameraCaptureViewModel r2, Continuation<? super CaptureTitleComponent$onViewCreated$3> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CaptureTitleComponent$onViewCreated$3 r0 = new CaptureTitleComponent$onViewCreated$3(this.this$0, this.$viewModel, r5);
        r0.Z$0 = ((Boolean) r4).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        boolean r4 = this.Z$0;
        CaptureTitleComponent r0 = this.this$0;
        CameraCaptureViewModel r1 = this.$viewModel;
        r0.getClass();
        if (r4 == false) goto L7;
        r0.p(new h2(r1));
    L9:
        return Unit.INSTANCE;
    L7:
        r0.p(new i2(r1));
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
