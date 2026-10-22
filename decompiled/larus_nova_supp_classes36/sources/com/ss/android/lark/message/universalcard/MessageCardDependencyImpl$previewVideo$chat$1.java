package com.ss.android.lark.message.universalcard;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.message.lynxcard.message.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.message.universalcard.MessageCardDependencyImpl$previewVideo$chat$1", f = "MessageCardDependencyImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageCardDependencyImpl$previewVideo$chat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Chat>, Object> {
    int label;
    final /* synthetic */ MessageCardDependencyImpl this$0;

    public MessageCardDependencyImpl$previewVideo$chat$1(MessageCardDependencyImpl r1, Continuation<? super MessageCardDependencyImpl$previewVideo$chat$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageCardDependencyImpl$previewVideo$chat$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Chat> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        d r3 = MessageCardDependencyImpl.access$getLynxCardCellCallback$p(this.this$0);
        if (r3 == null) goto L11;
        r5b.a r4 = r3.e;
        if (r4 == null) goto L11;
        String r5 = r4.getChatId();
        if (r5 == null) goto L11;
        return ImSdkService.b().we(r5);
    L11:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
