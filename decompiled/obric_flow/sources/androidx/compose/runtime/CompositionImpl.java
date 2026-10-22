package androidx.compose.runtime;

import ai.j0;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0094\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010U\u001a\u00020\u001cH\u0002J\u001e\u0010V\u001a\u00020\u001c2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0X2\u0006\u0010Y\u001a\u00020\u0010H\u0002J\b\u0010Z\u001a\u00020\u001cH\u0016Jc\u0010[\u001a\u00020\u001c2Y\u0010\u0013\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014H\u0002J\b\u0010\\\u001a\u00020\u001cH\u0016J\b\u0010]\u001a\u00020\u001cH\u0016J\b\u0010^\u001a\u00020\u001cH\u0002J \u0010_\u001a\u00020\u001c2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b H\u0016¢\u0006\u0002\u0010$J3\u0010a\u001a\u0002Hb\"\u0004\b\u0000\u0010b2\b\u0010c\u001a\u0004\u0018\u00010\u00012\u0006\u0010d\u001a\u00020;2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hb0\u001fH\u0016¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u001cH\u0016J\u0010\u0010h\u001a\u00020\u001c2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020\u001cH\u0002J\b\u0010l\u001a\u00020\u001cH\u0002J\"\u0010m\u001a\u0002Hn\"\u0004\b\u0000\u0010n2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hn0\u001fH\u0082\b¢\u0006\u0002\u0010oJK\u0010p\u001a\u0002Hn\"\u0004\b\u0000\u0010n25\u0010e\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002Hn0qH\u0082\b¢\u0006\u0002\u0010rJ$\u0010s\u001a\u00020\u001c2\u001a\u0010t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010v0u0)H\u0016J\u001a\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010/H\u0016J\b\u0010{\u001a\u00020\u001cH\u0016J\"\u0010|\u001a\u00020x2\u0006\u0010y\u001a\u00020*2\u0006\u0010}\u001a\u00020~2\b\u0010z\u001a\u0004\u0018\u00010/H\u0002J\u000f\u0010\u007f\u001a\u00020\u001c2\u0007\u0010\u0080\u0001\u001a\u00020;J\u0012\u0010\u0081\u0001\u001a\u00020\u001c2\u0007\u0010\u0082\u0001\u001a\u00020/H\u0002J\u0017\u0010\u0083\u0001\u001a\u00020\u00102\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0XH\u0016J\u0017\u0010\u0084\u0001\u001a\u00020\u001c2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020*H\u0016J\u0017\u0010\u0087\u0001\u001a\u00020\u001c2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0XH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u001c2\u0007\u0010\u0082\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u001c2\u0007\u0010\u0082\u0001\u001a\u00020/H\u0016J\u001b\u0010\u008a\u0001\u001a\u00020\u001c2\n\u0010i\u001a\u0006\u0012\u0002\b\u000303H\u0000¢\u0006\u0003\b\u008b\u0001J\u001f\u0010\u008c\u0001\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020/2\u0006\u0010y\u001a\u00020*H\u0000¢\u0006\u0003\b\u008d\u0001J!\u0010\u008e\u0001\u001a\u00020\u001c2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b H\u0016¢\u0006\u0002\u0010$J\u001d\u0010\u008f\u0001\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=H\u0002J#\u0010\u0090\u0001\u001a\u0002Hn\"\u0004\b\u0000\u0010n2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hn0\u001fH\u0082\b¢\u0006\u0002\u0010oJ\u001b\u0010\u0091\u0001\u001a\u00020\u00102\u0006\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010/H\u0002J\u0011\u0010\u0092\u0001\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020RH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u001cH\u0016JE\u0010V\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\fj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u000e*\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\fj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u000e2\u0007\u0010\u0082\u0001\u001a\u00020/2\u0006\u0010Y\u001a\u00020\u0010H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012Ra\u0010\u0013\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0018\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030302X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u0014\u00107\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012R\u0010\u00109\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0012R\u0014\u0010@\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0012R\u0011\u0010A\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0012Ra\u0010B\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020*02X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020*02X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020/0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010KR\"\u0010L\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010/0Mj\n\u0012\u0006\u0012\u0004\u0018\u00010/`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020RX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006\u0095\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "guardChanges", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", STGroup.DICT_KEY, "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 5 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 6 IdentityScopeMap.kt\nandroidx/compose/runtime/collection/IdentityScopeMap\n+ 7 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 8 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySetKt\n+ 9 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 10 Composition.kt\nandroidx/compose/runtime/CompositionKt\n+ 11 Trace.kt\nandroidx/compose/runtime/TraceKt\n+ 12 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1277:1\n891#1,2:1291\n1045#1,3:1293\n881#1,6:1297\n1048#1,7:1303\n893#1,4:1310\n891#1,2:1541\n1045#1,3:1543\n881#1,6:1546\n1048#1,7:1552\n893#1,4:1559\n891#1,2:1572\n1045#1,10:1574\n893#1,4:1584\n891#1,2:1666\n1045#1,10:1668\n893#1,4:1678\n891#1,2:1683\n1045#1,10:1685\n893#1,4:1695\n891#1,2:1700\n1045#1,10:1702\n893#1,4:1712\n1045#1,10:1716\n70#2:1278\n70#2:1280\n70#2:1296\n70#2:1314\n70#2:1323\n70#2:1324\n70#2:1528\n70#2:1540\n70#2:1665\n70#2:1682\n70#2:1699\n70#2:1726\n70#2:1729\n70#2:1730\n70#2:1731\n1#3:1279\n1#3:1742\n93#4,2:1281\n33#4,4:1283\n95#4,2:1287\n38#4:1289\n97#4:1290\n110#4,2:1563\n33#4,6:1565\n112#4:1571\n33#4,6:1603\n33#4,6:1745\n162#5,8:1315\n162#5,8:1588\n162#5,4:1599\n167#5,3:1609\n80#6,3:1325\n84#6:1335\n80#6,3:1343\n84#6:1353\n228#6:1366\n244#6,8:1367\n229#6:1375\n230#6:1395\n252#6,17:1396\n231#6:1413\n228#6:1414\n244#6,8:1415\n229#6:1423\n230#6:1443\n252#6,17:1444\n231#6:1461\n228#6:1462\n244#6,8:1463\n229#6:1471\n230#6:1491\n252#6,17:1492\n231#6:1509\n80#6,3:1517\n84#6:1527\n80#6,3:1529\n84#6:1539\n228#6:1616\n244#6,8:1617\n229#6:1625\n230#6:1645\n252#6,17:1646\n231#6:1663\n108#7,7:1328\n108#7,5:1338\n108#7,7:1346\n114#7:1354\n108#7,7:1357\n269#7,19:1376\n269#7,19:1424\n269#7,19:1472\n108#7,7:1520\n108#7,7:1532\n269#7,19:1626\n384#8,2:1336\n387#8:1355\n389#8:1365\n1855#9:1356\n1856#9:1364\n1271#10,7:1510\n46#11,3:1596\n50#11:1612\n46#11,3:1613\n50#11:1664\n13579#12,2:1727\n11653#12,9:1732\n13579#12:1741\n13580#12:1743\n11662#12:1744\n*S KotlinDebug\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl\n*L\n584#1:1291,2\n584#1:1293,3\n587#1:1297,6\n584#1:1303,7\n584#1:1310,4\n779#1:1541,2\n779#1:1543,3\n780#1:1546,6\n779#1:1552,7\n779#1:1559,4\n793#1:1572,2\n793#1:1574,10\n793#1:1584,4\n848#1:1666,2\n848#1:1668,10\n848#1:1678,4\n857#1:1683,2\n857#1:1685,10\n857#1:1695,4\n867#1:1700,2\n867#1:1702,10\n867#1:1712,4\n892#1:1716,10\n515#1:1278\n524#1:1280\n585#1:1296\n595#1:1314\n637#1:1323\n658#1:1324\n767#1:1528\n777#1:1540\n847#1:1665\n856#1:1682\n866#1:1699\n906#1:1726\n912#1:1729\n947#1:1730\n970#1:1731\n1032#1:1742\n531#1:1281,2\n531#1:1283,4\n531#1:1287,2\n531#1:1289\n531#1:1290\n792#1:1563,2\n792#1:1565,6\n792#1:1571\n817#1:1603,6\n1033#1:1745,6\n622#1:1315,8\n801#1:1588,8\n815#1:1599,4\n815#1:1609,3\n681#1:1325,3\n681#1:1335\n706#1:1343,3\n706#1:1353\n714#1:1366\n714#1:1367,8\n714#1:1375\n714#1:1395\n714#1:1396,17\n714#1:1413\n721#1:1414\n721#1:1415,8\n721#1:1423\n721#1:1443\n721#1:1444,17\n721#1:1461\n728#1:1462\n728#1:1463,8\n728#1:1471\n728#1:1491\n728#1:1492,17\n728#1:1509\n759#1:1517,3\n759#1:1527\n772#1:1529,3\n772#1:1539\n834#1:1616\n834#1:1617,8\n834#1:1625\n834#1:1645\n834#1:1646,17\n834#1:1663\n681#1:1328,7\n700#1:1338,5\n706#1:1346,7\n700#1:1354\n706#1:1357,7\n714#1:1376,19\n721#1:1424,19\n728#1:1472,19\n759#1:1520,7\n772#1:1532,7\n834#1:1626,19\n700#1:1336,2\n700#1:1355\n700#1:1365\n700#1:1356\n700#1:1364\n730#1:1510,7\n811#1:1596,3\n811#1:1612\n832#1:1613,3\n832#1:1664\n907#1:1727,2\n1032#1:1732,9\n1032#1:1741\n1032#1:1743\n1032#1:1744\n*E\n"})
public final class CompositionImpl implements ControlledComposition, RecomposeScopeOwner {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "deactivating", "", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "forgetting", "releasing", "remembering", "sideEffects", "Lkotlin/Function0;", "", "instance", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nComposition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl$RememberEventDispatcher\n+ 2 Trace.kt\nandroidx/compose/runtime/TraceKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,1277:1\n46#2,5:1278\n46#2,5:1283\n46#2,3:1288\n50#2:1297\n46#2,5:1298\n46#2,3:1303\n50#2:1312\n46#2,5:1313\n33#3,6:1291\n33#3,6:1306\n*S KotlinDebug\n*F\n+ 1 Composition.kt\nandroidx/compose/runtime/CompositionImpl$RememberEventDispatcher\n*L\n1111#1:1278,5\n1122#1:1283,5\n1134#1:1288,3\n1134#1:1297\n1147#1:1298,5\n1159#1:1303,3\n1159#1:1312\n1170#1:1313,5\n1135#1:1291,6\n1160#1:1306,6\n*E\n"})
    public static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private List<ComposeNodeLifecycleCallback> deactivating;
        private final List<RememberObserver> forgetting;
        private List<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering;
        private final List<Function0<Unit>> sideEffects;

