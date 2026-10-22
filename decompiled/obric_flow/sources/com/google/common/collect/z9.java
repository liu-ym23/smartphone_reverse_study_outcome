package com.google.common.collect;

import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: classes2.dex */
public final class z9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y9 f9250a;

    public final void a(y9 r5, y9 r10) {
        if (this.f9250a != r5) goto L7;
        this.f9250a = r10;
        return;
    L7:
        throw new ConcurrentModificationException();
    }
}
