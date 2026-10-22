package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.camera.impl.widget.SwipeVerticalRecyclerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "changeState", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTabComponent$onViewCreated$4", f = "CaptureTabComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTabComponent$onViewCreated$4 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CaptureTabComponent this$0;

    public CaptureTabComponent$onViewCreated$4(CaptureTabComponent r1, Continuation<? super CaptureTabComponent$onViewCreated$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureTabComponent$onViewCreated$4 r0 = new CaptureTabComponent$onViewCreated$4(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        if (r5 != ChangeState.HIDE.getState()) goto L8;
        com.larus.utils.e1.x(this.this$0.p());
        this.this$0.p().setForceInterceptFling(false);
        ((SwipeVerticalRecyclerView) this.this$0.n.getValue()).setOnSwipeListener((CaptureTabComponent.a) this.this$0.o.getValue());
    L14:
        return Unit.INSTANCE;
    L8:
        if (r5 != ChangeState.SHOW.getState()) goto L11;
        com.larus.utils.e1.o(this.this$0.p());
        this.this$0.p().setForceInterceptFling(true);
        ((SwipeVerticalRecyclerView) this.this$0.n.getValue()).setOnSwipeListener(null);
        goto L14
    L11:
        if (r5 != ChangeState.DEFAULT.getState()) goto L14;
        this.this$0.p().setForceInterceptFling(false);
        ((SwipeVerticalRecyclerView) this.this$0.n.getValue()).setOnSwipeListener(null);
        goto L14
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
