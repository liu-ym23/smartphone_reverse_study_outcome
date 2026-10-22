package com.google.common.cache;

import java.util.AbstractQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends com.google.common.collect.n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractQueue f8762c;

    public /* synthetic */ r(AbstractQueue r5, v0 r10, int r11) {
        this.f8761b = r11;
        this.f8762c = r5;
        super(r10);
    }

    @Override // com.google.common.collect.n0
    public final Object a(Object r5) {
        switch(this.f8761b) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        v0 r10 = ((v0) r5).getNextInWriteQueue();
        if (r10 != ((q) ((s) this.f8762c).f8764b)) goto L12;
        return null;
    L12:
        return r10;
    L8:
        v0 r11 = ((v0) r5).getNextInAccessQueue();
        if (r11 != ((q) ((s) this.f8762c).f8764b)) goto L13;
        return null;
    L13:
        return r11;
    }
}
