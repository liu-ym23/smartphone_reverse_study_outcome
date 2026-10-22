package com.larus.bmhome.social.userchat.model;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$_chatBotParticipantLiveData$2$3", f = "ChatConversationRequestModel.kt", i = {}, l = {97, 102, 114, 120, 124}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationRequestModel$_chatBotParticipantLiveData$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableLiveData<a> $botLiveData;
    final /* synthetic */ wc9.e $conv;
    int label;
    final /* synthetic */ ChatConversationRequestModel this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$_chatBotParticipantLiveData$2$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$_chatBotParticipantLiveData$2$3$1", f = "ChatConversationRequestModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableLiveData<a> $botLiveData;
        int label;
        final /* synthetic */ ChatConversationRequestModel this$0;

        public AnonymousClass1(ChatConversationRequestModel r1, MutableLiveData<a> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$botLiveData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$botLiveData, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            FLogger.a.w(this.this$0.q, "bot set to null: botParticipant is null");
            this.$botLiveData.setValue(null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$_chatBotParticipantLiveData$2$3$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$_chatBotParticipantLiveData$2$3$2", f = "ChatConversationRequestModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableLiveData<a> $botLiveData;
        int label;

        public AnonymousClass2(MutableLiveData<a> r1, Continuation<? super AnonymousClass2> r2) {
            this.$botLiveData = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$botLiveData, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$botLiveData.setValue(null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatConversationRequestModel$_chatBotParticipantLiveData$2$3(wc9.e r1, ChatConversationRequestModel r2, MutableLiveData<a> r3, Continuation<? super ChatConversationRequestModel$_chatBotParticipantLiveData$2$3> r4) {
        this.$conv = r1;
        this.this$0 = r2;
        this.$botLiveData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatConversationRequestModel$_chatBotParticipantLiveData$2$3(this.$conv, this.this$0, this.$botLiveData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        if (r0 == 5) goto L13;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L37:
        wc9.k r2 = (wc9.k) r1;
        if (r2 == null) goto L63;
        List r3 = r2.b;
        if (r3 == null) goto L55;
        Iterator r4 = r3.iterator();
    L43:
        if (r4.hasNext() == false) goto L53;
        Object r5 = r4.next();
        Integer r6 = ((ParticipantModel) r5).getType();
        if (r6 != null) goto L48;
    L50:
        boolean r8 = false;
    L51:
        if (r8 == false) goto L43;
    L54:
        ParticipantModel r9 = (ParticipantModel) r5;
    L56:
        if (r9 != null) goto L60;
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$botLiveData, null);
        this.label = 3;
        if (BuildersKt.withContext(r10, r11, this) != r7) goto L67;
        return r7;
    L67:
        return Unit.INSTANCE;
    L60:
        ChatConversationRequestModel r12 = this.this$0;
        String r13 = r9.getParticipantId();
        MutableLiveData<a> r14 = this.$botLiveData;
        this.label = 4;
        int r15 = ChatConversationRequestModel.r;
        if (r12.b(r13, "detail", r14, this) != r7) goto L67;
        return r7;
    L48:
        if (r6.intValue() != 2) goto L50;
        r8 = true;
        goto L51
    L53:
        r5 = null;
        goto L54
    L55:
        r9 = null;
        goto L56
    L63:
        FLogger.a.w(this.this$0.q, "bot set to null: result");
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass2 r18 = new AnonymousClass2(this.$botLiveData, null);
        this.label = 5;
        if (BuildersKt.withContext(r16, r18, this) != r7) goto L67;
        return r7;
    L13:
        ResultKt.throwOnFailure(r17);
        goto L67
    L14:
        ResultKt.throwOnFailure(r17);
        if (com.larus.platform.exp.c.a == true) goto L17;
    L23:
        String r19 = null;
    L24:
        if (r19 != null) goto L26;
    L29:
        boolean r20 = true;
    L30:
        if (r20 == true) goto L34;
        ChatConversationRequestModel r21 = this.this$0;
        MutableLiveData<a> r22 = this.$botLiveData;
        this.label = 1;
        int r23 = ChatConversationRequestModel.r;
        if (r21.b(r19, "detail", r22, this) != r7) goto L67;
        return r7;
    L34:
        IConversationRepoService r24 = RepoDispatcherDelegate.b.f();
        String r25 = this.$conv.a;
        this.label = 2;
        r1 = r24.b(r25, 0, 2, false, this);
        if (r1 != r7) goto L37;
        return r7;
    L26:
        if (r19.length() == 0) goto L29;
        r20 = false;
        goto L30
    L17:
        if (com.larus.bmhome.utils.i.h(this.$conv) == false) goto L23;
        com.larus.bmhome.chat.api.e0 r26 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r26 == null) goto L23;
        LaunchInfo r27 = r26.a;
        if (r27 == null) goto L23;
        r19 = r27.W();
        goto L24
    }
}
