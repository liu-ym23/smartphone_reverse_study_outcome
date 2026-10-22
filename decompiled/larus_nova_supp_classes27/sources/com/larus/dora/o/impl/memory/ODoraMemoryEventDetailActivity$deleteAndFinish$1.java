package com.larus.dora.o.impl.memory;

import android.content.Intent;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.memory.ODoraMemoryEventDetailActivity$deleteAndFinish$1", f = "ODoraMemoryEventDetailActivity.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
final class ODoraMemoryEventDetailActivity$deleteAndFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventId;
    int label;
    final /* synthetic */ ODoraMemoryEventDetailActivity this$0;

    public ODoraMemoryEventDetailActivity$deleteAndFinish$1(String r1, ODoraMemoryEventDetailActivity r2, Continuation<? super ODoraMemoryEventDetailActivity$deleteAndFinish$1> r3) {
        this.$eventId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ODoraMemoryEventDetailActivity$deleteAndFinish$1(this.$eventId, this.this$0, r4);
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
        if (((Boolean) r4).booleanValue() == false) goto L14;
        this.this$0.setResult(-1, new Intent().putExtra("deleted_event_id", this.$eventId));
        this.this$0.finish();
    L16:
        return Unit.INSTANCE;
    L14:
        t19.s r5 = t19.s.a;
        FlowCommonAppCompatActivity r2 = this.this$0;
        r5.getClass();
        t19.s.b(r2, 2131903456, false);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        OMemoryRepo r6 = OMemoryRepo.a;
        String r3 = this.$eventId;
        this.label = 1;
        r4 = r6.c(r3, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
