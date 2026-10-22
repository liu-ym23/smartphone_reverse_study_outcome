package com.larus.connector;

import android.content.Context;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.connector.ConnectorFragment$setConnectorEnabled$1", f = "ConnectorFragment.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
final class ConnectorFragment$setConnectorEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $connector;
    final /* synthetic */ boolean $enabled;
    int label;
    final /* synthetic */ ConnectorFragment this$0;

    public ConnectorFragment$setConnectorEnabled$1(ConnectorFragment r1, n r2, boolean r3, Continuation<? super ConnectorFragment$setConnectorEnabled$1> r4) {
        this.this$0 = r1;
        this.$connector = r2;
        this.$enabled = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ConnectorFragment$setConnectorEnabled$1(this.this$0, this.$connector, this.$enabled, r5);
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
    L11:
        boolean r7 = ((Boolean) r6).booleanValue();
        this.this$0.o.remove(this.$connector.a);
        if (r7 == false) goto L22;
        this.this$0.q.getClass();
        List<n> r8 = ConnectorListRepository.b();
        if (r8 == null) goto L16;
        this.this$0.Z90(r8);
    L16:
        s r9 = s.a;
        Context r2 = this.this$0.getContext();
        if (this.$enabled == false) goto L19;
        int r3 = 2131909522;
    L20:
        r9.getClass();
        s.o(r2, r3, false);
        return Unit.INSTANCE;
    L19:
        r3 = 2131909519;
        goto L20
    L22:
        this.this$0.q.getClass();
        List<n> r10 = ConnectorListRepository.b();
        if (r10 == null) goto L25;
        this.this$0.Z90(r10);
    L25:
        Context r11 = this.this$0.getContext();
        if (r11 == null) goto L29;
        s.a.getClass();
        s.b(r11, 2131904418, false);
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ConnectorListRepository r12 = this.this$0.q;
        n r4 = this.$connector;
        String r5 = r4.a;
        boolean r13 = this.$enabled;
        int r14 = r4.h;
        this.label = 1;
        r6 = r12.g(r5, r13, r14, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
