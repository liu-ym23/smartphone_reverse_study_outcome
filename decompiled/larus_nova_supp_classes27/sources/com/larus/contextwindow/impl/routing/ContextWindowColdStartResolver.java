package com.larus.contextwindow.impl.routing;

import com.larus.contextwindow.api.ContextWindowEntryRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import x29.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ContextWindowColdStartResolver {
    public final Function2<ContextWindowEntryRequest, Continuation<? super v29.a>, Object> a;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.routing.ContextWindowColdStartResolver$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<ContextWindowEntryRequest, Continuation<? super v29.a>, Object>, SuspendFunction {
        public AnonymousClass1(Object r8) {
            super(2, r8, ContextWindowColdStartDataSource.class, "load", "load(Lcom/larus/contextwindow/api/ContextWindowEntryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object invoke(ContextWindowEntryRequest r2, Continuation<? super v29.a> r3) {
            return ((ContextWindowColdStartDataSource) ((CallableReference) this).receiver).a(r2, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ContextWindowEntryRequest) r1, (Continuation) r2);
        }
    }

    public ContextWindowColdStartResolver(int r3) {
        AnonymousClass1 r4 = new AnonymousClass1(new ContextWindowColdStartDataSource(null));
        Intrinsics.checkNotNullParameter(r4, "inputLoader");
        this.a = r4;
    }

    public final Object a(ContextWindowEntryRequest r6, Continuation<? super com.larus.contextwindow.api.a> r7) {
        if ((r7 instanceof ContextWindowColdStartResolver$resolve$1) == false) goto L7;
        ContextWindowColdStartResolver$resolve$1 r0 = (ContextWindowColdStartResolver$resolve$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        g r9 = (g) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L18:
        r9.getClass();
        return g.a((v29.a) r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        g r10 = g.a;
        Function2<ContextWindowEntryRequest, Continuation<? super v29.a>, Object> r4 = this.a;
        r0.L$0 = r10;
        r0.label = 1;
        Object r11 = r4.invoke(r6, r0);
        if (r11 != r2) goto L17;
        return r2;
    L17:
        r8 = r11;
        r9 = r10;
    L7:
        r0 = new ContextWindowColdStartResolver$resolve$1(this, r7);
        goto L8
    }
}
