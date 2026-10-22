package com.larus.share.impl.message;

import com.larus.bmhome.share.network.MessageShareApi;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.network.f;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import dm9.a;
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
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.message.SubConversationShareManager$shareConversationWithCcmPanel$1$result$1", f = "SubConversationShareManager.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
public final class SubConversationShareManager$shareConversationWithCcmPanel$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends SaveMessageShareInfo>>, Object> {
    final /* synthetic */ e $conversation;
    int label;

    public SubConversationShareManager$shareConversationWithCcmPanel$1$result$1(e r1, Continuation<? super SubConversationShareManager$shareConversationWithCcmPanel$1$result$1> r2) {
        this.$conversation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SubConversationShareManager$shareConversationWithCcmPanel$1$result$1(this.$conversation, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<SaveMessageShareInfo>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MessageShareApi.Companion r12 = MessageShareApi.a;
        e r3 = this.$conversation;
        if (r3 == null) goto L11;
        String r4 = r3.a;
    L12:
        f r2 = new f(r4, null, Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(false), Boxing.boxBoolean(true), 2);
        this.label = 1;
        r12.getClass();
        r11 = MessageShareApi.Companion.a(r2, this);
        if (r11 != r0) goto L15;
        return r0;
    L11:
        r4 = null;
        goto L12
    }
}
