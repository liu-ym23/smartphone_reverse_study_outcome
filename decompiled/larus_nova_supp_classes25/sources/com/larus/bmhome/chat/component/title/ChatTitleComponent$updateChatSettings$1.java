package com.larus.bmhome.chat.component.title;

import android.text.TextUtils;
import by9.a;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$updateChatSettings$1", f = "ChatTitleComponent.kt", i = {}, l = {1493}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponent$updateChatSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ ModelItem $modelItem;
    final /* synthetic */ SpeakerVoice $newSpeakerVoice;
    final /* synthetic */ String $nickName;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.title.ChatTitleComponent$updateChatSettings$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$updateChatSettings$1$2", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SpeakerVoice $newSpeakerVoice;
        int label;
        final /* synthetic */ ChatTitleComponent this$0;

        public AnonymousClass2(ChatTitleComponent r1, SpeakerVoice r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$newSpeakerVoice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$newSpeakerVoice, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r3);
            ChatTitleComponent r4 = this.this$0;
            com.larus.platform.api.g0 r0 = r4.n;
            if (r0 == null) goto L10;
            if (r0 == null) goto L8;
            boolean r5 = r0.getTtsChecked();
        L9:
            r0.setTtsChecked(r5);
            goto L10
        L8:
            r5 = Intrinsics.areEqual(r4.L9(), Boxing.boxBoolean(true));
        L10:
            com.larus.platform.api.g0 r6 = this.this$0.n;
            if (r6 == null) goto L17;
            SpeakerVoice r1 = this.$newSpeakerVoice;
            if (r1 == null) goto L15;
            String r2 = r1.getId();
        L16:
            r6.setTtsBanned(Intrinsics.areEqual(r2, "0"));
            goto L17
        L15:
            r2 = null;
        L17:
            a r7 = this.this$0.i4();
            if (r7 == null) goto L21;
            r7.M9();
        L21:
            return Unit.INSTANCE;
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatTitleComponent$updateChatSettings$1(SpeakerVoice r1, BotModel r2, ModelItem r3, String r4, ChatTitleComponent r5, Continuation<? super ChatTitleComponent$updateChatSettings$1> r6) {
        this.$newSpeakerVoice = r1;
        this.$bot = r2;
        this.$modelItem = r3;
        this.$nickName = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatTitleComponent$updateChatSettings$1(this.$newSpeakerVoice, this.$bot, this.$modelItem, this.$nickName, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r73) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r73);
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r73);
        SpeakerVoice r3 = this.$newSpeakerVoice;
        if (r3 != null) goto L11;
        r3 = this.$bot.getVoiceType();
    L11:
        SpeakerVoice r23 = r3;
        ModelItem r4 = this.$modelItem;
        if (r4 != null) goto L14;
        r4 = this.$bot.getModel();
    L14:
        ModelItem r22 = r4;
        if (TextUtils.isEmpty(this.$nickName) == true) goto L17;
        String r5 = this.$nickName;
    L18:
        boolean r25 = this.$bot.getMuted();
        BotModel r6 = BotModel.copy$default(this.$bot, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, r22, r23, null, r25, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, r5, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -720897, 2147483519, null);
        SpeakerVoice r7 = this.$newSpeakerVoice;
        if (r7 == null) goto L25;
        ChatTitleComponent r8 = this.this$0;
        int r9 = ChatTitleComponent.P1;
        ChatTitleComponentViewModel r10 = r8.h4();
        e r11 = r8.V3();
        if (r11 == null) goto L23;
        Integer r12 = r11.v;
    L24:
        r10.updateAsrLanguage(r7, r12);
        goto L25
    L23:
        r12 = null;
    L25:
        AudioServiceDelegate.a.i0().l(r6);
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass2 r14 = new AnonymousClass2(this.this$0, this.$newSpeakerVoice, null);
        this.label = 1;
        if (BuildersKt.withContext(r13, r14, this) != r1) goto L29;
        return r1;
    L17:
        r5 = this.$bot.getCallerName();
        goto L18
    }
}
