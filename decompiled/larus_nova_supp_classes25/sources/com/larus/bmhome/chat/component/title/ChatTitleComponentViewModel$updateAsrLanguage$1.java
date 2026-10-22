package com.larus.bmhome.chat.component.title;

import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.setting.SettingRepo;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponentViewModel$updateAsrLanguage$1", f = "ChatTitleComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponentViewModel$updateAsrLanguage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $cvsType;
    final /* synthetic */ SpeakerVoice $voice;
    int label;
    final /* synthetic */ ChatTitleComponentViewModel this$0;

    public ChatTitleComponentViewModel$updateAsrLanguage$1(SpeakerVoice r1, ChatTitleComponentViewModel r2, Integer r3, Continuation<? super ChatTitleComponentViewModel$updateAsrLanguage$1> r4) {
        this.$voice = r1;
        this.this$0 = r2;
        this.$cvsType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatTitleComponentViewModel$updateAsrLanguage$1(this.$voice, this.this$0, this.$cvsType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r3);
        if (com.larus.utils.o0.d(this.$voice.getLanguageCode()) == false) goto L17;
        String r4 = this.$voice.getLanguageCode();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        String r5 = ChatTitleComponentViewModel.access$findAsrLanguageByLanguageCode(this.this$0, r4);
        Integer r0 = this.$cvsType;
        if (r0 != null) goto L13;
    L15:
        RepoDispatcher r1 = RepoDispatcher.a;
        r1.getClass();
        SettingRepo r2 = RepoDispatcher.e;
        r2.C0(r5);
        r1.getClass();
        r2.u(r5);
        goto L17
    L13:
        if (r0.intValue() != 1) goto L15;
        AudioServiceDelegate.a.g0(r5);
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
