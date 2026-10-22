package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "mode", "Lcom/larus/camera/impl/entity/EduResultMode;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$onViewCreated$5", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTabControlComponent$onViewCreated$5 extends SuspendLambda implements Function2<EduResultMode, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTabControlComponent this$0;

    public ResultTabControlComponent$onViewCreated$5(ResultTabControlComponent r1, Continuation<? super ResultTabControlComponent$onViewCreated$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultTabControlComponent$onViewCreated$5 r0 = new ResultTabControlComponent$onViewCreated$5(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(EduResultMode r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((EduResultMode) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r4);
        EduResultMode r5 = (EduResultMode) this.L$0;
        FLogger.a.i("ResultTabControlComponent", "[refreshActionEntrance] edu result mode changed:" + r5);
        ResultInputControlBinder r6 = this.this$0.o;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r6 = null;
    L7:
        op8.i r7 = (op8.i) r6.h.getValue();
        if (r7 == null) goto L11;
        r7.o8();
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
