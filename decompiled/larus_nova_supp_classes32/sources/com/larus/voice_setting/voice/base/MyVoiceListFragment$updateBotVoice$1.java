package com.larus.voice_setting.voice.base;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.base.MyVoiceListFragment$updateBotVoice$1", f = "MyVoiceListFragment.kt", i = {}, l = {648}, m = "invokeSuspend", n = {}, s = {})
final class MyVoiceListFragment$updateBotVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ SpeakerVoice $voice;
    int label;

    public MyVoiceListFragment$updateBotVoice$1(BotModel r1, SpeakerVoice r2, Continuation<? super MyVoiceListFragment$updateBotVoice$1> r3) {
        this.$bot = r1;
        this.$voice = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MyVoiceListFragment$updateBotVoice$1(this.$bot, this.$voice, r4);
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
    L15:
        ub8.h r6 = (ub8.h) r5;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IRepoDispatcherService r7 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r7 == null) goto L17;
        IBotRepoService r8 = r7.b();
        if (r8 == null) goto L17;
        BotModel r2 = this.$bot;
        SpeakerVoice r3 = this.$voice;
        this.label = 1;
        r5 = r8.t1(r2, r3, this);
        if (r5 != r0) goto L15;
        return r0;
    }
}
