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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
public final class RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Object>>, Object> {
    final /* synthetic */ kc8.q $createBlockConfig;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ Boolean $isCollectMode;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $previousPage;
    int label;

    public RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1(Message r1, String r2, String r3, Boolean r4, kc8.q r5, Continuation<? super RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1> r6) {
        this.$message = r1;
        this.$currentPage = r2;
        this.$previousPage = r3;
        this.$isCollectMode = r4;
        this.$createBlockConfig = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RichMediaCreationClickServiceImpl$bindLongClick$imageCommonParams$1(this.$message, this.$currentPage, this.$previousPage, this.$isCollectMode, this.$createBlockConfig, r9);
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
    L28:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CreationChatItemClickHelper r2 = CreationChatItemClickHelper.a;
        Message r12 = this.$message;
        String r3 = this.$currentPage;
        String r4 = this.$previousPage;
        Boolean r5 = this.$isCollectMode;
        kc8.q r6 = this.$createBlockConfig;
        List r7 = null;
        if (r6 == null) goto L13;
        a0 r8 = r6.d;
        if (r8 == null) goto L13;
        BotModel r9 = r8.j0();
    L14:
        kc8.q r10 = this.$createBlockConfig;
        if (r10 == null) goto L19;
        a0 r13 = r10.d;
        if (r13 == null) goto L19;
        wc9.e r14 = r13.h();
    L20:
        kc8.q r15 = this.$createBlockConfig;
        if (r15 == null) goto L25;
        Function0 r16 = r15.i;
        if (r16 == null) goto L25;
        r7 = (List) r16.invoke();
    L25:
        this.label = 1;
        r11 = CreationChatItemClickHelper.l(r2, r12, r3, r4, r5, r9, r14, r7, this);
        if (r11 != r0) goto L28;
        return r0;
    L19:
        r14 = null;
    L13:
        r9 = null;
        goto L14
    }
}
