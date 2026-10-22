package qyb;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Iterator<View>, KMutableIterator {
    public int a;
    public final /* synthetic */ ViewGroup b;

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
        View r2 = r0.getChildAt(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ViewGroup r0 = this.b;
        int r1 = this.a - 1;
        this.a = r1;
        r0.removeViewAt(r1);
    }

    public b(ViewGroup r1) {
        this.b = r1;
    }
}
