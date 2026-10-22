package com.obric.assistant.component.clicktalk;

import android.app.Application;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.asr.VoiceInputType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
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
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.clicktalk.ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1", f = "ChatClickTalkComponent.kt", i = {0, 1}, l = {891, 892, 919, 937}, m = "invokeSuspend", n = {"conv", "botReady"}, s = {"L$0", "I$0"})
final class ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callID;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ ChatClickTalkComponent$a $request;
    final /* synthetic */ String $startupAttemptId;
    final /* synthetic */ VoiceInputType $voiceInputType;
    final /* synthetic */ Integer $vuiId;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ ChatClickTalkComponent this$0;

    public ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1(ChatClickTalkComponent r1, ChatClickTalkComponent$a r2, String r3, String r4, String r5, Integer r6, VoiceInputType r7, Continuation<? super ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1> r8) {
        this.this$0 = r1;
        this.$request = r2;
        this.$startupAttemptId = r3;
        this.$enterMethod = r4;
        this.$callID = r5;
        this.$vuiId = r6;
        this.$voiceInputType = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1(this.this$0, this.$request, this.$startupAttemptId, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r11 = true;
        wc9.e r12 = null;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r23);
        Object r3 = r23;
    L100:
        if (r3 != null) goto L103;
        r11 = false;
    L103:
        ChatClickTalkComponent r4 = this.this$0;
        ChatClickTalkComponent$a r5 = this.$request;
        int r6 = ChatClickTalkComponent.L0;
        if (r4.p3(r5) == true) goto L106;
        if (r11 == false) goto L109;
        ChatClickTalkComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$startupAttemptId, this.$request);
    L111:
        return Unit.INSTANCE;
    L109:
        this.this$0.j4(false, "bot_is_empty");
        this.this$0.C3("dropped", "bot_unavailable", this.$startupAttemptId);
        this.this$0.h4(this.$request);
        goto L111
    L106:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r23);
        Object r7 = r23;
    L80:
        if (r7 != null) goto L83;
        r11 = false;
    L83:
        ChatClickTalkComponent r8 = this.this$0;
        ChatClickTalkComponent$a r9 = this.$request;
        int r10 = ChatClickTalkComponent.L0;
        if (r8.p3(r9) == true) goto L86;
        if (r11 == false) goto L89;
        ChatClickTalkComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$startupAttemptId, this.$request);
    L91:
        return Unit.INSTANCE;
    L89:
        this.this$0.j4(false, "conversation_is_empty");
        this.this$0.C3("dropped", "conversation_unavailable", this.$startupAttemptId);
        this.this$0.h4(this.$request);
        goto L91
    L86:
        return Unit.INSTANCE;
    L12:
        int r13 = this.I$0;
        ResultKt.throwOnFailure(r23);
        Object r14 = r23;
    L53:
        if (r14 != null) goto L56;
        r11 = false;
    L56:
        ChatClickTalkComponent r15 = this.this$0;
        ChatClickTalkComponent$a r16 = this.$request;
        int r17 = ChatClickTalkComponent.L0;
        if (r15.p3(r16) == true) goto L59;
        if (r13 == 0) goto L63;
        if (r11 == false) goto L63;
        ChatClickTalkComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$startupAttemptId, this.$request);
    L71:
        return Unit.INSTANCE;
    L63:
        com.larus.bmhome.chat.component.cvs.y r18 = this.this$0.u0();
        if (r18 == null) goto L66;
        r12 = r18.h();
    L66:
        if (r12 != null) goto L68;
        this.this$0.j4(false, "conversation_is_empty");
        this.this$0.C3("dropped", "conversation_unavailable", this.$startupAttemptId);
    L69:
        this.this$0.h4(this.$request);
        goto L71
    L68:
        this.this$0.j4(false, "bot_is_empty");
        this.this$0.C3("dropped", "bot_unavailable", this.$startupAttemptId);
        goto L69
    L59:
        return Unit.INSTANCE;
    L13:
        Deferred r19 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r20 = r23;
    L46:
        if (r20 == null) goto L48;
        int r21 = 1;
    L49:
        this.L$0 = null;
        this.I$0 = r21;
        this.label = 2;
        r14 = r19.await(this);
        if (r14 != r1) goto L52;
        return r1;
    L52:
        r13 = r21;
        goto L53
    L48:
        r21 = 0;
        goto L49
    L14:
        ResultKt.throwOnFailure(r23);
        ChatClickTalkComponent r22 = this.this$0;
        ChatClickTalkComponent$a r110 = this.$request;
        int r111 = ChatClickTalkComponent.L0;
        if (r22.p3(r110) == true) goto L17;
        int r24 = com.larus.utils.f0.a;
        if (com.larus.utils.f0.a(this.this$0.getContext()) == true) goto L23;
        t19.s r25 = t19.s.a;
        Application r26 = AppHost.a.getApplication();
        r25.getClass();
        t19.s.s(r26, 2131908080);
        this.this$0.j4(false, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        this.this$0.C3("blocked", "network_unavailable", this.$startupAttemptId);
        this.this$0.h4(this.$request);
        return Unit.INSTANCE;
    L23:
        if (this.this$0.u0() != null) goto L33;
        laa.d r27 = this.this$0.V3();
        if (r27 != null) goto L27;
    L29:
        boolean r28 = false;
    L30:
        if (r28 == true) goto L33;
        ChatClickTalkComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$startupAttemptId, this.$request);
        return Unit.INSTANCE;
    L27:
        if (r27.Da() != true) goto L29;
        r28 = true;
    L33:
        com.larus.bmhome.chat.component.cvs.y r29 = this.this$0.u0();
        if (r29 == null) goto L36;
        wc9.e r30 = r29.h();
    L37:
        if (r30 != null) goto L72;
        com.larus.bmhome.chat.component.cvs.y r31 = this.this$0.u0();
        if (r31 == null) goto L41;
        BotModel r32 = r31.j0();
    L42:
        if (r32 != null) goto L72;
        Deferred r33 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$bot$1(this.this$0, null), 3, null);
        r19 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$1(this.this$0, null), 3, null);
        this.L$0 = r19;
        this.label = 1;
        r20 = r33.await(this);
        if (r20 != r1) goto L46;
        return r1;
    L41:
        r32 = null;
    L72:
        com.larus.bmhome.chat.component.cvs.y r34 = this.this$0.u0();
        if (r34 == null) goto L75;
        wc9.e r35 = r34.h();
    L76:
        if (r35 != null) goto L92;
        Deferred r36 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$conv$2(this.this$0, null), 3, null);
        this.label = 3;
        r7 = r36.await(this);
        if (r7 != r1) goto L80;
        return r1;
    L92:
        com.larus.bmhome.chat.component.cvs.y r37 = this.this$0.u0();
        if (r37 == null) goto L95;
        BotModel r38 = r37.j0();
    L96:
        if (r38 != null) goto L113;
        Deferred r39 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatClickTalkComponent$prepareAndOpenContinuousTalk$1$1$bot$2(this.this$0, null), 3, null);
        this.label = 4;
        r3 = r39.await(this);
        if (r3 != r1) goto L100;
        return r1;
    L113:
        if (this.this$0.p3(this.$request) == true) goto L115;
        ChatClickTalkComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$startupAttemptId, this.$request);
        return Unit.INSTANCE;
    L115:
        return Unit.INSTANCE;
    L95:
        r38 = null;
        goto L96
    L75:
        r35 = null;
        goto L76
    L36:
        r30 = null;
        goto L37
    L17:
        return Unit.INSTANCE;
    }
}
