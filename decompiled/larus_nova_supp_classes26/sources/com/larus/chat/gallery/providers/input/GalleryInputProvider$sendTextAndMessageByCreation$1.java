package com.larus.chat.gallery.providers.input;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.bot.BotModel;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.providers.input.GalleryInputProvider$sendTextAndMessageByCreation$1", f = "GalleryInputProvider.kt", i = {0}, l = {244}, m = "invokeSuspend", n = {"sendConfig"}, s = {"L$1"})
final class GalleryInputProvider$sendTextAndMessageByCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GalleryInputProvider this$0;

    public GalleryInputProvider$sendTextAndMessageByCreation$1(wc9.e r1, String r2, GalleryInputProvider r3, ICoreInputAbility.OnSendParams r4, CustomMultiAttachmentInfo r5, Continuation<? super GalleryInputProvider$sendTextAndMessageByCreation$1> r6) {
        this.$conversation = r1;
        this.$conversationId = r2;
        this.this$0 = r3;
        this.$params = r4;
        this.$customMultiAttachment = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        GalleryInputProvider$sendTextAndMessageByCreation$1 r7 = new GalleryInputProvider$sendTextAndMessageByCreation$1(this.$conversation, this.$conversationId, this.this$0, this.$params, this.$customMultiAttachment, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$1;
        GalleryInputProvider r4 = (GalleryInputProvider) this.L$0;
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L36
    L23:
        MutableSharedFlow r5 = ty9.a.a;     // Catch: Throwable -> L36
        r4.getClass();     // Catch: Throwable -> L36
        String r6 = r1.getCvsId();     // Catch: Throwable -> L36
        if (r6 != null) goto L29;
        wc9.e r7 = r1.getConversation();     // Catch: Throwable -> L36
        if (r7 == null) goto L28;
        r3 = r7.a;     // Catch: Throwable -> L36
    L28:
        String r8 = r3;
    L30:
        boolean r20 = r1.getClearInputContent();     // Catch: Throwable -> L36
        if (r1.getAttachmentInfo() == null) goto L33;
        boolean r21 = true;
    L34:
        ty9.a.a(new CreationSendUiEvent(r8, null, false, true, true, true, true, true, false, true, true, true, true, r20, r21, 262, null));     // Catch: Throwable -> L36
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        GalleryInputProvider r10 = this.this$0;
        Throwable r11 = Result.exceptionOrNull-impl(r9);
        if (r11 == null) goto L42;
        FLogger.a.e(((com.larus.gallery.api.t) r10).a, "sendTextAndMessageByCreation error", r11);
    L42:
        return Unit.INSTANCE;
    L33:
        r21 = false;
        goto L34
    L29:
        r8 = r6;
        goto L30
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r25);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        wc9.e r13 = this.$conversation;
        String r14 = this.$conversationId;
        GalleryInputProvider r15 = this.this$0;
        ICoreInputAbility.OnSendParams r16 = this.$params;
        CustomMultiAttachmentInfo r17 = this.$customMultiAttachment;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L36
        CreationSendMessageConfig.Companion.getClass();     // Catch: Throwable -> L36
        CreationSendMessageConfig.a r19 = new CreationSendMessageConfig.a();     // Catch: Throwable -> L36
        r19.j(r13);     // Catch: Throwable -> L36
        r19.l(r14);     // Catch: Throwable -> L36
        ty8.b r22 = (ty8.b) ((com.larus.gallery.api.t) r15).d;     // Catch: Throwable -> L36
        if (r22 == null) goto L15;
        String r23 = r22.d;     // Catch: Throwable -> L36
        if (r23 == null) goto L15;
    L19:
        r19.f(r23);     // Catch: Throwable -> L36
        r19.i(r16.getContent());     // Catch: Throwable -> L36
        r19.m(r16.getEnterMethod());     // Catch: Throwable -> L36
        r19.r("chat");     // Catch: Throwable -> L36
        r19.d(Boxing.boxInt(r16.getActionInstruction()));     // Catch: Throwable -> L36
        r19.c(r16.getActionBarInstructionMap());     // Catch: Throwable -> L36
        r19.k(r17);     // Catch: Throwable -> L36
        r19.q(r16.messageExt);     // Catch: Throwable -> L36
        r19.p(r16.getLocalIntercepted());     // Catch: Throwable -> L36
        r19.o(r16.getLocalInterceptInfo());     // Catch: Throwable -> L36
        CreationSendMessageConfig r24 = r19.a;     // Catch: Throwable -> L36
        ICreationWorkflowService.Companion r26 = ICreationWorkflowService.a;     // Catch: Throwable -> L36
        this.L$0 = r15;     // Catch: Throwable -> L36
        this.L$1 = r24;     // Catch: Throwable -> L36
        this.label = 1;     // Catch: Throwable -> L36
        if (r26.W(r24, this) != r0) goto L22;
        return r0;
    L22:
        r1 = r24;
        r4 = r15;
    L15:
        BotModel r27 = r15.f.a;     // Catch: Throwable -> L36
        if (r27 == null) goto L18;
        r23 = r27.getBotId();     // Catch: Throwable -> L36
        goto L19
    L18:
        r23 = null;
    L36:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    }
}
