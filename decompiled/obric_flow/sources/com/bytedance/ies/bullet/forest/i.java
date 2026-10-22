package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements com.bytedance.forest.interceptor.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zm.c f5404b;

    public i() {
        this.f5404b = new zm.c(3);
    }

    @Override // com.bytedance.forest.interceptor.a
    public final void c(w r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (r10.f4436l == false) goto L39;
        String r5 = null;
        if (r10.f4442r == true) goto L8;
    L12:
        w r11 = null;
    L13:
        if (r11 == null) goto L29;
        String r12 = r10.f4441q.getOriginUrl();
        Intrinsics.checkNotNullParameter(r12, "url");
        if (GeckoXAdapter.Companion.canParsed(r12) == false) goto L22;
        int r13 = StringsKt.r("?", 0, 6, r12);
        if (r13 == (-1)) goto L22;
        if (r12 == null) goto L21;
        r12 = r12.substring(0, r13);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L22:
        boolean r14 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        String r15 = r11.f4443t;
        Intrinsics.checkNotNull(r15);
        ResourceFrom r16 = r10.f4444u;
        if (r16 != ResourceFrom.d) goto L26;
        r16 = null;
    L26:
        if (r16 != null) goto L28;
        r16 = r10.f4445v;
    L28:
        com.bytedance.ies.bullet.preloadv2.redirect.a.c(r12, com.bytedance.ies.bullet.preloadv2.redirect.a.b(r15, r16));
    L29:
        Object r17 = r10.f4441q.getCustomParams().get("rl_container_uuid");
        if ((r17 instanceof String) == false) goto L32;
        r5 = (String) r17;
    L32:
        if (r5 != null) goto L35;
        r5 = r10.f4441q.getGroupId();
    L35:
        if (this.f5404b.e(r10.f4441q.getOriginUrl(), r5) != null) goto L38;
        return;
    L38:
        throw new ClassCastException();
    L8:
        if (r10.f4441q.getScene() != Scene.f) goto L12;
        if (com.lynx.tasm.behavior.utils.d.g(r10.f4443t) == false) goto L12;
        r11 = r10;
        goto L13
    }

    @Override // com.bytedance.forest.interceptor.a
    public final void d(String r5, com.bytedance.forest.model.t r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "requestParams");
    }
}
