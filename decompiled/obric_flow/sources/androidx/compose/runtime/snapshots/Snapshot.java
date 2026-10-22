package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 S2\u00020\u0001:\u0001SB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u00100\u001a\u00020\"H\u0000¢\u0006\u0002\b1J\r\u00102\u001a\u00020\"H\u0010¢\u0006\u0002\b3J\b\u00104\u001a\u00020\"H\u0016J%\u00105\u001a\u0002H6\"\u0004\b\u0000\u001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H608H\u0086\bø\u0001\u0000¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\bH&J\n\u0010;\u001a\u0004\u0018\u00010\u0000H\u0011J\u0015\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0000H ¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0000H ¢\u0006\u0002\b@J\r\u0010A\u001a\u00020\"H ¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u001aH ¢\u0006\u0002\bEJ\r\u0010F\u001a\u00020\"H\u0000¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020\"H\u0010¢\u0006\u0002\bIJ\u0012\u0010J\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u0000H\u0011J \u0010K\u001a\u00020\u00002\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J\r\u0010L\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ\n\u0010N\u001a\u0004\u0018\u00010\u0000H\u0007J\u0012\u0010O\u001a\u00020\"2\b\u0010P\u001a\u0004\u0018\u00010\u0000H\u0007J\r\u0010Q\u001a\u00020\"H\u0000¢\u0006\u0002\bRR\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u00020\b8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!X \u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0012\u0010'\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00038P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R \u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!X \u0004¢\u0006\u0006\u001a\u0004\b/\u0010$\u0082\u0001\u0004TUVW\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006X"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "disposed", "", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "<set-?>", "getId", "()I", "setId$runtime_release", "(I)V", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "isPinned", "isPinned$runtime_release", "modified", "Landroidx/compose/runtime/collection/IdentityArraySet;", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "()V", "readObserver", "Lkotlin/Function1;", "", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "writeCount", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "closeAndReleasePinning", "closeAndReleasePinning$runtime_release", "closeLocked", "closeLocked$runtime_release", "dispose", "enter", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasPendingChanges", "makeCurrent", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "restoreCurrent", "takeNestedSnapshot", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime_release", "unsafeEnter", "unsafeLeave", "oldSnapshot", "validateNotDisposed", "validateNotDisposed$runtime_release", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2290:1\n1722#2:2291\n1722#2:2293\n70#3:2292\n70#3:2294\n1#4:2295\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n*L\n91#1:2291\n241#1:2293\n91#1:2292\n241#1:2294\n*E\n"})
public abstract class Snapshot {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private boolean disposed;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f428id;
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0001J%\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011JO\u0010\u0012\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0007J&\u0010\u0019\u001a\u00020\u001a2\u001e\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u001cJ\u001a\u0010\u001e\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0014J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0001J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0001J\u0006\u0010\"\u001a\u00020\u0011J6\u0010#\u001a\u00020$2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J\u001e\u0010%\u001a\u00020\u00042\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J%\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H'0\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000fJ7\u0010(\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u0002H\f0\u000e¢\u0006\u0002\b)H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "()V", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "isApplyObserverNotificationPending", "", "()Z", "createNonObservableSnapshot", "global", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "notifyObjectsInitialized", "", "observe", "readObserver", "Lkotlin/Function1;", "writeObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshotCount", "", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observer", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "removeCurrent", "restoreCurrent", "previous", "sendApplyNotifications", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeSnapshot", "withMutableSnapshot", "R", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 4 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 5 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,2290:1\n1#2:2291\n129#3,5:2292\n129#3,5:2297\n129#3,5:2302\n1722#4:2307\n1722#4:2309\n1722#4:2311\n70#5:2308\n70#5:2310\n70#5:2312\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n*L\n439#1:2292,5\n476#1:2297,5\n498#1:2302,5\n514#1:2307\n541#1:2309\n579#1:2311\n514#1:2308\n541#1:2310\n579#1:2312\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object observe$default(Companion r5, Function1 r10, Function1 r11, Function0 r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = null;
        L9:
            return r5.observe(r10, r11, r12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion r5, Function1 r10, Function1 r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = null;
        L9:
            return r5.takeMutableSnapshot(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Snapshot takeSnapshot$default(Companion r5, Function1 r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = null;
        L6:
            return r5.takeSnapshot(r10);
        }

        @PublishedApi
        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.access$getThreadSnapshot$p().get(), null, false, 6, null);
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final <T> T global(Function0<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "block");
            Snapshot r10 = removeCurrent();
            T r11 = r5.invoke();
            Snapshot.Companion.restoreCurrent(r10);
            return r11;
        }

