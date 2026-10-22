package com.bumptech.glide.load.engine;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable f1567b;

    public /* synthetic */ v(Iterable r5, int r10) {
        this.f1566a = r10;
        this.f1567b = r5;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch(this.f1566a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new com.google.common.base.x(this);
    L7:
        return ((ArrayList) this.f1567b).iterator();
    }
}
