package com.larus.setting.impl.iconchanger;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.utils.b0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.z2;
import com.larus.setting.impl.databinding.LarusPageChangeAppIconBinding;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$setupSelectSpeakerResult$1$1", f = "ChangeAppIconFragment.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {556, 572, 592}, m = "invokeSuspend", n = {"findBotResult", "updateLocalBotResult", "$this$invokeSuspend_u24lambda_u243", "findBotResult", "updateLocalBotResult", "$this$invokeSuspend_u24lambda_u243", "voice", "saveResult", "findBotResult", "updateLocalBotResult", "voice", "saveResult"}, s = {"L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "L$5", "L$6", "L$0", "L$1", "L$3", "L$4"})
final class ChangeAppIconFragment$setupSelectSpeakerResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ w2a.f $it;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ ChangeAppIconFragment this$0;

    public ChangeAppIconFragment$setupSelectSpeakerResult$1$1(ChangeAppIconFragment r1, w2a.f r2, Continuation<? super ChangeAppIconFragment$setupSelectSpeakerResult$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChangeAppIconFragment$setupSelectSpeakerResult$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r89) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r5 = "Fail";
        String r4 = CustomFeedPlayerEvent.EXTRA_KEY_REASON;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        Ref.ObjectRef r1 = (Ref.ObjectRef) this.L$5;
        p2a.m r2 = (p2a.m) this.L$4;
        SpeakerVoice r3 = (SpeakerVoice) this.L$3;
        LarusPageChangeAppIconBinding r8 = (LarusPageChangeAppIconBinding) this.L$2;
        Ref.BooleanRef r9 = (Ref.BooleanRef) this.L$1;
        Ref.ObjectRef r13 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r89);
        String r6 = "result";
        r4 = CustomFeedPlayerEvent.EXTRA_KEY_REASON;
        r5 = "Fail";
        Ref.ObjectRef r10 = r1;
        final SpeakerVoice r11 = r3;
        Object r12 = r89;
        p2a.m r14 = r2;
        String r15 = null;
    L64:
        r10.element = r12;
        Ref.BooleanRef r16 = r9;
        r10 = r13;
    L66:
        p2a.r r17 = p2a.r.b;
        e0 r18 = new e0();
        ouc.j.c(r18, "is_scheme", "False");
        ouc.j.c(r18, "enter_method", "bot_image_setting");
        if ((r14 instanceof p2a.j) == false) goto L69;
        ouc.j.c(r18, r6, r5);
        ouc.j.c(r18, r4, "ConfSaveFailed");
    L126:
        r17.T0(r18.a());
    L128:
        return Unit.INSTANCE;
    L69:
        String r19 = r4;
        String r20 = r5;
        if (z2.a.enableGetBotListAfterSaveVoice() == false) goto L123;
        Object r21 = r10.element;
        if (r21 != null) goto L74;
    L109:
        if (r21 != null) goto L111;
    L113:
        if (r21 == null) goto L115;
    L117:
        if (r21 == null) goto L119;
    L121:
        Unit r22 = Unit.INSTANCE;
        goto L126
    L119:
        if (r16.element == true) goto L121;
        ouc.j.c(r18, r6, r20);
        ouc.j.c(r18, r19, "UpdateBotFail + GetBotFail");
        goto L121
    L115:
        if (r16.element == false) goto L117;
        ouc.j.c(r18, r6, "Success");
        ouc.j.c(r18, r19, "UpdateBotSuccess + GetBotFail");
        goto L121
    L111:
        if (r16.element == true) goto L113;
        ouc.j.c(r18, r6, r20);
        ouc.j.c(r18, r19, "UpdateBotFail + GetBotSuccess");
        goto L121
    L74:
        if (r16.element == false) goto L109;
        float r23 = 0.0f;
        if (r11 == null) goto L78;
        float r110 = r11.getPitchF64();
    L79:
        BotModel r111 = (BotModel) r10.element;
        if (r111 == null) goto L84;
        SpeakerVoice r112 = r111.getVoiceType();
        if (r112 == null) goto L84;
        float r113 = r112.getPitchF64();
    L85:
        boolean r114 = b0.a(r110, r113);
        if (r11 == null) goto L88;
        float r115 = r11.getSpeechRateF64();
    L89:
        BotModel r116 = (BotModel) r10.element;
        if (r116 == null) goto L94;
        SpeakerVoice r117 = r116.getVoiceType();
        if (r117 == null) goto L94;
        r23 = r117.getSpeechRateF64();
    L94:
        boolean r24 = b0.a(r115, r23);
        if (r11 == null) goto L97;
        String r25 = r11.getStyleId();
    L98:
        BotModel r26 = (BotModel) r10.element;
        if (r26 == null) goto L104;
        SpeakerVoice r27 = r26.getVoiceType();
        if (r27 == null) goto L104;
        r15 = r27.getStyleId();
    L104:
        if (Intrinsics.areEqual(r25, r15) == false) goto L108;
        if (r114 == false) goto L108;
        if (r24 == false) goto L108;
        ouc.j.c(r18, r6, "Success");
    L108:
        ouc.j.c(r18, r6, r20);
        ouc.j.c(r18, r19, "ConfSaveAndUpdateBotNotEqual");
        goto L121
    L97:
        r25 = r15;
        goto L98
    L88:
        r115 = 0.0f;
    L84:
        r113 = 0.0f;
        goto L85
    L78:
        r110 = 0.0f;
        goto L79
    L123:
        if (r16.element == false) goto L125;
        ouc.j.c(r18, r6, "Success");
        goto L126
    L125:
        ouc.j.c(r18, r6, r20);
        ouc.j.c(r18, r19, "UpdateBotFail");
        goto L126
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Ref.BooleanRef r28 = (Ref.BooleanRef) this.L$7;
        p2a.m r29 = (p2a.m) this.L$6;
        SpeakerVoice r30 = (SpeakerVoice) this.L$5;
        LarusPageChangeAppIconBinding r118 = (LarusPageChangeAppIconBinding) this.L$4;
        ChangeAppIconFragment r119 = (ChangeAppIconFragment) this.L$3;
        LarusPageChangeAppIconBinding r31 = (LarusPageChangeAppIconBinding) this.L$2;
        r16 = (Ref.BooleanRef) this.L$1;
        Ref.ObjectRef r32 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r89);
        LarusPageChangeAppIconBinding r33 = r118;
        r11 = r30;
        r6 = "result";
        r10 = r32;
        r14 = r29;
        Ref.BooleanRef r34 = r28;
        Object r35 = r89;
    L45:
        r34.element = ((Boolean) r35).booleanValue();
        r33.i.V5();
        if (r11 == null) goto L52;
        BotModel r36 = r119.r;
        if (r36 == null) goto L50;
        BotModel r37 = BotModel.copy$default(r36, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r11, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null);
    L51:
        r119.r = r37;
        r119.ea0(r11);
    L54:
        if ((r14 instanceof p2a.j) == false) goto L57;
        t19.s.a.g(r119.getContext(), 2131907872, false);
        FLogger.a.e("ChangeAppIconFragment", "setupSelectSpeakerResult save voice error " + ((p2a.m) ((p2a.j) r14)).a);
    L65:
        r15 = null;
        goto L66
    L57:
        if ((r14 instanceof p2a.o) == false) goto L65;
        if (z2.a.enableGetBotListAfterSaveVoice() == false) goto L65;
        String r38 = r119.n;
        this.L$0 = r10;
        this.L$1 = r16;
        this.L$2 = r31;
        this.L$3 = r11;
        this.L$4 = r14;
        this.L$5 = r10;
        r15 = null;
        this.L$6 = null;
        this.L$7 = null;
        this.label = 3;
        r12 = r119.W90(r38, true, "default_write", this);
        if (r12 != r7) goto L63;
        return r7;
    L63:
        r13 = r10;
        r9 = r16;
        goto L64
    L50:
        r37 = null;
        goto L51
    L52:
        r33.i.V5();
        int r39 = ChangeAppIconFragment.B;
        r119.ea0(null);
        goto L54
    L11:
        LarusPageChangeAppIconBinding r40 = (LarusPageChangeAppIconBinding) this.L$4;
        ChangeAppIconFragment r41 = (ChangeAppIconFragment) this.L$3;
        LarusPageChangeAppIconBinding r42 = (LarusPageChangeAppIconBinding) this.L$2;
        Ref.BooleanRef r43 = (Ref.BooleanRef) this.L$1;
        Ref.ObjectRef r120 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r89);
        ChangeAppIconFragment r121 = r41;
        r34 = r43;
        r10 = r120;
        r33 = r40;
        Object r44 = r89;
    L34:
        p2a.m r45 = (p2a.m) r44;
        r11 = (SpeakerVoice) r45.a;
        BotModel r46 = r121.r;
        if (r46 == null) goto L37;
        String r47 = r46.getBotId();
    L38:
        if (r47 != null) goto L41;
        p2a.r r48 = p2a.r.b;
        e0 r49 = new e0();
        ouc.j.c(r49, "is_scheme", "False");
        ouc.j.c(r49, "enter_method", "bot_image_setting");
        ouc.j.c(r49, "result", r5);
        ouc.j.c(r49, r4, "BotIdIsNull");
        r48.T0(r49.a());
        return Unit.INSTANCE;
    L41:
        IBotRepoService r50 = zh8.a.e;
        Function1 r122 = new q(r11);
        this.L$0 = r10;
        this.L$1 = r34;
        this.L$2 = r42;
        this.L$3 = r121;
        this.L$4 = r33;
        this.L$5 = r11;
        this.L$6 = r45;
        this.L$7 = r34;
        this.label = 2;
        r35 = r50.l1(r47, r122, this);
        r7 = r7;
        if (r35 != r7) goto L44;
        return r7;
    L44:
        r31 = r42;
        r119 = r121;
        r14 = r45;
        r16 = r34;
        goto L45
    L37:
        r47 = null;
        goto L38
    L12:
        ResultKt.throwOnFailure(r89);
        Ref.ObjectRef r123 = new Ref.ObjectRef();
        Ref.BooleanRef r51 = new Ref.BooleanRef();
        r121 = this.this$0;
        LarusPageChangeAppIconBinding r52 = r121.e;
        if (r52 == null) goto L128;
        w2a.f r53 = this.$it;
        r52.i.Y5();
        r52.i.c6();
        p2a.i r54 = p2a.i.b;
        BotModel r124 = r121.r;
        if (r124 == null) goto L19;
        SpeakerVoice r125 = r124.getVoiceType();
        if (r125 == null) goto L19;
        String r126 = r125.getId();
    L20:
        BotModel r55 = r121.r;
        if (r55 == null) goto L23;
        String r56 = r55.getBotId();
    L24:
        BotModel r57 = r121.r;
        if (r57 == null) goto L29;
        SpeakerVoice r58 = r57.getVoiceType();
        if (r58 == null) goto L29;
        String r59 = r58.getLanguageCode();
    L30:
        this.L$0 = r123;
        this.L$1 = r51;
        this.L$2 = r52;
        this.L$3 = r121;
        this.L$4 = r52;
        this.label = 1;
        r44 = r54.y2(r53, r126, r56, r59, this);
        if (r44 != r7) goto L33;
        return r7;
    L33:
        r34 = r51;
        r10 = r123;
        r42 = r52;
        r33 = r42;
    L29:
        r59 = null;
        goto L30
    L23:
        r56 = null;
    L19:
        r126 = null;
        goto L20
    }
}
