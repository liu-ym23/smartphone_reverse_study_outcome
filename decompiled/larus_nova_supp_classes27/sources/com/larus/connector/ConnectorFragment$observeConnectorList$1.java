package com.larus.connector;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.connector.ConnectorFragment$observeConnectorList$1", f = "ConnectorFragment.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, s = {})
final class ConnectorFragment$observeConnectorList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectorFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ConnectorFragment a;

        public a(ConnectorFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            List<n> r4 = (List) r2;
            if (r4 != null) goto L5;
            ConnectorFragment r5 = this.a;
            int r6 = ConnectorFragment.t;
            r5.showLoading();
        L7:
            return Unit.INSTANCE;
        L5:
            ConnectorFragment r7 = this.a;
            int r0 = ConnectorFragment.t;
            r7.Z90(r4);
            goto L7
        }
    }

    public ConnectorFragment$observeConnectorList$1(ConnectorFragment r1, Continuation<? super ConnectorFragment$observeConnectorList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ConnectorFragment$observeConnectorList$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.this$0.q.getClass();
        b1 r6 = ConnectorListRepository.h;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
