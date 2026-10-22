package com.larus.bmhome.bot;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupSelectSpeakerResult$1$1", f = "CommonSettingFragment.kt", i = {}, l = {3777}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupSelectSpeakerResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromVoiceId;
    final /* synthetic */ w2a.f $it;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.CommonSettingFragment$setupSelectSpeakerResult$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupSelectSpeakerResult$1$1$2", f = "CommonSettingFragment.kt", i = {}, l = {3813}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fromVoiceId;
        final /* synthetic */ w2a.f $it;
        final /* synthetic */ p2a.m<SpeakerVoice> $saveResult;
        final /* synthetic */ SpeakerVoice $voice;
        int label;
        final /* synthetic */ CommonSettingFragment this$0;

        public AnonymousClass2(CommonSettingFragment r1, SpeakerVoice r2, w2a.f r3, String r4, p2a.m<SpeakerVoice> r5, Continuation<? super AnonymousClass2> r6) {
            this.this$0 = r1;
            this.$voice = r2;
            this.$it = r3;
            this.$fromVoiceId = r4;
            this.$saveResult = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass2(this.this$0, this.$voice, this.$it, this.$fromVoiceId, this.$saveResult, r9);
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
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r76);
        L46:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r76);
            com.larus.bmhome.setting.c r3 = this.this$0.g;
            if (r3 == null) goto L13;
            ItemTextArrow r4 = r3.Z0();
            if (r4 == null) goto L13;
            r4.V5();
        L13:
            String r5 = null;
            if (this.$voice == null) goto L23;
            CommonSettingFragment r6 = this.this$0;
            if (r6.s != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        L18:
            BotModel r7 = this.this$0.s;
            if (r7 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");
            BotModel r8 = null;
        L22:
            r6.rb0(BotModel.copy$default(r8, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, this.$voice, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
            this.this$0.xb0(this.$voice);
        L29:
            v2a.b r9 = p2a.r.b.f7();
            String r10 = this.this$0.k();
            w2a.f r11 = this.$it;
            String r12 = r11.h;
            r9.a(r11, r10, this.$fromVoiceId, "edit", this.$voice, r12);
            if ((this.$saveResult instanceof p2a.j) == false) goto L33;
            t19.s.a.g(this.this$0.getContext(), 2131907872, false);
            FLogger.a.e(this.this$0.e, "setupSelectSpeakerResult save voice error " + ((p2a.m) this.$saveResult).a);
            goto L46
        L33:
            if (this.this$0.n == null) goto L46;
            com.larus.platform.service.z2 r13 = com.larus.platform.service.z2.a;
            if (r13.R() == false) goto L46;
            if (r13.enableGetBotListAfterSaveVoice() == false) goto L46;
            CommonSettingFragment r14 = this.this$0;
            String r15 = r14.n;
            if (r15 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        L42:
            Boxing.boxBoolean(false);
            this.label = 1;
            if (r14.Fa0(r5, true, "default_write", this) != r1) goto L46;
            return r1;
        L41:
            r5 = r15;
            goto L42
        L21:
            r8 = r7;
            goto L22
        L23:
            com.larus.bmhome.setting.c r16 = this.this$0.g;
            if (r16 == null) goto L28;
            ItemTextArrow r17 = r16.Z0();
            if (r17 == null) goto L28;
            r17.V5();
        L28:
            this.this$0.xb0(null);
            goto L29
        }
    }

    public CommonSettingFragment$setupSelectSpeakerResult$1$1(w2a.f r1, CommonSettingFragment r2, String r3, Continuation<? super CommonSettingFragment$setupSelectSpeakerResult$1$1> r4) {
        this.$it = r1;
        this.this$0 = r2;
        this.$fromVoiceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommonSettingFragment$setupSelectSpeakerResult$1$1(this.$it, this.this$0, this.$fromVoiceId, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L28:
        p2a.m r10 = (p2a.m) r13;
        final SpeakerVoice r7 = (SpeakerVoice) r10.a;
        if ((r10 instanceof p2a.o) == false) goto L37;
        BotServiceImpl r14 = com.larus.im.d.a();
        BotModel r2 = this.this$0.s;
        if (r2 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r2 = null;
    L33:
        String r3 = r2.getBotId();
        if (r3 != null) goto L36;
        r3 = "";
    L36:
        r14.updateLocalBot(r3, new h5(r7), null);
        AudioServiceDelegate.a.i0().f(r7);
    L37:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass2(this.this$0, r7, this.$it, this.$fromVoiceId, r10, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        p2a.i r5 = p2a.i.b;
        w2a.f r6 = this.$it;
        BotModel r15 = this.this$0.s;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r15 = null;
    L11:
        SpeakerVoice r16 = r15.getVoiceType();
        if (r16 == null) goto L14;
        String r8 = r16.getId();
    L15:
        BotModel r17 = this.this$0.s;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r17 = null;
    L18:
        String r9 = r17.getBotId();
        BotModel r18 = this.this$0.s;
        if (r18 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r18 = null;
    L21:
        SpeakerVoice r19 = r18.getVoiceType();
        if (r19 == null) goto L24;
        String r11 = r19.getLanguageCode();
    L25:
        this.label = 1;
        r13 = r5.y2(r6, r8, r9, r11, this);
        if (r13 != r0) goto L28;
        return r0;
    L24:
        r11 = null;
        goto L25
    L14:
        r8 = null;
        goto L15
    }
}
