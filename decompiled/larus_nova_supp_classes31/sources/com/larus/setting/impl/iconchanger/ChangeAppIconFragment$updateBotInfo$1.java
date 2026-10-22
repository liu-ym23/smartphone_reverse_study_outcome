package com.larus.setting.impl.iconchanger;

import com.larus.bmhome.bot.BotSettingViewModel;
import com.larus.im.bean.bot.BotModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$updateBotInfo$1", f = "ChangeAppIconFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChangeAppIconFragment$updateBotInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $newBotInfo;
    int label;
    final /* synthetic */ ChangeAppIconFragment this$0;

    public ChangeAppIconFragment$updateBotInfo$1(BotModel r1, ChangeAppIconFragment r2, Continuation<? super ChangeAppIconFragment$updateBotInfo$1> r3) {
        this.$newBotInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChangeAppIconFragment$updateBotInfo$1(this.$newBotInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        int r4 = com.larus.bmhome.bot.a.a;
        this.$newBotInfo.getVoiceType();
        ChangeAppIconFragment r5 = this.this$0;
        BotModel r0 = r5.r;
        if (r0 == null) goto L8;
        ((BotSettingViewModel) r5.z.getValue()).updateAsrLanguage(r0, r5.k);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
