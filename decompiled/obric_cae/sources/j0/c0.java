package j0;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements Iterator<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f8377b;

    public c0(ViewGroup r8) {
        this.f8377b = r8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8376a >= this.f8377b.getChildCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final View next() {
        int r8 = this.f8376a;
        this.f8376a = r8 + 1;
        View r10 = this.f8377b.getChildAt(r8);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int r8 = this.f8376a - 1;
        this.f8376a = r8;
        this.f8377b.removeViewAt(r8);
    }
}
