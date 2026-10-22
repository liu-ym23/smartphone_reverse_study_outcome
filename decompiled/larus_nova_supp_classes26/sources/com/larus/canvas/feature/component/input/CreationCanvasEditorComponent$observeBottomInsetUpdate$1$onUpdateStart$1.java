package com.larus.canvas.feature.component.input;

import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.feature.ability.UpdateProgress;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.input.CreationCanvasEditorComponent$observeBottomInsetUpdate$1$onUpdateStart$1", f = "CreationCanvasEditorComponent.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
public final class CreationCanvasEditorComponent$observeBottomInsetUpdate$1$onUpdateStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationCanvasEditorComponent this$0;

    public CreationCanvasEditorComponent$observeBottomInsetUpdate$1$onUpdateStart$1(CreationCanvasEditorComponent r1, Continuation<? super CreationCanvasEditorComponent$observeBottomInsetUpdate$1$onUpdateStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationCanvasEditorComponent$observeBottomInsetUpdate$1$onUpdateStart$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CreationCanvasEditorComponent r14 = this.this$0;
        MutableSharedFlow<fy8.d> r2 = r14.o;
        CanvasEditorEventType r4 = CanvasEditorEventType.EVENT_BOTTOM_INSET_UPDATE;
        UpdateProgress r3 = UpdateProgress.UPDATE_START;
        fy8.f r15 = r14.Y2();
        if (r15 == null) goto L11;
        Boolean r16 = Boxing.boxBoolean(r15.w());
    L12:
        fy8.d r11 = new fy8.d(r4, null, null, null, new fy8.a(r3, 0, r16), null, 110);
        this.label = 1;
        if (r2.emit(r11, this) != r0) goto L16;
        return r0;
    L11:
        r16 = null;
        goto L12
    }
}
