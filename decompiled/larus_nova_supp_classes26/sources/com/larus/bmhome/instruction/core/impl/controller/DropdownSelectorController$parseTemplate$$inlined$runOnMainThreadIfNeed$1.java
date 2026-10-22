package com.larus.bmhome.instruction.core.impl.controller;

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
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/bmhome/instruction/core/impl/base/ControllerContextKt$runOnMainThreadIfNeed$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.controller.DropdownSelectorController$parseTemplate$$inlined$runOnMainThreadIfNeed$1", f = "DropdownSelectorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DropdownSelectorController$parseTemplate$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    int label;
    final /* synthetic */ DropdownSelectorController this$0;

    public DropdownSelectorController$parseTemplate$$inlined$runOnMainThreadIfNeed$1(Continuation r1, DropdownSelectorController r2) {
        this.this$0 = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownSelectorController$parseTemplate$$inlined$runOnMainThreadIfNeed$1(r3, this.this$0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r7);
        DropdownSelectorController r8 = this.this$0;
        Integer r5 = null;
        if (r8.r != 4) goto L12;
        gb6.c r9 = (gb6.c) r8.p.getValue();
        if (r9 == null) goto L21;
        StringBuilder r0 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r1 = this.this$0.q;
        if (r1 == null) goto L11;
        r5 = r1.b;
    L11:
        r0.append(r5);
        return Boxing.boxLong(r9.getLong(r0.toString(), -1));
    L21:
        return null;
    L12:
        gb6.c r10 = (gb6.c) r8.p.getValue();
        if (r10 == null) goto L23;
        StringBuilder r2 = new StringBuilder("dropbox_");
        r2.append(this.this$0.r);
        r2.append('_');
        com.larus.bmhome.actionbar.model.h r3 = this.this$0.q;
        if (r3 == null) goto L17;
        r5 = r3.b;
    L17:
        r2.append(r5);
        return Boxing.boxLong(r10.getLong(r2.toString(), -1));
    L23:
        return null;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
