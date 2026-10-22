package com.larus.uaigc.chat.block.create.horizontal;

import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kc8.a0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "it", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.LocalCreationHorizontalGroup$initView$1$6", f = "LocalCreationHorizontalGroup.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
final class LocalCreationHorizontalGroup$initView$1$6 extends SuspendLambda implements Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalCreationHorizontalGroup this$0;

    public LocalCreationHorizontalGroup$initView$1$6(LocalCreationHorizontalGroup r1, Continuation<? super LocalCreationHorizontalGroup$initView$1$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LocalCreationHorizontalGroup$initView$1$6 r0 = new LocalCreationHorizontalGroup$initView$1$6(this.this$0, r4);
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
    L36:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        Message r4 = (Message) this.L$0;
        LocalCreationChatItemClickHelper r3 = LocalCreationChatItemClickHelper.a;
        LocalCreationHorizontalGroup r14 = this.this$0;
        int r2 = LocalCreationHorizontalGroup.w;
        ChatParam r5 = r14.g;
        if (r5 == null) goto L11;
        String r6 = r5.d;
    L12:
        if (r5 == null) goto L14;
        String r7 = r5.c;
    L15:
        Boolean r8 = Boxing.boxBoolean(r14.h());
        kc8.q r15 = this.this$0.f;
        if (r15 == null) goto L20;
        a0 r16 = r15.d;
        if (r16 == null) goto L20;
        BotModel r9 = r16.j0();
    L21:
        kc8.q r17 = this.this$0.f;
        if (r17 == null) goto L26;
        a0 r18 = r17.d;
        if (r18 == null) goto L26;
        wc9.e r10 = r18.h();
    L27:
        kc8.q r19 = this.this$0.f;
        if (r19 == null) goto L32;
        Function0 r110 = r19.i;
        if (r110 == null) goto L32;
        List r11 = (List) r110.invoke();
    L33:
        this.label = 1;
        r13 = LocalCreationChatItemClickHelper.e(r3, r4, r6, r7, r8, r9, r10, r11, this);
        if (r13 != r0) goto L36;
        return r0;
    L32:
        r11 = null;
    L26:
        r10 = null;
    L20:
        r9 = null;
        goto L21
    L14:
        r7 = null;
        goto L15
    L11:
        r6 = null;
        goto L12
    }
}
