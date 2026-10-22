package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B'\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/paging/ItemSnapshotList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "placeholdersBefore", "", "placeholdersAfter", "items", "", "(IILjava/util/List;)V", "getItems", "()Ljava/util/List;", "getPlaceholdersAfter", "()I", "getPlaceholdersBefore", "size", "getSize", "get", "index", "(I)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ItemSnapshotList<T> extends AbstractList<T> {
    private final List<T> items;
    private final int placeholdersAfter;
    private final int placeholdersBefore;

    public ItemSnapshotList(int r3, int r4, List<? extends T> r5) {
        List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "items");
        this.placeholdersBefore = r3;
        this.placeholdersAfter = r4;
        this.items = r6;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int r6) {
        boolean r0 = true;
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L28;
        int r3 = this.placeholdersBefore;
        if (r6 >= (this.items.size() + r3)) goto L15;
        if (r3 > r6) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L24;
        int r5 = this.placeholdersBefore + this.items.size();
        if (r6 >= size()) goto L22;
        if (r5 > r6) goto L22;
    L23:
        if (r0 == false) goto L26;
        return null;
    L26:
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + r6 + " in ItemSnapshotList of size " + size());
    L22:
        r0 = false;
        goto L23
    L24:
        return this.items.get(r6 - this.placeholdersBefore);
    L15:
        r4 = false;
        goto L16
    L28:
        return null;
    L5:
        if (r6 >= this.placeholdersBefore) goto L7;
        r2 = true;
        goto L9
    }

    public final List<T> getItems() {
        return this.items;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return (this.placeholdersBefore + this.items.size()) + this.placeholdersAfter;
    }
}
