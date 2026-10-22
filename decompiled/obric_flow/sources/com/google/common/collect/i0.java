package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class i0 extends g7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9019c;
    public final /* synthetic */ z7 d;

    public /* synthetic */ i0(z7 r5, int r10) {
        this.f9019c = r10;
        this.d = r5;
        super(2);
    }

    @Override // com.google.common.collect.g7
    public z7 c() {
        switch(this.f9019c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return (o0) this.d;
    L7:
        return (j0) this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch(this.f9019c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((o0) this.d).d.descendingEntryIterator();
    L7:
        return ((j0) this.d).entryIterator();
    }

    @Override // com.google.common.collect.g7, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch(this.f9019c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((o0) this.d).d.entrySet().size();
    L7:
        return ((j0) this.d).distinctElements();
    }
}
