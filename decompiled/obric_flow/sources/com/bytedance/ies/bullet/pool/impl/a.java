package com.bytedance.ies.bullet.pool.impl;

import com.bytedance.forest.utils.m;
import com.bytedance.ies.bullet.pool.b;
import com.bytedance.ies.bullet.pool.c;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import kotlin.jvm.internal.Intrinsics;
import ug.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5817a;

    public a() {
        this.f5817a = new e(4);
    }

    public final void a(final String r5, final c r10, b r11) {
        Intrinsics.checkNotNullParameter(r5, "cacheKey");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "preRenderOp");
        e r12 = this.f5817a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "uniqueSchema");
        m r13 = (m) r12.f22361b;
        if (r13.get(r5) == null) goto L24;
        Intrinsics.checkNotNullParameter(r5, "uniqueSchema");
        com.bytedance.ies.bullet.service.base.e r14 = (com.bytedance.ies.bullet.service.base.e) r13.get(r5);
        BulletContainerView r15 = null;
        if (r14 == null) goto L7;
        BulletContainerView r16 = r14.f5986c;
    L8:
        if (r16 == null) goto L10;
        r15 = r16;
    L10:
        if (r15 == null) goto L13;
        String r17 = r15.getSessionId();
        if (r17 == null) goto L13;
    L14:
        r10.onSuccess(r17);
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "PreRender cacheKey " + r5 + " already exists", "XPreRender");
        return;
    L13:
        r17 = "";
        goto L14
    L7:
        r16 = null;
        goto L8
    L24:
        r11.mo2invoke(r5, new KeyPreRenderPool$preRender$1(this, r5, r10));     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Intrinsics.checkNotNullParameter(r5, "uniqueSchema");
        if (r13.get(r5) == null) goto L22;
        r12.f(r5);
    L22:
        r10.c(PoolResult.f5924c, e.getMessage());
    }
}
