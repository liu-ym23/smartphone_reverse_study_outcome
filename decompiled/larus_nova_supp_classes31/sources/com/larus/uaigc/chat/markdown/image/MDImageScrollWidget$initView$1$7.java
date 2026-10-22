package com.larus.uaigc.chat.markdown.image;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "it", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollWidget$initView$1$7", f = "MDImageScrollWidget.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
final class MDImageScrollWidget$initView$1$7 extends SuspendLambda implements Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MDImageScrollWidget this$0;

    public MDImageScrollWidget$initView$1$7(MDImageScrollWidget r1, Continuation<? super MDImageScrollWidget$initView$1$7> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MDImageScrollWidget$initView$1$7 r0 = new MDImageScrollWidget$initView$1$7(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Message r1, Continuation<? super Map<String, ? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Message) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L31:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        Message r4 = (Message) this.L$0;
        CreationChatItemClickHelper r3 = CreationChatItemClickHelper.a;
        MDImageScrollWidget r14 = this.this$0;
        String r5 = r14.k;
        String r6 = r14.l;
        Boolean r7 = r14.j;
        q0.a r15 = r14.m;
        if (r15 == null) goto L13;
        com.larus.bmhome.chat.component.cvs.y r16 = r15.u0();
        if (r16 == null) goto L13;
        BotModel r8 = r16.j0();
    L14:
        q0.a r17 = this.this$0.m;
        if (r17 == null) goto L19;
        com.larus.bmhome.chat.component.cvs.y r18 = r17.u0();
        if (r18 == null) goto L19;
        wc9.e r9 = r18.h();
    L20:
        q0.a r19 = this.this$0.m;
        if (r19 == null) goto L27;
        u7 r110 = r19.u3();
        if (r110 == null) goto L27;
        MessageAdapter r111 = r110.MF();
        if (r111 == null) goto L27;
        List r10 = r111.getCurrentList();
    L28:
        this.label = 1;
        r13 = CreationChatItemClickHelper.l(r3, r4, r5, r6, r7, r8, r9, r10, this);
        if (r13 != r0) goto L31;
        return r0;
    L27:
        r10 = null;
    L19:
        r9 = null;
    L13:
        r8 = null;
        goto L14
    }
}
