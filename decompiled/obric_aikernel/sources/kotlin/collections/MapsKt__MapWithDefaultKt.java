package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n*L\n24#1:105,6\n*E\n"})
class MapsKt__MapWithDefaultKt {
    public MapsKt__MapWithDefaultKt() {
    }

    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof MapWithDefault) == true) goto L5;
        V r12 = r10.get(r11);
        if (r12 == null) goto L9;
    L13:
        return r12;
    L9:
        if (r10.containsKey(r11) == true) goto L13;
        throw new NoSuchElementException("Key " + r11 + " is missing in the map.");
    L5:
        return (V) ((MapWithDefault) r10).getOrImplicitDefault(r11);
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> r10, Function1<? super K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if ((r10 instanceof MapWithDefault) == false) goto L6;
        return withDefault(((MapWithDefault) r10).getMap(), r11);
    L6:
        return new MapWithDefaultImpl(r10, r11);
    }

    @JvmName(name = "withDefaultMutable")
    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> r10, Function1<? super K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if ((r10 instanceof MutableMapWithDefault) == false) goto L6;
        return withDefaultMutable(((MutableMapWithDefault) r10).getMap(), r11);
    L6:
        return new MutableMapWithDefaultImpl(r10, r11);
    }
}
