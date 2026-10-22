package com.larus.camera.impl.ui.component.generalonly;

import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.utils.e1;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.CaptureCameraTipsComponent$setupTipsSwitcher$1", f = "CaptureCameraTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CaptureCameraTipsComponent$setupTipsSwitcher$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ q this$0;

    public CaptureCameraTipsComponent$setupTipsSwitcher$1(q r1, Continuation<? super CaptureCameraTipsComponent$setupTipsSwitcher$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureCameraTipsComponent$setupTipsSwitcher$1 r0 = new CaptureCameraTipsComponent$setupTipsSwitcher$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        int r3 = this.I$0;
        if (r3 != ChangeState.HIDE.getState()) goto L8;
        q r4 = this.this$0;
        int r0 = q.t;
        e1.x(r4.q());
    L12:
        return Unit.INSTANCE;
    L8:
        if (r3 != ChangeState.SHOW.getState()) goto L10;
        q r5 = this.this$0;
        int r1 = q.t;
        e1.o(r5.q());
        goto L12
    L10:
        ChangeState.DEFAULT.getState();
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
