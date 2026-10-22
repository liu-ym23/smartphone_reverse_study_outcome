package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class MviRepository<Entity, OPT extends c<Entity>, event extends b> {
    public final String a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final CoroutinesSafe e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public abstract Entity a();

    public final CoroutineScope d() {
        return (CoroutineScope) this.c.getValue();
    }

    public final d1<event> e() {
        return (d1) this.g.getValue();
    }

    public final CoroutineScope f() {
        return (CoroutineScope) this.b.getValue();
    }

    public final i1<Entity> g() {
        return (i1) this.i.getValue();
    }

    public final Entity h() {
        return (Entity) ((z0) this.h.getValue()).getValue();
    }

    public MviRepository() {
        this.a = getClass().getSimpleName() + '_' + hashCode();
        this.b = LazyKt.lazy(MviRepository$repoIOScope$2.INSTANCE);
        this.c = LazyKt.lazy(new MviRepository$mainUIScope$2(this));
        Lazy r0 = LazyKt.lazy(MviRepository$repoCpuScope$2.INSTANCE);
        this.d = r0;
        this.e = new CoroutinesSafe((CoroutineScope) r0.getValue());
        this.f = LazyKt.lazy(MviRepository$repoEventMutableFlow$2.INSTANCE);
        this.g = LazyKt.lazy(new MviRepository$repoEventFlow$2(this));
        this.h = LazyKt.lazy(new MviRepository$stateMutableFlow$2(this));
        this.i = LazyKt.lazy(new MviRepository$stateFlow$2(this));
    }

    public final void i() {
        CoroutineScopeKt.cancel$default(f(), null, 1, null);
        CoroutineScopeKt.cancel$default(d(), null, 1, null);
        CoroutineScopeKt.cancel$default((CoroutineScope) this.d.getValue(), null, 1, null);
        kotlinx.coroutines.channels.a r0 = this.e.b;
        if (r0 == null) goto L6;
        SendChannel.a.a(r0);
        return;
    }

    public String c() {
        return this.a;
    }

    public final void j(Function1<? super Continuation<? super Unit>, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.e.c(r2);
    }

    public final Object b(Entity r2, Continuation<? super Unit> r3) {
        Object r4 = ((z0) this.h.getValue()).emit(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object k(event r2, Continuation<? super Unit> r3) {
        Object r4 = ((MutableSharedFlow) this.f.getValue()).emit(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
