package com.larus.search.impl.global;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2<T> implements FlowCollector {
    public final /* synthetic */ FlowCollector a;

    /* JADX INFO: renamed from: com.larus.search.impl.global.GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2", f = "GlobalSearchFragment.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2 this$0;

        public AnonymousClass1(GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2 r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public GlobalSearchFragment$onViewCreated$1$3$invokeSuspend$$inlined$filter$1$2(FlowCollector r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        FlowCollector r9 = this.a;
        com.larus.paging.i r4 = (com.larus.paging.i) r6;
        if ((r4.a instanceof com.larus.paging.u.c) == true) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L25;
        r0.label = 1;
        if (r9.emit(r6, r0) != r2) goto L25;
        return r2;
    L17:
        if (r4.b.a == false) goto L19;
        r5 = true;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
