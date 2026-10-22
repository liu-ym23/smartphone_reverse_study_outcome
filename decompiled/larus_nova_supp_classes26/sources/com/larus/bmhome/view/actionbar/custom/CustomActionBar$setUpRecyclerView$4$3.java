package com.larus.bmhome.view.actionbar.custom;

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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$setUpRecyclerView$4$3", f = "CustomActionBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CustomActionBar$setUpRecyclerView$4$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    int label;
    final /* synthetic */ CustomActionBar this$0;

    public CustomActionBar$setUpRecyclerView$4$3(com.larus.bmhome.actionbar.model.z0 r1, CustomActionBar r2, Continuation<? super CustomActionBar$setUpRecyclerView$4$3> r3) {
        this.$item = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CustomActionBar$setUpRecyclerView$4$3(this.$item, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r6);
        com.larus.bmhome.actionbar.model.z0 r7 = this.$item;
        boolean r0 = false;
        if (r7 != null) goto L7;
    L9:
        if (r0 == false) goto L21;
        CustomActionBarViewModel r1 = this.this$0.o;
        if (r1 == null) goto L21;
        Long r8 = r7.a;
        long r2 = 0;
        if (r8 == null) goto L15;
        long r3 = r8.longValue();
    L16:
        String r9 = String.valueOf(r3);
        Long r4 = this.$item.t;
        if (r4 == null) goto L19;
        r2 = r4.longValue();
    L19:
        r1.reportRedDotExposure(r9, r2);
        goto L21
    L15:
        r3 = 0;
    L21:
        return Unit.INSTANCE;
    L7:
        if (r7.y != true) goto L9;
        r0 = true;
        goto L9
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
