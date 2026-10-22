package com.ss.android.lark.forwardv3.viewmodel;

import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0018\u00010\u0001j\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0018\u0001`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$performForward$1$messageParamsBuilders$1", f = "ForwardV3ViewModel.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardV3ViewModel$performForward$1$messageParamsBuilders$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<MessageParams.a<?, ?>>>, Object> {
    int label;
    final /* synthetic */ ForwardV3ViewModel this$0;

    public ForwardV3ViewModel$performForward$1$messageParamsBuilders$1(ForwardV3ViewModel r1, Continuation<? super ForwardV3ViewModel$performForward$1$messageParamsBuilders$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ForwardV3ViewModel$performForward$1$messageParamsBuilders$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ArrayList<MessageParams.a<?, ?>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return (ArrayList) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Deferred r5 = ForwardV3ViewModel.access$getMessageDeferred$p(this.this$0);
        if (r5 == null) goto L14;
        this.label = 1;
        r4 = r5.await(this);
        if (r4 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
