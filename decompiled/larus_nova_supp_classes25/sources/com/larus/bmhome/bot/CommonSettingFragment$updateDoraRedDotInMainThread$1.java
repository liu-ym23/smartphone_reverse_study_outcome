package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.ItemTextArrow;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$updateDoraRedDotInMainThread$1", f = "CommonSettingFragment.kt", i = {}, l = {780}, m = "invokeSuspend", n = {}, s = {})
public final class CommonSettingFragment$updateDoraRedDotInMainThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$updateDoraRedDotInMainThread$1(CommonSettingFragment r1, Continuation<? super CommonSettingFragment$updateDoraRedDotInMainThread$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonSettingFragment$updateDoraRedDotInMainThread$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        boolean r6 = ((Boolean) r5).booleanValue();
        com.larus.bmhome.setting.c r2 = this.this$0.g;
        if (r2 == null) goto L21;
        if (r6 == false) goto L17;
        ItemTextArrow r7 = r2.C();
        if (r7 == null) goto L21;
        r7.i6("");
        goto L21
    L17:
        ItemTextArrow r8 = r2.C();
        if (r8 == null) goto L21;
        r8.U5();
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r9 = Dispatchers.getDefault();
        CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1 r3 = new CommonSettingFragment$updateDoraRedDotInMainThread$1$shouldShowRedDot$1(null);
        this.label = 1;
        r5 = BuildersKt.withContext(r9, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
