package com.larus.camera.impl.ui.component.result.general;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Lcom/larus/camera/impl/utils/eventbus/Event;", "it", "com/larus/camera/impl/utils/eventbus/CameraEventBus$subscribe$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$2", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$2 extends SuspendLambda implements Function2<com.larus.camera.impl.utils.eventbus.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$2(Continuation r1, ResultSuggestedActionComponent r2) {
        this.this$0 = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$2 r0 = new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$2(r4, this.this$0);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.camera.impl.utils.eventbus.d r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.camera.impl.utils.eventbus.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r13);
        com.larus.camera.impl.utils.eventbus.d r14 = (com.larus.camera.impl.utils.eventbus.d) ((com.larus.camera.impl.utils.eventbus.g) this.L$0);
        e2 r0 = r14.a;
        FLogger.a.i("ResultSuggestedActionComponent", "[subscribe] received " + r14);
        ResultSuggestedActionComponent r15 = this.this$0;
        int r1 = ResultSuggestedActionComponent.w;
        ConstraintLayout r16 = r15.j();
        if ((r16 instanceof ConstraintLayout) == false) goto L7;
        ConstraintLayout r17 = r16;
    L9:
        if (r17 != null) goto L11;
    L20:
        ResultSuggestedActionComponent r18 = this.this$0;
        r18.t = true;
        r18.w(false);
        return Unit.INSTANCE;
    L11:
        if ((r0 instanceof e2.a) == false) goto L14;
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(r17);
        r2.clear(2131387698, 3);
        r2.clear(2131387698, 4);
        r2.connect(2131387698, 4, 2131373056, 4, ((e2.a) r0).a);
        r2.applyTo(r17);
        goto L20
    L14:
        if (Intrinsics.areEqual(r0, e2.c.a) == true) goto L20;
        if ((r0 instanceof e2.b) == false) goto L19;
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r17);
        r3.clear(2131387698, 3);
        r3.clear(2131387698, 4);
        r3.connect(2131387698, 4, r17.getId(), 4, RangesKt.coerceAtLeast(((e2.b) r0).a - this.this$0.t().getPaddingBottom(), 0));
        r3.applyTo(r17);
        goto L20
    L19:
        throw new NoWhenBranchMatchedException();
    L7:
        r17 = null;
        goto L9
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
