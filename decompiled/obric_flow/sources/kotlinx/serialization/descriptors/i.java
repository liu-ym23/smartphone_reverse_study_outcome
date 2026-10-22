package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.internal.x;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f19238b;

    public i(x r5) {
        this.f19238b = r5;
        this.f19237a = r5.f19254c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f19237a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        x r5 = this.f19238b;
        int r10 = this.f19237a;
        this.f19237a = r10 - 1;
        return r5.e[r5.f19254c - r10];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
