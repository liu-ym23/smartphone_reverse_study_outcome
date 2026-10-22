package com.bytedance.ttnet.utils;

import ai.i0;
import ai.j0;
import ai.q0;
import com.bumptech.glide.load.engine.bitmap_recycle.f;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ei.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wa.a f7540a;

    @Override // ei.b
    public final q0 intercept(ei.a r10) {
        long r5 = System.currentTimeMillis();
        wa.a r11 = this.f7540a;
        String r12 = r11.getClass().getName();
        String r13 = r12.substring(r12.lastIndexOf(46) + 1, r12.length());
        ((i0) ((f) r10).f).P.put(j0.j(r13, "Time"), Long.valueOf(r5));
        return r11.intercept(r10);
    }
}
