package kotlin.collections.builders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003PQRB\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001d\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J\u0014\u0010%\u001a\u00020\u000f2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\"H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0013\u0010*\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010+H\u0096\u0002J\u0016\u0010,\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\tH\u0016J\u0015\u0010/\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u000fH\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010:\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0015\u0010;\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0002\u0010-J\u0015\u0010<\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010-J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0002J\u0016\u0010@\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J.\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010B\u001a\u00020\u000fH\u0002J\u001e\u0010C\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\fH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\f\"\u0004\b\u0001\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\fH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020+H\u0002R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006S"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "(I)V", "backing", "", "[Ljava/lang/Object;", "isReadOnly", "", XSDatatype.FACET_LENGTH, "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacityInternal", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "BuilderSubList", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements Serializable, List<E>, RandomAccess, KMutableList {
    private static final Companion Companion = null;
    private static final ListBuilder Empty = null;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001PBA\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J&\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u001d\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0016J\u0014\u0010(\u001a\u00020\u00132\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010,H\u0096\u0002J\u0016\u0010-\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u000bH\u0016J\u0015\u00100\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0013H\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0096\u0002J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000107H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0001072\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u00020\u001bH\u0002J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010:\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0015\u0010;\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010.J\u0015\u0010<\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0016\u0010@\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J.\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010B\u001a\u00020\u0013H\u0002J\u001e\u0010C\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\tH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\t\"\u0004\b\u0002\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\tH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020,H\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006Q"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", TypedValues.CycleType.S_WAVE_OFFSET, "", XSDatatype.FACET_LENGTH, "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isReadOnly", "", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "checkForComodification", "checkIsMutable", "clear", "contentEquals", "other", "", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements Serializable, List<E>, RandomAccess, KMutableList {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", ExifInterface.LONGITUDE_EAST, "", Constants.KEY_LIST, "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "index", "", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList<E> list;

            public Itr(BuilderSubList<E> r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, Constants.KEY_LIST);
                this.list = r2;
                this.index = r3;
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(r2);
            }

            private final void checkForComodification() {
                if (ListBuilder.m1888access$getModCount$p$s2084097795(BuilderSubList.access$getRoot$p(this.list)) != this.expectedModCount) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.ListIterator
            public void add(E r4) {
                checkForComodification();
                BuilderSubList<E> r0 = this.list;
                int r1 = this.index;
                this.index = r1 + 1;
                r0.add(r1, r4);
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(this.list);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                if (this.index >= BuilderSubList.access$getLength$p(this.list)) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                if (this.index <= 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                checkForComodification();
                if (this.index >= BuilderSubList.access$getLength$p(this.list)) goto L7;
                int r0 = this.index;
                this.index = r0 + 1;
                this.lastIndex = r0;
                return (E) BuilderSubList.access$getBacking$p(this.list)[BuilderSubList.access$getOffset$p(this.list) + this.lastIndex];
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.index;
            }

            @Override // java.util.ListIterator
            public E previous() {
                checkForComodification();
                int r0 = this.index;
                if (r0 <= 0) goto L7;
                int r1 = r0 - 1;
                this.index = r1;
                this.lastIndex = r1;
                return (E) BuilderSubList.access$getBacking$p(this.list)[BuilderSubList.access$getOffset$p(this.list) + this.lastIndex];
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.index - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                checkForComodification();
                int r0 = this.lastIndex;
                if (r0 == (-1)) goto L5;
                boolean r2 = true;
            L6:
                if (r2 == false) goto L10;
                this.list.remove(r0);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(this.list);
                return;
            L10:
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            L5:
                r2 = false;
                goto L6
            }

            @Override // java.util.ListIterator
            public void set(E r3) {
                checkForComodification();
                int r0 = this.lastIndex;
                if (r0 == (-1)) goto L5;
                boolean r1 = true;
            L6:
                if (r1 == false) goto L10;
                this.list.set(r0, r3);
                return;
            L10:
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            L5:
                r1 = false;
                goto L6
            }
        }

        public BuilderSubList(E[] r2, int r3, int r4, BuilderSubList<E> r5, ListBuilder<E> r6) {
            Intrinsics.checkNotNullParameter(r2, "backing");
            Intrinsics.checkNotNullParameter(r6, "root");
            this.backing = r2;
            this.offset = r3;
            this.length = r4;
            this.parent = r5;
            this.root = r6;
            this.modCount = ListBuilder.m1888access$getModCount$p$s2084097795(r6);
        }

        public static final /* synthetic */ Object[] access$getBacking$p(BuilderSubList r0) {
            return r0.backing;
        }

        public static final /* synthetic */ int access$getLength$p(BuilderSubList r0) {
            return r0.length;
        }

        public static final /* synthetic */ int access$getModCount$p$s1462993667(BuilderSubList r0) {
            return r0.modCount;
        }

        public static final /* synthetic */ int access$getOffset$p(BuilderSubList r0) {
            return r0.offset;
        }

        public static final /* synthetic */ ListBuilder access$getRoot$p(BuilderSubList r0) {
            return r0.root;
        }

        private final void addAllInternal(int r3, Collection<? extends E> r4, int r5) {
            Collection<? extends E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            registerModification();
            BuilderSubList<E> r0 = this.parent;
            if (r0 == null) goto L5;
            r0.addAllInternal(r3, r6, r5);
        L6:
            this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
            this.length += r5;
            return;
        L5:
            ListBuilder.access$addAllInternal(this.root, r3, r6, r5);
            goto L6
        }

        private final void addAtInternal(int r2, E r3) {
            registerModification();
            BuilderSubList<E> r0 = this.parent;
            if (r0 == null) goto L5;
            r0.addAtInternal(r2, r3);
        L6:
            this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
            this.length++;
            return;
        L5:
            ListBuilder.access$addAtInternal(this.root, r2, r3);
            goto L6
        }

        private final void checkForComodification() {
            if (ListBuilder.m1888access$getModCount$p$s2084097795(this.root) != this.modCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        private final void checkIsMutable() {
            if (isReadOnly() == true) goto L6;
            return;
        L6:
            throw new UnsupportedOperationException();
        }

        private final boolean contentEquals(List<?> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, r4);
        }

        private final boolean isReadOnly() {
            return ListBuilder.access$isReadOnly$p(this.root);
        }

        private final void registerModification() {
            this.modCount++;
        }

        private final E removeAtInternal(int r2) {
            registerModification();
            BuilderSubList<E> r0 = this.parent;
            if (r0 == null) goto L5;
            E r3 = r0.removeAtInternal(r2);
        L6:
            this.length--;
            return r3;
        L5:
            r3 = (E) ListBuilder.access$removeAtInternal(this.root, r2);
            goto L6
        }

        private final void removeRangeInternal(int r2, int r3) {
            if (r3 <= 0) goto L4;
            registerModification();
        L4:
            BuilderSubList<E> r0 = this.parent;
            if (r0 == null) goto L7;
            r0.removeRangeInternal(r2, r3);
        L8:
            this.length -= r3;
            return;
        L7:
            ListBuilder.access$removeRangeInternal(this.root, r2, r3);
            goto L8
        }

        private final int retainOrRemoveAllInternal(int r3, int r4, Collection<? extends E> r5, boolean r6) {
            Collection<? extends E> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            BuilderSubList<E> r0 = this.parent;
            if (r0 == null) goto L5;
            int r8 = r0.retainOrRemoveAllInternal(r3, r4, r7, r6);
        L6:
            if (r8 <= 0) goto L8;
            registerModification();
        L8:
            this.length -= r8;
            return r8;
        L5:
            r8 = ListBuilder.access$retainOrRemoveAllInternal(this.root, r3, r4, r7, r6);
            goto L6
        }

        private final Object writeReplace() {
            if (isReadOnly() == false) goto L7;
            return new SerializedCollection((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"), 0);
        L7:
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public void add(int r3, E r4) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
            addAtInternal(this.offset + r3, r4);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E r3) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, r3);
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r3, Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
            int r0 = r5.size();
            addAllInternal(this.offset + r3, r5, r0);
            if (r0 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            int r0 = r5.size();
            addAllInternal(this.offset + this.length, r5, r0);
            if (r0 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r3) {
            checkForComodification();
            if (r3 != this) goto L5;
        L10:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L7;
        L9:
            return false;
        L7:
            if (contentEquals((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")) == false) goto L9;
            goto L9
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r3) {
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
            return this.backing[this.offset + r3];
        }

        @Override // kotlin.collections.AbstractMutableList
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            checkForComodification();
            int r0 = 0;
        L4:
            if (r0 >= this.length) goto L9;
            if (Intrinsics.areEqual(this.backing[this.offset + r0], r4) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            if (this.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(listIterator(0), Iterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r4) {
            checkForComodification();
            int r0 = this.length - 1;
        L3:
            if (r0 < 0) goto L8;
            if (Intrinsics.areEqual(this.backing[this.offset + r0], r4) == true) goto L6;
            r0 = r0 - 1;
            goto L3
        L6:
            return r0;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int r3) {
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
            return (ListIterator) ZeusTransformUtils.preCheckCast(new Itr(this, r3), ListIterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r1) {
            checkIsMutable();
            checkForComodification();
            int r2 = indexOf(r1);
            if (r2 < 0) goto L5;
            remove(r2);
        L5:
            if (r2 < 0) goto L7;
            return true;
        L7:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<? extends Object> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, r5, false) <= 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // kotlin.collections.AbstractMutableList
        public E removeAt(int r3) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
            return removeAtInternal(this.offset + r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<? extends Object> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, r5, true) > 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public E set(int r3, E r4) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
            E[] r0 = this.backing;
            int r2 = this.offset;
            E r1 = r0[r2 + r3];
            r0[r2 + r3] = r4;
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int r9, int r10) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r9, r10, this.length);
            return (List) ZeusTransformUtils.preCheckCast(new BuilderSubList(this.backing, this.offset + r9, r10 - r9, this, this.root), List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] r0 = this.backing;
            int r1 = this.offset;
            return ArraysKt.copyOfRange(r0, r1, this.length + r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] r5) {
            Intrinsics.checkNotNullParameter(r5, "array");
            checkForComodification();
            int r0 = r5.length;
            int r1 = this.length;
            if (r0 >= r1) goto L6;
            E[] r2 = this.backing;
            int r4 = this.offset;
            T[] r6 = (T[]) Arrays.copyOfRange(r2, r4, r1 + r4, r5.getClass());
            Intrinsics.checkNotNullExpressionValue(r6, "copyOfRange(...)");
            return r6;
        L6:
            E[] r3 = this.backing;
            int r7 = this.offset;
            ArraysKt.copyInto(r3, r5, 0, r7, r1 + r7);
            return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, (Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", ExifInterface.LONGITUDE_EAST, "", Constants.KEY_LIST, "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, Constants.KEY_LIST);
            this.list = r2;
            this.index = r3;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m1888access$getModCount$p$s2084097795(r2);
        }

        private final void checkForComodification() {
            if (ListBuilder.m1888access$getModCount$p$s2084097795(this.list) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public void add(E r4) {
            checkForComodification();
            ListBuilder<E> r0 = this.list;
            int r1 = this.index;
            this.index = r1 + 1;
            r0.add(r1, r4);
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m1888access$getModCount$p$s2084097795(this.list);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L7;
            int r0 = this.index;
            this.index = r0 + 1;
            this.lastIndex = r0;
            return (E) ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int r0 = this.index;
            if (r0 <= 0) goto L7;
            int r1 = r0 - 1;
            this.index = r1;
            this.lastIndex = r1;
            return (E) ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 == (-1)) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            this.list.remove(r0);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m1888access$getModCount$p$s2084097795(this.list);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r2 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void set(E r3) {
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            this.list.set(r0, r3);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
        ListBuilder r0 = new ListBuilder(0);
        r0.isReadOnly = true;
        Empty = r0;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    public ListBuilder(int r1) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(r1);
    }

    public /* synthetic */ ListBuilder(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 10;
    L5:
        this(r1);
    }

    public static final /* synthetic */ void access$addAllInternal(ListBuilder r2, int r3, Collection r4, int r5) {
        r2.addAllInternal(r3, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"), r5);
    }

    public static final /* synthetic */ void access$addAtInternal(ListBuilder r0, int r1, Object r2) {
        r0.addAtInternal(r1, r2);
    }

    public static final /* synthetic */ Object[] access$getBacking$p(ListBuilder r0) {
        return r0.backing;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r0) {
        return r0.length;
    }

    /* JADX INFO: renamed from: access$getModCount$p$s-2084097795, reason: not valid java name */
    public static final /* synthetic */ int m1888access$getModCount$p$s2084097795(ListBuilder r0) {
        return r0.modCount;
    }

    public static final /* synthetic */ boolean access$isReadOnly$p(ListBuilder r0) {
        return r0.isReadOnly;
    }

    public static final /* synthetic */ Object access$removeAtInternal(ListBuilder r0, int r1) {
        return r0.removeAtInternal(r1);
    }

    public static final /* synthetic */ void access$removeRangeInternal(ListBuilder r0, int r1, int r2) {
        r0.removeRangeInternal(r1, r2);
    }

    public static final /* synthetic */ int access$retainOrRemoveAllInternal(ListBuilder r2, int r3, int r4, Collection r5, boolean r6) {
        return r2.retainOrRemoveAllInternal(r3, r4, (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin"), r6);
    }

    private final void addAllInternal(int r5, Collection<? extends E> r6, int r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        registerModification();
        insertAtInternal(r5, r7);
        Iterator<E> r9 = r8.iterator();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        this.backing[r5 + r0] = r9.next();
        r0 = r0 + 1;
        goto L3
    }

    private final void addAtInternal(int r2, E r3) {
        registerModification();
        insertAtInternal(r2, 1);
        this.backing[r2] = r3;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final boolean contentEquals(List<?> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, r4);
    }

    private final void ensureCapacityInternal(int r3) {
        if (r3 < 0) goto L8;
        if (r3 <= this.backing.length) goto L9;
        int r4 = AbstractList.Companion.newCapacity$kotlin_stdlib(this.backing.length, r3);
        this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, r4);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r2) {
        ensureCapacityInternal(this.length + r2);
    }

    private final void insertAtInternal(int r4, int r5) {
        ensureExtraCapacity(r5);
        E[] r0 = this.backing;
        ArraysKt.copyInto(r0, r0, r4 + r5, r4, this.length);
        this.length += r5;
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final E removeAtInternal(int r5) {
        registerModification();
        E[] r0 = this.backing;
        E r1 = r0[r5];
        ArraysKt.copyInto(r0, r0, r5, r5 + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return r1;
    }

    private final void removeRangeInternal(int r4, int r5) {
        if (r5 <= 0) goto L4;
        registerModification();
    L4:
        E[] r0 = this.backing;
        ArraysKt.copyInto(r0, r0, r4, r4 + r5, this.length);
        E[] r6 = this.backing;
        int r1 = this.length;
        ListBuilderKt.resetRange(r6, r1 - r5, r1);
        this.length -= r5;
    }

    private final int retainOrRemoveAllInternal(int r6, int r7, Collection<? extends E> r8, boolean r9) {
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L8;
        int r3 = r6 + r0;
        if (r10.contains(this.backing[r3]) == r9) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        E[] r2 = this.backing;
        r0 = r0 + 1;
        r2[r1 + r6] = r2[r3];
        r1 = r1 + 1;
        goto L3
    L8:
        int r11 = r7 - r1;
        E[] r12 = this.backing;
        ArraysKt.copyInto(r12, r12, r6 + r1, r7 + r6, this.length);
        E[] r13 = this.backing;
        int r14 = this.length;
        ListBuilderKt.resetRange(r13, r14 - r11, r14);
        if (r11 <= 0) goto L11;
        registerModification();
    L11:
        this.length -= r11;
        return r11;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedCollection((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"), 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r3, E r4) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        addAtInternal(r3, r4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r2) {
        checkIsMutable();
        addAtInternal(this.length, r2);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        int r0 = r5.size();
        addAllInternal(r3, r5, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        int r0 = r4.size();
        addAllInternal(this.length, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length > 0) goto L7;
        ListBuilder<E> this = Empty;
    L7:
        return (List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L9:
        return true;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return this.backing[r3];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.backing[r0], r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(listIterator(0), Iterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r3) {
        int r0 = this.length - 1;
    L3:
        if (r0 < 0) goto L8;
        if (Intrinsics.areEqual(this.backing[r0], r3) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r3) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        return (ListIterator) ZeusTransformUtils.preCheckCast(new Itr(this, r3), ListIterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        checkIsMutable();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        remove(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r4, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r3) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return removeAtInternal(r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r5, true) > 0) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        E[] r2 = this.backing;
        E r0 = r2[r3];
        r2[r3] = r4;
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r9, int r10) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r9, r10, this.length);
        return (List) ZeusTransformUtils.preCheckCast(new BuilderSubList(this.backing, r9, r10 - r9, null, this), List.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r4) {
        Intrinsics.checkNotNullParameter(r4, "array");
        int r0 = r4.length;
        int r1 = this.length;
        if (r0 >= r1) goto L6;
        T[] r3 = (T[]) Arrays.copyOfRange(this.backing, 0, r1, r4.getClass());
        Intrinsics.checkNotNullExpressionValue(r3, "copyOfRange(...)");
        return r3;
    L6:
        ArraysKt.copyInto(this.backing, r4, 0, 0, r1);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r4);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, (Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"));
    }
}
