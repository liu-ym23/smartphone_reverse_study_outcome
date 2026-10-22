package com.ss.android.lark.flow.chat.message.system;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.system.FlowExecuteActionSystemActionHandler$createAddApply$1", f = "FlowExecuteActionSystemActionHandler.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
final class FlowExecuteActionSystemActionHandler$createAddApply$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<String> $chatterIds;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $reason;
    int label;

    public FlowExecuteActionSystemActionHandler$createAddApply$1(Context r1, String r2, List<String> r3, String r4, Continuation<? super FlowExecuteActionSystemActionHandler$createAddApply$1> r5) {
        this.$context = r1;
        this.$chatId = r2;
        this.$chatterIds = r3;
        this.$reason = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowExecuteActionSystemActionHandler$createAddApply$1(this.$context, this.$chatId, this.$chatterIds, this.$reason, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        com.larksuite.rucket.job.base.b.b r7 = (com.larksuite.rucket.job.base.b) r6;
        if ((r7 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L16;
        UDToast.show(this.$context, 2131892133);
        return Unit.INSTANCE;
    L16:
        if ((r7 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L36;
        com.larksuite.rucket.job.base.b.b r8 = r7;
        ErrorResult r3 = r8.a();
        String r4 = null;
        if (r3 == null) goto L20;
        String r5 = r3.getDisplayMsg();
    L21:
        StringBuilder r9 = new StringBuilder("createAddApply failed, error=");
        ErrorResult r10 = r8.a();
        if (r10 == null) goto L24;
        r4 = r10.getDisplayMsg();
    L24:
        r9.append(r4);
        Log.e("System_ActionHandler", r9.toString());
        if (r5 != null) goto L27;
    L30:
        if (r2 == true) goto L36;
        Context r11 = this.$context;
        if (r5 != null) goto L34;
        r5 = "";
    L34:
        UDToast.show(r11, r5);
        goto L36
    L27:
        if (r5.length() == 0) goto L30;
        r2 = false;
        goto L30
    L20:
        r5 = null;
    L36:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final String r12 = this.$chatId;
        final List<String> r13 = this.$chatterIds;
        final String r14 = this.$reason;
        CallbackCompatRucketJob r15 = com.larksuite.rucket.job.compat.f.a(new FlowExecuteActionSystemActionHandler$createAddApply$1$response$1(r12, r13, r14));
        this.label = 1;
        r6 = r15.awaitGet(this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
