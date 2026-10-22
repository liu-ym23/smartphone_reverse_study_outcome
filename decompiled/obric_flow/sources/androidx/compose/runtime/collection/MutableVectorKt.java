package androidx.compose.runtime.collection;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u001a \u0010\u0010\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", ExifInterface.GPS_DIRECTION_TRUE, "capacity", "", "size", "init", "Lkotlin/Function1;", "mutableVectorOf", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "checkIndex", "", "", "index", "checkSubIndex", "fromIndex", "toIndex", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMutableVector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n*L\n1#1,1194:1\n1161#1,2:1195\n*S KotlinDebug\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n*L\n1182#1:1195,2\n*E\n"})
public final class MutableVectorKt {
    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int r5) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[r5], 0);
    }

    public static /* synthetic */ MutableVector MutableVector$default(int r5, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = 16;
    L5:
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[r5], 0);
    }

    public static final /* synthetic */ void access$checkIndex(List r5, int r10) {
        checkIndex(r5, r10);
    }

    public static final /* synthetic */ void access$checkSubIndex(List r5, int r10, int r11) {
        checkSubIndex(r5, r10, r11);
    }

    private static final void checkIndex(List<?> r5, int r10) {
        int r11 = r5.size();
        if (r10 < 0) goto L7;
        if (r10 >= r11) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException("Index " + r10 + " is out of bounds. The list has " + r11 + " elements.");
    }

    private static final void checkSubIndex(List<?> r5, int r10, int r11) {
        int r12 = r5.size();
        if (r10 > r11) goto L12;
        if (r10 < 0) goto L10;
        if (r11 > r12) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r11 + ") is more than than the list size (" + r12 + ')');
    L10:
        throw new IndexOutOfBoundsException(j0.h(r10, "fromIndex (", ") is less than 0."));
    L12:
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + r10 + ") is greater than toIndex (" + r11 + ").");
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return new MutableVector(r5, r5.length);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int r5, Function1<? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "init");
        int r11 = 0;
        Intrinsics.reifiedOperationMarker(0, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] r12 = new Object[r5];
    L3:
        if (r11 >= r5) goto L6;
        r12[r11] = r10.invoke(Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return new MutableVector(r12, r5);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[16], 0);
    }
}
