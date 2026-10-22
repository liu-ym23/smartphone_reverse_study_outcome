package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class u6 extends d6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f9185c;

    public u6(ReferenceQueue r5, Object r10, int r11, u6 r12) {
        super(r5, r10, r11, r12);
        this.f9185c = null;
    }

    @Override // com.google.common.collect.h6
    public final Object getValue() {
        return this.f9185c;
    }
}
