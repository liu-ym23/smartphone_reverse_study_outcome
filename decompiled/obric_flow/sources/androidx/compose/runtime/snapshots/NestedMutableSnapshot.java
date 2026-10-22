package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/NestedMutableSnapshot\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2290:1\n1722#2:2291\n70#3:2292\n1#4:2293\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/NestedMutableSnapshot\n*L\n1420#1:2291\n1420#1:2292\n*E\n"})
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;
    private final MutableSnapshot parent;

    public NestedMutableSnapshot(int r5, SnapshotIdSet r10, Function1<Object, Unit> r11, Function1<Object, Unit> r12, MutableSnapshot r13) {
        Intrinsics.checkNotNullParameter(r10, "invalid");
        Intrinsics.checkNotNullParameter(r13, "parent");
        super(r5, r10, r11, r12);
        this.parent = r13;
        r13.mo43nestedActivated$runtime_release(this);
    }

    private final void deactivate() {
        if (this.deactivated == true) goto L6;
        this.deactivated = true;
        this.parent.mo44nestedDeactivated$runtime_release(this);
        return;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult apply() {
        if (this.parent.getApplied$runtime_release() == true) goto L39;
        if (this.parent.getDisposed$runtime_release() == true) goto L39;
        IdentityArraySet<StateObject> r5 = getModified$runtime_release();
        int r10 = getId();
        if (r5 == null) goto L10;
        MutableSnapshot r11 = this.parent;
        Map<StateRecord, ? extends StateRecord> r12 = SnapshotKt.access$optimisticMerges(r11, this, r11.getInvalid$runtime_release());
    L11:
        Object r13 = SnapshotKt.getLock();
        monitor-enter(r13);
        SnapshotKt.access$validateOpen(this);     // Catch: Throwable -> L25
        if (r5 != null) goto L16;
    L28:
        closeAndReleasePinning$runtime_release();     // Catch: Throwable -> L25
    L30:
        if (this.parent.getId() >= r10) goto L32;
        this.parent.advance$runtime_release();     // Catch: Throwable -> L25
    L32:
        MutableSnapshot r14 = this.parent;     // Catch: Throwable -> L25
        r14.setInvalid$runtime_release(r14.getInvalid$runtime_release().clear(r10).andNot(getPreviousIds$runtime_release()));     // Catch: Throwable -> L25
        this.parent.recordPrevious$runtime_release(r10);     // Catch: Throwable -> L25
        this.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());     // Catch: Throwable -> L25
        this.parent.recordPreviousList$runtime_release(getPreviousIds$runtime_release());     // Catch: Throwable -> L25
        this.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots$runtime_release());     // Catch: Throwable -> L25
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r13);
        setApplied$runtime_release(true);
        deactivate();
        return SnapshotApplyResult.Success.INSTANCE;
    L16:
        if (r5.size() == 0) goto L28;
        SnapshotApplyResult r16 = innerApplyLocked$runtime_release(this.parent.getId(), r12, this.parent.getInvalid$runtime_release());     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r16, SnapshotApplyResult.Success.INSTANCE) == true) goto L22;
        monitor-exit(r13);
        return r16;
    L22:
        IdentityArraySet<StateObject> r17 = this.parent.getModified$runtime_release();     // Catch: Throwable -> L25
        if (r17 == null) goto L27;
        r17.addAll(r5);     // Catch: Throwable -> L25
        goto L30
    L27:
        this.parent.setModified(r5);     // Catch: Throwable -> L25
        setModified(null);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L10:
        r12 = null;
    L39:
        return new SnapshotApplyResult.Failure(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release() == true) goto L6;
        super.dispose();
        deactivate();
        return;
    }

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }
}
