package com.obric.assistant.component;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricChatListComponent$scrollToBottom$1", f = "ObricChatListComponent.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatListComponent$scrollToBottom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricChatListComponent this$0;

    public ObricChatListComponent$scrollToBottom$1(ObricChatListComponent r1, Continuation<? super ObricChatListComponent$scrollToBottom$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricChatListComponent$scrollToBottom$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((BaseComponentFeatureInternal) this.this$0).a.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L15;
        FLogger.a.i("ObricChatListComponent", "scrollToBottom: is not stared, ignore scroll");
        return Unit.INSTANCE;
    L15:
        FLogger.a.i("ObricChatListComponent", "scrollToBottom: scroll to latest");
        u7 r5 = (u7) this.this$0.i.getValue();
        if (r5 == null) goto L18;
        r5.TP(false);
    L18:
        ld8.n r6 = (ld8.n) this.this$0.j.getValue();
        if (r6 == null) goto L22;
        r6.m60(BottomFloatingButtonAction.SCROLL_DOWN);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L12;
        return r0;
    }
}