        public final boolean isApplyObserverNotificationPending() {
            if (SnapshotKt.access$getPendingApplyObserverCount$p().get() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(Function1<Object, Unit> r10, Function1<Object, Unit> r11, Function0<? extends T> r12) {
            Intrinsics.checkNotNullParameter(r12, "block");
            if (r10 != null) goto L8;
            if (r11 != null) goto L8;
            return r12.invoke();
        L8:
            Snapshot r13 = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
            if (r13 == null) goto L18;
            if ((r13 instanceof MutableSnapshot) == true) goto L18;
            if (r10 == null) goto L15;
            Snapshot r14 = r13.takeNestedSnapshot(r10);
        L35:
            Snapshot r15 = r14.makeCurrent();     // Catch: Throwable -> L28
            T r16 = r12.invoke();     // Catch: Throwable -> L30
            r14.restoreCurrent(r15);     // Catch: Throwable -> L28
            r14.dispose();
            return r16;
        L30:
            th = move-exception;
            r14.restoreCurrent(r15);     // Catch: Throwable -> L28
            throw th;     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            r14.dispose();
            throw th;
        L15:
            return r12.invoke();
        L18:
            if ((r13 instanceof MutableSnapshot) == false) goto L21;
            MutableSnapshot r17 = (MutableSnapshot) r13;
        L22:
            r14 = new TransparentObserverMutableSnapshot(r17, r10, r11, true, false);
            goto L35
        L21:
            r17 = null;
            goto L22
        }

        @InternalComposeApi
        public final int openSnapshotCount() {
            return CollectionsKt.toList(SnapshotKt.access$getOpenSnapshots$p()).size();
        }

        public final ObserverHandle registerApplyObserver(final Function2<? super Set<? extends Object>, ? super Snapshot, Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "observer");
            SnapshotKt.access$advanceGlobalSnapshot(SnapshotKt.access$getEmptyLambda$p());
            Object r10 = SnapshotKt.getLock();
            monitor-enter(r10);
            SnapshotKt.access$getApplyObservers$p().add(r5);     // Catch: Throwable -> L8
            monitor-exit(r10);
            return new Snapshot$Companion$registerApplyObserver$2(r5);
        L8:
            th = move-exception;
            throw th;
        }

        public final ObserverHandle registerGlobalWriteObserver(final Function1<Object, Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "observer");
            Object r10 = SnapshotKt.getLock();
            monitor-enter(r10);
            SnapshotKt.access$getGlobalWriteObservers$p().add(r5);     // Catch: Throwable -> L8
            monitor-exit(r10);
            SnapshotKt.access$advanceGlobalSnapshot();
            return new Snapshot$Companion$registerGlobalWriteObserver$2(r5);
        L8:
            th = move-exception;
            throw th;
        }

        @PublishedApi
        public final Snapshot removeCurrent() {
            Snapshot r5 = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
            if (r5 == null) goto L5;
            SnapshotKt.access$getThreadSnapshot$p().set(null);
        L5:
            return r5;
        }

        @PublishedApi
        public final void restoreCurrent(Snapshot r5) {
            if (r5 == null) goto L5;
            SnapshotKt.access$getThreadSnapshot$p().set(r5);
            return;
        }

        public final void sendApplyNotifications() {
            Object r5 = SnapshotKt.getLock();
            monitor-enter(r5);
            IdentityArraySet<StateObject> r10 = ((GlobalSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get()).getModified$runtime_release();     // Catch: Throwable -> L10
            boolean r11 = false;
            if (r10 == null) goto L12;
            if (r10.isNotEmpty() != true) goto L12;
            r11 = true;
        L12:
            monitor-exit(r5);
            if (r11 == false) goto L20;
            SnapshotKt.access$advanceGlobalSnapshot();
            return;
        L20:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final MutableSnapshot takeMutableSnapshot(Function1<Object, Unit> r5, Function1<Object, Unit> r10) {
            Snapshot r11 = SnapshotKt.currentSnapshot();
            if ((r11 instanceof MutableSnapshot) == false) goto L5;
            MutableSnapshot r12 = (MutableSnapshot) r11;
        L6:
            if (r12 == null) goto L11;
            MutableSnapshot r13 = r12.takeNestedMutableSnapshot(r5, r10);
            if (r13 == null) goto L11;
            return r13;
        L11:
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
        L5:
            r12 = null;
            goto L6
        }

        public final Snapshot takeSnapshot(Function1<Object, Unit> r5) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(r5);
        }

        public final <R> R withMutableSnapshot(Function0<? extends R> r5) {
            Intrinsics.checkNotNullParameter(r5, "block");
            MutableSnapshot r10 = takeMutableSnapshot$default(this, null, null, 3, null);
            Snapshot r11 = r10.makeCurrent();     // Catch: Throwable -> L8
            R r12 = r5.invoke();     // Catch: Throwable -> L10
            InlineMarker.finallyStart(1);     // Catch: Throwable -> L8
            r10.restoreCurrent(r11);     // Catch: Throwable -> L8
            InlineMarker.finallyEnd(1);     // Catch: Throwable -> L8
            r10.apply().check();     // Catch: Throwable -> L8
            InlineMarker.finallyStart(1);
            r10.dispose();
            InlineMarker.finallyEnd(1);
            return r12;
        L10:
            th = move-exception;
            InlineMarker.finallyStart(1);     // Catch: Throwable -> L8
            r10.restoreCurrent(r11);     // Catch: Throwable -> L8
            InlineMarker.finallyEnd(1);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            InlineMarker.finallyStart(1);
            r10.dispose();
            InlineMarker.finallyEnd(1);
            throw th;
        }

        public final <T> T withoutReadObservation(Function0<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "block");
            Snapshot r10 = createNonObservableSnapshot();
            Snapshot r11 = r10.makeCurrent();     // Catch: Throwable -> L8
            T r12 = r5.invoke();     // Catch: Throwable -> L10
            InlineMarker.finallyStart(1);     // Catch: Throwable -> L8
            r10.restoreCurrent(r11);     // Catch: Throwable -> L8
            InlineMarker.finallyEnd(1);     // Catch: Throwable -> L8
            InlineMarker.finallyStart(1);
            r10.dispose();
            InlineMarker.finallyEnd(1);
            return r12;
        L10:
            th = move-exception;
            InlineMarker.finallyStart(1);     // Catch: Throwable -> L8
            r10.restoreCurrent(r11);     // Catch: Throwable -> L8
            InlineMarker.finallyEnd(1);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            InlineMarker.finallyStart(1);
            r10.dispose();
            InlineMarker.finallyEnd(1);
            throw th;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public /* synthetic */ Snapshot(int r5, SnapshotIdSet r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ int access$getPinningTrackingHandle$p(Snapshot r5) {
        return r5.pinningTrackingHandle;
    }

    private static /* synthetic */ void getPinningTrackingHandle$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot r5, Function1 r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 1) == 0) goto L7;
        r10 = null;
    L7:
        return r5.takeNestedSnapshot(r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
    }

