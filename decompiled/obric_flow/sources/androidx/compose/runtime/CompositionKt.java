package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e\u001a$\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e\u001a$\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001c\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u00140\u0013\u001a\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001\u001aI\u0010\u001d\u001a\u00020\u0011\"\b\b\u0000\u0010\u001e*\u00020\u0001\"\b\b\u0001\u0010\u001f*\u00020\u0001*\u0016\u0012\u0004\u0012\u0002H\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010!0 2\u0006\u0010\u0019\u001a\u0002H\u001e2\u0006\u0010\"\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010#\u001a7\u0010$\u001a\u00020\u0011\"\u0004\b\u0000\u0010%*\u0012\u0012\u0004\u0012\u0002H%0&j\b\u0012\u0004\u0012\u0002H%`'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00170)H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006*"}, d2 = {"PendingApplyNoModifications", "", "recomposeCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/ControlledComposition;", "getRecomposeCoroutineContext$annotations", "(Landroidx/compose/runtime/ControlledComposition;)V", "getRecomposeCoroutineContext", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/coroutines/CoroutineContext;", "Composition", "Landroidx/compose/runtime/Composition;", "applier", "Landroidx/compose/runtime/Applier;", "parent", "Landroidx/compose/runtime/CompositionContext;", "ControlledComposition", "clearCompositionErrors", "", "currentCompositionErrors", "", "Lkotlin/Pair;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "invalidateGroupsWithKey", STGroup.DICT_KEY, "", "simulateHotReload", "context", "addValue", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "value", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Ljava/lang/Object;Ljava/lang/Object;)V", "removeValueIf", ExifInterface.LONGITUDE_EAST, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "predicate", "Lkotlin/Function1;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1277:1\n1549#2:1278\n1620#2,3:1279\n1#3:1282\n*S KotlinDebug\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionKt\n*L\n1247#1:1278\n1247#1:1279,3\n*E\n"})
public final class CompositionKt {
    private static final Object PendingApplyNoModifications = null;

    static {
        PendingApplyNoModifications = new Object();
    }

    public static final Composition Composition(Applier<?> r10, CompositionContext r11) {
        Intrinsics.checkNotNullParameter(r10, "applier");
        Intrinsics.checkNotNullParameter(r11, "parent");
        CoroutineContext r5 = null;
        return new CompositionImpl(r11, r10, r5, 4, null);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> r10, CompositionContext r11) {
        Intrinsics.checkNotNullParameter(r10, "applier");
        Intrinsics.checkNotNullParameter(r11, "parent");
        CoroutineContext r5 = null;
        return new CompositionImpl(r11, r10, r5, 4, null);
    }

    public static final /* synthetic */ void access$addValue(IdentityArrayMap r5, Object r10, Object r11) {
        addValue(r5, r10, r11);
    }

    public static final /* synthetic */ Object access$getPendingApplyNoModifications$p() {
        return PendingApplyNoModifications;
    }

    private static final <K, V> void addValue(IdentityArrayMap<K, IdentityArraySet<V>> r5, K r10, V r11) {
        if (r5.contains(r10) == false) goto L7;
        IdentityArraySet<V> r12 = r5.get(r10);
        if (r12 == null) goto L9;
        r12.add(r11);
        return;
    L9:
        return;
    L7:
        IdentityArraySet<V> r13 = new IdentityArraySet();
        r13.add(r11);
        Unit r14 = Unit.INSTANCE;
        r5.set(r10, r13);
    }

    public static final void clearCompositionErrors() {
        HotReloader.Companion.clearErrors$runtime_release();
    }

    public static final List<Pair<Exception, Boolean>> currentCompositionErrors() {
        List<RecomposerErrorInfo> r5 = HotReloader.Companion.getCurrentErrors$runtime_release();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        RecomposerErrorInfo r12 = (RecomposerErrorInfo) r11.next();
        r10.add(TuplesKt.to(r12.getCause(), Boolean.valueOf(r12.getRecoverable())));
        goto L4
    L6:
        return r10;
    }

    @ExperimentalComposeApi
    public static final CoroutineContext getRecomposeCoroutineContext(ControlledComposition r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof CompositionImpl) == false) goto L5;
        CompositionImpl r10 = (CompositionImpl) r5;
    L6:
        if (r10 == null) goto L10;
        CoroutineContext r11 = r10.getRecomposeContext();
        if (r11 == null) goto L10;
        return r11;
    L10:
        return EmptyCoroutineContext.INSTANCE;
    L5:
        r10 = null;
        goto L6
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getRecomposeCoroutineContext$annotations(ControlledComposition r5) {
    }

    public static final void invalidateGroupsWithKey(int r5) {
        HotReloader.Companion.invalidateGroupsWithKey$runtime_release(r5);
    }

    private static final <E> void removeValueIf(HashSet<E> r5, Function1<? super E, Boolean> r10) {
        Iterator<E> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r10.invoke(r11.next()).booleanValue() == false) goto L4;
        r11.remove();
        goto L4
    }

    public static final void simulateHotReload(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        HotReloader.Companion.simulateHotReload$runtime_release(r5);
    }

    @ExperimentalComposeApi
    public static final Composition Composition(Applier<?> r5, CompositionContext r10, CoroutineContext r11) {
        Intrinsics.checkNotNullParameter(r5, "applier");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "recomposeCoroutineContext");
        return new CompositionImpl(r10, r5, r11);
    }

    @ExperimentalComposeApi
    public static final ControlledComposition ControlledComposition(Applier<?> r5, CompositionContext r10, CoroutineContext r11) {
        Intrinsics.checkNotNullParameter(r5, "applier");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "recomposeCoroutineContext");
        return new CompositionImpl(r10, r5, r11);
    }
}
