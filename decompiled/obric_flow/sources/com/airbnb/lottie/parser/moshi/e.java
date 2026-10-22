package com.airbnb.lottie.parser.moshi;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashTreeMap f1319a;

    public e(LinkedHashTreeMap r5) {
        this.f1319a = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f1319a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        if ((r5 instanceof Map.Entry) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1319a.findByEntry((Map.Entry) r5) == null) goto L7;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new d(this.f1319a, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        if ((r5 instanceof Map.Entry) == true) goto L5;
        return false;
    L5:
        LinkedHashTreeMap r10 = this.f1319a;
        g r11 = r10.findByEntry((Map.Entry) r5);
        if (r11 != null) goto L8;
        return false;
    L8:
        r10.removeInternal(r11, true);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f1319a.size;
    }
}
