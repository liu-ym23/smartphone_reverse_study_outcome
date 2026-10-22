package com.larus.uaigc.chat.block.create;

import com.larus.bmhome.chat.ChatParam;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.BaseCreationHolder$handleItemLongClick$2", f = "BaseCreationHolder.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class BaseCreationHolder$handleItemLongClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Object>>, Object> {
    final /* synthetic */ kc8.q $createBlockConfig;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ BaseCreationHolder<T> this$0;

    public BaseCreationHolder$handleItemLongClick$2(Message r1, BaseCreationHolder<T> r2, kc8.q r3, Continuation<? super BaseCreationHolder$handleItemLongClick$2> r4) {
        this.$message = r1;
        this.this$0 = r2;
        this.$createBlockConfig = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BaseCreationHolder$handleItemLongClick$2(this.$message, this.this$0, this.$createBlockConfig, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, ? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L42:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CreationChatItemClickHelper r2 = CreationChatItemClickHelper.a;
        Message r12 = this.$message;
        BaseCreationHolder<T> r3 = this.this$0;
        int r4 = BaseCreationHolder.h;
        ChatParam r5 = (ChatParam) r3.g.getValue();
        List r6 = null;
        if (r5 == null) goto L11;
        String r7 = r5.d;
    L12:
        ChatParam r8 = (ChatParam) this.this$0.g.getValue();
        if (r8 == null) goto L15;
        String r9 = r8.c;
    L16:
        kc8.q r10 = this.$createBlockConfig;
        if (r10 == null) goto L21;
        Function0 r13 = r10.e;
        if (r13 == null) goto L21;
        boolean r14 = ((Boolean) r13.invoke()).booleanValue();
    L22:
        Boolean r15 = Boxing.boxBoolean(r14);
        kc8.q r16 = this.$createBlockConfig;
        if (r16 == null) goto L27;
        a0 r17 = r16.d;
        if (r17 == null) goto L27;
        BotModel r18 = r17.j0();
    L28:
        kc8.q r19 = this.$createBlockConfig;
        if (r19 == null) goto L33;
        a0 r20 = r19.d;
        if (r20 == null) goto L33;
        wc9.e r21 = r20.h();
    L34:
        kc8.q r22 = this.$createBlockConfig;
        if (r22 == null) goto L39;
        Function0 r23 = r22.i;
        if (r23 == null) goto L39;
        r6 = (List) r23.invoke();
    L39:
        this.label = 1;
        r11 = CreationChatItemClickHelper.l(r2, r12, r7, r9, r15, r18, r21, r6, this);
        if (r11 != r0) goto L42;
        return r0;
    L33:
        r21 = null;
    L27:
        r18 = null;
    L21:
        r14 = false;
        goto L22
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    }
}
