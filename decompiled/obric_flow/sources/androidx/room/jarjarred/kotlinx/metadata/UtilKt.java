package androidx.room.jarjarred.kotlinx.metadata;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u001e\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¨\u0006\u0006"}, d2 = {"assignFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "", "collection", "", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtilKt {
    public static final <T> void assignFrom(List<T> r5, Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "collection");
        r5.clear();
        r5.addAll(r10);
    }
}
