package com.larus.uaigc.chat.block.create;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kc8.a0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "msg", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl$imageOperator$1$commonParamsGetter$1", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {637}, m = "invokeSuspend", n = {}, s = {})
public final class RichMediaCreationClickServiceImpl$imageOperator$1$commonParamsGetter$1 extends SuspendLambda implements Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> {
    final /* synthetic */ kc8.q $createBlockConfig;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ Boolean $isCollectMode;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $previousPage;
    /* synthetic */ Object L$0;
    int label;

    public RichMediaCreationClickServiceImpl$imageOperator$1$commonParamsGetter$1(Message r1, String r2, String r3, Boolean r4, kc8.q r5, Continuation<? super RichMediaCreationClickServiceImpl$imageOperator$1$commonParamsGetter$1> r6) {
        this.$message = r1;
        this.$currentPage = r2;
        this.$previousPage = r3;
        this.$isCollectMode = r4;
        this.$createBlockConfig = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        RichMediaCreationClickServiceImpl$imageOperator$1$commonParamsGetter$1 r7 = new RichMediaCreationClickServiceImpl$imageOperator$1$commonParamsGetter$1(this.$message, this.$currentPage, this.$previousPage, this.$isCollectMode, this.$createBlockConfig, r10);
        r7.L$0 = r9;
        return r7;
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
    L32:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        Message r14 = (Message) this.L$0;
        CreationChatItemClickHelper r3 = CreationChatItemClickHelper.a;
        if (r14 != null) goto L11;
        r14 = this.$message;
    L11:
        Message r4 = r14;
        String r5 = this.$currentPage;
        String r6 = this.$previousPage;
        Boolean r7 = this.$isCollectMode;
        kc8.q r15 = this.$createBlockConfig;
        if (r15 == null) goto L16;
        a0 r16 = r15.d;
        if (r16 == null) goto L16;
        BotModel r8 = r16.j0();
    L17:
        kc8.q r17 = this.$createBlockConfig;
        if (r17 == null) goto L22;
        a0 r18 = r17.d;
        if (r18 == null) goto L22;
        wc9.e r9 = r18.h();
    L23:
        kc8.q r19 = this.$createBlockConfig;
        if (r19 == null) goto L28;
        Function0 r110 = r19.i;
        if (r110 == null) goto L28;
        List r10 = (List) r110.invoke();
    L29:
        this.label = 1;
        r13 = CreationChatItemClickHelper.l(r3, r4, r5, r6, r7, r8, r9, r10, this);
        if (r13 != r0) goto L32;
        return r0;
    L28:
        r10 = null;
    L22:
        r9 = null;
    L16:
        r8 = null;
        goto L17
    }
}
