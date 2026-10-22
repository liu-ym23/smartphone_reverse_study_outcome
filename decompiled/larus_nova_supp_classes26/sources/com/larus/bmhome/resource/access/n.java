package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements l0 {
    public final ResourcePhase a;
    public final List<String> b;
    public final boolean c;

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "remote_fallback";
    }

    public n() {
        this.a = ResourcePhase.REMOTE_FALLBACK;
        this.b = CollectionsKt.listOf("remote_download");
        this.c = true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.c;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (s.a(r2.a.b.getType()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.h != null) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r5, Continuation<? super g> r6) {
        if (r5.a.d.k.e == false) goto L5;
        ResourceInputType r7 = r5.c.getType();
        StateFlowImpl r8 = s.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7 != ResourceInputType.LOCAL_PATH) goto L9;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == false) goto L16;
        return new g.c(new r("remote_fallback", "remote_fallback_to_local", "remote resource fallback to local pipeline", null));
    L16:
        return new g.b(new r("remote_fallback", "remote_fallback_unavailable", "remote resource cannot direct access and no local fallback source", null));
    L9:
        if (r7 == ResourceInputType.CONTENT_URI) goto L12;
        r9 = false;
        goto L13
    L5:
        return new g.b(new r("remote_fallback", "remote_fallback_disabled", "remote fallback is disabled", null));
    }
}
