package com.larus.uaigc.chat.block.correction;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.correction.CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1", f = "CorrectionImageBlockHolder.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Object>>, Object> {
    final /* synthetic */ ChatParam $currentChatParam;
    final /* synthetic */ q0.a $currentProvider;
    final /* synthetic */ Message $message;
    int label;

    public CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1(Message r1, ChatParam r2, q0.a r3, Continuation<? super CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1> r4) {
        this.$message = r1;
        this.$currentChatParam = r2;
        this.$currentProvider = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1(this.$message, this.$currentChatParam, this.$currentProvider, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, ? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L44:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CreationChatItemClickHelper r2 = CreationChatItemClickHelper.a;
        Message r13 = this.$message;
        ChatParam r3 = this.$currentChatParam;
        if (r3 == null) goto L11;
        String r5 = r3.d;
    L12:
        if (r3 == null) goto L14;
        String r6 = r3.c;
    L15:
        q0.a r4 = this.$currentProvider;
        if (r4 == null) goto L20;
        o r7 = r4.i2();
        if (r7 == null) goto L20;
        boolean r8 = r7.i0();
    L21:
        Boolean r9 = Boxing.boxBoolean(r8);
        q0.a r10 = this.$currentProvider;
        if (r10 == null) goto L26;
        y r11 = r10.u0();
        if (r11 == null) goto L26;
        BotModel r14 = r11.j0();
    L27:
        q0.a r15 = this.$currentProvider;
        if (r15 == null) goto L32;
        y r16 = r15.u0();
        if (r16 == null) goto L32;
        wc9.e r17 = r16.h();
    L33:
        q0.a r18 = this.$currentProvider;
        if (r18 == null) goto L40;
        u7 r19 = r18.u3();
        if (r19 == null) goto L40;
        MessageAdapter r20 = r19.MF();
        if (r20 == null) goto L40;
        List r110 = r20.getCurrentList();
    L41:
        this.label = 1;
        r12 = CreationChatItemClickHelper.l(r2, r13, r5, r6, r9, r14, r17, r110, this);
        if (r12 != r0) goto L44;
        return r0;
    L40:
        r110 = null;
    L32:
        r17 = null;
    L26:
        r14 = null;
    L20:
        r8 = false;
        goto L21
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    }
}