        public RememberEventDispatcher(Set<RememberObserver> r5) {
            Intrinsics.checkNotNullParameter(r5, "abandoning");
            this.abandoning = r5;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback r5) {
            Intrinsics.checkNotNullParameter(r5, "instance");
            List r10 = this.deactivating;
            if (r10 != null) goto L5;
            r10 = new ArrayList();
            this.deactivating = r10;
        L5:
            r10.add(r5);
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty() == true) goto L15;
            Object r5 = Trace.INSTANCE.beginSection("Compose:abandons");
            Iterator<RememberObserver> r10 = this.abandoning.iterator();     // Catch: Throwable -> L9
        L7:
            if (r10.hasNext() == false) goto L11;
            RememberObserver r11 = r10.next();     // Catch: Throwable -> L9
            r10.remove();     // Catch: Throwable -> L9
            r11.onAbandoned();     // Catch: Throwable -> L9
            goto L7
        L11:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
            Trace.INSTANCE.endSection(r5);
            return;
        L9:
            th = move-exception;
            Trace.INSTANCE.endSection(r5);
            throw th;
        }

        public final void dispatchRememberObservers() {
            List<ComposeNodeLifecycleCallback> r5 = this.deactivating;
            if (r5 == null) goto L18;
            if (r5.isEmpty() == true) goto L18;
            Object r10 = Trace.INSTANCE.beginSection("Compose:deactivations");
            int r11 = r5.size() - 1;     // Catch: Throwable -> L11
        L9:
            if ((-1) >= r11) goto L13;
            r5.get(r11).onDeactivate();     // Catch: Throwable -> L11
            r11 = r11 - 1;     // Catch: Throwable -> L11
            goto L9
        L13:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
            Trace.INSTANCE.endSection(r10);
            r5.clear();
        L11:
            th = move-exception;
            Trace.INSTANCE.endSection(r10);
            throw th;
        L18:
            if (this.forgetting.isEmpty() == true) goto L33;
            Object r13 = Trace.INSTANCE.beginSection("Compose:onForgotten");
            int r14 = this.forgetting.size() - 1;     // Catch: Throwable -> L25
        L21:
            if ((-1) >= r14) goto L28;
            RememberObserver r15 = this.forgetting.get(r14);     // Catch: Throwable -> L25
            if (this.abandoning.contains(r15) == true) goto L27;
            r15.onForgotten();     // Catch: Throwable -> L25
        L27:
            r14 = r14 - 1;     // Catch: Throwable -> L25
            goto L21
        L28:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L25
            Trace.INSTANCE.endSection(r13);
        L25:
            th = move-exception;
            Trace.INSTANCE.endSection(r13);
            throw th;
        L33:
            if (this.remembering.isEmpty() == true) goto L44;
            Object r17 = Trace.INSTANCE.beginSection("Compose:onRemembered");
            List<RememberObserver> r18 = this.remembering;     // Catch: Throwable -> L38
            int r19 = r18.size();     // Catch: Throwable -> L38
            int r20 = 0;
        L36:
            if (r20 >= r19) goto L40;
            RememberObserver r21 = r18.get(r20);     // Catch: Throwable -> L38
            this.abandoning.remove(r21);     // Catch: Throwable -> L38
            r21.onRemembered();     // Catch: Throwable -> L38
            r20 = r20 + 1;     // Catch: Throwable -> L38
            goto L36
        L40:
            Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L38
            Trace.INSTANCE.endSection(r17);
        L38:
            th = move-exception;
            Trace.INSTANCE.endSection(r17);
            throw th;
        L44:
            List<ComposeNodeLifecycleCallback> r23 = this.releasing;
            if (r23 != null) goto L47;
            return;
        L47:
            if (r23.isEmpty() == true) goto L75;
            Object r24 = Trace.INSTANCE.beginSection("Compose:releases");
            int r25 = r23.size() - 1;     // Catch: Throwable -> L53
        L51:
            if ((-1) >= r25) goto L55;
            r23.get(r25).onRelease();     // Catch: Throwable -> L53
            r25 = r25 - 1;     // Catch: Throwable -> L53
            goto L51
        L55:
            Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L53
            Trace.INSTANCE.endSection(r24);
            r23.clear();
            return;
        L53:
            th = move-exception;
            Trace.INSTANCE.endSection(r24);
            throw th;
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty() == true) goto L14;
            Object r5 = Trace.INSTANCE.beginSection("Compose:sideeffects");
            List<Function0<Unit>> r10 = this.sideEffects;     // Catch: Throwable -> L8
            int r11 = r10.size();     // Catch: Throwable -> L8
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L10;
            r10.get(r12).invoke();     // Catch: Throwable -> L8
            r12 = r12 + 1;     // Catch: Throwable -> L8
            goto L6
        L10:
            this.sideEffects.clear();     // Catch: Throwable -> L8
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L8
            Trace.INSTANCE.endSection(r5);
            return;
        L8:
            th = move-exception;
            Trace.INSTANCE.endSection(r5);
            throw th;
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver r5) {
            Intrinsics.checkNotNullParameter(r5, "instance");
            int r10 = this.remembering.lastIndexOf(r5);
            if (r10 < 0) goto L5;
            this.remembering.remove(r10);
            this.abandoning.remove(r5);
            return;
        L5:
            this.forgetting.add(r5);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback r5) {
            Intrinsics.checkNotNullParameter(r5, "instance");
            List r10 = this.releasing;
            if (r10 != null) goto L5;
            r10 = new ArrayList();
            this.releasing = r10;
        L5:
            r10.add(r5);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver r5) {
            Intrinsics.checkNotNullParameter(r5, "instance");
            int r10 = this.forgetting.lastIndexOf(r5);
            if (r10 < 0) goto L5;
            this.forgetting.remove(r10);
            this.abandoning.remove(r5);
            return;
        L5:
            this.remembering.add(r5);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "effect");
            this.sideEffects.add(r5);
        }
    }

    public CompositionImpl(CompositionContext r11, Applier<?> r12, CoroutineContext r13) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "applier");
        this.parent = r11;
        this.applier = r12;
        this.pendingModifications = new AtomicReference(null);
        this.lock = new Object();
        HashSet<RememberObserver> r10 = new HashSet();
        this.abandonSet = r10;
        SlotTable r5 = new SlotTable();
        this.slotTable = r5;
        this.observations = new IdentityScopeMap();
        this.conditionallyInvalidatedScopes = new HashSet();
        this.derivedStates = new IdentityScopeMap();
        ArrayList r14 = new ArrayList();
        this.changes = r14;
        ArrayList r15 = new ArrayList();
        this.lateChanges = r15;
        this.observationsProcessed = new IdentityScopeMap();
        this.invalidations = new IdentityArrayMap(0, 1, null);
        ComposerImpl r16 = new ComposerImpl(r12, r11, r5, r10, r14, r15, this);
        r11.registerComposer$runtime_release(r16);
        this.composer = r16;
        this._recomposeContext = r13;
        this.isRoot = r11 instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m5getLambda1$runtime_release();
    }

    private final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    private final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> r10, Object r11, boolean r12) {
        IdentityScopeMap<RecomposeScopeImpl> r5 = this.observations;
        int r13 = IdentityScopeMap.access$find(r5, r11);
        if (r13 < 0) goto L18;
        IdentityArraySet r14 = IdentityScopeMap.access$scopeSetAt(r5, r13);
        Object[] r15 = r14.getValues();
        int r16 = r14.size();
        int r17 = 0;
    L5:
        if (r17 >= r16) goto L18;
        Object r18 = r15[r17];
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        RecomposeScopeImpl r19 = (RecomposeScopeImpl) r18;
        if (this.observationsProcessed.remove(r11, r19) == true) goto L17;
        if (r19.invalidateForResult(r11) == InvalidationResult.IGNORED) goto L17;
        if (r19.isConditional() == false) goto L14;
        if (r12 == true) goto L14;
        this.conditionallyInvalidatedScopes.add(r19);
    L14:
        if (r10 != null) goto L16;
        r10 = new HashSet();
    L16:
        r10.add(r19);
    L17:
        r17 = r17 + 1;
    L18:
        return r10;
    }

    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r19) {
        RememberEventDispatcher r5 = new RememberEventDispatcher(this.abandonSet);
    L47:
        th = move-exception;
        if (this.lateChanges.isEmpty() == false) goto L64;
        r5.dispatchAbandons();
    L64:
        throw th;
    L4:
        if (r19.isEmpty() == true) goto L6;
        Object r10 = Trace.INSTANCE.beginSection("Compose:applyChanges");     // Catch: Throwable -> L47
        this.applier.onBeginChanges();     // Catch: Throwable -> L55
        SlotWriter r11 = this.slotTable.openWriter();     // Catch: Throwable -> L55
        Applier<?> r12 = this.applier;     // Catch: Throwable -> L14
        int r13 = r19.size();     // Catch: Throwable -> L14
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r15 >= r13) goto L16;
        r19.get(r15).invoke(r12, r11, r5);     // Catch: Throwable -> L14
        r15 = r15 + 1;     // Catch: Throwable -> L14
        goto L12
    L16:
        r19.clear();     // Catch: Throwable -> L14
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r11.close();     // Catch: Throwable -> L55
        this.applier.onEndChanges();     // Catch: Throwable -> L55
        Trace r17 = Trace.INSTANCE;     // Catch: Throwable -> L47
        r17.endSection(r10);     // Catch: Throwable -> L47
        r5.dispatchRememberObservers();     // Catch: Throwable -> L47
        r5.dispatchSideEffects();     // Catch: Throwable -> L47
        if (this.pendingInvalidScopes == false) goto L52;
        Object r18 = r17.beginSection("Compose:unobserve");     // Catch: Throwable -> L47
        this.pendingInvalidScopes = false;     // Catch: Throwable -> L29
        IdentityScopeMap<RecomposeScopeImpl> r20 = this.observations;     // Catch: Throwable -> L29
        int[] r21 = r20.getValueOrder();     // Catch: Throwable -> L29
        IdentityArraySet<RecomposeScopeImpl>[] r22 = r20.getScopeSets();     // Catch: Throwable -> L29
        Object[] r23 = r20.getValues();     // Catch: Throwable -> L29
        int r24 = r20.getSize();     // Catch: Throwable -> L29
        int r25 = 0;
        int r110 = 0;
    L22:
        if (r25 >= r24) goto L42;
        int r111 = r21[r25];     // Catch: Throwable -> L29
        IdentityArraySet<RecomposeScopeImpl> r112 = r22[r111];     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L29
        Object[] r113 = r112.getValues();     // Catch: Throwable -> L29
        int r114 = r112.size();     // Catch: Throwable -> L29
        int r115 = r14;
    L24:
        if (r14 >= r114) goto L33;
        IdentityArraySet<RecomposeScopeImpl>[] r116 = r22;
        Object r26 = r113[r14];     // Catch: Throwable -> L29
        int r117 = r24;
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");     // Catch: Throwable -> L29
        if (((RecomposeScopeImpl) r26).getValid() == false) goto L32;
        if (r115 == r14) goto L31;
        r113[r115] = r26;     // Catch: Throwable -> L29
    L31:
        r115 = r115 + 1;     // Catch: Throwable -> L29
    L32:
        r14 = r14 + 1;     // Catch: Throwable -> L29
        r22 = r116;
        r24 = r117;
        goto L24
    L33:
        IdentityArraySet<RecomposeScopeImpl>[] r118 = r22;
        int r119 = r24;
        int r27 = r115;
    L34:
        if (r27 >= r114) goto L36;
        r113[r27] = null;     // Catch: Throwable -> L29
        r27 = r27 + 1;     // Catch: Throwable -> L29
        goto L34
    L36:
        IdentityArraySet.access$setSize$p(r112, r115);     // Catch: Throwable -> L29
        if (r112.size() <= 0) goto L41;
        if (r110 == r25) goto L40;
        int r28 = r21[r110];     // Catch: Throwable -> L29
        r21[r110] = r111;     // Catch: Throwable -> L29
        r21[r25] = r28;     // Catch: Throwable -> L29
    L40:
        r110 = r110 + 1;     // Catch: Throwable -> L29
    L41:
        r25 = r25 + 1;     // Catch: Throwable -> L29
        r22 = r118;
        r24 = r119;
        r14 = 0;
        goto L22
    L42:
        int r29 = r20.getSize();     // Catch: Throwable -> L29
        int r30 = r110;
    L43:
        if (r30 >= r29) goto L45;
        r23[r21[r30]] = null;     // Catch: Throwable -> L29
        r30 = r30 + 1;     // Catch: Throwable -> L29
        goto L43
    L45:
        r20.setSize(r110);     // Catch: Throwable -> L29
        cleanUpDerivedStateObservations();     // Catch: Throwable -> L29
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L29
        Trace.INSTANCE.endSection(r18);     // Catch: Throwable -> L47
        goto L52
    L29:
        th = move-exception;
        Trace.INSTANCE.endSection(r18);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L52:
        if (this.lateChanges.isEmpty() == false) goto L81;
        r5.dispatchAbandons();
        return;
    L81:
        return;
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Trace.INSTANCE.endSection(r10);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L6:
        if (this.lateChanges.isEmpty() == false) goto L80;
        r5.dispatchAbandons();
        return;
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap<DerivedState<?>> r5 = this.derivedStates;
        int[] r10 = r5.getValueOrder();
        IdentityArraySet<DerivedState<?>>[] r11 = r5.getScopeSets();
        Object[] r12 = r5.getValues();
        int r13 = r5.getSize();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L21;
        int r16 = r10[r14];
        IdentityArraySet<DerivedState<?>> r17 = r11[r16];
        Intrinsics.checkNotNull(r17);
        Object[] r18 = r17.getValues();
        int r19 = r17.size();
        int r110 = 0;
        int r111 = 0;
    L5:
        if (r110 >= r19) goto L12;
        Object r20 = r18[r110];
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        IdentityArraySet<DerivedState<?>>[] r112 = r11;
        IdentityScopeMap<RecomposeScopeImpl> r21 = this.observations;
        if (r21.contains((DerivedState) r20) == false) goto L11;
        if (r111 == r110) goto L10;
        r18[r111] = r20;
    L10:
        r111 = r111 + 1;
    L11:
        r110 = r110 + 1;
        r11 = r112;
        goto L5
    L12:
        IdentityArraySet<DerivedState<?>>[] r113 = r11;
        int r22 = r111;
    L13:
        if (r22 >= r19) goto L15;
        r18[r22] = null;
        r22 = r22 + 1;
        goto L13
    L15:
        IdentityArraySet.access$setSize$p(r17, r111);
        if (r17.size() <= 0) goto L20;
        if (r15 == r14) goto L19;
        int r23 = r10[r15];
        r10[r15] = r16;
        r10[r14] = r23;
    L19:
        r15 = r15 + 1;
    L20:
        r14 = r14 + 1;
        r11 = r113;
        goto L3
    L21:
        int r24 = r5.getSize();
        int r25 = r15;
    L22:
        if (r25 >= r24) goto L24;
        r12[r10[r25]] = null;
        r25 = r25 + 1;
        goto L22
    L24:
        r5.setSize(r15);
        if (this.conditionallyInvalidatedScopes.isEmpty() == true) goto L32;
        Iterator<RecomposeScopeImpl> r26 = this.conditionallyInvalidatedScopes.iterator();
    L28:
        if (r26.hasNext() == false) goto L46;
        if (r26.next().isConditional() == true) goto L28;
        r26.remove();
        goto L28
    L46:
        return;
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object r5 = this.pendingModifications.getAndSet(CompositionKt.access$getPendingApplyNoModifications$p());
        if (r5 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r5, CompositionKt.access$getPendingApplyNoModifications$p()) == true) goto L17;
        if ((r5 instanceof Set) == false) goto L10;
        addPendingInvalidationsLocked((Set) r5, true);
        return;
    L10:
        if ((r5 instanceof Object[]) == false) goto L14;
        Set<? extends Object>[] r10 = (Set[]) r5;
        int r11 = r10.length;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L21;
        addPendingInvalidationsLocked(r10[r12], true);
        r12 = r12 + 1;
        goto L12
    L21:
        return;
    L14:
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    L17:
        throw j0.z("pending composition has not been applied");
    }

    private final void drainPendingModificationsLocked() {
        Object r5 = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(r5, CompositionKt.access$getPendingApplyNoModifications$p()) == false) goto L5;
        return;
    L5:
        if ((r5 instanceof Set) == false) goto L8;
        addPendingInvalidationsLocked((Set) r5, false);
        return;
    L8:
        if ((r5 instanceof Object[]) == false) goto L12;
        Set<? extends Object>[] r10 = (Set[]) r5;
        int r11 = r10.length;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L20;
        addPendingInvalidationsLocked(r10[r12], false);
        r12 = r12 + 1;
        goto L10
    L20:
        return;
    L12:
        if (r5 == null) goto L14;
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    L14:
        throw j0.z("calling recordModificationsOf and applyChanges concurrently is not supported");
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final <T> T guardChanges(Function0<? extends T> r5) {
        T r10 = r5.invoke();     // Catch: Throwable -> L8
        InlineMarker.finallyStart(1);     // Catch: Exception -> L6
        InlineMarker.finallyEnd(1);     // Catch: Exception -> L6
        return r10;
    L6:
        e = move-exception;
        abandonChanges();
        throw e;
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Exception -> L6
        if (this.abandonSet.isEmpty() == true) goto L12;
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();     // Catch: Exception -> L6
    L12:
        InlineMarker.finallyEnd(1);     // Catch: Exception -> L6
        throw th;     // Catch: Exception -> L6
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> r5) {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r10 = takeInvalidations();
        return r5.invoke(r10);
    L5:
        e = move-exception;
        this.invalidations = r10;
        throw e;
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl r10, Anchor r11, Object r12) {
        Object r5 = this.lock;
        monitor-enter(r5);
        CompositionImpl r13 = this.invalidationDelegate;     // Catch: Throwable -> L9
        if (r13 != null) goto L7;
    L11:
        r13 = null;
    L12:
        if (r13 == null) goto L14;
    L21:
        monitor-exit(r5);
        if (r13 != null) goto L24;
        this.parent.invalidate$runtime_release(this);
        if (isComposing() == false) goto L29;
        return InvalidationResult.DEFERRED;
    L29:
        return InvalidationResult.SCHEDULED;
    L24:
        return r13.invalidateChecked(r10, r11, r12);
    L14:
        if (tryImminentInvalidation(r10, r12) == false) goto L18;
        InvalidationResult r14 = InvalidationResult.IMMINENT;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return r14;
    L18:
        if (r12 != null) goto L20;
        this.invalidations.set(r10, null);     // Catch: Throwable -> L9
        goto L21
    L20:
        CompositionKt.access$addValue(this.invalidations, r10, r12);     // Catch: Throwable -> L9
        goto L21
    L7:
        if (this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, r11) == false) goto L11;
    L9:
        th = move-exception;
        throw th;
    }

    private final void invalidateScopeOfLocked(Object r10) {
        IdentityScopeMap<RecomposeScopeImpl> r5 = this.observations;
        int r11 = IdentityScopeMap.access$find(r5, r10);
        if (r11 < 0) goto L10;
        IdentityArraySet r12 = IdentityScopeMap.access$scopeSetAt(r5, r11);
        Object[] r13 = r12.getValues();
        int r14 = r12.size();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L14;
        Object r16 = r13[r15];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        RecomposeScopeImpl r17 = (RecomposeScopeImpl) r16;
        if (r17.invalidateForResult(r10) != InvalidationResult.IMMINENT) goto L9;
        this.observationsProcessed.add(r10, r17);
    L9:
        r15 = r15 + 1;
        goto L5
    L14:
        return;
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r5 = this.invalidations;
        this.invalidations = new IdentityArrayMap(0, 1, null);
        return r5;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> r5) {
        T r10 = r5.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        return r10;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (this.abandonSet.isEmpty() == true) goto L10;
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
    L10:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl r5, Object r10) {
        if (isComposing() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.composer.tryImminentInvalidation$runtime_release(r5, r10) == false) goto L7;
        return true;
    }

    private final void validateRecomposeScopeAnchors(SlotTable r10) {
        Object[] r11 = r10.getSlots();
        ArrayList r5 = new ArrayList();
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L11;
        Object r15 = r11[r14];
        if ((r15 instanceof RecomposeScopeImpl) == false) goto L7;
        RecomposeScopeImpl r16 = (RecomposeScopeImpl) r15;
    L8:
        if (r16 == null) goto L10;
        r5.add(r16);
    L10:
        r14 = r14 + 1;
        goto L3
    L7:
        r16 = null;
        goto L8
    L11:
        int r17 = r5.size();
    L12:
        if (r13 >= r17) goto L21;
        RecomposeScopeImpl r18 = (RecomposeScopeImpl) r5.get(r13);
        Anchor r19 = r18.getAnchor();
        if (r19 == null) goto L20;
        if (r10.slotsOf$runtime_release(r19.toIndexFor(r10)).contains(r18) == true) goto L20;
        throw new IllegalStateException(("Misaligned anchor " + r19 + " in scope " + r18 + " encountered, scope found at " + ArraysKt.indexOf(r10.getSlots(), r18)).toString());
    L20:
        r13 = r13 + 1;
        goto L12
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            java.util.List<kotlin.jvm.functions.Function3<androidx.compose.runtime.Applier<?>, androidx.compose.runtime.SlotWriter, androidx.compose.runtime.RememberManager, kotlin.Unit>> r1 = r4.changes     // Catch: java.lang.Throwable -> Lf
            r4.applyChangesInLocked(r1)     // Catch: java.lang.Throwable -> Lf
            r4.drainPendingModificationsLocked()     // Catch: java.lang.Throwable -> Lf
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r0)
            return
        Lf:
            r1 = move-exception
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r2 = r4.abandonSet     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            if (r2 != 0) goto L27
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r2 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r3 = r4.abandonSet     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r2.dispatchAbandons()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            goto L27
        L23:
            r4 = move-exception
            goto L2c
        L25:
            r1 = move-exception
            goto L28
        L27:
            throw r1     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
        L28:
            r4.abandonChanges()     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L2c:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.applyChanges():void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        Object r5 = this.lock;
        monitor-enter(r5);
    L7:
        th = move-exception;
    L17:
        e = move-exception;
        abandonChanges();     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L13:
        if (this.abandonSet.isEmpty() == true) goto L19;
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();     // Catch: Throwable -> L15 Exception -> L17
    L19:
        throw th;     // Catch: Throwable -> L15 Exception -> L17
    L5:
        if (this.lateChanges.isEmpty() == true) goto L9;
        applyChangesInLocked(this.lateChanges);     // Catch: Throwable -> L7
    L9:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            androidx.compose.runtime.ComposerImpl r1 = r4.composer     // Catch: java.lang.Throwable -> L1b
            r1.changesApplied$runtime_release()     // Catch: java.lang.Throwable -> L1b
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r1 = r4.abandonSet     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1d
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r1 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch: java.lang.Throwable -> L1b
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r2 = r4.abandonSet     // Catch: java.lang.Throwable -> L1b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1b
            r1.dispatchAbandons()     // Catch: java.lang.Throwable -> L1b
            goto L1d
        L1b:
            r1 = move-exception
            goto L21
        L1d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)
            return
        L21:
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r2 = r4.abandonSet     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            if (r2 != 0) goto L38
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r2 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r3 = r4.abandonSet     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r2.dispatchAbandons()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            goto L38
        L34:
            r4 = move-exception
            goto L3d
        L36:
            r1 = move-exception
            goto L39
        L38:
            throw r1     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
        L39:
            r4.abandonChanges()     // Catch: java.lang.Throwable -> L34
            throw r1     // Catch: java.lang.Throwable -> L34
        L3d:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.changesApplied():void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        Object r10 = this.lock;     // Catch: Throwable -> L9
        monitor-enter(r10);     // Catch: Throwable -> L9
        drainPendingModificationsForCompositionLocked();     // Catch: Throwable -> L11
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r11 = takeInvalidations();     // Catch: Throwable -> L11
        this.composer.composeContent$runtime_release(r11, r5);     // Catch: Throwable -> L11 Exception -> L13
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11 Exception -> L13
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L13:
        e = move-exception;
        this.invalidations = r11;     // Catch: Throwable -> L11
        throw e;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
    L21:
        e = move-exception;
        abandonChanges();
        throw e;
    L19:
        if (this.abandonSet.isEmpty() == true) goto L23;
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();     // Catch: Exception -> L21
    L23:
        throw th;     // Catch: Exception -> L21
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition r5, int r10, Function0<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        if (r5 == null) goto L14;
        if (Intrinsics.areEqual(r5, this) == true) goto L14;
        if (r10 < 0) goto L14;
        this.invalidationDelegate = (CompositionImpl) r5;
        this.invalidationDelegateGroup = r10;
        R r12 = r11.invoke();     // Catch: Throwable -> L10
        this.invalidationDelegate = null;
        this.invalidationDelegateGroup = 0;
        return r12;
    L10:
        th = move-exception;
        this.invalidationDelegate = null;
        this.invalidationDelegateGroup = 0;
        throw th;
    L14:
        return r11.invoke();
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        Object r5 = this.lock;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.disposed == true) goto L28;
        boolean r10 = true;
        this.disposed = true;     // Catch: Throwable -> L9
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m6getLambda2$runtime_release();     // Catch: Throwable -> L9
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r11 = this.composer.getDeferredChanges$runtime_release();     // Catch: Throwable -> L9
        if (r11 == null) goto L12;
        applyChangesInLocked(r11);     // Catch: Throwable -> L9
    L12:
        if (this.slotTable.getGroupsSize() > 0) goto L15;
        r10 = false;
    L15:
        if (r10 == false) goto L17;
    L18:
        RememberEventDispatcher r12 = new RememberEventDispatcher(this.abandonSet);     // Catch: Throwable -> L9
        if (r10 == false) goto L26;
        this.applier.onBeginChanges();     // Catch: Throwable -> L9
        SlotWriter r13 = this.slotTable.openWriter();     // Catch: Throwable -> L9
        ComposerKt.removeCurrentGroup(r13, r12);     // Catch: Throwable -> L23
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r13.close();     // Catch: Throwable -> L9
        this.applier.clear();     // Catch: Throwable -> L9
        this.applier.onEndChanges();     // Catch: Throwable -> L9
        r12.dispatchRememberObservers();     // Catch: Throwable -> L9
        goto L26
    L23:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L26:
        r12.dispatchAbandons();     // Catch: Throwable -> L9
    L27:
        this.composer.dispose$runtime_release();     // Catch: Throwable -> L9
        goto L28
    L17:
        if (this.abandonSet.isEmpty() == true) goto L27;
    L28:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        RememberEventDispatcher r10 = new RememberEventDispatcher(this.abandonSet);
        SlotWriter r11 = r5.getSlotTable$runtime_release().openWriter();
        ComposerKt.removeCurrentGroup(r11, r10);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r11.close();
        r10.dispatchRememberObservers();
        return;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return ArraysKt.filterNotNull(this.derivedStates.getValues());
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        Object r5 = this.lock;
        monitor-enter(r5);
        if (this.invalidations.getSize() <= 0) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r5);
        return r10;
    L7:
        r10 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        Object r5 = this.lock;
        monitor-enter(r5);
        boolean r10 = this.composer.getHasPendingChanges$runtime_release();     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<Object> getObservedObjects$runtime_release() {
        return ArraysKt.filterNotNull(this.observations.getValues());
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext r5 = this._recomposeContext;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return this.parent.getRecomposeCoroutineContext$runtime_release();
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> r10) {
        boolean r5 = true;
        Intrinsics.checkNotNullParameter(r10, "references");
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (Intrinsics.areEqual(r10.get(r12).getFirst().getComposition$runtime_release(), this) == false) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        r5 = false;
    L8:
        ComposerKt.runtimeCheck(r5);
        this.composer.insertMovableContentReferences(r10);     // Catch: Throwable -> L11
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
    L15:
        e = move-exception;
        abandonChanges();
        throw e;
    L13:
        if (this.abandonSet.isEmpty() == true) goto L17;
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();     // Catch: Exception -> L15
    L17:
        throw th;     // Catch: Exception -> L15
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        if (r5.getDefaultsInScope() == false) goto L5;
        r5.setDefaultsInvalid(true);
    L5:
        Anchor r11 = r5.getAnchor();
        if (r11 == null) goto L33;
        if (r11.getValid() == false) goto L33;
        if (this.slotTable.ownsAnchor(r11) == true) goto L27;
        Object r12 = this.lock;
        monitor-enter(r12);
        CompositionImpl r13 = this.invalidationDelegate;     // Catch: Throwable -> L23
        monitor-exit(r12);
        if (r13 == null) goto L22;
        if (r13.tryImminentInvalidation(r5, r10) != true) goto L22;
        return InvalidationResult.IMMINENT;
    L22:
        return InvalidationResult.IGNORED;
    L23:
        th = move-exception;
        throw th;
    L27:
        if (r5.getCanRecompose() == true) goto L31;
        return InvalidationResult.IGNORED;
    L31:
        return invalidateChecked(r5, r11, r10);
    L33:
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        Object r5 = this.lock;
        monitor-enter(r5);
        Object[] r10 = this.slotTable.getSlots();     // Catch: Throwable -> L9
        int r11 = r10.length;     // Catch: Throwable -> L9
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        Object r13 = r10[r12];     // Catch: Throwable -> L9
        if ((r13 instanceof RecomposeScopeImpl) == false) goto L11;
        RecomposeScopeImpl r14 = (RecomposeScopeImpl) r13;     // Catch: Throwable -> L9
    L12:
        if (r14 == null) goto L14;
        r14.invalidate();     // Catch: Throwable -> L9
    L14:
        r12 = r12 + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        r14 = null;
        goto L12
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void invalidateGroupsWithKey(int r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
        List<RecomposeScopeImpl> r11 = this.slotTable.invalidateGroupsWithKey$runtime_release(r5);     // Catch: Throwable -> L17
        monitor-exit(r10);
        if (r11 == null) goto L14;
        int r12 = r11.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L25;
        if (r11.get(r13).invalidateForResult(null) == InvalidationResult.IGNORED) goto L14;
        r13 = r13 + 1;
        goto L8
    L25:
        return;
    L14:
        if (this.composer.forceRecomposeScopes$runtime_release() == false) goto L24;
        this.parent.invalidate$runtime_release(this);
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.disposed;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(Set<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "values");
        Iterator<? extends Object> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r11 = r10.next();
        if (this.observations.contains(r11) == true) goto L9;
        if (this.derivedStates.contains(r11) == false) goto L4;
        return true;
    L9:
        return true;
    L11:
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        this.composer.prepareCompose$runtime_release(r5);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        Object r5 = this.lock;
        monitor-enter(r5);
        drainPendingModificationsForCompositionLocked();     // Catch: Throwable -> L21
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r10 = takeInvalidations();     // Catch: Throwable -> L10
        boolean r11 = this.composer.recompose$runtime_release(r10);     // Catch: Throwable -> L10 Exception -> L12
        if (r11 == true) goto L14;
        drainPendingModificationsLocked();     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(r5);
        return r11;
    L12:
        e = move-exception;
        this.invalidations = r10;     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
    L23:
        e = move-exception;
        abandonChanges();     // Catch: Throwable -> L21
        throw e;     // Catch: Throwable -> L21
    L19:
        if (this.abandonSet.isEmpty() == true) goto L25;
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();     // Catch: Throwable -> L21 Exception -> L23
    L25:
        throw th;     // Catch: Throwable -> L21 Exception -> L23
    L21:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        this.pendingInvalidScopes = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "values");
    L3:
        Object r5 = this.pendingModifications.get();
        boolean r11 = true;
        if (r5 != null) goto L6;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L11;
        Object r13 = r10;
    L16:
        AtomicReference<Object> r14 = this.pendingModifications;
    L18:
        if (r14.compareAndSet(r5, r13) == true) goto L23;
        if (r14.get() == r5) goto L18;
        r11 = false;
    L23:
        if (r11 == false) goto L3;
        if (r5 != null) goto L33;
        Object r15 = this.lock;
        monitor-enter(r15);
        drainPendingModificationsLocked();     // Catch: Throwable -> L30
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r15);
        return;
    L30:
        th = move-exception;
        throw th;
    L33:
        return;
    L11:
        if ((r5 instanceof Set) == false) goto L14;
        r13 = new Set[]{r5, r10};
        goto L16
    L14:
        if ((r5 instanceof Object[]) == false) goto L35;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
        r13 = ArraysKt.plus((Set[]) r5, r10);
        goto L16
    L35:
        throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
    L6:
        r12 = Intrinsics.areEqual(r5, CompositionKt.access$getPendingApplyNoModifications$p());
        goto L8
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        if (getAreChildrenComposing() == true) goto L15;
        RecomposeScopeImpl r5 = this.composer.getCurrentRecomposeScope$runtime_release();
        if (r5 == null) goto L18;
        r5.setUsed(true);
        if (r5.recordRead(r10) == true) goto L19;
        this.observations.add(r10, r5);
        if ((r10 instanceof DerivedState) == false) goto L20;
        this.derivedStates.removeScope(r10);
        Object[] r11 = ((DerivedState) r10).getCurrentRecord().getDependencies();
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L21;
        Object r14 = r11[r13];
        if (r14 == null) goto L22;
        this.derivedStates.add(r14, r10);
        r13 = r13 + 1;
        goto L11
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        Object r5 = this.lock;
        monitor-enter(r5);
        invalidateScopeOfLocked(r10);     // Catch: Throwable -> L9
        IdentityScopeMap<DerivedState<?>> r11 = this.derivedStates;     // Catch: Throwable -> L9
        int r12 = IdentityScopeMap.access$find(r11, r10);     // Catch: Throwable -> L9
        if (r12 < 0) goto L11;
        IdentityArraySet r13 = IdentityScopeMap.access$scopeSetAt(r11, r12);     // Catch: Throwable -> L9
        Object[] r14 = r13.getValues();     // Catch: Throwable -> L9
        int r15 = r13.size();     // Catch: Throwable -> L9
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L11;
        Object r17 = r14[r16];     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");     // Catch: Throwable -> L9
        invalidateScopeOfLocked((DerivedState) r17);     // Catch: Throwable -> L9
        r16 = r16 + 1;     // Catch: Throwable -> L9
    L11:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if (this.observations.contains(r5) == true) goto L6;
        this.derivedStates.removeScope(r5);
        return;
    }

    public final void removeObservation$runtime_release(Object r5, RecomposeScopeImpl r10) {
        Intrinsics.checkNotNullParameter(r5, "instance");
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.observations.remove(r5, r10);
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.composable = r5;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        if (this.disposed == true) goto L7;
        this.composable = r5;
        this.parent.composeInitial$runtime_release(this, r5);
        return;
    L7:
        throw new IllegalStateException("The composition is disposed");
    }

    public final void setPendingInvalidScopes$runtime_release(boolean r5) {
        this.pendingInvalidScopes = r5;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        Object r5 = this.lock;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isComposing() == true) goto L9;
        this.composer.verifyConsistent$runtime_release();     // Catch: Throwable -> L7
        this.slotTable.verifyWellFormed();     // Catch: Throwable -> L7
        validateRecomposeScopeAnchors(this.slotTable);     // Catch: Throwable -> L7
    L9:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> r18, boolean r19) {
        String r5 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet";
        if ((r18 instanceof IdentityArraySet) == false) goto L15;
        IdentityArraySet r10 = (IdentityArraySet) r18;
        Object[] r11 = r10.getValues();
        int r12 = r10.size();
        HashSet<RecomposeScopeImpl> r13 = null;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L27;
        Object r15 = r11[r14];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        if ((r15 instanceof RecomposeScopeImpl) == false) goto L9;
        ((RecomposeScopeImpl) r15).invalidateForResult(null);
    L14:
        r14 = r14 + 1;
        goto L5
    L9:
        r13 = addPendingInvalidationsLocked(r13, r15, r19);
        IdentityScopeMap<DerivedState<?>> r16 = this.derivedStates;
        int r17 = IdentityScopeMap.access$find(r16, r15);
        if (r17 < 0) goto L14;
        IdentityArraySet r20 = IdentityScopeMap.access$scopeSetAt(r16, r17);
        Object[] r110 = r20.getValues();
        int r21 = r20.size();
        int r111 = 0;
    L12:
        if (r111 >= r21) goto L14;
        Object r112 = r110[r111];
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        r13 = addPendingInvalidationsLocked(r13, (DerivedState) r112, r19);
        r111 = r111 + 1;
    L27:
        if (r19 == false) goto L58;
        if (this.conditionallyInvalidatedScopes.isEmpty() == true) goto L58;
        IdentityScopeMap<RecomposeScopeImpl> r22 = this.observations;
        int[] r23 = r22.getValueOrder();
        IdentityArraySet<RecomposeScopeImpl>[] r24 = r22.getScopeSets();
        Object[] r25 = r22.getValues();
        int r26 = r22.getSize();
        int r113 = 0;
        int r114 = 0;
    L31:
        if (r113 >= r26) goto L53;
        int r115 = r23[r113];
        IdentityArraySet<RecomposeScopeImpl> r116 = r24[r115];
        Intrinsics.checkNotNull(r116);
        Object[] r117 = r116.getValues();
        int r118 = r116.size();
        int r27 = 0;
        int r28 = 0;
    L33:
        if (r27 >= r118) goto L44;
        IdentityArraySet<RecomposeScopeImpl>[] r119 = r24;
        Object r29 = r117[r27];
        Intrinsics.checkNotNull(r29, r5);
        int r120 = r26;
        RecomposeScopeImpl r30 = (RecomposeScopeImpl) r29;
        String r121 = r5;
        if (this.conditionallyInvalidatedScopes.contains(r30) == true) goto L43;
        if (r13 != null) goto L38;
    L40:
        if (r28 == r27) goto L42;
        r117[r28] = r29;
    L42:
        r28 = r28 + 1;
        goto L43
    L38:
        if (r13.contains(r30) != true) goto L40;
    L43:
        r27 = r27 + 1;
        r24 = r119;
        r26 = r120;
        r5 = r121;
        goto L33
    L44:
        IdentityArraySet<RecomposeScopeImpl>[] r122 = r24;
        String r123 = r5;
        int r124 = r26;
        int r31 = r28;
    L45:
        if (r31 >= r118) goto L47;
        r117[r31] = null;
        r31 = r31 + 1;
        goto L45
    L47:
        IdentityArraySet.access$setSize$p(r116, r28);
        if (r116.size() <= 0) goto L52;
        if (r114 == r113) goto L51;
        int r32 = r23[r114];
        r23[r114] = r115;
        r23[r113] = r32;
    L51:
        r114 = r114 + 1;
    L52:
        r113 = r113 + 1;
        r24 = r122;
        r26 = r124;
        r5 = r123;
        goto L31
    L53:
        int r33 = r22.getSize();
        int r34 = r114;
    L54:
        if (r34 >= r33) goto L56;
        r25[r23[r34]] = null;
        r34 = r34 + 1;
        goto L54
    L56:
        r22.setSize(r114);
        this.conditionallyInvalidatedScopes.clear();
        cleanUpDerivedStateObservations();
        return;
    L58:
        if (r13 == null) goto L112;
        IdentityScopeMap<RecomposeScopeImpl> r35 = this.observations;
        int[] r36 = r35.getValueOrder();
        IdentityArraySet<RecomposeScopeImpl>[] r37 = r35.getScopeSets();
        Object[] r38 = r35.getValues();
        int r39 = r35.getSize();
        int r40 = 0;
        int r41 = 0;
    L60:
        if (r40 >= r39) goto L78;
        int r42 = r36[r40];
        IdentityArraySet<RecomposeScopeImpl> r125 = r37[r42];
        Intrinsics.checkNotNull(r125);
        Object[] r126 = r125.getValues();
        int r127 = r125.size();
        int r128 = 0;
        int r129 = 0;
    L62:
        if (r128 >= r127) goto L69;
        Object r130 = r126[r128];
        Intrinsics.checkNotNull(r130, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        if (r13.contains((RecomposeScopeImpl) r130) == true) goto L68;
        if (r129 == r128) goto L67;
        r126[r129] = r130;
    L67:
        r129 = r129 + 1;
    L68:
        r128 = r128 + 1;
        goto L62
    L69:
        int r43 = r129;
    L70:
        if (r43 >= r127) goto L72;
        r126[r43] = null;
        r43 = r43 + 1;
        goto L70
    L72:
        IdentityArraySet.access$setSize$p(r125, r129);
        if (r125.size() <= 0) goto L77;
        if (r41 == r40) goto L76;
        int r44 = r36[r41];
        r36[r41] = r42;
        r36[r40] = r44;
    L76:
        r41 = r41 + 1;
    L77:
        r40 = r40 + 1;
        goto L60
    L78:
        int r45 = r35.getSize();
        int r46 = r41;
    L79:
        if (r46 >= r45) goto L81;
        r38[r36[r46]] = null;
        r46 = r46 + 1;
        goto L79
    L81:
        r35.setSize(r41);
        cleanUpDerivedStateObservations();
        return;
    L112:
        return;
    L15:
        Iterator<T> r47 = r18.iterator();
        r13 = null;
    L17:
        if (r47.hasNext() == false) goto L27;
        Object r48 = r47.next();
        if ((r48 instanceof RecomposeScopeImpl) == true) goto L20;
        HashSet<RecomposeScopeImpl> r49 = addPendingInvalidationsLocked(r13, r48, r19);
        IdentityScopeMap<DerivedState<?>> r50 = this.derivedStates;
        int r51 = IdentityScopeMap.access$find(r50, r48);
        if (r51 < 0) goto L26;
        IdentityArraySet r52 = IdentityScopeMap.access$scopeSetAt(r50, r51);
        Object[] r53 = r52.getValues();
        int r54 = r52.size();
        int r55 = 0;
    L24:
        if (r55 >= r54) goto L26;
        Object r131 = r53[r55];
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        r49 = addPendingInvalidationsLocked(r49, (DerivedState) r131, r19);
        r55 = r55 + 1;
    L26:
        r13 = r49;
        goto L17
    L20:
        ((RecomposeScopeImpl) r48).invalidateForResult(null);
        goto L17
    }

    public /* synthetic */ CompositionImpl(CompositionContext r5, Applier r10, CoroutineContext r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r5, r10, r11);
    }
}
