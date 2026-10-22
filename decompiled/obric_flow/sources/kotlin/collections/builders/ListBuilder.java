package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003PQRB\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001d\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J\u0014\u0010%\u001a\u00020\u000f2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\"H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0013\u0010*\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010+H\u0096\u0002J\u0016\u0010,\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\tH\u0016J\u0015\u0010/\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u000fH\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010:\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0015\u0010;\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0002\u0010-J\u0015\u0010<\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010-J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0002J\u0016\u0010@\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J.\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010B\u001a\u00020\u000fH\u0002J\u001e\u0010C\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\fH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\f\"\u0004\b\u0001\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\fH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020+H\u0002R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006S"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "(I)V", "backing", "", "[Ljava/lang/Object;", "isReadOnly", "", "length", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacityInternal", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "BuilderSubList", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = null;
    private static final ListBuilder Empty = null;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001PBA\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J&\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u001d\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0016J\u0014\u0010(\u001a\u00020\u00132\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010,H\u0096\u0002J\u0016\u0010-\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u000bH\u0016J\u0015\u00100\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0013H\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0096\u0002J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000107H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0001072\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u00020\u001bH\u0002J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010:\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0015\u0010;\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010.J\u0015\u0010<\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0016\u0010@\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J.\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010B\u001a\u00020\u0013H\u0002J\u001e\u0010C\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\tH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\t\"\u0004\b\u0002\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\tH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020,H\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006Q"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isReadOnly", "", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "checkForComodification", "checkIsMutable", "clear", "contentEquals", "other", "", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", ExifInterface.LONGITUDE_EAST, "", "list", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "index", "", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$BuilderSubList$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
        public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList<E> list;

            public Itr(BuilderSubList<E> r5, int r10) {
                Intrinsics.checkNotNullParameter(r5, "list");
                this.list = r5;
                this.index = r10;
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(r5);
            }

            private final void checkForComodification() {
                if (ListBuilder.m591access$getModCount$p$s2084097795(BuilderSubList.access$getRoot$p(this.list)) != this.expectedModCount) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }

            @Override // java.util.ListIterator
            public void add(E r5) {
                checkForComodification();
                BuilderSubList<E> r10 = this.list;
                int r11 = this.index;
                this.index = r11 + 1;
                r10.add(r11, r5);
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
                int r5 = this.index;
                this.index = r5 + 1;
                this.lastIndex = r5;
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
                int r5 = this.index;
                if (r5 <= 0) goto L7;
                int r10 = r5 - 1;
                this.index = r10;
                this.lastIndex = r10;
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
                int r5 = this.lastIndex;
                if (r5 == (-1)) goto L7;
                this.list.remove(r5);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = BuilderSubList.access$getModCount$p$s1462993667(this.list);
                return;
            L7:
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }

            @Override // java.util.ListIterator
            public void set(E r5) {
                checkForComodification();
                int r10 = this.lastIndex;
                if (r10 == (-1)) goto L7;
                this.list.set(r10, r5);
                return;
            L7:
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
        }

        public BuilderSubList(E[] r5, int r10, int r11, BuilderSubList<E> r12, ListBuilder<E> r13) {
            Intrinsics.checkNotNullParameter(r5, "backing");
            Intrinsics.checkNotNullParameter(r13, "root");
            this.backing = r5;
            this.offset = r10;
            this.length = r11;
            this.parent = r12;
            this.root = r13;
            ((AbstractList) this).modCount = ListBuilder.m591access$getModCount$p$s2084097795(r13);
        }

        public static final /* synthetic */ Object[] access$getBacking$p(BuilderSubList r5) {
            return r5.backing;
        }

        public static final /* synthetic */ int access$getLength$p(BuilderSubList r5) {
            return r5.length;
        }

        public static final /* synthetic */ int access$getModCount$p$s1462993667(BuilderSubList r5) {
            return ((AbstractList) r5).modCount;
        }

        public static final /* synthetic */ int access$getOffset$p(BuilderSubList r5) {
            return r5.offset;
        }

        public static final /* synthetic */ ListBuilder access$getRoot$p(BuilderSubList r5) {
            return r5.root;
        }

        private final void addAllInternal(int r5, Collection<? extends E> r10, int r11) {
            registerModification();
            BuilderSubList<E> r12 = this.parent;
            if (r12 == null) goto L5;
            r12.addAllInternal(r5, r10, r11);
        L6:
            this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
            this.length += r11;
            return;
        L5:
            ListBuilder.access$addAllInternal(this.root, r5, r10, r11);
            goto L6
        }

        private final void addAtInternal(int r5, E r10) {
            registerModification();
            BuilderSubList<E> r11 = this.parent;
            if (r11 == null) goto L5;
            r11.addAtInternal(r5, r10);
        L6:
            this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
            this.length++;
            return;
        L5:
            ListBuilder.access$addAtInternal(this.root, r5, r10);
            goto L6
        }

        private final void checkForComodification() {
            if (ListBuilder.m591access$getModCount$p$s2084097795(this.root) != ((AbstractList) this).modCount) goto L6;
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

        private final boolean contentEquals(List<?> r5) {
            return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, r5);
        }

        private final boolean isReadOnly() {
            return ListBuilder.access$isReadOnly$p(this.root);
        }

        private final void registerModification() {
            ((AbstractList) this).modCount++;
        }

        private final E removeAtInternal(int r5) {
            registerModification();
            BuilderSubList<E> r10 = this.parent;
            if (r10 == null) goto L5;
            E r11 = r10.removeAtInternal(r5);
        L6:
            this.length--;
            return r11;
        L5:
            r11 = (E) ListBuilder.access$removeAtInternal(this.root, r5);
            goto L6
        }

        private final void removeRangeInternal(int r5, int r10) {
            if (r10 <= 0) goto L4;
            registerModification();
        L4:
            BuilderSubList<E> r11 = this.parent;
            if (r11 == null) goto L7;
            r11.removeRangeInternal(r5, r10);
        L8:
            this.length -= r10;
            return;
        L7:
            ListBuilder.access$removeRangeInternal(this.root, r5, r10);
            goto L8
        }

        private final int retainOrRemoveAllInternal(int r5, int r10, Collection<? extends E> r11, boolean r12) {
            BuilderSubList<E> r13 = this.parent;
            if (r13 == null) goto L5;
            int r14 = r13.retainOrRemoveAllInternal(r5, r10, r11, r12);
        L6:
            if (r14 <= 0) goto L8;
            registerModification();
        L8:
            this.length -= r14;
            return r14;
        L5:
            r14 = ListBuilder.access$retainOrRemoveAllInternal(this.root, r5, r10, r11, r12);
            goto L6
        }

        private final Object writeReplace() {
            if (isReadOnly() == false) goto L7;
            return new SerializedCollection(this, 0);
        L7:
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E r5) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, r5);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            int r10 = r5.size();
            addAllInternal(this.offset + this.length, r5, r10);
            if (r10 <= 0) goto L5;
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
        public boolean equals(Object r5) {
            checkForComodification();
            if (r5 != this) goto L5;
        L10:
            return true;
        L5:
            if ((r5 instanceof List) == true) goto L7;
        L9:
            return false;
        L7:
            if (contentEquals((List) r5) == false) goto L9;
            goto L9
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r5) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, this.length);
            return this.backing[this.offset + r5];
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
        public int indexOf(Object r5) {
            checkForComodification();
            int r10 = 0;
        L4:
            if (r10 >= this.length) goto L9;
            if (Intrinsics.areEqual(this.backing[this.offset + r10], r5) == true) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return r10;
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
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r5) {
            checkForComodification();
            int r10 = this.length - 1;
        L3:
            if (r10 < 0) goto L8;
            if (Intrinsics.areEqual(this.backing[this.offset + r10], r5) == true) goto L6;
            r10 = r10 - 1;
            goto L3
        L6:
            return r10;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r5) {
            checkIsMutable();
            checkForComodification();
            int r10 = indexOf(r5);
            if (r10 < 0) goto L5;
            remove(r10);
        L5:
            if (r10 < 0) goto L7;
            return true;
        L7:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, r5, false) <= 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // kotlin.collections.AbstractMutableList
        public E removeAt(int r5) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, this.length);
            return removeAtInternal(this.offset + r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, r5, true) > 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public E set(int r5, E r10) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, this.length);
            E[] r11 = this.backing;
            int r12 = this.offset;
            E r13 = r11[r12 + r5];
            r11[r12 + r5] = r10;
            return r13;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int r10, int r11) {
            kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r10, r11, this.length);
            return new BuilderSubList(this.backing, this.offset + r10, r11 - r10, this, this.root);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] r5) {
            Intrinsics.checkNotNullParameter(r5, "array");
            checkForComodification();
            int r10 = r5.length;
            int r11 = this.length;
            if (r10 >= r11) goto L6;
            E[] r12 = this.backing;
            int r13 = this.offset;
            return (T[]) Arrays.copyOfRange(r12, r13, r11 + r13, r5.getClass());
        L6:
            E[] r14 = this.backing;
            int r15 = this.offset;
            ArraysKt.copyInto(r14, r5, 0, r15, r11 + r15);
            return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int r5) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r5, this.length);
            return new Itr(this, r5);
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public void add(int r5, E r10) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r5, this.length);
            addAtInternal(this.offset + r5, r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r5, Collection<? extends E> r10) {
            Intrinsics.checkNotNullParameter(r10, "elements");
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r5, this.length);
            int r11 = r10.size();
            addAllInternal(this.offset + r5, r10, r11);
            if (r11 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] r5 = this.backing;
            int r10 = this.offset;
            return ArraysKt.copyOfRange(r5, r10, this.length + r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", ExifInterface.LONGITUDE_EAST, "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "list");
            this.list = r5;
            this.index = r10;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m591access$getModCount$p$s2084097795(r5);
        }

        private final void checkForComodification() {
            if (ListBuilder.m591access$getModCount$p$s2084097795(this.list) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public void add(E r5) {
            checkForComodification();
            ListBuilder<E> r10 = this.list;
            int r11 = this.index;
            this.index = r11 + 1;
            r10.add(r11, r5);
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m591access$getModCount$p$s2084097795(this.list);
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
            int r5 = this.index;
            this.index = r5 + 1;
            this.lastIndex = r5;
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
            int r5 = this.index;
            if (r5 <= 0) goto L7;
            int r10 = r5 - 1;
            this.index = r10;
            this.lastIndex = r10;
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
            int r5 = this.lastIndex;
            if (r5 == (-1)) goto L7;
            this.list.remove(r5);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m591access$getModCount$p$s2084097795(this.list);
            return;
        L7:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        @Override // java.util.ListIterator
        public void set(E r5) {
            checkForComodification();
            int r10 = this.lastIndex;
            if (r10 == (-1)) goto L7;
            this.list.set(r10, r5);
            return;
        L7:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    static {
        Companion = new Companion(null);
        ListBuilder r5 = new ListBuilder(0);
        r5.isReadOnly = true;
        Empty = r5;
    }

    public ListBuilder() {
        int r5 = 0;
        this(r5, 1, null);
    }

    public static final /* synthetic */ void access$addAllInternal(ListBuilder r5, int r10, Collection r11, int r12) {
        r5.addAllInternal(r10, r11, r12);
    }

    public static final /* synthetic */ void access$addAtInternal(ListBuilder r5, int r10, Object r11) {
        r5.addAtInternal(r10, r11);
    }

    public static final /* synthetic */ Object[] access$getBacking$p(ListBuilder r5) {
        return r5.backing;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r5) {
        return r5.length;
    }

    /* JADX INFO: renamed from: access$getModCount$p$s-2084097795, reason: not valid java name */
    public static final /* synthetic */ int m591access$getModCount$p$s2084097795(ListBuilder r5) {
        return ((AbstractList) r5).modCount;
    }

    public static final /* synthetic */ boolean access$isReadOnly$p(ListBuilder r5) {
        return r5.isReadOnly;
    }

    public static final /* synthetic */ Object access$removeAtInternal(ListBuilder r5, int r10) {
        return r5.removeAtInternal(r10);
    }

    public static final /* synthetic */ void access$removeRangeInternal(ListBuilder r5, int r10, int r11) {
        r5.removeRangeInternal(r10, r11);
    }

    public static final /* synthetic */ int access$retainOrRemoveAllInternal(ListBuilder r5, int r10, int r11, Collection r12, boolean r13) {
        return r5.retainOrRemoveAllInternal(r10, r11, r12, r13);
    }

    private final void addAllInternal(int r5, Collection<? extends E> r10, int r11) {
        registerModification();
        insertAtInternal(r5, r11);
        Iterator<? extends E> r12 = r10.iterator();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        this.backing[r5 + r13] = r12.next();
        r13 = r13 + 1;
        goto L3
    }

    private final void addAtInternal(int r5, E r10) {
        registerModification();
        insertAtInternal(r5, 1);
        this.backing[r5] = r10;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final boolean contentEquals(List<?> r5) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, r5);
    }

    private final void ensureCapacityInternal(int r5) {
        if (r5 < 0) goto L8;
        E[] r10 = this.backing;
        if (r5 <= r10.length) goto L9;
        int r11 = kotlin.collections.AbstractList.Companion.newCapacity$kotlin_stdlib(r10.length, r5);
        this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, r11);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r5) {
        ensureCapacityInternal(this.length + r5);
    }

    private final void insertAtInternal(int r5, int r10) {
        ensureExtraCapacity(r10);
        E[] r11 = this.backing;
        ArraysKt.copyInto(r11, r11, r5 + r10, r5, this.length);
        this.length += r10;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final E removeAtInternal(int r5) {
        registerModification();
        E[] r10 = this.backing;
        E r11 = r10[r5];
        ArraysKt.copyInto(r10, r10, r5, r5 + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return r11;
    }

    private final void removeRangeInternal(int r5, int r10) {
        if (r10 <= 0) goto L4;
        registerModification();
    L4:
        E[] r11 = this.backing;
        ArraysKt.copyInto(r11, r11, r5, r5 + r10, this.length);
        E[] r12 = this.backing;
        int r13 = this.length;
        ListBuilderKt.resetRange(r12, r13 - r10, r13);
        this.length -= r10;
    }

    private final int retainOrRemoveAllInternal(int r10, int r11, Collection<? extends E> r12, boolean r13) {
        int r5 = 0;
        int r14 = 0;
    L3:
        if (r5 >= r11) goto L8;
        int r15 = r10 + r5;
        if (r12.contains(this.backing[r15]) == r13) goto L6;
        r5 = r5 + 1;
        goto L3
    L6:
        E[] r16 = this.backing;
        r5 = r5 + 1;
        r16[r14 + r10] = r16[r15];
        r14 = r14 + 1;
        goto L3
    L8:
        int r17 = r11 - r14;
        E[] r18 = this.backing;
        ArraysKt.copyInto(r18, r18, r10 + r14, r11 + r10, this.length);
        E[] r19 = this.backing;
        int r20 = this.length;
        ListBuilderKt.resetRange(r19, r20 - r17, r20);
        if (r17 <= 0) goto L11;
        registerModification();
    L11:
        this.length -= r17;
        return r17;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r5) {
        checkIsMutable();
        addAtInternal(this.length, r5);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        checkIsMutable();
        int r10 = r5.size();
        addAllInternal(this.length, r5, r10);
        if (r10 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length <= 0) goto L6;
        return this;
    L6:
        return Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r5 instanceof List) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((List) r5) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r5) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, this.length);
        return this.backing[r5];
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
    public int indexOf(Object r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.backing[r10], r5) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
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
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        int r10 = this.length - 1;
    L3:
        if (r10 < 0) goto L8;
        if (Intrinsics.areEqual(this.backing[r10], r5) == true) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r10;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r5) {
        checkIsMutable();
        int r10 = indexOf(r5);
        if (r10 < 0) goto L5;
        remove(r10);
    L5:
        if (r10 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r5, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r5) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, this.length);
        return removeAtInternal(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r5, true) > 0) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r5, E r10) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, this.length);
        E[] r11 = this.backing;
        E r12 = r11[r5];
        r11[r5] = r10;
        return r12;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r10, int r11) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r10, r11, this.length);
        return new BuilderSubList(this.backing, r10, r11 - r10, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        int r10 = r5.length;
        int r11 = this.length;
        if (r10 < r11) goto L5;
        ArraysKt.copyInto(this.backing, r5, 0, 0, r11);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r5);
    L5:
        return (T[]) Arrays.copyOfRange(this.backing, 0, r11, r5.getClass());
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, this);
    }

    public ListBuilder(int r5) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r5) {
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r5, this.length);
        return new Itr(this, r5);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r5, E r10) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r5, this.length);
        addAtInternal(r5, r10);
    }

    public /* synthetic */ ListBuilder(int r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = 10;
    L5:
        this(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r5, Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r5, this.length);
        int r11 = r10.size();
        addAllInternal(r5, r10, r11);
        if (r11 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }
}
