package com.larus.business.multitask_management.impl.component;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ll9.m;
import ll9.r;
import ll9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.PinnedServicesFeature$isPinned$1", f = "PinnedServicesFeature.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
final class PinnedServicesFeature$isPinned$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $node;
    final /* synthetic */ Function1<Boolean, Unit> $onRemotePinnedResult;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PinnedServicesFeature$isPinned$1(Function1<? super Boolean, Unit> r1, t r2, Continuation<? super PinnedServicesFeature$isPinned$1> r3) {
        this.$onRemotePinnedResult = r1;
        this.$node = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinnedServicesFeature$isPinned$1(this.$onRemotePinnedResult, this.$node, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Boolean r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        r r10 = (r) r9;
        Function1<Boolean, Unit> r2 = this.$onRemotePinnedResult;
        if (r10 == null) goto L34;
        List r11 = r10.e;
        if (r11 == null) goto L34;
        t r4 = this.$node;
        Iterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L30;
        Object r5 = r12.next();
        m r6 = (m) r5;
        if (r6 == null) goto L21;
        NodeType r7 = r6.a;
    L23:
        if (r7 == r4.a) goto L25;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L17;
    L31:
        m r13 = (m) r5;
        if (r13 == null) goto L34;
        r3 = r13.c;
        goto L34
    L25:
        if (Intrinsics.areEqual(r6.b, r4.b) == false) goto L27;
        r8 = true;
        goto L28
    L21:
        r7 = null;
        goto L23
    L30:
        r5 = null;
    L34:
        r2.invoke(r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r14 = Dispatchers.getIO();
        PinnedServicesFeature$isPinned$1$resp$1 r15 = new PinnedServicesFeature$isPinned$1$resp$1(this.$node, null);
        this.label = 1;
        r9 = BuildersKt.withContext(r14, r15, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
