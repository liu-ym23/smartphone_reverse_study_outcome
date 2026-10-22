package com.larus.bot.impl.feature.edit.feature.firstmet.tts;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.flow.kmp.common.util.i;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.bean.message.TextContent;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.tts.TtsScene;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import wf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotFirstMetEditTtsPlayer$readText$1", f = "BotFirstMetEditTtsPlayer.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class BotFirstMetEditTtsPlayer$readText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpeakerVoice $speakerVoice;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ BotFirstMetEditTtsPlayer this$0;

    public BotFirstMetEditTtsPlayer$readText$1(BotFirstMetEditTtsPlayer r1, String r2, SpeakerVoice r3, Continuation<? super BotFirstMetEditTtsPlayer$readText$1> r4) {
        this.this$0 = r1;
        this.$text = r2;
        this.$speakerVoice = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotFirstMetEditTtsPlayer$readText$1(this.this$0, this.$text, this.$speakerVoice, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r58) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r58);
    L45:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r58);
        Message r1 = this.this$0.c;
        String r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.getContent();
    L12:
        boolean r4 = false;
        if (r3 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L37;
        if (r3 != null) goto L22;
    L23:
        r4 = true;
    L24:
        if (r4 == false) goto L46;
    L32:
        Object r6 = null;
    L33:
        TextContent r7 = (TextContent) r6;
        if (r7 == null) goto L37;
        r2 = r7.text;
        goto L37
    L46:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L28
        r6 = Result.constructor-impl(HttpExtKt.f.fromJson(r3, TextContent.class));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r6) == false) goto L33;
    L28:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L22:
        if (StringsKt.isBlank(r3) == false) goto L24;
    L37:
        if (Intrinsics.areEqual(r2, this.$text) == true) goto L39;
        String r13 = System.currentTimeMillis() + "-onboarding";
        int r10 = b.a;
        String r27 = i.a();
        BotFirstMetEditTtsPlayer r12 = this.this$0;
        List r45 = CollectionsKt.listOf(Boxing.boxInt(MessageTag.MessageTag_Onboarding_FIRSTMEG.value));
        TextContent r14 = new TextContent(this.$text, null, null, null, null, null, null, null, 254, null);
        Intrinsics.checkNotNullParameter(r14, "what");
        r12.c = new Message(r13, null, null, 0, 21, null, 1, false, null, GsonProtectorUtils.toJson(HttpExtKt.f, r14), null, null, null, null, r27, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, r45, false, null, null, 0, null, null, null, -536887890, 31, null);
    L39:
        BotFirstMetEditTtsPlayer r15 = this.this$0;
        Message r16 = r15.c;
        if (r16 == null) goto L45;
        SpeakerVoice r17 = this.$speakerVoice;
        IAIChatAudioService.a.b(r16.getConversationId());
        x1 r18 = r15.b;
        TtsScene r19 = TtsScene.Auto_Other;
        this.label = 1;
        if (x1.b.b(r18, r16, r17, false, null, null, r19, this, 60) != r11) goto L45;
        return r11;
    L15:
        if (r3.length() == 0) goto L18;
        r5 = false;
        goto L19
    L11:
        r3 = null;
        goto L12
    }
}
