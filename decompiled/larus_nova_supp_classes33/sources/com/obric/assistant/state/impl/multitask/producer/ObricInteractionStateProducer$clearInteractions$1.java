package com.obric.assistant.state.impl.multitask.producer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import jha.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricInteractionStateProducer$clearInteractions$1", f = "ObricInteractionStateProducer.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class ObricInteractionStateProducer$clearInteractions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ownerId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ObricInteractionStateProducer this$0;

    public ObricInteractionStateProducer$clearInteractions$1(ObricInteractionStateProducer r1, String r2, Continuation<? super ObricInteractionStateProducer$clearInteractions$1> r3) {
        this.this$0 = r1;
        this.$ownerId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricInteractionStateProducer$clearInteractions$1(this.this$0, this.$ownerId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$2;
        ObricInteractionStateProducer r3 = (ObricInteractionStateProducer) this.L$1;
        a r4 = (a) this.L$0;
        ResultKt.throwOnFailure(r8);
    L32:
        Set r9 = ((LinkedHashMap) r3.b).entrySet();     // Catch: Throwable -> L29
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L29
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L29
    L14:
        if (r10.hasNext() == false) goto L18;
        Object r6 = r10.next();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(((ObricInteractionStateProducer.a) ((Map.Entry) r6).getValue()).a, r2) == false) goto L14;
        r5.add(r6);     // Catch: Throwable -> L29
        goto L14
    L18:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));     // Catch: Throwable -> L29
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L29
    L20:
        if (r7.hasNext() == false) goto L22;
        r11.add((g) ((Map.Entry) r7.next()).getKey());     // Catch: Throwable -> L29
        goto L20
    L22:
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L29
    L24:
        if (r12.hasNext() == false) goto L26;
        ObricInteractionStateProducer.d(r3, (g) r12.next(), MapsKt.emptyMap());     // Catch: Throwable -> L29
        goto L24
    L26:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L29
        r4.unlock(null);
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r3 = this.this$0;
        a r14 = r3.c;
        String r15 = this.$ownerId;
        this.L$0 = r14;
        this.L$1 = r3;
        this.L$2 = r15;
        this.label = 1;
        if (r14.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r4 = r14;
        r2 = r15;
        goto L32
    }
}
