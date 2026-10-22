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
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.controller.DropdownListSelectorController$persistIfNeedSave$$inlined$runOnMainThreadIfNeed$1", f = "DropdownListSelectorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DropdownListSelectorController$persistIfNeedSave$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.h $dropdownBox$inlined;
    final /* synthetic */ int $persistDropdownId$inlined;
    final /* synthetic */ long $selectedId$inlined;
    int label;
    final /* synthetic */ DropdownListSelectorController this$0;

    public DropdownListSelectorController$persistIfNeedSave$$inlined$runOnMainThreadIfNeed$1(Continuation r1, com.larus.bmhome.actionbar.model.h r2, DropdownListSelectorController r3, int r4, long r5) {
        this.$dropdownBox$inlined = r2;
        this.this$0 = r3;
        this.$persistDropdownId$inlined = r4;
        this.$selectedId$inlined = r5;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DropdownListSelectorController$persistIfNeedSave$$inlined$runOnMainThreadIfNeed$1(r9, this.$dropdownBox$inlined, this.this$0, this.$persistDropdownId$inlined, this.$selectedId$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r4);
        if (Intrinsics.areEqual(this.$dropdownBox$inlined.i, Boxing.boxBoolean(true)) == false) goto L21;
        StringBuilder r5 = new StringBuilder("dropbox_");
        com.larus.bmhome.instruction.core.impl.base.c r0 = this.this$0.c;
        Integer r1 = null;
        if (r0 == null) goto L13;
        aq8.d r2 = r0.a;
        if (r2 == null) goto L13;
        dq8.h r3 = r2.a;
        if (r3 == null) goto L13;
        Integer r6 = r3.getInstructionType();
    L14:
        r5.append(r6);
        r5.append('_');
        com.larus.bmhome.actionbar.model.u r7 = this.this$0.b;
        if (r7 == null) goto L17;
        r1 = r7.a;
    L17:
        r5.append(r1);
        r5.append('_');
        r5.append(this.$persistDropdownId$inlined);
        String r8 = r5.toString();
        gb6.c r9 = (gb6.c) this.this$0.p.getValue();
        if (r9 == null) goto L21;
        r9.storeLong(r8, this.$selectedId$inlined);
    L13:
        r6 = null;
    L21:
        return Unit.INSTANCE;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
