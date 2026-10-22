package androidx.compose.runtime.collection;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003pqrB\u001f\b\u0001\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001b\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\bJ\u0019\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010$J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0017\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0086\bJ+\u0010'\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0006\u0010+\u001a\u00020\u001fJ\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0007J\u000b\u00102\u001a\u00028\u0000¢\u0006\u0002\u00103J0\u00102\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u00103J2\u00105\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104JS\u00106\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Jh\u0010?\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70@H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJS\u0010B\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Jh\u0010C\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70@H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJ+\u0010D\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J1\u0010F\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J+\u0010G\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J1\u0010H\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010I\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007H\u0086\n¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ+\u0010M\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J+\u0010N\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010O\u001a\u00020\u001cJ\u0006\u0010P\u001a\u00020\u001cJ\u000b\u0010Q\u001a\u00028\u0000¢\u0006\u0002\u00103J0\u0010Q\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0013\u0010R\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u0010\u0010S\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u00103J2\u0010S\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J>\u0010T\u001a\b\u0012\u0004\u0012\u0002H70\u0005\"\u0006\b\u0001\u00107\u0018\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010VJS\u0010W\u001a\b\u0012\u0004\u0012\u0002H70\u0005\"\u0006\b\u0001\u00107\u0018\u00012'\u0010U\u001a#\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010XJP\u0010Y\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0006\b\u0001\u00107\u0018\u00012)\u0010U\u001a%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J;\u0010Z\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0006\b\u0001\u00107\u0018\u00012\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010[\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\\J\u0013\u0010^\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0013\u0010`\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0002\u0010JJ\u0016\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007J\u0014\u0010d\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J+\u0010e\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u001e\u0010f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010gJ\u001e\u0010h\u001a\u00020\u001f2\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00028\u00000jj\b\u0012\u0004\u0012\u00028\u0000`kJ+\u0010l\u001a\u00020\u00072\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070)H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010n\u001a\u00020oH\u0001R.\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006s"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "getContent", "()[Ljava/lang/Object;", "setContent", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "list", "", "<set-?>", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "([Ljava/lang/Object;)Z", "", "", "any", "predicate", "Lkotlin/Function1;", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "minusAssign", "(Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "reversedAny", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "throwNoSuchElementException", "", "MutableVectorList", "SubList", "VectorListIterator", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMutableVector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1194:1\n48#1:1198\n48#1:1199\n523#1:1200\n53#1:1203\n523#1:1204\n48#1:1205\n523#1:1206\n523#1:1207\n523#1:1208\n48#1:1209\n523#1:1210\n48#1:1211\n523#1:1212\n523#1:1213\n523#1:1214\n48#1:1215\n523#1:1216\n48#1:1219\n48#1:1220\n48#1:1221\n523#1:1222\n1864#2,3:1195\n1855#2,2:1201\n1855#2,2:1217\n*S KotlinDebug\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n249#1:1198\n259#1:1199\n260#1:1200\n292#1:1203\n293#1:1204\n307#1:1205\n308#1:1206\n334#1:1207\n359#1:1208\n595#1:1209\n595#1:1210\n637#1:1211\n637#1:1212\n665#1:1213\n675#1:1214\n768#1:1215\n769#1:1216\n794#1:1219\n821#1:1220\n833#1:1221\n834#1:1222\n185#1:1195,3\n281#1:1201,2\n782#1:1217,2\n*E\n"})
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;
    private T[] content;
    private List<T> list;
    private int size;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0096\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", ExifInterface.GPS_DIRECTION_TRUE, "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMutableVector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector$MutableVectorList\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,1194:1\n523#2:1195\n*S KotlinDebug\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector$MutableVectorList\n*L\n941#1:1195\n*E\n"})
    public static final class MutableVectorList<T> implements List<T>, KMutableList {
        private final MutableVector<T> vector;

        public MutableVectorList(MutableVector<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "vector");
            this.vector = r5;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r5) {
            return this.vector.add(r5);
        }

        @Override // java.util.List
        public boolean addAll(int r5, Collection<? extends T> r10) {
            Intrinsics.checkNotNullParameter(r10, "elements");
            return this.vector.addAll(r5, r10);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.vector.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r5) {
            return this.vector.contains(r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            return this.vector.containsAll(r5);
        }

        @Override // java.util.List
        public T get(int r5) {
            MutableVectorKt.access$checkIndex(this, r5);
            return this.vector.getContent()[r5];
        }

        public int getSize() {
            return this.vector.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object r5) {
            return this.vector.indexOf(r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.vector.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r5) {
            return this.vector.lastIndexOf(r5);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r5) {
            return removeAt(r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            return this.vector.removeAll(r5);
        }

        public T removeAt(int r5) {
            MutableVectorKt.access$checkIndex(this, r5);
            return this.vector.removeAt(r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            return this.vector.retainAll(r5);
        }

        @Override // java.util.List
        public T set(int r5, T r10) {
            MutableVectorKt.access$checkIndex(this, r5);
            return this.vector.set(r5, r10);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int r5, int r10) {
            MutableVectorKt.access$checkSubIndex(this, r5, r10);
            return new SubList(this, r5, r10);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List
        public void add(int r5, T r10) {
            this.vector.add(r5, r10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            return this.vector.addAll(r5);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r5) {
            return new VectorListIterator(this, r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r5) {
            return this.vector.remove(r5);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r5) {
            Intrinsics.checkNotNullParameter(r5, "array");
            return (T[]) CollectionToArray.toArray(this, r5);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0096\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMutableVector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector$SubList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1194:1\n1855#2,2:1195\n1855#2,2:1197\n*S KotlinDebug\n*F\n+ 1 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector$SubList\n*L\n1013#1:1195,2\n1095#1:1197,2\n*E\n"})
    public static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> r5, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r5, "list");
            this.list = r5;
            this.start = r10;
            this.end = r11;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r5) {
            List<T> r10 = this.list;
            int r11 = this.end;
            this.end = r11 + 1;
            r10.add(r11, r5);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int r5, Collection<? extends T> r10) {
            Intrinsics.checkNotNullParameter(r10, "elements");
            this.list.addAll(r5 + this.start, r10);
            int r11 = this.end;
            this.end = r10.size() + r11;
            if (r10.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int r5 = this.end - 1;
            int r10 = this.start;
            if (r10 > r5) goto L7;
        L4:
            this.list.remove(r5);
            if (r5 == r10) goto L7;
            r5 = r5 - 1;
        L7:
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r5) {
            int r10 = this.start;
            int r11 = this.end;
        L3:
            if (r10 >= r11) goto L9;
            if (Intrinsics.areEqual(this.list.get(r10), r5) == true) goto L6;
            r10 = r10 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            Iterator<T> r10 = r5.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (contains(r10.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.List
        public T get(int r5) {
            MutableVectorKt.access$checkIndex(this, r5);
            return this.list.get(r5 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object r5) {
            int r10 = this.start;
            int r11 = this.end;
        L3:
            if (r10 >= r11) goto L9;
            if (Intrinsics.areEqual(this.list.get(r10), r5) == true) goto L7;
            r10 = r10 + 1;
            goto L3
        L7:
            return r10 - this.start;
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
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r5) {
            int r10 = this.end - 1;
            int r11 = this.start;
            if (r11 <= r10) goto L5;
            return -1;
        L5:
            if (Intrinsics.areEqual(this.list.get(r10), r5) == true) goto L7;
            if (r10 == r11) goto L14;
            r10 = r10 - 1;
            goto L5
        L14:
            return -1;
        L7:
            return r10 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r5) {
            return removeAt(r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            int r10 = this.end;
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            remove(r11.next());
            goto L4
        L7:
            if (r10 == this.end) goto L9;
            return true;
        L9:
            return false;
        }

        public T removeAt(int r5) {
            MutableVectorKt.access$checkIndex(this, r5);
            T r10 = this.list.remove(r5 + this.start);
            this.end--;
            return r10;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            int r10 = this.end;
            int r11 = r10 - 1;
            int r12 = this.start;
            if (r12 > r11) goto L10;
        L5:
            if (r5.contains(this.list.get(r11)) == true) goto L7;
            this.list.remove(r11);
            this.end--;
        L7:
            if (r11 == r12) goto L10;
            r11 = r11 - 1;
        L10:
            if (r10 == this.end) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.List
        public T set(int r5, T r10) {
            MutableVectorKt.access$checkIndex(this, r5);
            return this.list.set(r5 + this.start, r10);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int r5, int r10) {
            MutableVectorKt.access$checkSubIndex(this, r5, r10);
            return new SubList(this, r5, r10);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List
        public void add(int r5, T r10) {
            this.list.add(r5 + this.start, r10);
            this.end++;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r5) {
            return new VectorListIterator(this, r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r5) {
            int r10 = this.start;
            int r11 = this.end;
        L3:
            if (r10 >= r11) goto L9;
            if (Intrinsics.areEqual(this.list.get(r10), r5) == true) goto L6;
            r10 = r10 + 1;
            goto L3
        L6:
            this.list.remove(r10);
            this.end--;
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r5) {
            Intrinsics.checkNotNullParameter(r5, "array");
            return (T[]) CollectionToArray.toArray(this, r5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            this.list.addAll(this.end, r5);
            int r10 = this.end;
            this.end = r5.size() + r10;
            if (r5.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "", "index", "", "(Ljava/util/List;I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class VectorListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private int index;
        private final List<T> list;

        public VectorListIterator(List<T> r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "list");
            this.list = r5;
            this.index = r10;
        }

        @Override // java.util.ListIterator
        public void add(T r5) {
            this.list.add(this.index, r5);
            this.index++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.list.size()) goto L5;
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
        public T next() {
            List<T> r5 = this.list;
            int r10 = this.index;
            this.index = r10 + 1;
            return r5.get(r10);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int r5 = this.index - 1;
            this.index = r5;
            return this.list.get(r5);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int r5 = this.index - 1;
            this.index = r5;
            this.list.remove(r5);
        }

        @Override // java.util.ListIterator
        public void set(T r5) {
            this.list.set(this.index, r5);
        }
    }

    @PublishedApi
    public MutableVector(T[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "content");
        this.content = r5;
        this.size = r10;
    }

    @PublishedApi
    public static /* synthetic */ void getContent$annotations() {
    }

    public final boolean add(T r5) {
        ensureCapacity(this.size + 1);
        T[] r10 = this.content;
        int r11 = this.size;
        r10[r11] = r5;
        this.size = r11 + 1;
        return true;
    }

    public final boolean addAll(int r10, List<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r5 = 0;
        if (r11.isEmpty() == false) goto L5;
        return false;
    L5:
        int r12 = this.size;
        ensureCapacity(r11.size() + r12);
        T[] r13 = this.content;
        if (r10 == this.size) goto L8;
        ArraysKt.copyInto(r13, r13, r11.size() + r10, r10, this.size);
    L8:
        int r14 = r11.size();
    L9:
        if (r5 >= r14) goto L11;
        r13[r10 + r5] = r11.get(r5);
        r5 = r5 + 1;
        goto L9
    L11:
        int r15 = this.size;
        this.size = r11.size() + r15;
        return true;
    }

    public final boolean any(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L11;
        T[] r11 = getContent();
        int r12 = 0;
    L6:
        if (r5.invoke(r11[r12]).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        if (r12 < r10) goto L6;
    L7:
        return true;
    L11:
        return false;
    }

    public final List<T> asMutableList() {
        List<T> r5 = this.list;
        if (r5 != null) goto L6;
        MutableVectorList r10 = new MutableVectorList(this);
        this.list = r10;
        return r10;
    L6:
        return r5;
    }

    public final void clear() {
        T[] r5 = this.content;
        int r10 = getSize();
    L3:
        r10 = r10 - 1;
        if ((-1) >= r10) goto L6;
        r5[r10] = null;
        goto L3
    L6:
        this.size = 0;
    }

    public final boolean contains(T r10) {
        int r5 = getSize() - 1;
        if (r5 < 0) goto L10;
        int r11 = 0;
    L6:
        if (Intrinsics.areEqual(getContent()[r11], r10) == true) goto L7;
        if (r11 == r5) goto L10;
        r11 = r11 + 1;
        goto L6
    L7:
        return true;
    L10:
        return false;
    }

    public final boolean containsAll(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (contains(r5.get(r11)) == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final boolean contentEquals(MutableVector<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (r10.size == this.size) goto L5;
        return false;
    L5:
        int r5 = getSize() - 1;
        if (r5 < 0) goto L13;
        int r11 = 0;
    L9:
        if (Intrinsics.areEqual(r10.getContent()[r11], getContent()[r11]) == false) goto L10;
        if (r11 == r5) goto L13;
        r11 = r11 + 1;
        goto L9
    L10:
        return false;
    L13:
        return true;
    }

    public final void ensureCapacity(int r5) {
        T[] r10 = this.content;
        if (r10.length >= r5) goto L6;
        this.content = (T[]) Arrays.copyOf(r10, Math.max(r5, r10.length * 2));
        return;
    }

    public final T first() {
        if (isEmpty() == true) goto L7;
        return getContent()[0];
    L7:
        throw new NoSuchElementException("MutableVector is empty.");
    }

    public final T firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getContent()[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R fold(R r5, Function2<? super R, ? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        int r11 = getSize();
        if (r11 <= 0) goto L7;
        T[] r12 = getContent();
        int r13 = 0;
    L5:
        R r14 = r5;
        r5 = r10.mo2invoke(r14, r12[r13]);
        r13 = r13 + 1;
        if (r13 < r11) goto L5;
    L7:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R foldIndexed(R r5, Function3<? super Integer, ? super R, ? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        int r11 = getSize();
        if (r11 <= 0) goto L7;
        T[] r12 = getContent();
        int r13 = 0;
    L5:
        R r14 = r5;
        r5 = r10.invoke(Integer.valueOf(r13), r14, r12[r13]);
        r13 = r13 + 1;
        if (r13 < r11) goto L5;
    L7:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R foldRight(R r5, Function2<? super T, ? super R, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        int r11 = getSize();
        if (r11 <= 0) goto L7;
        int r12 = r11 - 1;
        T[] r13 = getContent();
    L5:
        r5 = r10.mo2invoke(r13[r12], r5);
        r12 = r12 - 1;
        if (r12 >= 0) goto L5;
    L7:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R foldRightIndexed(R r5, Function3<? super Integer, ? super T, ? super R, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        int r11 = getSize();
        if (r11 <= 0) goto L7;
        int r12 = r11 - 1;
        T[] r13 = getContent();
    L5:
        r5 = r10.invoke(Integer.valueOf(r12), r13[r12], r5);
        r12 = r12 - 1;
        if (r12 >= 0) goto L5;
    L7:
        return r5;
    }

    public final void forEach(Function1<? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        int r10 = getSize();
        if (r10 <= 0) goto L7;
        T[] r11 = getContent();
        int r12 = 0;
    L5:
        r5.invoke(r11[r12]);
        r12 = r12 + 1;
        if (r12 < r10) goto L5;
        return;
    }

    public final void forEachIndexed(Function2<? super Integer, ? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        int r10 = getSize();
        if (r10 <= 0) goto L7;
        T[] r11 = getContent();
        int r12 = 0;
    L5:
        r5.mo2invoke(Integer.valueOf(r12), r11[r12]);
        r12 = r12 + 1;
        if (r12 < r10) goto L5;
        return;
    }

    public final void forEachReversed(Function1<? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        int r10 = getSize();
        if (r10 <= 0) goto L7;
        int r11 = r10 - 1;
        T[] r12 = getContent();
    L5:
        r5.invoke(r12[r11]);
        r11 = r11 - 1;
        if (r11 >= 0) goto L5;
        return;
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        if (getSize() <= 0) goto L7;
        int r10 = getSize() - 1;
        T[] r11 = getContent();
    L5:
        r5.mo2invoke(Integer.valueOf(r10), r11[r10]);
        r10 = r10 - 1;
        if (r10 >= 0) goto L5;
        return;
    }

    public final T get(int r5) {
        return getContent()[r5];
    }

    public final T[] getContent() {
        return this.content;
    }

    public final IntRange getIndices() {
        return new IntRange(0, getSize() - 1);
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final int indexOf(T r5) {
        int r10 = this.size;
        if (r10 <= 0) goto L10;
        T[] r11 = this.content;
        int r12 = 0;
    L6:
        if (Intrinsics.areEqual(r5, r11[r12]) == true) goto L7;
        r12 = r12 + 1;
        if (r12 < r10) goto L6;
        return -1;
    L7:
        return r12;
    L10:
        return -1;
    }

    public final int indexOfFirst(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L10;
        T[] r11 = getContent();
        int r12 = 0;
    L6:
        if (r5.invoke(r11[r12]).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        if (r12 < r10) goto L6;
        return -1;
    L7:
        return r12;
    L10:
        return -1;
    }

    public final int indexOfLast(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L10;
        int r11 = r10 - 1;
        T[] r12 = getContent();
    L6:
        if (r5.invoke(r12[r11]).booleanValue() == true) goto L7;
        r11 = r11 - 1;
        if (r11 >= 0) goto L6;
        return -1;
    L7:
        return r11;
    L10:
        return -1;
    }

    public final boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this.size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T last() {
        if (isEmpty() == true) goto L7;
        return getContent()[getSize() - 1];
    L7:
        throw new NoSuchElementException("MutableVector is empty.");
    }

    public final int lastIndexOf(T r5) {
        int r10 = this.size;
        if (r10 <= 0) goto L10;
        int r11 = r10 - 1;
        T[] r12 = this.content;
    L6:
        if (Intrinsics.areEqual(r5, r12[r11]) == true) goto L7;
        r11 = r11 - 1;
        if (r11 >= 0) goto L6;
        return -1;
    L7:
        return r11;
    L10:
        return -1;
    }

    public final T lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getContent()[getSize() - 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> R[] map(Function1<? super T, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r5, "transform");
        int r10 = getSize();
        int r11 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] r12 = (R[]) new Object[r10];
    L3:
        if (r11 >= r10) goto L5;
        r12[r11] = r5.invoke(getContent()[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> R[] mapIndexed(Function2<? super Integer, ? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "transform");
        int r5 = getSize();
        int r11 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] r12 = (R[]) new Object[r5];
    L3:
        if (r11 >= r5) goto L5;
        r12[r11] = r10.mo2invoke(Integer.valueOf(r11), getContent()[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    public final /* synthetic */ <R> MutableVector<R> mapIndexedNotNull(Function2<? super Integer, ? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "transform");
        int r5 = getSize();
        int r11 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] r12 = new Object[r5];
        if (r5 <= 0) goto L12;
        T[] r13 = getContent();
        int r14 = 0;
    L5:
        R r15 = r10.mo2invoke(Integer.valueOf(r11), r13[r11]);
        if (r15 == null) goto L8;
        r12[r14] = r15;
        r14 = r14 + 1;
    L8:
        r11 = r11 + 1;
        if (r11 < r5) goto L5;
        r11 = r14;
    L12:
        return new MutableVector(r12, r11);
    }

    public final /* synthetic */ <R> MutableVector<R> mapNotNull(Function1<? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "transform");
        int r5 = getSize();
        int r11 = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] r12 = new Object[r5];
        if (r5 <= 0) goto L12;
        T[] r13 = getContent();
        int r14 = 0;
    L5:
        R r15 = r10.invoke(r13[r11]);
        if (r15 == null) goto L8;
        r12[r14] = r15;
        r14 = r14 + 1;
    L8:
        r11 = r11 + 1;
        if (r11 < r5) goto L5;
        r11 = r14;
    L12:
        return new MutableVector(r12, r11);
    }

    public final void minusAssign(T r5) {
        remove(r5);
    }

    public final void plusAssign(T r5) {
        add(r5);
    }

    public final boolean remove(T r5) {
        int r10 = indexOf(r5);
        if (r10 < 0) goto L6;
        removeAt(r10);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        int r5 = this.size;
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        remove(r10.get(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        if (r5 == this.size) goto L10;
        return true;
    L10:
        return false;
    }

    public final T removeAt(int r5) {
        T[] r10 = this.content;
        T r11 = r10[r5];
        if (r5 == (getSize() - 1)) goto L5;
        ArraysKt.copyInto(r10, r10, r5, r5 + 1, this.size);
    L5:
        int r12 = this.size - 1;
        this.size = r12;
        r10[r12] = null;
        return r11;
    }

    public final void removeRange(int r5, int r10) {
        if (r10 <= r5) goto L15;
        int r11 = this.size;
        if (r10 >= r11) goto L6;
        T[] r12 = this.content;
        ArraysKt.copyInto(r12, r12, r5, r10, r11);
    L6:
        int r13 = this.size - (r10 - r5);
        int r14 = getSize() - 1;
        if (r13 > r14) goto L12;
        int r15 = r13;
    L9:
        this.content[r15] = null;
        if (r15 == r14) goto L12;
        r15 = r15 + 1;
    L12:
        this.size = r13;
        return;
    }

    public final boolean retainAll(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r10 = this.size;
        int r11 = getSize() - 1;
    L4:
        if ((-1) >= r11) goto L10;
        if (r5.contains(getContent()[r11]) == true) goto L8;
        removeAt(r11);
    L8:
        r11 = r11 - 1;
        goto L4
    L10:
        if (r10 != this.size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean reversedAny(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L10;
        int r11 = r10 - 1;
        T[] r12 = getContent();
    L6:
        if (r5.invoke(r12[r11]).booleanValue() == true) goto L7;
        r11 = r11 - 1;
        if (r11 >= 0) goto L6;
        return false;
    L7:
        return true;
    L10:
        return false;
    }

    public final T set(int r5, T r10) {
        T[] r11 = this.content;
        T r12 = r11[r5];
        r11[r5] = r10;
        return r12;
    }

    public final void setContent(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.content = r5;
    }

    public final void sortWith(Comparator<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "comparator");
        T[] r10 = this.content;
        ArraysKt.m(r5, this.size, r10);
    }

    public final int sumBy(Function1<? super T, Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "selector");
        int r10 = getSize();
        int r11 = 0;
        if (r10 <= 0) goto L7;
        T[] r12 = getContent();
        int r13 = 0;
    L5:
        r11 = r11 + r5.invoke(r12[r13]).intValue();
        r13 = r13 + 1;
        if (r13 < r10) goto L5;
    L7:
        return r11;
    }

    @PublishedApi
    public final Void throwNoSuchElementException() {
        throw new NoSuchElementException("MutableVector contains no element matching the predicate.");
    }

    public final boolean containsAll(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Iterator<T> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (contains(r10.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final T firstOrNull(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L10;
        T[] r11 = getContent();
        int r12 = 0;
    L5:
        T r13 = r11[r12];
        if (r5.invoke(r13).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        if (r12 < r10) goto L5;
        return null;
    L7:
        return r13;
    L10:
        return null;
    }

    public final void add(int r5, T r10) {
        ensureCapacity(this.size + 1);
        T[] r11 = this.content;
        int r12 = this.size;
        if (r5 == r12) goto L5;
        ArraysKt.copyInto(r11, r11, r5 + 1, r5, r12);
    L5:
        r11[r5] = r10;
        this.size++;
    }

    public final T first(Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r5 = getSize();
        if (r5 <= 0) goto L11;
        T[] r11 = getContent();
        int r12 = 0;
    L5:
        T r13 = r11[r12];
        if (r10.invoke(r13).booleanValue() == true) goto L7;
        r12 = r12 + 1;
        if (r12 >= r5) goto L11;
    L7:
        return r13;
    L11:
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    public final T lastOrNull(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L10;
        int r11 = r10 - 1;
        T[] r12 = getContent();
    L5:
        T r13 = r12[r11];
        if (r5.invoke(r13).booleanValue() == true) goto L7;
        r11 = r11 - 1;
        if (r11 >= 0) goto L5;
        return null;
    L7:
        return r13;
    L10:
        return null;
    }

    public final T last(Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int r10 = getSize();
        if (r10 <= 0) goto L11;
        int r11 = r10 - 1;
        T[] r12 = getContent();
    L5:
        T r13 = r12[r11];
        if (r5.invoke(r13).booleanValue() == true) goto L7;
        r11 = r11 - 1;
        if (r11 < 0) goto L11;
    L7:
        return r13;
    L11:
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    public final boolean removeAll(MutableVector<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        int r5 = this.size;
        int r11 = r10.getSize() - 1;
        if (r11 < 0) goto L9;
        int r12 = 0;
    L5:
        remove(r10.getContent()[r12]);
        if (r12 == r11) goto L9;
        r12 = r12 + 1;
    L9:
        if (r5 == this.size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean containsAll(MutableVector<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        IntRange r5 = new IntRange(0, r10.getSize() - 1);
        int r11 = r5.getFirst();
        int r12 = r5.getLast();
        if (r11 <= r12) goto L5;
    L9:
        return true;
    L5:
        if (contains(r10.getContent()[r11]) == false) goto L6;
        if (r11 == r12) goto L9;
        r11 = r11 + 1;
        goto L5
    L6:
        return false;
    }

    public final boolean removeAll(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if (r5.isEmpty() == false) goto L5;
        return false;
    L5:
        int r10 = this.size;
        Iterator<T> r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L10;
        remove(r11.next());
        goto L7
    L10:
        if (r10 == this.size) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean addAll(int r5, MutableVector<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        ensureCapacity(this.size + r10.size);
        T[] r11 = this.content;
        int r12 = this.size;
        if (r5 == r12) goto L8;
        ArraysKt.copyInto(r11, r11, r10.size + r5, r5, r12);
    L8:
        ArraysKt.copyInto(r10.content, r11, r5, 0, r10.size);
        this.size += r10.size;
        return true;
    }

    public final boolean addAll(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return addAll(getSize(), r5);
    }

    public final boolean addAll(MutableVector<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return addAll(getSize(), r5);
    }

    public final boolean addAll(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if (r5.length != 0) goto L5;
        return false;
    L5:
        ensureCapacity(this.size + r5.length);
        ArraysKt.f(r5, this.content, this.size, 0, 12);
        this.size += r5.length;
        return true;
    }

    public final boolean addAll(int r10, Collection<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r5 = 0;
        if (r11.isEmpty() == false) goto L5;
        return false;
    L5:
        int r12 = this.size;
        ensureCapacity(r11.size() + r12);
        T[] r13 = this.content;
        if (r10 == this.size) goto L8;
        ArraysKt.copyInto(r13, r13, r11.size() + r10, r10, this.size);
    L8:
        Iterator<T> r14 = r11.iterator();
    L10:
        if (r14.hasNext() == false) goto L15;
        T r15 = r14.next();
        int r16 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r13[r5 + r10] = r15;
        r5 = r16;
        goto L10
    L15:
        int r17 = this.size;
        this.size = r11.size() + r17;
        return true;
    }

    public final boolean addAll(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return addAll(this.size, r5);
    }
}
