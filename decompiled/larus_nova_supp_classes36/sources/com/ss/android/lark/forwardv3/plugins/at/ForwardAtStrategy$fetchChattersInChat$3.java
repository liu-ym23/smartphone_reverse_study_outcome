package com.ss.android.lark.forwardv3.plugins.at;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.plugins.at.ForwardAtStrategy$fetchChattersInChat$3", f = "ForwardAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ForwardAtStrategy$fetchChattersInChat$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ Collection<String> $ids;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ForwardAtStrategy this$0;

    public ForwardAtStrategy$fetchChattersInChat$3(ForwardAtStrategy r1, Collection<String> r2, Continuation<? super ForwardAtStrategy$fetchChattersInChat$3> r3) {
        this.this$0 = r1;
        this.$ids = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ForwardAtStrategy$fetchChattersInChat$3 r0 = new ForwardAtStrategy$fetchChattersInChat$3(this.this$0, this.$ids, r5);
        r0.L$0 = r4;
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
        Log.e("ForwardAtStrategy", "get local chatter failed, error = " + ((ErrorResult) this.L$0).getDisplayMsg());
        ForwardAtStrategy r4 = this.this$0;
        List<String> r0 = CollectionsKt.toList(this.$ids);
        int r1 = ForwardAtStrategy.j;
        r4.a(r0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
