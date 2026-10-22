package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes6.dex */
public class TypeIntrinsics {
    public TypeIntrinsics() {
    }

    public static Collection asMutableCollection(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableCollection.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableCollection");
    L8:
        return castToCollection(r1);
    }

    public static Collection asMutableCollection(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableCollection.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToCollection(r1);
    }

    public static Iterable asMutableIterable(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableIterable.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableIterable");
    L8:
        return castToIterable(r1);
    }

    public static Iterable asMutableIterable(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableIterable.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToIterable(r1);
    }

    public static Iterator asMutableIterator(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableIterator.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableIterator");
    L8:
        return castToIterator(r1);
    }

    public static Iterator asMutableIterator(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableIterator.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToIterator(r1);
    }

    public static List asMutableList(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableList.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableList");
    L8:
        return castToList(r1);
    }

    public static List asMutableList(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableList.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToList(r1);
    }

    public static ListIterator asMutableListIterator(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableListIterator.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableListIterator");
    L8:
        return castToListIterator(r1);
    }

    public static ListIterator asMutableListIterator(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableListIterator.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToListIterator(r1);
    }

    public static Map asMutableMap(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableMap.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableMap");
    L8:
        return castToMap(r1);
    }

    public static Map asMutableMap(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableMap.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToMap(r1);
    }

    public static Map.Entry asMutableMapEntry(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableMap.Entry.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableMap.MutableEntry");
    L8:
        return castToMapEntry(r1);
    }

    public static Map.Entry asMutableMapEntry(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableMap.Entry.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToMapEntry(r1);
    }

    public static Set asMutableSet(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableSet.class) == true) goto L8;
        throwCce(r1, "kotlin.collections.MutableSet");
    L8:
        return castToSet(r1);
    }

    public static Set asMutableSet(Object r1, String r2) {
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, KMutableSet.class) == true) goto L8;
        throwCce(r2);
    L8:
        return castToSet(r1);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object r2, int r3) {
        if (r2 != null) goto L4;
    L6:
        return r2;
    L4:
        if (isFunctionOfArity(r2, r3) == true) goto L6;
        throwCce(r2, "kotlin.jvm.functions.Function" + r3);
        goto L6
    }

    public static Object beforeCheckcastToFunctionOfArity(Object r0, int r1, String r2) {
        if (r0 != null) goto L4;
    L6:
        return r0;
    L4:
        if (isFunctionOfArity(r0, r1) == true) goto L6;
        throwCce(r2);
        goto L6
    }

    public static Collection castToCollection(Object r2) {
        return (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Iterable castToIterable(Object r2) {
        return (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Iterator castToIterator(Object r2) {
        return (Iterator) ZeusTransformUtils.preCheckCast(r2, Iterator.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static List castToList(Object r2) {
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static ListIterator castToListIterator(Object r2) {
        return (ListIterator) ZeusTransformUtils.preCheckCast(r2, ListIterator.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Map castToMap(Object r2) {
        return (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Map.Entry castToMapEntry(Object r2) {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Set castToSet(Object r2) {
        return (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static int getFunctionArity(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, FunctionBase.class) == false) goto L7;
        return ((FunctionBase) ZeusTransformUtils.preCheckCast(r2, FunctionBase.class, "com.obric.memorydata.plugin")).getArity();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Function0.class) == false) goto L11;
        return 0;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, Function1.class) == false) goto L15;
        return 1;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, Function2.class) == false) goto L19;
        return 2;
    L19:
        if (ZeusTransformUtils.instanceOf(r2, Function3.class) == false) goto L23;
        return 3;
    L23:
        if (ZeusTransformUtils.instanceOf(r2, Function4.class) == false) goto L27;
        return 4;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, Function5.class) == false) goto L31;
        return 5;
    L31:
        if (ZeusTransformUtils.instanceOf(r2, Function6.class) == false) goto L35;
        return 6;
    L35:
        if (ZeusTransformUtils.instanceOf(r2, Function7.class) == false) goto L39;
        return 7;
    L39:
        if (ZeusTransformUtils.instanceOf(r2, Function8.class) == false) goto L43;
        return 8;
    L43:
        if (ZeusTransformUtils.instanceOf(r2, Function9.class) == false) goto L47;
        return 9;
    L47:
        if (ZeusTransformUtils.instanceOf(r2, Function10.class) == false) goto L51;
        return 10;
    L51:
        if (ZeusTransformUtils.instanceOf(r2, Function11.class) == false) goto L55;
        return 11;
    L55:
        if (ZeusTransformUtils.instanceOf(r2, Function12.class) == false) goto L59;
        return 12;
    L59:
        if (ZeusTransformUtils.instanceOf(r2, Function13.class) == false) goto L63;
        return 13;
    L63:
        if (ZeusTransformUtils.instanceOf(r2, Function14.class) == false) goto L67;
        return 14;
    L67:
        if (ZeusTransformUtils.instanceOf(r2, Function15.class) == false) goto L71;
        return 15;
    L71:
        if (ZeusTransformUtils.instanceOf(r2, Function16.class) == false) goto L75;
        return 16;
    L75:
        if (ZeusTransformUtils.instanceOf(r2, Function17.class) == false) goto L79;
        return 17;
    L79:
        if (ZeusTransformUtils.instanceOf(r2, Function18.class) == false) goto L83;
        return 18;
    L83:
        if (ZeusTransformUtils.instanceOf(r2, Function19.class) == false) goto L87;
        return 19;
    L87:
        if (ZeusTransformUtils.instanceOf(r2, Function20.class) == false) goto L91;
        return 20;
    L91:
        if (ZeusTransformUtils.instanceOf(r2, Function21.class) == false) goto L95;
        return 21;
    L95:
        if (ZeusTransformUtils.instanceOf(r2, Function22.class) == false) goto L98;
        return 22;
    L98:
        return -1;
    }

    public static boolean isFunctionOfArity(Object r1, int r2) {
        if (ZeusTransformUtils.instanceOf(r1, Function.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (getFunctionArity(r1) != r2) goto L7;
        return true;
    }

    public static boolean isMutableCollection(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableCollection.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableIterable(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Iterable.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableIterable.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableIterator(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Iterator.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableIterator.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableList(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, List.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableList.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableListIterator(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, ListIterator.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableListIterator.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableMap(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Map.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableMap.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableMapEntry(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Map.Entry.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableMap.Entry.class) == false) goto L9;
        goto L8
    }

    public static boolean isMutableSet(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Set.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, KMappedMarker.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, KMutableSet.class) == false) goto L9;
        goto L8
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r1) {
        return (T) Intrinsics.sanitizeStackTrace(r1, TypeIntrinsics.class.getName());
    }

    public static ClassCastException throwCce(ClassCastException r2) {
        throw ((ClassCastException) ZeusTransformUtils.preCheckCast(sanitizeStackTrace(r2), ClassCastException.class, "com.obric.memorydata.plugin"));
    }

    public static void throwCce(Object r1, String r2) {
        if (r1 != null) goto L4;
        String r3 = "null";
    L5:
        throwCce(r3 + " cannot be cast to " + r2);
        return;
    L4:
        r3 = r1.getClass().getName();
        goto L5
    }

    public static void throwCce(String r1) {
        throw throwCce(new ClassCastException(r1));
    }
}
