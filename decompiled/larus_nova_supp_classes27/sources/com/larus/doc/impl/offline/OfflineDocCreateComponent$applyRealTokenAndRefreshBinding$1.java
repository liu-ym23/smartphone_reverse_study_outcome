package com.larus.doc.impl.offline;

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
@DebugMetadata(c = "com.larus.doc.impl.offline.OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1", f = "OfflineDocCreateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $realToken;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ OfflineDocCreateComponent this$0;

    public OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1(OfflineDocCreateComponent r1, String r2, String r3, int r4, Continuation<? super OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1> r5) {
        this.this$0 = r1;
        this.$realToken = r2;
        this.$source = r3;
        this.$resourceType = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1(this.this$0, this.$realToken, this.$source, this.$resourceType, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        d r6 = this.this$0.r;
        if (r6 != null) goto L9;
        return Unit.INSTANCE;
    L9:
        if (r6.XL(this.$realToken) == false) goto L11;
        boolean r0 = r6.HS();
        OfflineDocCreateComponent r1 = this.this$0;
        if (r1.p == true) goto L18;
        if (r0 == false) goto L18;
        r1.p = true;
        int r2 = m39.b.a;
        m39.b.c(this.$source, this.$realToken, true, null);
        r6.ND(this.$resourceType);
        return Unit.INSTANCE;
    L18:
        int r7 = m39.b.a;
        m39.b.c(this.$source, this.$realToken, false, "hasRefreshed=" + this.this$0.p + ",chatAdded=" + r0);
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
