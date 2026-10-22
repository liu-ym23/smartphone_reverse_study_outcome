package com.obric.assistant.window;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.window.ObricPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1", f = "ObricPageStateComponent.kt", i = {}, l = {463}, m = "invokeSuspend", n = {}, s = {})
final class ObricPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $trigger;
    int label;
    final /* synthetic */ ObricPageStateComponent this$0;

    public ObricPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1(ObricPageStateComponent r1, String r2, Continuation<? super ObricPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1> r3) {
        this.this$0 = r1;
        this.$trigger = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1(this.this$0, this.$trigger, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        ObricPageStateComponent r12 = this.this$0;
        int r3 = ObricPageStateComponent.Z;
        r12.getClass();
        String r4 = sea.e.b();
        if (r4 == null) goto L18;
        if (r4.length() == 0) goto L18;
        r2 = false;
    L18:
        if (r2 == true) goto L23;
        String r5 = sea.e.d.get();
        if (r5 != null) goto L22;
        r5 = "scene:conversation_change";
    L22:
        r12.R = new laa.w(r4, r5);
        FLogger.a.i("ObricPageStateComponent", "updatePendingComplexTaskReplyTarget from sceneHelper, trigger=conversation_change, replyMessageId=".concat(r4));
    L23:
        ObricPageStateComponent r13 = this.this$0;
        String r6 = this.$trigger;
        laa.w r7 = r13.R;
        if (r7 == null) goto L37;
        String r8 = sea.e.b();
        if (Intrinsics.areEqual(r8, r7.a) == true) goto L29;
        FLogger.a.i("ObricPageStateComponent", "tryConsumePendingComplexTaskReplyTarget skipped, trigger=" + r6 + ", reason=expired_or_replaced, pending=" + r7 + ", sceneReplyMessageId=" + r8);
        r13.R = null;
        goto L37
    L29:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        laa.c r9 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r13, r13)).getAbility(laa.c.class);
        if (r9 != null) goto L33;
        FLogger.a.i("ObricPageStateComponent", "tryConsumePendingComplexTaskReplyTarget skipped, trigger=" + r6 + ", reason=no_chat_list_ability, pending=" + r7);
        goto L37
    L33:
        if (r9.BL(r7.a) == true) goto L35;
        FLogger.a.i("ObricPageStateComponent", "tryConsumePendingComplexTaskReplyTarget waiting, trigger=" + r6 + ", replyMessageId=" + r7.a + ", source=" + r7.b);
        goto L37
    L35:
        FLogger.a.i("ObricPageStateComponent", "tryConsumePendingComplexTaskReplyTarget success, trigger=" + r6 + ", replyMessageId=" + r7.a + ", source=" + r7.b);
        r9.vC(r7.a);
        sea.e.e.set(SystemClock.elapsedRealtime());
        r13.R = null;
        sea.e.a(r7.a);
    L37:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
