package com.larus.bot.impl.feature.edit;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.spi.IAIChatService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotUpdateFragment$updateSpeakerResult$1$2", f = "BotUpdateFragment.kt", i = {1}, l = {791, 797}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class BotUpdateFragment$updateSpeakerResult$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromVoiceId;
    final /* synthetic */ w2a.f $it;
    Object L$0;
    int label;
    final /* synthetic */ BotUpdateFragment this$0;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotUpdateFragment$updateSpeakerResult$1$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotUpdateFragment$updateSpeakerResult$1$2$2", f = "BotUpdateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotUpdateFragment this$0;

        public AnonymousClass2(BotUpdateFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            ItemTextArrow r3 = this.this$0.t;
            if (r3 == null) goto L7;
            r3.V5();
        L7:
            this.this$0.ba0(false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BotUpdateFragment$updateSpeakerResult$1$2(BotUpdateFragment r1, w2a.f r2, String r3, Continuation<? super BotUpdateFragment$updateSpeakerResult$1$2> r4) {
        this.this$0 = r1;
        this.$it = r2;
        this.$fromVoiceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotUpdateFragment$updateSpeakerResult$1$2(this.this$0, this.$it, this.$fromVoiceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        SpeakerVoice r2 = (SpeakerVoice) this.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        SpeakerVoice r14 = r2;
    L29:
        v2a.b r5 = IAIChatService.a.f7();
        this.this$0.getClass();
        w2a.f r6 = this.$it;
        r5.a(r6, "bot_update", this.$fromVoiceId, "edit", r14, r6.h);
        p2a.r r3 = p2a.r.b;
        BotUpdateFragment r4 = this.this$0;
        ouc.e0 r7 = new ouc.e0();
        ouc.j.c(r7, "is_scheme", "False");
        r4.getClass();
        ouc.j.c(r7, "enter_method", "bot_update");
        if (r14 == null) goto L32;
        ouc.j.c(r7, "result", "Success");
    L33:
        r3.T0(r7.a());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass2(this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L32:
        ouc.j.c(r7, "result", "Fail");
        ouc.j.c(r7, "reason", "ConfCreateFailed");
        goto L33
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L19:
        r14 = (SpeakerVoice) r13;
    L21:
        if (r14 == null) goto L29;
        BotUpdateFragment r8 = this.this$0;
        r8.o = r14;
        BotUpdateViewModel.updateVoice$default(r8.X90(), r14, false, 2, null);
        BotUpdateFragment r9 = this.this$0;
        if (r9.G == false) goto L29;
        BotUpdateViewModel r10 = r9.X90();
        this.L$0 = r14;
        this.label = 2;
        if (r10.update(this) != r0) goto L27;
        return r0;
    L27:
        r2 = r14;
        goto L28
    L10:
        ResultKt.throwOnFailure(r13);
        BotUpdateFragment r15 = this.this$0;
        int r11 = BotUpdateFragment.K;
        p2a.f r16 = (p2a.f) r15.J.getValue();
        if (r16 == null) goto L20;
        w2a.f r12 = this.$it;
        BotLanguage r17 = this.this$0.n;
        if (r17 == null) goto L15;
        String r18 = r17.c();
    L16:
        this.label = 1;
        r13 = r16.F1(r12, r18, this);
        if (r13 != r0) goto L19;
        return r0;
    L15:
        r18 = null;
        goto L16
    L20:
        r14 = null;
        goto L21
    }
}
