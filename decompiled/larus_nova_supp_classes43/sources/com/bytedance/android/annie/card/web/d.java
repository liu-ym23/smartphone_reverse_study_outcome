package com.bytedance.android.annie.card.web;

import com.bytedance.android.annie.api.card.IHybridComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements o7.c.a {
    public final /* synthetic */ WebComponent a;

    public d(WebComponent r1) {
        this.a = r1;
    }

    @Override // o7.c.a
    public final void a(int r10, int r11, int r12, int r13) {
        WebComponent r1 = this.a;
        IHybridComponent.b r0 = r1.m;
        if (r0 == null) goto L6;
        r0.a(r1, r10, r11, r12, r13);
        return;
    }
}
