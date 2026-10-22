package androidx.compose.runtime.snapshots;

import ai.j0;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00014B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0001J)\u0010\u001f\u001a\u00020\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00130\u0003J\b\u0010!\u001a\u00020\u0013H\u0002J&\u0010\"\u001a\u00020\u0011\"\b\b\u0000\u0010#*\u00020\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001c\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010)\u001a\u00020\rJ?\u0010*\u001a\u00020\u0005\"\b\b\u0000\u0010#*\u00020\u00012\u0006\u0010\u001e\u001a\u0002H#2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0016\u00103\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", ExifInterface.GPS_DIRECTION_TRUE, "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshotStateObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,610:1\n182#1,2:615\n184#1,2:628\n182#1,2:641\n184#1,2:654\n182#1,2:656\n184#1,2:669\n182#1,2:671\n184#1,2:684\n1182#2:611\n1161#2,2:612\n1#3:614\n460#4,11:617\n460#4,11:630\n460#4,11:643\n460#4,11:658\n460#4,11:673\n366#4,12:686\n728#4,2:698\n*S KotlinDebug\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver\n*L\n66#1:615,2\n66#1:628,2\n263#1:641,2\n263#1:654,2\n273#1:656,2\n273#1:669,2\n305#1:671,2\n305#1:684,2\n174#1:611\n174#1:612,2\n66#1:617,11\n183#1:630,11\n263#1:643,11\n273#1:658,11\n305#1:673,11\n318#1:686,12\n321#1:698,2\n*E\n"})
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final MutableVector<ObservedScopeMap> observedScopeMaps;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges;
    private final Function1<Object, Unit> readObserver;
    private boolean sendingNotifications;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020\u0004J0\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010+J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0001J(\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\bH\u0002J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0002J)\u00100\u001a\u00020\u00042!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0\u0003J\u0012\u00104\u001a\u00020\u00042\n\u00105\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshotStateObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 IdentityArrayIntMap.kt\nandroidx/compose/runtime/collection/IdentityArrayIntMap\n+ 6 IdentityArrayMap.kt\nandroidx/compose/runtime/collection/IdentityArrayMap\n+ 7 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySetKt\n+ 8 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 9 IdentityScopeMap.kt\nandroidx/compose/runtime/collection/IdentityScopeMap\n+ 10 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,610:1\n1182#2:611\n1161#2,2:612\n377#3,6:614\n383#3,2:621\n48#4:620\n460#4,11:756\n137#5,22:623\n172#5,8:645\n172#5,8:660\n125#6,7:653\n132#6,15:668\n384#7,2:683\n387#7:723\n389#7:755\n108#8,5:685\n108#8,5:693\n108#8,7:701\n114#8:709\n108#8,7:714\n114#8:722\n108#8,5:725\n108#8,7:733\n114#8:741\n108#8,7:746\n108#8,7:770\n108#8,7:778\n80#9,3:690\n80#9,3:698\n84#9:708\n84#9:710\n80#9,3:711\n84#9:721\n80#9,3:730\n84#9:740\n84#9:742\n80#9,3:743\n84#9:753\n80#9,3:767\n84#9:777\n1855#10:724\n1856#10:754\n*S KotlinDebug\n*F\n+ 1 SnapshotStateObserver.kt\nandroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap\n*L\n368#1:611\n368#1:612,2\n466#1:614,6\n466#1:621,2\n466#1:620\n575#1:756,11\n479#1:623,22\n493#1:645,8\n505#1:660,8\n502#1:653,7\n502#1:668,15\n543#1:683,2\n543#1:723\n543#1:755\n543#1:685,5\n546#1:693,5\n557#1:701,7\n546#1:709\n568#1:714,7\n543#1:722\n546#1:725,5\n557#1:733,7\n546#1:741\n568#1:746,7\n588#1:770,7\n605#1:778,7\n546#1:690,3\n557#1:698,3\n557#1:708\n546#1:710\n568#1:711,3\n568#1:721\n557#1:730,3\n557#1:740\n546#1:742\n568#1:743,3\n568#1:753\n588#1:767,3\n588#1:777\n543#1:724\n543#1:754\n*E\n"})
    public static final class ObservedScopeMap {
        private Object currentScope;
        private IdentityArrayIntMap currentScopeReads;
        private int currentToken;
        private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final IdentityArraySet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;
        private final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues;
        private final MutableVector<DerivedState<?>> statesToReread;
        private final IdentityScopeMap<Object> valueToScopes;

        public ObservedScopeMap(Function1<Object, Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "onChanged");
            this.onChanged = r5;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap();
            this.scopeToValues = new IdentityArrayMap(0, 1, null);
            this.invalidated = new IdentityArraySet();
            this.statesToReread = new MutableVector(new DerivedState[16], 0);
            this.derivedStateObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1(this);
            this.dependencyToDerivedStates = new IdentityScopeMap();
            this.recordedDerivedStateValues = new HashMap();
        }

        public static final /* synthetic */ int access$getDeriveStateScopeCount$p(ObservedScopeMap r5) {
            return r5.deriveStateScopeCount;
        }

        public static final /* synthetic */ void access$setDeriveStateScopeCount$p(ObservedScopeMap r5, int r10) {
            r5.deriveStateScopeCount = r10;
        }

        private final void clearObsoleteStateReads(Object r12) {
            int r5 = this.currentToken;
            IdentityArrayIntMap r10 = this.currentScopeReads;
            if (r10 == null) goto L26;
            Object[] r11 = r10.getKeys();
            int[] r13 = r10.getValues();
            int r14 = r10.getSize();
            int r15 = 0;
            int r16 = 0;
        L5:
            if (r15 >= r14) goto L17;
            Object r17 = r11[r15];
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Any");
            int r18 = r13[r15];
            if (r18 == r5) goto L9;
            boolean r19 = true;
        L10:
            if (r19 == false) goto L12;
            removeObservation(r12, r17);
        L12:
            if (r19 == true) goto L16;
            if (r16 == r15) goto L15;
            r11[r16] = r17;
            r13[r16] = r18;
        L15:
            r16 = r16 + 1;
        L16:
            r15 = r15 + 1;
            goto L5
        L9:
            r19 = false;
            goto L10
        L17:
            int r110 = r16;
        L18:
            if (r110 >= r14) goto L20;
            r11[r110] = null;
            r110 = r110 + 1;
            goto L18
        L20:
            IdentityArrayIntMap.access$setSize$p(r10, r16);
            return;
        }

        private final void removeObservation(Object r5, Object r10) {
            this.valueToScopes.remove(r10, r5);
            if ((r10 instanceof DerivedState) == true) goto L5;
            return;
        L5:
            if (this.valueToScopes.contains(r10) == true) goto L9;
            this.dependencyToDerivedStates.removeScope(r10);
            this.recordedDerivedStateValues.remove(r10);
            return;
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(Object r10) {
            Intrinsics.checkNotNullParameter(r10, "scope");
            IdentityArrayIntMap r5 = this.scopeToValues.remove(r10);
            if (r5 != null) goto L5;
            return;
        L5:
            Object[] r11 = r5.getKeys();
            int[] r12 = r5.getValues();
            int r13 = r5.getSize();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L8;
            Object r15 = r11[r14];
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Any");
            int r16 = r12[r14];
            removeObservation(r10, r15);
            r14 = r14 + 1;
            goto L6
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet<Object> r5 = this.invalidated;
            Function1<Object, Unit> r10 = this.onChanged;
            Object[] r11 = r5.getValues();
            int r12 = r5.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            Object r14 = r11[r13];
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            r10.invoke(r14);
            r13 = r13 + 1;
            goto L3
        L5:
            r5.clear();
        }

        public final void observe(Object r10, Function1<Object, Unit> r11, Function0<Unit> r12) {
            Intrinsics.checkNotNullParameter(r10, "scope");
            Intrinsics.checkNotNullParameter(r11, "readObserver");
            Intrinsics.checkNotNullParameter(r12, "block");
            Object r5 = this.currentScope;
            IdentityArrayIntMap r13 = this.currentScopeReads;
            int r14 = this.currentToken;
            this.currentScope = r10;
            this.currentScopeReads = this.scopeToValues.get(r10);
            if (this.currentToken != (-1)) goto L5;
            this.currentToken = SnapshotKt.currentSnapshot().getId();
        L5:
            DerivedStateObserver r15 = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> r16 = SnapshotStateKt.derivedStateObservers();
            r16.add(r15);     // Catch: Throwable -> L9
            Snapshot.Companion.observe(r11, null, r12);     // Catch: Throwable -> L9
            r16.removeAt(r16.getSize() - 1);
            Object r17 = this.currentScope;
            Intrinsics.checkNotNull(r17);
            clearObsoleteStateReads(r17);
            this.currentScope = r5;
            this.currentScopeReads = r13;
            this.currentToken = r14;
            return;
        L9:
            th = move-exception;
            r16.removeAt(r16.getSize() - 1);
            throw th;
        }

        public final boolean recordInvalidation(Set<? extends Object> r20) {
            Intrinsics.checkNotNullParameter(r20, "changes");
            IdentityScopeMap<DerivedState<?>> r5 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> r10 = this.recordedDerivedStateValues;
            IdentityScopeMap<Object> r11 = this.valueToScopes;
            IdentityArraySet<Object> r12 = this.invalidated;
            if ((r20 instanceof IdentityArraySet) == false) goto L33;
            IdentityArraySet r13 = (IdentityArraySet) r20;
            Object[] r14 = r13.getValues();
            int r15 = r13.size();
            int r16 = 0;
            boolean r17 = false;
        L5:
            if (r16 >= r15) goto L61;
            Object r18 = r14[r16];
            Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (r5.contains(r18) == false) goto L26;
            int r19 = IdentityScopeMap.access$find(r5, r18);
            if (r19 < 0) goto L26;
            IdentityArraySet r110 = IdentityScopeMap.access$scopeSetAt(r5, r19);
            Object[] r111 = r110.getValues();
            int r112 = r110.size();
            int r113 = 0;
        L11:
            if (r113 >= r112) goto L25;
            Object r21 = r111[r113];
            Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            DerivedState<?> r22 = (DerivedState) r21;
            Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
            int r23 = r15;
            Object r24 = r10.get(r22);
            SnapshotMutationPolicy<?> r114 = r22.getPolicy();
            if (r114 != null) goto L15;
            r114 = SnapshotStateKt.structuralEqualityPolicy();
        L15:
            Object[] r115 = r14;
            boolean r116 = r17;
            if (r114.equivalent(r22.getCurrentRecord().getCurrentValue(), r24) == true) goto L22;
            int r25 = IdentityScopeMap.access$find(r11, r22);
            if (r25 < 0) goto L23;
            IdentityArraySet r26 = IdentityScopeMap.access$scopeSetAt(r11, r25);
            Object[] r27 = r26.getValues();
            int r28 = r26.size();
            r17 = r116;
            int r29 = 0;
        L20:
            if (r29 >= r28) goto L24;
            Object r117 = r27[r29];
            Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            r12.add(r117);
            r29 = r29 + 1;
            r17 = true;
        L24:
            r113 = r113 + 1;
            r15 = r23;
            r14 = r115;
        L23:
            r17 = r116;
            goto L24
        L22:
            this.statesToReread.add(r22);
            goto L23
        L25:
            int r210 = r15;
            Object[] r118 = r14;
        L27:
            int r30 = IdentityScopeMap.access$find(r11, r18);
            if (r30 < 0) goto L32;
            IdentityArraySet r31 = IdentityScopeMap.access$scopeSetAt(r11, r30);
            Object[] r32 = r31.getValues();
            int r33 = r31.size();
            int r34 = 0;
        L30:
            if (r34 >= r33) goto L32;
            Object r119 = r32[r34];
            Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            r12.add(r119);
            r34 = r34 + 1;
            r17 = true;
        L32:
            r16 = r16 + 1;
            r15 = r210;
            r14 = r118;
        L26:
            r210 = r15;
            r118 = r14;
        L61:
            if (this.statesToReread.isNotEmpty() == false) goto L68;
            MutableVector<DerivedState<?>> r35 = this.statesToReread;
            int r36 = r35.getSize();
            if (r36 <= 0) goto L67;
            DerivedState<?>[] r37 = r35.getContent();
            int r120 = 0;
        L65:
            rereadDerivedState(r37[r120]);
            r120 = r120 + 1;
            if (r120 < r36) goto L65;
        L67:
            this.statesToReread.clear();
        L68:
            return r17;
        L33:
            Iterator r38 = r20.iterator();
            r17 = false;
        L35:
            if (r38.hasNext() == false) goto L61;
            Object r39 = r38.next();
            if (r5.contains(r39) == false) goto L54;
            int r40 = IdentityScopeMap.access$find(r5, r39);
            if (r40 < 0) goto L54;
            IdentityArraySet r41 = IdentityScopeMap.access$scopeSetAt(r5, r40);
            Object[] r121 = r41.getValues();
            int r42 = r41.size();
            int r122 = 0;
        L41:
            if (r122 >= r42) goto L54;
            Object r123 = r121[r122];
            Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            DerivedState<?> r124 = (DerivedState) r123;
            Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
            Object r125 = r10.get(r124);
            SnapshotMutationPolicy<?> r126 = r124.getPolicy();
            if (r126 != null) goto L45;
            r126 = SnapshotStateKt.structuralEqualityPolicy();
        L45:
            Iterator r211 = r38;
            if (r126.equivalent(r124.getCurrentRecord().getCurrentValue(), r125) == true) goto L52;
            int r43 = IdentityScopeMap.access$find(r11, r124);
            if (r43 < 0) goto L53;
            IdentityArraySet r44 = IdentityScopeMap.access$scopeSetAt(r11, r43);
            Object[] r127 = r44.getValues();
            int r45 = r44.size();
            int r128 = 0;
        L50:
            if (r128 >= r45) goto L53;
            Object r129 = r127[r128];
            Intrinsics.checkNotNull(r129, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            r12.add(r129);
            r128 = r128 + 1;
            r17 = true;
        L53:
            r122 = r122 + 1;
            r38 = r211;
            goto L41
        L52:
            this.statesToReread.add(r124);
        L54:
            Iterator r212 = r38;
            int r46 = IdentityScopeMap.access$find(r11, r39);
            if (r46 < 0) goto L59;
            IdentityArraySet r47 = IdentityScopeMap.access$scopeSetAt(r11, r46);
            Object[] r48 = r47.getValues();
            int r49 = r47.size();
            int r50 = 0;
        L57:
            if (r50 >= r49) goto L59;
            Object r130 = r48[r50];
            Intrinsics.checkNotNull(r130, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            r12.add(r130);
            r50 = r50 + 1;
            r17 = true;
        L59:
            r38 = r212;
            goto L35
        }

        public final void recordRead(Object r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            Object r10 = this.currentScope;
            Intrinsics.checkNotNull(r10);
            int r11 = this.currentToken;
            IdentityArrayIntMap r12 = this.currentScopeReads;
            if (r12 != null) goto L5;
            r12 = new IdentityArrayIntMap();
            this.currentScopeReads = r12;
            this.scopeToValues.set(r10, r12);
            Unit r13 = Unit.INSTANCE;
        L5:
            recordRead(r5, r11, r10, r12);
        }

        public final void removeScopeIf(Function1<Object, Boolean> r14) {
            Intrinsics.checkNotNullParameter(r14, "predicate");
            IdentityArrayMap<Object, IdentityArrayIntMap> r5 = this.scopeToValues;
            int r10 = r5.getSize();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r11 >= r10) goto L16;
            Object r13 = r5.getKeys()[r11];
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            IdentityArrayIntMap r15 = (IdentityArrayIntMap) r5.getValues()[r11];
            Boolean r16 = r14.invoke(r13);
            if (r16.booleanValue() == false) goto L10;
            Object[] r17 = r15.getKeys();
            int[] r18 = r15.getValues();
            int r19 = r15.getSize();
            int r110 = 0;
        L7:
            if (r110 >= r19) goto L10;
            Object r111 = r17[r110];
            Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Any");
            int r112 = r18[r110];
            removeObservation(r13, r111);
            r110 = r110 + 1;
        L10:
            if (r16.booleanValue() == true) goto L14;
            if (r12 == r11) goto L13;
            r5.getKeys()[r12] = r13;
            r5.getValues()[r12] = r5.getValues()[r11];
        L13:
            r12 = r12 + 1;
        L14:
            r11 = r11 + 1;
            goto L3
        L16:
            if (r5.getSize() <= r12) goto L27;
            int r113 = r5.getSize();
            int r114 = r12;
        L18:
            if (r114 >= r113) goto L20;
            r5.getKeys()[r114] = null;
            r5.getValues()[r114] = null;
            r114 = r114 + 1;
            goto L18
        L20:
            IdentityArrayMap.access$setSize$p(r5, r12);
            return;
        }

        public final void rereadDerivedState(DerivedState<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "derivedState");
            IdentityArrayMap<Object, IdentityArrayIntMap> r5 = this.scopeToValues;
            int r11 = SnapshotKt.currentSnapshot().getId();
            IdentityScopeMap<Object> r12 = this.valueToScopes;
            int r13 = IdentityScopeMap.access$find(r12, r10);
            if (r13 < 0) goto L10;
            IdentityArraySet r14 = IdentityScopeMap.access$scopeSetAt(r12, r13);
            Object[] r15 = r14.getValues();
            int r16 = r14.size();
            int r17 = 0;
        L5:
            if (r17 >= r16) goto L14;
            Object r18 = r15[r17];
            Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            IdentityArrayIntMap r19 = r5.get(r18);
            if (r19 != null) goto L9;
            r19 = new IdentityArrayIntMap();
            r5.set(r18, r19);
            Unit r20 = Unit.INSTANCE;
        L9:
            recordRead(r10, r11, r18, r19);
            r17 = r17 + 1;
            goto L5
        L14:
            return;
        }

        private final void recordRead(Object r5, int r10, Object r11, IdentityArrayIntMap r12) {
            if (this.deriveStateScopeCount <= 0) goto L5;
            return;
        L5:
            int r13 = r12.add(r5, r10);
            if ((r5 instanceof DerivedState) == false) goto L14;
            if (r13 == r10) goto L14;
            DerivedState.Record r14 = ((DerivedState) r5).getCurrentRecord();
            this.recordedDerivedStateValues.put(r5, r14.getCurrentValue());
            Object[] r15 = r14.getDependencies();
            IdentityScopeMap<DerivedState<?>> r16 = this.dependencyToDerivedStates;
            r16.removeScope(r5);
            int r17 = r15.length;
            int r18 = 0;
        L9:
            if (r18 >= r17) goto L14;
            Object r19 = r15[r18];
            if (r19 == null) goto L14;
            r16.add(r19, r5);
            r18 = r18 + 1;
        L14:
            if (r13 != (-1)) goto L19;
            this.valueToScopes.add(r5, r11);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "onChangedExecutor");
        this.onChangedExecutor = r5;
        this.pendingChanges = new AtomicReference(null);
        this.applyObserver = new SnapshotStateObserver$applyObserver$1(this);
        this.readObserver = new SnapshotStateObserver$readObserver$1(this);
        this.observedScopeMaps = new MutableVector(new ObservedScopeMap[16], 0);
    }

    public static final /* synthetic */ void access$addChanges(SnapshotStateObserver r5, Set r10) {
        r5.addChanges(r10);
    }

    public static final /* synthetic */ boolean access$drainChanges(SnapshotStateObserver r5) {
        return r5.drainChanges();
    }

    public static final /* synthetic */ ObservedScopeMap access$getCurrentMap$p(SnapshotStateObserver r5) {
        return r5.currentMap;
    }

    public static final /* synthetic */ MutableVector access$getObservedScopeMaps$p(SnapshotStateObserver r5) {
        return r5.observedScopeMaps;
    }

    public static final /* synthetic */ boolean access$getSendingNotifications$p(SnapshotStateObserver r5) {
        return r5.sendingNotifications;
    }

    public static final /* synthetic */ boolean access$isPaused$p(SnapshotStateObserver r5) {
        return r5.isPaused;
    }

    public static final /* synthetic */ void access$sendNotifications(SnapshotStateObserver r5) {
        r5.sendNotifications();
    }

    public static final /* synthetic */ void access$setSendingNotifications$p(SnapshotStateObserver r5, boolean r10) {
        r5.sendingNotifications = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addChanges(Set<? extends Object> r5) {
    L2:
        Object r10 = this.pendingChanges.get();
        if (r10 != null) goto L6;
        Set<? extends Object> r11 = r5;
    L11:
        AtomicReference<Object> r12 = this.pendingChanges;
    L13:
        if (r12.compareAndSet(r10, r11) == true) goto L14;
        if (r12.get() == r10) goto L13;
    L14:
        return;
    L6:
        if ((r10 instanceof Set) == false) goto L9;
        r11 = CollectionsKt.listOf(new Set[]{r10, r5});
        goto L11
    L9:
        if ((r10 instanceof List) == false) goto L18;
        r11 = CollectionsKt.plus((Collection) r10, CollectionsKt.listOf(r5));
        goto L11
    L18:
        report();
        throw new KotlinNothingValueException();
    }

    private final boolean drainChanges() {
        MutableVector<ObservedScopeMap> r5 = this.observedScopeMaps;
        monitor-enter(r5);
        boolean r10 = this.sendingNotifications;     // Catch: Throwable -> L34
        monitor-exit(r5);
        if (r10 == false) goto L9;
        return false;
    L9:
        boolean r11 = false;
    L10:
        Set<? extends Object> r12 = removeChanges();
        if (r12 == null) goto L12;
        MutableVector<ObservedScopeMap> r13 = this.observedScopeMaps;
        monitor-enter(r13);
        MutableVector<ObservedScopeMap> r14 = this.observedScopeMaps;     // Catch: Throwable -> L27
        int r15 = r14.getSize();     // Catch: Throwable -> L27
        if (r15 <= 0) goto L29;
        ObservedScopeMap[] r16 = r14.getContent();     // Catch: Throwable -> L27
        int r17 = 0;
    L19:
        if (r16[r17].recordInvalidation(r12) == true) goto L23;
        if (r11 == true) goto L23;
        r11 = false;
    L24:
        r17 = r17 + 1;     // Catch: Throwable -> L27
        if (r17 < r15) goto L19;
    L23:
        r11 = true;
    L29:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r13);
    L27:
        th = move-exception;
        throw th;
    L12:
        return r11;
    L34:
        th = move-exception;
        throw th;
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> r10) {
        MutableVector<ObservedScopeMap> r5 = this.observedScopeMaps;
        int r11 = r5.getSize();
        if (r11 <= 0) goto L10;
        ObservedScopeMap[] r12 = r5.getContent();
        int r13 = 0;
    L5:
        ObservedScopeMap r14 = r12[r13];
        if (r14.getOnChanged() == r10) goto L11;
        r13 = r13 + 1;
        if (r13 < r11) goto L5;
    L11:
        ObservedScopeMap r15 = r14;
        if (r15 != null) goto L15;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap r16 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 1));
        this.observedScopeMaps.add(r16);
        return r16;
    L15:
        return r15;
    L10:
        r14 = null;
        goto L11
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> r10) {
        MutableVector<ObservedScopeMap> r5 = this.observedScopeMaps;
        monitor-enter(r5);
        MutableVector<ObservedScopeMap> r11 = this.observedScopeMaps;     // Catch: Throwable -> L10
        int r12 = r11.getSize();     // Catch: Throwable -> L10
        if (r12 <= 0) goto L12;
        ObservedScopeMap[] r13 = r11.getContent();     // Catch: Throwable -> L10
        int r14 = 0;
    L7:
        r10.invoke(r13[r14]);     // Catch: Throwable -> L10
        r14 = r14 + 1;     // Catch: Throwable -> L10
        if (r14 < r12) goto L7;
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r5);
        InlineMarker.finallyEnd(1);
        return;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final Set<Object> removeChanges() {
    L2:
        Object r5 = this.pendingChanges.get();
        Object r10 = null;
        if (r5 == null) goto L4;
        if ((r5 instanceof Set) == false) goto L9;
        Set<Object> r11 = (Set) r5;
    L17:
        AtomicReference<Object> r12 = this.pendingChanges;
    L19:
        if (r12.compareAndSet(r5, r10) == true) goto L20;
        if (r12.get() == r5) goto L19;
    L20:
        return r11;
    L9:
        if ((r5 instanceof List) == false) goto L24;
        List r13 = (List) r5;
        Set<Object> r14 = (Set) r13.get(0);
        if (r13.size() != 2) goto L14;
        r10 = r13.get(1);
    L16:
        r11 = r14;
        goto L17
    L14:
        if (r13.size() <= 2) goto L16;
        r10 = r13.subList(1, r13.size());
        goto L16
    L24:
        report();
        throw new KotlinNothingValueException();
    L4:
        return null;
    }

    private final Void report() {
        throw j0.z("Unexpected notification");
    }

    private final void sendNotifications() {
        this.onChangedExecutor.invoke(new AnonymousClass1(this));
    }

    public final void clear(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        MutableVector<ObservedScopeMap> r10 = this.observedScopeMaps;
        monitor-enter(r10);
        MutableVector<ObservedScopeMap> r11 = this.observedScopeMaps;     // Catch: Throwable -> L10
        int r12 = r11.getSize();     // Catch: Throwable -> L10
        if (r12 <= 0) goto L12;
        ObservedScopeMap[] r13 = r11.getContent();     // Catch: Throwable -> L10
        int r14 = 0;
    L7:
        r13[r14].clearScopeObservations(r5);     // Catch: Throwable -> L10
        r14 = r14 + 1;     // Catch: Throwable -> L10
        if (r14 < r12) goto L7;
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void clearIf(Function1<Object, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        MutableVector<ObservedScopeMap> r10 = this.observedScopeMaps;
        monitor-enter(r10);
        MutableVector<ObservedScopeMap> r11 = this.observedScopeMaps;     // Catch: Throwable -> L10
        int r12 = r11.getSize();     // Catch: Throwable -> L10
        if (r12 <= 0) goto L12;
        ObservedScopeMap[] r13 = r11.getContent();     // Catch: Throwable -> L10
        int r14 = 0;
    L7:
        r13[r14].removeScopeIf(r5);     // Catch: Throwable -> L10
        r14 = r14 + 1;     // Catch: Throwable -> L10
        if (r14 < r12) goto L7;
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void notifyChanges(Set<? extends Object> r5, Snapshot r10) {
        Intrinsics.checkNotNullParameter(r5, "changes");
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        this.applyObserver.mo2invoke(r5, r10);
    }

    public final <T> void observeReads(T r5, Function1<? super T, Unit> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r10, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(r11, "block");
        MutableVector<ObservedScopeMap> r12 = this.observedScopeMaps;
        monitor-enter(r12);
        ObservedScopeMap r13 = ensureMap(r10);     // Catch: Throwable -> L13
        monitor-exit(r12);
        boolean r14 = this.isPaused;
        ObservedScopeMap r15 = this.currentMap;
        this.isPaused = false;     // Catch: Throwable -> L10
        this.currentMap = r13;     // Catch: Throwable -> L10
        r13.observe(r5, this.readObserver, r11);     // Catch: Throwable -> L10
        this.currentMap = r15;
        this.isPaused = r14;
        return;
    L10:
        th = move-exception;
        this.currentMap = r15;
        this.isPaused = r14;
        throw th;
    L13:
        th = move-exception;
        throw th;
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle r5 = this.applyUnsubscribe;
        if (r5 == null) goto L6;
        r5.dispose();
        return;
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        boolean r10 = this.isPaused;
        this.isPaused = true;
        r5.invoke();     // Catch: Throwable -> L6
        this.isPaused = r10;
        return;
    L6:
        th = move-exception;
        this.isPaused = r10;
        throw th;
    }

    public final void clear() {
        MutableVector<ObservedScopeMap> r5 = this.observedScopeMaps;
        monitor-enter(r5);
        MutableVector<ObservedScopeMap> r10 = this.observedScopeMaps;     // Catch: Throwable -> L10
        int r11 = r10.getSize();     // Catch: Throwable -> L10
        if (r11 <= 0) goto L12;
        ObservedScopeMap[] r12 = r10.getContent();     // Catch: Throwable -> L10
        int r13 = 0;
    L7:
        r12[r13].clear();     // Catch: Throwable -> L10
        r13 = r13 + 1;     // Catch: Throwable -> L10
        if (r13 < r11) goto L7;
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r5);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
