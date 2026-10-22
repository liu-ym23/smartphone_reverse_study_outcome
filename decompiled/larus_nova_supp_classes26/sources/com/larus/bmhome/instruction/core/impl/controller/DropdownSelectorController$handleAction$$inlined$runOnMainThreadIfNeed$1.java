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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/bmhome/instruction/core/impl/base/ControllerContextKt$runOnMainThreadIfNeed$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.controller.DropdownSelectorController$handleAction$$inlined$runOnMainThreadIfNeed$1", f = "DropdownSelectorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DropdownSelectorController$handleAction$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $selectedId$inlined;
    int label;
    final /* synthetic */ DropdownSelectorController this$0;

    public DropdownSelectorController$handleAction$$inlined$runOnMainThreadIfNeed$1(Continuation r1, DropdownSelectorController r2, long r3) {
        this.this$0 = r2;
        this.$selectedId$inlined = r3;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DropdownSelectorController$handleAction$$inlined$runOnMainThreadIfNeed$1(r5, this.this$0, this.$selectedId$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r4);
        com.larus.bmhome.actionbar.model.h r5 = this.this$0.q;
        if (r5 == null) goto L7;
        boolean r6 = Intrinsics.areEqual(r5.i, Boxing.boxBoolean(true));
    L8:
        if (r6 == false) goto L23;
        Integer r1 = null;
        if (this.this$0.r != 4) goto L15;
        StringBuilder r7 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r0 = this.this$0.q;
        if (r0 == null) goto L14;
        r1 = r0.b;
    L14:
        r7.append(r1);
        String r8 = r7.toString();
    L19:
        gb6.c r2 = (gb6.c) this.this$0.p.getValue();
        if (r2 == null) goto L23;
        r2.storeLong(r8, this.$selectedId$inlined);
        goto L23
    L15:
        StringBuilder r9 = new StringBuilder("dropbox_");
        r9.append(this.this$0.r);
        r9.append('_');
        com.larus.bmhome.actionbar.model.h r3 = this.this$0.q;
        if (r3 == null) goto L18;
        r1 = r3.b;
    L18:
        r9.append(r1);
        r8 = r9.toString();
    L23:
        return Unit.INSTANCE;
    L7:
        r6 = false;
        goto L8
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
