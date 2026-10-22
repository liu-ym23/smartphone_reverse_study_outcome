package com.lark.kmp.rustclient.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class BaseRustDispatcher implements s {
    public final List<com.lark.kmp.rustclient.api.c> a;
    public final CoroutineDispatcher b;
    public final CoroutineDispatcher c;
    public final MutableSharedFlow<Pair<rpc.c, com.lark.kmp.rustclient.api.model.j>> d;
    public final buc.e<Map<Long, MutableSharedFlow<rpc.a>>> e;
    public final CoroutineScope f;

    @Override // com.lark.kmp.rustclient.internal.q
    public final boolean d(long r2) {
        return ((Map) this.e.c()).containsKey(Long.valueOf(r2));
    }

    @Override // com.lark.kmp.rustclient.internal.s
    public final MutableSharedFlow e(long r9) {
        buc.e<Map<Long, MutableSharedFlow<rpc.a>>> r0 = this.e;
    L3:
        Object r1 = r0.c();
        Map r2 = (Map) r1;
        if (r2.containsKey(Long.valueOf(r9)) == true) goto L8;
        r2 = MapsKt.plus(r2, TuplesKt.to(Long.valueOf(r9), SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null)));
    L8:
        if (r0.a(r1, r2) == false) goto L3;
        return (MutableSharedFlow) MapsKt.getValue(r2, Long.valueOf(r9));
    }

    public final void g(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public final void j(rpc.c r10) {
        Intrinsics.checkNotNullParameter(r10, "pushData");
        List<com.lark.kmp.rustclient.api.c> r0 = this.a;
        boolean r2 = false;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((com.lark.kmp.rustclient.api.c) r1.next()).a(r10) == false) goto L9;
        r2 = true;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        BuildersKt.launch$default(this.f, this.b, null, new BaseRustDispatcher$dispatchPush$2(this, r10, null), 2, null);
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final void k(rpc.a r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        System.out.println("kmp: handleCallback " + r8 + "  " + ((Map) this.e.c()).get(Long.valueOf(r8.a)));
        MutableSharedFlow r0 = (MutableSharedFlow) ((Map) this.e.c()).get(Long.valueOf(r8.a));
        if (r0 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f, this.c, null, new BaseRustDispatcher$handleCallback$1(r8, r0, this, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRustDispatcher(List<? extends com.lark.kmp.rustclient.api.c> r2, CoroutineDispatcher r3, CoroutineDispatcher r4) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r3, "pushDispatcher");
        Intrinsics.checkNotNullParameter(r4, "asyncDispatcher");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = buc.b.d(MapsKt.emptyMap());
        this.f = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }
}
