package kq9;

import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSelectionMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final AlbumSelectItem a;
    public final AlbumSelectionMediaType b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AlbumSelectionEventItem(albumItem=" + this.a + ", mediaType=" + this.b + ')';
    }

    public d(AlbumSelectItem r2, AlbumSelectionMediaType r3) {
        Intrinsics.checkNotNullParameter(r2, "albumItem");
        Intrinsics.checkNotNullParameter(r3, "mediaType");
        this.a = r2;
        this.b = r3;
    }
}
