package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public ArgumentList(int r10) {
        super(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return contains((TypeArgumentMarker) r10);
    }

    public /* bridge */ boolean contains(TypeArgumentMarker r10) {
        return super.contains(r10);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return indexOf((TypeArgumentMarker) r10);
    }

    public /* bridge */ int indexOf(TypeArgumentMarker r10) {
        return super.indexOf(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((TypeArgumentMarker) r10);
    }

    public /* bridge */ int lastIndexOf(TypeArgumentMarker r10) {
        return super.lastIndexOf(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r10) {
        if ((r10 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return remove((TypeArgumentMarker) r10);
    }

    public /* bridge */ boolean remove(TypeArgumentMarker r10) {
        return super.remove(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
