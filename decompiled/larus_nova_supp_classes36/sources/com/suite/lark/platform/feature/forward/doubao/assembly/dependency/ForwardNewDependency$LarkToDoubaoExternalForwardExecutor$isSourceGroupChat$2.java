package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2", f = "ForwardNewDependency.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $chatId;
    int label;

    public ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2(String r1, Continuation<? super ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2> r2) {
        this.$chatId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2(this.$chatId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        Chat r4 = ImSdkService.b().getLocalChat(this.$chatId);     // Catch: Throwable -> L10
        if (r4 == null) goto L12;
        if (r4.isP2PChat() == true) goto L12;
        boolean r5 = true;
    L14:
        return Boxing.boxBoolean(r5);
    L12:
        r5 = false;
    L10:
        th = move-exception;
        Log.e("ForwardNewDependency", "get source chat failed, chatId=" + this.$chatId, th);
        goto L12
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
