package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d5 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f8937b;

    public /* synthetic */ d5(Iterator r5, int r10) {
        this.f8936a = r10;
        this.f8937b = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f8936a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8937b.hasNext();
    L7:
        return this.f8937b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f8936a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        Map.Entry r5 = (Map.Entry) this.f8937b.next();
        r5.getClass();
        return new e7(r5);
    L7:
        return this.f8937b.next();
    }
}
