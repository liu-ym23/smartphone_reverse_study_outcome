package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003678B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J#\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002J\u001c\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010#J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0016\u0010$\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002J\u001c\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0013\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0015\u0010'\u001a\u00028\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010(J/\u0010)\u001a\u00020\u000f2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\f0+H\u0086\bø\u0001\u0000J\u001a\u0010.\u001a\u00020\u000f2\b\b\u0001\u0010/\u001a\u00020\u00042\b\b\u0001\u00100\u001a\u00020\u0004J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ \u00102\u001a\u00028\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u0004R\u0012\u0010\u0006\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"Landroidx/collection/MutableObjectList;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ObjectList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", Constants.KEY_LIST, "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)Z", "(I[Ljava/lang/Object;)Z", "", "", "", "Lkotlin/sequences/Sequence;", "asList", "asMutableList", "", "clear", "ensureCapacity", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeIf", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "removeRange", CommonConsts.APM_INNER_EVENT_COST_START, "end", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "trim", "minCapacity", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", Constants.KEY_LIST, "", "index", "", "(Ljava/util/List;I)V", "prevIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MutableObjectListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> r3, int r4) {
            List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, Constants.KEY_LIST);
            this.list = r5;
            this.prevIndex = r4 - 1;
        }

        @Override // java.util.ListIterator
        public void add(T r3) {
            List<T> r0 = this.list;
            int r1 = this.prevIndex + 1;
            this.prevIndex = r1;
            r0.add(r1, r3);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.prevIndex < (this.list.size() - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.prevIndex < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> r0 = this.list;
            int r1 = this.prevIndex + 1;
            this.prevIndex = r1;
            return r0.get(r1);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> r0 = this.list;
            int r1 = this.prevIndex;
            this.prevIndex = r1 - 1;
            return r0.get(r1);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T r2) {
            this.list.set(this.prevIndex, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0096\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006*"}, d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", ExifInterface.GPS_DIRECTION_TRUE, "", "objectList", "Landroidx/collection/MutableObjectList;", "(Landroidx/collection/MutableObjectList;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ObjectListMutableList<T> implements List<T>, KMutableList {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "objectList");
            this.objectList = r2;
        }

        @Override // java.util.List
        public void add(int r1, T r2) {
            this.objectList.add(r1, r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r1) {
            return this.objectList.add(r1);
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends T> r4) {
            Collection<? extends T> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            return this.objectList.addAll(r3, r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            return this.objectList.addAll((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r1) {
            return this.objectList.contains(r1);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            return this.objectList.containsAll((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.List
        public T get(int r3) {
            ObjectListKt.access$checkIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r3);
            return this.objectList.get(r3);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object r1) {
            return this.objectList.indexOf(r1);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(new MutableObjectListIterator((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), 0), Iterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public int lastIndexOf(Object r1) {
            return this.objectList.lastIndexOf(r1);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return (ListIterator) ZeusTransformUtils.preCheckCast(new MutableObjectListIterator((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), 0), ListIterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r4) {
            return (ListIterator) ZeusTransformUtils.preCheckCast(new MutableObjectListIterator((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r4), ListIterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public final T remove(int r1) {
            return removeAt(r1);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r1) {
            return this.objectList.remove(r1);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            return this.objectList.removeAll((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        public T removeAt(int r3) {
            ObjectListKt.access$checkIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r3);
            return this.objectList.removeAt(r3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> r3) {
            Collection<? extends T> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            return this.objectList.retainAll(r4);
        }

        @Override // java.util.List
        public T set(int r3, T r4) {
            ObjectListKt.access$checkIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r3);
            return this.objectList.set(r3, r4);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int r4, int r5) {
            ObjectListKt.access$checkSubIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r4, r5);
            return (List) ZeusTransformUtils.preCheckCast(new SubList((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r4, r5), List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r3) {
            Intrinsics.checkNotNullParameter(r3, "array");
            return (T[]) CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0096\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/collection/MutableObjectList$SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", Constants.KEY_LIST, CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> r3, int r4, int r5) {
            List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, Constants.KEY_LIST);
            this.list = r6;
            this.start = r4;
            this.end = r5;
        }

        @Override // java.util.List
        public void add(int r3, T r4) {
            this.list.add(r3 + this.start, r4);
            this.end++;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r4) {
            List<T> r0 = this.list;
            int r1 = this.end;
            this.end = r1 + 1;
            r0.add(r1, r4);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends T> r4) {
            Collection<? extends T> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            this.list.addAll(r3 + this.start, r5);
            this.end += r5.size();
            if (r5.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r3) {
            Collection<? extends T> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            this.list.addAll(this.end, r4);
            this.end += r4.size();
            if (r4.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int r0 = this.end - 1;
            int r1 = this.start;
            if (r1 > r0) goto L7;
        L4:
            this.list.remove(r0);
            if (r0 == r1) goto L7;
            r0 = r0 - 1;
        L7:
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r4) {
            int r0 = this.start;
            int r1 = this.end;
        L3:
            if (r0 >= r1) goto L9;
            if (Intrinsics.areEqual(this.list.get(r0), r4) == true) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            Iterator<T> r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            if (contains(r5.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.List
        public T get(int r3) {
            ObjectListKt.access$checkIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r3);
            return this.list.get(r3 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object r4) {
            int r0 = this.start;
            int r1 = this.end;
        L3:
            if (r0 >= r1) goto L9;
            if (Intrinsics.areEqual(this.list.get(r0), r4) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return r0 - this.start;
        L9:
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            if (this.end != this.start) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(new MutableObjectListIterator((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), 0), Iterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public int lastIndexOf(Object r4) {
            int r0 = this.end - 1;
            int r1 = this.start;
            if (r1 <= r0) goto L5;
            return -1;
        L5:
            if (Intrinsics.areEqual(this.list.get(r0), r4) == true) goto L7;
            if (r0 == r1) goto L14;
            r0 = r0 - 1;
            goto L5
        L14:
            return -1;
        L7:
            return r0 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return (ListIterator) ZeusTransformUtils.preCheckCast(new MutableObjectListIterator((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), 0), ListIterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r4) {
            return (ListIterator) ZeusTransformUtils.preCheckCast(new MutableObjectListIterator((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r4), ListIterator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List
        public final T remove(int r1) {
            return removeAt(r1);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r4) {
            int r0 = this.start;
            int r1 = this.end;
        L3:
            if (r0 >= r1) goto L9;
            if (Intrinsics.areEqual(this.list.get(r0), r4) == true) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            this.list.remove(r0);
            this.end--;
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            int r0 = this.end;
            Iterator<T> r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L7;
            remove(r6.next());
            goto L4
        L7:
            if (r0 == this.end) goto L9;
            return true;
        L9:
            return false;
        }

        public T removeAt(int r3) {
            ObjectListKt.access$checkIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r3);
            T r4 = this.list.remove(r3 + this.start);
            this.end--;
            return r4;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "elements");
            int r0 = this.end;
            int r1 = r0 - 1;
            int r2 = this.start;
            if (r2 > r1) goto L10;
        L5:
            if (r6.contains(this.list.get(r1)) == true) goto L7;
            this.list.remove(r1);
            this.end--;
        L7:
            if (r1 == r2) goto L10;
            r1 = r1 - 1;
        L10:
            if (r0 == this.end) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.List
        public T set(int r3, T r4) {
            ObjectListKt.access$checkIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r3);
            return this.list.set(r3 + this.start, r4);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int r4, int r5) {
            ObjectListKt.access$checkSubIndex((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r4, r5);
            return (List) ZeusTransformUtils.preCheckCast(new SubList((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin"), r4, r5), List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r3) {
            Intrinsics.checkNotNullParameter(r3, "array");
            return (T[]) CollectionToArray.toArray((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public MutableObjectList(int r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableObjectList(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 16;
    L5:
        this(r1);
    }

    public static /* synthetic */ void trim$default(MutableObjectList r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0._size;
    L5:
        r0.trim(r1);
    }

    public final void add(int r5, E r6) {
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == false) goto L14;
        ensureCapacity(this._size + 1);
        Object[] r1 = this.content;
        if (r5 == this._size) goto L11;
        ArraysKt.copyInto(r1, r1, r5 + 1, r5, this._size);
    L11:
        r1[r5] = r6;
        this._size++;
        return;
    L14:
        throw new IndexOutOfBoundsException("Index " + r5 + " must be in 0.." + this._size);
    L5:
        if (r5 > this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean add(E r4) {
        ensureCapacity(this._size + 1);
        this.content[this._size] = r4;
        this._size++;
        return true;
    }

    public final boolean addAll(int r6, ObjectList<E> r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L18;
        if (r7.isEmpty() == false) goto L12;
        return false;
    L12:
        ensureCapacity(this._size + r7._size);
        Object[] r3 = this.content;
        if (r6 == this._size) goto L15;
        ArraysKt.copyInto(r3, r3, r7._size + r6, r6, this._size);
    L15:
        ArraysKt.copyInto(r7.content, r3, r6, 0, r7._size);
        this._size += r7._size;
        return true;
    L18:
        throw new IndexOutOfBoundsException("Index " + r6 + " must be in 0.." + this._size);
    L5:
        if (r6 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean addAll(int r7, Collection<? extends E> r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "elements");
        int r2 = 0;
        if (r7 >= 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L25;
        if (r9.isEmpty() == false) goto L12;
        return false;
    L12:
        ensureCapacity(this._size + r9.size());
        Object[] r4 = this.content;
        if (r7 == this._size) goto L15;
        ArraysKt.copyInto(r4, r4, r9.size() + r7, r7, this._size);
    L15:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r1.hasNext() == false) goto L22;
        Object r5 = r1.next();
        int r6 = r2 + 1;
        if (r2 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r4[r2 + r7] = r5;
        r2 = r6;
        goto L17
    L22:
        this._size += r9.size();
        return true;
    L25:
        throw new IndexOutOfBoundsException("Index " + r7 + " must be in 0.." + this._size);
    L5:
        if (r7 > this._size) goto L7;
        r3 = true;
        goto L8
    }

    public final boolean addAll(int r10, E[] r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r10 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L21;
        if (r11.length != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return false;
    L15:
        ensureCapacity(this._size + r11.length);
        Object[] r4 = this.content;
        if (r10 == this._size) goto L18;
        ArraysKt.copyInto(r4, r4, r11.length + r10, r10, this._size);
    L18:
        ArraysKt.copyInto$default(r11, r4, r10, 0, 0, 12, null);
        this._size += r11.length;
        return true;
    L12:
        r3 = false;
        goto L13
    L21:
        throw new IndexOutOfBoundsException("Index " + r10 + " must be in 0.." + this._size);
    L5:
        if (r10 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean addAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(Iterable<? extends E> r3) {
        Iterable<? extends E> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = this._size;
        plusAssign(r4);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(List<? extends E> r3) {
        List<? extends E> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = this._size;
        plusAssign(r4);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(Sequence<? extends E> r3) {
        Sequence<? extends E> r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = this._size;
        plusAssign(r4);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(E[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> r0 = this.list;
        if (r0 != null) goto L7;
        r0 = new ObjectListMutableList(this);
        this.list = r0;
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public final void clear() {
        ArraysKt.fill(this.content, null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int r3) {
        Object[] r0 = this.content;
        if (r0.length >= r3) goto L6;
        Object[] r4 = Arrays.copyOf(r0, Math.max(r3, (r0.length * 3) / 2));
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.content = r4;
        return;
    }

    public final int getCapacity() {
        return this.content.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        Object[] r0 = r14.elements;
        long[] r15 = r14.metadata;
        int r1 = r15.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r15[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        remove(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        remove(r5.next());
        goto L4
    }

    public final void minusAssign(E r1) {
        remove(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(List<? extends E> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r5.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Sequence<? extends E> r3) {
        Sequence r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        remove(r5.next());
        goto L4
    }

    public final void minusAssign(E[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(ObjectList<E> r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        ensureCapacity(this._size + r6._size);
        ArraysKt.copyInto(r6.content, this.content, this._size, 0, r6._size);
        this._size += r6._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        if (r14.isEmpty() == false) goto L5;
        return;
    L5:
        ensureCapacity(this._size + r14.getSize());
        Object[] r0 = r14.elements;
        long[] r15 = r14.metadata;
        int r1 = r15.length - 2;
        if (r1 < 0) goto L22;
        int r3 = 0;
    L8:
        long r4 = r15[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L20;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L11:
        if (r8 >= r6) goto L19;
        if ((255 & r4) >= 128) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        add(r0[(r3 << 3) + r8]);
    L18:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L11
    L15:
        r9 = false;
        goto L16
    L19:
        if (r6 == 8) goto L20;
        return;
    L20:
        if (r3 == r1) goto L29;
        r3 = r3 + 1;
        goto L8
    L29:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        add(r5.next());
        goto L4
    }

    public final void plusAssign(E r1) {
        add(r1);
    }

    public final void plusAssign(List<? extends E> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "elements");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this._size;
        ensureCapacity(r8.size() + r0);
        Object[] r1 = this.content;
        int r2 = 0;
        int r3 = r8.size();
    L6:
        if (r2 >= r3) goto L8;
        r1[r2 + r0] = r8.get(r2);
        r2 = r2 + 1;
        goto L6
    L8:
        this._size += r8.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Sequence<? extends E> r3) {
        Sequence r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        add(r5.next());
        goto L4
    }

    public final void plusAssign(E[] r9) {
        Intrinsics.checkNotNullParameter(r9, "elements");
        if (r9.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        ensureCapacity(this._size + r9.length);
        ArraysKt.copyInto$default(r9, this.content, this._size, 0, 0, 12, null);
        this._size += r9.length;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean remove(E r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        removeAt(r2);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(Iterable<? extends E> r3) {
        Iterable<? extends E> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = this._size;
        minusAssign(r4);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(List<? extends E> r3) {
        List<? extends E> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = this._size;
        minusAssign(r4);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(Sequence<? extends E> r3) {
        Sequence<? extends E> r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = this._size;
        minusAssign(r4);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(E[] r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        remove(r6[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        if (r0 == this._size) goto L10;
        return true;
    L10:
        return false;
    }

    public final E removeAt(int r6) {
        boolean r0 = false;
        if (r6 < 0) goto L8;
        if (r6 >= this._size) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L15;
        Object[] r1 = this.content;
        E r3 = (E) r1[r6];
        if (r6 == (((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1)) goto L12;
        ArraysKt.copyInto(r1, r1, r6, r6 + 1, this._size);
    L12:
        this._size--;
        r1[this._size] = null;
        return r3;
    L15:
        throw new IndexOutOfBoundsException("Index " + r6 + " must be in 0.." + (((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1));
    }

    public final void removeIf(Function1<? super E, Boolean> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r0 = this._size;
        Object[] r2 = this.content;
        int r4 = 0;
        IntRange r3 = RangesKt.until(0, ((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size);
        int r5 = r3.getFirst();
        int r6 = r3.getLast();
        if (r5 > r6) goto L9;
    L4:
        r2[r5 - r4] = r2[r5];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r2[r5]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r4 = r4 + 1;
    L7:
        if (r5 == r6) goto L9;
        r5 = r5 + 1;
    L9:
        ArraysKt.fill(r2, null, r0 - r4, r0);
        this._size -= r4;
    }

    public final void removeRange(int r5, int r6) {
        boolean r0 = true;
        if (r5 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L26;
        if (r6 >= 0) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L26;
        if (r6 < r5) goto L24;
        if (r6 != r5) goto L19;
        return;
    L19:
        if (r6 >= this._size) goto L21;
        ArraysKt.copyInto(this.content, this.content, r5, r6, this._size);
    L21:
        int r1 = this._size - (r6 - r5);
        ArraysKt.fill(this.content, null, r1, this._size);
        this._size = r1;
        return;
    L24:
        throw new IllegalArgumentException("Start (" + r5 + ") is more than end (" + r6 + ')');
    L12:
        if (r6 > this._size) goto L14;
    L26:
        throw new IndexOutOfBoundsException("Start (" + r5 + ") and end (" + r6 + ") must be in 0.." + this._size);
    L5:
        if (r5 > this._size) goto L7;
        r2 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = ((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (r6.contains(r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 != this._size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean retainAll(Iterable<? extends E> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "elements");
        int r0 = this._size;
        Object[] r2 = this.content;
        int r1 = ((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1;
    L4:
        if ((-1) >= r1) goto L10;
        if (CollectionsKt.contains(r7, r2[r1]) == true) goto L8;
        removeAt(r1);
    L8:
        r1 = r1 - 1;
        goto L4
    L10:
        if (r0 != this._size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean retainAll(Collection<? extends E> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "elements");
        int r0 = this._size;
        Object[] r2 = this.content;
        int r1 = ((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1;
    L4:
        if ((-1) >= r1) goto L10;
        if (r7.contains(r2[r1]) == true) goto L8;
        removeAt(r1);
    L8:
        r1 = r1 - 1;
        goto L4
    L10:
        if (r0 != this._size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean retainAll(Sequence<? extends E> r6) {
        Sequence r7 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r6, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "elements");
        int r0 = this._size;
        Object[] r2 = this.content;
        int r1 = ((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1;
    L4:
        if ((-1) >= r1) goto L10;
        if (SequencesKt.contains(r7, r2[r1]) == true) goto L8;
        removeAt(r1);
    L8:
        r1 = r1 - 1;
        goto L4
    L10:
        if (r0 != this._size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean retainAll(E[] r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = ((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (ArraysKt.indexOf(r6, r1[r2]) >= 0) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 != this._size) goto L17;
        return false;
    L17:
        return true;
    }

    public final E set(int r4, E r5) {
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        Object[] r3 = this.content;
        E r0 = (E) r3[r4];
        r3[r4] = r5;
        return r0;
    L11:
        throw new IndexOutOfBoundsException("set index " + r4 + " must be between 0 .. " + (((ObjectList) ZeusTransformUtils.preCheckCast(this, ObjectList.class, "com.obric.memorydata.plugin"))._size - 1));
    L5:
        if (r4 >= this._size) goto L7;
        r1 = true;
        goto L7
    }

    public final void trim(int r2) {
        int r3 = Math.max(r2, this._size);
        if (this.content.length <= r3) goto L6;
        Object[] r4 = Arrays.copyOf(this.content, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.content = r4;
        return;
    }
}
