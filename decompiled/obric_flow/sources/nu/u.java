package nu;

import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f20340c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString[] f20341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f20342b;

    public u(ByteString[] r5, int[] r10) {
        this.f20341a = r5;
        this.f20342b = r10;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r5) {
        if ((r5 instanceof ByteString) == true) goto L5;
        return false;
    L5:
        return super.contains((ByteString) r5);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r5) {
        return this.f20341a[r5];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f20341a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r5) {
        if ((r5 instanceof ByteString) == true) goto L5;
        return -1;
    L5:
        return super.indexOf((ByteString) r5);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r5) {
        if ((r5 instanceof ByteString) == true) goto L5;
        return -1;
    L5:
        return super.lastIndexOf((ByteString) r5);
    }
}
