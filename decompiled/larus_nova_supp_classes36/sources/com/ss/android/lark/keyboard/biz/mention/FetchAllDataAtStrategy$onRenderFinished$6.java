package com.ss.android.lark.keyboard.biz.mention;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.FetchAllDataAtStrategy$onRenderFinished$6", f = "FetchAllDataAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FetchAllDataAtStrategy$onRenderFinished$6 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curChatId;
    final /* synthetic */ AtomicInteger $taskLock;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FetchAllDataAtStrategy this$0;

    public FetchAllDataAtStrategy$onRenderFinished$6(String r1, FetchAllDataAtStrategy r2, AtomicInteger r3, Continuation<? super FetchAllDataAtStrategy$onRenderFinished$6> r4) {
        this.$curChatId = r1;
        this.this$0 = r2;
        this.$taskLock = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        FetchAllDataAtStrategy$onRenderFinished$6 r0 = new FetchAllDataAtStrategy$onRenderFinished$6(this.$curChatId, this.this$0, this.$taskLock, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        Log.e("FetchAllDataAtStrategy", "check chatters in chat failed, chatId = " + this.$curChatId + ", error = " + ((ErrorResult) this.L$0).getDisplayMsg());
        FetchAllDataAtStrategy.e(this.this$0, this.$curChatId, this.$taskLock);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
