package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleEditState;", "redo", "", "undo", "inMarkSelectMode", "inCropMode"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$configRedoAndUndoButton$1", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$configRedoAndUndoButton$1 extends SuspendLambda implements Function5<Boolean, Boolean, Boolean, Boolean, Continuation<? super d2>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    /* synthetic */ boolean Z$3;
    int label;

    public ResultTitleComponent$configRedoAndUndoButton$1(Continuation<? super ResultTitleComponent$configRedoAndUndoButton$1> r2) {
        super(5, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        return invoke(((Boolean) r7).booleanValue(), ((Boolean) r8).booleanValue(), ((Boolean) r9).booleanValue(), ((Boolean) r10).booleanValue(), (Continuation) r11);
    }

    public final Object invoke(boolean r2, boolean r3, boolean r4, boolean r5, Continuation<? super d2> r6) {
        ResultTitleComponent$configRedoAndUndoButton$1 r0 = new ResultTitleComponent$configRedoAndUndoButton$1(r6);
        r0.Z$0 = r2;
        r0.Z$1 = r3;
        r0.Z$2 = r4;
        r0.Z$3 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        return new d2(this.Z$0, this.Z$1, this.Z$2, this.Z$3);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
