package com.larus.canvas.feature.component.input;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasInputComponent$changeImeStatus$1", f = "CanvasInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CanvasInputComponent$changeImeStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $show;
    int label;
    final /* synthetic */ CanvasInputComponent this$0;

    public CanvasInputComponent$changeImeStatus$1(boolean r1, CanvasInputComponent r2, Continuation<? super CanvasInputComponent$changeImeStatus$1> r3) {
        this.$show = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CanvasInputComponent$changeImeStatus$1(this.$show, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        if (this.$show == false) goto L9;
        CanvasInputComponent r6 = this.this$0;
        int r1 = CanvasInputComponent.t;
        ICoreInputAbility r7 = r6.Y2();
        if (r7 == null) goto L13;
        ICoreInputAbility.b.e(r7, "canvasInput_changeImeStatus", null, false, 6);
    L13:
        return Unit.INSTANCE;
    L9:
        CanvasInputComponent r8 = this.this$0;
        int r2 = CanvasInputComponent.t;
        ICoreInputAbility r9 = r8.Y2();
        if (r9 == null) goto L13;
        r9.qp(false);
        Boxing.boxBoolean(true);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
