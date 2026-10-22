package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements l0 {
    public final String a;
    public final ResourcePhase b;

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return false;
    }

    public p() {
        this.a = "remote_resolve";
        this.b = ResourcePhase.REMOTE_RESOLVE;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return this.a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2.c instanceof j0.c) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.a.d.k.d == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r8, Continuation<? super g> r9) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        Set r2 = ServiceManager.get().getServices(ResourceRemoteResolver.class, true);     // Catch: Throwable -> L15
        if (r2 != null) goto L6;
        r2 = SetsKt.emptySet();     // Catch: Throwable -> L15
    L6:
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L15
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();     // Catch: Throwable -> L15
        if (((ResourceRemoteResolver) r4).b(r8.a.a, r8.c.getType(), r8.a.c) == false) goto L8;
    L13:
        Object r5 = Result.constructor-impl((ResourceRemoteResolver) r4);     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.e("ResourceAccessPipeline", "[remoteResolve] collect resolver failed", r6);
    L21:
        if (Result.isFailure-impl(r5) == true) goto L24;
        r0 = r5;
    L24:
        ResourceRemoteResolver r7 = (ResourceRemoteResolver) r0;
        if (r7 != null) goto L28;
        FLogger.a.i("ResourceAccessPipeline", "[remoteResolve] no resolver, resourceInput=" + r8.c.getType());
        return g.e.a;
    L28:
        FLogger.a.i("ResourceAccessPipeline", "[remoteResolve] hit resolver=" + r7.getKey());
        return r7.a(r8, r9);
    L12:
        r4 = null;
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
