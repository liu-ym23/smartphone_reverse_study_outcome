package com.ss.android.lark.keyboard.biz.mention;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.FetchAllDataAtStrategy$onRenderFinished$2", f = "FetchAllDataAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FetchAllDataAtStrategy$onRenderFinished$2 extends SuspendLambda implements Function2<Map<String, ? extends ChatChatter>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curChatId;
    final /* synthetic */ AtomicInteger $taskLock;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FetchAllDataAtStrategy this$0;

    public FetchAllDataAtStrategy$onRenderFinished$2(FetchAllDataAtStrategy r1, String r2, AtomicInteger r3, Continuation<? super FetchAllDataAtStrategy$onRenderFinished$2> r4) {
        this.this$0 = r1;
        this.$curChatId = r2;
        this.$taskLock = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        FetchAllDataAtStrategy$onRenderFinished$2 r0 = new FetchAllDataAtStrategy$onRenderFinished$2(this.this$0, this.$curChatId, this.$taskLock, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Map) r1, (Continuation) r2);
    }

    public final Object invoke(Map<String, ? extends ChatChatter> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        Map<String, ? extends ChatChatter> r4 = (Map) this.L$0;
        FetchAllDataAtStrategy r0 = this.this$0;
        r0.g = r4;
        FetchAllDataAtStrategy.e(r0, this.$curChatId, this.$taskLock);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
