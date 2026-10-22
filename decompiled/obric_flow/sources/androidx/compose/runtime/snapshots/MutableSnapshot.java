package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J'\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\u0080\bø\u0001\u0000¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/compose/runtime/collection/IdentityArraySet;", "modified", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setModified", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/MutableSnapshot\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 5 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 6 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2290:1\n978#1,2:2291\n984#1,3:2295\n987#1,6:2300\n978#1,2:2342\n984#1,3:2346\n987#1,6:2351\n978#1,9:2387\n987#1,6:2398\n1722#2:2293\n1722#2:2298\n1722#2:2306\n1722#2:2320\n1722#2:2344\n1722#2:2349\n1722#2:2376\n1722#2:2385\n1722#2:2396\n1722#2:2404\n1722#2:2406\n70#3:2294\n70#3:2299\n70#3:2307\n70#3:2321\n70#3:2345\n70#3:2350\n70#3:2377\n70#3:2386\n70#3:2397\n70#3:2405\n70#3:2407\n33#4,6:2308\n33#4,6:2314\n33#4,6:2336\n33#4,4:2372\n38#4:2378\n33#4,6:2379\n108#5,7:2322\n108#5,7:2329\n108#5,7:2358\n108#5,7:2365\n192#6:2357\n1#7:2408\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/MutableSnapshot\n*L\n676#1:2291,2\n676#1:2295,3\n676#1:2300,6\n808#1:2342,2\n808#1:2346,3\n808#1:2351,6\n995#1:2387,9\n995#1:2398,6\n677#1:2293\n676#1:2298\n728#1:2306\n781#1:2320\n809#1:2344\n808#1:2349\n961#1:2376\n986#1:2385\n995#1:2396\n998#1:2404\n1022#1:2406\n677#1:2294\n676#1:2299\n728#1:2307\n781#1:2321\n809#1:2345\n808#1:2350\n961#1:2377\n986#1:2386\n995#1:2397\n998#1:2405\n1022#1:2407\n767#1:2308,6\n773#1:2314,6\n786#1:2336,6\n958#1:2372,4\n958#1:2378\n969#1:2379,6\n784#1:2322,7\n785#1:2329,7\n873#1:2358,7\n908#1:2365,7\n855#1:2357\n*E\n"})
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private static final int[] EmptyIntArray = null;
    private boolean applied;
    private List<? extends StateObject> merged;
    private IdentityArraySet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        EmptyIntArray = new int[0];
    }

    public MutableSnapshot(int r5, SnapshotIdSet r10, Function1<Object, Unit> r11, Function1<Object, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "invalid");
        super(r5, r10, null);
        this.readObserver = r11;
        this.writeObserver = r12;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    private final void abandon() {
        IdentityArraySet<StateObject> r5 = getModified$runtime_release();
        if (r5 == null) goto L15;
        validateNotApplied();
        setModified(null);
        int r10 = getId();
        Object[] r11 = r5.getValues();
        int r12 = r5.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L15;
        Object r14 = r11[r13];
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        StateRecord r15 = ((StateObject) r14).getFirstStateRecord();
    L7:
        if (r15 == null) goto L14;
        if (r15.getSnapshotId$runtime_release() != r10) goto L11;
    L12:
        r15.setSnapshotId$runtime_release(0);
    L13:
        r15 = r15.getNext$runtime_release();
        goto L7
    L11:
        if (CollectionsKt.contains(this.previousIds, Integer.valueOf(r15.getSnapshotId$runtime_release())) == false) goto L13;
    L14:
        r13 = r13 + 1;
    L15:
        closeAndReleasePinning$runtime_release();
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int r5 = this.previousPinnedSnapshots.length;
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[r10]);
        r10 = r10 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot r5, Function1 r10, Function1 r11, int r12, Object r13) {
        if (r13 != null) goto L12;
        if ((r12 & 1) == 0) goto L7;
        r10 = null;
    L7:
        if ((r12 & 2) == 0) goto L10;
        r11 = null;
    L10:
        return r5.takeNestedMutableSnapshot(r10, r11);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    private final void validateNotApplied() {
        if (this.applied == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Unsupported operation on a snapshot that has been applied");
    }

    private final void validateNotAppliedOrPinned() {
        if (this.applied == true) goto L5;
        return;
    L5:
        if (Snapshot.access$getPinningTrackingHandle$p(this) < 0) goto L8;
        return;
    L8:
        throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    public final <T> T advance$runtime_release(Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        recordPrevious$runtime_release(getId());
        T r11 = r10.invoke();
        if (getApplied$runtime_release() == false) goto L5;
    L17:
        return r11;
    L5:
        if (getDisposed$runtime_release() == true) goto L17;
        int r5 = getId();
        Object r12 = SnapshotKt.getLock();
        monitor-enter(r12);
        int r13 = SnapshotKt.access$getNextSnapshotId$p();     // Catch: Throwable -> L12
        SnapshotKt.access$setNextSnapshotId$p(r13 + 1);     // Catch: Throwable -> L12
        setId$runtime_release(r13);     // Catch: Throwable -> L12
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(getId()));     // Catch: Throwable -> L12
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        monitor-exit(r12);
        InlineMarker.finallyEnd(1);
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), r5 + 1, getId()));
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public SnapshotApplyResult apply() {
        IdentityArraySet<StateObject> r5 = getModified$runtime_release();
        if (r5 == null) goto L5;
        Map<StateRecord, ? extends StateRecord> r10 = SnapshotKt.access$optimisticMerges((MutableSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get(), this, SnapshotKt.access$getOpenSnapshots$p().clear(((GlobalSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get()).getId()));
    L6:
        List r11 = CollectionsKt.emptyList();
        Object r12 = SnapshotKt.getLock();
        monitor-enter(r12);
        SnapshotKt.access$validateOpen(this);     // Catch: Throwable -> L18
        if (r5 != null) goto L11;
    L20:
        closeLocked$runtime_release();     // Catch: Throwable -> L18
        GlobalSnapshot r13 = (GlobalSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get();     // Catch: Throwable -> L18
        SnapshotKt.access$takeNewGlobalSnapshot(r13, SnapshotKt.access$getEmptyLambda$p());     // Catch: Throwable -> L18
        IdentityArraySet<StateObject> r14 = r13.getModified$runtime_release();     // Catch: Throwable -> L18
        if (r14 != null) goto L23;
    L26:
        r14 = null;
    L27:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r12);
        this.applied = true;
        int r16 = 0;
        if (r14 != null) goto L32;
    L37:
        if (r5 != null) goto L39;
    L44:
        Object r17 = SnapshotKt.getLock();
        monitor-enter(r17);
        releasePinnedSnapshotsForCloseLocked$runtime_release();     // Catch: Throwable -> L51
        SnapshotKt.access$checkAndOverwriteUnusedRecordsLocked();     // Catch: Throwable -> L51
        if (r14 == null) goto L53;
        Object[] r18 = r14.getValues();     // Catch: Throwable -> L51
        int r19 = r14.size();     // Catch: Throwable -> L51
        int r20 = 0;
    L49:
        if (r20 >= r19) goto L53;
        Object r21 = r18[r20];     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");     // Catch: Throwable -> L51
        SnapshotKt.access$processForUnusedRecordsLocked((StateObject) r21);     // Catch: Throwable -> L51
        r20 = r20 + 1;     // Catch: Throwable -> L51
    L53:
        if (r5 == null) goto L57;
        Object[] r22 = r5.getValues();     // Catch: Throwable -> L51
        int r23 = r5.size();     // Catch: Throwable -> L51
        int r24 = 0;
    L55:
        if (r24 >= r23) goto L57;
        Object r25 = r22[r24];     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");     // Catch: Throwable -> L51
        SnapshotKt.access$processForUnusedRecordsLocked((StateObject) r25);     // Catch: Throwable -> L51
        r24 = r24 + 1;     // Catch: Throwable -> L51
    L57:
        List<? extends StateObject> r26 = this.merged;     // Catch: Throwable -> L51
        if (r26 == null) goto L62;
        int r27 = r26.size();     // Catch: Throwable -> L51
    L60:
        if (r16 >= r27) goto L62;
        SnapshotKt.access$processForUnusedRecordsLocked(r26.get(r16));     // Catch: Throwable -> L51
        r16 = r16 + 1;     // Catch: Throwable -> L51
    L62:
        this.merged = null;     // Catch: Throwable -> L51
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r17);
        return SnapshotApplyResult.Success.INSTANCE;
    L51:
        th = move-exception;
        throw th;
    L39:
        if (r5.isEmpty() == true) goto L44;
        int r28 = r11.size();
        int r29 = 0;
    L42:
        if (r29 >= r28) goto L44;
        ((Function2) r11.get(r29)).mo2invoke(r5, this);
        r29 = r29 + 1;
        goto L42
    L32:
        if (r14.isEmpty() == true) goto L37;
        Intrinsics.checkNotNull(r14);
        int r30 = r11.size();
        int r31 = 0;
    L35:
        if (r31 >= r30) goto L37;
        ((Function2) r11.get(r31)).mo2invoke(r14, this);
        r31 = r31 + 1;
        goto L35
    L23:
        if (r14.isEmpty() == true) goto L26;
        r11 = CollectionsKt.toMutableList(SnapshotKt.access$getApplyObservers$p());     // Catch: Throwable -> L18
        goto L27
    L11:
        if (r5.size() == 0) goto L20;
        GlobalSnapshot r32 = (GlobalSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get();     // Catch: Throwable -> L18
        SnapshotApplyResult r33 = innerApplyLocked$runtime_release(SnapshotKt.access$getNextSnapshotId$p(), r10, SnapshotKt.access$getOpenSnapshots$p().clear(r32.getId()));     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r33, SnapshotApplyResult.Success.INSTANCE) == true) goto L17;
        monitor-exit(r12);
        return r33;
    L17:
        closeLocked$runtime_release();     // Catch: Throwable -> L18
        SnapshotKt.access$takeNewGlobalSnapshot(r32, SnapshotKt.access$getEmptyLambda$p());     // Catch: Throwable -> L18
        r14 = r32.getModified$runtime_release();     // Catch: Throwable -> L18
        setModified(null);     // Catch: Throwable -> L18
        r32.setModified(null);     // Catch: Throwable -> L18
        r11 = CollectionsKt.toMutableList(SnapshotKt.access$getApplyObservers$p());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(getId()).andNot(this.previousIds));
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release() == true) goto L6;
        super.dispose();
        mo44nestedDeactivated$runtime_release(this);
        return;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        IdentityArraySet<StateObject> r5 = getModified$runtime_release();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isNotEmpty() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int r18, Map<StateRecord, ? extends StateRecord> r19, SnapshotIdSet r20) {
        SnapshotIdSet r5 = r20;
        Intrinsics.checkNotNullParameter(r5, "invalidSnapshots");
        SnapshotIdSet r10 = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        IdentityArraySet<StateObject> r11 = getModified$runtime_release();
        Intrinsics.checkNotNull(r11);
        Object[] r12 = r11.getValues();
        int r13 = r11.size();
        ArrayList r14 = null;
        List<? extends StateObject> r15 = null;
        int r16 = 0;
    L3:
        if (r16 >= r13) goto L41;
        Object r17 = r12[r16];
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        StateObject r110 = (StateObject) r17;
        StateRecord r111 = r110.getFirstStateRecord();
        StateRecord r112 = SnapshotKt.access$readable(r111, r18, r5);
        if (r112 == null) goto L40;
        StateRecord r113 = SnapshotKt.access$readable(r111, getId(), r10);
        if (r113 == null) goto L40;
        if (Intrinsics.areEqual(r112, r113) == true) goto L40;
        StateRecord r21 = SnapshotKt.access$readable(r111, getId(), getInvalid$runtime_release());
        if (r21 == null) goto L38;
        if (r19 == null) goto L17;
        StateRecord r22 = r19.get(r112);
        if (r22 == null) goto L17;
    L18:
        if (r22 == null) goto L20;
        if (Intrinsics.areEqual(r22, r21) == true) goto L40;
        if (Intrinsics.areEqual(r22, r112) == false) goto L31;
        if (r14 != null) goto L27;
        r14 = new ArrayList();
    L27:
        r14.add(TuplesKt.to(r110, r112.create()));
        if (r15 != null) goto L30;
        r15 = new ArrayList();
    L30:
        r15.add(r110);
        goto L40
    L31:
        if (r14 != null) goto L34;
        r14 = new ArrayList();
    L34:
        if (Intrinsics.areEqual(r22, r113) == true) goto L36;
        Pair r23 = TuplesKt.to(r110, r22);
    L37:
        r14.add(r23);
        goto L40
    L36:
        r23 = TuplesKt.to(r110, r113.create());
        goto L37
    L20:
        return new SnapshotApplyResult.Failure(this);
    L17:
        r22 = r110.mergeRecords(r113, r112, r21);
        goto L18
    L38:
        SnapshotKt.access$readError();
        throw new KotlinNothingValueException();
    L40:
        r16 = r16 + 1;
        r5 = r20;
        goto L3
    L41:
        if (r14 == null) goto L52;
        advance$runtime_release();
        int r24 = r14.size();
        int r25 = 0;
    L43:
        if (r25 >= r24) goto L52;
        Pair r26 = (Pair) r14.get(r25);
        StateObject r27 = (StateObject) r26.component1();
        StateRecord r28 = (StateRecord) r26.component2();
        r28.setSnapshotId$runtime_release(getId());
        Object r29 = SnapshotKt.getLock();
        monitor-enter(r29);
        r28.setNext$runtime_release(r27.getFirstStateRecord());     // Catch: Throwable -> L49
        r27.prependStateRecord(r28);     // Catch: Throwable -> L49
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r29);
        r25 = r25 + 1;
    L49:
        th = move-exception;
        throw th;
    L52:
        if (r15 == null) goto L62;
        int r31 = r15.size();
        int r32 = 0;
    L54:
        if (r32 >= r31) goto L56;
        r11.remove(r15.get(r32));
        r32 = r32 + 1;
        goto L54
    L56:
        List<? extends StateObject> r33 = this.merged;
        if (r33 == null) goto L60;
        r15 = CollectionsKt.plus(r33, r15);
    L60:
        this.merged = r15;
    L62:
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public void mo43nestedActivated$runtime_release(Snapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public void mo44nestedDeactivated$runtime_release(Snapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        int r10 = this.snapshots;
        if (r10 <= 0) goto L11;
        int r11 = r10 - 1;
        this.snapshots = r11;
        if (r11 == 0) goto L7;
        return;
    L7:
        if (this.applied == true) goto L13;
        abandon();
        return;
    L13:
        return;
    L11:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied == false) goto L5;
        return;
    L5:
        if (getDisposed$runtime_release() == true) goto L10;
        advance$runtime_release();
        return;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo45recordModified$runtime_release(StateObject r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        IdentityArraySet<StateObject> r10 = getModified$runtime_release();
        if (r10 != null) goto L5;
        r10 = new IdentityArraySet();
        setModified(r10);
    L5:
        r10.add(r5);
    }

    public final void recordPrevious$runtime_release(int r5) {
        Object r10 = SnapshotKt.getLock();
        monitor-enter(r10);
        this.previousIds = this.previousIds.set(r5);     // Catch: Throwable -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshots");
        Object r10 = SnapshotKt.getLock();
        monitor-enter(r10);
        this.previousIds = this.previousIds.or(r5);     // Catch: Throwable -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int r5) {
        if (r5 < 0) goto L5;
        this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, r5);
        return;
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "handles");
        if (r5.length != 0) goto L5;
        return;
    L5:
        int[] r10 = this.previousPinnedSnapshots;
        if (r10.length == 0) goto L9;
        r5 = ArraysKt.plus(r10, r5);
    L9:
        this.previousPinnedSnapshots = r5;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void setApplied$runtime_release(boolean r5) {
        this.applied = r5;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> r5) {
        this.merged = r5;
    }

    public void setModified(IdentityArraySet<StateObject> r5) {
        this.modified = r5;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.previousIds = r5;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.previousPinnedSnapshots = r5;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int r5) {
        this.writeCount = r5;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> r10, Function1<Object, Unit> r11) {
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        Object r5 = SnapshotKt.getLock();
        monitor-enter(r5);
        int r12 = SnapshotKt.access$getNextSnapshotId$p();     // Catch: Throwable -> L19
        SnapshotKt.access$setNextSnapshotId$p(r12 + 1);     // Catch: Throwable -> L19
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(r12));     // Catch: Throwable -> L19
        SnapshotIdSet r13 = getInvalid$runtime_release();     // Catch: Throwable -> L19
        setInvalid$runtime_release(r13.set(r12));     // Catch: Throwable -> L19
        NestedMutableSnapshot r14 = new NestedMutableSnapshot(r12, SnapshotKt.addRange(r13, getId() + 1, r12), SnapshotKt.mergedReadObserver$default(r10, getReadObserver$runtime_release(), false, 4, null), SnapshotKt.access$mergedWriteObserver(r11, getWriteObserver$runtime_release()), this);     // Catch: Throwable -> L19
        monitor-exit(r5);
        if (getApplied$runtime_release() == false) goto L9;
    L18:
        return r14;
    L9:
        if (getDisposed$runtime_release() == true) goto L18;
        int r15 = getId();
        Object r16 = SnapshotKt.getLock();
        monitor-enter(r16);
        int r17 = SnapshotKt.access$getNextSnapshotId$p();     // Catch: Throwable -> L15
        SnapshotKt.access$setNextSnapshotId$p(r17 + 1);     // Catch: Throwable -> L15
        setId$runtime_release(r17);     // Catch: Throwable -> L15
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(getId()));     // Catch: Throwable -> L15
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r16);
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), r15 + 1, getId()));
    L15:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> r10) {
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int r5 = getId();
        recordPrevious$runtime_release(getId());
        Object r11 = SnapshotKt.getLock();
        monitor-enter(r11);
        int r12 = SnapshotKt.access$getNextSnapshotId$p();     // Catch: Throwable -> L19
        SnapshotKt.access$setNextSnapshotId$p(r12 + 1);     // Catch: Throwable -> L19
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(r12));     // Catch: Throwable -> L19
        NestedReadonlySnapshot r13 = new NestedReadonlySnapshot(r12, SnapshotKt.addRange(getInvalid$runtime_release(), r5 + 1, r12), r10, this);     // Catch: Throwable -> L19
        monitor-exit(r11);
        if (getApplied$runtime_release() == false) goto L9;
    L18:
        return r13;
    L9:
        if (getDisposed$runtime_release() == true) goto L18;
        int r14 = getId();
        Object r15 = SnapshotKt.getLock();
        monitor-enter(r15);
        int r16 = SnapshotKt.access$getNextSnapshotId$p();     // Catch: Throwable -> L15
        SnapshotKt.access$setNextSnapshotId$p(r16 + 1);     // Catch: Throwable -> L15
        setId$runtime_release(r16);     // Catch: Throwable -> L15
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(getId()));     // Catch: Throwable -> L15
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r15);
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), r14 + 1, getId()));
    L15:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit r5 = Unit.INSTANCE;
        if (getApplied$runtime_release() == false) goto L5;
        return;
    L5:
        if (getDisposed$runtime_release() == true) goto L17;
        int r10 = getId();
        Object r11 = SnapshotKt.getLock();
        monitor-enter(r11);
        int r12 = SnapshotKt.access$getNextSnapshotId$p();     // Catch: Throwable -> L11
        SnapshotKt.access$setNextSnapshotId$p(r12 + 1);     // Catch: Throwable -> L11
        setId$runtime_release(r12);     // Catch: Throwable -> L11
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(getId()));     // Catch: Throwable -> L11
        monitor-exit(r11);
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), r10 + 1, getId()));
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
