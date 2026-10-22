package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j1 implements am3.c<ListTag.ListTagEcomViewContent> {
    public j1() {
    }

    public final Object decode(am3.g r7) throws Exception {
        ListTag.ListTagEcomViewContent r0 = new ListTag.ListTagEcomViewContent();
        r0.setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L9;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L7;
        r0.ecomViewTag = (py.k) vh7.f.a(r7, py.k.class);
        goto L3
    L7:
        am3.h.d(r4, r7);
        goto L3
    L9:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
