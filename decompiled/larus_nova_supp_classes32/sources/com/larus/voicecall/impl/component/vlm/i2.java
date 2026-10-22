package com.larus.voicecall.impl.component.vlm;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i2 implements Iterator<View>, KMappedMarker {
    public int a;
    public final /* synthetic */ ViewGroup b;

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a >= this.b.getChildCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final View next() {
        ViewGroup r0 = this.b;
        int r1 = this.a;
        this.a = r1 + 1;
        return r0.getChildAt(r1);
    }

    public i2(ViewGroup r1) {
        this.b = r1;
    }
}
