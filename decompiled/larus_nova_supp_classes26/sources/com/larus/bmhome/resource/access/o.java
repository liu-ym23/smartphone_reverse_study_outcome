package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements l0 {
    public final ResourcePhase a;
    public final List<String> b;
    public final boolean c;

    public static final class a {
        public final ResourceRouteDecision a;
        public final ResourceRouteReason b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ResourceRoute(decision=" + this.a + ", reason=" + this.b + ')';
        }

        public a(ResourceRouteDecision r2, ResourceRouteReason r3) {
            Intrinsics.checkNotNullParameter(r2, "decision");
            Intrinsics.checkNotNullParameter(r3, "reason");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "remote_policy";
    }

    public o() {
        this.a = ResourcePhase.POLICY;
        this.b = CollectionsKt.listOf("remote_resolve");
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
        return s.a(r2.c.getType());
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r11, Continuation<? super g> r12) {
        if (r11.h == null) goto L5;
        a r0 = new a(ResourceRouteDecision.DIRECT, ResourceRouteReason.ARTIFACT_READY);
    L26:
        Pair[] r7 = new Pair[3];
        String r13 = r11.a.d.m.get("remote_policy_version");
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        r7[0] = TuplesKt.to("remote_policy_version", r13);
        r7[1] = TuplesKt.to("route_decision", r0.a.getValue());
        r7[2] = TuplesKt.to("route_reason", r0.b.getValue());
        return new g.a(new i0(null, null, null, null, null, null, MapsKt.mapOf(r7), 63));
    L5:
        j0 r1 = r11.c;
        if ((r1 instanceof j0.d) == false) goto L9;
        r0 = new a(ResourceRouteDecision.DIRECT, ResourceRouteReason.TOS_KEY_DIRECT);
        goto L26
    L9:
        if ((r1 instanceof j0.c) == false) goto L19;
        v r2 = r11.a.d.k;
        boolean r8 = r2.d;
        if (r2.e == false) goto L17;
        ResourceRouteDecision r9 = ResourceRouteDecision.FALLBACK_DOWNLOAD;
        if (r8 == false) goto L15;
        ResourceRouteReason r10 = ResourceRouteReason.REMOTE_URL_NEEDS_LOCAL_SOURCE;
    L16:
        r0 = new a(r9, r10);
        goto L26
    L15:
        r10 = ResourceRouteReason.REMOTE_RESOLVE_DISABLED;
        goto L16
    L17:
        r0 = new a(ResourceRouteDecision.REJECT, ResourceRouteReason.REMOTE_FALLBACK_DISABLED);
        goto L26
    L19:
        if ((r1 instanceof j0.b) == false) goto L21;
    L25:
        r0 = new a(ResourceRouteDecision.SKIP, ResourceRouteReason.UNSUPPORTED_REMOTE_INPUT);
        goto L26
    L21:
        if ((r1 instanceof j0.a) == true) goto L25;
        throw new NoWhenBranchMatchedException();
    }
}
