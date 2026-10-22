package com.bytedance.android.annie.container.fragment;

import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements dr7.d {
    public final /* synthetic */ AnnieFragment a;

    public h(AnnieFragment r1) {
        this.a = r1;
    }

    public final void a(hr7.c r10) {
        AnnieFragment r0 = this.a;
        WeakHandler r1 = r0.D;
        if (r1 == null) goto L6;
        r1.post(new g(r10, r0));
        return;
    }
}
