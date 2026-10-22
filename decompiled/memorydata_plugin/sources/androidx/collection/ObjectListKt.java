package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u0007H\u0086\b\u001a\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000b\u001a'\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\f\u001a\u0002H\u0007¢\u0006\u0002\u0010\r\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\u000e\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000f\u001a.\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0001\"\u0002H\u0007H\u0086\b¢\u0006\u0002\u0010\u0011\u001a\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u0007\u001a\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\f\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001a/\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\u000e\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0001\"\u0002H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a \u0010\u001c\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"EmptyArray", "", "", "[Ljava/lang/Object;", "EmptyObjectList", "Landroidx/collection/ObjectList;", "emptyObjectList", ExifInterface.LONGITUDE_EAST, "mutableObjectListOf", "Landroidx/collection/MutableObjectList;", "element1", "(Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "elements", "([Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "objectListOf", "(Ljava/lang/Object;)Landroidx/collection/ObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)Landroidx/collection/ObjectList;", "checkIndex", "", "", "index", "", "checkSubIndex", "fromIndex", "toIndex", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObjectListKt {
    private static final Object[] EmptyArray = null;
    private static final ObjectList<Object> EmptyObjectList = null;

    static {
        EmptyArray = new Object[0];
        EmptyObjectList = (ObjectList) ZeusTransformUtils.preCheckCast(new MutableObjectList(0), ObjectList.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$checkIndex(List r2, int r3) {
        checkIndex((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final /* synthetic */ void access$checkSubIndex(List r2, int r3, int r4) {
        checkSubIndex((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static final /* synthetic */ Object[] access$getEmptyArray$p() {
        return EmptyArray;
    }

    private static final void checkIndex(List<?> r3, int r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r4 < 0) goto L7;
        if (r4 >= r5) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException("Index " + r4 + " is out of bounds. The list has " + r5 + " elements.");
    }

    private static final void checkSubIndex(List<?> r2, int r3, int r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size();
        if (r3 > r4) goto L12;
        if (r3 < 0) goto L10;
        if (r4 > r5) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r4 + ") is more than than the list size (" + r5 + ')');
    L10:
        throw new IndexOutOfBoundsException("fromIndex (" + r3 + ") is less than 0.");
    L12:
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + r3 + ") is greater than toIndex (" + r4 + ").");
    }

    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<E> r0 = (ObjectList<E>) EmptyObjectList;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return r0;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList(0, 1, null);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E r2) {
        MutableObjectList<E> r0 = new MutableObjectList(1);
        r0.add(r2);
        return r0;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E r2, E r3) {
        MutableObjectList<E> r0 = new MutableObjectList(2);
        r0.add(r2);
        r0.add(r3);
        return r0;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E r2, E r3, E r4) {
        MutableObjectList<E> r0 = new MutableObjectList(3);
        r0.add(r2);
        r0.add(r3);
        r0.add(r4);
        return r0;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableObjectList<E> r0 = new MutableObjectList(r2.length);
        r0.plusAssign(r2);
        return r0;
    }

    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<E> r0 = (ObjectList<E>) EmptyObjectList;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return r0;
    }

    public static final <E> ObjectList<E> objectListOf(E r2) {
        return (ObjectList) ZeusTransformUtils.preCheckCast(mutableObjectListOf(r2), ObjectList.class, "com.obric.memorydata.plugin");
    }

    public static final <E> ObjectList<E> objectListOf(E r1, E r2) {
        return (ObjectList) ZeusTransformUtils.preCheckCast(mutableObjectListOf(r1, r2), ObjectList.class, "com.obric.memorydata.plugin");
    }

    public static final <E> ObjectList<E> objectListOf(E r0, E r1, E r2) {
        return (ObjectList) ZeusTransformUtils.preCheckCast(mutableObjectListOf(r0, r1, r2), ObjectList.class, "com.obric.memorydata.plugin");
    }

    public static final <E> ObjectList<E> objectListOf(E... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableObjectList r0 = new MutableObjectList(r2.length);
        r0.plusAssign(r2);
        return (ObjectList) ZeusTransformUtils.preCheckCast(r0, ObjectList.class, "com.obric.memorydata.plugin");
    }
}
