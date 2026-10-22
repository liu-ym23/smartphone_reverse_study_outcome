package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.im.internal.delegate.c0;
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
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.controller.DropdownListSelectorController$parseTemplate$lambda$9$$inlined$runOnMainThreadIfNeed$1", f = "DropdownListSelectorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DropdownListSelectorController$parseTemplate$lambda$9$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.h $dropdownBox$inlined;
    int label;
    final /* synthetic */ DropdownListSelectorController this$0;

    public DropdownListSelectorController$parseTemplate$lambda$9$$inlined$runOnMainThreadIfNeed$1(Continuation r1, com.larus.bmhome.actionbar.model.h r2, DropdownListSelectorController r3) {
        this.$dropdownBox$inlined = r2;
        this.this$0 = r3;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DropdownListSelectorController$parseTemplate$lambda$9$$inlined$runOnMainThreadIfNeed$1(r4, this.$dropdownBox$inlined, this.this$0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r6);
        if (Intrinsics.areEqual(this.$dropdownBox$inlined.i, Boxing.boxBoolean(true)) == false) goto L23;
        StringBuilder r7 = new StringBuilder("dropbox_");
        com.larus.bmhome.instruction.core.impl.base.c r2 = this.this$0.c;
        Long r3 = null;
        if (r2 == null) goto L13;
        aq8.d r4 = r2.a;
        if (r4 == null) goto L13;
        dq8.h r5 = r4.a;
        if (r5 == null) goto L13;
        Integer r8 = r5.getInstructionType();
    L14:
        r7.append(r8);
        r7.append('_');
        com.larus.bmhome.actionbar.model.u r9 = this.this$0.b;
        if (r9 == null) goto L17;
        Integer r10 = r9.a;
    L18:
        r7.append(r10);
        r7.append('_');
        r7.append(this.$dropdownBox$inlined.b);
        String r11 = r7.toString();
        gb6.c r12 = (gb6.c) this.this$0.p.getValue();
        if (r12 == null) goto L21;
        r3 = Boxing.boxLong(r12.getLong(r11, -1));
    L21:
        c0.b.i("DropdownListSelectorController", "key is " + r11 + ' ' + r3 + " is " + r3);
        return r3;
    L17:
        r10 = null;
    L13:
        r8 = null;
        goto L14
    L23:
        return Boxing.boxLong(-1);
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
