package com.larus.business.multitask_management.impl.view;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.view.OngoingTaskItemHolderView$bind$4$1", f = "OngoingTaskItemHolderView.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
final class OngoingTaskItemHolderView$bind$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bindingAdapterPosition;
    final /* synthetic */ kl9.u $item;
    final /* synthetic */ Function3<Integer, String, Map<String, String>, Unit> $onItemClick;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public OngoingTaskItemHolderView$bind$4$1(Function3<? super Integer, ? super String, ? super Map<String, String>, Unit> r1, int r2, kl9.u r3, Continuation<? super OngoingTaskItemHolderView$bind$4$1> r4) {
        this.$onItemClick = r1;
        this.$bindingAdapterPosition = r2;
        this.$item = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OngoingTaskItemHolderView$bind$4$1(this.$onItemClick, this.$bindingAdapterPosition, this.$item, r5);
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
    L25:
        Boolean r7 = (Boolean) r6;
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Function3<Integer, String, Map<String, String>, Unit> r8 = this.$onItemClick;
        kl9.p r2 = null;
        if (r8 == null) goto L11;
        r8.invoke(Boxing.boxInt(this.$bindingAdapterPosition), "enter", null);
    L11:
        kl9.p r9 = this.$item.k;
        if (r9 == null) goto L14;
        Boolean r3 = r9.f;
    L15:
        if (r3 != null) goto L18;
        if (r9 == null) goto L19;
        r2 = kl9.p.a(r9, null, Boxing.boxBoolean(true), 223);
    L19:
        if (r2 == null) goto L27;
        kl9.u r10 = this.$item;
        il9.a r4 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r4 == null) goto L27;
        String r11 = r10.a;
        this.label = 1;
        r6 = r4.h1(r11, r2, true, this);
        if (r6 != r0) goto L25;
        return r0;
    L18:
        r2 = r9;
        goto L19
    L14:
        r3 = null;
        goto L15
    }
}
