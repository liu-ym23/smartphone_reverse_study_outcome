package com.larus.bmhome.clarification;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$requestPreHandle$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {700}, m = "invokeSuspend", n = {}, s = {})
public final class ClarificationAttachmentManager$requestPreHandle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y $conversation;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $key;
    final /* synthetic */ String $localMsgId;
    int label;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$requestPreHandle$1(UplinkFileEntity r1, y r2, ClarificationAttachmentManager r3, String r4, String r5, Continuation<? super ClarificationAttachmentManager$requestPreHandle$1> r6) {
        this.$entity = r1;
        this.$conversation = r2;
        this.this$0 = r3;
        this.$localMsgId = r4;
        this.$key = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ClarificationAttachmentManager$requestPreHandle$1(this.$entity, this.$conversation, this.this$0, this.$localMsgId, this.$key, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L30:
        FLogger.a.i("ClarificationAttachMgr", "[preHandle] key:" + this.$key + ", result:" + ((com.larus.network.http.a) r10));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Lazy r11 = ChatApi.a;
        ChatApi r12 = ChatApi.a.a();
        UplinkFileEntity r3 = this.$entity;
        y r2 = this.$conversation;
        String r4 = null;
        if (r2 == null) goto L12;
        String r5 = r2.Y1();
        if (r5 == null) goto L12;
    L16:
        y r6 = this.$conversation;
        if (r6 == null) goto L21;
        BotModel r7 = r6.j0();
        if (r7 == null) goto L21;
        String r8 = r7.getBotId();
    L22:
        y r9 = this.$conversation;
        if (r9 == null) goto L27;
        wc9.e r13 = r9.h();
        if (r13 == null) goto L27;
        r4 = r13.B;
    L27:
        String r14 = this.$localMsgId;
        this.label = 1;
        r12.getClass();
        r10 = ChatApi.b(r3, r5, r8, r4, r14, this);
        if (r10 != r0) goto L30;
        return r0;
    L21:
        r8 = null;
    L12:
        d2 r15 = this.this$0.b.a;
        if (r15 == null) goto L15;
        r5 = r15.a;
        goto L16
    L15:
        r5 = null;
        goto L16
    }
}
