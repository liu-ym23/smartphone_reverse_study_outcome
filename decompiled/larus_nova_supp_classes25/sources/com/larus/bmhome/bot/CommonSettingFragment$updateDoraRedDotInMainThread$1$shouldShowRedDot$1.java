package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1", f = "CommonSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1(Continuation<? super CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        com.larus.platform.service.z2 r5 = com.larus.platform.service.z2.a;
        boolean r1 = false;
        if (r5.f() == false) goto L7;
        boolean r0 = r5.j();
        if (r5.l() == true) goto L11;
        boolean r2 = r5.e();
        boolean r6 = r5.s();
        if (r0 == true) goto L16;
        if (r2 == true) goto L16;
        if (r6 == true) goto L16;
    L18:
        return Boxing.boxBoolean(r1);
    L16:
        r1 = true;
        goto L18
    L11:
        return Boxing.boxBoolean(r0);
    L7:
        return Boxing.boxBoolean(false);
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
