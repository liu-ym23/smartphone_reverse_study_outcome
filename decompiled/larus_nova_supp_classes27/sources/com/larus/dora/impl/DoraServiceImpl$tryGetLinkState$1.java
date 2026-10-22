package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import g49.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kj4.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$tryGetLinkState$1", f = "DoraServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraServiceImpl$tryGetLinkState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$tryGetLinkState$1(DoraServiceImpl r1, Continuation<? super DoraServiceImpl$tryGetLinkState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraServiceImpl$tryGetLinkState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r6);
        List r7 = CollectionsKt.filterNotNull(DoraAdapterExtKt.j(a.g()));
        DoraServiceImpl r0 = this.this$0;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L19;
        DoraDevice r2 = (DoraDevice) r8.next();
        int r3 = a.g().getDoraLinkState(r2);
        d.d("DoraAudioManagerWrapper", r2.sn + ": btConnectState: " + DoraServiceImpl.o1(r0, r3) + ", doraLinkState: " + DoraServiceImpl.o1(r0, r3));
        int r4 = 2;
        if (r3 != 2) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L14;
        r4 = 1;
    L14:
        r0.H0 = r4;
        if (r5 == false) goto L17;
        r0.c.e();
    L17:
        r1.add(Unit.INSTANCE);
        goto L6
    L10:
        r5 = false;
        goto L11
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
