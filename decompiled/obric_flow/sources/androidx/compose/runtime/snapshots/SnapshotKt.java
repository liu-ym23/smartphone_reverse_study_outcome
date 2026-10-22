package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010)\u001a\u00020\bH\u0002\u001a6\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010,\u001a\b\u0010-\u001a\u00020\bH\u0002\u001a4\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u00101\u001a\u000202H\u0002\u001a\u001f\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*H\u0001¢\u0006\u0002\u00106\u001a'\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00108\u001a\b\u00109\u001a\u00020\u0007H\u0000\u001aL\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010<\u001a\u000202H\u0002\u001aB\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u0010?\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0016H\u0001\u001a.\u0010A\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000204\u0018\u00010B2\u0006\u00109\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0010H\u0002\u001a\u0010\u0010F\u001a\u0002022\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\u0010\u0010G\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\b\u0010H\u001a\u00020IH\u0002\u001a1\u0010J\u001a\u0004\u0018\u0001H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010L\u001a\u0010\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0001H\u0000\u001a\b\u0010O\u001a\u00020IH\u0002\u001a%\u0010P\u001a\u0002H*\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0QH\u0081\bø\u0001\u0000¢\u0006\u0002\u0010R\u001a>\u0010S\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010T\u001a\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010U\u001a:\u0010V\u001a\u0002H*\"\b\b\u0000\u0010**\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010W\u001a\u0018\u0010X\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010Y\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002042\u0006\u00107\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u00109\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010]\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0007H\u0002\u001a\u001c\u0010^\u001a\u00020\u0010*\u00020\u00102\u0006\u0010_\u001a\u00020\u00012\u0006\u0010`\u001a\u00020\u0001H\u0000\u001a!\u0010a\u001a\u000204*\u0002042\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002020\u000fH\u0082\b\u001a#\u0010c\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010d\u001a+\u0010e\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010f\u001a+\u0010g\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010f\u001aN\u0010h\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010j\u001a\u0002H*2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010l\u001a3\u0010m\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u0010j\u001a\u0002H*H\u0000¢\u0006\u0002\u0010n\u001a!\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016¢\u0006\u0002\u0010d\u001a)\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007¢\u0006\u0002\u0010f\u001aH\u0010o\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002Hi0\u000fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010p\u001aF\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010r\u001aN\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010s\u001a+\u0010t\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0018\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010#\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070(X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006u"}, d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "checkAndOverwriteUnusedRecordsLocked", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "overwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "usedLocked", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "findYoungestOr", "predicate", "newOverwritableRecordLocked", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecordLocked", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 5 SnapshotWeakSet.kt\nandroidx/compose/runtime/snapshots/SnapshotWeakSet\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2290:1\n1722#1:2291\n1722#1:2294\n1722#1:2296\n1722#1:2298\n1722#1:2306\n1722#1:2315\n2029#1,9:2317\n1722#1:2354\n1722#1:2356\n1722#1:2358\n1722#1:2361\n1722#1:2363\n1722#1:2372\n70#2:2292\n70#2:2293\n70#2:2295\n70#2:2297\n70#2:2299\n70#2:2307\n70#2:2316\n70#2:2355\n70#2:2357\n70#2:2359\n70#2:2362\n70#2:2364\n70#2:2373\n33#3,6:2300\n108#4,7:2308\n108#4,7:2365\n125#5,28:2326\n1#6:2360\n*S KotlinDebug\n*F\n+ 1 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n*L\n611#1:2291\n1782#1:2294\n1808#1:2296\n1822#1:2298\n1831#1:2306\n1901#1:2315\n2011#1:2317,9\n2084#1:2354\n2093#1:2356\n2161#1:2358\n2173#1:2361\n2201#1:2363\n2266#1:2372\n611#1:2292\n1722#1:2293\n1782#1:2295\n1808#1:2297\n1822#1:2299\n1831#1:2307\n1901#1:2316\n2084#1:2355\n2093#1:2357\n2161#1:2359\n2173#1:2362\n2201#1:2364\n2266#1:2373\n1823#1:2300,6\n1833#1:2308,7\n2224#1:2365,7\n2041#1:2326,28\n*E\n"})
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    private static final List<Function2<Set<? extends Object>, Snapshot, Unit>> applyObservers = null;
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot = null;
    private static final Function1<SnapshotIdSet, Unit> emptyLambda = null;
    private static final SnapshotWeakSet<StateObject> extraStateObjects = null;
    private static final List<Function1<Object, Unit>> globalWriteObservers = null;
    private static final Object lock = null;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable = null;
    private static final Snapshot snapshotInitializer = null;
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = null;

    static {
        emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
        threadSnapshot = new SnapshotThreadLocal();
        lock = new Object();
        SnapshotIdSet.Companion r5 = SnapshotIdSet.Companion;
        openSnapshots = r5.getEMPTY();
        nextSnapshotId = 1;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet();
        applyObservers = new ArrayList();
        globalWriteObservers = new ArrayList();
        int r10 = nextSnapshotId;
        nextSnapshotId = r10 + 1;
        GlobalSnapshot r11 = new GlobalSnapshot(r10, r5.getEMPTY());
        openSnapshots = openSnapshots.set(r11.getId());
        AtomicReference<GlobalSnapshot> r12 = new AtomicReference(r11);
        currentGlobalSnapshot = r12;
        snapshotInitializer = r12.get();
        pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final /* synthetic */ Object access$advanceGlobalSnapshot(Function1 r5) {
        return advanceGlobalSnapshot(r5);
    }

    public static final /* synthetic */ void access$checkAndOverwriteUnusedRecordsLocked() {
        checkAndOverwriteUnusedRecordsLocked();
    }

    public static final /* synthetic */ Snapshot access$createTransparentSnapshotWithNoParentReadObserver(Snapshot r5, Function1 r10, boolean r11) {
        return createTransparentSnapshotWithNoParentReadObserver(r5, r10, r11);
    }

    public static final /* synthetic */ List access$getApplyObservers$p() {
        return applyObservers;
    }

    public static final /* synthetic */ AtomicReference access$getCurrentGlobalSnapshot$p() {
        return currentGlobalSnapshot;
    }

    public static final /* synthetic */ Function1 access$getEmptyLambda$p() {
        return emptyLambda;
    }

    public static final /* synthetic */ List access$getGlobalWriteObservers$p() {
        return globalWriteObservers;
    }

    public static final /* synthetic */ int access$getNextSnapshotId$p() {
        return nextSnapshotId;
    }

    public static final /* synthetic */ SnapshotIdSet access$getOpenSnapshots$p() {
        return openSnapshots;
    }

    public static final /* synthetic */ AtomicInt access$getPendingApplyObserverCount$p() {
        return pendingApplyObserverCount;
    }

    public static final /* synthetic */ SnapshotThreadLocal access$getThreadSnapshot$p() {
        return threadSnapshot;
    }

    public static final /* synthetic */ Function1 access$mergedReadObserver(Function1 r5, Function1 r10, boolean r11) {
        return mergedReadObserver(r5, r10, r11);
    }

    public static final /* synthetic */ Function1 access$mergedWriteObserver(Function1 r5, Function1 r10) {
        return mergedWriteObserver(r5, r10);
    }

    public static final /* synthetic */ Map access$optimisticMerges(MutableSnapshot r5, MutableSnapshot r10, SnapshotIdSet r11) {
        return optimisticMerges(r5, r10, r11);
    }

    public static final /* synthetic */ void access$processForUnusedRecordsLocked(StateObject r5) {
        processForUnusedRecordsLocked(r5);
    }

    public static final /* synthetic */ Void access$readError() {
        return readError();
    }

    public static final /* synthetic */ StateRecord access$readable(StateRecord r5, int r10, SnapshotIdSet r11) {
        return readable(r5, r10, r11);
    }

    public static final /* synthetic */ Void access$reportReadonlySnapshotWrite() {
        return reportReadonlySnapshotWrite();
    }

    public static final /* synthetic */ void access$setNextSnapshotId$p(int r5) {
        nextSnapshotId = r5;
    }

    public static final /* synthetic */ void access$setOpenSnapshots$p(SnapshotIdSet r5) {
        openSnapshots = r5;
    }

    public static final /* synthetic */ Object access$takeNewGlobalSnapshot(Snapshot r5, Function1 r10) {
        return takeNewGlobalSnapshot(r5, r10);
    }

    public static final /* synthetic */ Snapshot access$takeNewSnapshot(Function1 r5) {
        return takeNewSnapshot(r5);
    }

    public static final /* synthetic */ void access$validateOpen(Snapshot r5) {
        validateOpen(r5);
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
    L3:
        if (r10 >= r11) goto L5;
        r5 = r5.set(r10);
        r10 = r10 + 1;
        goto L3
    L5:
        return r5;
    }

    private static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> r10) {
        Snapshot r5 = snapshotInitializer;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        GlobalSnapshot r11 = (GlobalSnapshot) r5;
        Object r12 = getLock();
        monitor-enter(r12);
        GlobalSnapshot r13 = currentGlobalSnapshot.get();     // Catch: Throwable -> L7
        IdentityArraySet<StateObject> r14 = r13.getModified$runtime_release();     // Catch: Throwable -> L7
        if (r14 == null) goto L9;
        pendingApplyObserverCount.add(1);     // Catch: Throwable -> L7
    L9:
        T r15 = (T) takeNewGlobalSnapshot(r13, r10);
        monitor-exit(r12);
        int r16 = 0;
        if (r14 != null) goto L46;
    L30:
        Object r17 = getLock();
        monitor-enter(r17);
        checkAndOverwriteUnusedRecordsLocked();     // Catch: Throwable -> L37
        if (r14 == null) goto L40;
        Object[] r18 = r14.getValues();     // Catch: Throwable -> L37
        int r19 = r14.size();     // Catch: Throwable -> L37
    L35:
        if (r16 >= r19) goto L39;
        Object r20 = r18[r16];     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");     // Catch: Throwable -> L37
        processForUnusedRecordsLocked((StateObject) r20);     // Catch: Throwable -> L37
        r16 = r16 + 1;     // Catch: Throwable -> L37
        goto L35
    L39:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L40:
        monitor-exit(r17);
        return r15;
    L37:
        th = move-exception;
        throw th;
    L46:
        Object r22 = getLock();     // Catch: Throwable -> L22
        monitor-enter(r22);     // Catch: Throwable -> L22
        List r23 = CollectionsKt.toMutableList(applyObservers);     // Catch: Throwable -> L25
        monitor-exit(r22);     // Catch: Throwable -> L22
        int r24 = r23.size();     // Catch: Throwable -> L22
        int r25 = 0;
    L19:
        if (r25 >= r24) goto L24;
        ((Function2) r23.get(r25)).mo2invoke(r14, r13);     // Catch: Throwable -> L22
        r25 = r25 + 1;
        goto L19
    L24:
        pendingApplyObserverCount.add(-1);
        goto L30
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        pendingApplyObserverCount.add(-1);
        throw th;
    L7:
        th = move-exception;
        throw th;
    }

    private static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> r5 = extraStateObjects;
        int r10 = r5.getSize$runtime_release();
        int r11 = 0;
        int r12 = 0;
    L3:
        StateObject r13 = null;
        if (r11 >= r10) goto L15;
        WeakReference<StateObject> r14 = r5.getValues$runtime_release()[r11];
        if (r14 == null) goto L8;
        r13 = r14.get();
    L8:
        if (r13 == null) goto L14;
        if (overwriteUnusedRecordsLocked(r13) == false) goto L14;
        if (r12 == r11) goto L13;
        r5.getValues$runtime_release()[r12] = r14;
        r5.getHashes$runtime_release()[r12] = r5.getHashes$runtime_release()[r11];
    L13:
        r12 = r12 + 1;
    L14:
        r11 = r11 + 1;
        goto L3
    L15:
        int r15 = r12;
    L16:
        if (r15 >= r10) goto L18;
        r5.getValues$runtime_release()[r15] = null;
        r5.getHashes$runtime_release()[r15] = 0;
        r15 = r15 + 1;
        goto L16
    L18:
        if (r12 == r10) goto L26;
        r5.setSize$runtime_release(r12);
        return;
    }

    private static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot r10, Function1<Object, Unit> r11, boolean r12) {
        boolean r5 = r10 instanceof MutableSnapshot;
        if (r5 == true) goto L8;
        if (r10 == null) goto L8;
        return new TransparentObserverSnapshot(r10, r11, false, r12);
    L8:
        if (r5 == false) goto L11;
        MutableSnapshot r13 = (MutableSnapshot) r10;
    L13:
        return new TransparentObserverMutableSnapshot(r13, r11, null, false, r12);
    L11:
        r13 = null;
        goto L13
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot r5, Function1 r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r11 = false;
    L9:
        return createTransparentSnapshotWithNoParentReadObserver(r5, r10, r11);
    }

    @PublishedApi
    public static final <T extends StateRecord> T current(T r5, Snapshot r10) {
        Intrinsics.checkNotNullParameter(r5, "r");
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        T r11 = (T) readable(r5, r10.getId(), r10.getInvalid$runtime_release());
        if (r11 == null) goto L5;
        return r11;
    L5:
        readError();
        throw new KotlinNothingValueException();
    }

    public static final Snapshot currentSnapshot() {
        Snapshot r5 = threadSnapshot.get();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return currentGlobalSnapshot.get();
    }

    private static final StateRecord findYoungestOr(StateRecord r5, Function1<? super StateRecord, Boolean> r10) {
        StateRecord r11 = r5;
    L3:
        if (r5 == null) goto L11;
        if (r10.invoke(r5).booleanValue() == true) goto L6;
        if (r11.getSnapshotId$runtime_release() >= r5.getSnapshotId$runtime_release()) goto L10;
        r11 = r5;
    L10:
        r5 = r5.getNext$runtime_release();
        goto L3
    L6:
        return r5;
    L11:
        return r11;
    }

    public static final Object getLock() {
        return lock;
    }

    @PublishedApi
    public static /* synthetic */ void getLock$annotations() {
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    @PublishedApi
    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    private static final Function1<Object, Unit> mergedReadObserver(final Function1<Object, Unit> r5, final Function1<Object, Unit> r10, boolean r11) {
        if (r11 == true) goto L5;
        r10 = null;
    L5:
        if (r5 == null) goto L10;
        if (r10 == null) goto L10;
        if (Intrinsics.areEqual(r5, r10) == true) goto L10;
        return new AnonymousClass1(r5, r10);
    L10:
        if (r5 == null) goto L12;
        return r5;
    L12:
        return r10;
    }

    public static /* synthetic */ Function1 mergedReadObserver$default(Function1 r5, Function1 r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = true;
    L6:
        return mergedReadObserver(r5, r10, r11);
    }

    private static final Function1<Object, Unit> mergedWriteObserver(final Function1<Object, Unit> r5, final Function1<Object, Unit> r10) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L7;
        if (Intrinsics.areEqual(r5, r10) == true) goto L7;
        return new C00681(r5, r10);
    L7:
        if (r5 == null) goto L9;
        return r5;
    L9:
        return r10;
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T r5, StateObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        T r11 = (T) usedLocked(r10);
        if (r11 == null) goto L5;
        r11.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        return r11;
    L5:
        T r12 = (T) r5.create();
        r12.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        r12.setNext$runtime_release(r10.getFirstStateRecord());
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$15");
        r10.prependStateRecord(r12);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return r12;
    }

    public static final <T extends StateRecord> T newWritableRecord(T r5, StateObject r10, Snapshot r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        Object r12 = getLock();
        monitor-enter(r12);
        T r13 = (T) newWritableRecordLocked(r5, r10, r11);
        monitor-exit(r12);
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T r5, StateObject r10, Snapshot r11) {
        T r12 = (T) newOverwritableRecordLocked(r5, r10);
        r12.assign(r5);
        r12.setSnapshotId$runtime_release(r11.getId());
        return r12;
    }

    @PublishedApi
    public static final void notifyWrite(Snapshot r5, StateObject r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        Intrinsics.checkNotNullParameter(r10, "state");
        r5.setWriteCount$runtime_release(r5.getWriteCount$runtime_release() + 1);
        Function1<Object, Unit> r11 = r5.getWriteObserver$runtime_release();
        if (r11 == null) goto L6;
        r11.invoke(r10);
        return;
    }

    private static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot r12, MutableSnapshot r13, SnapshotIdSet r14) {
        IdentityArraySet<StateObject> r5 = r13.getModified$runtime_release();
        int r15 = r12.getId();
        if (r5 != null) goto L5;
        return null;
    L5:
        SnapshotIdSet r10 = r13.getInvalid$runtime_release().set(r13.getId()).or(r13.getPreviousIds$runtime_release());
        Object[] r11 = r5.getValues();
        int r16 = r5.size();
        int r17 = 0;
        HashMap r18 = null;
    L6:
        if (r17 >= r16) goto L26;
        Object r19 = r11[r17];
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        StateObject r20 = (StateObject) r19;
        StateRecord r21 = r20.getFirstStateRecord();
        StateRecord r22 = readable(r21, r15, r14);
        if (r22 == null) goto L25;
        StateRecord r23 = readable(r21, r15, r10);
        if (r23 == null) goto L25;
        if (Intrinsics.areEqual(r22, r23) == true) goto L25;
        StateRecord r24 = readable(r21, r13.getId(), r13.getInvalid$runtime_release());
        if (r24 == null) goto L23;
        StateRecord r25 = r20.mergeRecords(r23, r22, r24);
        if (r25 == null) goto L22;
        if (r18 != null) goto L21;
        r18 = new HashMap();
    L21:
        r18.put(r22, r25);
        r18 = r18;
        goto L25
    L22:
        return null;
    L23:
        readError();
        throw new KotlinNothingValueException();
    L25:
        r17 = r17 + 1;
        goto L6
    L26:
        return r18;
    }

    public static final <T extends StateRecord, R> R overwritable(T r5, StateObject r10, T r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "candidate");
        Intrinsics.checkNotNullParameter(r12, "block");
        getSnapshotInitializer();
        Object r13 = getLock();
        monitor-enter(r13);
        Snapshot r14 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r15 = r12.invoke(overwritableRecord(r5, r10, r14, r11));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r13);
        InlineMarker.finallyEnd(1);
        notifyWrite(r14, r10);
        return r15;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T extends StateRecord> T overwritableRecord(T r5, StateObject r10, Snapshot r11, T r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        Intrinsics.checkNotNullParameter(r12, "candidate");
        if (r11.getReadOnly() == false) goto L5;
        r11.mo45recordModified$runtime_release(r10);
    L5:
        int r13 = r11.getId();
        if (r12.getSnapshotId$runtime_release() != r13) goto L8;
        return r12;
    L8:
        Object r14 = getLock();
        monitor-enter(r14);
        T r15 = (T) newOverwritableRecordLocked(r5, r10);
        monitor-exit(r14);
        r15.setSnapshotId$runtime_release(r13);
        r11.mo45recordModified$runtime_release(r10);
        return r15;
    L14:
        th = move-exception;
        throw th;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject r10) {
        StateRecord r5 = r10.getFirstStateRecord();
        int r11 = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord r12 = null;
        StateRecord r13 = null;
        int r14 = 0;
    L3:
        if (r5 == null) goto L28;
        int r15 = r5.getSnapshotId$runtime_release();
        if (r15 == 0) goto L26;
        if (r15 >= r11) goto L25;
        if (r12 != null) goto L10;
        r14 = r14 + 1;
        r12 = r5;
        goto L26
    L10:
        if (r5.getSnapshotId$runtime_release() >= r12.getSnapshotId$runtime_release()) goto L12;
        StateRecord r16 = r12;
        r12 = r5;
    L13:
        if (r13 != null) goto L24;
        r13 = r10.getFirstStateRecord();
        StateRecord r17 = r13;
    L15:
        if (r13 == null) goto L23;
        if (r13.getSnapshotId$runtime_release() >= r11) goto L24;
        if (r17.getSnapshotId$runtime_release() >= r13.getSnapshotId$runtime_release()) goto L22;
        r17 = r13;
    L22:
        r13 = r13.getNext$runtime_release();
        goto L15
    L23:
        r13 = r17;
    L24:
        r12.setSnapshotId$runtime_release(0);
        r12.assign(r13);
        r12 = r16;
        goto L26
    L12:
        r16 = r5;
        goto L13
    L25:
        r14 = r14 + 1;
    L26:
        r5 = r5.getNext$runtime_release();
        goto L3
    L28:
        if (r14 > 1) goto L30;
        return false;
    L30:
        return true;
    }

    private static final void processForUnusedRecordsLocked(StateObject r5) {
        if (overwriteUnusedRecordsLocked(r5) == false) goto L6;
        extraStateObjects.add(r5);
        return;
    }

    private static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    private static final <T extends StateRecord> T readable(T r5, int r10, SnapshotIdSet r11) {
        T r12 = null;
    L3:
        if (r5 == null) goto L12;
        if (valid(r5, r10, r11) == false) goto L11;
        if (r12 != null) goto L9;
    L10:
        r12 = r5;
        goto L11
    L9:
        if (r12.getSnapshotId$runtime_release() < r5.getSnapshotId$runtime_release()) goto L10;
    L11:
        r5 = (T) r5.getNext$runtime_release();
        goto L3
    L12:
        if (r12 == null) goto L14;
        return r12;
    L14:
        return null;
    }

    public static final void releasePinningLocked(int r5) {
        pinningTable.remove(r5);
    }

    private static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @PublishedApi
    public static final <T> T sync(Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Object r10 = getLock();
        monitor-enter(r10);
        T r11 = r5.invoke();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r10);
        InlineMarker.finallyEnd(1);
        return r11;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T> T takeNewGlobalSnapshot(Snapshot r5, Function1<? super SnapshotIdSet, ? extends T> r10) {
        T r11 = r10.invoke(openSnapshots.clear(r5.getId()));
        Object r12 = getLock();
        monitor-enter(r12);
        int r13 = nextSnapshotId;     // Catch: Throwable -> L7
        nextSnapshotId = r13 + 1;     // Catch: Throwable -> L7
        openSnapshots = openSnapshots.clear(r5.getId());     // Catch: Throwable -> L7
        currentGlobalSnapshot.set(new GlobalSnapshot(r13, openSnapshots));     // Catch: Throwable -> L7
        r5.dispose();     // Catch: Throwable -> L7
        openSnapshots = openSnapshots.set(r13);     // Catch: Throwable -> L7
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r12);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private static final <T extends Snapshot> T takeNewSnapshot(final Function1<? super SnapshotIdSet, ? extends T> r5) {
        return (T) advanceGlobalSnapshot(new C00691(r5));
    }

    public static final int trackPinning(int r5, SnapshotIdSet r10) {
        Intrinsics.checkNotNullParameter(r10, "invalid");
        int r11 = r10.lowest(r5);
        Object r12 = getLock();
        monitor-enter(r12);
        int r13 = pinningTable.add(r11);     // Catch: Throwable -> L7
        monitor-exit(r12);
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    private static final StateRecord usedLocked(StateObject r5) {
        StateRecord r10 = r5.getFirstStateRecord();
        int r11 = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet r12 = SnapshotIdSet.Companion.getEMPTY();
        StateRecord r13 = null;
    L3:
        if (r10 == null) goto L17;
        if (r10.getSnapshotId$runtime_release() == 0) goto L6;
        if (valid(r10, r11, r12) == false) goto L16;
        if (r13 != null) goto L12;
        r13 = r10;
        goto L16
    L12:
        if (r10.getSnapshotId$runtime_release() >= r13.getSnapshotId$runtime_release()) goto L15;
        return r10;
    L15:
        return r13;
    L16:
        r10 = r10.getNext$runtime_release();
        goto L3
    L6:
        return r10;
    L17:
        return null;
    }

    private static final boolean valid(int r5, int r10, SnapshotIdSet r11) {
        if (r10 == 0) goto L7;
        if (r10 > r5) goto L7;
        if (r11.get(r10) == true) goto L7;
        return true;
    L7:
        return false;
    }

    private static final void validateOpen(Snapshot r5) {
        if (openSnapshots.get(r5.getId()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Snapshot is not open");
    }

    public static final <T extends StateRecord, R> R withCurrent(T r5, Function1<? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "block");
        return r10.invoke(current(r5));
    }

    public static final <T extends StateRecord, R> R writable(T r5, StateObject r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "block");
        getSnapshotInitializer();
        Object r12 = getLock();
        monitor-enter(r12);
        Snapshot r13 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r14 = r11.invoke(writableRecord(r5, r10, r13));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r12);
        InlineMarker.finallyEnd(1);
        notifyWrite(r13, r10);
        return r14;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @PublishedApi
    public static final <T extends StateRecord> T writableRecord(T r5, StateObject r10, Snapshot r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        if (r11.getReadOnly() == false) goto L5;
        r11.mo45recordModified$runtime_release(r10);
    L5:
        T r12 = (T) readable(r5, r11.getId(), r11.getInvalid$runtime_release());
        if (r12 != null) goto L8;
        readError();
        throw new KotlinNothingValueException();
    L8:
        if (r12.getSnapshotId$runtime_release() != r11.getId()) goto L10;
        return r12;
    L10:
        T r13 = (T) newWritableRecord(r12, r10, r11);
        r11.mo45recordModified$runtime_release(r10);
        return r13;
    }

    public static final /* synthetic */ void access$advanceGlobalSnapshot() {
        advanceGlobalSnapshot();
    }

    @PublishedApi
    public static final <T extends StateRecord> T current(T r5) {
        Intrinsics.checkNotNullParameter(r5, "r");
        Snapshot.Companion r10 = Snapshot.Companion;
        Snapshot r11 = r10.getCurrent();
        T r12 = (T) readable(r5, r11.getId(), r11.getInvalid$runtime_release());
        if (r12 != null) goto L15;
        Object r13 = getLock();
        monitor-enter(r13);
        Snapshot r14 = r10.getCurrent();     // Catch: Throwable -> L12
        T r15 = (T) readable(r5, r14.getId(), r14.getInvalid$runtime_release());
        monitor-exit(r13);
        if (r15 != null) goto L18;
        readError();
        throw new KotlinNothingValueException();
    L18:
        return r15;
    L12:
        th = move-exception;
        throw th;
    L15:
        return r12;
    }

    private static final boolean valid(StateRecord r5, int r10, SnapshotIdSet r11) {
        return valid(r10, r5.getSnapshotId$runtime_release(), r11);
    }

    public static final <T extends StateRecord> T readable(T r5, StateObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Snapshot.Companion r11 = Snapshot.Companion;
        Snapshot r12 = r11.getCurrent();
        Function1<Object, Unit> r13 = r12.getReadObserver$runtime_release();
        if (r13 == null) goto L5;
        r13.invoke(r10);
    L5:
        T r14 = (T) readable(r5, r12.getId(), r12.getInvalid$runtime_release());
        if (r14 != null) goto L18;
        Object r15 = getLock();
        monitor-enter(r15);
        Snapshot r16 = r11.getCurrent();     // Catch: Throwable -> L15
        StateRecord r17 = r10.getFirstStateRecord();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");     // Catch: Throwable -> L15
        T r18 = (T) readable(r17, r16.getId(), r16.getInvalid$runtime_release());
        if (r18 == null) goto L13;
        monitor-exit(r15);
        return r18;
    L13:
        readError();     // Catch: Throwable -> L15
        throw new KotlinNothingValueException();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return r14;
    }

    public static final <T extends StateRecord, R> R writable(T r5, StateObject r10, Snapshot r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        Intrinsics.checkNotNullParameter(r12, "block");
        Object r13 = getLock();
        monitor-enter(r13);
        R r14 = r12.invoke(writableRecord(r5, r10, r11));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r13);
        InlineMarker.finallyEnd(1);
        notifyWrite(r11, r10);
        return r14;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T extends StateRecord> T readable(T r5, StateObject r10, Snapshot r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        Function1<Object, Unit> r12 = r11.getReadObserver$runtime_release();
        if (r12 == null) goto L5;
        r12.invoke(r10);
    L5:
        T r13 = (T) readable(r5, r11.getId(), r11.getInvalid$runtime_release());
        if (r13 == null) goto L8;
        return r13;
    L8:
        readError();
        throw new KotlinNothingValueException();
    }

    private static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(AnonymousClass3.INSTANCE);
    }
}
