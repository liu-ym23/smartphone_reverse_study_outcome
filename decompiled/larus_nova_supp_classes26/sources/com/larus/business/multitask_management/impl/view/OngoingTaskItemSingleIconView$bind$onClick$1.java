package com.larus.business.multitask_management.impl.view;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.view.OngoingTaskItemSingleIconView$bind$onClick$1", f = "OngoingTaskItemSingleIconView.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class OngoingTaskItemSingleIconView$bind$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kl9.u $item;
    final /* synthetic */ Function2<String, Map<String, String>, Unit> $onItemClick;
    final /* synthetic */ kl9.p $targetAction;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public OngoingTaskItemSingleIconView$bind$onClick$1(Function2<? super String, ? super Map<String, String>, Unit> r1, kl9.p r2, kl9.u r3, Continuation<? super OngoingTaskItemSingleIconView$bind$onClick$1> r4) {
        this.$onItemClick = r1;
        this.$targetAction = r2;
        this.$item = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OngoingTaskItemSingleIconView$bind$onClick$1(this.$onItemClick, this.$targetAction, this.$item, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L29:
        Boolean r7 = (Boolean) r6;
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Function2<String, Map<String, String>, Unit> r8 = this.$onItemClick;
        if (r8 == null) goto L22;
        kl9.p r2 = this.$targetAction;
        if (r2 == null) goto L16;
        Map r3 = r2.h;
        if (r3 == null) goto L16;
        String r4 = (String) r3.get("button_key");
        if (r4 == null) goto L16;
    L17:
        kl9.p r5 = this.$targetAction;
        if (r5 == null) goto L20;
        Map r9 = r5.h;
    L21:
        r8.invoke(r4, r9);
        goto L22
    L20:
        r9 = null;
    L16:
        r4 = "";
    L22:
        kl9.p r10 = this.$targetAction;
        if (r10 == null) goto L31;
        kl9.u r11 = this.$item;
        il9.a r12 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r12 == null) goto L31;
        String r13 = r11.a;
        this.label = 1;
        r6 = r12.h1(r13, r10, false, this);
        if (r6 != r0) goto L29;
        return r0;
    }
}
