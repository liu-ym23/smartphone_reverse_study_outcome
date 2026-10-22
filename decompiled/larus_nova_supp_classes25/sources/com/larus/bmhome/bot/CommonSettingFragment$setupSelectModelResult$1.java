package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ModelItem;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupSelectModelResult$1", f = "CommonSettingFragment.kt", i = {}, l = {3905, 3906}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupSelectModelResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ModelItem $newModelItem;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupSelectModelResult$1(CommonSettingFragment r1, ModelItem r2, Continuation<? super CommonSettingFragment$setupSelectModelResult$1> r3) {
        this.this$0 = r1;
        this.$newModelItem = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonSettingFragment$setupSelectModelResult$1(this.this$0, this.$newModelItem, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r76) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        BotSwitchConfInfo r6 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r76);
        Object r3 = r76;
    L22:
        BotModel r4 = (BotModel) r3;
        CommonSettingFragment r5 = this.this$0;
        if (r5.s != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L25:
        BotModel r7 = this.this$0.s;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r8 = null;
    L29:
        ModelItem r9 = this.$newModelItem;
        if (r4 == null) goto L32;
        r6 = r4.getSwitchConfInfo();
    L32:
        r5.rb0(BotModel.copy$default(r8, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, r9, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, r6, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65537, 2147483615, null));
        this.this$0.yb0();
        return Unit.INSTANCE;
    L28:
        r8 = r7;
        goto L29
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r76);
    L16:
        CommonSettingFragment r10 = this.this$0;
        String r11 = r10.n;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r11 = null;
    L19:
        this.label = 2;
        r3 = CommonSettingFragment.Ga0(r10, r11, false, this, 14);
        if (r3 != r1) goto L22;
        return r1;
    L10:
        ResultKt.throwOnFailure(r76);
        CommonSettingFragment r12 = this.this$0;
        BigDecimal r13 = CommonSettingFragment.k1;
        BotSettingViewModel r14 = r12.Ja0();
        String r15 = this.this$0.n;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r15 = null;
    L13:
        this.label = 1;
        if (r14.requireSyncConversationInfo(r15, this) != r1) goto L16;
        return r1;
    }
}
