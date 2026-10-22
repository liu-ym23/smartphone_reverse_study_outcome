package com.larus.bmhome.bot;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$listener$1$onBotChanged$2", f = "CommonSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommonSettingFragment$listener$1$onBotChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotChangeType $changeType;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$listener$1$onBotChanged$2(CommonSettingFragment r1, BotChangeType r2, Continuation<? super CommonSettingFragment$listener$1$onBotChanged$2> r3) {
        this.this$0 = r1;
        this.$changeType = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonSettingFragment$listener$1$onBotChanged$2(this.this$0, this.$changeType, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r10);
        CommonSettingFragment r11 = this.this$0;
        boolean r0 = true;
        r11.A = true;
        if (this.$changeType == BotChangeType.DELETE) goto L7;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), Dispatchers.getMain().getImmediate(), null, new CommonSettingFragment$setupViews$1(r11, null), 2, null);
    L7:
        CommonSettingFragment r12 = this.this$0;
        com.larus.bmhome.setting.c r1 = r12.g;
        if (r1 == null) goto L38;
        ItemTextArrow r2 = r1.e0();
        if (r2 == null) goto L38;
        BotModel r3 = r12.s;
        if (r3 != null) goto L15;
        r2.U5();
        goto L38
    L15:
        BotMemoryConfig r4 = r3.getBotMemoryConfig();
        boolean r5 = false;
        if (r4 == null) goto L18;
        boolean r6 = Intrinsics.areEqual(r4.getEnableBotMemory(), Boolean.TRUE);
    L19:
        if (r6 == false) goto L38;
        String r13 = r12.S;
        if (r13.length() != 0) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
        r2.U5();
        goto L38
    L27:
        int r8 = com.larus.bmhome.bot.utils.d.a;
        Intrinsics.checkNotNullParameter(r13, "botId");
        if (r13.length() == 0) goto L31;
        r0 = false;
    L31:
        if (r0 == true) goto L34;
        Keva r9 = Keva.getRepo("memory_guide_red_dot", 0);
        Intrinsics.checkNotNullParameter(r13, "botId");
        r5 = r9.getBoolean("ltm_item_clicked_".concat(r13), false);
    L34:
        if (r5 == true) goto L36;
        r2.i6(r2.getSubTextView().getText().toString());
        goto L38
    L36:
        r2.U5();
        goto L38
    L24:
        r7 = false;
        goto L25
    L18:
        r6 = false;
    L38:
        return Unit.INSTANCE;
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
