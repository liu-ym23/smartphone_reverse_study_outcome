package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\u001a%\u0010\f\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000¢\u0006\u0002\u0010\r\u001a@\u0010\u000e\u001a\u00020\u0001*\u00020\u00012.\u0010\u000f\u001a*\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00130\u0011\u0012\u0004\u0012\u00020\u00140\u0010H\u0080\bø\u0001\u0000\u001a%\u0010\u0015\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"compositionLocalMapOf", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "contains", "", ExifInterface.GPS_DIRECTION_TRUE, STGroup.DICT_KEY, "Landroidx/compose/runtime/CompositionLocal;", "getValueOf", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "mutate", "mutator", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/State;", "", "read", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCompositionLocalMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositionLocalMap.kt\nandroidx/compose/runtime/CompositionLocalMapKt\n*L\n1#1,106:1\n73#1:107\n*S KotlinDebug\n*F\n+ 1 CompositionLocalMap.kt\nandroidx/compose/runtime/CompositionLocalMapKt\n*L\n97#1:107\n*E\n"})
public final class CompositionLocalMapKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    @Composable
    public static final PersistentCompositionLocalMap compositionLocalMapOf(ProvidedValue<?>[] r10, PersistentCompositionLocalMap r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "values");
        Intrinsics.checkNotNullParameter(r11, "parentScope");
        r12.startReplaceableGroup(-300354947);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-300354947, r13, -1, "androidx.compose.runtime.compositionLocalMapOf (CompositionLocalMap.kt:91)");
    L5:
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> r14 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder();
        int r5 = r10.length;
        int r15 = 0;
    L6:
        if (r15 >= r5) goto L13;
        ProvidedValue<?> r16 = r10[r15];
        r12.startReplaceableGroup(680845765);
        if (r16.getCanOverride() == false) goto L10;
    L11:
        CompositionLocal<?> r17 = r16.getCompositionLocal();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        r14.put(r17, r16.getCompositionLocal().provided$runtime_release(r16.getValue(), r12, 8));
    L12:
        r12.endReplaceableGroup();
        r15 = r15 + 1;
        goto L6
    L10:
        if (contains(r11, r16.getCompositionLocal()) == true) goto L12;
    L13:
        ?? r18 = r14.build();
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        r12.endReplaceableGroup();
        return r18;
    }

    public static final <T> boolean contains(PersistentCompositionLocalMap r5, CompositionLocal<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        return r5.containsKey(r10);
    }

    public static final <T> T getValueOf(PersistentCompositionLocalMap r5, CompositionLocal<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        State<? extends Object> r11 = r5.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return (T) r11.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    public static final PersistentCompositionLocalMap mutate(PersistentCompositionLocalMap r5, Function1<? super Map<CompositionLocal<Object>, State<Object>>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "mutator");
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> r11 = r5.builder();
        r10.invoke(r11);
        return r11.build();
    }

    public static final <T> T read(PersistentCompositionLocalMap r5, CompositionLocal<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if (contains(r5, r10) == false) goto L6;
        return (T) getValueOf(r5, r10);
    L6:
        return r10.getDefaultValueHolder$runtime_release().getValue();
    }
}