    public final void closeAndReleasePinning$runtime_release() {
        Object r5 = SnapshotKt.getLock();
        monitor-enter(r5);
        closeLocked$runtime_release();     // Catch: Throwable -> L7
        releasePinnedSnapshotsForCloseLocked$runtime_release();     // Catch: Throwable -> L7
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(getId()));
    }

    public void dispose() {
        this.disposed = true;
        Object r5 = SnapshotKt.getLock();
        monitor-enter(r5);
        releasePinnedSnapshotLocked$runtime_release();     // Catch: Throwable -> L7
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final <T> T enter(Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Snapshot r10 = makeCurrent();
        T r11 = r5.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        restoreCurrent(r10);
        InlineMarker.finallyEnd(1);
        return r11;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        restoreCurrent(r10);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final boolean getDisposed$runtime_release() {
        return this.disposed;
    }

    public int getId() {
        return this.f428id;
    }

    public SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    public abstract IdentityArraySet<StateObject> getModified$runtime_release();

    public abstract Function1<Object, Unit> getReadObserver$runtime_release();

    public abstract boolean getReadOnly();

    public abstract Snapshot getRoot();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime_release() {
        if (access$getPinningTrackingHandle$p(this) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @PublishedApi
    public Snapshot makeCurrent() {
        Snapshot r5 = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
        SnapshotKt.access$getThreadSnapshot$p().set(this);
        return r5;
    }

    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public abstract void mo43nestedActivated$runtime_release(Snapshot r5);

    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public abstract void mo44nestedDeactivated$runtime_release(Snapshot r5);

    public abstract void notifyObjectsInitialized$runtime_release();

    /* JADX INFO: renamed from: recordModified$runtime_release */
    public abstract void mo45recordModified$runtime_release(StateObject r5);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int r5 = this.pinningTrackingHandle;
        if (r5 < 0) goto L6;
        SnapshotKt.releasePinningLocked(r5);
        this.pinningTrackingHandle = -1;
        return;
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    @PublishedApi
    public void restoreCurrent(Snapshot r5) {
        SnapshotKt.access$getThreadSnapshot$p().set(r5);
    }

    public final void setDisposed$runtime_release(boolean r5) {
        this.disposed = r5;
    }

    public void setId$runtime_release(int r5) {
        this.f428id = r5;
    }

    public void setInvalid$runtime_release(SnapshotIdSet r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.invalid = r5;
    }

    public void setWriteCount$runtime_release(int r5) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract Snapshot takeNestedSnapshot(Function1<Object, Unit> r5);

    public final int takeoverPinnedSnapshot$runtime_release() {
        int r5 = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return r5;
    }

    @ExperimentalComposeApi
    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    @ExperimentalComposeApi
    public final void unsafeLeave(Snapshot r5) {
        if (SnapshotKt.access$getThreadSnapshot$p().get() != this) goto L7;
        restoreCurrent(r5);
        return;
    L7:
        throw new IllegalStateException(("Cannot leave snapshot; " + this + " is not the current snapshot").toString());
    }

    public final void validateNotDisposed$runtime_release() {
        if (this.disposed == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Cannot use a disposed snapshot");
    }

    private Snapshot(int r5, SnapshotIdSet r10) {
        this.invalid = r10;
        this.f428id = r5;
        if (r5 == 0) goto L5;
        int r11 = SnapshotKt.trackPinning(r5, getInvalid$runtime_release());
    L6:
        this.pinningTrackingHandle = r11;
        return;
    L5:
        r11 = -1;
        goto L6
    }
}
