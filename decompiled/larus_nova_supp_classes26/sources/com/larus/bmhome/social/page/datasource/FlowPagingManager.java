package com.larus.bmhome.social.page.datasource;

import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.bmhome.social.page.datasource.event.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class FlowPagingManager<T, Key, Event extends com.larus.bmhome.social.page.datasource.event.a<T>> {
    public final Lazy a;
    public final Lazy b;
    public final ConcurrentLinkedQueue<com.larus.bmhome.social.page.datasource.event.e> c;
    public final ConflatedFlow<Boolean> d;
    public final ConflatedFlow<Unit> e;
    public final Lazy f;
    public final MutexImpl g;
    public final MutableSharedFlow<Event> h;

    public abstract com.larus.bmhome.social.page.datasource.event.a b();

    public abstract a<T, Key> c();

    public abstract f<T, Key> d();

    public FlowPagingManager() {
        this.a = LazyKt.lazy(new b(this));
        this.b = LazyKt.lazy(new c(this));
        this.c = new ConcurrentLinkedQueue();
        this.d = new ConflatedFlow(null);
        this.e = new ConflatedFlow(null);
        this.f = LazyKt.lazy(new d(this));
        this.g = kotlinx.coroutines.sync.b.a();
        this.h = SharedFlowKt.MutableSharedFlow$default(0, Integer.MAX_VALUE, null, 5, null);
        new FlowPagingManager$flow$1(this, null);
    }

    public static final Object a(FlowPagingManager r4, com.larus.bmhome.social.page.datasource.event.e r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof FlowPagingManager$executeOperation$1) == false) goto L7;
        FlowPagingManager$executeOperation$1 r0 = (FlowPagingManager$executeOperation$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.larus.bmhome.social.page.datasource.event.e r8 = (com.larus.bmhome.social.page.datasource.event.e) r0.L$1;
        r4 = (FlowPagingManager) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L23:
        g r9 = (g) r7;
        return r4.b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r4;
        r0.L$1 = r5;
        r0.label = 1;
        if ((r5 instanceof com.larus.bmhome.social.page.datasource.event.e.b) == false) goto L19;
        Object r10 = ((LoadStateHolder) r4.f.getValue()).b(((com.larus.bmhome.social.page.datasource.event.e.b) r5).a, r0);
    L17:
        r7 = r10;
        if (r7 != r2) goto L23;
        return r2;
    L19:
        if ((r5 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L26;
        r10 = ((LoadStateHolder) r4.f.getValue()).a((com.larus.bmhome.social.page.datasource.event.e.a) r5, r0);
        goto L17
    L26:
        throw new NoWhenBranchMatchedException();
    L7:
        r0 = new FlowPagingManager$executeOperation$1(r4, r6);
        goto L8
    }
}
