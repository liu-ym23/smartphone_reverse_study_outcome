package com.larus.bmhome.chat.component.cvs;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.AccountService;
import com.larus.utils.y;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationVM$handleConversationIdEmpty$1", f = "ChatConversationVM.kt", i = {0, 1, 1}, l = {DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION, 144}, m = "invokeSuspend", n = {"expectedSecUserId", "expectedSecUserId", "localCid"}, s = {"L$0", "L$0", "L$1"})
public final class ChatConversationVM$handleConversationIdEmpty$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pushContentId;
    final /* synthetic */ String $ugSchema;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatConversationVM this$0;

    public ChatConversationVM$handleConversationIdEmpty$1(ChatConversationVM r1, String r2, String r3, Continuation<? super ChatConversationVM$handleConversationIdEmpty$1> r4) {
        this.this$0 = r1;
        this.$pushContentId = r2;
        this.$ugSchema = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatConversationVM$handleConversationIdEmpty$1(this.this$0, this.$pushContentId, this.$ugSchema, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r3 = (String) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);
        final String r8 = r3;
        final String r6 = r5;
    L23:
        final String r9 = (String) r14;
        if (r8.length() > 0) goto L27;
        r4 = false;
    L27:
        if (r4 == false) goto L31;
        if (r9 == null) goto L31;
        SoftReference r15 = y.a;
        final ChatConversationVM r7 = this.this$0;
        final String r10 = this.$pushContentId;
        final String r11 = this.$ugSchema;
        y.c(new x(r6, r7, r8, r9, r10, r11));
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r12 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);
    L14:
        e r16 = (e) r14;
        if (r16 == null) goto L17;
        r2 = r16.a;
    L17:
        if (r2 != null) goto L19;
        r2 = "";
    L19:
        LocalSubConvHelper r13 = LocalSubConvHelper.a;
        this.L$0 = r12;
        this.L$1 = r2;
        this.label = 2;
        r14 = r13.f(r16, this);
        if (r14 != r0) goto L22;
        return r0;
    L22:
        r6 = r12;
        r8 = r2;
        goto L23
    L10:
        ResultKt.throwOnFailure(r14);
        String r17 = AccountService.a.getSecUserId();
        LocalSubConvHelper r18 = LocalSubConvHelper.a;
        this.L$0 = r17;
        this.label = 1;
        Object r19 = r18.c(r17, null, this);
        if (r19 != r0) goto L13;
        return r0;
    L13:
        r12 = r17;
        r14 = r19;
        goto L14
    }
}
