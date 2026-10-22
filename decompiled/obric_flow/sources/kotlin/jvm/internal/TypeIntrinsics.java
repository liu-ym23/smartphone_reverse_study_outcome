package kotlin.jvm.internal;

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

/* JADX INFO: loaded from: classes3.dex */
public class TypeIntrinsics {
    public TypeIntrinsics() {
    }

    public static Collection asMutableCollection(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableCollection) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableCollection");
    L8:
        return castToCollection(r5);
    }

    public static Iterable asMutableIterable(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableIterable) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableIterable");
    L8:
        return castToIterable(r5);
    }

    public static Iterator asMutableIterator(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableIterator) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableIterator");
    L8:
        return castToIterator(r5);
    }

    public static List asMutableList(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableList) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableList");
    L8:
        return castToList(r5);
    }

    public static ListIterator asMutableListIterator(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableListIterator) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableListIterator");
    L8:
        return castToListIterator(r5);
    }

    public static Map asMutableMap(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableMap) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableMap");
    L8:
        return castToMap(r5);
    }

    public static Map.Entry asMutableMapEntry(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableMap.Entry) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableMap.MutableEntry");
    L8:
        return castToMapEntry(r5);
    }

    public static Set asMutableSet(Object r5) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableSet) == true) goto L8;
        throwCce(r5, "kotlin.collections.MutableSet");
    L8:
        return castToSet(r5);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object r5, int r10) {
        if (r5 != null) goto L4;
    L6:
        return r5;
    L4:
        if (isFunctionOfArity(r5, r10) == true) goto L6;
        throwCce(r5, "kotlin.jvm.functions.Function" + r10);
        goto L6
    }

    public static Collection castToCollection(Object r5) {
        return (Collection) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Iterable castToIterable(Object r5) {
        return (Iterable) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Iterator castToIterator(Object r5) {
        return (Iterator) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static List castToList(Object r5) {
        return (List) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static ListIterator castToListIterator(Object r5) {
        return (ListIterator) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Map castToMap(Object r5) {
        return (Map) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Map.Entry castToMapEntry(Object r5) {
        return (Map.Entry) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static Set castToSet(Object r5) {
        return (Set) r5;
    L4:
        e = move-exception;
        throw throwCce(e);
    }

    public static int getFunctionArity(Object r5) {
        if ((r5 instanceof FunctionBase) == false) goto L7;
        return ((FunctionBase) r5).getArity();
    L7:
        if ((r5 instanceof Function0) == false) goto L11;
        return 0;
    L11:
        if ((r5 instanceof Function1) == false) goto L15;
        return 1;
    L15:
        if ((r5 instanceof Function2) == false) goto L19;
        return 2;
    L19:
        if ((r5 instanceof Function3) == false) goto L23;
        return 3;
    L23:
        if ((r5 instanceof Function4) == false) goto L27;
        return 4;
    L27:
        if ((r5 instanceof Function5) == false) goto L31;
        return 5;
    L31:
        if ((r5 instanceof Function6) == false) goto L35;
        return 6;
    L35:
        if ((r5 instanceof Function7) == false) goto L39;
        return 7;
    L39:
        if ((r5 instanceof Function8) == false) goto L43;
        return 8;
    L43:
        if ((r5 instanceof Function9) == false) goto L47;
        return 9;
    L47:
        if ((r5 instanceof Function10) == false) goto L51;
        return 10;
    L51:
        if ((r5 instanceof Function11) == false) goto L55;
        return 11;
    L55:
        if ((r5 instanceof Function12) == false) goto L59;
        return 12;
    L59:
        if ((r5 instanceof Function13) == false) goto L63;
        return 13;
    L63:
        if ((r5 instanceof Function14) == false) goto L67;
        return 14;
    L67:
        if ((r5 instanceof Function15) == false) goto L71;
        return 15;
    L71:
        if ((r5 instanceof Function16) == false) goto L75;
        return 16;
    L75:
        if ((r5 instanceof Function17) == false) goto L79;
        return 17;
    L79:
        if ((r5 instanceof Function18) == false) goto L83;
        return 18;
    L83:
        if ((r5 instanceof Function19) == false) goto L87;
        return 19;
    L87:
        if ((r5 instanceof Function20) == false) goto L91;
        return 20;
    L91:
        if ((r5 instanceof Function21) == false) goto L95;
        return 21;
    L95:
        if ((r5 instanceof Function22) == false) goto L98;
        return 22;
    L98:
        return -1;
    }

    public static boolean isFunctionOfArity(Object r5, int r10) {
        if ((r5 instanceof Function) == true) goto L5;
    L7:
        return false;
    L5:
        if (getFunctionArity(r5) != r10) goto L7;
        return true;
    }

    public static boolean isMutableCollection(Object r5) {
        if ((r5 instanceof Collection) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableCollection) == false) goto L9;
        goto L8
    }

    public static boolean isMutableIterable(Object r5) {
        if ((r5 instanceof Iterable) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableIterable) == false) goto L9;
        goto L8
    }

    public static boolean isMutableIterator(Object r5) {
        if ((r5 instanceof Iterator) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableIterator) == false) goto L9;
        goto L8
    }

    public static boolean isMutableList(Object r5) {
        if ((r5 instanceof List) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableList) == false) goto L9;
        goto L8
    }

    public static boolean isMutableListIterator(Object r5) {
        if ((r5 instanceof ListIterator) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableListIterator) == false) goto L9;
        goto L8
    }

    public static boolean isMutableMap(Object r5) {
        if ((r5 instanceof Map) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableMap) == false) goto L9;
        goto L8
    }

    public static boolean isMutableMapEntry(Object r5) {
        if ((r5 instanceof Map.Entry) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableMap.Entry) == false) goto L9;
        goto L8
    }

    public static boolean isMutableSet(Object r5) {
        if ((r5 instanceof Set) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof KMappedMarker) == true) goto L7;
    L8:
        return true;
    L7:
        if ((r5 instanceof KMutableSet) == false) goto L9;
        goto L8
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r5) {
        return (T) Intrinsics.sanitizeStackTrace(r5, TypeIntrinsics.class.getName());
    }

    public static void throwCce(Object r5, String r10) {
        if (r5 != null) goto L4;
        String r11 = "null";
    L5:
        throwCce(r11 + " cannot be cast to " + r10);
        return;
    L4:
        r11 = r5.getClass().getName();
        goto L5
    }

    public static Object beforeCheckcastToFunctionOfArity(Object r5, int r10, String r11) {
        if (r5 != null) goto L4;
    L6:
        return r5;
    L4:
        if (isFunctionOfArity(r5, r10) == true) goto L6;
        throwCce(r11);
        goto L6
    }

    public static void throwCce(String r5) {
        throw throwCce(new ClassCastException(r5));
    }

    public static Collection asMutableCollection(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableCollection) == true) goto L8;
        throwCce(r10);
    L8:
        return castToCollection(r5);
    }

    public static Iterable asMutableIterable(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableIterable) == true) goto L8;
        throwCce(r10);
    L8:
        return castToIterable(r5);
    }

    public static Iterator asMutableIterator(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableIterator) == true) goto L8;
        throwCce(r10);
    L8:
        return castToIterator(r5);
    }

    public static List asMutableList(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableList) == true) goto L8;
        throwCce(r10);
    L8:
        return castToList(r5);
    }

    public static ListIterator asMutableListIterator(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableListIterator) == true) goto L8;
        throwCce(r10);
    L8:
        return castToListIterator(r5);
    }

    public static Map asMutableMap(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableMap) == true) goto L8;
        throwCce(r10);
    L8:
        return castToMap(r5);
    }

    public static Map.Entry asMutableMapEntry(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableMap.Entry) == true) goto L8;
        throwCce(r10);
    L8:
        return castToMapEntry(r5);
    }

    public static Set asMutableSet(Object r5, String r10) {
        if ((r5 instanceof KMappedMarker) == false) goto L8;
        if ((r5 instanceof KMutableSet) == true) goto L8;
        throwCce(r10);
    L8:
        return castToSet(r5);
    }

    public static ClassCastException throwCce(ClassCastException r5) {
        throw ((ClassCastException) sanitizeStackTrace(r5));
    }
}
