package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001eH\u0002¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"arrayOfUninitializedElements", "", ExifInterface.LONGITUDE_EAST, "size", "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", ExifInterface.GPS_DIRECTION_TRUE, "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", "offset", "length", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
public final class ListBuilderKt {
    public static final /* synthetic */ boolean access$subarrayContentEquals(Object[] r5, int r10, int r11, List r12) {
        return subarrayContentEquals(r5, r10, r11, r12);
    }

    public static final /* synthetic */ int access$subarrayContentHashCode(Object[] r5, int r10, int r11) {
        return subarrayContentHashCode(r5, r10, r11);
    }

    public static final /* synthetic */ String access$subarrayContentToString(Object[] r5, int r10, int r11, Collection r12) {
        return subarrayContentToString(r5, r10, r11, r12);
    }

    public static final <E> E[] arrayOfUninitializedElements(int r5) {
        if (r5 < 0) goto L6;
        return (E[]) new Object[r5];
    L6:
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final <T> T[] copyOfUninitializedElements(T[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (T[]) Arrays.copyOf(r5, r10);
    }

    public static final <E> void resetAt(E[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5[r10] = null;
    }

    public static final <E> void resetRange(E[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
    L3:
        if (r10 >= r11) goto L5;
        resetAt(r5, r10);
        r10 = r10 + 1;
        goto L3
    }

    private static final <T> boolean subarrayContentEquals(T[] r5, int r10, int r11, List<?> r12) {
        if (r11 == r12.size()) goto L5;
        return false;
    L5:
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L11;
        if (Intrinsics.areEqual(r5[r10 + r13], r12.get(r13)) == false) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static final <T> int subarrayContentHashCode(T[] r5, int r10, int r11) {
        int r12 = 1;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        T r14 = r5[r10 + r13];
        int r15 = r12 * 31;
        if (r14 == null) goto L7;
        int r16 = r14.hashCode();
    L8:
        r12 = r15 + r16;
        r13 = r13 + 1;
        goto L3
    L7:
        r16 = 0;
        goto L8
    L9:
        return r12;
    }

    private static final <T> String subarrayContentToString(T[] r5, int r10, int r11, Collection<? extends T> r12) {
        StringBuilder r13 = new StringBuilder((r11 * 3) + 2);
        r13.append("[");
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L11;
        if (r14 <= 0) goto L6;
        r13.append(", ");
    L6:
        T r15 = r5[r10 + r14];
        if (r15 != r12) goto L9;
        r13.append("(this Collection)");
    L10:
        r14 = r14 + 1;
        goto L3
    L9:
        r13.append(r15);
        goto L10
    L11:
        r13.append("]");
        return r13.toString();
    }
}
