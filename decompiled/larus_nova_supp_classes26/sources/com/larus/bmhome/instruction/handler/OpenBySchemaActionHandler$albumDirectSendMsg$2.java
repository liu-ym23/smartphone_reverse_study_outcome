package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.handler.OpenBySchemaActionHandler$albumDirectSendMsg$2", f = "OpenBySchemaActionHandler.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
final class OpenBySchemaActionHandler$albumDirectSendMsg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ Map<String, String> $msgExtMap;
    final /* synthetic */ ICoreInputAbility.OnSendParams $sendParams;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ s this$0;

    public OpenBySchemaActionHandler$albumDirectSendMsg$2(s r1, String r2, ICoreInputAbility.OnSendParams r3, String r4, CustomMultiAttachmentInfo r5, Map<String, String> r6, Continuation<? super OpenBySchemaActionHandler$albumDirectSendMsg$2> r7) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$sendParams = r3;
        this.$enterMethod = r4;
        this.$customMultiAttachment = r5;
        this.$msgExtMap = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        OpenBySchemaActionHandler$albumDirectSendMsg$2 r8 = new OpenBySchemaActionHandler$albumDirectSendMsg$2(this.this$0, this.$conversationId, this.$sendParams, this.$enterMethod, this.$customMultiAttachment, this.$msgExtMap, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L22
    L20:
        Object r13 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r12).booleanValue()));     // Catch: Throwable -> L22
    L24:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L28;
        FLogger.a.e("OpenBySchemaActionHandler", "albumDirectSendMsg sendCreationMessage failed", r14);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        s r16 = this.this$0;
        String r2 = this.$conversationId;
        ICoreInputAbility.OnSendParams r3 = this.$sendParams;
        String r4 = this.$enterMethod;
        CustomMultiAttachmentInfo r5 = this.$customMultiAttachment;
        Map<String, String> r6 = this.$msgExtMap;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L22
        ICreationWorkflowService.Companion r8 = ICreationWorkflowService.a;     // Catch: Throwable -> L22
        CreationSendMessageConfig.Companion.getClass();     // Catch: Throwable -> L22
        CreationSendMessageConfig.a r9 = new CreationSendMessageConfig.a();     // Catch: Throwable -> L22
        int r10 = s.o;     // Catch: Throwable -> L22
        com.larus.bmhome.chat.component.cvs.y r11 = r16.b();     // Catch: Throwable -> L22
        String r17 = null;
        if (r11 == null) goto L13;
        wc9.e r18 = r11.h();     // Catch: Throwable -> L22
    L14:
        r9.j(r18);     // Catch: Throwable -> L22
        r9.l(r2);     // Catch: Throwable -> L22
        ChatParam r19 = r16.e().a(ChatParam.class);     // Catch: Throwable -> L22
        if (r19 == null) goto L17;
        r17 = r19.b;     // Catch: Throwable -> L22
    L17:
        r9.f(r17);     // Catch: Throwable -> L22
        r9.i(r3.getContent());     // Catch: Throwable -> L22
        r9.m(r4);     // Catch: Throwable -> L22
        r9.r("chat");     // Catch: Throwable -> L22
        r9.d(Boxing.boxInt(r3.getActionInstruction()));     // Catch: Throwable -> L22
        r9.c(r3.getActionBarInstructionMap());     // Catch: Throwable -> L22
        r9.k(r5);     // Catch: Throwable -> L22
        r9.q(r6);     // Catch: Throwable -> L22
        r9.p(r3.getLocalIntercepted());     // Catch: Throwable -> L22
        r9.o(r3.getLocalInterceptInfo());     // Catch: Throwable -> L22
        CreationSendMessageConfig r110 = r9.a;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        r12 = r8.W(r110, this);     // Catch: Throwable -> L22
        if (r12 != r0) goto L20;
        return r0;
    L13:
        r18 = null;
    L22:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
