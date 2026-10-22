package com.obric.assistant.chat.menu.omnitask;

import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.special_input.util.j;
import com.obric.assistant.utils.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.menu.omnitask.OmniTaskReplyMenuItemHandler$handleMenuItemClick$2", f = "OmniTaskReplyMenuItemHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OmniTaskReplyMenuItemHandler$handleMenuItemClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ DMTaskState $taskState;
    int label;

    public OmniTaskReplyMenuItemHandler$handleMenuItemClick$2(DMTaskState r1, Fragment r2, Continuation<? super OmniTaskReplyMenuItemHandler$handleMenuItemClick$2> r3) {
        this.$taskState = r1;
        this.$fragment = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OmniTaskReplyMenuItemHandler$handleMenuItemClick$2(this.$taskState, this.$fragment, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r9);
        ISpecialInputTask r1 = com.obric.assistant.special_input.c.a();
        if (r1 == null) goto L7;
        ISpecialInputTask.a.a(r1, j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "bot_chat_menu")), null, this.$taskState, 10), true, true, true, null, 16);
    L7:
        DMTaskInfo r10 = this.$taskState.getTaskInfo();
        if (r10 == null) goto L10;
        String r11 = f.a(r10);
    L11:
        if (r11 != null) goto L13;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        FLogger.a.i("OmniTaskReplyMenuItemHandler", "handleMenuItemClick: lastReplyMsgId = ".concat(r11));
        if (o0.d(r11) == false) goto L19;
        laa.c r0 = s1a.a.g(this.$fragment).o(Reflection.getOrCreateKotlinClass(laa.c.class));
        if (r0 == null) goto L19;
        r0.vC(r11);
    L19:
        return Unit.INSTANCE;
    L10:
        r11 = null;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
