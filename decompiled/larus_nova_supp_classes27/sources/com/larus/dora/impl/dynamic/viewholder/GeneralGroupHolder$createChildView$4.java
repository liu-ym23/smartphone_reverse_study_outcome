package com.larus.dora.impl.dynamic.viewholder;

import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$createChildView$4", f = "GeneralGroupHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GeneralGroupHolder$createChildView$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z49.b $doraDevice;
    final /* synthetic */ ItemTextArrow $itemView;
    int label;

    public GeneralGroupHolder$createChildView$4(z49.b r1, ItemTextArrow r2, Continuation<? super GeneralGroupHolder$createChildView$4> r3) {
        this.$doraDevice = r1;
        this.$itemView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GeneralGroupHolder$createChildView$4(this.$doraDevice, this.$itemView, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r3);
        Function1<? super Boolean, Unit> r4 = PacificInterfaceManager.a;
        String r5 = this.$doraDevice.c();
        String r0 = "";
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        String r1 = this.$doraDevice.e();
        if (r1 == null) goto L11;
        r0 = r1;
    L11:
        boolean r6 = PacificInterfaceManager.c(r5, r0);
        ItemTextArrow r2 = this.$itemView;
        int r7 = j0.a;
        if (r6 == false) goto L14;
        int r8 = 2131904044;
    L15:
        String r9 = j0.d(r8);
        int r10 = ItemTextArrow.k;
        r2.Z5(r9, null);
        return Unit.INSTANCE;
    L14:
        r8 = 2131904047;
        goto L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
