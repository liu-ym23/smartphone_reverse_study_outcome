package com.obric.widget.host.internal;

import com.obric.widget.host.runtime.WidgetDataSnapshot;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1", f = "DefaultWidgetHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetDataSnapshot>, Object> {
    final /* synthetic */ int $instanceId;
    final /* synthetic */ WidgetDefinitionMetadata $metadata;
    int label;
    final /* synthetic */ DefaultWidgetHost this$0;

    public DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1(DefaultWidgetHost r5, WidgetDefinitionMetadata r10, int r11, Continuation<? super DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1> r12) {
        this.this$0 = r5;
        this.$metadata = r10;
        this.$instanceId = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1(this.this$0, this.$metadata, this.$instanceId, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super WidgetDataSnapshot> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        return DefaultWidgetHost.access$getRuntimeServices$p(this.this$0).queryWidgetData(this.$metadata.getAppletId(), this.$metadata.getWidgetId(), this.$instanceId);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super WidgetDataSnapshot> r10) {
        return ((DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
