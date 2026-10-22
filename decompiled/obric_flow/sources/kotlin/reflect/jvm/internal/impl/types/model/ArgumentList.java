package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public ArgumentList(int r5) {
        super(r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r5) {
        if ((r5 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return contains((TypeArgumentMarker) r5);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r5) {
        if ((r5 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return indexOf((TypeArgumentMarker) r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r5) {
        if ((r5 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((TypeArgumentMarker) r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r5) {
        if ((r5 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return remove((TypeArgumentMarker) r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(TypeArgumentMarker r5) {
        return super.contains(r5);
    }

    public /* bridge */ int indexOf(TypeArgumentMarker r5) {
        return super.indexOf(r5);
    }

    public /* bridge */ int lastIndexOf(TypeArgumentMarker r5) {
        return super.lastIndexOf(r5);
    }

    public /* bridge */ boolean remove(TypeArgumentMarker r5) {
        return super.remove(r5);
    }
}
